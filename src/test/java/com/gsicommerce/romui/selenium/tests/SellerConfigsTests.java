package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.CommonElementsPage;
import com.gsicommerce.romui.selenium.testdata.SellerConfigurationsData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class SellerConfigsTests extends ROMUIBasePage {

	private SellerConfigurationsData sellerConfigData;
	private static int selleridselected;

	@Test(enabled = true, priority = 1, description = "To Verify Manage Seller Configurations ")
	public void testVerifyManageSellerConfig() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.orderMgmPage().clickOnSellerConfigurations();
		logger.info("Navigated to Seller Configurations page");
		logger.info("Verify Manager Seller Configuration display Seller id,Sellername");
		romuipages.sellerConfigurationsPage().verifyManageSellerConfig();
		logger.info("Manager Seller config screen verified successfully");
	}

	@Test(enabled = true, priority = 2, description = "To Verify Edit Seller Configurations feature")
	public void testEditSeller() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.orderMgmPage().clickOnSellerConfigurations();
		logger.info("Navigated to Seller Configurations page");
		logger.info("Click Edit Seller Icon and edit the field on Edit Seller Configuration page");
		romuipages.sellerConfigurationsPage().verifyEditSellerConfig();
		logger.info("Verify Edit Seller updated successfully Message");
		Assert.assertTrue(romuipages.sellerConfigurationsPage().txtSuccessMsg.getText()
				.contains(RomuiEnumValues.SELLERCONFIG_EDIT.getMessage()));
		logger.info("Edit Seller config verified successfully");
	}

	@Test(enabled = true, priority = 3, description = "To Verify View Seller Configurations feature")
	public void testViewSeller() throws JsonParseException, JsonMappingException, IOException, Exception {
		sellerConfigData = SellerConfigurationsData.get(env.getFileLocation());

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.orderMgmPage().clickOnSellerConfigurations();
		logger.info("Navigated to Seller Configurations page");
		selleridselected = CommonElementsPage.getRowNo(sellerConfigData.getSellerID());
		logger.info("Clicking on View Seller icon for the View Seller Configuration screen to be viewed");
		//CommonElementsPage.clickActionsIcon(selleridselected, 3, 1, 1);
		CommonElementsPage.clickDivSpanLink(selleridselected, 3, 0, 1, 1);
		// romuipages.sellerConfigurationsPage().viewSellerConfig();
		logger.info("Validate Seller ID:" + sellerConfigData.getSellerID());
		Assert.assertTrue(
				romuipages.sellerConfigurationsPage().verifyViewSellerConfig(0, sellerConfigData.getSellerID()),
				"No data found for Seller ID");
		logger.info("Validate Inventory Organization ID:" + sellerConfigData.getInventoryOrganizationID());
		Assert.assertTrue(romuipages.sellerConfigurationsPage().verifyViewSellerConfig(1,
				sellerConfigData.getInventoryOrganizationID()), "No data found for Inventory Organization ID");
		logger.info("Validate Seller Name:" + sellerConfigData.getSellerName());
		Assert.assertTrue(
				romuipages.sellerConfigurationsPage().verifyViewSellerConfig(2, sellerConfigData.getSellerName()),
				"No data found for Seller Name");
		logger.info("Validate Max Duration:" + sellerConfigData.getMaxDuration());
		Assert.assertTrue(
				romuipages.sellerConfigurationsPage().verifyViewSellerConfig(3, sellerConfigData.getMaxDuration()),
				"No data found for Max Duration");
		logger.info("Validate In-Store Pickup checkbox checked:");
		Assert.assertTrue(
				(romuipages.sellerConfigurationsPage().chkboxInStorePick.getAttribute("checked").equals("true")),
				"In-Store Pickup Checkbox not checked");

		logger.info("Validate Ship-To-Store  checkbox checked:");
		Assert.assertTrue(
				(romuipages.sellerConfigurationsPage().chkboxShipToStore.getAttribute("checked").equals("true")),
				" Ship-To-Store Checkbox not checked");

		logger.info("Validate Ship-From-Store checkbox checked:");
		Assert.assertTrue(
				(romuipages.sellerConfigurationsPage().chkboxShipFromStore.getAttribute("checked").equals("true")),
				"Ship-From-Store Checkbox not checked");
		Action.scrollToBottomofPage();
		logger.info("Validate Seller Region Lookup Strategy:" + sellerConfigData.getSellerRegionLookupStrategy());
		Assert.assertTrue(
				(romuipages.sellerConfigurationsPage().lookupStrategyPanel.get(3).getText()
						.contains(sellerConfigData.getSellerRegionLookupStrategy())),
				"Seller Region Lookup Strategy not edited");
	}

}
