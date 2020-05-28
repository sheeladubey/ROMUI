package com.gsicommerce.romui.selenium.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;

public class OrdersTest extends ROMUIBasePage {

	@Test(enabled = true, priority = 1, description = "to Verify search order by Order number")
	public void testSearchOrderbyNumber() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		romuipages.ordersPage().searchOrderByOrderNum("ordernumber");

	}

	@Test(enabled = true, priority = 2, description = "to Verify search order by Fullfillment number")
	public void testSearchOrderByFullfillmentNumber()
			throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		romuipages.ordersPage().searchOrderByFulfillOrderNum("FulfillmentOrderID");

	}

	@Test(enabled = true, priority = 3, description = "to Verify search order by Customer Name")
	public void testSearchOrderByCustomerName()
			throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		romuipages.ordersPage().searchOrderByCustomerName("firstname", "lastname");

	}

	@Test(enabled = true, priority = 4, description = "to Verify search order by Email id")
	public void testSearchOrderByEmail() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		romuipages.ordersPage().searchOrderByEmail("Email");

	}

	@Test(enabled = false, priority = 1, description = "View Order Detail page")
	public void testViewOrder() throws JsonParseException, JsonMappingException, IOException, Exception {

		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.homePage().clickOnLandingButton("Order Management");
		logger.info("Order Management link is clicked on");
		romuipages.orderMgmPage().clickOnOrders();
		logger.info("Navigated to Orders page");
		romuipages.ordersPage().searchOrderByCustomerName(null, null);
		logger.info("Search Criteria by Cusomter name displayed");
		// romuipages.ordersPage().viewOrder();

	}

}
