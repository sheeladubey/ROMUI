package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class ServiceFlowTest extends ROMUIBasePage {

	@Test(enabled = true, priority=1,description = "Add ServiceFlow")
	public void testAddServiceFlow()throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnServiceFlows();
		logger.info("Navigated to Service Flow page");		
		romuipages.serviceFlowPage().addSvcFlw();
		logger.info("Add link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Verify if add serviceflow success message is displayed");
	//	Assert.assertEquals(romuipages.serviceFlowPage().txtSuccessMsg.getText(), RomuiEnumValues.SERVICEFLOW_SAVE.getMessage(), "Service Flow is not Saved successfully");
		romuipages.serviceFlowPage().addSvcFlwProcess1();	
	}

	
	/*
	 * @Test(enabled = true, priority=2,description = "View Service Flow") public
	 * void testViewServiceFlow() {
	 * 
	 * logger.info("Login credentials to be entered");
	 * romuipages.loginPage().login(env.getUserName(), env.getPassword());
	 * romuipages.homePage().clickOnLandingButton("Order Management");
	 * logger.info("Order Management link is clicked on");
	 * romuipages.orderMgmPage().clickOnServiceFlows();
	 * logger.info("Navigated to Service Flow page");
	 * romuipages.pipeLinesPage().clickViewPipeline();
	 * logger.info("View serviceflow Feature has been validated successfully");
	 * 
	 * }
	 * 
	 * @Test(enabled = false, priority=6,description = "Edit Service Flow") public
	 * void testEditServiceFlow()throws JsonParseException, JsonMappingException,
	 * IOException {
	 * 
	 * logger.info("Login credentials to be entered");
	 * romuipages.loginPage().login(env.getUserName(), env.getPassword());
	 * romuipages.homePage().clickOnLandingButton("Order Management");
	 * logger.info("Order Management link is clicked on");
	 * romuipages.orderMgmPage().clickOnServiceFlows();
	 * logger.info("Navigated to Service Flow page");
	 * romuipages.pipeLinesPage().EditPipeline(); logger.
	 * info("Edit link is clicked on to enter the data and Clicked on Save btn");
	 * logger.info("Verify if Edit serviceflow success message is displayed");
	 * Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
	 * RomuiEnumValues.PIPELINE_EDIT.getMessage(), "Pipelne hasn't been updated");
	 * 
	 * }
	 * 
	 * 
	 * @Test(enabled = true, priority=4,description = "Copy Service Flow") public
	 * void testCopyServiceFlow()throws JsonParseException, JsonMappingException,
	 * IOException {
	 * 
	 * logger.info("Login credentials to be entered");
	 * romuipages.loginPage().login(env.getUserName(), env.getPassword());
	 * romuipages.homePage().clickOnLandingButton("Order Management");
	 * logger.info("Order Management link is clicked on");
	 * romuipages.orderMgmPage().clickOnServiceFlows();
	 * logger.info("Navigated to Service Flow page");
	 * romuipages.pipeLinesPage().copyPipeline(); logger.
	 * info("Copy link is clicked on to enter the data and Clicked on Save btn");
	 * logger.info("Verify if Copy serviceflow success message is displayed");
	 * Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
	 * RomuiEnumValues.PIPELINE_SAVE.getMessage(),
	 * "Copy serviceflow didn't get created Saved successfully");
	 * 
	 * }
	 * 
	 * @Test(enabled = true, priority=5,invocationCount=1,description =
	 * "Edit Service flow Processes") public void testEditServiceFlowProcesses() {
	 * 
	 * logger.info("Login credentials to be entered");
	 * romuipages.loginPage().login(env.getUserName(), env.getPassword());
	 * romuipages.homePage().clickOnLandingButton("Order Management");
	 * logger.info("Order Management link is clicked on");
	 * romuipages.orderMgmPage().clickOnServiceFlows();
	 * logger.info("Navigated to Service Flow page");
	 * romuipages.pipeLinesPage().editPipelienConfiguration(); logger.
	 * info("Edit Pipeline Config link is clicked on to enter the data and Clicked on Save btn"
	 * ); logger.
	 * info("Verify if Edit serviceflow Processes success message is displayed");
	 * Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
	 * RomuiEnumValues.PIPELINE_SAVE.getMessage(),
	 * "EDIT serviceflow Processes didn't get created successfully");
	 * 
	 * }
	 */
	 
}
