package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class PaymentMethodConfigTests extends ROMUIBasePage {

	@Test(enabled = true, priority = 1, description = "to Verify Add PaymentMethod Configuration for StoredValueCard")
	public void testAddPaymentConfigForStoredValueCard() throws JsonParseException, JsonMappingException, IOException {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPaymtMethdConfig();
		logger.info("Navigated to PaymentMethod Config page");
		romuipages.paymtMethdConfigPage().addPaymentMethodConfig(0);
		logger.info("Add link is clcked on to enter the data and Clicked on Save btn");
		logger.info("Verify if add paymentmethodconfig success message is displayed");
		Assert.assertEquals(romuipages.paymtMethdConfigPage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.PAYMENT_METHOD_CONFIG_ADD.getMessage(),
				"Payment Config Add for StoredValue Card is not updated successfully");
	}

	@Test(enabled = true, priority = 2, description = "to Verify Edit PaymentMethod Configuration for StoredValueCard")
	public void testEditPaymentConfigForStoredValueCard() throws JsonParseException, JsonMappingException, IOException {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPaymtMethdConfig();
		logger.info("Navigated to PaymentMethod Config page");
		romuipages.paymtMethdConfigPage().editPaymentMethodConfig(0);
		logger.info("Edit link is clcked on to enter the modified data and Clicked on Save btn");
		logger.info("Verify if edit paymentmethodconfig success message is displayed");
		Assert.assertEquals(romuipages.paymtMethdConfigPage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.PAYMENT_METHOD_CONFIG_UPDATE.getMessage(),
				"Payment Config Edit for StoredValueCard is not updated successfully");
	}

	@Test(enabled = true, priority = 3, description = "to Verify Delete PaymentMethod Configuration for StoredValueCard")
	public void testDeletePaymentConfigForStoredValueCard()
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPaymtMethdConfig();
		logger.info("Navigated to PaymentMethod Config page");
		romuipages.paymtMethdConfigPage().deletePaymentMethodConfig();
		logger.info("Delete link is clcked on to delete the config");
		logger.info("Verify if delete paymentmethodconfig success message is displayed");
		Assert.assertEquals(romuipages.paymtMethdConfigPage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.PAYMENT_METHOD_CONFIG_DELETE.getMessage(),
				"Payment Config Delete for StoredValueCard is not updated successfully");
	}

	@Test(enabled = true, priority = 4, description = "to Verify Add PaymentMethod Configuration for Credit Card")
	public void testAddPaymentConfigForCreditCard() throws JsonParseException, JsonMappingException, IOException {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPaymtMethdConfig();
		logger.info("Navigated to PaymentMethod Config page");
		romuipages.paymtMethdConfigPage().addPaymentMethodConfig(1);
		logger.info("Add link is clcked on to enter the data and Clicked on Save btn");
		logger.info("Verify if add paymentmethodconfig success message is displayed");
		Assert.assertEquals(romuipages.paymtMethdConfigPage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.PAYMENT_METHOD_CONFIG_ADD.getMessage(),
				"Payment Config Add is not updated successfully");
	}

	@Test(enabled = true, priority = 5, description = "to Verify Edit PaymentMethod Configuration for Credit Card")
	public void testEditPaymentConfigForCreditCard() throws JsonParseException, JsonMappingException, IOException {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPaymtMethdConfig();
		logger.info("Navigated to PaymentMethod Config page");
		romuipages.paymtMethdConfigPage().editPaymentMethodConfig(1);
		logger.info("Edit link is clcked on to enter the modified data and Clicked on Save btn");
		logger.info("Verify if edit paymentmethodconfig success message is displayed");
		Assert.assertEquals(romuipages.paymtMethdConfigPage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.PAYMENT_METHOD_CONFIG_UPDATE.getMessage(),
				"Payment Config Edit is not updated successfully");
	}

	@Test(enabled = true, priority = 6, description = "to Verify Delete PaymentMethod Configuration for CreditCard")
	public void testDeletePaymentConfigForCreditCard()
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPaymtMethdConfig();
		logger.info("Navigated to PaymentMethod Config page");
		romuipages.paymtMethdConfigPage().deletePaymentMethodConfig();
		logger.info("Delete link is clcked on to delete the config");
		logger.info("Verify if delete paymentmethodconfig success message is displayed");
		Assert.assertEquals(romuipages.paymtMethdConfigPage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.PAYMENT_METHOD_CONFIG_DELETE.getMessage(),
				"Payment Config Delete for Credit Card is not updated successfully");
	}

	@Test(enabled = true, priority = 7, description = "to Verify Add PaymentMethod Configuration for PrePaid Card")
	public void testAddPaymentConfigForPrePaidCard() throws JsonParseException, JsonMappingException, IOException {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPaymtMethdConfig();
		logger.info("Navigated to PaymentMethod Config page");
		romuipages.paymtMethdConfigPage().addPaymentMethodConfig(2);
		logger.info("Add link is clcked on to enter the data and Clicked on Save btn");
		logger.info("Verify if add paymentmethodconfig success message is displayed");
		Assert.assertEquals(romuipages.paymtMethdConfigPage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.PAYMENT_METHOD_CONFIG_ADD.getMessage(),
				"Payment Config Add is not updated successfully");
	}

	@Test(enabled = true, priority = 8, description = "to Verify Edit PaymentMethod Configuration for PrePaidCard")
	public void testEditPaymentConfigForPrepaidCard() throws JsonParseException, JsonMappingException, IOException {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPaymtMethdConfig();
		logger.info("Navigated to PaymentMethod Config page");
		romuipages.paymtMethdConfigPage().editPaymentMethodConfig(2);
		logger.info("Edit link is clcked on to enter the modified data and Clicked on Save btn");
		logger.info("Verify if edit paymentmethodconfig success message is displayed");
		Assert.assertEquals(romuipages.paymtMethdConfigPage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.PAYMENT_METHOD_CONFIG_UPDATE.getMessage(),
				"Payment Config Edit for PrePaid Card is not updated successfully");
	}

	@Test(enabled = true, priority = 9, description = "to Verify Delete PaymentMethod Configuration for Prepaid Card")
	public void testDeletePaymentConfigForPrePaidCard()
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPaymtMethdConfig();
		logger.info("Navigated to PaymentMethod Config page");
		romuipages.paymtMethdConfigPage().deletePaymentMethodConfig();
		logger.info("Delete link is clcked on to delete the config");
		logger.info("Verify if delete paymentmethodconfig success message is displayed");
		Assert.assertEquals(romuipages.paymtMethdConfigPage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.PAYMENT_METHOD_CONFIG_DELETE.getMessage(),
				"Payment Config Delete for Prepaid is not updated successfully");
	}

	@Test(enabled = true, priority = 10, description = "to Verify Add PaymentMethod Configuration for PayPal")
	public void testAddPaymentConfigForPayPal() throws JsonParseException, JsonMappingException, IOException {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPaymtMethdConfig();
		logger.info("Navigated to PaymentMethod Config page");
		romuipages.paymtMethdConfigPage().addPaymentMethodConfig(3);
		logger.info("Add link is clcked on to enter the data and Clicked on Save btn");
		logger.info("Verify if add paymentmethodconfig success message is displayed");
		Assert.assertEquals(romuipages.paymtMethdConfigPage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.PAYMENT_METHOD_CONFIG_ADD.getMessage(),
				"Payment Config Add for PayPal is not updated successfully");
	}

	@Test(enabled = true, priority = 11, description = "to Verify Edit PaymentMethod Configuration for PayPal")
	public void testEditPaymentConfigForPayPal() throws JsonParseException, JsonMappingException, IOException {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPaymtMethdConfig();
		logger.info("Navigated to PaymentMethod Config page");
		romuipages.paymtMethdConfigPage().editPaymentMethodConfig(3);
		logger.info("Edit link is clcked on to enter the modified data and Clicked on Save btn");
		logger.info("Verify if edit paymentmethodconfig success message is displayed");
		Assert.assertEquals(romuipages.paymtMethdConfigPage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.PAYMENT_METHOD_CONFIG_UPDATE.getMessage(),
				"Payment Config Edit for PayPal is not updated successfully");
	}

	@Test(enabled = true, priority = 12, description = "to Verify Delete PaymentMethod Configuration for PayPal")
	public void testDeletePaymentConfigForPayPal()
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPaymtMethdConfig();
		logger.info("Navigated to PaymentMethod Config page");
		romuipages.paymtMethdConfigPage().deletePaymentMethodConfig();
		logger.info("Delete link is clcked on to delete the config");
		logger.info("Verify if delete paymentmethodconfig success message is displayed");
		Assert.assertEquals(romuipages.paymtMethdConfigPage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.PAYMENT_METHOD_CONFIG_DELETE.getMessage(),
				"Payment Config Delete for PayPal is not updated successfully");
	}
}
