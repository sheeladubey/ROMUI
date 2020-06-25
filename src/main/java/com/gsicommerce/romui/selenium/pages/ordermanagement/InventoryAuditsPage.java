package com.gsicommerce.romui.selenium.pages.ordermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.gsicommerce.romui.selenium.testdata.CatalogInventorySearchData;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class InventoryAuditsPage {

	WebDriver driver;
	Environment env;
	Action action;

	public InventoryAuditsPage(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);

	}

	@FindBy(how = How.CSS, using = "#store_fulfillment_inventory_audit_search_item_id")
	private WebElement txtItemIDSearch;

	@FindBy(how = How.CSS, using = "#store_fulfillment_inventory_audit_search_node_id")
	private WebElement txtNodeIDSearch;

	@FindBy(how = How.CSS, using = "#store_fulfillment_inventory_audit_search_type_id")
	private WebElement drpdwnSupplyType;

	@FindBy(how = How.CSS, using = "#store_fulfillment_inventory_audit_search_start_date")
	private WebElement calETAFrom;

	@FindBy(how = How.CSS, using = "#store_fulfillment_inventory_audit_search_end_date")
	private WebElement calETATo;

	@FindBy(how = How.CSS, using = ".pagination-heading div")
	private WebElement inventoryAuditHeader;

	public void searchForInventoryAudits(CatalogInventorySearchData data) {
		CommonElementsPage.clickOnSearchIcon();
		Action.clickUsingJavaScipt(CommonElementsPage.btnSearch);
		Assert.assertEquals(CommonElementsPage.txtAlertErrorMsg.getText(), RomuiEnumValues.FORM_ERROR.getMessage(),
				"No error message displayed for blank mandatory field");
		CommonElementsPage.clickOnSearchIcon();
		Action.enter(txtItemIDSearch, data.getItemID());
		Action.enter(txtNodeIDSearch, data.getNodeID());
		Action.selectByVisibleText(drpdwnSupplyType, data.getSupplyType());

		// CommonElementsPage.clickOnSearchBtn();
		Action.clickUsingJavaScipt(CommonElementsPage.btnSearch);
	}

	public boolean verifyAudits(CatalogInventorySearchData data) throws Exception {
		boolean found = false;
		int rowNo = CommonElementsPage.getTotalRows();
		if (inventoryAuditHeader.getText().contains("Inventory Audits Found") && (rowNo > 0)) {
			found = true;
		}
		return found;
	}

}
