package com.gsicommerce.romui.selenium.utilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestResult;

import com.crossbrowsertesting.AutomatedTest;
import com.crossbrowsertesting.Snapshot;
import com.crossbrowsertesting.Video;
import com.gsicommerce.romui.selenium.testdata.Environment;

public class Browser {
	
	static String username = "usoni%40radial.com"; // Your username
	static String authkey = "u61969854dbbf6ad"; // Your authkey
	/**
	 * This method will get the browser instance for the browser type and url
	 * provided. If the browser instance does not exist, then it will start another
	 * instance with the url.
	 * 
	 * @param browserType - valid values are ie, firefox, chrome
	 * @param url
	 * @return driver object
	 */
	
	public static WebDriver getBrowserInstance(final String browserType, final String url, final Environment env) {

		final WebDriver driver = buildBrowserInstance(env, browserType);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(env.getWaitPeriod(), TimeUnit.SECONDS);
		driver.get(url);

		try {
			maximizeWindow(driver, browserType);
		} catch (final WebDriverException e) {
			maximizeWindow(driver, browserType);
		}

		return driver;
	}

	private static void maximizeWindow(final WebDriver driver, final String browserType) {
		if (browserType.contains("firefox") || browserType.contains("ie") || browserType.contains("chrome")) {

			driver.manage().window().maximize();
		}
	}

