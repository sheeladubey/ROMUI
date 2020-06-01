package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

import junit.framework.Assert;

public class ShippingLabelConfigTests extends ROMUIBasePage {

	@Test(enabled = false, priority = 1, description = "Add Ship Label Config for Consignor")
	public void testAddShipLabelConfigByConsignor() throws JsonParseException, JsonMappingException, IOException,Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().addShippingLabelConfig(0);
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for Consignor add success message is displayed");
	}

	@Test(enabled = false, priority = 2, description = "Add Ship Label Config for Consignor_Mock")
	public void testAddShipLabelConfigByConsignorMock() throws JsonParseException, JsonMappingException, IOException,Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().addShippingLabelConfig(1);
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for Consignor add success message is displayed");
	}

	@Test(enabled = false, priority = 3, description = "Add Ship Label Config for Fedex")
	public void testAddShipLabelConfigByFedex() throws JsonParseException, JsonMappingException, IOException,Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().addShippingLabelConfigByFedex(2);
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for Fedex add success message is displayed");
		Assert.assertEquals(romuipages.shipLbleConfigPage().txtSuccessMsg.getText(),
				RomuiEnumValues.SHIPPING_LABEL_CONFIG_ADD.getMessage(),
				"Shipping Label Config doesn't added successfully"); 
	}

	@Test(enabled = false, priority = 4, description = "Add Ship Label Config for UPS")
	public void testAddShipLabelConfigByUps() throws JsonParseException, JsonMappingException, IOException {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().addShippingLabelConfigByUPS(3);
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for UPS add success message is displayed");
		Assert.assertEquals(romuipages.shipLbleConfigPage().txtSuccessMsg.getText(),
				RomuiEnumValues.SHIPPING_LABEL_CONFIG_ADD.getMessage(),
				"Shipping Label Config doesn't added successfully");
	}

	@Test(enabled = false, priority = 5, description = "Add Ship Label Config for UPS_Mock")
	public void testAddShipLabelConfigByUPSMock() throws JsonParseException, JsonMappingException, IOException,Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().addShippingLabelConfig(4);
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for Consignor add success message is displayed");
	}

	@Test(enabled = true, priority = 7, description = "Edit Ship Label Config for Fedex")
	public void testeditShipLabelConfigByFedex() throws JsonParseException, JsonMappingException, IOException,Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().editShippingLabelConfigByFedex(2);
		// romuipages.shipLbleConfigPage().editShippingLabelConfig(2);
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for Fedex add success message is displayed");
	}

	@Test(enabled = false, priority = 8, description = "Edit Ship Label Config for Consignor")
	public void testeditShipLabelConfigByConsignor() throws JsonParseException, JsonMappingException, IOException {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().editShippingLabelConfigByConsignor(0);
		// romuipages.shipLbleConfigPage().editShippingLabelConfig(0);
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for Consignor add success message is displayed");
	}

	@Test(enabled = false, priority = 6, description = "Edit Ship Label Config for UPS")
	public void testEditShipLabelConfigByUps() throws JsonParseException, JsonMappingException, IOException {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().editShippingLabelConfigByUPS(3);
		// romuipages.shipLbleConfigPage().editShippingLabelConfig(3);
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for UPS add success message is displayed");
		Assert.assertEquals(romuipages.shipLbleConfigPage().txtSuccessMsg.getText(),
				RomuiEnumValues.SHIPPNG_LABEL_CONFIG_EDIT.getMessage(),
				"Shipping Label Config doesn't Edited successfully");
	}

	
}