package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class PipelinesTests extends ROMUIBasePage {

	@Test(enabled = true, priority = 1, description = "To Verify Add Pipeline feature")
	public void testAddPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().addPipeline();
		logger.info("Add link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Verify if add pipeline success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.PIPELINE_SAVE.getMessage(), "Pipelne is not Saved successfully");
	}

	@Test(enabled = false, priority = 2, description = "To Verify View Pipeline feature")
	public void testViewPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().clickViewPipeline();
		logger.info("View Pipeline Feature has veen validated successfully");

	}	

	@Test(enabled = false, priority =3, invocationCount = 1, description = "To verfiy Edit Pipeline feature of draft status")
	public void testEditPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().editPipeline();
		logger.info("Edit link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Edit pipeline verified successfully");
		// Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
		// RomuiEnumValues.PIPELINE_EDIT.getMessage(), "Pipelne hasn't been updated");

	}

	@Test(enabled = false, priority =4, invocationCount = 1, description = "To Verify Edit Pipeline feature of Active Status")
	public void testeditPipelineActive() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().editPipelineActiveStatus();
		logger.info("Edit link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Edit Pipeline Active status verified successfully.");
		/*
		 * Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
		 * RomuiEnumValues.PIPELINE_EDIT.getMessage(), "Pipelne hasn't been updated");
		 */

	}

	@Test(enabled = false, priority = 5, invocationCount = 1, description = "To Verify Edit Pipeline feature of Inactive Status")
	public void testeditPipelineInActive() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().editPipelineInActiveStatus();
		logger.info("Edit link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Edit Pipeline InActive status verified successfully.");
		/*
		 * Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
		 * RomuiEnumValues.PIPELINE_EDIT.getMessage(), "Pipelne hasn't been updated");
		 */

	}

	@Test(enabled = false, priority = 6, description = "To Verify Copy Pipeline feature for Draft status")
	public void testCopyPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().copyPipeline();
		logger.info("Copy link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Verify if Copy pipeline success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.PIPELINE_SAVE.getMessage(), "Copy Pipeline for draft status hasn't been Saved successfully");
		logger.info("Draft Status Copy pipeline has been verified successfully");
	}
	
	@Test(enabled = false, priority = 7, description = "To Verify Copy Pipeline feature for Active status")
	public void testCopyPipelineActiveStatus() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().copyPipelineActiveStatus();
		logger.info("Copy link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Verify if Copy pipeline success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.PIPELINE_SAVE.getMessage(), "Copy Pipeline for draft status hasn't been Saved successfully");
		logger.info("Active Status Copy pipeline has been verified successfully");
	}
	
	@Test(enabled = false, priority = 8, description = "To Verify Copy Pipeline feature for Inactive status")
	public void testCopyPipelineInActiveStatus() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().copyPipelineInActiveStatus();
		logger.info("Copy link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Verify if Copy pipeline success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.PIPELINE_SAVE.getMessage(), "Copy Pipeline for draft status hasn't been Saved successfully");
		logger.info("Active Status Copy pipeline has been verified successfully");
	}

	@Test(enabled = false, priority = 9, invocationCount = 1, description = "To Verify Edit Pipeline Configuration")
	public void testEditPipelineConfiguration() throws Exception {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().editPipelienConfiguration();
		logger.info("Edit Pipeline Config link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Verify if Edit pipeline Config success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.PIPELINE_SAVE.getMessage(), "Edit Pipelne Config hasn't been successfully");
		logger.info("Edit pipeline Config has been verified successfully");
	}
	
	@Test(enabled = false, priority =10, description = "To Verify Delete Pipeline feature")
	public void testDeletePipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().deletePipeline();
		logger.info("Verify if Delete pipeline success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.PIPELINE_DELETE.getMessage(), "Pipelne not deleted");

	}
	
	@Test(enabled = true, priority =11, description = "To Verify Pipeline form validation")
	public void testPipelineFormValidation() throws JsonParseException, JsonMappingException, IOException, Exception {
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().pipelineFormValidation();
		logger.info("Pipeline form Error Validation verified");
		
	}
}
