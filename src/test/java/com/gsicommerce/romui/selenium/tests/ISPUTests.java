package com.gsicommerce.romui.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.testdata.ISPUData;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class ISPUTests extends ROMUIBasePage {
	
	private ISPUData data;

	@Test(enabled = false, description = "to Verify ISPU Pick Order")
	public void testISPUPickOrder() throws Exception {
		data = ISPUData.get(env.getFileLocation());
		String orderNo = data.getOrderNoList().get(0);
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.loginPage().selectNode(data.getStoreIndex(), data.getNodeID());
		//romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToISPUPick();
		romuipages.ispuPickPage().viewFulfillmentOrderDetails(data.getNodeID(), orderNo);
		Assert.assertTrue(romuipages.ispuPickPage().txtFulfilmntOrderNo.getText().contains(orderNo), "Fulfilment Order No is not found");
		romuipages.ispuPickPage().verifyViewFulfilmntOrderDetails(data.getShipMethod(),"order", 1);
		romuipages.ispuPickPage().verifyViewFulfilmntOrderDetails(data.getNodeID(),"order", 1);
		romuipages.ispuPickPage().verifyViewFulfilmntOrderDetails(data.getItemIdList().get(0),"sku", 0);
		romuipages.ispuPickPage().verifyViewFulfilmntOrderDetails(data.getItemIdList().get(1),"sku", 2);
		romuipages.ispuPickPage().verifyViewFulfilmntOrderDetails(data.getQtyList().get(0),"sku", 1);
		romuipages.ispuPickPage().verifyViewFulfilmntOrderDetails(data.getQtyList().get(1),"sku", 3);
		romuipages.ispuPickPage().navigateBack();
		romuipages.ispuPickPage().singleRowPickOrder(data);
		romuipages.storeFulflmtDashbrdPage().navigateToOrderSearch();
		romuipages.ordersPage().verifyOrderNoStatus(data.getOrderNoList().get(0), RomuiEnumValues.READY_FOR_PICKUP);
	}
	
	@Test(enabled = false, description = "to Verify ISPU Pick Order decline")
	public void testISPUPickOrderDecline() throws Exception {
		data = ISPUData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.loginPage().selectNode(data.getStoreIndex(), data.getNodeID());
		//romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToISPUPick();
		romuipages.ispuPickPage().pickOrderDecline(data);
		romuipages.storeFulflmtDashbrdPage().navigateToOrderSearch();
		romuipages.ordersPage().verifyOrderNoStatus(data.getOrderNoList().get(1), RomuiEnumValues.READY_FOR_PICKUP);
	}

	@Test(enabled = false, description = "to Verify ISPU Customer Pickup Order for pickup complete")
	public void testISPUCustomerPickup() throws Exception {
		data = ISPUData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		//romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.loginPage().selectNode(data.getStoreIndex(), data.getNodeID());
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToISPUCustPickup();
		romuipages.ispuPickPage().customerPickup(data);
		romuipages.storeFulflmtDashbrdPage().navigateToOrderSearch();
		romuipages.ordersPage().verifyOrderNoStatus(data.getOrderNoList().get(1), RomuiEnumValues.PICKUP_COMPLETE);
	}
	
	@Test(enabled = false, description = "to Verify ISPU decline Customer Pickup Order for pickup complete")
	public void testISPUCustomerPickupDecline() throws Exception {
		data = ISPUData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		//romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.loginPage().selectNode(data.getStoreIndex(), data.getNodeID());
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToISPUCustPickup();
		romuipages.ispuPickPage().customerPickupDecline(data);
		romuipages.storeFulflmtDashbrdPage().navigateToOrderSearch();
		romuipages.ordersPage().verifyOrderNoStatus(data.getOrderNoList().get(1), RomuiEnumValues.PICKUP_COMPLETE);
	}
	
	@Test(enabled = true, description = "to Verify ISPU print pick ticket")
	public void testISPUPrintPickTicket() throws Exception {
		data = ISPUData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		//romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.loginPage().selectNode(data.getStoreIndex(), data.getNodeID());
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToISPUPick();
		romuipages.ispuPickPage().viewPrintPickTicket(data.getOrderNoList().get(0));		
	}
	
	@Test(enabled = true, description = "to Verify ISPU Get My tickets")
	public void testISPUGetMyTickets() throws Exception {
		data = ISPUData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		//romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.loginPage().selectNode(data.getStoreIndex(), data.getNodeID());
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToISPUPick();
		romuipages.ispuPickPage().getMyTicket(data.getNodeID(), data.getOrderNoList().get(0));		
	}
}
