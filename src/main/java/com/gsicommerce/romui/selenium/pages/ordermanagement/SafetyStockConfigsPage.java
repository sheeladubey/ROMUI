package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.common.ROMUIPageFactory;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.InventoryAvailabilityData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class SafetyStockConfigsPage {
	WebDriver driver;
	Environment env;
	private InventoryAvailabilityData inventoryAvailabilityData;
	
	public SafetyStockConfigsPage(WebDriver driver, Environment env)
	{
		this.driver=driver;
		this.env=env;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS ,using="#store_fulfillment_safety_stock_search_type")
	private WebElement drpdwnType;
	
	@FindBy(how = How.CSS ,using="#store_fulfillment_safety_stock_search_item_id")
	private WebElement txtboxItemId;
	
	@FindBy(how = How.CSS ,using="#ss-search-node-id")
	private WebElement txtboxNodeId;
	
	@FindBy(how = How.CSS ,using="#store_fulfillment_safety_stock_search_fulfillment_type")
	private WebElement drpdwnFulfillType;
	
	@FindBy(how = How.CSS ,using="#store_fulfillment_safety_stock_search_supply_type")
	private WebElement drpdwnSupplyType;
	
	@FindBy(how = How.CSS ,using="#store_fulfillment_safety_stock_search_node_type")
	private WebElement drpdwnNodeType;
	
	@FindBy(how = How.CSS ,using=".pagination-heading")
	private WebElement headerSafetyStock;
	
	@FindBy(how = How.CSS, using = ".alert-info")
	private WebElement txtSuccessMsg;
	
	@FindBy(how = How.CSS ,using="[type='submit'][data-filter-submit-button='']")
	private WebElement btnSearch;
	
	public void searchSafetyStockByNodeItemFulfillType(int indexType,int indexFulfillType,int indexSuppyType) throws Exception
	{
		inventoryAvailabilityData =InventoryAvailabilityData.get(env.getFileLocation());
		CommonElementsPage.clickOnSearchIcon();
		Action.waitForElementToBeClickable(driver, drpdwnType, 10);
		Action.selectByVisibleText(drpdwnType, inventoryAvailabilityData.getChoose_a_Type().get(indexType));
		Action.enter(txtboxItemId, inventoryAvailabilityData.getItemId());
		Action.enter(txtboxNodeId, inventoryAvailabilityData.getNodeId());
		Action.selectByVisibleText(drpdwnFulfillType, inventoryAvailabilityData.getFulfillment_Type_Id().get(indexFulfillType));
		Action.selectByVisibleText(drpdwnSupplyType, inventoryAvailabilityData.getSupply_Type_Id().get(indexSuppyType));
		Action.waitForElementToBeClickable(driver, btnSearch, 10);
		Action.clickUsingJavaScipt(btnSearch);
		int rowSS=CommonElementsPage.getRowNo(inventoryAvailabilityData.getItemId());
		Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowSS, 1), inventoryAvailabilityData.getItemId(),
						"No Safety Stock Found by Node item Search ");
	}
	
	public void searchSafetyStockByType(int indexType) throws Exception
	{
		inventoryAvailabilityData =InventoryAvailabilityData.get(env.getFileLocation());
		CommonElementsPage.clickOnSearchIcon();
		Action.waitForElementToBeClickable(driver, drpdwnType, 10);
		Action.selectByVisibleText(drpdwnType, inventoryAvailabilityData.getChoose_a_Type().get(indexType));
		Action.waitForElementToBeClickable(driver, btnSearch, 20);
		Action.clickUsingJavaScipt(btnSearch);
	}
	
	
	public boolean verfiySafetyStockRecord() throws Exception
	{
		boolean found = false;
		int rowNo = CommonElementsPage.getTotalRows();
		if (headerSafetyStock.getText().contains("Safety Stocks Found") && (rowNo > 0) ) {
			found = true;
		}else {
			Assert.assertTrue(txtSuccessMsg.getText().contains(RomuiEnumValues.SAFETYSTOCK_NOTFOUND.getMessage()),"No search found");
		}
		return found;
		
	}

}
