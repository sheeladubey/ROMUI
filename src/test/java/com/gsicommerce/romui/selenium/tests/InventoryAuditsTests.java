package com.gsicommerce.romui.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.testdata.CatalogInventorySearchData;

public class InventoryAuditsTests extends ROMUIBasePage {

	private CatalogInventorySearchData data;

	@Test(enabled = true, priority = 1, description = "to Verify view Audit for inventory")
	public void testVerifyInventoryAudit() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnInventoryAudits();
		logger.info("Search for Inventory Audits");
		romuipages.inventoryAuditsPage().searchForInventoryAudits(data);
		Assert.assertTrue(romuipages.inventoryAuditsPage().verifyAudits(data), "Audit for inventory is not showing up");
	}
}
