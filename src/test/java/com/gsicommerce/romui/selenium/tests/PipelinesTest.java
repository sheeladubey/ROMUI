package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class PipelinesTest extends ROMUIBasePage {
	
	@Test(enabled =false, priority=1,description = "Add Pipeline")
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
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(), RomuiEnumValues.PIPELINE_SAVE.getMessage(), "Pipelne is not Saved successfully");
	}

	@Test(enabled = false, priority=2,description = "View Pipeline")
	public void testViewPipeline() throws JsonParseException, JsonMappingException, IOException, Exception  {		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");		
		romuipages.pipeLinesPage().clickViewPipeline();
		logger.info("View Pipeline Feature has veen validated successfully");
		
	}
	
	@Test(enabled = false, priority=3,description = "Delete Pipeline")
	public void testDeletePipeline() throws JsonParseException, JsonMappingException, IOException, Exception {		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");		
		romuipages.pipeLinesPage().deletePipeline();
		logger.info("Verify if Delete pipeline success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(), RomuiEnumValues.PIPELINE_DELETE.getMessage(), "Pipelne not deleted");
		
	}
	
	@Test(enabled = true, priority=6,invocationCount=1,description = "Edit Pipeline")
	public void testEditPipeline()throws JsonParseException, JsonMappingException, IOException,Exception {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");		
		romuipages.pipeLinesPage().EditPipeline();
		logger.info("Edit link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Verify if Edit pipeline success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(), RomuiEnumValues.PIPELINE_EDIT.getMessage(), "Pipelne hasn't been updated");
		
	}
	
	
	@Test(enabled = false, priority=4,description = "Copy Pipeline")
	public void testCopyPipeline()throws JsonParseException, JsonMappingException, IOException,Exception {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");	
		romuipages.pipeLinesPage().copyPipeline();
		logger.info("Copy link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Verify if Copy pipeline success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(), RomuiEnumValues.PIPELINE_SAVE.getMessage(), "Copy Pipeline didn't get created Saved successfully");
		
}
	
	@Test(enabled = false, priority=5,invocationCount=1,description = "Edit Pipeline Configuration")
	public void testEditPipelineConfiguration() throws Exception{		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnPipeline();
		logger.info("Navigated to Pipeline page");		
		romuipages.pipeLinesPage().editPipelienConfiguration();
		logger.info("Edit Pipeline Config link is clicked on to enter the data and Clicked on Save btn");
		logger.info("Verify if Edit pipeline Config success message is displayed");
		Assert.assertEquals(romuipages.pipeLinesPage().txtSuccessMsg.getText(), RomuiEnumValues.PIPELINE_SAVE.getMessage(), "EDIT Pipelne Config didn't get created successfully");
			
}
}
