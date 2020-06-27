package com.gsicommerce.romui.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class SafetyStockConfigsTests extends ROMUIBasePage {

	@Test(enabled = false, priority = 1, description = "to Verify Safety stock is searched through type in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchBy() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(0);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(),
				"No Safety Stock Found by NodeItem search");
		logger.info("NodeItem Safety Stock Search verified");
		logger.info("Verify Safety stock is searched through Node type Item");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(1);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(),
				"No Safety Stock Found by NodeTypeItem search");
		logger.info("NodeTypeItem Safety Stock Search verified");
		logger.info("Verify Safety stock is searched through Node Item Attribute");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(2);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(),
				"No Safety Stock Found by NodeItemAttribute Search");
		logger.info("NodeItemAttribute Safety Stock Search verified");
		logger.info("Verify Safety stock is searched through Node type Item Attribute");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(3);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(),
				"No Safety Stock Found by NodeTypeItemAttribute Search");
		logger.info("NodeTypeItemAttribute Safety Stock Search verified");
		logger.info("Verify Safety stock is searched through Global  Node Type");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(4);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(),
				"No Safety Stock Found by GlobalNodeType search");
		logger.info("GlobalNodeType Safety Stock Search verified");
		logger.info("Verify Safety stock is searched through Global  Supply Type");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(5);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(),
				"No Safety Stock Found by Global  Supply Type search");
		logger.info("Global  Supply Type Safety Stock Search verified");
		logger.info("Verify Safety stock is searched through Aggregated Global");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(6);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(),
				"No Safety Stock Found by Aggregated Global search");
		logger.info(" Aggregated Global Safety Stock Search verified");

	}

	@Test(enabled = false, priority = 2, description = "to Verify Safety stock is searched through Node Type Item  in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByNodeTypeItem() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node type Item");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(1);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(),
				"No Safety Stock Found by NodeTypeItem search");
		logger.info("NodeTypeItem Safety Stock Search verified");

	}

