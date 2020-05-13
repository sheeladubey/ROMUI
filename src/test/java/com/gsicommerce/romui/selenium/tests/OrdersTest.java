package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;

public class OrdersTest extends ROMUIBasePage {
	
	@Test(enabled = true, priority=1,description = "Search Order by Order number")
	public void testSearchOrderbyNumber()throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");	
		romuipages.ordersPage().searchOrderByOrderNum();
	}
	
	@Test(enabled = true, priority=1,description = "Search Order by Fullfillment number")
	public void testSearchOrderByFullfillmentNumber()throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");	
        romuipages.ordersPage().searchOrderByFulfillOrderNum();
	
}
	
	@Test(enabled = true, priority=1,description = "Search Order by Customer Name")
	public void testSearchOrderByCustomerName()throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");	
		romuipages.ordersPage().searchOrderByCustomerName();
		

}
	
	@Test(enabled = true, priority=1,description = "Search Order by Email id")
	public void testSearchOrderByEmail()throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");		
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");	
		romuipages.ordersPage().searchOrderByEmail();

}
}
