package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.SellerConfigurationsData;
import com.gsicommerce.romui.selenium.utilities.Action;

public class SellerConfigurationsPage {

	WebDriver driver;
	Environment env;
	Action action;

	private SellerConfigurationsData sellerConfigData;
	private static int selleridselected;
	private static int rowNo;

	public SellerConfigurationsPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CSS, using = "#seller_store_id")
	private WebElement txtboxSellerID;

	@FindBy(how = How.CSS, using = "#seller_inventory_organization_id")
	private WebElement txtboxInventoryOrgID;

	@FindBy(how = How.CSS, using = "#seller_store_name")
	private WebElement txtboxSellerName;

	@FindBy(how = How.CSS, using = "#seller_default_latest_ship_date_days")
	private WebElement txtboxMaxDuration;

	@FindBy(how = How.CSS, using = "[name='seller[store_pickup_eligible]'][value='true']")
	public WebElement chkboxInStorePick;

	@FindBy(how = How.CSS, using = "[name='seller[ship_to_store_eligible]'][value='true']")
	public WebElement chkboxShipToStore;

	@FindBy(how = How.CSS, using = "[name='seller[ship_from_store_eligible]'][value='true']")
	public WebElement chkboxShipFromStore;

	@FindBy(how = How.CSS, using = "[name='seller[associate_delivery_eligible]'][value='true']")
	private WebElement chkboxAD;

	@FindBy(how = How.CSS, using = "[name='seller[distribution_center_eligible]'][value='true']")
	private WebElement chkboxDC;

	@FindBy(how = How.CSS, using = "[name='seller[drop_ship_eligible]'][value='true']")
	private WebElement chkboxDropShip;

	@FindBy(how = How.CSS, using = "#seller_status_descriptions_attributes_0_description")
	private WebElement txtboxOSCreated;

	@FindBy(how = How.CSS, using = "#seller_status_descriptions_attributes_1_description")
	private WebElement txtboxOSPreSellLine;

	@FindBy(how = How.CSS, using = "#seller_status_descriptions_attributes_2_description")
	private WebElement txtboxOSOGCLine;

	@FindBy(how = How.CSS, using = "#seller_status_descriptions_attributes_33_description")
	public WebElement txtboxOSDummyReturn;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-default form-collection-add']")
	private WebElement btnAddAdjReason;

	@FindBy(how = How.CSS, using = ".pagination-heading")
	private WebElement sellerConfigHeader;

	@FindBy(how = How.CSS, using = "[placeholder='Enter Code'][type='text']")
	private List<WebElement> txtboxAdjReasoncode;

	@FindBy(how = How.CSS, using = "[placeholder='Enter Reason'][type='text']")
	private List<WebElement> txtboxAdjReason;

	@FindBy(how = How.CSS, using = ".form-collection-prompt-toggle[data-repeater-remove='']")
	private List<WebElement> btnInvAdjDelete;

	@FindBy(how = How.CSS, using = "[name='seller[region_lookup_strategy_attributes][3][lookup_level]']")
	public WebElement drpdwnSellerRegionStrategy;

	@FindBy(how = How.CSS, using = ".alert-info")
	public WebElement txtSuccessMsg;

	@FindBy(how = How.CSS, using = ".col-sm-6")
	public List<WebElement> viewSellerConfigPanel;

	@FindBy(how = How.CSS, using = ".seller-status-desc.col-xs-6")
	public List<WebElement> orderStatusDescriptionPanel;

	@FindBy(how = How.CSS, using = "div.lookup-strategy")
	public List<WebElement> lookupStrategyPanel;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Edit')]")
	private WebElement btnEdit;

	public void verifyEditSellerConfig() throws JsonParseException, JsonMappingException, IOException, Exception {
		sellerConfigData = SellerConfigurationsData.get(env.getFileLocation());		
		Reporter.log("Validate Seller ID,Inventory Organization ID,Seller Name is not editable");
		Assert.assertTrue((txtboxSellerID.getAttribute("readonly").equals("true")), "Seller ID Field is editable");
		Assert.assertTrue((txtboxInventoryOrgID.getAttribute("readonly").equals("true")),
				"Inventory Org ID Field is editable");
		Assert.assertTrue((txtboxSellerName.getAttribute("readonly").equals("true")), "Seller Name Field is editable");
		Action.enter(txtboxMaxDuration, sellerConfigData.getMaxDuration());
		chkboxAD.click();
		Action.scrollDown("500");
		chkboxDC.click();
		chkboxDropShip.click();
		Action.enter(txtboxOSCreated, sellerConfigData.getOSCreated());
		Action.enter(txtboxOSPreSellLine, sellerConfigData.getOSSellLine());
		Action.enter(txtboxOSDummyReturn, sellerConfigData.getOSDummyReturn());
		Action.scrollDown("800");
		int Adjcodesize = txtboxAdjReasoncode.size();
		int Adjreasonsize = txtboxAdjReason.size();
		System.out.println("Exist code textbox is::" + Adjcodesize);
		Action.clickUsingJavaScipt(btnAddAdjReason);
		Action.enter(txtboxAdjReasoncode.get(Adjcodesize), sellerConfigData.getInventoryAdjReasonsCode());
		Action.enter(txtboxAdjReason.get(Adjreasonsize), sellerConfigData.getInventoryAdjReasonsCode());
		Action.scrollDown("600");
		drpdwnSellerRegionStrategy.click();
		Action.selectByVisibleText(drpdwnSellerRegionStrategy, sellerConfigData.getSellerRegionLookupStrategy());
		CommonElementsPage.clickOnSaveBtn();
		}
	

	public void verifyEditSellerFromViewPage() throws Exception
	{
		sellerConfigData = SellerConfigurationsData.get(env.getFileLocation());
		clickViewSellerConfig();
		Action.waitForElementToBeClickable(driver, btnEdit, 10);
		Action.clickUsingJavaScipt(btnEdit);
		verifyEditSellerConfig();
		
	}
	public void clickEditSellerConfig() throws Exception
	{
		sellerConfigData = SellerConfigurationsData.get(env.getFileLocation());
		rowNo = CommonElementsPage.getTotalRows();
		if (sellerConfigHeader.getText().contains("Sellers Found") && (rowNo > 0)) {
		selleridselected = CommonElementsPage.getRowNo(sellerConfigData.getSellerID(), 1);
		System.out.println("Row Selected is :" + selleridselected);
		Reporter.log("Click Edit Seller Configurations Icon");
		System.out.println("Seller id Selected is ::" + CommonElementsPage.getRowCellTextVal(selleridselected, 1));
		System.out.println("Click Edit Seller Config Icon");
		CommonElementsPage.clickDivSpanLink(selleridselected, 3, 0, 2, 1);
		}else {
			System.out.println("No Manage Seller Configurations Records found for Edit Seller");
		}
	}

	public void clickViewSellerConfig() throws Exception
	{
		sellerConfigData = SellerConfigurationsData.get(env.getFileLocation());
		rowNo = CommonElementsPage.getTotalRows();
		if (sellerConfigHeader.getText().contains("Sellers Found") && (rowNo > 0)) {
		selleridselected = CommonElementsPage.getRowNo(sellerConfigData.getSellerID(), 1);
		System.out.println("Row Selected is :" + selleridselected);
		Reporter.log("Click View Seller Configurations Icon");	
		System.out.println("Click View Seller Configurations Icon");
		CommonElementsPage.clickDivSpanLink(selleridselected, 3, 0, 1, 1);
	
	}else {
		System.out.println("No Manage Seller Configurations Records found for View Seller");
	}
	}
	
	public boolean verifyViewSellerConfig(int index, String expected) throws Exception {
		boolean found = false;
		String actual = viewSellerConfigPanel.get(index).getText();
		if (actual.contains(expected)) {
			found = true;
		} else {
			found = false;
		}
		return found;
	}

	public boolean verifyManageSellerConfig() throws Exception {
		sellerConfigData = SellerConfigurationsData.get(env.getFileLocation());
		selleridselected = CommonElementsPage.getRowNo(sellerConfigData.getSellerID(), 1);
		boolean found = false;
		rowNo = CommonElementsPage.getTotalRows();
		if (sellerConfigHeader.getText().contains("Sellers Found") && (rowNo > 0)) {
			found = true;
		}
		Assert.assertTrue(
				CommonElementsPage.getRowCellTextVal(selleridselected, 1).contains(sellerConfigData.getSellerID()),
				"Seller ID doesn't display on Manager Seller Config Screen");
		Assert.assertTrue(
				CommonElementsPage.getRowCellTextVal(selleridselected, 2).contains(sellerConfigData.getSellerName()),
				"Seller Name doesn't display on Manager Seller Config Screen");
		return found;

	}
}
