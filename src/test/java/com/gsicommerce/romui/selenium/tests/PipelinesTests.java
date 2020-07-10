package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.testdata.PipelineData;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class PipelinesTests extends ROMUIBasePage {
	private PipelineData pipelinedata;
	@Test(enabled = false, priority = 1, description = "To Verify Add Pipeline feature")
	public void testAddPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		pipelinedata = PipelineData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(pipelinedata.getStoreIndex(), pipelinedata.getNodeID());
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().addPipeline();
		logger.info("Add link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Verify if add pipeline success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.PIPELINE_SAVE.getMessage(), "Pipelne is not Saved successfully");
		logger.info("Add Pipeline Feature Has Been validated successfully");
	}

	@Test(enabled = false, priority = 2, description = "To Verify View Pipeline feature")
	public void testViewPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		pipelinedata = PipelineData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(pipelinedata.getStoreIndex(), pipelinedata.getNodeID());
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().clickViewPipeline();
		logger.info("View Pipeline Feature has Been validated successfully");

	}

	@Test(enabled = false, priority = 3, invocationCount = 1, description = "To verfiy Edit Pipeline feature of draft status")
	public void testEditPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		pipelinedata = PipelineData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(pipelinedata.getStoreIndex(), pipelinedata.getNodeID());
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		// romuipages.pipeLinesPage().editPipeline(1);
		romuipages.pipeLinesPage().editPipelineDraftStatus();
		logger.info("Edit link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Edit pipeline has Been validated successfully");
	}

	@Test(enabled = false, priority = 4, invocationCount = 1, description = "To Verify Edit Pipeline feature of Active Status")
	public void testeditPipelineActive() throws JsonParseException, JsonMappingException, IOException, Exception {
		pipelinedata = PipelineData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(pipelinedata.getStoreIndex(), pipelinedata.getNodeID());
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().editPipelineActiveStatus();
		logger.info("Edit link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Edit Pipeline Active status has been Validated successfully.");
	}

	@Test(enabled = false, priority = 5, invocationCount = 1, description = "To Verify Edit Pipeline feature of Inactive Status")
	public void testeditPipelineInActive() throws JsonParseException, JsonMappingException, IOException, Exception {
		pipelinedata = PipelineData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(pipelinedata.getStoreIndex(), pipelinedata.getNodeID());
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().editPipelineInActiveStatus();
		logger.info("Edit link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Edit Pipeline InActive status has Been validated successfully.");

	}

	@Test(enabled = false, priority = 6, description = "To Verify Copy Pipeline feature for Draft status")
	public void testCopyPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		pipelinedata = PipelineData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(pipelinedata.getStoreIndex(), pipelinedata.getNodeID());
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().copyPipelineDraftStatus();
		logger.info("Copy link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Verify if Copy pipeline success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.PIPELINE_SAVE.getMessage(),
				"Copy Pipeline for draft status hasn't been Saved successfully");
		logger.info("Draft Status Copy pipeline has been verified successfully");
	}

	@Test(enabled = false, priority = 7, description = "To Verify Copy Pipeline feature for Active status")
	public void testCopyPipelineActiveStatus() throws JsonParseException, JsonMappingException, IOException, Exception {
		pipelinedata = PipelineData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(pipelinedata.getStoreIndex(), pipelinedata.getNodeID());
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().copyPipelineActiveStatus();
		logger.info("Copy link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Verify if Copy pipeline success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.PIPELINE_SAVE.getMessage(),
				"Copy Pipeline for draft status hasn't been Saved successfully");
		logger.info("Active Status Copy pipeline has been verified successfully");
	}

	@Test(enabled = false, priority = 8, description = "To Verify Copy Pipeline feature for Inactive status")
	public void testCopyPipelineInActiveStatus()
			throws JsonParseException, JsonMappingException, IOException, Exception {
		pipelinedata = PipelineData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(pipelinedata.getStoreIndex(), pipelinedata.getNodeID());
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().copyPipelineInActiveStatus();
		logger.info("Copy link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Verify if Copy pipeline success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.PIPELINE_SAVE.getMessage(),
				"Copy Pipeline for draft status hasn't been Saved successfully");
		logger.info("InActive Status Copy pipeline has been verified successfully");
	}

	@Test(enabled = false, priority = 9, invocationCount = 1, description = "To Verify Edit Pipeline Configuration for Active status")
	public void testEditPipelineConfigurationActiveStatus() throws Exception {
		pipelinedata = PipelineData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(pipelinedata.getStoreIndex(), pipelinedata.getNodeID());
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().editPipelienConfigurationActive();
		logger.info("Edit Pipeline Config link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Edit pipeline Config for ACTIVE status has been verified successfully");
	}

	@Test(enabled = true, priority = 10, invocationCount = 1, description = "To Verify Delete Pipeline feature")
	public void testDeletePipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		pipelinedata = PipelineData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(pipelinedata.getStoreIndex(), pipelinedata.getNodeID());
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().deletePipeline();
		logger.info("Verify if Delete pipeline success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.PIPELINE_DELETE.getMessage(), "Pipelne not deleted");

	}

	@Test(enabled = false, priority = 11, description = "To Verify Pipeline form validation")
	public void testPipelineFormValidation() throws JsonParseException, JsonMappingException, IOException, Exception {
		pipelinedata = PipelineData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(pipelinedata.getStoreIndex(), pipelinedata.getNodeID());
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().pipelineFormValidation();
		logger.info("Pipeline form Error Validation verified");

	}

	@Test(enabled = false, priority = 12, invocationCount = 1, description = "To Verify Edit Pipeline Configuration for Draft status")
	public void testeditPipelienConfigurationDraft() throws Exception {
		pipelinedata = PipelineData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		logger.info("Select Seller and Node");
		romuipages.loginPage().selectNode(pipelinedata.getStoreIndex(), pipelinedata.getNodeID());
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");
		romuipages.pipeLinesPage().editPipelienConfigurationDraft();
		logger.info("Edit Pipeline Config link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Verify if Edit pipeline Config success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(),
				RomuiEnumValues.PIPELINE_SAVE.getMessage(), "Edit Pipelne Config hasn't been successfully");
		logger.info("Edit pipeline Config for draft status has been verified successfully");
	}

}
