package com.gsicommerce.romui.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.testdata.CatalogInventorySearchData;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class InventorySearchTests extends ROMUIBasePage {

	private CatalogInventorySearchData data;

	@Test(enabled = true, priority = 1, description = "to Verify Add Inventory for itemID Search")
	public void testAddInventoryforItemSearch() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnInventorySearch();
		logger.info("Item for which inventory to be added:" + data.getItemID());
		romuipages.inventorySearchPage().addInventory(data, data.getClientItemID());
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.INVENTORY_ADD.getMessage(), "Inventory is not added successfully");
	}

	@Test(enabled = true, priority = 2, description = "to Verify Add Inventory for productID Search")
	public void testAddInventoryforProductIDSearch() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnInventorySearch();
		logger.info("Item for which inventory to be added:" + data.getProductID());
		romuipages.inventorySearchPage().addInventory(data, data.getProductID());
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.INVENTORY_ADD.getMessage(), "Inventory is not added successfully");
	}

	@Test(enabled = true, priority = 3, description = "to Verify Add Inventory for styleID Search")
	public void testAddInventoryforStyleIDSearch() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnInventorySearch();
		logger.info("Item for which inventory to be added:" + data.getStyleID());
		romuipages.inventorySearchPage().addInventory(data, data.getStyleID());
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.INVENTORY_ADD.getMessage(), "Inventory is not added successfully");
	}

	@Test(enabled = true, priority = 4, description = "to Verify Add Inventory for Status Search")
	public void testAddInventoryforStatusSearch() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnInventorySearch();
		logger.info("Status for which inventory to be added:" + data.getStatus());
		romuipages.inventorySearchPage().addInventory(data, "Active");
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.INVENTORY_ADD.getMessage(), "Inventory is not added successfully");
	}

	@Test(enabled = true, priority = 5, description = "to Verify Add Inventory for multiple selection of options")
	public void testAddInventoryForMultipleSelection() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnInventorySearch();
		logger.info("Selection of Items for which inventory to be added:");
		romuipages.inventorySearchPage().addInventory(data, "multiple");
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.INVENTORY_ADD.getMessage(), "Inventory is not added successfully");
	}

	@Test(enabled = true, priority = 6, description = "to Verify different options of Inventory search")
	public void testVerifyInventorySearch() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnInventorySearch();
		logger.info("Validate error alert message for blank ItemID Search");
		romuipages.inventorySearchPage().searchForInventory(data, null, null, null, null);
		Assert.assertEquals(romuipages.commonElePage().txtAlertErrorMsg.getText(),
				RomuiEnumValues.FORM_ERROR.getMessage(), "No error message displayed for blank mandatory field");
		logger.info("Search for ItemID:" + data.getItemID());
		romuipages.inventorySearchPage().searchForInventory(data, data.getItemID(), null, null, null);
		Assert.assertTrue(romuipages.inventorySearchPage().verifySearch(1, 1, data.getNodeID()),
				"No data found for the search by ItemID:" + data.getItemID() + "");
		logger.info("Search for nodeList:" + data.getNodeID());
		romuipages.inventorySearchPage().searchForInventory(data, data.getItemID(), data.getNodeID(), null, null);
		Assert.assertTrue(romuipages.inventorySearchPage().verifySearch(1, 1, data.getNodeID()),
				"No data found for the search by NodeID:" + data.getNodeID() + "");
		logger.info("Search for node type:" + data.getNodeType());
		romuipages.inventorySearchPage().searchForInventory(data, data.getItemID(), null, data.getNodeType(), null);
		Assert.assertTrue(romuipages.inventorySearchPage().verifySearch(1, 1, data.getNodeID()),
				"No data found for the search by Node Type:" + data.getNodeID() + "");
		logger.info("Search for Supply type:" + data.getSupplyType());
		romuipages.inventorySearchPage().searchForInventory(data, data.getItemID(), null, null, data.getSupplyType());
		Assert.assertTrue(romuipages.inventorySearchPage().verifySearch(1, 1, data.getNodeID()),
				"No data found for the search by Supply Type:" + data.getNodeID() + "");
		logger.info("Search for All Options");
		romuipages.inventorySearchPage().searchForInventory(data, data.getItemID(), data.getNodeID(),
				data.getNodeType(), data.getSupplyType());
		Assert.assertTrue(romuipages.inventorySearchPage().verifySearch(1, 1, data.getNodeID()),
				"No data found for the search by all types:" + data.getNodeID() + "");

	}

	@Test(enabled = true, priority = 7, description = "to Verify Adjust Inventory")
	public void testVerifyAjustInventory() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnInventorySearch();
		logger.info("Search for All Options");
		romuipages.inventorySearchPage().searchForInventory(data, data.getItemID(), data.getNodeID(),
				data.getNodeType(), data.getSupplyType());
		romuipages.inventorySearchPage().adjustInventory(data);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.INVENTORY_ADJUST.getMessage(), "Inventory is not adjusted successfully");
	}

	@Test(enabled = true, priority = 8, description = "to Verify Move Inventory")
	public void testVerifyMoveInventory() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnInventorySearch();
		logger.info("Search for All Options");
		romuipages.inventorySearchPage().searchForInventory(data, data.getItemID(), data.getNodeID(),
				data.getNodeType(), data.getSupplyType());
		romuipages.inventorySearchPage().moveInventory(data);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.INVENTORY_MOVE.getMessage(), "Inventory is not adjusted successfully");
	}

	@Test(enabled = true, priority = 9, description = "to Verify view Audit for inventory")
	public void testVerifyViewAudit() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnInventorySearch();
		logger.info("Search for All Options");
		romuipages.inventorySearchPage().searchForInventory(data, data.getItemID(), data.getNodeID(),
				data.getNodeType(), data.getSupplyType());
		Assert.assertTrue(romuipages.inventorySearchPage().viewAudits(data),
				"view Audit for inventory is not successful");
		;
	}
}
