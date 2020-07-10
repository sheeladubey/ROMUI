package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.ShippingLabelConfigData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class ShippingLabelConfigPage {

	WebDriver driver;
	Environment env;
	private ShippingLabelConfigData shipConfigdata;
	private static String serviceProviderConfig;
	private static String editServiceProviderConfig;
	private static int rowNoGroupName;
	private static int rowNoEditGroupName;

	public ShippingLabelConfigPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_service_provider_name")
	private WebElement drpdwnServiceProviderName;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_description")
	private WebElement txtdwnSellerDescription;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_default_label_strategy")
	private WebElement drpdwnDefaultLabelStrategy;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_country_code")
	private WebElement drpdwnCountry;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='shipping_label_configuration[address_override]']")
	private WebElement chkboxAddressOverride;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_country")
	private WebElement drpdwnCountryOverride;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_address_line1")
	private WebElement txtAddressLine1;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_address_line2")
	private WebElement txtAddressLine2;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_address_line3")
	private WebElement txtAddressLine3;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_city")
	private WebElement txtCity;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_state")
	private WebElement drpdwnState;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_seller_address_override_attributes_zip_code")
	private WebElement txtZipCode;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_service_provider_attributes_attributes_parent_account_number")
	private WebElement txtParentAccountNumber;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_service_provider_attributes_attributes_parent_key")
	private WebElement txtParentKey;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_service_provider_attributes_attributes_parent_password")
	private WebElement txtParentPassword;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_service_provider_attributes_attributes_signature_option")
	private WebElement txtSignatureOption;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_service_provider_attributes_attributes_label_stock_type")
	private WebElement txtLabelStockType;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_service_provider_attributes_attributes_parent_meter_number")
	private WebElement txtParentMeterNumber;

	// @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add Carrier')]")
	@FindBy(how = How.CSS, using = "[data-additional-carrier=''][type='button']")
	private WebElement btnAddCarrier;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_carrier_attributes_0_carrier_service_name")
	private WebElement drpdwnServiceName;

	@FindBy(how = How.CSS, using = "#shipping_label_configuration_carrier_attributes_0_carrier_carrier_code")
	private WebElement drpdwnCarrierCode;

	@FindBy(how = How.CSS, using = "[data-tooltip='Edit']")
	private WebElement btnEditShippingLblConfig;

	@FindBy(how = How.XPATH, using = ".//option")
	private List<WebElement> StateSearchSelectDropDownOption;

	@FindBy(how = How.CSS, using = ".alert-info")
	public WebElement txtSuccessMsg;

	@FindBy(how = How.CSS, using = ".btn-default[type='submit']")
	public WebElement btnSave;

	@FindBy(how = How.CSS, using = "[href='/en/sellers/TMSEB2/shipping_label_configurations/new?provider=CONSIGNER']")
	public WebElement btnAdd;

	@FindBy(how = How.CSS, using = "[data-shipping-label-configuration-carrier-delete=''][value='fulfillment-node-sourcing-index-0']")
	public WebElement btnDeleteCarrier;

	public void addShippingLabelConfig(int shipconfigindex)
			throws JsonParseException, JsonMappingException, IOException, Exception {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		serviceProviderConfig = shipConfigdata.getserviceProviderName().get(shipconfigindex);
		Action.waitForElementToBeClickable(driver, btnAdd, 10);
		Action.clickUsingJavaScipt(btnAdd);
		Action.waitForElementToBeClickable(driver, drpdwnServiceProviderName, 20);
		Action.selectByVisibleText(drpdwnServiceProviderName, serviceProviderConfig);
		Common.waitForPageLoaded(driver);
		Action.waitForElementToBeClickable(driver, txtdwnSellerDescription, 20);
		Action.enter(txtdwnSellerDescription, shipConfigdata.getsellerDescription());
		Action.selectByVisibleText(drpdwnDefaultLabelStrategy, shipConfigdata.getDefaultLabelStrategy());
		drpdwnCountry.click();
		Action.selectByVisibleText(drpdwnCountry, shipConfigdata.getcountry().get(2));
		// chkboxAddressOverride.click();
		Action.clickUsingJavaScipt(chkboxAddressOverride);
		Action.selectByVisibleText(drpdwnCountryOverride, shipConfigdata.getcountry().get(2));
		Action.scrollToBottomofPage();
		Action.enter(txtAddressLine1, shipConfigdata.getAddressLine1());
		Action.enter(txtAddressLine2, shipConfigdata.getAddressLine2());
		Action.enter(txtAddressLine3, shipConfigdata.getAddressLine3());
		Action.enter(txtCity, shipConfigdata.getCity());
		/*
		 * Action.waitForElementToBeVisible(driver, drpdwnState, 10);
		 * Action.clickElementJavaScipt(drpdwnState);
		 * Action.scrollingToElementofAPage(drpdwnState);
		 * CommonElementsPage.selectDropDwnValues(drpdwnState,
		 * shipConfigdata.getState()); Action.selectByValue(drpdwnState,
		 * shipConfigdata.getState()); Action.waitForElementPresent(driver, drpdwnState,
		 * 30); Action.clickElementJavaScipt(drpdwnState);
		 * selectStateDropdown(shipConfigdata.getState());
		 * Action.selectByVisibleText(drpdwnState,"Pennsylvania" );
		 */
		Action.enter(txtZipCode, shipConfigdata.getZipcode());
		if (serviceProviderConfig.equals("CONSIGNOR")) {
			Action.waitForElementToBeClickable(driver, btnSave, 20);
			btnSave.click();
			rowNoGroupName = CommonElementsPage.getRowNo(serviceProviderConfig, 1);
			System.out.println("Selected row is :" + CommonElementsPage.getRowNo(serviceProviderConfig, 1));
			System.out.println("Row text selected:"
					+ CommonElementsPage.getRowCellTextVal(rowNoGroupName, 1).equals(serviceProviderConfig));
			Assert.assertTrue(CommonElementsPage.getRowCellTextVal(rowNoGroupName, 1).contains(serviceProviderConfig),
					"NEW SHIPPING LABEL CONFIGURATION for service provider CONSIGNOR has not been added");
		}
		if (serviceProviderConfig.equals("CONSIGNOR_MOCK")) {
			Action.waitForElementToBeClickable(driver, btnSave, 20);
			btnSave.click();
			rowNoGroupName = CommonElementsPage.getRowNo(serviceProviderConfig, 1);
			System.out.println("Selected row is :" + CommonElementsPage.getRowNo(serviceProviderConfig, 1));
			System.out.println("Row text selected:" + CommonElementsPage.getRowCellTextVal(rowNoGroupName, 1));
			Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowNoGroupName, 1), serviceProviderConfig,
					"NEW SHIPPING LABEL CONFIGURATION for service provider CONSIGNOR_MOCK has not been added");
		}
		if (serviceProviderConfig.equals("FEDEX")) {
			Action.scrollToBottomofPage();
			Action.waitForElementToBeClickable(driver, btnAddCarrier, 10);
			// btnAddCarrier.click();
			Action.clickUsingJavaScipt(btnAddCarrier);
			Action.waitForElementToBeClickable(driver, drpdwnServiceName, 10);
			drpdwnServiceName.click();
			Action.selectByVisibleText(drpdwnServiceName, shipConfigdata.getServiceName().get(1));
			Action.waitForElementToBeClickable(driver, drpdwnCarrierCode, 10);
			drpdwnCarrierCode.click();
			Action.selectByVisibleText(drpdwnCarrierCode, shipConfigdata.getCarrierCode());
			Action.waitForElementToBeClickable(driver, txtParentAccountNumber, 10);
			Action.enter(txtParentAccountNumber, shipConfigdata.getparentAccountNumber());
			Action.waitForElementToBeClickable(driver, txtParentKey, 10);
			Action.enter(txtParentKey, shipConfigdata.getparentKey());
			Action.enter(txtParentPassword, shipConfigdata.getparentPassword());
			Action.enter(txtSignatureOption, shipConfigdata.getsignatureOption());
			Action.enter(txtLabelStockType, shipConfigdata.getlabelStockType());
			Action.enter(txtParentMeterNumber, shipConfigdata.getparentMeterNumber());
			Action.waitForElementToBeClickable(driver, btnSave, 10);
			Action.clickUsingJavaScipt(btnSave);
			rowNoGroupName = CommonElementsPage.getRowNo(serviceProviderConfig, 1);
			System.out.println("Selected row is :" + CommonElementsPage.getRowNo(serviceProviderConfig, 1));
			System.out.println("Row text selected:" + CommonElementsPage.getRowCellTextVal(rowNoGroupName, 1));
			Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowNoGroupName, 1), serviceProviderConfig,
					"NEW SHIPPING LABEL CONFIGURATION for service provider FEDEX has not been added");
		}
		if (serviceProviderConfig.equals("UPS")) {
			Action.waitForElementToBeClickable(driver, btnAddCarrier, 10);
			btnAddCarrier.click();
			Action.scrollToBottomofPage();
			Action.waitForElementToBeClickable(driver, drpdwnServiceName, 10);
			drpdwnServiceName.click();
			Action.selectByVisibleText(drpdwnServiceName, shipConfigdata.getServiceName().get(1));
			Action.waitForElementToBeClickable(driver, drpdwnCarrierCode, 10);
			Action.selectByVisibleText(drpdwnCarrierCode, shipConfigdata.getUPSCarrierCode());
			Action.waitForElementToBeClickable(driver, btnSave, 10);
			Action.clickUsingJavaScipt(btnSave);
			rowNoGroupName = CommonElementsPage.getRowNo(serviceProviderConfig, 1);
			System.out.println("Selected row is :" + CommonElementsPage.getRowNo(serviceProviderConfig, 1));
			System.out.println("Row text selected:" + CommonElementsPage.getRowCellTextVal(rowNoGroupName, 1));
			Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowNoGroupName, 1), serviceProviderConfig,
					"NEW SHIPPING LABEL CONFIGURATION for service provider UPS has not been added");
		}
		if (serviceProviderConfig.equals("UPS_MOCK")) {
			Action.waitForElementToBeClickable(driver, btnSave, 10);
			Action.clickUsingJavaScipt(btnSave);
			rowNoGroupName = CommonElementsPage.getRowNo(serviceProviderConfig, 1);
			System.out.println("Selected row is :" + CommonElementsPage.getRowNo(serviceProviderConfig, 1));
			System.out.println("Row text selected:" + CommonElementsPage.getRowCellTextVal(rowNoGroupName, 1));
			Assert.assertTrue(CommonElementsPage.getRowCellTextVal(rowNoGroupName, 1).contains(serviceProviderConfig),
					"NEW SHIPPING LABEL CONFIGURATION for service provider UPS_MOCK has not been added");
		}
	}

	public void editShippingLabelConfig(int editshipLabelConfigindex) throws Exception {
		shipConfigdata = ShippingLabelConfigData.get(env.getFileLocation());
		editServiceProviderConfig = shipConfigdata.getserviceProviderName().get(editshipLabelConfigindex);
		// Get selected row
		rowNoEditGroupName = CommonElementsPage.getRowNo(editServiceProviderConfig, 1);
		System.out.println("Selected row is:" + rowNoEditGroupName);
		CommonElementsPage.clickActionsSpanIcon(rowNoEditGroupName, 3, 0);
		if (editServiceProviderConfig.equals("CONSIGNOR")) {
			Action.waitForElementToBeClickable(driver, txtdwnSellerDescription, 20);
			txtdwnSellerDescription.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Action.enter(txtdwnSellerDescription, shipConfigdata.getsellerDescription());
			if (!chkboxAddressOverride.isSelected()) {
				chkboxAddressOverride.click();
				Action.selectByVisibleText(drpdwnCountryOverride, shipConfigdata.getcountry().get(2));
				Action.scrollToBottomofPage();
				Action.enter(txtAddressLine1, shipConfigdata.getAddressLine1());
				Action.enter(txtAddressLine2, shipConfigdata.getAddressLine2());
				Action.enter(txtAddressLine3, shipConfigdata.getAddressLine3());
				Action.enter(txtCity, shipConfigdata.getCity());

			} else {
				chkboxAddressOverride.click();
			}

		}
		if (editServiceProviderConfig.equals("CONSIGNOR_MOCK")) {
			Action.waitForElementToBeClickable(driver, txtdwnSellerDescription, 20);
			txtdwnSellerDescription.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Action.enter(txtdwnSellerDescription, shipConfigdata.getsellerDescription());
			if (!chkboxAddressOverride.isSelected()) {
				chkboxAddressOverride.click();
				Action.selectByVisibleText(drpdwnCountryOverride, shipConfigdata.getcountry().get(2));
				Action.scrollToBottomofPage();
				Action.enter(txtAddressLine1, shipConfigdata.getAddressLine1());
				Action.enter(txtAddressLine2, shipConfigdata.getAddressLine2());
				Action.enter(txtAddressLine3, shipConfigdata.getAddressLine3());
				Action.enter(txtCity, shipConfigdata.getCity());

			} else {
				chkboxAddressOverride.click();
			}
		}
		if (editServiceProviderConfig.equals("FEDEX")) {
			Action.waitForElementToBeClickable(driver, txtdwnSellerDescription, 20);
			txtdwnSellerDescription.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Action.enter(txtdwnSellerDescription, shipConfigdata.getsellerDescription());
			drpdwnCountry.click();
			Action.selectByVisibleText(drpdwnCountry, shipConfigdata.getcountry().get(2));
			if (!chkboxAddressOverride.isSelected()) {
				chkboxAddressOverride.click();
				Action.selectByVisibleText(drpdwnCountryOverride, shipConfigdata.getcountry().get(2));
				Action.scrollToBottomofPage();
				Action.enter(txtAddressLine1, shipConfigdata.getAddressLine1());
				Action.enter(txtAddressLine2, shipConfigdata.getAddressLine2());
				Action.enter(txtAddressLine3, shipConfigdata.getAddressLine3());
				Action.enter(txtCity, shipConfigdata.getCity());

			} else {
				chkboxAddressOverride.click();
			}
			txtParentPassword.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Action.enter(txtParentPassword, shipConfigdata.getparentPassword());

		}
		if (editServiceProviderConfig.equals("UPS")) {
			Action.waitForElementToBeClickable(driver, txtdwnSellerDescription, 20);
			txtdwnSellerDescription.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Action.enter(txtdwnSellerDescription, shipConfigdata.getsellerDescription());
			if (!chkboxAddressOverride.isSelected()) {
				chkboxAddressOverride.click();
				Action.selectByVisibleText(drpdwnCountryOverride, shipConfigdata.getcountry().get(2));
				Action.scrollToBottomofPage();
				Action.enter(txtAddressLine1, shipConfigdata.getAddressLine1());
				Action.enter(txtAddressLine2, shipConfigdata.getAddressLine2());
				Action.enter(txtAddressLine3, shipConfigdata.getAddressLine3());
				Action.enter(txtCity, shipConfigdata.getCity());

			} else {
				chkboxAddressOverride.click();
			}
			Action.scrollToBottomofPage();
			if (!btnDeleteCarrier.isDisplayed()) {
				Action.waitForElementToBeClickable(driver, btnAddCarrier, 20);
				btnAddCarrier.click();
				Action.waitForElementToBeClickable(driver, drpdwnServiceName, 20);
				drpdwnServiceName.click();
				Action.selectByVisibleText(drpdwnServiceName, shipConfigdata.getServiceName().get(1));
				Action.waitForElementToBeClickable(driver, drpdwnCarrierCode, 10);
				Action.selectByVisibleText(drpdwnCarrierCode, shipConfigdata.getUPSCarrierCode());

			} else {
				Action.waitForElementToBeClickable(driver, btnDeleteCarrier, 20);
				btnDeleteCarrier.click();
			}
		}
		if (editServiceProviderConfig.equals("UPS_MOCK")) {
			Action.waitForElementToBeClickable(driver, txtdwnSellerDescription, 20);
			txtdwnSellerDescription.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Action.enter(txtdwnSellerDescription, shipConfigdata.getsellerDescription());
			if (!chkboxAddressOverride.isSelected()) {
				chkboxAddressOverride.click();
				Action.selectByVisibleText(drpdwnCountryOverride, shipConfigdata.getcountry().get(2));
				Action.scrollToBottomofPage();
				Action.enter(txtAddressLine1, shipConfigdata.getAddressLine1());
				Action.enter(txtAddressLine2, shipConfigdata.getAddressLine2());
				Action.enter(txtAddressLine3, shipConfigdata.getAddressLine3());
				Action.enter(txtCity, shipConfigdata.getCity());

			} else {
				chkboxAddressOverride.click();
			}
		}
		Action.waitForElementToBeClickable(driver, btnSave, 20);
		btnSave.click();
	}

	public void shipLabelConfigFormValidation()
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		Action.waitForElementToBeClickable(driver, btnAdd, 10);
		Action.clickUsingJavaScipt(btnAdd);
		Action.waitForElementToBeClickable(driver, btnSave, 20);
		btnSave.click();
		Assert.assertEquals(CommonElementsPage.txtAlertErrorMsg.getText(), RomuiEnumValues.FORM_ERROR.getMessage(),
				"shipping Label form Error Validation message has not been found");

	}

}
