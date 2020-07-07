package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;

public class NodeCalendarsTests  extends ROMUIBasePage {
	
	@Test(enabled = true, priority = 1, description = "to Verify search order by Order number")
	public void testSearchOrderbyNumber() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Click on NodeCalendars page");
		romuipages.orderMgmPage().clickOnNodeCalendars();
		logger.info("Navigated to NodeCalendars page");
		logger.info("Enter data on NodeCalendars page");
		romuipages.nodeCalendarsPage().addNodeCalendars();
		

}
}
