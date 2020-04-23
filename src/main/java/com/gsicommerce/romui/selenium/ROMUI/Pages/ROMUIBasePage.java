package com.gsicommerce.romui.selenium.ROMUI.Pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.gsicommerce.romui.selenium.ROMUI.Pages.Common.PageFactory;
import com.gsicommerce.romui.selenium.ROMUI.Pages.Common.ROMUIPageFactory;
import com.gsicommerce.romui.selenium.ROMUI.TestData.Environment;
import com.gsicommerce.romui.selenium.ROMUI.Utilities.Browser;
import com.gsicommerce.romui.selenium.ROMUI.Utilities.Common;

public class ROMUIBasePage {
	public static WebDriver driver;
	public static Environment env;
	public ROMUIPageFactory romuipages;
	public static Logger logger;
	
		
	@BeforeClass
	public void setup(final ITestContext c) 
	{		
		env = Environment.getInstance(c);
		driver = Common.startApplication(env,env.getBrowserType());
		logger = Logger.getLogger("romui");
		PropertyConfigurator.configure("log4j.properties");
		romuipages = PageFactory.getROMUIPages(driver, env);
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(final ITestResult c) throws IOException {
		if(!c.isSuccess()){
			Browser.screenShot(driver, env, c);
		}
		Browser.reset(driver);		
	}
}
