package com.gsicommerce.romui.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.testdata.InventoryAvailabilityData;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class ATPRulesTests extends ROMUIBasePage {
	private InventoryAvailabilityData inventoryAvailabilityData;

	@Test(enabled = true, priority = 1, description = "to Verify Manage ATP rules displays all the ATP rules available for the store")
	public void testVerifyManageATPRule() throws Exception {
		inventoryAvailabilityData = InventoryAvailabilityData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(inventoryAvailabilityData.getStoreIndex(),
				inventoryAvailabilityData.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to ATP Rules page");
		romuipages.orderMgmPage().clickOnATPRules();
		logger.info(" Verify Manage ATP rules displays");
		Assert.assertTrue(romuipages.atpRulesPage().verifyInvAvail(),
				"Manage ATP rules screen doesn't displays all the ATP rules ");
		logger.info("Manage ATP rules display VERIFIED");
	}

	@Test(enabled = true, priority = 2, description = "to Verify user able to Add ATP rule in Manage ATP rules page")
	public void testAddATPRule() throws Exception {
		inventoryAvailabilityData = InventoryAvailabilityData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(inventoryAvailabilityData.getStoreIndex(),
				inventoryAvailabilityData.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to ATP Rules page");
		romuipages.orderMgmPage().clickOnATPRules();
		logger.info(" Verify user able to Add ATP rule in Manage ATP rules page");
		romuipages.atpRulesPage().addATPRule();
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.ATPRULES_ADD.getMessage(), "ATP Rule is not added successfully");
		logger.info("Add ATP Rule verified successfully");
	}

	@Test(enabled = true, priority = 3, description = "to Verify user able to edit ATP rule in Manage ATP rules page")
	public void testEditATPRule() throws Exception {
		inventoryAvailabilityData = InventoryAvailabilityData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(inventoryAvailabilityData.getStoreIndex(),
				inventoryAvailabilityData.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to ATP Rules page");
		romuipages.orderMgmPage().clickOnATPRules();
		logger.info(" Verify user able to Edit ATP rule in Manage ATP rules page");
		romuipages.atpRulesPage().editATPRule();
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.ATPRULES_EDIT.getMessage(), "ATP Rule is not Edited successfully");
		logger.info("Edit ATP Rule verified successfully");
	}

	@Test(enabled = true, priority = 4, description = "to Verify user able to delete ATP rule in Manage ATP rules page")
	public void testDeleteATPRule() throws Exception {
		inventoryAvailabilityData = InventoryAvailabilityData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(inventoryAvailabilityData.getStoreIndex(),
				inventoryAvailabilityData.getNodeID());
		Common.waitForPageLoaded(driver);
		logger.info("Navigate to ATP Rules page");
		romuipages.orderMgmPage().clickOnATPRules();
		logger.info(" Verify user able to Edit ATP rule in Manage ATP rules page");
		romuipages.atpRulesPage().deleteATPRule();
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.ATPRULES_DELETE.getMessage(), "ATP Rule is not DELETED successfully");
		logger.info("Delete ATP Rule verified successfully");
	}
}
