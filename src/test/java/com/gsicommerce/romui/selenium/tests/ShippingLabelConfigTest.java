package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;

public class ShippingLabelConfigTest extends ROMUIBasePage {
	
	@Test(enabled = true, priority=3,description = "Add Ship Label Config for Fedex")
	public void testAddShipLabelConfigByFedex()throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");	
		romuipages.shipLbleConfigPage().addShippingLabelConfigByFedex();
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for Fedex add success message is displayed");
}
	
	@Test(enabled = true, priority=1,description = "Add Ship Label Config for Consignor")
	public void testAddShipLabelConfigByConsignor()throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");	
		romuipages.shipLbleConfigPage().addShippingLabelConfigByConsignor();
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for Consignor add success message is displayed");
}
	
	@Test(enabled = true, priority=2,description = "Add Ship Label Config for UPS")
	public void testAddShipLabelConfigByUps()throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");	
		romuipages.shipLbleConfigPage().addShippingLabelConfigByUPS();
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for UPS add success message is displayed");
}
	
	@Test(enabled = true, priority=4,description = "Edit Ship Label Config for Fedex")
	public void testeditShipLabelConfigByFedex()throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");	
		romuipages.shipLbleConfigPage().editShippingLabelConfigByFedex();
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for Fedex add success message is displayed");
}
	
	@Test(enabled = true, priority=5,description = "Edit Ship Label Config for Consignor")
	public void testeditShipLabelConfigByConsignor()throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");	
		romuipages.shipLbleConfigPage().editShippingLabelConfigByConsignor();
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for Consignor add success message is displayed");
}
	
	@Test(enabled = true, priority=6,description = "Edit Ship Label Config for UPS")
	public void testEditShipLabelConfigByUps()throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");	
		romuipages.shipLbleConfigPage().addShippingLabelConfigByUPS();
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for UPS add success message is displayed");
}
}