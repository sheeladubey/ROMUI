package com.gsicommerce.romui.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class SafetyStockConfigsTests extends ROMUIBasePage {

	@Test(enabled = true, priority = 1, description = "to Verify add Safety stock through Node Item in Manage Safety Stock Configuration page")
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

	@Test(enabled = true, priority = 2, description = "to Verify edit Safety stock through Node Item in Manage Safety Stock Configuration page")
	public void testEditSafetyStockByNodeItem() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStock(0, 0, 2, 0, 0);
		logger.info("Safety Stock Search by NODE ITEM verified");
		logger.info("Verify Safety stock edit through Node Item");
		romuipages.safetyStockConfigsPage().editSafetyStock(0);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_EDIT.getMessage(), "Safety Stock for Node item not EDITED successfully");
		logger.info("Safety Stock edit by NODE ITEM verified");
	}

//	@Test(enabled = true, priority = 3, description = "to Verify Safety stock is searched through Node Item in Manage Safety Stock Configuration page")
//	public void testSafetyStockSearchByNodeItem() throws Exception {
//
//		logger.info("Login credentials to be entered");
//		romuipages.loginPage().login(env.getUserName(), env.getPassword());
//		// romuipages.homePage().clickOnLandingButton("Order Management");
//		logger.info("Navigate to Manage Safety Stock Configuration page");
//		romuipages.orderMgmPage().clickOnSafetyStockConfig();
//		logger.info("Verify Safety stock is searched through Node Item");
//		romuipages.safetyStockConfigsPage().searchSafetyStock(0, 0, 2, 0, 0);
//		logger.info("Safety Stock Search by NODE ITEM,FULFILLMENT TYPE,SUPPLY TYPE verified");
//	}

	@Test(enabled = true, priority = 4, description = "to Verify delete Safety stock through Node Item in Manage Safety Stock Configuration page")
	public void testDeleteSafetyStockByNodeItem() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStock(0, 0, 2, 0, 0);
		logger.info("Safety Stock Search by NODE ITEM verified");
		logger.info("Verify delete Safety stock through Node Item");
		romuipages.safetyStockConfigsPage().deleteSafetyStock(0);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_DELETE.getMessage(),
				"Safety Stock for Node item is not Deleted successfully");
		logger.info("Delete Safety Stock by NODE ITEM verified");
	}

	@Test(enabled = true, priority = 5, description = "to Verify add Safety stock through Node Type Item in Manage Safety Stock Configuration page")
	public void testaddSafetyStockByNodeTypeItem() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock add through Node Type Item");
		romuipages.safetyStockConfigsPage().addSafetyStock(1, 1, 2, 3, 2, 0);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_ADD.getMessage(), "Safety Stock for Node type item not added successfully");
		logger.info("Safety Stock add by NODE TYPE ITEM verified");
	}

	@Test(enabled = true, priority = 6, description = "to Verify edit Safety stock through Node type Item in Manage Safety Stock Configuration page")
	public void testEditSafetyStockByNodeTypeItem() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Type Item");
		romuipages.safetyStockConfigsPage().searchSafetyStock(1, 1, 2, 3, 0);
		logger.info("Safety Stock Search by Node Type Item verified");
		logger.info("Verify Safety stock edit through Node Type Item");
		romuipages.safetyStockConfigsPage().editSafetyStock(1);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_EDIT.getMessage(),
				"Safety Stock for Node Type item not EDITED successfully");
		logger.info("Safety Stock edit by NODE  TYPE ITEM verified");
	}

	@Test(enabled = true, priority = 7, description = "to Verify delete Safety stock through Node type Item in Manage Safety Stock Configuration page")
	public void testDeleteSafetyStockByNodeTypeItem() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Type Item");
		romuipages.safetyStockConfigsPage().searchSafetyStock(1, 1, 2, 3, 0);
		logger.info("Safety Stock Search by Node Type Item verified");
		logger.info("Verify delete Safety stock through Node Type Item");
		romuipages.safetyStockConfigsPage().deleteSafetyStock(1);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_DELETE.getMessage(),
				"Safety Stock for Node TYPE item is not Deleted successfully");
		logger.info("Delete Safety Stock by NODE TYPE ITEM verified");
	}

	@Test(enabled = true, priority = 8, description = "to Verify add Safety stock through NODE ITEM ATTRIBUTE in Manage Safety Stock Configuration page")
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

	@Test(enabled = true, priority = 9, description = "to Verify edit Safety stock through NodeItemAttribute in Manage Safety Stock Configuration page")
	public void testEditSafetyStockByNodeItemAttribute() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStock(2, 2, 3, 0, 0);
		logger.info("Safety Stock Search by NODE ITEM verified");
		logger.info("Verify Safety stock edit through Node Item");
		romuipages.safetyStockConfigsPage().editSafetyStock(2);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_EDIT.getMessage(),
				"Safety Stock for NodeItemAttributeNode Type item not EDITED successfully");
		logger.info("Safety Stock edit by NodeItemAttribute verified");
	}

	@Test(enabled = true, priority = 10, description = "to Verify delete Safety stock through NodeItemAttributeNode in Manage Safety Stock Configuration page")
	public void testDeleteSafetyStockByNodeItemAttribute() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStock(2, 2, 3, 0, 0);
		logger.info("Safety Stock Search by NodeItemAttributeNode verified");
		logger.info("Verify delete Safety stock through Node Item");
		romuipages.safetyStockConfigsPage().deleteSafetyStock(2);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_DELETE.getMessage(),
				"Safety Stock for NodeItemAttributeNode is not Deleted successfully");
		logger.info("Delete Safety Stock by NodeItemAttributeNode verified");
	}

	@Test(enabled = true, priority = 11, description = "to Verify add Safety stock through NODE TYPE ITEM ATTRIBUTE in Manage Safety Stock Configuration page")
	public void testaddSafetyStockByNodeTypeItemAttribute() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock add through NODE TYPE ITEM ATTRIBUTE");
		romuipages.safetyStockConfigsPage().addSafetyStock(3, 1, 4, 3, 2, 1);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_ADD.getMessage(),
				"Safety Stock for NODE TYPE ITEM ATTRIBUTE not added successfully");
		logger.info("Safety Stock add by NODE TYPE ITEM ATTRIBUTE verified");
	}

	@Test(enabled = true, priority = 12, description = "to Verify edit Safety stock through NodeTypeItemAttribute in Manage Safety Stock Configuration page")
	public void testEditSafetyStockByNodeTypeItemAttribute() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through NodeTypeItemAttribute");
		romuipages.safetyStockConfigsPage().searchSafetyStock(3, 1, 4, 3, 1);
		logger.info("Safety Stock Search by NodeTypeItemAttribute verified");
		logger.info("Verify Safety stock edit through NodeTypeItemAttribute");
		romuipages.safetyStockConfigsPage().editSafetyStock(3);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_EDIT.getMessage(),
				"Safety Stock for NodeTypeItemAttribute Type item not EDITED successfully");
		logger.info("Safety Stock edit by NodeTypeItemAttribute verified");
	}

	@Test(enabled = true, priority = 13, description = "to Verify delete Safety stock through NodeTypeItemAttribute in Manage Safety Stock Configuration page")
	public void testDeleteSafetyStockByNodeTypeItemAttribute() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through NodeTypeItemAttribute");
		romuipages.safetyStockConfigsPage().searchSafetyStock(3, 1, 4, 3, 1);
		logger.info("Safety Stock Search by NodeTypeItemAttribute verified");
		logger.info("Verify delete Safety stock through NodeTypeItemAttribute");
		romuipages.safetyStockConfigsPage().deleteSafetyStock(3);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_DELETE.getMessage(),
				"Safety Stock for NodeTypeItemAttribute is not Deleted successfully");
		logger.info("Delete Safety Stock by NodeTypeItemAttribute verified");
	}

	@Test(enabled = true, priority = 14, description = "to Verify add Safety stock through GLOBAL NODE TYPE & Fulfillment type & supply type in Manage Safety Stock Configuration page")
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

	@Test(enabled = true, priority = 15, description = "to Verify edit Safety stock through GLOBALNODETYPE in Manage Safety Stock Configuration page")
	public void testEditSafetyStockByGLOBALNODETYPE() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStock(4, 0, 1, 1, 0);
		logger.info("Safety Stock Search by GLOBALNODETYPE verified");
		logger.info("Verify Safety stock edit through Node Item");
		romuipages.safetyStockConfigsPage().editSafetyStock(4);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_EDIT.getMessage(),
				"Safety Stock for GLOBALNODETYPE Type item not EDITED successfully");
		logger.info("Safety Stock edit by GLOBALNODETYPE verified");
	}

	@Test(enabled = true, priority = 16, description = "to Verify delete Safety stock through GLOBALNODETYPE in Manage Safety Stock Configuration page")
	public void testDeleteSafetyStockByGLOBALNODETYPE() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item");
		romuipages.safetyStockConfigsPage().searchSafetyStock(4, 0, 1, 1, 0);
		logger.info("Safety Stock Search by NodeTypeItemAttribute verified");
		logger.info("Verify delete Safety stock through Node Item");
		romuipages.safetyStockConfigsPage().deleteSafetyStock(4);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_DELETE.getMessage(),
				"Safety Stock for NodeTypeItemAttribute is not Deleted successfully");
		logger.info("Delete Safety Stock by NodeTypeItemAttribute verified");
	}

	@Test(enabled = true, priority = 17, description = "to Verify add Safety stock through GLOBAL SUPPLY TYPE in Manage Safety Stock Configuration page")
	public void testaddSafetyStockByGLOBALSUPPLYTYPE() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock add through GLOBAL SUPPLY TYPE");
		romuipages.safetyStockConfigsPage().addGlobal_AggregatedGlobalType(5, 2, 1);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_ADD.getMessage(),
				"Safety Stock for GLOBAL SUPPLY TYPE not added successfully");
		logger.info("Safety Stock add by GLOBAL SUPPLY TYPE verified");
		romuipages.safetyStockConfigsPage().searchGlobal_AggregatedGlobalType(5, 2, 0);

	}

	@Test(enabled = true, priority = 18, description = "to Verify edit Safety stock through GLOBALSUPPLYTYPE in Manage Safety Stock Configuration page")
	public void testEditSafetyStockByGLOBALSUPPLYTYPE() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through GLOBALSUPPLYTYPE");
		romuipages.safetyStockConfigsPage().searchGlobal_AggregatedGlobalType(5, 2, 0);
		logger.info("Safety Stock Search by GLOBALSUPPLYTYPE verified");
		logger.info("Verify Safety stock edit through GLOBALSUPPLYTYPE");
		romuipages.safetyStockConfigsPage().editSafetyStock(5);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_EDIT.getMessage(),
				"Safety Stock for GLOBALSUPPLYTYPE Type item not EDITED successfully");
		logger.info("Safety Stock edit by GLOBALSUPPLYTYPE verified");
	}

	@Test(enabled = true, priority = 19, description = "to Verify delete Safety stock through GLOBALSUPPLYTYPE in Manage Safety Stock Configuration page")
	public void testDeleteSafetyStockByGLOBALSUPPLYTYPE() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through GLOBALSUPPLYTYPE");
		romuipages.safetyStockConfigsPage().searchGlobal_AggregatedGlobalType(5, 2, 0);
		logger.info("Safety Stock Search by GLOBALSUPPLYTYPE verified");
		logger.info("Verify delete Safety stock through GLOBALSUPPLYTYPE");
		romuipages.safetyStockConfigsPage().deleteSafetyStock(5);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_DELETE.getMessage(),
				"Safety Stock for GLOBALSUPPLYTYPE is not Deleted successfully");
		logger.info("Delete Safety Stock by GLOBALSUPPLYTYPE verified");
	}

	@Test(enabled = true, priority = 20, description = "to Verify add Safety stock through AGGREGRATED GLOBAL in Manage Safety Stock Configuration page")
	public void testaddSafetyStockByAGGREGRATEDGLOBAL() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock add through AGGREGRATED GLOBAL Type");
		romuipages.safetyStockConfigsPage().addGlobal_AggregatedGlobalType(6, 0, 1);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_ADD.getMessage(),
				"Safety Stock for AGGREGRATED GLOBAL type item not added successfully");
		logger.info("Safety Stock add by AGGREGRATED GLOBAL verified");
		//romuipages.safetyStockConfigsPage().searchGlobal_AggregatedGlobalType(6, 0, 0);
	}

	@Test(enabled = true, priority = 21, description = "to Verify edit Safety stock through AGGREGRATEDGLOBAL in Manage Safety Stock Configuration page")
	public void testEditSafetyStockByAGGREGRATEDGLOBAL() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through AGGREGRATED GLOBAL");
		// romuipages.safetyStockConfigsPage().searchSafetyStock(6, 0, 0, 0, 0);
		romuipages.safetyStockConfigsPage().searchGlobal_AggregatedGlobalType(6, 0, 1);
		logger.info("Safety Stock Search by AGGREGRATEDGLOBAL verified");
		logger.info("Verify Safety stock edit through AGGREGRATED GLOBAL");
		romuipages.safetyStockConfigsPage().editSafetyStock(6);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_EDIT.getMessage(),
				"Safety Stock for AGGREGRATEDGLOBAL Type item not EDITED successfully");
		logger.info("Safety Stock edit by AGGREGRATEDGLOBAL verified");
	}

	@Test(enabled = true, priority = 22, description = "to Verify delete Safety stock through AGGREGRATEDGLOBAL in Manage Safety Stock Configuration page")
	public void testDeleteSafetyStockByAGGREGRATEDGLOBAL() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through AGGREGRATED GLOBAL");
		romuipages.safetyStockConfigsPage().searchGlobal_AggregatedGlobalType(6, 0, 1);
		logger.info("Safety Stock Search by AGGREGRATEDGLOBAL verified");
		logger.info("Verify delete Safety stock through AGGREGRATED GLOBAL");
		romuipages.safetyStockConfigsPage().deleteSafetyStock(6);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SAFETYSTOCK_DELETE.getMessage(),
				"Safety Stock for AGGREGRATEDGLOBAL is not Deleted successfully");
		logger.info("Delete Safety Stock by AGGREGRATEDGLOBAL verified");
	}

	@Test(enabled = true, priority = 23, description = "to Verify Safety stock is searched through type in Manage Safety Stock Configuration page")
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

	@Test(enabled = true, priority = 24, description = "to Verify Safety stock is searched through Node Item in Manage Safety Stock Configuration page")
	public void testSafetyStockSearchByNodeItem() throws Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Navigate to Manage Safety Stock Configuration page");
		romuipages.orderMgmPage().clickOnSafetyStockConfig();
		logger.info("Verify Safety stock is searched through Node Item ");
		romuipages.safetyStockConfigsPage().searchSafetyStockByType(0);
		logger.info("NodeItem Safety Stock Search verified");
		Assert.assertTrue(romuipages.safetyStockConfigsPage().verfiySafetyStockRecord(),
				"No Safety Stock Found by Node Item search");
		logger.info("Node Item Safety Stock Search verified");
	}

	@Test(enabled = true, priority = 25, description = "to Verify Safety stock is searched through Node Type Item  in Manage Safety Stock Configuration page")
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

	@Test(enabled = true, priority = 26, description = "to Verify Safety stock is searched through Node Item Attribute in Manage Safety Stock Configuration page")
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

	@Test(enabled = true, priority = 27, description = "to Verify Safety stock is searched through Node Type Item Attribute in Manage Safety Stock Configuration page")
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

	@Test(enabled = true, priority = 28, description = "to Verify Safety stock is searched through Global  Node Type in Manage Safety Stock Configuration page")
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

	@Test(enabled = true, priority = 29, description = "to Verify Safety stock is searched through Global  Supply Type in Manage Safety Stock Configuration page")
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

	@Test(enabled = true, priority = 30, description = "to Verify Safety stock is searched through Aggregated Global in Manage Safety Stock Configuration page")
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

}
