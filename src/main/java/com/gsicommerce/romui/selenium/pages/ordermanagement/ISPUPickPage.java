package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.ISPUData;
import com.gsicommerce.romui.selenium.utilities.Action;

public class ISPUPickPage {

	WebDriver driver;
	Environment env;
	Action action;
	private ISPUData data;

	public ISPUPickPage(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);

	}

	@FindBy(how = How.CSS, using = "#fulfillment_order_queue_search_order_display_id")
	@CacheLookup
	private WebElement txtOrderNo;

	@FindBy(how = How.CSS, using = "[data-tooltip='Pick Order']")
	@CacheLookup
	private WebElement btnPickOrder;

	@FindBy(how = How.CSS, using = "#store_fulfillment_pick_ticket_1_picked_quantity")
	@CacheLookup
	private WebElement drpdwnPick;

	@FindBy(how = How.CSS, using = "#store_fulfillment_pick_ticket_1_canceled_quantity")
	@CacheLookup
	private WebElement drpdwnDeclined;

	@FindBy(how = How.CSS, using = "[data-tooltip='Complete Pickup']")
	@CacheLookup
	private WebElement btnCompletePickup;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Complete Pickup')]")
	@CacheLookup
	private WebElement btnCompletePickup2;
	
	@FindBy(how = How.CSS, using = "[data-tooltip='View Fulfillment Order']")
	@CacheLookup
	private WebElement lkViewFulfilmtOrder;
	

	@FindBy(how = How.CSS, using = ".fulfillment-order-summary-heading")
	@CacheLookup
	public WebElement txtFulfilmntOrderNo;

	@FindBy(how = How.CSS, using = ".col-sm-4.col-md-3.fulfillment-order-mobile-details")
	private List<WebElement> fulfilmntOrderDetailSection;

	@FindBy(how = How.CSS, using = ".col-xs-6.col-md-4.fulfillment-order-mobile-details")
	private List<WebElement> fulfilmntOrderSKUDetailSection;
	
	@FindBy(how = How.CSS, using = "#fulfillment_order_queue_search_order_id")
	@CacheLookup
	private WebElement txtFulfilmentOrderNo;
	
	@FindBy(how = How.CSS, using = "[data-item-declined='']")
	@CacheLookup
	private List<WebElement> drpdwnSelectDecline;
	
	@FindBy(how = How.CSS, using = "[data-decline-reasons='']")
	@CacheLookup
	private List<WebElement> drpdwnSelectDeclineReason;
	
	@FindBy(how = How.CSS, using = "[data-pick-choices='']")
	@CacheLookup
	private List<WebElement> drpdwnSelectPickTicketQty;
	
	@FindBy(how = How.CSS, using = "[data-tooltip='Print Pick Ticket']")
	@CacheLookup
	private WebElement lkPrintPickTicket;

	public void searchByOrderNumber(String orderNumber) throws Exception {
		CommonElementsPage.clickOnSearchIcon();
		Action.enter(txtFulfilmentOrderNo, orderNumber);
		CommonElementsPage.clickOnSearchBtn();
	}

	public void pickOrder(ISPUData data) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(data.getNodeID(),1);
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		searchByOrderNumber(data.getOrderNoList().get(0));
		btnPickOrder.click();
		selectAllItemsAndQuantities(data.getQtyList(),data.getItemIdList());
		//Action.selectByVisibleText(drpdwnPick, data.getQtyList().get(0));
		CommonElementsPage.clickOnConfirmBtn();
		Action.switchWindow("Confirm Pick Ticket");
		CommonElementsPage.enterStagingLoc(data.getLocId());
		CommonElementsPage.clickOnContinueBtn();
		Action.closePrintDialog();
	}

	public void customerPickup(ISPUData data) throws Exception {
		searchByOrderNumber(data.getOrderNoList().get(0));
		CommonElementsPage.clickActionsIconWithoutSpan(0, 8, 2);
		selectAllItemsAndQuantities(data.getQtyList(), data.getItemIdList());
		btnCompletePickup2.click();
		Action.closePrintDialog();
	}

	public void completeOrderPickup(List<String> quantity, List<String> itemId) {
		selectAllItemsAndQuantities(quantity, itemId);
		btnCompletePickup2.click();

	}

	public void selectItemQuantityDropdown(String quantity, String itemId) {
		WebElement drpdwnPickupQty = driver
				.findElement(By.cssSelector("#store_fulfillment_fulfillment_order_" + itemId + "_picked_quantity"));
		Action.selectByVisibleText(drpdwnPickupQty, quantity);
	}

	public void selectAllItemsAndQuantities(final List<String> itemQuantityList, final List<String> itemIdList) {
		String itemId;
		String quantity;
		for (int i = 0; i < itemIdList.size(); i++) {

			quantity = itemQuantityList.get(i).trim();
			itemId = itemIdList.get(i).trim();

			if ((itemId != null) && !(itemId.equalsIgnoreCase("null"))) {
				Reporter.log("finding quantity:" + quantity);
				selectItemQuantityDropdown(quantity, itemId);
			}

		}
	}

	public void viewFulfillmentOrderDetails(String nodeID, String orderNo) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(nodeID,1);
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		searchByOrderNumber(orderNo);
		lkViewFulfilmtOrder.click();
		Action.waitForElementToBeVisible(driver, txtFulfilmntOrderNo, 30);
	}

	public boolean verifyViewFulfilmntOrderDetails(String searchItem, String section, int index)
			throws Exception {
		boolean found = false;
		if (section.equals("order")) {
			
			if (fulfilmntOrderDetailSection.get(index).getText().contains(searchItem)) {
				found = true;
			}
		} else if (section.equals("sku")) {
			if (fulfilmntOrderSKUDetailSection.get(index).getText().contains(searchItem)) {
				found = true;
			}
		}
		return found;

	}
	
	public void navigateBack() {
		Action.navigateBack();
	}
	
	public void singleRowPickOrder(ISPUData data) throws Exception {
		btnPickOrder.click();
		Action.selectByVisibleText(drpdwnPick, data.getQtyList().get(0));
		CommonElementsPage.clickOnConfirmBtn();
		Action.switchWindow("Confirm Pick Ticket");
		CommonElementsPage.enterStagingLoc(data.getLocId());
		CommonElementsPage.clickOnContinueBtn();
		Action.closePrintDialog();
	}
	
	public void selectAllDecline(String qty) {
		for (int i = 1; i <= drpdwnSelectDecline.size(); i++) {
			selectDeclineDropdown(qty, Integer.toString(i));
		}
	}

	public void selectDeclineDropdown(String qty,String index) {
		WebElement drpdwnDecline = driver
				.findElement(By.cssSelector("#store_fulfillment_pick_ticket_"+index+"_canceled_quantity"));
		Action.selectByVisibleText(drpdwnDecline, qty);
	}
	
	public void selectAllDeclineReason() {
		for (int i = 1; i <= drpdwnSelectDeclineReason.size(); i++) {
			selectDeclineReasonDropdown(Integer.toString(i));
		}
	}

	public void selectDeclineReasonDropdown(String index) {
		WebElement drpdwnDecline = driver
				.findElement(By.cssSelector("#store_fulfillment_pick_ticket_"+index+"_cancellation_reason_code"));
		Action.selectByIndex(drpdwnDecline, 1);
	}
	
	public void selectAllPickTicketQty() {
		for (int i = 1; i <= drpdwnSelectPickTicketQty.size(); i++) {
			selectPickTicketQtyDropdown(Integer.toString(i));
		}
	}

	public void selectPickTicketQtyDropdown(String index) {
		WebElement drpdwnPickTktQty = driver
				.findElement(By.cssSelector("#store_fulfillment_pick_ticket_"+index+"_picked_quantity"));
		Action.selectByIndex(drpdwnPickTktQty, 1);
	}
	
	public void pickOrderDecline(ISPUData data) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(data.getNodeID(),1);
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		searchByOrderNumber(data.getOrderNoList().get(1));
		btnPickOrder.click();
		selectAllPickTicketQty();
		selectAllDecline(data.getDeclineQty());
		selectAllDeclineReason();
		CommonElementsPage.clickOnConfirmBtn();
		Action.switchWindow("Confirm Pick Ticket");
		CommonElementsPage.enterStagingLoc(data.getLocId());
		CommonElementsPage.clickOnContinueBtn();
		Action.closePrintDialog();
	}
	
	public void customerPickupDecline(ISPUData data) throws Exception {
		searchByOrderNumber(data.getOrderNoList().get(0));
		CommonElementsPage.clickActionsIconWithoutSpan(0, 8, 2);
		selectAllItemsAndQuantities(data.getQtyList(), data.getItemIdList());
		selectCustomerPickupAllDecline("1", data.getItemIdList());
		selectCustomerPickupAllDeclineReason(data.getItemIdList());
		btnCompletePickup2.click();
		Action.closePrintDialog();
	}
	
	public void selectCustomerPickupAllDecline(String qty, final List<String> itemIdList ) {
		for (int i = 1; i <= drpdwnSelectDecline.size(); i++) {
			selectCustomerPickupDeclineDropdown(qty, itemIdList.get(i-1));
		}
	}

	public void selectCustomerPickupDeclineDropdown(String qty,String index) {
		WebElement drpdwnDecline = driver
				.findElement(By.cssSelector("#store_fulfillment_fulfillment_order_"+index+"_canceled_quantity"));
		Action.selectByVisibleText(drpdwnDecline, qty);
	}
	
	public void selectCustomerPickupAllDeclineReason(final List<String> itemIdList) {
		for (int i = 1; i <= drpdwnSelectDeclineReason.size(); i++) {
			selectCustomerPickupDeclineReasonDropdown(itemIdList.get(i-1));
		}
	}

	public void selectCustomerPickupDeclineReasonDropdown(String index) {
		WebElement drpdwnDecline = driver
				.findElement(By.cssSelector("#store_fulfillment_fulfillment_order_"+index+"_cancellation_reason_code"));
		Action.selectByIndex(drpdwnDecline, 1);
	}
	
	public void viewPrintPickTicket(String orderNo) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(orderNo, 2);
		CommonElementsPage.clickDivSpanLink(rowNo, 7,0, 2,1);
		Action.closePrintDialog();
	}
	
	public void getMyTicket(String nodeID, String orderNo) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(nodeID,1);
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		CommonElementsPage.clickOnSearchIcon();
		Action.enter(txtFulfilmentOrderNo, orderNo);
		CommonElementsPage.clickOnGetMyTicketsBtn();
		Assert.assertNotNull(CommonElementsPage.getRowCellTextVal(1, 1),"No data displayed for Pick Ticket Summary page");
	}
	
}
