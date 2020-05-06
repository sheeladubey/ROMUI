package com.gsicommerce.romui.selenium.utilities;

import java.net.IDN;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.PaymentMethodConfigData;
import com.thoughtworks.xstream.XStream;

public class Common {

	/** Default wait time for an element. 7 seconds. */
	public static final int DEFAULT_WAIT_4_ELEMENT = 7;
	/**
	 * Default wait time for a page to be displayed. 12 seconds. The average webpage
	 * load time is 6 seconds Based on your tests, please set this value. "0" will
	 * nullify implicitlyWait and speed up a test.
	 */
	public static final int DEFAULT_WAIT_4_PAGE = 12;
	private static final Random RANDOM_GENERATOR = new Random();

	/**
	 * Converts string to int
	 * 
	 * @param num
	 * @return
	 */
	public static int convertStringToInt(final String num) {
		return Integer.parseInt(num);
	}

	/**
	 * This method will return a US-ASCII string for the unicode string provided
	 * 
	 * @param unicodeString
	 * @return
	 */
	public static String convertUniCodeToASCII(final String unicodeString) {

		return IDN.toASCII(unicodeString);
	}

	/**
	 * This method can be used to start the application
	 * 
	 * @param env
	 * @param application
	 * @return webdriver
	 */
	public static WebDriver startApplication(final Environment env, final String browserType) {
		final String url = getAppUrl(env);
		return Browser.getBrowserInstance(browserType, url, env);
	}

	public static String getAppUrl(final Environment env) {

		return "http://" + env.getStoreEnvironment() + "-vip.gspt.net";
	}

