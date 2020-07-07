package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;

public class OrderCreateTests extends ROMUIBasePage {

	@Test(enabled = true, priority = 1, description = "to Verify search order by Order number")
	public void testCreateOrder() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Read host and apikey for Create Order");
		romuipages.orderCreatePage().getBBWPropertiesData();
		logger.info("enter data in xml and place order");
		romuipages.orderCreatePage().BBWOrderCreateSTH();
		
	}



}