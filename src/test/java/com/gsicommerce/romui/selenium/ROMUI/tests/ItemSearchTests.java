package com.gsicommerce.romui.selenium.ROMUI.tests;

import org.testng.annotations.Test;
import com.gsicommerce.romui.selenium.ROMUI.Pages.ROMUIBasePage;

public class ItemSearchTests extends ROMUIBasePage {

	@Test(enabled = true,description = "to Verify for valid item search")
	public void testValidItemSearch() {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnItemSearch();
	}
}