	/**
	 * Wait for the element to be present in the DOM, and displayed on the page. And
	 * returns the first WebElement using the given method.
	 * 
	 * @param WebDriver The driver object to be used
	 * @param By        selector to find the element
	 * @param           int The time in seconds to wait until returning a failure
	 *
	 * @return WebElement the first WebElement using the given method, or null (if
	 *         the timeout is reached)
	 */
	public static WebElement waitForElement(WebDriver driver, final By by, int timeOutInSeconds) {
		WebElement element;
		try {
			// To use WebDriverWait(), we would have to nullify implicitlyWait().
			// Because implicitlyWait time also set "driver.findElement()" wait time.
			// info from:
			// https://groups.google.com/forum/?fromgroups=#!topic/selenium-users/6VO_7IXylgY
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		return null;
	}

	/**
	 * Wait for the element to be present in the DOM, displayed and clickable on the
	 * page. And returns the first WebElement using the given method.
	 * 
	 * @param WebDriver The driver object to be used
	 * @param By        selector to find the element
	 * @param           int The time in seconds to wait until returning a failure
	 *
	 * @return WebElement the first WebElement using the given method, or null (if
	 *         the timeout is reached)
	 */
	public static WebElement waitForElementToBeClickable(WebDriver driver, final By by, int timeOutInSeconds) {
		WebElement element;
		try {
			// To use WebDriverWait(), we would have to nullify implicitlyWait().
			// Because implicitlyWait time also set "driver.findElement()" wait time.
			// info from:
			// https://groups.google.com/forum/?fromgroups=#!topic/selenium-users/6VO_7IXylgY
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.elementToBeClickable(by));

			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		return null;
	}

	public static WebElement waitForElement(WebDriver driver, WebElement element, int timeOutInSeconds) {

		try {
			// To use WebDriverWait(), we would have to nullify implicitlyWait().
			// Because implicitlyWait time also set "driver.findElement()" wait time.
			// info from:
			// https://groups.google.com/forum/?fromgroups=#!topic/selenium-users/6VO_7IXylgY
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.visibilityOf(element));

			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		return null;
	}

	/**
	 * Wait for the element to be present in the DOM, regardless of being displayed
	 * or not. And returns the first WebElement using the given method.
	 *
	 * @param WebDriver The driver object to be used
	 * @param By        selector to find the element
	 * @param           int The time in seconds to wait until returning a failure
	 * 
	 * @return WebElement the first WebElement using the given method, or null (if
	 *         the timeout is reached)
	 */
	public static WebElement waitForElementPresent(WebDriver driver, final By by, int timeOutInSeconds) {
		WebElement element;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		return null;
	}

	/**
	 * Wait for the List<WebElement> to be present in the DOM, regardless of being
	 * displayed or not. Returns all elements within the current page DOM.
	 * 
	 * @param WebDriver The driver object to be used
	 * @param By        selector to find the element
	 * @param           int The time in seconds to wait until returning a failure
	 *
	 * @return List<WebElement> all elements within the current page DOM, or null
	 *         (if the timeout is reached)
	 */
	public static List<WebElement> waitForListElementsPresent(WebDriver driver, final List<WebElement> webelements,
			int timeOutInSeconds) {
		List<WebElement> elements;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driverObject) {
					return areElementsPresent(driverObject, webelements);
				}
			});

			elements = driver.findElements((By) webelements);
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset implicitlyWait
			return elements; // return the element
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		return null;
	}

	/**
	 * Wait for an element to appear on the refreshed web-page. And returns the
	 * first WebElement using the given method.
	 *
	 * This method is to deal with dynamic pages.
	 * 
	 * Some sites have tested have required a page refresh to add additional
	 * elements to the DOM. Generally you wouldn't need to do this in a typical AJAX
	 * scenario.
	 * 
	 * @param WebDriver The driver object to use to perform this element search
	 * @param locator   selector to find the element
	 * @param           int The time in seconds to wait until returning a failure
	 * 
	 * @return WebElement the first WebElement using the given method, or null(if
	 *         the timeout is reached)
	 * 
	 */
	public static WebElement waitForElementRefresh(WebDriver driver, final By by, int timeOutInSeconds) {
		WebElement element;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driverObject) {
					driverObject.navigate().refresh(); // refresh the page ****************
					return isElementPresentAndDisplay(driverObject, by);
				}
			});
			element = driver.findElement(by);
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		return null;
	}

	/**
	 * Wait for the Text to be present in the given element, regardless of being
	 * displayed or not.
	 *
	 * @param WebDriver The driver object to be used to wait and find the element
	 * @param locator   selector of the given element, which should contain the text
	 * @param String    The text we are looking
	 * @param           int The time in seconds to wait until returning a failure
	 * 
	 * @return boolean
	 */
	public static boolean waitForTextPresent(WebDriver driver, final By by, final String text, int timeOutInSeconds) {
		boolean isPresent = false;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driverObject) {
					return isTextPresent(driverObject, by, text); // is the Text in the DOM
				}
			});
			isPresent = isTextPresent(driver, by, text);
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset implicitlyWait
			return isPresent;
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		return false;
	}

	/**
	 * Waits for the Condition of JavaScript.
	 *
	 *
	 * @param WebDriver The driver object to be used to wait and find the element
	 * @param String    The javaScript condition we are waiting. e.g. "return
	 *                  (xmlhttp.readyState >= 2 && xmlhttp.status == 200)"
	 * @param           int The time in seconds to wait until returning a failure
	 * 
	 * @return boolean true or false(condition fail, or if the timeout is reached)
	 **/
	public static boolean waitForJavaScriptCondition(WebDriver driver, final String javaScript, int timeOutInSeconds) {
		boolean jscondition = false;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driverObject) {
					return (Boolean) ((JavascriptExecutor) driverObject).executeScript(javaScript);
				}
			});
			jscondition = (Boolean) ((JavascriptExecutor) driver).executeScript(javaScript);
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset implicitlyWait
			return jscondition;
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		return false;
	}

	/**
	 * Waits for the completion of Ajax jQuery processing by checking "return
	 * jQuery.active == 0" condition.
	 *
	 * @param WebDriver - The driver object to be used to wait and find the element
	 * @param           int - The time in seconds to wait until returning a failure
	 * 
	 * @return boolean true or false(condition fail, or if the timeout is reached)
	 */
	public static boolean waitForJQueryProcessing(WebDriver driver, int timeOutInSeconds) {
		boolean jQcondition = false;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driverObject) {
					return (Boolean) ((JavascriptExecutor) driverObject).executeScript("return jQuery.active == 0");
				}
			});
			jQcondition = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset implicitlyWait
			return jQcondition;
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		return jQcondition;
	}

	/**
	 * Coming to implicit wait, If you have set it once then you would have to
	 * explicitly set it to zero to nullify it -
	 */
	public static void nullifyImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
	}

	/**
	 * Set driver implicitlyWait() time.
	 */
	public static void setImplicitWait(WebDriver driver, int waitTimeInSeconds) {
		driver.manage().timeouts().implicitlyWait(waitTimeInSeconds, TimeUnit.SECONDS);
	}

	/**
	 * Reset ImplicitWait. To reset ImplicitWait time you would have to explicitly
	 * set it to zero to nullify it before setting it with a new time value.
	 */
	public static void resetImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
		driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset implicitlyWait
	}

	/**
	 * Reset ImplicitWait.
	 * 
	 * @param int - a new wait time in seconds
	 */
	public static void resetImplicitWait(WebDriver driver, int newWaitTimeInSeconds) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
		driver.manage().timeouts().implicitlyWait(newWaitTimeInSeconds, TimeUnit.SECONDS); // reset implicitlyWait
	}

	/**
	 * Checks if the text is present in the element.
	 * 
	 * @param driver - The driver object to use to perform this element search
	 * @param by     - selector to find the element that should contain text
	 * @param text   - The Text element you are looking for
	 * @return true or false
	 */
	private static boolean isTextPresent(WebDriver driver, By by, String text) {
		try {
			return driver.findElement(by).getText().contains(text);
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks if the elment is in the DOM, regardless of being displayed or not.
	 * 
	 * @param driver - The driver object to use to perform this element search
	 * @param by     - selector to find the element
	 * @return boolean
	 */
	private static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);// if it does not find the element throw NoSuchElementException, which calls
									// "catch(Exception)" and returns false;
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Checks if the List<WebElement> are in the DOM, regardless of being displayed
	 * or not.
	 * 
	 * @param driver     - The driver object to use to perform this element search
	 * @param btnLanding - selector to find the element
	 * @return boolean
	 */
	private static boolean areElementsPresent(WebDriver driver, List<WebElement> btnLanding) {
		try {
			driver.findElements((By) btnLanding);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Checks if the elment is in the DOM and displayed.
	 * 
	 * @param driver - The driver object to use to perform this element search
	 * @param by     - selector to find the element
	 * @return boolean
	 */
	private static boolean isElementPresentAndDisplay(WebDriver driver, By by) {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static WebElement waitForElementPresent(WebDriver driver, WebElement element, int timeOutInSeconds) {

		try {
			// To use WebDriverWait(), we would have to nullify implicitlyWait().
			// Because implicitlyWait time also set "driver.findElement()" wait time.
			// info from:
			// https://groups.google.com/forum/?fromgroups=#!topic/selenium-users/6VO_7IXylgY
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			By elemBy = By.id(element.getAttribute("id"));

			element = wait.until(ExpectedConditions.presenceOfElementLocated(elemBy));

			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		return null;
	}

	public WebElement fluentWait(WebDriver driver, final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return foo;
	};

	public void waitForElementToLoad(WebDriver driver, final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver arg0) {
				System.out.println("Checking for the element!!");
				WebElement element = arg0.findElement(locator);
				if (element != null) {
					System.out.println("Target element found");
				}
				return element;
			}
		};

		wait.until(function);
	}

	public void waitForElementToVisible(WebDriver driver, final WebElement element1) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver arg0) {
				System.out.println("Checking for the element!!");
				WebElement element = element1;
				if (element != null) {
					System.out.println("Target element found");
				}
				return element;
			}
		};

		wait.until(function);
	}

	/**
	 * This method will generate a java object for the xml data file provided. For
	 * this to work,every xml should have corresponding class file.
	 * 
	 * @param fileName - xml file
	 * 
	 * @return - java object representing the class.
	 */
	public Object xmlToJava(final String fileName) {
		final XStream xstream = new XStream();
		xstream.alias("ProductData", PaymentMethodConfigData.class);
		// xstream.alias("Address", Address.class);
		// xstream.alias("CreditCardData", CreditCardData.class);
		// xstream.alias("Consumer", Consumer.class);
		// xstream.alias("Promotion", Promotion.class);
		return xstream.fromXML(getClass().getResourceAsStream(fileName));
	}

	/**
	 * This method generates a 6 digit random number with a prefix
	 * 
	 * @param prefix
	 * @return String - a String with prefix followed by a random number
	 */
	public static String generateRandomID(final String prefix) {
		return new StringBuilder(prefix).append(RANDOM_GENERATOR.nextInt(999999)).toString();
	}

	public static void dragAndDrop(WebDriver driver, WebElement drag, WebElement drop,int timeOutInSeconds) {
		
		try{	
			//To use WebDriverWait(), we would have to nullify implicitlyWait(). 
			//Because implicitlyWait time also set "driver.findElement()" wait time.  
			//info from: https://groups.google.com/forum/?fromgroups=#!topic/selenium-users/6VO_7IXylgY
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait() 
			 //Using Action class for drag and drop.		
	         Actions drapdopaction=new Actions(driver);	
	         drapdopaction.dragAndDrop(drag, drop).build().perform();
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); //reset implicitlyWait
			
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		} 
	
	}

		
		
	}

