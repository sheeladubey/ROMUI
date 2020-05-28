package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.ShippingLabelConfigData;
import com.gsicommerce.romui.selenium.utilities.Action;

public class ShippingLabelConfigPage {

	WebDriver driver;
	Environment env;

	private ShippingLabelConfigData shipConfigdata;

	public ShippingLabelConfigPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_service_provider_name")
	@CacheLookup
	private WebElement drpdwnServiceProviderName;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_description")
	@CacheLookup
	private WebElement txtdwnSellerDescription;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_default_label_strategy")
	@CacheLookup
	private WebElement drpdwnDefaultLabelStrategy;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_country_code")
	@CacheLookup
	private WebElement drpdwnCountry;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='shipping_label_configuration[address_override]']")
	@CacheLookup
	private WebElement chkboxAddressOverride;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_country")
	@CacheLookup
	private WebElement drpdwnCountryOverride;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_address_line1")
	@CacheLookup
	private WebElement txtAddressLine1;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_address_line2")
	@CacheLookup
	private WebElement txtAddressLine2;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_address_line3")
	@CacheLookup
	private WebElement txtAddressLine3;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_city")
	@CacheLookup
	private WebElement txtCity;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_state")
	@CacheLookup
	private WebElement drpdwnState;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_zip_code")
	@CacheLookup
	private WebElement txtZipCode;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_service_provider_attributes_attributes_parent_account_number")
	@CacheLookup
	private WebElement txtParentAccountNumber;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_service_provider_attributes_attributes_parent_key")
	@CacheLookup
	private WebElement txtParentKey;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_service_provider_attributes_attributes_parent_password")
	@CacheLookup
	private WebElement txtParentPassword;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_service_provider_attributes_attributes_signature_option")
	@CacheLookup
	private WebElement txtSignatureOption;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_service_provider_attributes_attributes_label_stock_type")
	@CacheLookup
	private WebElement txtLabelStockType;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_service_provider_attributes_attributes_parent_meter_number")
	@CacheLookup
	private WebElement txtParentMeterNumber;

	// @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add Carrier')]")
	@FindBy(how = How.CSS, using = "[data-additional-carrier=''][type='button']")
	@CacheLookup
	private WebElement btnAddCarrier;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_carrier_attributes_0_carrier_service_name")
	@CacheLookup
	private WebElement drpdwnServiceName;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_carrier_attributes_0_carrier_carrier_code")
	@CacheLookup
	private WebElement drpdwnCarrierCode;

	@FindBy(how = How.CSS, using = "[data-tooltip='Edit']")
	@CacheLookup
	private WebElement btnEditShippingLblConfig;

	@FindBy(how = How.XPATH, using = ".//option")
	@CacheLookup
	private List<WebElement> drpdwnselectServiceProvider;

	@FindBy(how = How.CSS, using = ".alert-info")
	@CacheLookup
	public WebElement txtSuccessMsg;

	@FindBy(how = How.CSS, using = ".btn-default[type='submit']")
	@CacheLookup
	public WebElement btnSave;

	@FindBy(how = How.CSS, using = "[href='/en/sellers/TMSEB2/shipping_label_configurations/new?provider=CONSIGNER']")
	@CacheLookup
	public WebElement btnAdd;

	public void addShippingLabelConfig(int index) throws JsonParseException, JsonMappingException, IOException {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		// CommonElementsPage.clickOnAddBtn();
		Action.waitForElementToBeClickable(driver, btnAdd, 10);
		btnAdd.click();
		Action.selectByVisibleText(drpdwnServiceProviderName, shipConfigdata.getserviceProviderName().get(index));
		Action.enter(txtdwnSellerDescription, shipConfigdata.getsellerDescription());
		Action.selectByIndex(drpdwnDefaultLabelStrategy, 0);
		Action.selectByIndex(drpdwnCountry, 3);
		chkboxAddressOverride.click();
		Action.selectByIndex(drpdwnCountryOverride, 3);
		Action.scrollDown("300");
		Action.enter(txtAddressLine1, shipConfigdata.getAddressLine1());
		Action.enter(txtAddressLine2, shipConfigdata.getAddressLine2());
		// Action.enter(txtAddressLine2, shipConfigdata.getAddressLine3());
		Action.enter(txtCity, shipConfigdata.getCity());
		// Action.enter(txtState, shipConfigdata.getState());
		drpdwnState.click();
		Action.selectByVisibleText(drpdwnState, shipConfigdata.getState());
		Action.enter(txtZipCode, shipConfigdata.getZipcode());
		Action.waitForElementToBeClickable(driver, btnSave, 20);
		// CommonElementsPage.clickOnSaveBtn();
		btnSave.click();
	}

	public void addShippingLabelConfigByFedex(int index) throws JsonParseException, JsonMappingException, IOException {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		// CommonElementsPage.clickOnAddBtn();
		Action.waitForElementToBeClickable(driver, btnAdd, 10);
		btnAdd.click();
		Action.selectByVisibleText(drpdwnServiceProviderName, shipConfigdata.getserviceProviderName().get(index));
		Action.enter(txtdwnSellerDescription, shipConfigdata.getsellerDescription());
		Action.selectByIndex(drpdwnDefaultLabelStrategy, 0);
		Action.selectByIndex(drpdwnCountry, 3);
		chkboxAddressOverride.click();
		Action.selectByIndex(drpdwnCountryOverride, 3);
		Action.scrollDown("500");
		Action.enter(txtAddressLine1, shipConfigdata.getAddressLine1());
		Action.enter(txtAddressLine2, shipConfigdata.getAddressLine2());
		Action.enter(txtAddressLine2, shipConfigdata.getAddressLine3());
		Action.enter(txtCity, shipConfigdata.getCity());
		// Action.enter(txtState, shipConfigdata.getState());
		Action.selectByValue(drpdwnState, shipConfigdata.getState());
		Action.enter(txtZipCode, shipConfigdata.getZipcode());
		Action.waitForElementToBeClickable(driver, btnAddCarrier, 10);
		btnAddCarrier.click();
		Action.selectByIndex(drpdwnServiceName, 1);
		Action.selectByIndex(drpdwnCarrierCode, 1);
		Action.enter(txtParentAccountNumber, shipConfigdata.getparentAccountNumber());
		Action.enter(txtParentKey, shipConfigdata.getparentKey());
		Action.enter(txtParentPassword, shipConfigdata.getparentPassword());
		Action.enter(txtSignatureOption, shipConfigdata.getsignatureOption());
		Action.enter(txtLabelStockType, shipConfigdata.getlabelStockType());
		Action.enter(txtParentMeterNumber, shipConfigdata.getparentMeterNumber());
		Action.waitForElementToBeClickable(driver, btnSave, 10);
		// CommonElementsPage.clickOnSaveBtn();
		btnSave.click();
	}

	public void addShippingLabelConfigByUPS(int index) throws JsonParseException, JsonMappingException, IOException {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		// CommonElementsPage.clickOnAddBtn();
		Action.waitForElementToBeClickable(driver, btnAdd, 10);
		btnAdd.click();
		Action.selectByVisibleText(drpdwnServiceProviderName, shipConfigdata.getserviceProviderName().get(index));
		Action.enter(txtdwnSellerDescription, shipConfigdata.getsellerDescription());
		Action.selectByIndex(drpdwnDefaultLabelStrategy, 0);
		Action.selectByIndex(drpdwnCountry, 3);
		chkboxAddressOverride.click();
		Action.selectByIndex(drpdwnCountryOverride, 3);
		Action.scrollDown("500");
		Action.enter(txtAddressLine1, shipConfigdata.getAddressLine1());
		Action.enter(txtAddressLine2, shipConfigdata.getAddressLine2());
		Action.enter(txtCity, shipConfigdata.getCity());
		// Action.enter(txtState, shipConfigdata.getState());
		Action.selectByValue(drpdwnState, shipConfigdata.getState());
		Action.enter(txtZipCode, shipConfigdata.getZipcode());
		Action.waitForElementToBeClickable(driver, btnAddCarrier, 10);
		btnAddCarrier.click();
		Action.selectByIndex(drpdwnServiceName, 1);
		Action.selectByIndex(drpdwnCarrierCode, 1);
		Action.waitForElementToBeClickable(driver, btnSave, 10);
		btnSave.click();
		// CommonElementsPage.clickOnSaveBtn();
	}

	public void editShippingLabelConfigByUPS(int index) throws JsonParseException, JsonMappingException, IOException {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		btnEditShippingLblConfig.click();
		Action.selectByVisibleText(drpdwnServiceProviderName, shipConfigdata.getserviceProviderName().get(index));
		Action.enter(txtdwnSellerDescription, shipConfigdata.getsellerDescription());
		Action.selectByIndex(drpdwnDefaultLabelStrategy, 0);
		Action.selectByIndex(drpdwnCountry, 3);
		chkboxAddressOverride.click();
		Action.waitForElementToBeClickable(driver, btnAddCarrier, 10);
		btnAddCarrier.click();
		Action.waitForElementToBeClickable(driver, drpdwnServiceName, 10);
		Action.selectByIndex(drpdwnServiceName, 2);
		Action.selectByIndex(drpdwnCarrierCode, 2);
		// Common.waitForElementPresent(driver, btnSave, 20);
		Action.waitForElementToBeClickable(driver, btnSave, 20);
		// CommonElementsPage.clickOnSaveBtn();
		btnSave.click();
	}

	public void editShippingLabelConfigByFedex(int index) throws JsonParseException, JsonMappingException, IOException {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		btnEditShippingLblConfig.click();
		Action.selectByVisibleText(drpdwnServiceProviderName, shipConfigdata.getserviceProviderName().get(index));
		Action.enter(txtdwnSellerDescription, shipConfigdata.getsellerDescription());
		Action.selectByIndex(drpdwnDefaultLabelStrategy, 0);
		Action.selectByIndex(drpdwnCountry, 3);
		chkboxAddressOverride.click();
		System.out.println("clicked override address");
		Action.selectByIndex(drpdwnCountryOverride, 3);
		Action.scrollDown("300");
		Action.enter(txtAddressLine1, shipConfigdata.getAddressLine1());
		System.out.println("Entered address1");
		Action.enter(txtAddressLine2, shipConfigdata.getAddressLine2());
		Action.enter(txtCity, shipConfigdata.getCity());
		// Action.enter(txtState, shipConfigdata.getState());
		Action.enter(txtZipCode, shipConfigdata.getZipcode());
		Action.selectByIndex(drpdwnServiceName, 2);
		Action.selectByIndex(drpdwnCarrierCode, 2);
		Action.enter(txtParentAccountNumber, shipConfigdata.getparentAccountNumber());
		Action.enter(txtParentKey, shipConfigdata.getparentKey());
		Action.enter(txtParentPassword, shipConfigdata.getparentPassword());
		Action.enter(txtSignatureOption, shipConfigdata.getsignatureOption());
		Action.enter(txtLabelStockType, shipConfigdata.getlabelStockType());
		Action.enter(txtParentMeterNumber, shipConfigdata.getparentMeterNumber());
		CommonElementsPage.clickOnSaveBtn();
	}

	public void editShippingLabelConfigByConsignor(int index)
			throws JsonParseException, JsonMappingException, IOException {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		btnEditShippingLblConfig.click();
		Action.selectByVisibleText(drpdwnServiceProviderName, shipConfigdata.getserviceProviderName().get(index));
		Action.enter(txtdwnSellerDescription, shipConfigdata.getsellerDescription());
		Action.selectByIndex(drpdwnDefaultLabelStrategy, 0);
		Action.selectByIndex(drpdwnCountry, 3);
		chkboxAddressOverride.click();
		System.out.println("clicked override address");
		Action.selectByIndex(drpdwnCountryOverride, 3);
		Action.scrollDown("300");
		Action.enter(txtAddressLine1, shipConfigdata.getAddressLine1());
		System.out.println("Entered address1");
		Action.enter(txtAddressLine2, shipConfigdata.getAddressLine2());
		Action.enter(txtCity, shipConfigdata.getCity());
		// Action.enter(txtState, shipConfigdata.getState());
		Action.enter(txtZipCode, shipConfigdata.getZipcode());
		CommonElementsPage.clickOnSaveBtn();
	}

	public String selectGroupName(String groupName, int index) {
		// shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		// drpdwnServiceProviderName.click();
		List<WebElement> groupname = driver.findElements(By.cssSelector(
				"tr.reflow-table-row[data-lookup-id='shipConfigdata.getserviceProviderName().get(index)']"));
		for (int i = 0; i < groupname.size(); i++) {
			System.out.println("first group name is:" + groupname.get(i).getText());
			if (groupname.get(i).getText().equals(shipConfigdata.getserviceProviderName().get(index))) {
				// Action.(btnEditShippingLblConfig,groupname);
				btnEditShippingLblConfig.click();
				break;
			}
		}
		System.out.println("group name List is :" + groupName);
		return groupName;
	}
}
