package com.gsicommerce.romui.selenium.tests;

import org.testng.annotations.Test;

import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;

public class ReturnItemsTests extends ROMUIBasePage {
	
	@Test(enabled = true, description = "to Verify Return items via Store Fulfillment screen")
	public void testReturnsItems() throws Exception {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		//romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Click Store Fulfillment");
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		logger.info("Click Return items link");
		romuipages.storeFulflmtDashbrdPage().navigateToReturnItems();
		logger.info("Verify Return order creation");
		romuipages.ordersPage().createReturnOrder();
		logger.info("Return order creation Validated");
	}

}
