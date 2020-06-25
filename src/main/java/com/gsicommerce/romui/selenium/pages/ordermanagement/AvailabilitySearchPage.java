package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.util.List;

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

public class AvailabilitySearchPage {

	WebDriver driver;
	Environment env;
	Action action;

	public AvailabilitySearchPage(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);

	}

	@FindBy(how = How.CSS, using = "#availability_search_item_id")
	private WebElement txtItemIDSearch;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Lookup')]")
	private List<WebElement> lookUpList;

	@FindBy(how = How.CSS, using = "#availability_search_node_type_id")
	private WebElement drpdwnNodeType;

	@FindBy(how = How.CSS, using = "#inventory_node_search_id")
	private List<WebElement> txtNodeID;

	@FindBy(how = How.CSS, using = "button.btn-default[type='submit']")
	public static List<WebElement> btnManageInventoryNodeSearch;

	@FindBy(how = How.CSS, using = "[type='checkbox'][data-lookup-toggle='']")
	private WebElement chkboxNodeID;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Select')]")
	private WebElement lkSelectItem;

	@FindBy(how = How.CSS, using = ".pagination-heading div")
	private WebElement inventoryAuditHeader;

	public void searchForAvailability(CatalogInventorySearchData data) {
		CommonElementsPage.clickOnSearchIcon();
		Action.clickUsingJavaScipt(CommonElementsPage.btnSearch);
		Assert.assertEquals(CommonElementsPage.txtAlertErrorMsg.getText(), RomuiEnumValues.FORM_ERROR.getMessage(),
				"No error message displayed for blank mandatory field");
		CommonElementsPage.clickOnSearchIcon();
		Action.enter(txtItemIDSearch, data.getItemID());
		lookUpList.get(1).click();
		Action.waitForElementToBeClickable(driver, txtNodeID.get(1), 30);
		Action.enter(txtNodeID.get(1), data.getNodeID());
		clickOnManageInventorySearchBtn(5);
		Action.waitForElementToBeClickable(driver, chkboxNodeID, 30);
		chkboxNodeID.click();
		Action.clickUsingJavaScipt(lkSelectItem);
		Action.selectByVisibleText(drpdwnNodeType, data.getNodeType());

		// CommonElementsPage.clickOnSearchBtn();
		Action.clickUsingJavaScipt(CommonElementsPage.btnSearch);
	}

	public void clickOnManageInventorySearchBtn(int index) {
		btnManageInventoryNodeSearch.get(index).click();
	}

	public boolean verifyAvailability(CatalogInventorySearchData data) throws Exception {
		boolean found = false;
		int rowNo = CommonElementsPage.getTotalRows();
		if (inventoryAuditHeader.getText().contains("Available Search Found") && (rowNo > 0)) {
			found = true;
		}
		return found;
	}

}
