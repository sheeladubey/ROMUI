package com.gsicommerce.romui.selenium.pages.ordermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Action;

public class ShippingLabelConfigPage {
	
	WebDriver driver;
	Environment env;
	Action action;
	
	public ShippingLabelConfigPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);
	}


}
