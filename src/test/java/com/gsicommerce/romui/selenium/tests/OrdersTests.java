package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;

public class OrdersTests extends ROMUIBasePage {

	@Test(enabled = false, priority = 1, description = "to Verify search order by Order number")
	public void testSearchOrderbyNumber() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		//romuipages.loginPage().loginSSO(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		//romuipages.ordersPage().searchOrderByOrderNum("ordernumber");
		romuipages.ordersPage().searchOrderBy(0);
		logger.info("Search By Order Number verified");

	}

	@Test(enabled = false, priority = 2, description = "to Verify search order by Fullfillment number")
	public void testSearchOrderByFullfillmentNumber()
			throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		//romuipages.ordersPage().searchOrderByFulfillOrderNum("FulfillmentOrderID");
		romuipages.ordersPage().searchOrderBy(1);
		logger.info("Search By Fulfillment Order Number verified");

	}

	@Test(enabled = false, priority = 3, description = "to Verify search order by Customer Name")
	public void testSearchOrderByCustomerName()
			throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		//romuipages.ordersPage().searchOrderByCustomerName("firstname", "lastname");
		romuipages.ordersPage().searchOrderBy(2);
		logger.info("Search By Customer Name verified");

	}

	@Test(enabled = false, priority = 4, description = "to Verify search order by Email id")
	public void testSearchOrderByEmail() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		//romuipages.ordersPage().searchOrderByEmail("Email");
		romuipages.ordersPage().searchOrderBy(3);
		logger.info("Search By EmailID verified");

	}

	@Test(enabled = false, priority = 5, description = "to Verify search order by Order Status")
	public void testSearchOrderByOrderStatus() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		//romuipages.ordersPage().searchOrderByOrderStatus("StatusFrom", "StatusTo");
		romuipages.ordersPage().searchOrderBy(4);
		logger.info("Search By Order Status verified");

	}

	@Test(enabled = false, priority = 6, description = "to Verify edit search order ")
	public void testEditSearch() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		romuipages.ordersPage().clickEditSearch();
		logger.info("Edit Search verified");
	}

	@Test(enabled = false, priority = 7, description = "View Order Detail page by order number search")
	public void testViewOrder() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		logger.info("Verify view order screen for Order number search");
		 romuipages.ordersPage().viewOrders(0);
		 logger.info("View order screen has been verified by Search  Order number");
			 
	}
	
	@Test(enabled = false, priority =8, description = "View Order Detail page by fulfillment order search")
	public void testViewOrderByFulfillment() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
	 logger.info("Verify view order screen for fulfillment Order number search");
		 romuipages.ordersPage().viewOrders(1);
		logger.info("View order screen has been verified by Search  Fulfillment Order number");
		 
		 
	}
	
	@Test(enabled = false, priority = 9, description = "View Order Detail page by Customer name search")
	public void testViewOrderByCustomername() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		 logger.info("Verify view order screen for customer name search");
		 romuipages.ordersPage().viewOrders(2);
		 logger.info("View order screen has been verified by Search  Customer Name");
		 
	}
	
	@Test(enabled = false, priority = 10, description = "View Order Detail page by Email search")
	public void testViewOrderByEmail() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		 logger.info("Verify view order screen for Email search");
		 romuipages.ordersPage().viewOrders(3);
		 logger.info("View order screen has been verified by Search  Email");
	}
	
	@Test(enabled = false, priority = 11, description = "View Order Detail page by order status search")
	public void testViewOrderByStatus() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		 logger.info("Verify view order screen for order status search");
		 romuipages.ordersPage().viewOrders(4);
		 logger.info("View order screen has been verified by Search  order status");
	}
	
	
	
	@Test(enabled = false, priority =8, description = "form validation")
	public void testOrderSearchFormValidation()
			throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		romuipages.ordersPage().orderSearchFormValidation();
		logger.info("Error Form Validation verified");

}
	
	@Test(enabled = true, priority = 11, description = "To Verify Add Zero Cost Order")
	public void testAddZCOrder() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		 logger.info("Verify ZC Order creation");
		 romuipages.ordersPage().addZeroCostOrder();
		 logger.info("Add Zero Cost Order Validated");
	}
	
	
}
