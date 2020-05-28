package com.gsicommerce.romui.selenium.tests;

import org.testng.annotations.Test;

import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;

public class ItemSearchTests extends ROMUIBasePage {

	@Test(enabled = false, description = "to Verify for valid item search")
	public void testValidItemSearch() {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnItemSearch();
	}
}
