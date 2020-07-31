package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.testdata.ShippingLabelConfigData;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

import junit.framework.Assert;

public class ShippingLabelConfigTests extends ROMUIBasePage {
	
	private ShippingLabelConfigData shipConfigdata;
	@Test(enabled = true, priority = 1, description = "Add Ship Label Config for Consignor")
	public void testAddShipLabelConfigByConsignor()
			throws JsonParseException, JsonMappingException, IOException, Exception {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(shipConfigdata.getStoreIndex(), shipConfigdata.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to Shipping Label Config");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().addShippingLabelConfig(0);
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for Consignor add success message is displayed");
		Assert.assertTrue(romuipages.shipLbleConfigPage().txtSuccessMsg.getText()
				.contains(RomuiEnumValues.SHIPPING_LABEL_CONFIG_ADD.getMessage()));
		logger.info("Ship Label Config for CONSIGNOR Group Name ADDED successfully");
		/*
		 * romuipages.shipLbleConfigPage().addShippingLabelConfig(1); logger.
		 * info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn"
		 * ); logger.
		 * info("Verify if ship Label Config for Consignor_mock done successfully");
		 * 
		 * romuipages.shipLbleConfigPage().addShippingLabelConfig(2); logger.
		 * info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn"
		 * ); logger.info("Verify if ship Label Config for Fedex done successfully ");
		 * 
		 * romuipages.shipLbleConfigPage().addShippingLabelConfig(3); logger.
		 * info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn"
		 * ); logger.info("Verify if ship Label Config for UPS done successfully ");
		 * 
		 * romuipages.shipLbleConfigPage().addShippingLabelConfig(4); logger.
		 * info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn"
		 * ); logger.info("Verify if ship Label Config for UPS done successfully ");
		 */
	}

	@Test(enabled = true, priority = 2, description = "Add Ship Label Config for Consignor_Mock")
	public void testAddShipLabelConfigByConsignorMock()
			throws JsonParseException, JsonMappingException, IOException, Exception {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(shipConfigdata.getStoreIndex(), shipConfigdata.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to Shipping Label Config");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().addShippingLabelConfig(1);
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for CONSIGNOR_MOCK add success message is displayed");
		Assert.assertTrue(romuipages.shipLbleConfigPage().txtSuccessMsg.getText()
				.contains(RomuiEnumValues.SHIPPING_LABEL_CONFIG_ADD.getMessage()));
		logger.info("Ship Label Config for CONSIGNOR_MOCK Group Name ADDED successfully");
	}

	@Test(enabled = true, priority = 3, description = "Add Ship Label Config for Fedex")
	public void testAddShipLabelConfigByFedex()
			throws JsonParseException, JsonMappingException, IOException, Exception {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(shipConfigdata.getStoreIndex(), shipConfigdata.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to Shipping Label Config");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().addShippingLabelConfig(2);
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for FEDEX add success message is displayed");
		Assert.assertTrue(romuipages.shipLbleConfigPage().txtSuccessMsg.getText()
				.contains(RomuiEnumValues.SHIPPING_LABEL_CONFIG_ADD.getMessage()));
		
		logger.info("Ship Label Config for FEDEX Group Name ADDED successfully");
	}

	@Test(enabled = true, priority = 4, description = "Add Ship Label Config for UPS")
	public void testAddShipLabelConfigByUps() throws Exception {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(shipConfigdata.getStoreIndex(), shipConfigdata.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to Shipping Label Config");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().addShippingLabelConfig(3);
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for UPS add success message is displayed");
		Assert.assertTrue(romuipages.shipLbleConfigPage().txtSuccessMsg.getText()
				.contains(RomuiEnumValues.SHIPPING_LABEL_CONFIG_ADD.getMessage()));
		
		logger.info("Ship Label Config for UPS Group Name ADDED successfully");
	}

	@Test(enabled = true, priority = 5, description = "Add Ship Label Config for UPS_Mock")
	public void testAddShipLabelConfigByUPSMock()
			throws JsonParseException, JsonMappingException, IOException, Exception {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(shipConfigdata.getStoreIndex(), shipConfigdata.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to Shipping Label Config");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().addShippingLabelConfig(4);
		logger.info("Add link is clicked on to enter the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for UPS_MOCK add success message is displayed");
		Assert.assertTrue(romuipages.shipLbleConfigPage().txtSuccessMsg.getText()
				.contains(RomuiEnumValues.SHIPPING_LABEL_CONFIG_ADD.getMessage()));
		logger.info("Ship Label Config for UPS_MOCK Group Name ADDED successfully");
	}

	@Test(enabled = true, priority = 6, description = "Edit Ship Label Config for Consignor")
	public void testEditShipLabelConfigByConsignor() throws Exception {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(shipConfigdata.getStoreIndex(), shipConfigdata.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to Shipping Label Config");	
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().editShippingLabelConfig(0);
		logger.info("EDIT ICON is clicked on to edit the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for Consignor edit success message is displayed");
		Assert.assertTrue(romuipages.shipLbleConfigPage().txtSuccessMsg.getText()
				.contentEquals(RomuiEnumValues.SHIPPNG_LABEL_CONFIG_EDIT.getMessage()));
		logger.info("Ship Label Config for Consignor Group Name edited successfully");
		/*
		 * romuipages.shipLbleConfigPage().editShippingLabelConfig(1); logger.
		 * info("EDIT ICON is clicked on to edit the Ship Label Config data and Clicked on Save btn"
		 * ); logger.
		 * info("Verify if ship Label Config for Consignor_mock edit success message is displayed"
		 * ); Assert.assertTrue(romuipages.shipLbleConfigPage().txtSuccessMsg.getText().
		 * contentEquals(RomuiEnumValues.SHIPPNG_LABEL_CONFIG_EDIT.getMessage()));
		 * logger.
		 * info("Ship Label Config for Consignor_mock Group Name edited successfully");
		 * romuipages.shipLbleConfigPage().editShippingLabelConfig(2); logger.
		 * info("EDIT ICON is clicked on to edit the Ship Label Config data and Clicked on Save btn"
		 * ); logger.
		 * info("Verify if ship Label Config for FEDEX edit success message is displayed"
		 * ); Assert.assertTrue(romuipages.shipLbleConfigPage().txtSuccessMsg.getText().
		 * contentEquals(RomuiEnumValues.SHIPPNG_LABEL_CONFIG_EDIT.getMessage()));
		 * logger.info("Ship Label Config for FEDEX Group Name edited successfully");
		 * romuipages.shipLbleConfigPage().editShippingLabelConfig(3); logger.
		 * info("EDIT ICON is clicked on to edit the Ship Label Config data and Clicked on Save btn"
		 * ); logger.
		 * info("Verify if ship Label Config for UPS edit success message is displayed"
		 * ); Assert.assertTrue(romuipages.shipLbleConfigPage().txtSuccessMsg.getText().
		 * contentEquals(RomuiEnumValues.SHIPPNG_LABEL_CONFIG_EDIT.getMessage()));
		 * logger.info("Ship Label Config for UPS Group Name edited successfully");
		 * romuipages.shipLbleConfigPage().editShippingLabelConfig(4); logger.
		 * info("EDIT ICON is clicked on to edit the Ship Label Config data and Clicked on Save btn"
		 * ); logger.
		 * info("Verify if ship Label Config for UPS_MOCK edit success message is displayed"
		 * ); Assert.assertTrue(romuipages.shipLbleConfigPage().txtSuccessMsg.getText().
		 * contentEquals(RomuiEnumValues.SHIPPNG_LABEL_CONFIG_EDIT.getMessage()));
		 * logger.info("Ship Label Config for UPS_MOCK Group Name edited successfully");
		 */
	}

	@Test(enabled = true, priority = 7, description = "Edit Ship Label Config for Consignor_mock")
	public void testEditShipLabelConfigByConsignor_mock() throws Exception {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(shipConfigdata.getStoreIndex(), shipConfigdata.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to Shipping Label Config");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().editShippingLabelConfig(1);
		logger.info("EDIT link is clicked on to edit the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for Consignor_mock edit success message is displayed");
		
		Assert.assertTrue(romuipages.shipLbleConfigPage().txtSuccessMsg.getText()
				.contentEquals(RomuiEnumValues.SHIPPNG_LABEL_CONFIG_EDIT.getMessage()));
		logger.info("Ship Label Config for Consignor_mock Group Name edited successfully");
	}

	@Test(enabled = true, priority = 8, description = "Edit Ship Label Config for Fedex")
	public void testeditShipLabelConfigByFedex()
			throws JsonParseException, JsonMappingException, IOException, Exception {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(shipConfigdata.getStoreIndex(), shipConfigdata.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to Shipping Label Config");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().editShippingLabelConfig(2);
		logger.info("EDIT link is clicked on to edit the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for Fedex edit success message is displayed");
		Assert.assertTrue(romuipages.shipLbleConfigPage().txtSuccessMsg.getText()
				.contentEquals(RomuiEnumValues.SHIPPNG_LABEL_CONFIG_EDIT.getMessage()));
		logger.info("Ship Label Config for FEDEX Group Name EDITED successfully");
	}

	@Test(enabled = true, priority = 9, description = "Edit Ship Label Config for UPS")
	public void testEditShipLabelConfigByUps() throws Exception {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(shipConfigdata.getStoreIndex(), shipConfigdata.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to Shipping Label Config");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().editShippingLabelConfig(3);
		logger.info("EDIT link is clicked on to edit the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for UPS edit success message is displayed");
		
		Assert.assertTrue(romuipages.shipLbleConfigPage().txtSuccessMsg.getText()
				.contentEquals(RomuiEnumValues.SHIPPNG_LABEL_CONFIG_EDIT.getMessage()));
		logger.info("Ship Label Config for UPS Group Name edited successfully");
	}

	@Test(enabled = true, priority = 10, description = "Edit Ship Label Config for UPS_MOCK")
	public void testEditShipLabelConfigByUps_mock() throws Exception {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(shipConfigdata.getStoreIndex(), shipConfigdata.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to Shipping Label Config");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().editShippingLabelConfig(4);
		logger.info("EDIT link is clicked on to edit the Ship Label Config data and Clicked on Save btn");
		logger.info("Verify if ship Label Config for UPS_MOCK edit success message is displayed");
		Assert.assertTrue(romuipages.shipLbleConfigPage().txtSuccessMsg.getText()
				.contentEquals(RomuiEnumValues.SHIPPNG_LABEL_CONFIG_EDIT.getMessage()));
		logger.info("Ship Label Config for UPS_MOCK Group Name edited successfully");
	}

	@Test(enabled = true, priority = 11, description = "Ship Label Config form validation")
	public void testShipLabelConfigFormValidation() throws Exception {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(shipConfigdata.getStoreIndex(), shipConfigdata.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to Shipping Label Config");
		romuipages.orderMgmPage().clickOnShippingLabelConfig();
		logger.info("Navigated to Shipping Label Config page");
		romuipages.shipLbleConfigPage().shipLabelConfigFormValidation();
		logger.info("Ship Label Config form validation done successfully");
	}
}
