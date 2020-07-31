package com.gsicommerce.romui.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.gsicommerce.romui.selenium.pages.ROMUIBasePage;
import com.gsicommerce.romui.selenium.testdata.SFSData;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class SFSTests extends ROMUIBasePage {
	
	private SFSData data;
	
	@Test(enabled = false, description = "to Verify SFS Pick Order")
	public void testSFSPickOrder() throws Exception {
		data = SFSData.get(env.getFileLocation());
		String orderNo = data.getOrderNoList().get(0);
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.loginPage().selectNode(data.getStoreIndex(), data.getNodeID());
		//romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToSFSPick();
		romuipages.ispuPickPage().viewFulfillmentOrderDetails(data.getNodeID(), orderNo);
		Assert.assertTrue(romuipages.ispuPickPage().txtFulfilmntOrderNo.getText().contains(orderNo), "Fulfilment Order No is not found");
		romuipages.ispuPickPage().verifyViewFulfilmntOrderDetails(data.getNodeID(),"order", 1);
		romuipages.ispuPickPage().verifyViewFulfilmntOrderDetails(data.getItemIdList().get(0),"sku", 0);
		romuipages.ispuPickPage().verifyViewFulfilmntOrderDetails(data.getItemIdList().get(1),"sku", 2);
		romuipages.ispuPickPage().verifyViewFulfilmntOrderDetails(data.getQtyList().get(0),"sku", 1);
		romuipages.ispuPickPage().verifyViewFulfilmntOrderDetails(data.getQtyList().get(1),"sku", 3);
		romuipages.ispuPickPage().navigateBack();
		romuipages.sfsPage().pickOrder(data);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SFS_PICKORDER_SUCCESS_MSG.getMessage(), "Order is not picked up successfully");
		romuipages.storeFulflmtDashbrdPage().navigateToOrderSearch();
		romuipages.ordersPage().verifyOrderNoStatus(data.getOrderNoList().get(0), RomuiEnumValues.READY_FOR_PACK);
	}
	
	@Test(enabled = false, description = "to Verify SFS Pick Order Decline")
	public void testSFSPickOrderDecline() throws Exception {
		data = SFSData.get(env.getFileLocation());
		String orderNo = data.getOrderNoList().get(0);
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.loginPage().selectNode(data.getStoreIndex(), data.getNodeID());
		//romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToSFSPick();
		romuipages.sfsPage().pickOrderDecline(data);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SFS_PICKORDER_SUCCESS_MSG.getMessage(), "Order is not picked up successfully");
		romuipages.storeFulflmtDashbrdPage().navigateToOrderSearch();
		romuipages.ordersPage().verifyOrderNoStatus(data.getOrderNoList().get(0), RomuiEnumValues.READY_FOR_PACK);
	}
	
	@Test(enabled = false, description = "to Verify SFS Pick Order Pick Selected")
	public void testSFSPickSelectedPickOrder() throws Exception {
		data = SFSData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.loginPage().selectNode(data.getStoreIndex(), data.getNodeID());
		//romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToSFSPick();
		romuipages.sfsPage().pickSelected(data);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SFS_PICKORDER_SUCCESS_MSG.getMessage(), "Orders are not select picked up successfully");
		romuipages.storeFulflmtDashbrdPage().navigateToOrderSearch();
		romuipages.ordersPage().verifyOrderNoStatus(data.getOrderNoList().get(0), RomuiEnumValues.READY_FOR_PACK);
	}
	
	@Test(enabled = false, description = "to Verify SFS Bulk Decline")
	public void testSFSBulkDecline() throws Exception {
		data = SFSData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.loginPage().selectNode(data.getStoreIndex(), data.getNodeID());
		//romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToSFSPick();
		romuipages.sfsPage().bulkDecline(data);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SFS_BULK_DECLINE_SUCCESS_MSG.getMessage(), "Buld Decline is not successful");
		
	}
	
	@Test(enabled = false, description = "to Verify SFS Print Pick Ticket")
	public void testSFSPrintPickTicket() throws Exception {
		data = SFSData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.loginPage().selectNode(data.getStoreIndex(), data.getNodeID());
		//romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToSFSPick();
		romuipages.sfsPage().printPickTicket(data.getNodeID(), data.getOrderNoList().get(0));		
	}

	@Test(enabled = true, description = "to Verify SFS Get My Ticket")
	public void testSFSGetMykTicket() throws Exception {
		data = SFSData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.loginPage().selectNode(data.getStoreIndex(), data.getNodeID());
		//romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToSFSPick();
		romuipages.sfsPage().getMyTicket(data.getNodeID(), data.getOrderNoList().get(0));		
	}

	@Test(enabled = false, description = "to Verify SFS Pack Order")
	public void testSFSPackOrder() throws Exception {
		data = SFSData.get(env.getFileLocation());
		logger.info("Login credentials to be entered");
		romuipages.loginPage().login(env.getUserName(), env.getPassword());
		romuipages.loginPage().selectNode(data.getStoreIndex(), data.getNodeID());
		//romuipages.homePage().clickOnLandingButton("Order Management");
		romuipages.orderMgmPage().clickOnStoreFulfillment();
		romuipages.storeFulflmtDashbrdPage().navigateToSFSPack();
		romuipages.sfsPage().completePackOrder(data);
		Assert.assertEquals(romuipages.commonElePage().txtEditSuccessMsg.getText(),
				RomuiEnumValues.SFS_PACKORDER_SUCCESS_MSG.getMessage(), "Order is not packed up successfully");
		romuipages.storeFulflmtDashbrdPage().navigateToOrderSearch();
		romuipages.ordersPage().verifyOrderNoStatus(data.getOrderNoList().get(0), RomuiEnumValues.READY_FOR_PACK);
	}
	
	
}
