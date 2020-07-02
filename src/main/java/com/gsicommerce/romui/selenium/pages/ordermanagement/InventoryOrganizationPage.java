package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.InventoryAvailabilityData;
import com.gsicommerce.romui.selenium.testdata.InventoryOrganizationData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class InventoryOrganizationPage {

	WebDriver driver;
	Environment env;
	private InventoryOrganizationData inventoryOrganizationData;
	private static int rowNoInvOrg;

	public InventoryOrganizationPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using = ".pagination-heading")
	private WebElement headerInventoryOrg;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Edit')]")
	private WebElement btnEdit;
	
	@FindBy(how = How.CSS, using = ".col-sm-6")
	public List<WebElement> viewInventoryOrgsDetails;
	
	@FindBy(how = How.CSS, using = "[data-lookup='node-group-id'] .lookup-search-button-wrapper")
	private WebElement nodeGroupIDLookup;
	
	@FindBy(how = How.CSS, using = "[data-lookup='shipping-calendar-id'] .lookup-search-button-wrapper")
	private WebElement shippingCalendarIDLookup;
	
	@FindBy(how = How.CSS, using = "#inventory_organization_default_atp_rule_id")
	private WebElement drpdwnDefaultATPRule;
	
	@FindBy(how = How.CSS, using = "#inventory_organization_node_rejected_supply_action_id")
	private WebElement drpdwnNodeRejectSupply;
	
	@FindBy(how = How.CSS, using = ".form-collection-add[type='button']")
	private WebElement btnAddAttribute;
	
	@FindBy(how = How.CSS, using = "[data-repeater='item_attributes'] .row")
	private List<WebElement> txtboxNamePriority;
	
	@FindBy(how = How.CSS, using = "[data-repeater-item=''] [type='text']")
	private List<WebElement> txtboxNamePriority1;
	
	
	public boolean verfiyInventoryOrgsRecord() throws Exception {
		boolean found = false;
		int rowNo = CommonElementsPage.getTotalRows();
		if (headerInventoryOrg.getText().contains("Inventory Organization Found") && (rowNo > 0)) {
			found = true;
		} 
		return found;

	}
	
	public void clickViewInventoryOrgs() throws Exception
	{
		inventoryOrganizationData = InventoryOrganizationData.get(env.getFileLocation());
		rowNoInvOrg=CommonElementsPage.getRowNo(inventoryOrganizationData.getInventoryOrgID());
		System.out.println("Selected row is: " +rowNoInvOrg);
		System.out.println("Selected row is: " +CommonElementsPage.getRowCellTextVal(rowNoInvOrg,1));
		if (headerInventoryOrg.getText().contains("Inventory Organization Found") && (rowNoInvOrg > 0)) {
		CommonElementsPage.clickDivSpanLink(rowNoInvOrg, 3, 0, 1, 1);		
	}
	}
	
	public void clickEditInventoryOrgs() throws Exception
	{
		inventoryOrganizationData = InventoryOrganizationData.get(env.getFileLocation());
		rowNoInvOrg=CommonElementsPage.getRowNo(inventoryOrganizationData.getInventoryOrgID());
		System.out.println("Selected row for Edit is: " +rowNoInvOrg);
		System.out.println("Selected row text for edit is: " +CommonElementsPage.getRowCellTextVal(rowNoInvOrg,1));
		if (headerInventoryOrg.getText().contains("Inventory Organization Found") && (rowNoInvOrg > 0)) {
		CommonElementsPage.clickDivSpanLink(rowNoInvOrg, 3, 0, 2, 1);
		}
		Common.waitForPageLoaded(driver);
		
	}
	
	public void EditInventoryOrgs() throws Exception
	{
		inventoryOrganizationData = InventoryOrganizationData.get(env.getFileLocation());
		nodeGroupIDLookup.click();
		int rowNoGroupid=CommonElementsPage.getRowNo(inventoryOrganizationData.getGroupID());
		System.out.println("Selected row for GroupID selection is: "+CommonElementsPage.getRowNo(inventoryOrganizationData.getGroupID()));
		CommonElementsPage.clickSelectLink(rowNoGroupid,3,1,1);
		shippingCalendarIDLookup.click();
		int rowNoCalid=CommonElementsPage.getRowNo(inventoryOrganizationData.getCalendarID());
		System.out.println("Selected row for CalendarID selection is: "+CommonElementsPage.getRowNo(inventoryOrganizationData.getCalendarID()));
		CommonElementsPage.clickSelectLink(rowNoCalid,3,1,1);
		Action.waitForElementToBeClickable(driver, drpdwnDefaultATPRule, 10);
		Action.selectByVisibleText(drpdwnDefaultATPRule, inventoryOrganizationData.getDefaultATP());
		Action.waitForElementToBeClickable(driver, drpdwnNodeRejectSupply, 10);
		Action.selectByVisibleText(drpdwnNodeRejectSupply, inventoryOrganizationData.getNodeRejected());
		Action.scrollToBottomofPage();
		btnAddAttribute.click();
		Common.waitForPageLoaded(driver);
		int sizeAttribute=txtboxNamePriority1.size();
		System.out.println("size of item Attribute textbox Name & Priority fields is" +sizeAttribute);
		Action.enter(txtboxNamePriority1.get(sizeAttribute-2), inventoryOrganizationData.getAttributeName());
		Action.enter(txtboxNamePriority1.get(sizeAttribute-1), inventoryOrganizationData.getPriority());
		CommonElementsPage.clickOnSaveBtn();
	
	}
	
	public boolean verifyViewInventoryOrgs(int index, String expected) throws Exception {
		boolean found = false;
		String actual = viewInventoryOrgsDetails.get(index).getText();
		if (actual.contains(expected)) {
			found = true;
		} else {
			found = false;
		}
		return found;
	}
	
	public void EditInventoryOrgsFromView() throws Exception
	{
		clickViewInventoryOrgs();
		Action.waitForElementToBeClickable(driver, btnEdit, 10);
		Action.clickUsingJavaScipt(btnEdit);
		EditInventoryOrgs();
		
	}

}
