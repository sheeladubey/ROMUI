package com.gsicommerce.romui.selenium.utilities;

import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.ElementPresent;

public class Action {

	// DELAY is a value which will be used in waitForElement method and can be
	// increased if the environment is slow.
	private static final Integer DELAY = 3;
	private static final String GENERAL_ERROR = "/waroot/system_branding.gif";
	public static WebDriver driver;
	public Environment env;
	protected Integer WAIT_PERIOD;
	protected static String REPORT_DIRECTORY;
	protected static String DOMAIN;
	protected static boolean EXPLICIT_WAIT = false;
	private Action actions;
	public static final int DEFAULT_WAIT_4_PAGE = 12;

	public Action(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		this.WAIT_PERIOD = env.getWaitPeriod();
		// REPORT_DIRECTORY = env.ReportDirectory();
		// DOMAIN = env.getDomain();
	}

	public void enableExplicitWait() {
		if (!EXPLICIT_WAIT) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			EXPLICIT_WAIT = true;
		}
	}

	public void enableImplicitWait() {
		if (EXPLICIT_WAIT) {
			driver.manage().timeouts().implicitlyWait(WAIT_PERIOD, TimeUnit.SECONDS);
			EXPLICIT_WAIT = false;
		}
	}

	/**
	 * This is a protected method which waits for the webelement to appear on the
	 * page and returns the webelement object. This method will be used by
	 * webelement class constructor.
	 * 
	 * @param driver
	 * @param element
	 * @param sec     - Waiting period for webelement. it is in seconds.
	 * @return WebElement
	 */
	private WebElement waitForElement(final By element, final int sec) {
		final Wait<WebDriver> wait = new WebDriverWait(driver, DELAY * sec);
		final ExpectedCondition<WebElement> condition = new ElementPresent(element);
		;
		try {
			final WebElement we = wait.until(condition);
			return we;
		} catch (final WebDriverException e) {
			return null;
		}
	}

	/**
	 * find a web element by chaining the list of locators together. ex:
	 * findElement(By.id("main_content"), By.linkText("Storefront"))
	 * 
	 * @param locators
	 * @return
	 */
	public GsiWebElement findElement(final By... locators) {
		return findElement(EXPLICIT_WAIT, locators);

	}

	public GsiWebElement findElement(final boolean wait, final By... locators) {
		if (locators.length < 1) {
			throw new IllegalArgumentException("at least one locator must be provided");
		}

		WebElement element;
		if (wait) {
			element = waitForElement(locators[0], this.WAIT_PERIOD);
		} else {
			try {
				element = driver.findElement(locators[0]);
			} catch (final WebDriverException e) {
				element = null;
			}
		}

		if (element == null) {
			if (verifyTextPresentIn(GENERAL_ERROR)) {
				fail("APPLICATION CRASHED. TEST FAILED.");
			}
		}

		// walk the chain of By locators
		for (int i = 1; i < locators.length; i++) {
			element = wrapElement(element, (String) null).findElement(locators[i]);
		}

		return wrapElement(element, locators[locators.length - 1]);
	}

	protected Webtable_Old findWebTable(final By locator, final WebDriver driver, final Environment env) {
		return new Webtable_Old(findElement(locator), driver, env);
	}

	public List<GsiWebElement> findElements(final By locator) {
		return findElements(EXPLICIT_WAIT, locator);
	}

	/**
	 * This findElements is a wrapper for webdriver FindElements method and uses
	 * wait
	 * 
	 * @param wait
	 * @param locator
	 * @return
	 */
	protected List<GsiWebElement> findElements(final boolean wait, final By locator) {

		if (wait) {
			waitForElement(locator, this.WAIT_PERIOD);
		}

		final List<GsiWebElement> list = new ArrayList<GsiWebElement>();

		final List<WebElement> elements = driver.findElements(locator);
		if (elements == null) {
			if (verifyTextPresentIn(GENERAL_ERROR)) {
				fail("APPLICATION CRASHED. TEST FAILED.");
			}

			return list;
		}

		for (final WebElement element : elements) {
			list.add(wrapElement(element, locator));
		}

		return list;
	}

	protected void enableWait() {
		driver.manage().timeouts().implicitlyWait(WAIT_PERIOD, TimeUnit.SECONDS);
	}

	protected void disableWait() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	protected GsiWebElement wrapElement(final WebElement element, final By locator) {
		return new AssertingWebElement(element, locator);
	}

	protected WebElement wrapElement(final WebElement element, final String locator) {
		return new AssertingWebElement(element, locator);
	}

	/**
	 * This method will search the page for a webtable which has a column header
	 * provided and return the webtable object.
	 * 
	 * @param driver
	 * @param columnHeader
	 * @return Webtable object
	 */
	protected Webtable_Old findWebTable(final String columnHeader) {
		enableExplicitWait();
		try {
			for (int i = 0; i < 2; i++) {

				for (final WebElement webtable : findElements(By.tagName("table"))) {
					final List<WebElement> headerColumns = new ArrayList<WebElement>();
					try {
						headerColumns.addAll(webtable.findElements(By.xpath("thead/tr/th")));
					} catch (final NoSuchElementException ignored) {
						// roll on!
					}

					headerColumns.addAll(webtable.findElements(By.xpath("tbody/tr/td")));
					headerColumns.addAll(webtable.findElements(By.xpath("tbody/tr/th")));

					for (final WebElement headerColumn : headerColumns) {
						if (headerColumn.getText().equalsIgnoreCase(columnHeader)) {
							return new Webtable_Old(new AssertingWebElement(webtable), driver, env);
						}
					}
				}

				// Common.sleepFor(DELAY * 5000);
			}
			return new Webtable_Old(null, driver, env);
		} finally {
			enableImplicitWait();
		}
	}

	/**
	 * This method will search the page for a webtable which has a column header
	 * provided and return the webtable object. This method should be used if you
	 * have more than one webtable using same column headers. Use index parameter to
	 * specify which one you want.
	 * 
	 * @param driver
	 * @param columnHeader
	 * @index integer which decides which webtable
	 * @return Webtable object
	 */
	protected Webtable_Old findWebTable(final String columnHeader, final int index) {

		enableExplicitWait();
		try {
			final List<Webtable_Old> matchingWebtables = new ArrayList<Webtable_Old>();
			final List<GsiWebElement> webtables = findElements(By.tagName("table"));

			for (final GsiWebElement webtable : webtables) {
				final List<WebElement> headerColumns = new ArrayList<WebElement>();
				try {
					headerColumns.addAll(webtable.findElements(By.xpath("thead/tr/th")));
				} catch (final NoSuchElementException ignored) {
					// roll on!
				}
				headerColumns.addAll(webtable.findElements(By.xpath("tbody/tr/td")));
				headerColumns.addAll(webtable.findElements(By.xpath("tbody/tr/th")));

				for (final WebElement headerColumn : headerColumns) {
					if (headerColumn.getText().equalsIgnoreCase(columnHeader)) {
						final Webtable_Old wt = new Webtable_Old(webtable, driver, env);
						matchingWebtables.add(wt);
						break;
					}
				}
			}

			if (index >= matchingWebtables.size()) {
				fail("Search for Table Failed. No table found with specified column header.");
				return null;
			}
			return matchingWebtables.get(index);
		} finally {
			enableImplicitWait();
		}
	}

	/**
	 * This method will search the page for a webtable which has a column header
	 * provided and return the collection of webtable objects. This method should be
	 * used if you have more than one webtable using same column headers.
	 * 
	 * @param driver
	 * @param columnHeader
	 * 
	 * @return List<Webtable> object
	 */
	protected List<Webtable_Old> findWebTables(final String columnHeader) {

		enableExplicitWait();
		try {
			final List<Webtable_Old> matchingWebtables = new ArrayList<Webtable_Old>();
			final List<GsiWebElement> webtables = findElements(By.tagName("table"));

			for (final GsiWebElement webtable : webtables) {
				final List<WebElement> headerColumns = new ArrayList<WebElement>();
				try {
					headerColumns.addAll(webtable.findElements(By.xpath("thead/tr/th")));
				} catch (final NoSuchElementException ignored) {
					// roll on!
				}
				headerColumns.addAll(webtable.findElements(By.xpath("tbody/tr/td")));
				headerColumns.addAll(webtable.findElements(By.xpath("tbody/tr/th")));

				for (final WebElement headerColumn : headerColumns) {
					if (headerColumn.getText().equalsIgnoreCase(columnHeader)) {
						final Webtable_Old wt = new Webtable_Old(webtable, driver, env);
						matchingWebtables.add(wt);
						break;
					}
				}
			}
			return matchingWebtables;
		} finally {
			enableImplicitWait();
		}
	}

	/**
	 * determine the current url in the browser
	 * 
	 * @return url string
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * This method switches focus to window with title.
	 * 
	 * @param driver
	 * @param windowTitle
	 * @return boolean - whether switch was successful.
	 */
	public static boolean switchWindow(final String windowTitle) {

		for (final String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			driver.switchTo().window(handle).getTitle();
			if (driver.getTitle().compareToIgnoreCase(windowTitle.toLowerCase()) == 0) {
				return true;
			}
		}
		return false;
	}

	public void switchWindow() {
		// Common.sleepFor(10000);
		for (final String handle : driver.getWindowHandles()) {
			if (handle == "")
				continue;
			if (!driver.getWindowHandle().equals(handle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
	}

	/**
	 * Switch to the current frame providing the name of the frame
	 * 
	 * @param framename
	 */
	public void switchFrame(final String framename) {

		try {

			driver.switchTo().frame(framename);
		} catch (final NoSuchFrameException ne) {
			ne.printStackTrace();
		}

	}

	/**
	 * Switch to the first frame on the page, or the main document when a page
	 * contains iframes
	 * 
	 * @param framename
	 */
	public void switchToDefaultContent() {

		try {

			driver.switchTo().defaultContent();
		} catch (final NoSuchFrameException ne) {
			ne.printStackTrace();
		}

	}

	/**
	 * count how many times link text shows up on a page.
	 * 
	 * @param linkText displayed string to find in links on-screen
	 */
	public int countLinks(final String linkText) {
		return findElements(By.linkText(linkText)).size();
	}

	/**
	 * Search the page for the text passed in
	 * 
	 * @param expectedText
	 * @return boolean
	 */
	public boolean verifyTextPresentIn(final String expectedText) {
		final String lowerCase = expectedText.toLowerCase();

		for (int i = 0; i < DELAY * 5; i++) {
			if (driver.getPageSource().toLowerCase().contains(lowerCase)) {
				return true;
			}

			// Common.sleepFor(1000);
		}

		return false;
	}

	public boolean verifyTextNotPresentIn(WebDriver driver, By locator, String expectedText, int sec) {
		WebElement we = waitForElement(driver, locator, sec);
		if (we != null) {
			if (we.getText().contains(expectedText)) {
				Assert.fail("[TEXT SEARCH FAILED] ELEMENT WITH TEXT " + expectedText
						+ " HAS BEEN FOUND; TEXT SHOULD NOT APPEAR!");
				return false;
			} else if (we.getText().equalsIgnoreCase(expectedText)) {
				Assert.fail("[TEXT SEARCH FAILED] ELEMENT WITH TEXT " + expectedText
						+ " HAS BEEN FOUND; TEXT SHOULD NOT APPEAR!");
				return false;
			} else if (driver.getPageSource().contains(expectedText)) {
				Assert.fail("[TEXT SEARCH FAILED] ELEMENT WITH TEXT " + expectedText
						+ " HAS BEEN FOUND; TEXT SHOULD NOT APPEAR!");
				return false;
			} else if (driver.getPageSource().equalsIgnoreCase(expectedText)) {
				Assert.fail("[TEXT SEARCH FAILED] ELEMENT WITH TEXT " + expectedText
						+ " HAS BEEN FOUND; TEXT SHOULD NOT APPEAR!");
				return false;
			} else {
				return true;
			}
		} else if (driver.getPageSource().contains(expectedText)) {
			Assert.fail("[TEXT SEARCH FAILED] ELEMENT WITH TEXT " + expectedText
					+ " HAS BEEN FOUND; TEXT SHOULD NOT APPEAR!");
			return false;
		} else if (driver.getPageSource().equalsIgnoreCase(expectedText)) {
			Assert.fail("[TEXT SEARCH FAILED] ELEMENT WITH TEXT " + expectedText
					+ " HAS BEEN FOUND; TEXT SHOULD NOT APPEAR!");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param driver
	 * @param expectedText
	 * @param sec
	 * @return
	 */
	public boolean verifyTextNotPresentIn(WebDriver driver, String expectedText, int sec) {
		// Common.sleepFor((DELAY * sec) * 1000);
		if (driver.getPageSource().contains(expectedText)) {
			Assert.fail("[TEXT SEARCH FAILED] ELEMENT WITH TEXT " + expectedText
					+ " HAS BEEN FOUND; TEXT SHOULD NOT APPEAR!");
			return false;
		} else {
			return true;
		}

	}

	/**
	 * This method is used to find Element by Label (traces label "for" attribute to
	 * Input "id")
	 * 
	 * @param labelName
	 * @return WebElement
	 */
	protected WebElement findElementByLabel(final String labelName) {
		return findElement(By.id(getIdByLabel(labelName)));
	}

	private String getIdByLabel(final String labelName) {
		for (final WebElement e : findElements(By.tagName("label"))) {
			if (e.getText().contains(labelName)) {
				return e.getAttribute("for");
			}
		}
		return null;
	}

	public static void saveScreenShot(final String pSource, final String name, final String folderName) {
		try {
			final File f = new File(REPORT_DIRECTORY + "/" + folderName);
			try {
				f.mkdir();
			} catch (final Exception e) {
				e.fillInStackTrace();
			}
			BufferedWriter out = null;
			try {
				out = new BufferedWriter(new FileWriter(f + "/" + name + ".html"));
				out.write(pSource.replace("/is-bin", "http://" + DOMAIN + "/is-bin"));
			} finally {
				if (null != out) {
					out.close();
				}
			}
		} catch (final Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	protected WebElement findElementByHref(final String sub) {
		final String desc = String.format("href contains <%s>", sub);

		if (null == sub) {
			return wrapElement(null, desc);
		}

		for (final WebElement e : findElements(By.tagName("a"))) {
			if (e.getAttribute("href").contains(sub)) {
				return e;
			}
		}

		return wrapElement(null, desc);
	}

	/**
	 * 
	 * @param driver
	 * @param element
	 * @param sec
	 * @return
	 */
	public WebElement waitForElement(WebDriver driver, By element, int sec) {
		Wait<WebDriver> wait = new WebDriverWait(driver, DELAY * sec);
		ExpectedCondition<WebElement> condition = new ElementPresent(element);
		try {
			WebElement we = wait.until(condition);
			return we;
		} catch (WebDriverException e) {
			return null;
		}
	}

	/**
	 * This function is used to wait for a certain time until a element is loaded It
	 * is used for ensuring the elements are loaded before taking screenshots
	 * 
	 * @param driver
	 * @param element
	 * @param sec
	 * @return
	 */
	public void waitForPresenceOfElement(WebDriver driver, By element, long sec) {
		Wait<WebDriver> wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	/**
	 * This function is used to wait for a certain time until a element is loaded
	 * 
	 * @param driver
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public WebElement waitForElementPresent(WebDriver driver, WebElement element, int timeOutInSeconds) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			By elemBy = By.id(element.getAttribute("id"));
			element = wait.until(ExpectedConditions.presenceOfElementLocated(elemBy));
			return element; // return the element
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		return null;
	}

	/**
	 * This function is used to wait for a certain time until a element is loaded
	 * 
	 * @param driver
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement webelement, int timeOutInSeconds) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(webelement));
			return element; // return the element
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		return null;
	}

	/**
	 * This function is used to wait for a certain time until a element is clickable
	 * 
	 * @param driver
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement webelement,
			int timeOutInSeconds) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webelement));
			return element; // return the element
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		return null;
	}

	/**
	 * 
	 * @param driver
	 * @param locator
	 * @param expectedText
	 * @param sec
	 * @return
	 */
	public boolean verifyTextPresentIn(WebDriver driver, By locator, String expectedText, int sec) {
		WebElement we = waitForElement(driver, locator, sec);
		if (we != null) {
			// Common.sleepFor(1000);
			if (we.getText().contains(expectedText)) {
				return true;
			} else if (we.getText().equalsIgnoreCase(expectedText)) {
				return true;
			} else if (we.getText().replace("\n", "").replace("\r", "")
					.contains(expectedText.replace("\r", "").replace("\n", ""))) {
				return true;
			} else if (driver.getPageSource().contains(expectedText)) {
				return true;
			} else if (driver.getPageSource().equalsIgnoreCase(expectedText)) {
				return true;
			} else {
				Assert.fail("[TEXT SEARCH FAILED] ELEMENT WITH TEXT " + expectedText
						+ " NOT FOUND; TEXT CANNOT BE VERIFIED!");
				return false;
			}
		} else if (driver.getPageSource().contains(expectedText)) {
			return true;
		} else if (driver.getPageSource().equalsIgnoreCase(expectedText)) {
			return true;
		}
		Assert.fail("[TEXT SEARCH FAILED] ELEMENT WITH TEXT " + expectedText + " NOT FOUND; TEXT CANNOT BE VERIFIED!");
		return false;
	}

	/**
	 * 
	 * @param driver
	 * @param locator
	 * @param selectAction
	 * @param value
	 * @return
	 */
	public Select selectByVisibleText(WebDriver driver, By locator, String selectAction, String value) {

		Select localeList;

		WebElement element = waitForElement(driver, locator, 20);
		if (element == null) {
			element = waitForElement(driver, locator, 20);
		}

		if (element != null) {
			try {
				if (element.getAttribute("type").equalsIgnoreCase("hidden")) {
					element = null;
				}
			} catch (IllegalStateException e) {
			} catch (NullPointerException e) {
			}
		}

		if (element != null) {
			try {
				localeList = new Select(element);
			} catch (IllegalStateException e) {
				localeList = new Select(element);
			}
		} else {
			localeList = null;
		}

		if (!selectAction.equalsIgnoreCase("exists")) {

			try {
				if (selectAction.equalsIgnoreCase("select")) {
					localeList.selectByVisibleText(value);
				} else {
					Assert.fail(" SELECT ACTION NOT VALID. TEST FAILED.");
				}
			} catch (IllegalStateException e) {
				localeList.selectByVisibleText(value);
			} catch (NoSuchElementException e) {
				Assert.fail(locator + " LISTBOX NOT FOUND. TEST FAILED.");
			} catch (NullPointerException e) {
				Assert.fail(locator + " LISTBOX NOT FOUND. TEST FAILED.");
			} catch (org.openqa.selenium.WebDriverException e) {
				Assert.fail(locator + " ACTION FAILED. TEST FAILED.");
			}
		}

		return localeList;
	}

	public void moveToElement(WebElement element) {
		actions.moveToElement(element);
	}

	// Scroll Down Function
	public static void scrollDown(String px) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + px + ")", "");
	}

	// Scroll Up Function
	public static void scrollUp(String px) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(" + px + ",0)", "");
	}

	/// <summary>
	/// Select by Visible Text
	/// </summary>
	/// <param name="el"></param>
	/// <param name="Text"></param>
	public static Select selectByVisibleText(WebElement el, String Text) {
		Select statusBySelect = new Select(el);
		statusBySelect.selectByVisibleText(Text);
		return statusBySelect;
	}

	/// <summary>
	/// Select by Value
	/// </summary>
	/// <param name="el"></param>
	/// <param name="value"></param>
	public static Select selectByValue(WebElement el, String value) {
		Select statusBySelect = new Select(el);
		statusBySelect.selectByValue(value);
		return statusBySelect;
	}

	/// <summary>
	/// Select by Index
	/// </summary>
	/// <param name="el"></param>
	/// <param name="index"></param>
	public static Select selectByIndex(WebElement el, int index) {
		Select statusBySelect = new Select(el);
		statusBySelect.selectByIndex(index);
		return statusBySelect;
	}

	/// <summary>
	/// Enter the text
	/// </summary>
	/// <param name="el"></param>
	/// <param name="text"></param>
	public static void enter(WebElement el, String text) {
		el.clear();
		el.sendKeys(text);
	}

	public static String AlertAccept(WebDriver driver) throws InterruptedException {
		try {
			if (isAlertDialogPresent()) {
				String alertMsg = driver.switchTo().alert().getText();
				driver.switchTo().alert().accept();
				Thread.sleep(6000);
				System.out.println("Captured the Alert message " + alertMsg);
				return alertMsg;
			}
			return null;
		} catch (NoAlertPresentException e) {
			return null;
		}
	}

	public static boolean isAlertDialogPresent() {
		try {
			Alert alert = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
			return (alert != null);
		} catch (UnhandledAlertException ex) {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert is" + alert.getText());
		}
		return true;
	}

	/**
	 * 
	 * @param driver
	 * @param locator
	 * @param expectedText
	 * @param sec
	 * @return
	 */
	public boolean verifyTextPresentInWebElement(WebDriver driver, WebElement we, String expectedText, int sec) {
		if (we != null) {
			// Common.sleepFor(1000);
			if (we.getText().contains(expectedText)) {
				return true;
			} else if (we.getText().equalsIgnoreCase(expectedText)) {
				return true;
			} else if (we.getText().replace("\n", "").replace("\r", "")
					.contains(expectedText.replace("\r", "").replace("\n", ""))) {
				return true;
			} else if (driver.getPageSource().contains(expectedText)) {
				return true;
			} else if (driver.getPageSource().equalsIgnoreCase(expectedText)) {
				return true;
			} else {
				Assert.fail("[TEXT SEARCH FAILED] ELEMENT WITH TEXT " + expectedText
						+ " NOT FOUND; TEXT CANNOT BE VERIFIED!");
				return false;
			}
		} else if (driver.getPageSource().contains(expectedText)) {
			return true;
		} else if (driver.getPageSource().equalsIgnoreCase(expectedText)) {
			return true;
		}
		Assert.fail("[TEXT SEARCH FAILED] ELEMENT WITH TEXT " + expectedText + " NOT FOUND; TEXT CANNOT BE VERIFIED!");
		return false;
	}

	// Click element by javaScript
	public static void clickUsingJavaScipt(WebElement el) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", el);
	}

	// This will scroll the web page till end.
	public static void scrollToBottomofPage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	// This will scroll the page till the element is found

	public static void scrollToElementofPage(WebElement el) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", el);
	}

	public static void dragAndDrop(WebDriver driver, WebElement drag, WebElement drop, int timeOutInSeconds) {

		try {
			// To use WebDriverWait(), we would have to nullify implicitlyWait().
			// Because implicitlyWait time also set "driver.findElement()" wait time.
			// info from:
			// https://groups.google.com/forum/?fromgroups=#!topic/selenium-users/6VO_7IXylgY
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
			// Using Action class for drag and drop.
			Actions drapdopaction = new Actions(driver);
			drapdopaction.dragAndDrop(drag, drop).build().perform();
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset implicitlyWait

		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}

	}
	
	public static void navigateBack() {
		try {
			driver.navigate().back(); 
		} catch (final NoSuchFrameException ne) {
			ne.printStackTrace();
		}
	}
	
	public static void closePrintDialog() throws InterruptedException, AWTException {
		Thread.sleep(15000L);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Robot r = new Robot();
		r.delay(6000);
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	//	executor.executeScript("return document.querySelector('print-preview-app').shadowRoot.querySelector('print-preview-sidebar').shadowRoot.querySelector('print-preview-button-strip').shadowRoot.querySelector('cr-button.cancel-button').click();");
	//	executor.executeScript("document.getElementsByClassName('cancel')[0].click();");
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	}
	public static void scrollToTopofPage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(document.body.scrollHeight,0);");
	}


}