	private static WebDriver buildBrowserInstance(final Environment env, final String browserType) {
		WebDriver driver = null;

		if (browserType.equalsIgnoreCase("chrome")) {
			setSystemProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			// DesiredCapabilities chromecapabilities = DesiredCapabilities.chrome();
			// chromecapabilities.setBrowserName("chrome");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			options.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(options);
			return driver;
		}
		if (browserType.equalsIgnoreCase("safari")) {
			SafariOptions options = new SafariOptions();
			options.setUseTechnologyPreview(true);
			driver = new SafariDriver(options);
			return driver;
		}

		if (browserType.equalsIgnoreCase("ie")) {
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.introduceFlakinessByIgnoringSecurityDomains();
			options.enablePersistentHovering();
			options.destructivelyEnsureCleanSession();
			options.requireWindowFocus();	
			options.setCapability("EnableNativeEvents", false);
			options.setCapability("ignoreZoomSetting", true);
			File file = new File("C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
			driver = new InternetExplorerDriver(options);	
			// Press CTRL + 0 keys of keyboard to set IEDriver Instance zoom level to 100%.
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
		
		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setLegacy(false);
			driver = new FirefoxDriver(options);

		} else if (browserType.equalsIgnoreCase("htmlunit")) {
			driver = new HtmlUnitDriver();
			((HtmlUnitDriver) driver).setJavascriptEnabled(true);
		} else if (browserType.equalsIgnoreCase("htmlunit-noscript")) {
			driver = new HtmlUnitDriver();
			((HtmlUnitDriver) driver).setJavascriptEnabled(false);
		} else if (browserType.equalsIgnoreCase("remote-firefox")) {
			driver = remoteWebDriver(env);
		} else if (browserType.equalsIgnoreCase("remote-ie")) {
			driver = remoteWebDriver(env);
		} else if (browserType.equalsIgnoreCase("remote-android")) {
			driver = remoteWebDriver(env);
		} else if (browserType.equalsIgnoreCase("remote-iphone")) {
			driver = remoteWebDriver(env);
		} else if (browserType.equalsIgnoreCase("remote-safari")) {
			driver = remoteWebDriver(env);
		} else if (browserType.equalsIgnoreCase("remote-chrome")) {
			driver = remoteWebDriver(env);
		}

		return driver;

	}

	private static void setSystemProperty(final String propKey, final String value) {
		if (null == value) {
			return;
		}

		System.setProperty(propKey, value);
	}

	private static WebDriver remoteWebDriver(final Environment env) {
		try {
			if (env.getBrowserType().equalsIgnoreCase("remote-firefox")) {
				final FirefoxProfile profile = new FirefoxProfile();
				profile.setAcceptUntrustedCertificates(true);
				profile.setAssumeUntrustedCertificateIssuer(false);
				profile.setPreference("capability.policy.default.Window.QueryInterface", "allAccess");
				profile.setPreference("capability.policy.default.Window.frameElement.get", "allAccess");
				final DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability(FirefoxDriver.PROFILE, profile);
				capabilities.setJavascriptEnabled(true);
				capabilities.setCapability("name", "Sheela CBT Firefox Test");
				capabilities.setCapability("browserName", "Firefox");
				capabilities.setCapability("version", "76");
				capabilities.setCapability("platform", "Windows 10");
				capabilities.setCapability("screenResolution", "1366x768");
				capabilities.setCapability("record_video", "true");
				final RemoteWebDriver remoteFirefoxDriver = new RemoteWebDriver(
						new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"),
						capabilities);
				return remoteFirefoxDriver;
			}

			if (env.getBrowserType().equalsIgnoreCase("remote-ie")) {
				final DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				capabilities.setCapability("requireWindowFocus", true);
				capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
				capabilities.setCapability("ignoreZoomSetting", true);
				// capabilities.setJavascriptEnabled(true);
				capabilities.setCapability("name", "Sheela CBT IE test");
				capabilities.setCapability("build", "1.0");
				capabilities.setCapability("browserName", "Internet Explorer");
				capabilities.setCapability("version", "11");
				capabilities.setCapability("platform", "Windows 10");
				capabilities.setCapability("screenResolution", "1366x768");
				capabilities.setCapability("record_video", "true");
				File file = new File("C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				final RemoteWebDriver remoteIEDriver = new RemoteWebDriver(
						new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"),
						capabilities);
				return remoteIEDriver;
			}

			if (env.getBrowserType().equalsIgnoreCase("remote-android")) {
				final DesiredCapabilities capabilities = DesiredCapabilities.android();
				capabilities.setJavascriptEnabled(true);
				final WebDriver remoteDriver = new RemoteWebDriver(new URL(env.getRemoteUrl()), capabilities);
				return remoteDriver;
			}

			if (env.getBrowserType().equalsIgnoreCase("remote-chrome")) {
				//final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				final ChromeOptions capabilities = new ChromeOptions(); 
				capabilities.setCapability("name", "Sheela CBT Chrome test");
				capabilities.setCapability("browserName", "Chrome");
				capabilities.setCapability("platform", "Windows 10");
				capabilities.setCapability("screenResolution", "1366x768");
				capabilities.setCapability("record_video", "true");
				capabilities.setCapability("max_duration","1800");
				capabilities.setCapability("idle_timeout","180");
				capabilities.setCapability("timezone","GMT-05:00");
				//capabilities.setJavascriptEnabled(true);
				capabilities.addArguments("javascript.enabled");
				final RemoteWebDriver remoteDriver = new RemoteWebDriver(
						new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"),
						capabilities);
				// initialize an AutomatedTest object with CBT selenium session id
				AutomatedTest myTest = new AutomatedTest((remoteDriver).getSessionId().toString());
				System.out.println("myTest value is::"+myTest);
			/*	// start up a video
				Video video = myTest.startRecordingVideo();
				// take a snapshot of where we currently are
				Snapshot googleSnap = myTest.takeSnapshot();
				googleSnap.setDescription("ROMUI CHROME TEST RESULT");
				googleSnap.saveLocally("C:\\Users\\shedubey\\Desktop\\ROM\\ROMUI_Automation\\ROMUI-sheela\\ScreenShots");
				// stop our video and set a description
				video.stopRecording();
				// set a score for our test and end it
				myTest.setScore("pass");
				myTest.stop();
				// save our video
				video.saveLocally("C:\\Users\\shedubey\\Desktop\\ROM\\ROMUI_Automation\\ROMUI-sheela\\ScreenShots\\ChromeTestResult.mp4");*/
				return remoteDriver;
			}
			if (env.getBrowserType().equalsIgnoreCase("remote-iphone")) {
				final DesiredCapabilities capabilities = DesiredCapabilities.iphone();
				capabilities.setJavascriptEnabled(true);
				final WebDriver remoteDriver = new RemoteWebDriver(new URL(env.getRemoteUrl()), capabilities);
				return remoteDriver;
			}
			if (env.getBrowserType().equalsIgnoreCase("remote-safari")) {
				SafariOptions options = new SafariOptions();
				options.setUseTechnologyPreview(true);
				final WebDriver remoteDriver = new RemoteWebDriver(new URL(env.getRemoteUrl()), options);
				return remoteDriver;
			}
		} catch (final Exception e) {
			throw new IllegalStateException("Failed to create remote webdriver", e);
		}

		return null;
	}

	/**
	 * Close all the browser instances
	 * 
	 * @param driver WebDriver instance to close
	 */
	public static void reset(final WebDriver driver) {
		if (null == driver) {
			return;
		}
		try {
			if (driver.switchTo().alert() != null) {
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
			}

		} catch (Exception e) {

		}
		try {
			driver.quit();
		} catch (final Exception WillBeOK) {
		}
	}

	/**
	 * Capture screenshot of entire page and save on the disc in output folder. Can
	 * be used for IE also.
	 * 
	 */
	public static void screenShot(final WebDriver driver, final Environment env, final ITestResult c)
			throws IOException {

		String NewFileNamePath;
		File directory = new File(".");
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmssaa");
		Date date = new Date();
		NewFileNamePath = directory.getCanonicalPath() + "\\ScreenShots\\" + "_" + dateFormat.format(date) + "_"
				+ env.getStoreEnvironment() + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(NewFileNamePath));
		NewFileNamePath = "<a href=file:///" + NewFileNamePath + ">ScreenShot" + "</a>";

	}

	public static String screenShot2(final WebDriver driver, final Environment env, final ITestResult c)
			throws IOException {

		String NewFileNamePath;
		File directory = new File(".");
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmssaa");
		Date date = new Date();
		NewFileNamePath = directory.getCanonicalPath() + "\\ScreenShots\\" + "_" + dateFormat.format(date) + "_"
				+ env.getStoreEnvironment() + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(NewFileNamePath));
		// NewFileNamePath = "<a href=file:///" + NewFileNamePath + ">ScreenShot"
		// + "</a>";
		return NewFileNamePath;

	}

}