/*	@Test(enabled = false, priority = 3, description = "to Verify Safety stock is searched through Node Item Attribute in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByNodeItemAttribute() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item Attribute");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(2);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(),
				"No Safety Stock Found by NodeItemAttribute Search");
		logger.info("NodeItemAttribute Safety Stock Search verified");
	}

	@Test(enabled = false, priority = 4, description = "to Verify Safety stock is searched through Node Type Item Attribute in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByNodeTypeItemAttribute() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node type Item Attribute");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(3);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(),
				"No Safety Stock Found by NodeTypeItemAttribute Search");
		logger.info("NodeTypeItemAttribute Safety Stock Search verified");

	}

	@Test(enabled = false, priority = 5, description = "to Verify Safety stock is searched through Global  Node Type in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByGlobalNodeType() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Global  Node Type");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(4);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(),
				"No Safety Stock Found by GlobalNodeType search");
		logger.info("GlobalNodeType Safety Stock Search verified");
	}

	@Test(enabled = false, priority = 6, description = "to Verify Safety stock is searched through Global  Supply Type in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByGlobalSupplyType() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Global  Supply Type");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(5);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(),
				"No Safety Stock Found by Global  Supply Type search");
		logger.info("Global  Supply Type Safety Stock Search verified");
	}

	@Test(enabled = false, priority = 7, description = "to Verify Safety stock is searched through Aggregated Global in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByAggregatedGlobal() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Aggregated Global");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(6);
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(),
				"No Safety Stock Found by Aggregated Global search");
		logger.info(" Aggregated Global Safety Stock Search verified");
	}
*/
	@Test(enabled = false, priority = 10, description = "to Verify Safety stock is searched through Node Item & Fulfillment type & supply type in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByNodeItem() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStockByNodeItemFulfillType(0, 0, 2,0);
		logger.info("Safety Stock Search by NODE ITEM,FULFILLMENT TYPE,SUPPLY TYPE verified");
	}

	@Test(enabled = true, priority = 8, description = "to Verify add Safety stock through Node Item & Fulfillment type & supply type in Manage Safety Stock Configuration page")
	public void testAddSafetyStockByNodeItem() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock add through Node Item");
		romuipages.safetyStockConfigsPage().addSafetyStock(0, 0, 2, 0, 1, 0);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_ADD.getMessage(), "Safety Stock for Node item not added successfully");
		logger.info("Safety Stock add by NODE ITEM verified");
	}
	
	@Test(enabled = true, priority = 9, description = "to Verify edit Safety stock through Node Item & Fulfillment type & supply type in Manage Safety Stock Configuration page")
	public void testEditSafetyStockByNodeItem() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStockByNodeItemFulfillType(0, 0, 2,0);
		logger.info("Safety Stock Search by NODE ITEM verified");
		logger.info("Verify Safety stock edit through Node Item");
		romuipages.safetyStockConfigsPage().editSafetyStock();
	   Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_EDIT.getMessage(), "Safety Stock for Node item not EDITED successfully");
		logger.info("Safety Stock edit by NODE ITEM verified");
	}
	@Test(enabled = true, priority = 10, description = "to Verify delete Safety stock through Node Item in Manage Safety Stock Configuration page")
	public void testDeleteSafetyStockByNodeItem() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStockByNodeItemFulfillType(0, 0, 2,0);
		logger.info("Safety Stock Search by NODE ITEM verified");
		logger.info("Verify delete Safety stock through Node Item");
		romuipages.safetyStockConfigsPage().deleteSafetyStock();
	   Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_DELETE.getMessage(), "Safety Stock for Node item is not Deleted successfully");
		logger.info("Delete Safety Stock by NODE ITEM verified");
	}


	@Test(enabled = false, priority = 10, description = "to Verify add Safety stock through Node Type Item in Manage Safety Stock Configuration page")
	public void testaddSafetyStockByNodeTypeItem() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock add through Node Item");
		romuipages.safetyStockConfigsPage().addSafetyStock(1, 1, 2, 3, 2, 0);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_ADD.getMessage(), "Safety Stock for Node type item not added successfully");
		logger.info("Safety Stock add by NODE TYPE ITEM verified");
	}

	@Test(enabled = false, priority = 11, description = "to Verify add Safety stock through NODE ITEM ATTRIBUTE & Fulfillment type & supply type in Manage Safety Stock Configuration page")
	public void testaddSafetyStockByNodeItemAttribute() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock add through Node Item");
		romuipages.safetyStockConfigsPage().addSafetyStock(2, 2, 3, 0, 2, 0);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_ADD.getMessage(), "Safety Stock for Node type item not added successfully");
		logger.info("Safety Stock add by NODE ITEM ATTRIBUTEE verified");
	}

	@Test(enabled = false, priority = 12, description = "to Verify add Safety stock through NODE TYPE ITEM ATTRIBUTE & Fulfillment type & supply type in Manage Safety Stock Configuration page")
	public void testaddSafetyStockByNodeTypeItemAttribute() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock add through Node Item");
		romuipages.safetyStockConfigsPage().addSafetyStock(3, 1, 4, 3, 2, 1);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_ADD.getMessage(), "Safety Stock for Node type item not added successfully");
		logger.info("Safety Stock add by NODE TYPE ITEM ATTRIBUTE verified");
	}

	@Test(enabled = false, priority = 13, description = "to Verify add Safety stock through GLOBAL NODE TYPE & Fulfillment type & supply type in Manage Safety Stock Configuration page")
	public void testaddSafetyStockByGLOBALNODETYPE() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock add through Node Item");
		romuipages.safetyStockConfigsPage().addSafetyStock(4, 0, 1, 1, 1, 0);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_ADD.getMessage(), "Safety Stock for Node type item not added successfully");
		logger.info("Safety Stock add by GLOBAL NODE TYPE verified");
	}

	@Test(enabled = false, priority = 14, description = "to Verify add Safety stock through GLOBAL SUPPLY TYPE & Fulfillment type & supply type in Manage Safety Stock Configuration page")
	public void testaddSafetyStockByGLOBALSUPPLYTYPE() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock add through Node Item");
		romuipages.safetyStockConfigsPage().addSafetyStock(5, 0, 2, 0, 1, 0);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_ADD.getMessage(), "Safety Stock for Node type item not added successfully");
		logger.info("Safety Stock add by GLOBAL SUPPLY TYPE verified");
	}

	@Test(enabled = false, priority = 15, description = "to Verify add Safety stock through AGGREGRATED GLOBAL in Manage Safety Stock Configuration page")
	public void testaddSafetyStockByAGGREGRATEDGLOBAL() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock add through Node Item");
		romuipages.safetyStockConfigsPage().addSafetyStock(6, 0, 0, 0, 1, 0);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_ADD.getMessage(), "Safety Stock for Node type item not added successfully");
		logger.info("Safety Stock add by AGGREGRATED GLOBAL verified");
	}

}
