package com.gsicommerce.romui.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;

public class SafetyStockConfigsTests extends ROMUIBasePage {
	
	@Test(enabled = true, priority = 1, description = "to Verify Safety stock is searched through Node Item in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByNodeItem() throws Exception {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(0);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(), "No Safety Stock Found by NodeItem search");
		logger.info("NodeItem Safety Stock Search verified");
		
	}
	
	@Test(enabled = true, priority = 2, description = "to Verify Safety stock is searched through Node Type Item  in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByNodeTypeItem() throws Exception {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(1);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(), "No Safety Stock Found by NodeTypeItem search");
		logger.info("NodeTypeItem Safety Stock Search verified");
		
	}
	
	@Test(enabled = true, priority = 3, description = "to Verify Safety stock is searched through Node Item Attribute in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByNodeItemAttribute() throws Exception {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(2);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(), "No Safety Stock Found by NodeItemAttribute Search");
		logger.info("NodeItemAttribute Safety Stock Search verified");	
	}

	@Test(enabled = true, priority = 4, description = "to Verify Safety stock is searched through Node Type Item Attribute in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByNodeTypeItemAttribute() throws Exception {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(3);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(), "No Safety Stock Found by NodeTypeItemAttribute Search");
		logger.info("NodeTypeItemAttribute Safety Stock Search verified");
		
	}

	@Test(enabled = true, priority = 5, description = "to Verify Safety stock is searched through Global  Node Type in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByGlobalNodeType() throws Exception {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(4);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(), "No Safety Stock Found by GlobalNodeType search");
		logger.info("GlobalNodeType Safety Stock Search verified");   
	}
	
	@Test(enabled = false, priority = 6, description = "to Verify Safety stock is searched through Global  Supply Type in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByGlobalSupplyType() throws Exception {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(5);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(), "No Safety Stock Found by Global  Supply Type search");
		logger.info("Global  Supply Type Safety Stock Search verified");
	}
	
	@Test(enabled = false, priority = 7, description = "to Verify Safety stock is searched through Aggregated Global in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByAggregatedGlobal() throws Exception {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(6);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(), "No Safety Stock Found by Aggregated Global search");
		logger.info(" Aggregated Global Safety Stock Search verified");
	}
	
	@Test(enabled = false, priority = 8, description = "to Verify Safety stock is searched through Node Item & Fulfillment type & supply type in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByNodeItemFulfillType() throws Exception {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStockByNodeItemFulfillType(0,0,2);
		logger.info("Safety Stock Search by NODE ITEM,FULFILLMENT TYPE,SUPPLY TYPE verified");		
	}

}
