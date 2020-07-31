package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;

import org.openqa.selenium.Keys;
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
import com.gsicommerce.romui.selenium.testdata.ReasonCodesData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;


public class ReasonCodesPage {

	WebDriver driver;
	Environment env;

	private ReasonCodesData reasonCodesData;
	private static String returnCode;
	private static String returnType;
	private static int returnCodeRow;

	public ReasonCodesPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='btn-default btn']//span[contains(text(),'Add')]")
	private WebElement btnAddReason;

	@FindBy(how = How.CSS, using = "#orders_reason_code_id")
	private WebElement txtboxName;

	@FindBy(how = How.CSS, using = "#orders_reason_code_type")
	private WebElement drpdwnType;

	@FindBy(how = How.CSS, using = "#orders_reason_code_description")
	private WebElement txtboxDescription;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save')]")
	private WebElement btnSaveReason;

	@FindBy(how = How.CSS, using = ".alert-info")
	public WebElement txtSuccessMsg;

	@FindBy(how = How.CSS, using = "[data-disable-with='Confirm'][value='Confirm']")
	private WebElement btnConfirm;

	public void addReasonCodes(int indextype) throws Exception {
		reasonCodesData = ReasonCodesData.get(env.getFileLocation());
		Action.waitForElementToBeClickable(driver, btnAddReason, 10);
		Action.clickUsingJavaScipt(btnAddReason);
		Common.waitForPageLoaded(driver);
		returnCode = reasonCodesData.getName();
		System.out.println("Reason Code Name going to Add is:" + returnCode);
		Reporter.log("Reason Code Name going to Add is:" + returnCode);
		Action.enter(txtboxName, returnCode);
		returnType = reasonCodesData.getType().get(indextype);
		System.out.println("Selected Type is::" + returnType);
		Reporter.log("Selected Type is::" + returnType);
		Action.selectByVisibleText(drpdwnType, returnType);
		System.out.println("Reason code Description is::" + reasonCodesData.getDescription());
		Action.enter(txtboxDescription, reasonCodesData.getDescription());
		Action.waitForElementToBeClickable(driver, btnSaveReason, 10);
		btnSaveReason.click();

	}

	public void duplicateReasonCode(int indextype) throws Exception {
		reasonCodesData = ReasonCodesData.get(env.getFileLocation());
		Action.waitForElementToBeClickable(driver, btnAddReason, 10);
		Action.clickUsingJavaScipt(btnAddReason);
		Common.waitForPageLoaded(driver);
		System.out.println("Reason Code Name going to Add is:" + returnCode);
		Reporter.log("Reason Code Name going to Add is:" + returnCode);
		Action.enter(txtboxName, returnCode);
		System.out.println("Selected Type is::" + returnType);
		Action.selectByVisibleText(drpdwnType, returnType);
		Action.enter(txtboxDescription, reasonCodesData.getDescription());
		Action.waitForElementToBeClickable(driver, btnSaveReason, 10);
		btnSaveReason.click();
		Assert.assertEquals(CommonElementsPage.txtAlertErrorMsg.getText(),
				RomuiEnumValues.REASONCODES_DUPLICATE.getMessage(), "USER can add duplicate Reason code");
	}

	public void editReasonCode(int indextype) throws Exception {
		reasonCodesData = ReasonCodesData.get(env.getFileLocation());
		returnType = reasonCodesData.getType().get(indextype);
		System.out.println("Selected Type is::" + returnType);
		System.out.println("Reason Code Name Added is:" + returnCode);
	/*	if(returnType=="Return")
		{
		returnCodeRow = CommonElementsPage.getRowNoListofTable(returnCode, 1,1);
		}*/
		returnCodeRow = CommonElementsPage.getRowNoListofTable(returnCode, 1,2);
		System.out.println("Selected return code row is::" + returnCodeRow);
		if(returnType=="Order Modify")
		{
		//returnCodeRow = CommonElementsPage.getRowNoListofTable(returnCode, 1,2);
		//}
		System.out.println("Selected return code row is::" + returnCodeRow);
		System.out.println(
				"Selected return code for Edit Action is::" + CommonElementsPage.getRowCellTextVal(returnCodeRow, 1));
		System.out.println("click Edit Reason Icon");
		Reporter.log("click Edit Reason Icon");
		CommonElementsPage.clickDivSpanLink(returnCodeRow, 4, 1, 1, 1);
		/*
		 * System.out.println("Validate Name and Type fields are non editable");
		 * Reporter.log("Validate Name and Type fields are non editable");
		 * Assert.assertTrue(txtboxName.getAttribute("hidden").equals("true"),
		 * "Reason Code Name is editable filed");
		 * Assert.assertTrue(drpdwnType.getAttribute("hidden").equals("true"),
		 * "Reason Code Type is editable filed");
		 */
		Common.waitForPageLoaded(driver);
		Action.waitForElementToBeClickable(driver, txtboxDescription, 30);
		txtboxDescription.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Action.enter(txtboxDescription, reasonCodesData.getDescription());
		Action.waitForElementToBeClickable(driver, btnSaveReason, 10);
		Action.clickUsingJavaScipt(btnSaveReason);
		}
	}

	public void deleteReasonCode() throws Exception {
		reasonCodesData = ReasonCodesData.get(env.getFileLocation());
		System.out.println("Selected return code row is::" + returnCodeRow);
		Reporter.log("Selected return code row is::" + returnCodeRow);
		System.out.println(
				"Selected return code for Delete Action is::" + CommonElementsPage.getRowCellTextVal(returnCodeRow, 1));
		Reporter.log(
				"Selected return code for Delete Action is::" + CommonElementsPage.getRowCellTextVal(returnCodeRow, 1));
		System.out.println("click Delete Reason Icon");
		Reporter.log("click Delete Reason Icon");
		CommonElementsPage.clickSelectLink(returnCodeRow, 4, 1, 1);
		btnConfirm.click();

	}

	// Below method is for Reason Code form validation
	public void formValidationReasonCode()
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {

		Action.waitForElementToBeClickable(driver, btnAddReason, 10);
		Action.clickUsingJavaScipt(btnAddReason);
		Action.waitForElementToBeClickable(driver, btnSaveReason, 10);
		Action.clickUsingJavaScipt(btnSaveReason);
		Assert.assertEquals(CommonElementsPage.txtAlertErrorMsg.getText(), RomuiEnumValues.FORM_ERROR.getMessage(),
				"Reason Code form Error Validation message has not been found");
	}
}
