package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.testdata.ReasonCodesData;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class ReasonCodesTests extends ROMUIBasePage {

	private ReasonCodesData reasonCodesData;

	@Test(enabled = true, priority = 1, description = "To Verify User able to add Reason Code for type Order Modify")
	public void testAddReasonCodeByOrderModify()
			throws JsonParseException, JsonMappingException, IOException, Exception {
		reasonCodesData = ReasonCodesData.get(env.getFileLocation());
		Reporter.log("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		Reporter.log("Select Seller and Node");
		romuipages.loginPage().selectNode(reasonCodesData.getStoreIndex(), reasonCodesData.getNodeID());
		Reporter.log("Click Reason Code link");
		romuipages.orderMgmPage().clickOnReasonCodes();
		Reporter.log("Navigated to Reason Code page");
		Reporter.log("Add reason code data for type Order Modify");
		romuipages.reasonCodesPage().addReasonCodes(0);
		Reporter.log("Reason code data added successully by type Order Modify");
		Reporter.log("Verify if add reason code success message is displayed");
		Assert.assertEquals(romuipages.reasonCodesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.REASONCODES_ADD.getMessage(),
				"Reason code for type Order Modify is not added successfully");
		Reporter.log("Add Reason code by Order Modify type Feature Has Been validated successfully");
	}

	@Test(enabled = true, priority = 2, description = "To Verify User able to edit Reason Code for type Order Modify")
	public void testEditReasonCodeByOrderModifyType()
			throws JsonParseException, JsonMappingException, IOException, Exception {
		reasonCodesData = ReasonCodesData.get(env.getFileLocation());
		Reporter.log("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		Reporter.log("Select Seller and Node");
		romuipages.loginPage().selectNode(reasonCodesData.getStoreIndex(), reasonCodesData.getNodeID());
		Reporter.log("Click Reason Code link");
		romuipages.orderMgmPage().clickOnReasonCodes();
		Reporter.log("Navigated to Reason Code page");
		Reporter.log("Edit reason code data for type Order Modify");
		romuipages.reasonCodesPage().editReasonCode(0);
		Reporter.log("Reason code data Edited successully by type Order Modify");
		Reporter.log("Verify if edit reason code success message is displayed");
		Assert.assertEquals(romuipages.reasonCodesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.REASONCODES_EDIT.getMessage(),
				"Reason code for type Order Modify is not edited successfully");
		Reporter.log("Edit Reason code by OrderModify type Feature Has Been validated successfully");
	}

	@Test(enabled = true, priority = 3, description = "To Validate user not able to add duplicate reason code for Order Modify type")
	public void testDuplicateReasonCodeByOrderModify()
			throws JsonParseException, JsonMappingException, IOException, Exception {

		reasonCodesData = ReasonCodesData.get(env.getFileLocation());
		Reporter.log("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		Reporter.log("Select Seller and Node");
		romuipages.loginPage().selectNode(reasonCodesData.getStoreIndex(), reasonCodesData.getNodeID());
		Reporter.log("Click Reason Code link");
		romuipages.orderMgmPage().clickOnReasonCodes();
		Reporter.log("Navigated to Reason Code page");
		Reporter.log("Verify Form Validation for reason Code");
		romuipages.reasonCodesPage().duplicateReasonCode(0);
		Reporter.log("Duplicate Reason code validation by Order Modify type done successfully");
	}

	@Test(enabled = false, priority = 4, description = "To Verify User able to delete Reason Code for type Order Modify")
	public void testDeleteReasonCodeByOrderModifyType()
			throws JsonParseException, JsonMappingException, IOException, Exception {
		reasonCodesData = ReasonCodesData.get(env.getFileLocation());
		Reporter.log("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		Reporter.log("Select Seller and Node");
		romuipages.loginPage().selectNode(reasonCodesData.getStoreIndex(), reasonCodesData.getNodeID());
		Reporter.log("Click Reason Code link");
		romuipages.orderMgmPage().clickOnReasonCodes();
		Reporter.log("Navigated to Reason Code page");
		Reporter.log("Delete reason code data for type Order Modify");
		romuipages.reasonCodesPage().deleteReasonCode();
		Reporter.log("Reason code data deleted successully by type Order Modify");
		Reporter.log("Verify if delete reason code success message is displayed");
		Assert.assertEquals(romuipages.reasonCodesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.REASONCODES_DELETE.getMessage(),
				"Reason code for type Order Modify is not Deleted successfully");
		Reporter.log("Delete Reason code by Order Modify type Feature Has Been validated successfully");
	}

	@Test(enabled = false, priority = 5, description = "To Verify User able to add Reason Code for type Return")
	public void testAddReasonCodeByReturnType()
			throws JsonParseException, JsonMappingException, IOException, Exception {
		reasonCodesData = ReasonCodesData.get(env.getFileLocation());
		Reporter.log("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		Reporter.log("Select Seller and Node");
		romuipages.loginPage().selectNode(reasonCodesData.getStoreIndex(), reasonCodesData.getNodeID());
		Reporter.log("Click Reason Code link");
		romuipages.orderMgmPage().clickOnReasonCodes();
		Reporter.log("Navigated to Reason Code page");
		Reporter.log("Add reason code data for type Return");
		romuipages.reasonCodesPage().addReasonCodes(1);
		Reporter.log("Reason code data added successully by type return");
		Reporter.log("Verify if add reason code success message is displayed");
		Assert.assertEquals(romuipages.reasonCodesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.REASONCODES_ADD.getMessage(), "Reason code for type Return is not added successfully");
		Reporter.log("Add Reason code by Return type Feature Has Been validated successfully");
	}

	@Test(enabled = false, priority = 6, description = "To Verify User able to edit Reason Code for type Return")
	public void testEditReasonCodeByReturnType()
			throws JsonParseException, JsonMappingException, IOException, Exception {
		reasonCodesData = ReasonCodesData.get(env.getFileLocation());
		Reporter.log("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		Reporter.log("Select Seller and Node");
		romuipages.loginPage().selectNode(reasonCodesData.getStoreIndex(), reasonCodesData.getNodeID());
		Reporter.log("Click Reason Code link");
		romuipages.orderMgmPage().clickOnReasonCodes();
		Reporter.log("Navigated to Reason Code page");
		Reporter.log("Edit reason code data for type Return");
		romuipages.reasonCodesPage().editReasonCode(1);
		Reporter.log("Reason code data Edited successully by type return");
		Reporter.log("Verify if edit reason code success message is displayed");
		Assert.assertEquals(romuipages.reasonCodesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.REASONCODES_EDIT.getMessage(),
				"Reason code for type Return is not edited successfully");
		Reporter.log("Edit Reason code by Return type Feature Has Been validated successfully");
	}

	@Test(enabled = true, priority = 7, description = "To Validate user not able to add duplicate reason code for Return type")
	public void testDuplicateReasonCodeByReturn()
			throws JsonParseException, JsonMappingException, IOException, Exception {

		reasonCodesData = ReasonCodesData.get(env.getFileLocation());
		Reporter.log("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		Reporter.log("Select Seller and Node");
		romuipages.loginPage().selectNode(reasonCodesData.getStoreIndex(), reasonCodesData.getNodeID());
		Reporter.log("Click Reason Code link");
		romuipages.orderMgmPage().clickOnReasonCodes();
		Reporter.log("Navigated to Reason Code page");
		Reporter.log("Verify Form Validation for reason Code");
		romuipages.reasonCodesPage().duplicateReasonCode(1);
		Reporter.log("Duplicate Reason code validation by Return type done successfully");
	}

	@Test(enabled = false, priority = 8, description = "To Verify User able to delete Reason Code for type Return")
	public void testDeleteReasonCodeByReturnType()
			throws JsonParseException, JsonMappingException, IOException, Exception {
		reasonCodesData = ReasonCodesData.get(env.getFileLocation());
		Reporter.log("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		Reporter.log("Select Seller and Node");
		romuipages.loginPage().selectNode(reasonCodesData.getStoreIndex(), reasonCodesData.getNodeID());
		Reporter.log("Click Reason Code link");
		romuipages.orderMgmPage().clickOnReasonCodes();
		Reporter.log("Navigated to Reason Code page");
		Reporter.log("delete reason code data for type Return");
		romuipages.reasonCodesPage().deleteReasonCode();
		Reporter.log("Reason code data deleted successully by type return");
		Reporter.log("Verify if delete reason code success message is displayed");
		Assert.assertEquals(romuipages.reasonCodesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.REASONCODES_DELETE.getMessage(),
				"Reason code for type Return is not Deleted successfully");
		Reporter.log("Delete Reason code by Return type Feature Has Been validated successfully");
	}

	@Test(enabled = true, priority = 9, description = "To Validate form validation")

	public void testFormValidationReasonCode() throws JsonParseException, JsonMappingException, IOException, Exception {
		reasonCodesData = ReasonCodesData.get(env.getFileLocation());
		Reporter.log("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		Reporter.log("Select Seller and Node");
		romuipages.loginPage().selectNode(reasonCodesData.getStoreIndex(), reasonCodesData.getNodeID());
		Reporter.log("Click Reason Code link");
		romuipages.orderMgmPage().clickOnReasonCodes();
		Reporter.log("Navigated to Reason Code page");
		Reporter.log("Verify Form Validation for reason Code");
		romuipages.reasonCodesPage().formValidationReasonCode();
		Reporter.log("Reason code Form validation done successfully");
	}

}
