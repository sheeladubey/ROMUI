package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.RegionConfigurationData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class FulfillmentNodePage {

	WebDriver driver;
	Environment env;
	Action action;

	public FulfillmentNodePage(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);

	}

	@FindBy(how = How.CSS, using = "#inventory_node_type")
	private WebElement drpdwnNodeType;

	@FindBy(how = How.CSS, using = "#inventory_node_id")
	private WebElement txtNodeID;

	@FindBy(how = How.CSS, using = "#inventory_node_name")
	private WebElement txtNodeDescrp;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='inventory_node[active]']")
	private WebElement chkboxEnableForAvailblty;

	@FindBy(how = How.CSS, using = "#inventory_node_address_attributes_country_code")
	private WebElement drpdwnCountry;

	@FindBy(how = How.CSS, using = "#inventory_node_address_attributes_line1")
	private WebElement txtAddrLine1;

	@FindBy(how = How.CSS, using = "#inventory_node_address_attributes_line2")
	private WebElement txtAddrLine2;

	@FindBy(how = How.CSS, using = "#inventory_node_address_attributes_line3")
	private WebElement txtAddrLine3;

	@FindBy(how = How.CSS, using = "#inventory_node_address_attributes_line4")
	private WebElement txtAddrLine4;

	@FindBy(how = How.CSS, using = "#inventory_node_address_attributes_city")
	private WebElement txtCity;

	@FindBy(how = How.CSS, using = "#inventory_node_address_attributes_region")
	private WebElement txtState;

	@FindBy(how = How.CSS, using = "#inventory_node_address_attributes_postal_code")
	private WebElement txtZipCode;

	@FindBy(how = How.CSS, using = "#inventory_node_address_attributes_email")
	private WebElement txtEmailAddr;

	@FindBy(how = How.CSS, using = "#inventory_node_address_attributes_phone")
	private WebElement txtPhoneNo;

	@FindBy(how = How.CSS, using = "#inventory_node_timezone_id")
	private WebElement drpdwnTimezone;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='inventory_node[inventory_tracking_eligible]']")
	private WebElement chkboxNodeTracksInventory;

	@FindBy(how = How.CSS, using = "#inventory_node_priority")
	private WebElement txtPriority;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='inventory_node[ispu_eligible]']")
	@CacheLookup
	private WebElement chkboxISPUEligible;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='inventory_node[sfs_eligible]']")
	@CacheLookup
	private WebElement chkboxSFSEligible;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='inventory_node[sts_eligible]']")
	@CacheLookup
	private WebElement chkboxSTSEligible;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='inventory_node[ad_eligible]']")
	@CacheLookup
	private WebElement chkboxADEligible;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='inventory_node[gift_wrap_eligible]']")
	@CacheLookup
	private WebElement chkboxGiftWrapSrvAllowede;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='inventory_node[hfr_eligible]']")
	@CacheLookup
	private WebElement chkboxHFReturnsEligible;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='inventory_node[auto_resource]']")
	@CacheLookup
	private WebElement chkboxAutoResource;

	@FindBy(how = How.CSS, using = "#inventory_node_latitude")
	private WebElement txtLattitude;

	@FindBy(how = How.CSS, using = "#inventory_node_longitude")
	private WebElement txtLongitude;

	@FindBy(how = How.CSS, using = "[type='radio'][value='HOLD_AND_AUTO_UNHOLD']")
	private WebElement rbHoldandAutoUnhold;

	@FindBy(how = How.CSS, using = "[type='radio'][value='HOLD_AND_MANUAL_UNHOLD']")
	private WebElement rbHoldandManualUnhold;

	@FindBy(how = How.CSS, using = "[type='radio'][value='NO_HOLD']")
	private WebElement rbNoHold;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='inventory_node[print_shipping_label_separately]']")
	@CacheLookup
	private WebElement chkboxPrintPackSlipAndShipLbl;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add a Package')]")
	@CacheLookup
	public WebElement btnAddAPackage;

	@FindBy(how = How.CSS, using = "#inventory_node_package_configurations_attributes_0_id")
	@CacheLookup
	private WebElement txtPackageID;

	@FindBy(how = How.CSS, using = "#inventory_node_package_configurations_attributes_0_weight")
	@CacheLookup
	private WebElement txtWeight;

	@FindBy(how = How.CSS, using = "#inventory_node_package_configurations_attributes_0_material_weight")
	@CacheLookup
	private WebElement txtPkgMaterialWt;

	@FindBy(how = How.CSS, using = "#inventory_node_package_configurations_attributes_0_height")
	@CacheLookup
	private WebElement txtHeight;

	@FindBy(how = How.CSS, using = "#inventory_node_package_configurations_attributes_0_width")
	@CacheLookup
	private WebElement txtWidth;

	@FindBy(how = How.CSS, using = "#inventory_node_package_configurations_attributes_0_length")
	@CacheLookup
	private WebElement txtLength;

	@FindBy(how = How.CSS, using = "#inventory_node_package_configurations_attributes_0_weight_uom")
	@CacheLookup
	private WebElement drpdwnWeightUnits;

	@FindBy(how = How.CSS, using = "#inventory_node_package_configurations_attributes_0_material_weight_uom")
	@CacheLookup
	private WebElement drpdwnPkgMtWtUnits;

	@FindBy(how = How.CSS, using = "#inventory_node_package_configurations_attributes_0_height_uom")
	@CacheLookup
	private WebElement drpdwnHeighUnits;

	@FindBy(how = How.CSS, using = "#inventory_node_package_configurations_attributes_0_width_uom")
	@CacheLookup
	private WebElement drpdwnWidthUnits;

	@FindBy(how = How.CSS, using = "#inventory_node_package_configurations_attributes_0_length_uom")
	@CacheLookup
	private WebElement drpdwnLengthUnits;

	@FindBy(how = How.CSS, using = "#inventory_node_default_package_index")
	private WebElement rbDefaultPkg;

	@FindBy(how = How.CSS, using = "#inventory_node_receipt_processing_days")
	private WebElement txtRecptPTFutureDays;

	@FindBy(how = How.CSS, using = "#inventory_node_minimum_shipment_days")
	private WebElement txtMinShipmtProcessngDays;

	@FindBy(how = How.CSS, using = "#inventory_node_maximum_shipment_days")
	private WebElement txtMaxShipmtProcessngDays;

	@FindBy(how = How.CSS, using = "#inventory_node_shipping_calendar_id")
	private WebElement drpdwnShippngCalID;

	@FindBy(how = How.CSS, using = "[type='radio'][name='inventory_node[push_notification_enabled]']")
	@CacheLookup
	private List<WebElement> rbPNOptions;

	@FindBy(how = How.CSS, using = "#inventory_node_node_label_attributes_service_provider_name")
	@CacheLookup
	private WebElement drpdwnSrvProviderName;

	@FindBy(how = How.CSS, using = "#inventory_node_node_label_attributes_default_label_strategy")
	@CacheLookup
	private WebElement drpdwnDefaultLablStratgy;

	@FindBy(how = How.CSS, using = "#inventory_node_node_label_attributes_account_number")
	@CacheLookup
	private WebElement txtAcctNo;

	public void addInventoryNode(RegionConfigurationData data, String regionGrpName) throws InterruptedException {

	}

	public void editShippingRegionGroups(RegionConfigurationData data, String regionGrpName) throws Exception {

	}

	public void deleteShippingRegionGroups(RegionConfigurationData data, String regionGrpName) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(regionGrpName,1);
		Action.scrollToBottomofPage();
		CommonElementsPage.clickActionsSpanIcon(rowNo, 5, 1);
		CommonElementsPage.clickOnSearchBtn();
	}

}
