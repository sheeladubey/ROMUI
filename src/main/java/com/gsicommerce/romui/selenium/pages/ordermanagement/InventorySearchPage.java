package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gsicommerce.romui.selenium.testdata.CatalogInventorySearchData;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Action;

public class InventorySearchPage {

	WebDriver driver;
	Environment env;
	Action action;

	public InventorySearchPage(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);

	}

	@FindBy(how = How.CSS, using = "#store_fulfillment_inventory_search_item_id")
	private WebElement txtItemIDSearch;

	@FindBy(how = How.CSS, using = "#items_item_search_form_client_item_id")
	private List<WebElement> txtClientItemIDSearch;

	@FindBy(how = How.CSS, using = "#items_item_search_form_display_product_id")
	private List<WebElement> txtDisProductIDSearch;

	@FindBy(how = How.CSS, using = "#items_item_search_form_status")
	private List<WebElement> drpdwnStatusSearch;

	@FindBy(how = How.CSS, using = "#items_item_search_form_style_id")
	private List<WebElement> txtStyleIDSearch;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Lookup')]")
	private List<WebElement> lookUpList;

	@FindBy(how = How.CSS, using = "#items_item_search_form_query")
	private List<WebElement> txtItemSearch;

	@FindBy(how = How.CSS, using = "#inventory_node_search_id")
	private List<WebElement> txtNodeID;

	@FindBy(how = How.CSS, using = "#store_fulfillment_inventory_search_node_type_id")
	private WebElement drpdwnNodeType;

	@FindBy(how = How.CSS, using = "#store_fulfillment_inventory_search_type_id")
	private WebElement drpdwnSearchSupplyType;

	@FindBy(how = How.CSS, using = "#store_fulfillment_inventory_search_start_date")
	private WebElement calETAFrom;

	@FindBy(how = How.CSS, using = "#store_fulfillment_inventory_search_end_date")
	private WebElement calETATo;

	@FindBy(how = How.CSS, using = "#store_fulfillment_inventory_adjustment_type_id")
	private WebElement drpdwnSupplyType;

	@FindBy(how = How.CSS, using = "#mode")
	private WebElement drpdwnAdjstmntType;

	@FindBy(how = How.CSS, using = "#store_fulfillment_inventory_adjustment_quantity")
	private WebElement txtQty;

	@FindBy(how = How.CSS, using = "#store_fulfillment_inventory_adjustment_reason_id")
	private WebElement drpdwnReason;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Select')]")
	private WebElement lkSelectItem;

	@FindBy(how = How.CSS, using = ".pagination-heading div")
	private WebElement inventoryAuditHeader;

	@FindBy(how = How.CSS, using = "[type='checkbox'][data-lookup-toggle='']")
	private WebElement chkboxNodeID;

	@FindBy(how = How.CSS, using = "button[type='submit']")
	public static List<WebElement> btnManageInventoryNodeSearch;

	@FindBy(how = How.CSS, using = "#source_target_type_id")
	private WebElement drpdwnMoveInvSupplyType;

	@FindBy(how = How.CSS, using = "#source_quantity")
	private WebElement txtMoveInvQty;

	@FindBy(how = How.CSS, using = "#source_reason_id")
	private WebElement drpdwnMoveInvReason;

	@FindBy(how = How.CSS, using = "[data-tooltip='Show Advanced Search']")
	private WebElement btnShowAdvancedSearch;

	public void searchForInventory(CatalogInventorySearchData data, String itemID, String nodeList, String nodeType,
			String supplyType) {
		CommonElementsPage.clickOnSearchIcon();
		if (itemID != null) {
			Action.enter(txtItemIDSearch, data.getItemID());
		}
		if (nodeList != null) {
			lookUpList.get(1).click();
			Action.waitForElementToBeClickable(driver, txtNodeID.get(1), 30);
			Action.enter(txtNodeID.get(1), data.getNodeID());
			clickOnManageInventorySearchBtn(4);
			Action.waitForElementToBeClickable(driver, chkboxNodeID, 30);
			chkboxNodeID.click();
			Action.clickUsingJavaScipt(lkSelectItem);
		}
		if (nodeType != null) {
			Action.selectByVisibleText(drpdwnNodeType, data.getNodeType());
		}
		if (supplyType != null) {
			Action.selectByVisibleText(drpdwnSearchSupplyType, data.getSupplyType());
		}
		// CommonElementsPage.clickOnSearchBtn();
		Action.clickUsingJavaScipt(CommonElementsPage.btnSearch);
	}

	public void addInventory(CatalogInventorySearchData data, String searchItem) throws Exception {
		CommonElementsPage.clickOnAddBtn();
		lookUpList.get(0).click();
		if (searchItem.contains("multiple")) {
			Action.waitForElementToBeClickable(driver, btnShowAdvancedSearch, 30);
			btnShowAdvancedSearch.click();
			Action.enter(txtClientItemIDSearch.get(1), data.getClientItemID());
			Action.enter(txtDisProductIDSearch.get(1), data.getProductID());
			Action.selectByVisibleText(drpdwnStatusSearch.get(1), data.getStatus());
			Action.enter(txtStyleIDSearch.get(1), data.getStyleID());
		} else {
			Action.waitForElementToBeClickable(driver, txtItemSearch.get(1), 30);
			Action.enter(txtItemSearch.get(1), searchItem);
		}
		// Action.clickUsingJavaScipt(CommonElementsPage.btnSearch);
		clickOnManageInventorySearchBtn(3);
		int rowNo = CommonElementsPage.getRowNo(data.getClientItemID());
		CommonElementsPage.clickSelectLink(rowNo, 4,0,0);
		lookUpList.get(1).click();
		Action.waitForElementToBeClickable(driver, txtNodeID.get(1), 30);
		Action.enter(txtNodeID.get(1), data.getNodeID());
		clickOnManageInventorySearchBtn(3);
		Action.clickUsingJavaScipt(lkSelectItem);
		Action.selectByVisibleText(drpdwnSupplyType, data.getSupplyType());
		Action.enter(txtQty, data.getQuantity());
		Action.selectByVisibleText(drpdwnReason, data.getReason());
		CommonElementsPage.clickOnSaveBtn();
		Thread.sleep(3000);
	}

	public void adjustInventory(CatalogInventorySearchData data) throws Exception {
		CommonElementsPage.clickSingleRowActionsIcon(5, 1);
		Action.selectByVisibleText(drpdwnAdjstmntType, data.getAdjustmentType());
		Action.enter(txtQty, data.getAdjustmentQty());
		Action.selectByVisibleText(drpdwnReason, data.getReason());
		CommonElementsPage.clickOnSaveBtn();
	}

	public void moveInventory(CatalogInventorySearchData data) throws Exception {
		CommonElementsPage.clickSingleRowActionsIcon(5, 2);
		lookUpList.get(0).click();
		Action.waitForElementToBeClickable(driver, txtNodeID.get(1), 30);
		Action.enter(txtNodeID.get(1), data.getNodeID());
		clickOnManageInventorySearchBtn(3);
		Action.clickUsingJavaScipt(lkSelectItem);
		Action.selectByVisibleText(drpdwnMoveInvSupplyType, data.getSupplyType());
		Action.enter(txtMoveInvQty, data.getQuantity());
		Action.selectByVisibleText(drpdwnMoveInvReason, data.getReason());
		CommonElementsPage.clickOnSaveBtn();
	}

	public boolean viewAudits(CatalogInventorySearchData data) throws Exception {
		boolean found = false;
		CommonElementsPage.clickSingleRowActionsIcon(5, 3);
		int rowNo = CommonElementsPage.getTotalRows();
		if (inventoryAuditHeader.getText().contains("Inventory Audits Found") && (rowNo > 0)) {
			found = true;
		}
		return found;
	}

	public boolean verifySearch(int row, int col, String expected) throws Exception {
		boolean found = false;
		if (CommonElementsPage.getRowCellTextVal(row, col).contains(expected)) {
			found = true;
		}
		return found;
	}

	public void clickOnManageInventorySearchBtn(int index) {
		btnManageInventoryNodeSearch.get(index).click();
	}

}
