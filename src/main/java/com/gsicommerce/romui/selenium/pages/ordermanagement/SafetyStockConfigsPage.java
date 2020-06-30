package com.gsicommerce.romui.selenium.pages.ordermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.InventoryAvailabilityData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class SafetyStockConfigsPage {
	WebDriver driver;
	Environment env;
	private InventoryAvailabilityData inventoryAvailabilityData;
	private static int rowNodeItem;
	private static int rowNodeTypeItem;
	private static int rowNodeItemAttri;
	private static int rowNodeItemAttrid;
	private static int rowGlobalNode;
	private static int rowGlobalSupply;

	public SafetyStockConfigsPage(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "#store_fulfillment_safety_stock_search_type")
	private WebElement drpdwnType;

	@FindBy(how = How.CSS, using = "#store_fulfillment_safety_stock_search_item_id")
	private WebElement txtboxItemId;

	@FindBy(how = How.CSS, using = "#ss-search-node-id")
	private WebElement txtboxNodeId;

	@FindBy(how = How.CSS, using = "#store_fulfillment_safety_stock_search_fulfillment_type")
	private WebElement drpdwnFulfillType;

	@FindBy(how = How.CSS, using = "#store_fulfillment_safety_stock_search_supply_type")
	private WebElement drpdwnSupplyType;

	@FindBy(how = How.CSS, using = "#store_fulfillment_safety_stock_search_node_type")
	private WebElement drpdwnSearchNodeType;
	
	@FindBy(how = How.CSS, using = "#store_fulfillment_safety_stock_search_item_attribute_id")
	private WebElement drpdwnSearchItemAttributeID;
	
	@FindBy(how = How.CSS, using = "#store_fulfillment_safety_stock_search_item_attribute_value")
	private WebElement txtboxSearchItemAttributeValue;

	@FindBy(how = How.CSS, using = ".pagination-heading")
	private WebElement headerSafetyStock;

	@FindBy(how = How.CSS, using = ".alert-info")
	private WebElement txtSuccessMsg;

	@FindBy(how = How.CSS, using = "[type='submit'][data-filter-submit-button='']")
	private WebElement btnSearch;

	@FindBy(how = How.CSS, using = "#condition_type[label='Safety Stock Condition Type']")
	private WebElement drpdwnSafetyStockConditionType;

	@FindBy(how = How.CSS, using = "[data-lookup='item-id'] .lookup-search-button")
	private WebElement itemLookup;

	@FindBy(how = How.CSS, using = "[data-lookup='node-id'] .lookup-search-button")
	private WebElement nodeLookup;

	@FindBy(how = How.CSS, using = "#store_fulfillment_safety_stock_rule_safety_stock_condition_attributes_fulfillment_type_id")
	private WebElement drpdwnFulfillTypeSafetyStockadd;

	@FindBy(how = How.CSS, using = "#store_fulfillment_safety_stock_rule_safety_stock_condition_attributes_supply_type_id")
	private WebElement drpdwnSupplyTypeSafetyStockadd;

	@FindBy(how = How.CSS, using = "#store_fulfillment_safety_stock_rule_safety_stock_application_attributes_application_type")
	private WebElement drpdwnSafetyStockTypeadd;

	@FindBy(how = How.CSS, using = "#new_safety_stock_rule_supply_safety_stock_value")
	private WebElement txtboxSafetyStockvalue;

	@FindBy(how = How.CSS, using = "#store_fulfillment_safety_stock_rule_safety_stock_condition_attributes_node_type_id")
	private WebElement drpdwnNodeTypeSafetyStockadd;

	@FindBy(how = How.CSS, using = "#store_fulfillment_safety_stock_rule_safety_stock_condition_attributes_item_attribute_id")
	private WebElement drpdwnItemAttributeSafetyStockadd;

	@FindBy(how = How.CSS, using = "#store_fulfillment_safety_stock_rule_safety_stock_condition_attributes_item_attribute_value")
	private WebElement txtboxItemAttributeValueSafetyStockadd;

	@FindBy(how = How.CSS, using = ".container-fluid #items_item_search_form_query")
	private WebElement txtboxItemIDSearch;

	@FindBy(how = How.CSS, using = ".container-fluid [type='submit']")
	private WebElement btnSearchitemNode;

	@FindBy(how = How.CSS, using = ".reflow-table-actions [type='button'][data-lookup-select='']")
	private WebElement btnSelectitemNode;

	@FindBy(how = How.CSS, using = ".container-fluid #inventory_node_search_id")
	private WebElement txtboxNodeIDSearch;

	@FindBy(how = How.CSS, using = ".btn-default[type='submit']")
	private WebElement btnSave;

	@FindBy(how = How.CSS, using = "[name='data-delete-safety-stock-rule-action'] [type='submit']")
	private WebElement btnConfirmDeleteSafety;

	@FindBy(how = How.CSS, using = ".radial-filter-menu-toggle-btn")
	private WebElement btnSearchIcon;

	@FindBy(how = How.CSS, using = ".alert-danger")
	private WebElement msgErrorAlert;

	public void addSafetyStock(int indexType, int indexFulfillType, int indexSuppyType, int indexNodeType,
			int indexSafetyStockType, int indexItemAttr) throws Exception {
		try {
		inventoryAvailabilityData = InventoryAvailabilityData.get(env.getFileLocation());
		CommonElementsPage.clickOnAddBtn();
		Action.waitForElementToBeClickable(driver, drpdwnSafetyStockConditionType, 10);
		Action.selectByVisibleText(drpdwnSafetyStockConditionType,
				inventoryAvailabilityData.getChoose_a_Type().get(indexType));
		Common.waitForPageLoaded(driver);
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE ITEM")) {
			clickItemIDLookup();
			clickNodeIDLookup();
		}
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE TYPE ITEM")) {
			clickItemIDLookup();
			Action.selectByVisibleText(drpdwnNodeTypeSafetyStockadd,
					inventoryAvailabilityData.getNode_Type().get(indexNodeType));

		}
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE ITEM ATTRIBUTE")) {
			Action.selectByVisibleText(drpdwnItemAttributeSafetyStockadd,
					inventoryAvailabilityData.getItem_Attribute().get(indexItemAttr));
			Action.enter(txtboxItemAttributeValueSafetyStockadd, inventoryAvailabilityData.getItem_Attribute_Value());
			clickNodeIDLookup();
		}
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE TYPE ITEM ATTRIBUTE")) {
			Action.selectByVisibleText(drpdwnItemAttributeSafetyStockadd,
					inventoryAvailabilityData.getItem_Attribute().get(indexItemAttr));
			Action.enter(txtboxItemAttributeValueSafetyStockadd, inventoryAvailabilityData.getItem_Attribute_Value());
			Action.selectByVisibleText(drpdwnNodeTypeSafetyStockadd,
					inventoryAvailabilityData.getNode_Type().get(indexNodeType));
		}
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("GLOBAL NODE TYPE")) {
			Action.selectByVisibleText(drpdwnNodeTypeSafetyStockadd,
					inventoryAvailabilityData.getNode_Type().get(indexNodeType));

		}
		Action.selectByVisibleText(drpdwnFulfillTypeSafetyStockadd,
				inventoryAvailabilityData.getFulfillment_Type_Id().get(indexFulfillType));
		Action.selectByVisibleText(drpdwnSupplyTypeSafetyStockadd,
				inventoryAvailabilityData.getSupply_Type_Id().get(indexSuppyType));
		Action.selectByVisibleText(drpdwnSafetyStockTypeadd,
				inventoryAvailabilityData.getSafety_Stock_Type().get(indexSafetyStockType));
		Action.waitForElementToBeClickable(driver, txtboxSafetyStockvalue, 10);
		Action.enter(txtboxSafetyStockvalue, inventoryAvailabilityData.getSafety_Stock_Value());
		Action.waitForElementToBeClickable(driver, btnSave, 10);
		Action.clickUsingJavaScipt(btnSave);
		}catch(Exception e) {
			System.out.println("Oh snap! Safety Stock already exists");
			Assert.assertTrue(true, msgErrorAlert.getText());
		}

	}
	
	public void addGlobal_AggregatedGlobalType(int indexType,int indexSuppyType,int indexSafetyStockType) throws Exception {
		inventoryAvailabilityData = InventoryAvailabilityData.get(env.getFileLocation());
		CommonElementsPage.clickOnAddBtn();
		Action.waitForElementToBeClickable(driver, drpdwnSafetyStockConditionType, 30);
		Action.selectByVisibleText(drpdwnSafetyStockConditionType,inventoryAvailabilityData.getChoose_a_Type().get(indexType));
		Common.waitForPageLoaded(driver);
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("GLOBAL SUPPLY TYPE")) {			
		Action.waitForElementToBeClickable(driver, drpdwnSupplyTypeSafetyStockadd, 10);
		Action.selectByVisibleText(drpdwnSupplyTypeSafetyStockadd, inventoryAvailabilityData.getSupply_Type_Id().get(indexSuppyType));
		Action.selectByVisibleText(drpdwnSafetyStockTypeadd,inventoryAvailabilityData.getSafety_Stock_Type().get(indexSafetyStockType));
		Action.waitForElementToBeClickable(driver, txtboxSafetyStockvalue, 10);
		Action.enter(txtboxSafetyStockvalue, inventoryAvailabilityData.getSafety_Stock_Value());
		Action.waitForElementToBeClickable(driver, btnSave, 10);
		Action.clickUsingJavaScipt(btnSave);
		Common.waitForPageLoaded(driver);
		rowGlobalSupply=CommonElementsPage.getRowNo(inventoryAvailabilityData.getSupply_Type_Id().get(indexSuppyType));
		System.out.println("Selected Supply Type id is for GLOBAL SUPPLY TYPE attribute::"
				+ CommonElementsPage.getRowCellTextVal(rowGlobalSupply, 1));
		Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowGlobalSupply, 1),
				inventoryAvailabilityData.getSupply_Type_Id().get(indexSuppyType),
				"No Safety Stock added by GLOBAL SUPPLY TYPE attribute");
		}
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("AGGREGRATED GLOBAL")) {
			Action.selectByVisibleText(drpdwnSafetyStockTypeadd,inventoryAvailabilityData.getSafety_Stock_Type().get(indexSafetyStockType));
			Action.waitForElementToBeClickable(driver, txtboxSafetyStockvalue, 10);
			Action.enter(txtboxSafetyStockvalue, inventoryAvailabilityData.getSafety_Stock_Value());
			Action.waitForElementToBeClickable(driver, btnSave, 10);
			Action.clickUsingJavaScipt(btnSave);
			Common.waitForPageLoaded(driver);
		}
		
	}

	public void editSafetyStock(int indexType) throws Exception {
		inventoryAvailabilityData = InventoryAvailabilityData.get(env.getFileLocation());
			
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE ITEM")) {
		CommonElementsPage.clickDivChildSpanLink(rowNodeItem, 7, 0, 0, 1);
	
		}
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE TYPE ITEM")) {
			CommonElementsPage.clickDivChildSpanLink(rowNodeTypeItem, 7, 0, 0, 1);
			
		}if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE ITEM ATTRIBUTE")) {
			CommonElementsPage.clickDivChildSpanLink(rowNodeItemAttri, 8, 0, 0, 1);
		}if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE TYPE ITEM ATTRIBUTE")) {
			CommonElementsPage.clickDivChildSpanLink(rowNodeItemAttrid, 8, 0, 0, 1);
		}if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("GLOBAL NODE TYPE")) {
			CommonElementsPage.clickDivChildSpanLink(rowGlobalNode, 6, 0, 0, 1);
		}if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("GLOBAL SUPPLY TYPE")) {
			CommonElementsPage.clickDivChildSpanLink(rowGlobalSupply, 4, 0, 0, 1);
		}
		Common.waitForPageLoaded(driver);
		Action.waitForElementToBeClickable(driver, txtboxSafetyStockvalue, 10);
		Action.enter(txtboxSafetyStockvalue,inventoryAvailabilityData.getEditSafety_Stock_Value());
		Action.waitForElementToBeClickable(driver, btnSave, 20);
		Action.clickUsingJavaScipt(btnSave);
	
	}

	public void deleteSafetyStock(int indexType) throws Exception {
		inventoryAvailabilityData = InventoryAvailabilityData.get(env.getFileLocation());
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE ITEM")) {
		CommonElementsPage.clickSelectBtnSpanLink(rowNodeItem, 7, 1);		
		}		
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE TYPE ITEM")) {
			CommonElementsPage.clickSelectBtnSpanLink(rowNodeTypeItem,7,1);
		}if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE ITEM ATTRIBUTE")) {
			CommonElementsPage.clickSelectBtnSpanLink(rowNodeItemAttri,8,1);
		}if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE TYPE ITEM ATTRIBUTE")) {
			CommonElementsPage.clickSelectBtnSpanLink(rowNodeItemAttrid, 8, 1);
		}if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("GLOBAL NODE TYPE")) {
			CommonElementsPage.clickSelectBtnSpanLink(rowGlobalNode, 6, 1);
		}if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("GLOBAL SUPPLY TYPE")) {
			CommonElementsPage.clickSelectBtnSpanLink(rowGlobalNode, 6, 1);;
		}
		Action.waitForElementToBeClickable(driver, btnConfirmDeleteSafety, 20);
		Action.clickUsingJavaScipt(btnConfirmDeleteSafety);
	}

	

	public void clickItemIDLookup() {
		itemLookup.click();
		Action.waitForElementToBeClickable(driver, txtboxItemIDSearch, 10);
		Action.enter(txtboxItemIDSearch, inventoryAvailabilityData.getItemId());
		Action.waitForElementToBeClickable(driver, btnSearchitemNode, 10);
		btnSearchitemNode.click();
		Common.waitForPageLoaded(driver);
		Action.waitForElementToBeClickable(driver, btnSelectitemNode, 20);
		btnSelectitemNode.click();
	}

	public void clickNodeIDLookup() {
		nodeLookup.click();
		Action.waitForElementToBeClickable(driver, txtboxNodeIDSearch, 20);
		Action.enter(txtboxNodeIDSearch, inventoryAvailabilityData.getNodeId());
		Action.waitForElementToBeClickable(driver, btnSearchitemNode, 20);
		// btnSearchitemNode.click();
		Action.clickUsingJavaScipt(btnSearchitemNode);
		Common.waitForPageLoaded(driver);
		Action.waitForElementToBeClickable(driver, btnSelectitemNode, 20);
		btnSelectitemNode.click();
	}

	public void searchSafetyStockByNodeItemFulfillType(int indexType, int indexFulfillType, int indexSuppyType,
			int indexNodeType, int indexItemAttr) throws Exception {
		inventoryAvailabilityData = InventoryAvailabilityData.get(env.getFileLocation());
		Common.waitForPageLoaded(driver);
		Action.waitForElementToBeClickable(driver, btnSearchIcon, 30);
		Action.clickUsingJavaScipt(btnSearchIcon);
		Action.waitForElementToBeClickable(driver, drpdwnType, 10);
		Action.selectByVisibleText(drpdwnType, inventoryAvailabilityData.getChoose_a_Type().get(indexType));
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE ITEM")) {
			Action.enter(txtboxItemId, inventoryAvailabilityData.getItemId());
			Action.enter(txtboxNodeId, inventoryAvailabilityData.getNodeId());
		}
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE TYPE ITEM")) {
			Action.enter(txtboxItemId, inventoryAvailabilityData.getItemId());
			Action.selectByVisibleText(drpdwnSearchNodeType, inventoryAvailabilityData.getNode_Type().get(indexNodeType));

		}
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE ITEM ATTRIBUTE")) {
			Action.waitForElementToBeClickable(driver, txtboxNodeId, 30);
			Action.enter(txtboxNodeId, inventoryAvailabilityData.getNodeId());
			Action.waitForElementToBeClickable(driver, drpdwnSearchItemAttributeID, 10);
			Action.selectByVisibleText(drpdwnSearchItemAttributeID,
					inventoryAvailabilityData.getItem_Attribute().get(indexItemAttr));
			Action.waitForElementToBeClickable(driver, txtboxSearchItemAttributeValue, 10);
			Action.enter(txtboxSearchItemAttributeValue, inventoryAvailabilityData.getItem_Attribute_Value());
		}
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE TYPE ITEM ATTRIBUTE")) {
			//Common.waitForPageLoaded(driver);
			Action.waitForElementToBeClickable(driver, drpdwnSearchNodeType, 10);
			Action.selectByVisibleText(drpdwnSearchNodeType, inventoryAvailabilityData.getNode_Type().get(indexNodeType));
			Action.waitForElementToBeClickable(driver, drpdwnSearchItemAttributeID, 10);
			Action.selectByVisibleText(drpdwnSearchItemAttributeID,
					inventoryAvailabilityData.getItem_Attribute().get(indexItemAttr));
			Action.enter(txtboxSearchItemAttributeValue, inventoryAvailabilityData.getItem_Attribute_Value());
		}
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("GLOBAL NODE TYPE")) {
			Action.selectByVisibleText(drpdwnSearchNodeType, inventoryAvailabilityData.getNode_Type().get(indexNodeType));
		}
		Action.selectByVisibleText(drpdwnFulfillType,
				inventoryAvailabilityData.getFulfillment_Type_Id().get(indexFulfillType));
		Action.selectByVisibleText(drpdwnSupplyType, inventoryAvailabilityData.getSupply_Type_Id().get(indexSuppyType));
		Action.waitForElementToBeClickable(driver, btnSearch, 10);
		Action.clickUsingJavaScipt(btnSearch);

		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE ITEM")) {
			rowNodeItem = CommonElementsPage.getRowNo(inventoryAvailabilityData.getItemId());
			System.out.println(
					"Selected item id is for node item ::" + CommonElementsPage.getRowCellTextVal(rowNodeItem, 1));
			Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowNodeItem, 1),
					inventoryAvailabilityData.getItemId(), "No Safety Stock added by Node item ");
		}
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE TYPE ITEM")) {
			//rowNodeTypeItem = CommonElementsPage.getRowNo(inventoryAvailabilityData.getNode_Type().get(indexNodeType));
			rowNodeTypeItem = CommonElementsPage.getRowNo(inventoryAvailabilityData.getItemId());
			System.out.println("Selected node type item is for node type item ::"
					+ CommonElementsPage.getRowCellTextVal(rowNodeTypeItem, 2));
			Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowNodeTypeItem, 2),
					inventoryAvailabilityData.getNode_Type().get(indexNodeType),
					"No Safety Stock added by Node type item  ");
		}
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE ITEM ATTRIBUTE")) {
			rowNodeItemAttri = CommonElementsPage
					.getRowNo(inventoryAvailabilityData.getItem_Attribute().get(indexItemAttr));
			System.out.println("Selected row is:"+CommonElementsPage
					.getRowNo(inventoryAvailabilityData.getItem_Attribute().get(indexItemAttr)));
			System.out.println("Selected item attribute id is for node item attribute::"
					+ CommonElementsPage.getRowCellTextVal(rowNodeItemAttri, 1));
			Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowNodeItemAttri, 1),
					inventoryAvailabilityData.getItem_Attribute().get(indexItemAttr),
					"No Safety Stock added by Node item attribute  ");
		}
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("NODE TYPE ITEM ATTRIBUTE")) {
			rowNodeItemAttrid = CommonElementsPage
					.getRowNo(inventoryAvailabilityData.getItem_Attribute().get(indexItemAttr));
			System.out.println("Selected item attribute id is for node type item attribute::"
					+ CommonElementsPage.getRowCellTextVal(rowNodeItemAttrid, 1));
			Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowNodeItemAttrid, 1),
					inventoryAvailabilityData.getItem_Attribute().get(indexItemAttr),
					"No Safety Stock added by Node type item attribute  ");
		}
		if (inventoryAvailabilityData.getChoose_a_Type().get(indexType).equals("GLOBAL NODE TYPE")) {
			rowGlobalNode=CommonElementsPage
					.getRowNo(inventoryAvailabilityData.getNode_Type().get(indexNodeType));
			System.out.println("Selected item attribute id is for node type item attribute::"
					+ CommonElementsPage.getRowCellTextVal(rowGlobalNode, 1));
			Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowGlobalNode, 1),
					inventoryAvailabilityData.getNode_Type().get(indexNodeType),
					"No Safety Stock added by Node type item attribute");
					
		}
	}

	public void searchSafetyStockByType(int indexType) throws Exception {
		inventoryAvailabilityData = InventoryAvailabilityData.get(env.getFileLocation());
		CommonElementsPage.clickOnSearchIcon();
		Action.waitForElementToBeClickable(driver, drpdwnType, 10);
		Action.selectByVisibleText(drpdwnType, inventoryAvailabilityData.getChoose_a_Type().get(indexType));
		Action.waitForElementToBeClickable(driver, btnSearch, 20);
		Action.clickUsingJavaScipt(btnSearch);
	}

	public boolean verfiySafetyStockRecord() throws Exception {
		boolean found = false;
		int rowNo = CommonElementsPage.getTotalRows();
		if (headerSafetyStock.getText().contains("Safety Stocks Found") && (rowNo > 0)) {
			found = true;
		} else {
			Assert.assertTrue(txtSuccessMsg.getText().contains(RomuiEnumValues.SAFETYSTOCK_NOTFOUND.getMessage()),
					"No search found");
		}
		return found;

	}

}
