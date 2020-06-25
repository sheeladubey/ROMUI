package com.gsicommerce.romui.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.testdata.CatalogInventorySearchData;

public class AvailabilitySearchTests extends ROMUIBasePage {

	private CatalogInventorySearchData data;

	@Test(enabled = true, priority = 1, description = "to Verify Availability Search")
	public void testVerifyAvailabilitySearch() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnAvailabilitySearch();
		;
		logger.info("Search for Availabiltiy");
		romuipages.availbltySearchPage().searchForAvailability(data);
		Assert.assertTrue(romuipages.availbltySearchPage().verifyAvailability(data),
				"Availability Search not showing up any data");
	}
}
