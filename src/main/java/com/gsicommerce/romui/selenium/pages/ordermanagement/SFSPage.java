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
import com.gsicommerce.romui.selenium.testdata.SFSData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;

public class SFSPage {

	WebDriver driver;
	Environment env;
	Action action;
	private SFSData data;

	public SFSPage(WebDriver driver, Environment env) {
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

	@FindBy(how = How.CSS, using = "[data-tooltip='Pack Order']")
	@CacheLookup
	private WebElement btnPackOrder;

	@FindBy(how = How.CSS, using = "#store_fulfillment_pack_packages_attributes_0_box_id")
	@CacheLookup
	private List<WebElement> drpdwnBoxID;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Complete Packing')]")
	@CacheLookup
	private WebElement btnCompletePacking;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Confirm Shipment')]")
	@CacheLookup
	private WebElement btnConfirmShipment;

	@FindBy(how = How.XPATH, using = "//*[@class='panel-title pack-click-area']")
	@CacheLookup
	private List<WebElement> packageArea;
	
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
	
	@FindBy(how = How.CSS, using = "[data-item-declined='']")
	@CacheLookup
	private List<WebElement> drpdwnSelectDecline;
	
	@FindBy(how = How.CSS, using = "[data-decline-reasons='']")
	@CacheLookup
	private List<WebElement> drpdwnSelectDeclineReason;
	
	@FindBy(how = How.CSS, using = "#fulfillment_order_queue_search_order_id")
	@CacheLookup
	private WebElement txtSearchFulfilmntOrderNo;
	
	@FindBy(how = How.CSS, using = "[data-check-all='']")
	@CacheLookup
	private List<WebElement> listSelectCheckboxes;
	
	@FindBy(how = How.CSS, using = "[name='bulk_decline']")
	@CacheLookup
	public WebElement btnConfirm;
	
	@FindBy(how = How.CSS, using = "[data-tooltip='Print Pick Ticket']")
	@CacheLookup
	private WebElement lkPrintPickTicket;


	public void searchByOrderNumber(String orderNumber) throws Exception {
		CommonElementsPage.clickOnSearchIcon();
		Action.enter(txtSearchFulfilmntOrderNo, orderNumber);
		CommonElementsPage.clickOnSearchBtn();
	}

	public void pickOrder(SFSData data) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(data.getNodeID(),1);
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		searchByOrderNumber(data.getOrderNoList().get(0));
		btnPickOrder.click();
		confirmPickTicket(data.getQtyList(), data.getItemIdList());		
	}

	public void completePackOrder(SFSData data) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(data.getNodeID(),1);
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		searchByOrderNumber(data.getOrderNoList().get(0));
		btnPackOrder.click();
		selectAllBoxID(1);
		btnCompletePacking.click();
		Common.closePrintPopup();
		Action.waitForElementToBeClickable(driver, btnConfirmShipment, 30);
		btnConfirmShipment.click();
	}

	public void confirmPickTicket(List<String> quantity, List<String> itemId) {
		selectAllItemsAndQuantities(quantity, itemId);
		CommonElementsPage.clickOnConfirmBtn();
	}

	public void selectItemQuantityDropdown(String quantity, String itemNo) {
		WebElement drpdwnPickupQty = driver
				.findElement(By.cssSelector("#store_fulfillment_pick_ticket_" + itemNo + "_picked_quantity"));
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
				String itemNo = Integer.toString(itemIdList.size() - i);
				selectItemQuantityDropdown(quantity, itemNo);
			}

		}
	}

	public void selectAllBoxID(int index) {
		for (int i = 0; i < packageArea.size(); i++) {
			selectBoxIDDropdown(index, Integer.toString(i));
		}
	}

	public void selectBoxIDDropdown(int index, String boxNo) {
		WebElement drpdwnBoxID = driver
				.findElement(By.cssSelector("#store_fulfillment_pack_packages_attributes_" + boxNo + "_box_id"));
		Action.selectByIndex(drpdwnBoxID, index);
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
	
	public void pickOrderDecline(SFSData data) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(data.getNodeID(),1);
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		searchByOrderNumber(data.getOrderNoList().get(0));
		btnPickOrder.click();
		selectAllItemsAndQuantities(data.getQtyList(), data.getItemIdList());
		selectAllDecline(data.getDeclineQty());
		selectAllDeclineReason();
		CommonElementsPage.clickOnConfirmBtn();	
	}
	
	public void pickSelected(SFSData data) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(data.getNodeID(),1);
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		rowNo=0;
		for (int i=0;i<data.getOrderNoList().size();i++) {
			rowNo = CommonElementsPage.getRowNo(data.getOrderNoList().get(i),2);
			if(rowNo!=0) {
				listSelectCheckboxes.get(rowNo -1).click();
			}
		}
		CommonElementsPage.btnPickSelected.click();
		selectAllItemsAndQuantities(data.getQtyList(), data.getItemIdList());
		CommonElementsPage.clickOnConfirmBtn();
	}
	
	public void bulkDecline(SFSData data) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(data.getNodeID(),1);
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		rowNo=0;
		for (int i=0;i<data.getOrderNoList().size();i++) {
			rowNo = CommonElementsPage.getRowNo(data.getOrderNoList().get(i),2);
			if(rowNo!=0) {
				listSelectCheckboxes.get(rowNo -1).click();
			}
		}
		CommonElementsPage.btnBulkDecline.click();
		Action.waitForElementToBeClickable(driver, btnConfirm, 30);
		btnConfirm.click();		
	}
	
	public void printPickTicket(String nodeID, String orderNo) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(nodeID,1);
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		searchByOrderNumber(orderNo);
		lkPrintPickTicket.click();
		Action.closePrintDialog();
	}
	public void getMyTicket(String nodeID, String orderNo) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(nodeID,1);
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		CommonElementsPage.clickOnSearchIcon();
		Action.enter(txtSearchFulfilmntOrderNo, orderNo);
		CommonElementsPage.clickOnGetMyTicketsBtn();
		Assert.assertNotNull(CommonElementsPage.getRowCellTextVal(1, 1),"No data displayed for Pick Ticket Summary page");
	}

}
