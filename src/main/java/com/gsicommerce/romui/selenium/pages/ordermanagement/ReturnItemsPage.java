package com.gsicommerce.romui.selenium.pages.ordermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gsicommerce.romui.selenium.testdata.Environment;

public class ReturnItemsPage {
	
	WebDriver driver;
	Environment env;
	

	public ReturnItemsPage(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
	

	}


}
