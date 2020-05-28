package com.gsicommerce.romui.selenium.tests;

import org.testng.annotations.Test;

import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;

public class ISPUTests extends ROMUIBasePage {

	@Test(enabled = true, description = "to Verify ISPU Pick Order")
	public void testISPUPickOrder() throws Exception {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToISPUPick();
		romuipages.ispuPickPage().pickOrder("100803", "0002698643695353", "2", "123");
		romuipages.storeFulflmtDashbrdPage().navigateToOrderSearch();
	}
}
