package com.gsicommerce.romui.selenium.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.CommonElementsPage;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class SFSTests extends ROMUIBasePage {

	@Test(enabled = true, description = "to Verify SFS Pick Order")
	public void testSFSPickOrder() throws Exception {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToSFSPick();
		romuipages.sfsPage().pickOrder();
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SFS_PICKORDER_SUCCESS_MSG.getMessage(), "Order is not picked up successfully");
		romuipages.storeFulflmtDashbrdPage().navigateToOrderSearch();
	}

	@Test(enabled = true, description = "to Verify SFS Pack Order")
	public void testSFSPackOrder() throws Exception {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToSFSPack();
		romuipages.sfsPage().completePackOrder();
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SFS_PACKORDER_SUCCESS_MSG.getMessage(), "Order is not packed up successfully");
//		romuipages.storeFulflmtDashbrdPage().navigateToOrderSearch();
	}
}
