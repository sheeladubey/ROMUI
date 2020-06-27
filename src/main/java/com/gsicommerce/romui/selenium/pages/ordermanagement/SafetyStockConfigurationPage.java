package com.gsicommerce.romui.selenium.pages.ordermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gsicommerce.romui.selenium.testdata.Environment;

public class SafetyStockConfigurationPage {
	WebDriver driver;
	Environment env;
	
	public SafetyStockConfigurationPage(WebDriver driver, Environment env)
	{
		this.driver=driver;
		this.env=env;
		PageFactory.initElements(driver, this);
	}

}
