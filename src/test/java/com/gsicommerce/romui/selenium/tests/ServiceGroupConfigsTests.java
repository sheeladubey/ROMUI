package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class ServiceGroupConfigsTests extends ROMUIBasePage {

	@Test(enabled = true, priority = 1, description = "to Verify Edit Seller Service Group Configurations")
	public void testEditSellerServiceGroupConfigs() throws JsonParseException, JsonMappingException, IOException {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnServiceGrpConfig();
		logger.info("Navigated to Seller Service Group Config page");
		romuipages.serviceGrpConfigPage().editSellerServiceGroupConfigs();
		logger.info("Clicked on each service to enter the modified data and Clicked on Save btn");
		logger.info("Verify if edit Seller Service Group success message is displayed");
		Assert.assertEquals(romuipages.serviceGrpConfigPage().txtEditSuccessMsg.getText(), RomuiEnumValues.SERVICE_GROUP_CONFIG.getMessage(), "Edit Seller Service Group Config is not updated successfully");
	}
	
	
}