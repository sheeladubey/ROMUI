package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class UserManagementTests extends ROMUIBasePage {	
	
	
	  @Test(enabled = true, priority=1,description = "Add Role") public void
	  testAddRole()throws JsonParseException, JsonMappingException, IOException,
	  InterruptedException {
	  
	  logger.info("Login credentials to be entered");
	  romuipages.loginPage().login(env.getUserName(), env.getPassword());
	  romuipages.homePage().clickOnLandingButton("Order Management");
	  logger.info("Order Management link is clicked on");
	  romuipages.orderMgmPage().clickOnRoles();
	  logger.info("Navigated to User Role page");
	  romuipages.userManagementPage().addRole();
	  logger.info("Add link is clicked on to enter the data and Clicked on Save btn");
	  logger.info("Verify if add Role success message is displayed");
	  Assert.assertEquals(romuipages.userManagementPage().txtSuccessMsg.getText(),
	  RomuiEnumValues.ROLE_SAVE.getMessage(), "Role is not created successfully");
	  logger.info("Navigated to User page");
	  romuipages.userManagementPage().addUser();
	  Assert.assertEquals(romuipages.userManagementPage().userSuccessMsg.getText(),
	  RomuiEnumValues.USER_SAVE.getMessage(), "User is not created successfully");
	  logger.info("User is created Sucessfully");
	  
	  }
		
		  @Test(enabled = true, priority=2,description = "SearchBy UserId") public void
		  testSearchUser()throws JsonParseException, JsonMappingException, IOException,
		  InterruptedException {
		  
		  logger.info("Login credentials to be entered");
		  romuipages.loginPage().login(env.getUserName(), env.getPassword());
		  romuipages.homePage().clickOnLandingButton("Order Management");
		  logger.info("Order Management link is clicked on");
		  romuipages.orderMgmPage().clickOnUsers();
		  logger.info("Navigated to User page");
		  romuipages.userManagementPage().searchByUserId();
		  logger.info("SearchBy UserId Feature has been validated successfully");
		  
		  }
		  
		  @Test(enabled = true, priority=3,description = "Error Message") public void
		  testErrorMsg()throws JsonParseException, JsonMappingException, IOException,
		  InterruptedException {
		  
		  logger.info("Login credentials to be entered");
		  romuipages.loginPage().login(env.getUserName(), env.getPassword());
		  romuipages.homePage().clickOnLandingButton("Order Management");
		  logger.info("Order Management link is clicked on");
		  romuipages.orderMgmPage().clickOnUsers();
		  logger.info("Navigated to User page");
		  romuipages.userManagementPage().userNotFound();
		  logger.info("Error Message Feature has been validated successfully");
		  
		  } 
		  
		  
		  
		  @Test(enabled = true, priority=4,description = "SearchBy FirstName") public
		  void testSearchFname()throws JsonParseException, JsonMappingException,
		  IOException, InterruptedException {
		  
		  logger.info("Login credentials to be entered");
		  romuipages.loginPage().login(env.getUserName(), env.getPassword());
		  romuipages.homePage().clickOnLandingButton("Order Management");
		  logger.info("Order Management link is clicked on");
		  romuipages.orderMgmPage().clickOnUsers();
		  logger.info("Navigated to User page");
		  romuipages.userManagementPage().searchByFirstName();
		  logger.info("SearchBy first Name Feature has been validated successfully");
		  
		  }
		  
		  @Test(enabled = true, priority=5,description = "SearchBy LastName") public
		  void testSearchlname()throws JsonParseException, JsonMappingException,
		  IOException, InterruptedException {
		  
		  logger.info("Login credentials to be entered");
		  romuipages.loginPage().login(env.getUserName(), env.getPassword());
		  romuipages.homePage().clickOnLandingButton("Order Management");
		  logger.info("Order Management link is clicked on");
		  romuipages.orderMgmPage().clickOnUsers();
		  logger.info("Navigated to User page");
		  romuipages.userManagementPage().searchByLastName();
		  logger.info("SearchBy Last Name Feature has been validated successfully");
		  
		  }
		  
		  @Test(enabled = true, priority=6,description = "SearchBy email") public void
		  testEmail()throws JsonParseException, JsonMappingException, IOException,
		  InterruptedException {
		  
		  logger.info("Login credentials to be entered");
		  romuipages.loginPage().login(env.getUserName(), env.getPassword());
		  romuipages.homePage().clickOnLandingButton("Order Management");
		  logger.info("Order Management link is clicked on");
		  romuipages.orderMgmPage().clickOnUsers();
		  logger.info("Navigated to User page");
		  romuipages.userManagementPage().searchByEmail();
		  logger.info("SearchBy email Feature has been validated successfully");
		  
		  }
		  
		  
		  
		  @Test(enabled = true, priority=7,description = "SearchBy Node") public void
		  testnode()throws JsonParseException, JsonMappingException, IOException,
		  InterruptedException {
		  
		  logger.info("Login credentials to be entered");
		  romuipages.loginPage().login(env.getUserName(), env.getPassword());
		  romuipages.homePage().clickOnLandingButton("Order Management");
		  logger.info("Order Management link is clicked on");
		  romuipages.orderMgmPage().clickOnUsers();
		  logger.info("Navigated to User page");
		  romuipages.userManagementPage().searchByNode();
		  logger.info("SearchBy Node Feature has been validated successfully");
		  
		  } 
		
		
		  @Test(enabled = true, priority=8,description = "Edit User") public void
		  testEditUser()throws Exception {
		  
		  logger.info("Login credentials to be entered");
		  romuipages.loginPage().login(env.getUserName(), env.getPassword());
		  romuipages.homePage().clickOnLandingButton("Order Management");
		  logger.info("Order Management link is clicked on");
		  romuipages.orderMgmPage().clickOnUsers();
		  logger.info("Navigated to User page");
		  romuipages.userManagementPage().editUser();
		  Assert.assertEquals(romuipages.userManagementPage().userSuccessMsg.getText(),
		  RomuiEnumValues.USER_EDIT.getMessage(), "User is not edited successfully");
		  logger.info("Edit User Feature has been validated successfully");
		  
		  }
		  
		  
		  @Test(enabled = true, priority=9,description = "Delete User") public void
		  testDeleteUser()throws Exception {
		  
		  logger.info("Login credentials to be entered");
		  romuipages.loginPage().login(env.getUserName(), env.getPassword());
		  romuipages.homePage().clickOnLandingButton("Order Management");
		  logger.info("Order Management link is clicked on");
		  romuipages.orderMgmPage().clickOnUsers();
		  logger.info("Navigated to User page");
		  romuipages.userManagementPage().deleteUser();
		  Assert.assertEquals(romuipages.userManagementPage().userSuccessMsg.getText(),
		  RomuiEnumValues.USER_DELETE.getMessage(),
		  "User is not deleted successfully");
		  logger.info("Delete User Feature has been validated successfully");
		  
		  }
		  
		  
		  
		  @Test(enabled = true, priority=10,description = "Edit Role") public void
		  testEditRole()throws Exception {
		  
		  logger.info("Login credentials to be entered");
		  romuipages.loginPage().login(env.getUserName(), env.getPassword());
		  romuipages.homePage().clickOnLandingButton("Order Management");
		  logger.info("Order Management link is clicked on");
		  romuipages.orderMgmPage().clickOnRoles();
		  logger.info("Navigated to Role page");
		  romuipages.userManagementPage().editRole();
		  Assert.assertEquals(romuipages.userManagementPage().userSuccessMsg.getText(),
		  RomuiEnumValues.ROLE_EDIT.getMessage(), "Role is not edited successfully");
		  logger.info("Edit Role Feature has been validated successfully");
		  
		  }
		  
		  
		  
		  @Test(enabled = true, priority=11,description = "Delete Role") public void
		  testDeleteRole()throws Exception {
		  
		  logger.info("Login credentials to be entered");
		  romuipages.loginPage().login(env.getUserName(), env.getPassword());
		  romuipages.homePage().clickOnLandingButton("Order Management");
		  logger.info("Order Management link is clicked on");
		  romuipages.orderMgmPage().clickOnRoles();
		  logger.info("Navigated to Role page");
		  romuipages.userManagementPage().deleteRole();
		  Assert.assertEquals(romuipages.userManagementPage().userSuccessMsg.getText(),
		  RomuiEnumValues.ROLE_DELETE.getMessage(),
		  "Role is not deleted successfully");
		  logger.info("Delete Role Feature has been validated successfully");
		  
		  }
		  
		  
		  
		  @Test(enabled = true, priority=12,description = "User Error Validation")
		  public void testUserErrorValidation()throws JsonParseException,
		  JsonMappingException, IOException, InterruptedException {
		  
		  logger.info("Login credentials to be entered");
		  romuipages.loginPage().login(env.getUserName(), env.getPassword());
		  romuipages.homePage().clickOnLandingButton("Order Management");
		  logger.info("Order Management link is clicked on");
		  romuipages.orderMgmPage().clickOnUsers();
		  logger.info("Navigated to User page");
		  romuipages.userManagementPage().userValidation();
		  logger.info("User Error Validation Feature has been validated successfully");
		  
		  }
		  
		  @Test(enabled = true, priority=13,description = "Role Error Validation")
		  public void testRoleErrorValidation()throws JsonParseException,
		  JsonMappingException, IOException, InterruptedException {
		  
		  logger.info("Login credentials to be entered");
		  romuipages.loginPage().login(env.getUserName(), env.getPassword());
		  romuipages.homePage().clickOnLandingButton("Order Management");
		  logger.info("Order Management link is clicked on");
		  romuipages.orderMgmPage().clickOnRoles();
		  logger.info("Navigated to User page");
		  romuipages.userManagementPage().roleValidation();
		  logger.info("Role Error Validation Feature has been validated successfully");
		  
		  }
		 

}