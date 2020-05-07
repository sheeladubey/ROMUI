package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;

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
	Action action;
	private ShippingLabelConfigData shipConfigdata;

	public ShippingLabelConfigPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);
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
	
	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_city")
	@CacheLookup
	private WebElement txtCity;
	
	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_state")
	@CacheLookup
	private WebElement txtState;
	
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

	public void addShippingLabelConfig() throws JsonParseException, JsonMappingException, IOException {
		shipConfigdata =ShippingLabelConfigData.get(env.getFileLocation());
		CommonElementsPage.clickOnAddBtn();
		Action.selectByIndex(drpdwnServiceProviderName, 2);
		Action.enter(txtdwnSellerDescription, shipConfigdata.getsellerDescription());
		Action.selectByIndex(drpdwnDefaultLabelStrategy,0);
		Action.selectByIndex(drpdwnCountry,3);
		chkboxAddressOverride.click();
		System.out.println("clicked override address");
		Action.selectByIndex(drpdwnCountryOverride,3);
		Action.enter(txtParentAccountNumber, shipConfigdata.getAddressLine1());
		System.out.println("Entered address1");
		Action.enter(txtParentAccountNumber, shipConfigdata.getAddressLine2());
		Action.enter(txtParentAccountNumber, shipConfigdata.getCity());
		Action.enter(txtParentAccountNumber, shipConfigdata.getState());
		Action.enter(txtParentAccountNumber, shipConfigdata.getZipcode());
		Action.enter(txtParentAccountNumber, shipConfigdata.getparentAccountNumber());
		Action.enter(txtParentKey, shipConfigdata.getparentKey());
		Action.enter(txtParentPassword, shipConfigdata.getparentPassword());
		Action.enter(txtSignatureOption, shipConfigdata.getsignatureOption());
		Action.enter(txtLabelStockType, shipConfigdata.getlabelStockType());
		Action.enter(txtParentMeterNumber, shipConfigdata.getparentMeterNumber());
		CommonElementsPage.clickOnSaveBtn();
	}
}
