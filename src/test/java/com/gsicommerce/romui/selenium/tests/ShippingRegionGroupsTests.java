package com.gsicommerce.romui.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.testdata.RegionConfigurationData;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class ShippingRegionGroupsTests extends ROMUIBasePage {

	private RegionConfigurationData data;
	private final String regionGrpName = Common.generateRandomID("UIAutoRGN");
	private final String regionName = Common.generateRandomID("UIAutoRN");

	@Test(enabled = true, priority = 1, description = "to Verify Add Shipping Region Groups")
	public void testVerifyAddShippingRegionGroups() throws Exception {
		data = RegionConfigurationData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnShippingRegionGrps();
		logger.info("Add New Shipping Region Groups");
		romuipages.shippngRegionGrpPage().addShippingRegionGroups(data, regionGrpName);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SHIPPINGREGIONGRP_SAVED.getMessage(),
				"Shipping Region Group is not added successfully");
	}

	@Test(enabled = true, priority = 2, description = "to Verify Edit Shipping Region Groups")
	public void testVerifyEditShippingRegionGroups() throws Exception {
		data = RegionConfigurationData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnShippingRegionGrps();
		logger.info("Edit Shipping Region Groups");
		romuipages.shippngRegionGrpPage().editShippingRegionGroups(data, regionGrpName);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SHIPPINGREGIONGRP_SAVED.getMessage(),
				"Shipping Region Group is not edited successfully");
	}

	@Test(enabled = true, priority = 3, description = "to Verify delete Shipping Region Groups")
	public void testVerifyDeleteShippingRegionGroups() throws Exception {
		data = RegionConfigurationData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnShippingRegionGrps();
		logger.info("Delete Shipping Region Groups");
		romuipages.shippngRegionGrpPage().deleteShippingRegionGroups(data, regionGrpName);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SHIPPINGREGIONGRP_DELETE.getMessage(),
				"Shipping Region Group is not deleted successfully");
	}

	@Test(enabled = true, priority = 4, description = "to Verify Add Shipping Region")
	public void testVerifyAddShippingRegion() throws Exception {
		data = RegionConfigurationData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnShippingRegions();
		logger.info("Add New Shipping Region");
		romuipages.shippngRegionGrpPage().addShippingRegion(data, regionName);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SHIPPINGREGION_SAVED.getMessage(), "Shipping Region is not added successfully");
	}

	@Test(enabled = true, priority = 5, description = "to Verify Edit Shipping Region")
	public void testVerifyEditShippingRegion() throws Exception {
		data = RegionConfigurationData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnShippingRegions();
		logger.info("Edit Shipping Region");
		romuipages.shippngRegionGrpPage().editShippingRegion(data, regionName);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SHIPPINGREGION_SAVED.getMessage(), "Shipping Region is not edited successfully");
	}

	@Test(enabled = true, priority = 6, description = "to Verify delete Shipping Region")
	public void testVerifyDeleteShippingRegion() throws Exception {
		data = RegionConfigurationData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnShippingRegions();
		logger.info("Delete Shipping Region");
		romuipages.shippngRegionGrpPage().deleteShippingRegion(data, regionName);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SHIPPINGREGION_DELETE.getMessage(), "Shipping Region is not deleted successfully");
	}

}
