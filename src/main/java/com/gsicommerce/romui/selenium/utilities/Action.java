package com.gsicommerce.romui.selenium.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.gsicommerce.romui.selenium.testdata.Environment;

public class Action {

	// DELAY is a value which will be used in waitForElement method and can be
	// increased if the environment is slow.
	private static final Integer DELAY = 3;
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

	protected void enableWait() {
		driver.manage().timeouts().implicitlyWait(WAIT_PERIOD, TimeUnit.SECONDS);
	}

	protected void disableWait() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
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
		clickUsingJavaScipt(el);
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

	public static void scrollToTopofPage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(document.body.scrollHeight,0);");
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
		// executor.executeScript("return
		// document.querySelector('print-preview-app').shadowRoot.querySelector('print-preview-sidebar').shadowRoot.querySelector('print-preview-button-strip').shadowRoot.querySelector('cr-button.cancel-button').click();");
		// executor.executeScript("document.getElementsByClassName('cancel')[0].click();");
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	}

}
