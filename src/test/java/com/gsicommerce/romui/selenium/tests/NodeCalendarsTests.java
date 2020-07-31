package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.CommonElementsPage;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class NodeCalendarsTests extends ROMUIBasePage {

	@Test(enabled = true, priority = 1, description = "to Verify user able to add Node Calendra")
	public void testAddNodeCalendars() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Click on NodeCalendars page");
		romuipages.orderMgmPage().clickOnNodeCalendars();
		logger.info("Navigated to NodeCalendars page");
		logger.info("Enter data on NodeCalendars page");
		romuipages.nodeCalendarsPage().addNodeCalendars();
		logger.info("Add Node Calendars Has Been validated successfully");

	}

	@Test(enabled = true, priority = 2, description = "to Verify user able to view Node Calendra")
	public void testViewNodeCalendars() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Click on NodeCalendars page");
		romuipages.orderMgmPage().clickOnNodeCalendars();
		logger.info("Navigated to NodeCalendars page");
		logger.info("Click View Calendar Icon");
		romuipages.nodeCalendarsPage().viewNodeCalendars();
		logger.info("View Calendar has been verified ");
	}

	@Test(enabled = true, priority = 3, description = "to Verify user able to Edit Node Calendra")
	public void testEditNodeCalendars() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Click on NodeCalendars page");
		romuipages.orderMgmPage().clickOnNodeCalendars();
		logger.info("Navigated to NodeCalendars page");
		logger.info("Click Edit Calendar Icon");
		romuipages.nodeCalendarsPage().clickEditNodeCalendar();
		logger.info("Navigated to Edit Calendar Configuration");
		logger.info("Enter data to Edit Calendar Config");
		romuipages.nodeCalendarsPage().editNodeCalendars();
		Assert.assertEquals(romuipages.nodeCalendarsPage().txtSuccessMsg.getText(),
				RomuiEnumValues.NODECALENDARS_EDIT.getMessage(), "Node Calendars not edited successfully");
		logger.info("Edit Calendar has been verified ");

	}

	@Test(enabled = true, priority = 5, description = "to Verify user able to delete Node Calendra")
	public void testDeleteNodeCalendars() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Click on NodeCalendars page");
		romuipages.orderMgmPage().clickOnNodeCalendars();
		logger.info("Navigated to NodeCalendars page");
		logger.info("Click Delete Calendar Icon");
		romuipages.nodeCalendarsPage().deleteNodeCalendars();
		Assert.assertEquals(romuipages.nodeCalendarsPage().txtSuccessMsg.getText(),
				RomuiEnumValues.NODECALENDARS_DELETE.getMessage(), "Node Calendars not DELETED successfully");
		logger.info("Delete Calendar has been verified ");

	}

	@Test(enabled = true, priority = 6, description = "to Validate form validation for Node Calendra")
	public void testFormValidationNodeCalendars()
			throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Click on NodeCalendars page");
		romuipages.orderMgmPage().clickOnNodeCalendars();
		logger.info("Navigated to NodeCalendars page");
		logger.info("Click Delete Calendar Icon");
		romuipages.nodeCalendarsPage().formValidationNodeCalendar();
		romuipages.commonElePage();
		Assert.assertEquals(CommonElementsPage.txtAlertErrorMsg.getText(), RomuiEnumValues.FORM_ERROR.getMessage(),
				"No form validation exist for Node Calendars.");
		logger.info("Form Validation for Node Calendar has been verified ");

	}

	@Test(enabled = true, priority = 4, description = "to Verify user able to Edit Node Calendra from View Calendar Configuration")
	public void testEditNodeCalendarsView() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Click on NodeCalendars page");
		romuipages.orderMgmPage().clickOnNodeCalendars();
		logger.info("Navigated to NodeCalendars page");
		logger.info("Enter data to Edit Calendar Config");
		romuipages.nodeCalendarsPage().editNodeCalendarsFromView();
		Assert.assertEquals(romuipages.nodeCalendarsPage().txtSuccessMsg.getText(),
				RomuiEnumValues.NODECALENDARS_EDIT.getMessage(), "Node Calendars not edited successfully");
		logger.info("Edit Calendar has been verified ");
	}
}
