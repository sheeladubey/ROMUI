package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;

public class ShippingLabelConfigTest extends ROMUIBasePage {
	
	@Test(enabled = true, priority=1,description = "Add Ship Label Config")
	public void testAddShipLabelConfig()throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");	
		romuipages.shipLbleConfigPage().addShippingLabelConfig();
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config add success message is displayed");
}
}