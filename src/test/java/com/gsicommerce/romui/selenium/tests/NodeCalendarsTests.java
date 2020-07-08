package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class NodeCalendarsTests  extends ROMUIBasePage {
	
	@Test(enabled = true, priority = 1, description = "to Verify user able to add Node Calendra")
	public void testAddNodeCalendars() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Click on NodeCalendars page");
		romuipages.orderMgmPage().clickOnNodeCalendars();
		logger.info("Navigated to NodeCalendars page");
		logger.info("Enter data on NodeCalendars page");
		romuipages.nodeCalendarsPage().addNodeCalendars();
		Assert.assertEquals(romuipages.nodeCalendarsPage().txtSuccessMsg.getText(),RomuiEnumValues.NODECALENDARS_ADD.getMessage(), "Node Calendars not added successfully");
		logger.info("Add Node Calendars Has Been validated successfully");
		

}
}
