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
import com.gsicommerce.romui.selenium.testdata.PaymentMethodConfigData;
import com.gsicommerce.romui.selenium.utilities.Action;

public class PaymentMethodConfigPage {

	WebDriver driver;
	Environment env;

	private PaymentMethodConfigData data;

	public PaymentMethodConfigPage(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "[data-tooltip='Edit']")
	@CacheLookup
	private WebElement lkEdit;

	@FindBy(how = How.CSS, using = "[data-tooltip='Delete']")
	@CacheLookup
	private WebElement lkDelete;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_payment_method_code")
	@CacheLookup
	private WebElement drpdwnPaymntMethdCode;

	@FindBy(how = How.CSS, using = "[name='payment_method_configuration[active]'][type='checkbox']")
	@CacheLookup
	private WebElement chkboxActive;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_description")
	@CacheLookup
	private WebElement txtAreaDescrp;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_min_wait_time_in_hrs_for_consolidation")
	@CacheLookup
	private WebElement txtMinWaitTimeForConsoldtion;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_auth_expiry_in_hrs")
	@CacheLookup
	private WebElement txtAuthexpiry;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_auth_reversal_in_hrs")
	@CacheLookup
	private WebElement txtAuthReversal;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_auth_reversal_strategy")
	@CacheLookup
	private WebElement drpdwnAuthRevrslStrgy;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_cash_back_limit")
	@CacheLookup
	private WebElement txtCashbackLmt;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_charge_sequence")
	@CacheLookup
	private WebElement txtChargeSequnce;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_new_refund_payment_method_code")
	@CacheLookup
	private WebElement drpdwnNewRefundPaymtMethdCode;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_refund_constraint_operator")
	@CacheLookup
	private WebElement drpdwnRefundConstrnOprtor;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_refund_constraint_payment_method_code")
	@CacheLookup
	private WebElement drpdwnRefundConstrtPaymtMethdCode;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_refund_constraint_value")
	@CacheLookup
	private WebElement txtRefundConstrtValue;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_refund_sequence")
	@CacheLookup
	private WebElement txtRefundSeqnce;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_refund_item_id")
	@CacheLookup
	private WebElement txtRefundItemID;

	@FindBy(how = How.CSS, using = "#payment_method_configuration_refund_item_uom")
	@CacheLookup
	private WebElement txtRefundItemUOM;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='payment_method_configuration[refund_same_account]']")
	@CacheLookup
	private WebElement chkboxRefndSameAcct;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='payment_method_configuration[refund_requires_fulfillment]']")
	@CacheLookup
	private WebElement chkboxRefndRqrsFulfilmnt;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='payment_method_configuration[zero_value_auth_supported]']")
	@CacheLookup
	private WebElement chkboxZeroValAuthSupprtd;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='payment_method_configuration[allow_charge_consolidation]']")
	@CacheLookup
	private WebElement chkboxAllowChrgConsoldtn;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='payment_method_configuration[allow_exceed_settlement_over_auth]']")
	@CacheLookup
	private WebElement chkboxAllowExcedSettlmntOverAuth;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='payment_method_configuration[charge_instead_of_auth]']")
	@CacheLookup
	private WebElement chkboxChargeInstdOfAuth;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='payment_method_configuration[charge_upto_available]']")
	@CacheLookup
	private WebElement chkboxChargeUptoAvalble;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='payment_method_configuration[confirm_funds]']")
	@CacheLookup
	private WebElement chkboxConfrmFunds;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='payment_method_configuration[default_for_return]']")
	@CacheLookup
	private WebElement chkboxDefaultForReturn;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='payment_method_configuration[processing_required]']")
	@CacheLookup
	private WebElement chkboxProcessngReqrd;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='payment_method_configuration[partial_reversal_supported]']")
	@CacheLookup
	private WebElement chkboxPartialRevrslSupprtd;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='payment_method_configuration[valid_for_return]']")
	@CacheLookup
	private WebElement chkboxValidForReturn;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='payment_method_configuration[voidable]']")
	@CacheLookup
	private WebElement chkboxVoidable;

	@FindBy(how = How.CSS, using = ".alert-info")
	@CacheLookup
	public WebElement txtEditSuccessMsg;

	@FindBy(how = How.CSS, using = "[data-disable-with='Confirm']")
	@CacheLookup
	public WebElement btnConfirm;

	public void editPaymentMethodConfig(int index) throws JsonParseException, JsonMappingException, IOException {
		data = PaymentMethodConfigData.get(env.getFileLocation());
		lkEdit.click();
		Action.waitForElementToBeClickable(driver, drpdwnPaymntMethdCode, 10);
		Action.selectByVisibleText(drpdwnPaymntMethdCode, data.getPaymentMethodCode().get(index));
		Action.enter(txtAreaDescrp, data.getDescription());
		Action.enter(txtMinWaitTimeForConsoldtion, data.getMinWaitTime());
		Action.enter(txtAuthexpiry, data.getAutoExpiry());
		CommonElementsPage.clickOnSaveBtn();
	}

	public void addPaymentMethodConfig(int index) throws JsonParseException, JsonMappingException, IOException {
		data = PaymentMethodConfigData.get(env.getFileLocation());
		CommonElementsPage.clickOnAddBtn();
		Action.waitForElementToBeClickable(driver, drpdwnPaymntMethdCode, 10);
		Action.selectByVisibleText(drpdwnPaymntMethdCode, data.getPaymentMethodCode().get(index));
		chkboxActive.click();
		Action.enter(txtAreaDescrp, data.getDescription());
		Action.enter(txtMinWaitTimeForConsoldtion, data.getMinWaitTime());
		Action.enter(txtAuthexpiry, data.getAutoExpiry());
		Action.enter(txtAuthReversal, data.getAuthReversal());
		Action.selectByIndex(drpdwnAuthRevrslStrgy, 1);
		Action.enter(txtCashbackLmt, data.getCashbackLimit());
		Action.enter(txtChargeSequnce, data.getChargeSequence());
		Action.selectByIndex(drpdwnNewRefundPaymtMethdCode, 1);
		Action.selectByIndex(drpdwnRefundConstrnOprtor, 1);
		Action.selectByIndex(drpdwnRefundConstrtPaymtMethdCode, 1);
		Action.enter(txtRefundConstrtValue, data.getrefundConstraintValue());
		Action.enter(txtRefundSeqnce, data.getRefundSequence());
		Action.enter(txtRefundItemID, data.getRefundItemID());
		Action.enter(txtRefundItemUOM, data.getRefundItemUOM());
		Action.scrollDown("500");
		chkboxRefndSameAcct.click();
		chkboxRefndRqrsFulfilmnt.click();
		chkboxZeroValAuthSupprtd.click();
		chkboxAllowChrgConsoldtn.click();
		chkboxAllowExcedSettlmntOverAuth.click();
		chkboxChargeInstdOfAuth.click();
		chkboxChargeUptoAvalble.click();
		chkboxConfrmFunds.click();
		chkboxDefaultForReturn.click();
		chkboxProcessngReqrd.click();
		chkboxPartialRevrslSupprtd.click();
		chkboxValidForReturn.click();
		chkboxVoidable.click();
		CommonElementsPage.clickOnSaveBtn();
	}

	public void deletePaymentMethodConfig() throws InterruptedException {
		lkDelete.click();
		Action.waitForElementToBeClickable(driver, btnConfirm, 10);
		btnConfirm.click();
	}

}
