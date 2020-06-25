package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.CommonElementsPage;
import com.gsicommerce.romui.selenium.testdata.CatalogInventorySearchData;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class ItemSearchTests extends ROMUIBasePage {

	private CatalogInventorySearchData data;
	private final String clientItemID = Common.generateRandomID("UIAuto");

	@Test(enabled = true, priority = 1, description = "to Verify for add item")
	public void testAddItem() throws JsonParseException, JsonMappingException, IOException {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnItemSearch();
		logger.info("Item to be added:" + clientItemID);
		romuipages.itemSearchPage().addItem(data, clientItemID);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.ITEM_ADD.getMessage(), "Item is not added successfully");
	}

	@Test(enabled = true, priority = 2, description = "to Verify & validate Edit item")
	public void testEditItem() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnItemSearch();
		logger.info("Item to be edited:" + clientItemID);
		romuipages.itemSearchPage().searchForItem(clientItemID, "clientItemID");
		romuipages.itemSearchPage().editItem(data);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.ITEM_EDIT.getMessage(), "Item is not updated successfully");
		romuipages.itemSearchPage().searchForItem(clientItemID, "clientItemID");
		Assert.assertEquals(romuipages.itemSearchPage().txtItemSummaryDescrp.getText(),
				"Auto - " + data.getItemDescrp(), "Item " + clientItemID + " description is not updated");

	}

	@Test(enabled = true, priority = 3, description = "to Verify & validate View item")
	public void testViewItem() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnItemSearch();
		logger.info("Item to be searched:" + clientItemID);
		romuipages.itemSearchPage().searchForItem(clientItemID, "clientItemID");
		logger.info("Clicking on View icon for the item to be viewed");
		CommonElementsPage.clickSingleRowActionsIcon(4, 1);
		logger.info("Validate Item Description:" + "Auto - " + data.getItemDescrp());
		Assert.assertTrue(romuipages.itemSearchPage().verifyViewItem(1, "Auto - " + data.getItemDescrp()),
				"No data found for Description");
		logger.info("Validate Item Color, Size or Style:");
		String expected = "" + data.getColorDescrp() + ", " + data.getSizeCode() + ", " + data.getStyleDescrp() + "";
		Assert.assertTrue(romuipages.itemSearchPage().verifyViewItem(1, expected),
				"No data found for Color,Size or Style");
		logger.info("Validate Item ID:" + clientItemID);
		Assert.assertTrue(romuipages.itemSearchPage().verifyViewItem(1, clientItemID), "No data found for Item ID");
		logger.info("Validate Status:" + data.getStatus());
		if (data.getStatus().contains("active")) {
			expected = "Active";
		} else if (data.getStatus().contains("inactive")) {
			expected = "Inactive";
		} else {
			expected = "Discontinued";
		}
		Assert.assertTrue(romuipages.itemSearchPage().verifyViewItem(2, expected), "No data found for Status");
		logger.info("Validate Style ID:" + data.getStyleID());
		Assert.assertTrue(romuipages.itemSearchPage().verifyViewItem(2, data.getStyleID()),
				"No data found for StyleID");
		logger.info("Validate Network Override:" + data.getSourcingOverride());
		Assert.assertTrue(romuipages.itemSearchPage().verifyViewItem(3, data.getSourcingOverride()),
				"No data found for Network Override");
		logger.info("Validate Network Preference:" + data.getSourcingPreference());
		Assert.assertTrue(romuipages.itemSearchPage().verifyViewItem(3, data.getSourcingPreference()),
				"No data found for Network Preference");
		logger.info("Validate Fulfillment Eligibility:");
		Assert.assertTrue(
				romuipages.itemSearchPage().verifyViewItem(3,
						"Ship-from Store, In-Store Pick Up, Ship-to Store, Drop Ship"),
				"No data found for Fulfillment Eligibility");

	}

	@Test(enabled = true, priority = 4, description = "to Verify for valid client itemID search")
	public void testValidClientItemIDSearch() throws Exception {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnItemSearch();
		logger.info("Search for clientItemID:" + clientItemID);
		romuipages.itemSearchPage().searchForItem(clientItemID, "clientItemID");
		Assert.assertTrue(romuipages.itemSearchPage().verifySearch(1, 1, clientItemID),
				"No data found for the search by clientItemID:" + clientItemID + "");
	}

	@Test(enabled = true, priority = 5, description = "to Verify for valid Product ID search")
	public void testValidProductIDSearch() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnItemSearch();
		String productID = data.getProductID();
		logger.info("Search for productID:" + productID);
		romuipages.itemSearchPage().searchForItem(productID, "productID");
		Assert.assertTrue(romuipages.itemSearchPage().verifySearch(1, 1, data.getProductTitle()),
				"No data found for the search by productID:" + productID + "");
	}

	@Test(enabled = true, priority = 6, description = "to Verify for valid Item search by Status")
	public void testValidItemSearchByStatus() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnItemSearch();
		logger.info("Search for Status:" + data.getStatus());
		romuipages.itemSearchPage().searchForItem(data.getStatus(), "status");
		Assert.assertTrue(romuipages.itemSearchPage().verifySearch(1, 3, "Active"),
				"No data found for the search by Status as:" + data.getStatus() + "");
	}

	@Test(enabled = true, priority = 7, description = "to Verify for valid search by selecting all options")
	public void testValidSearchByAllOptions() throws Exception {
		data = CatalogInventorySearchData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		// romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnItemSearch();
		logger.info("Search for All Options");
		romuipages.itemSearchPage().searchForMultipleOptions(data);
		Assert.assertTrue(romuipages.itemSearchPage().verifySearch(1, 1, data.getClientItemID()),
				"No data found for the search by all options");
		Assert.assertTrue(romuipages.itemSearchPage().verifySearch(1, 3, "Active"),
				"No data found for the search by all options");
	}
}
