package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
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

	public void searchByOrderNumber(String orderNumber) throws Exception {
		Action.enter(txtOrderNo, orderNumber);
		CommonElementsPage.clickOnSearchBtn();
	}

	public void pickOrder() throws Exception {
		data = SFSData.get(env.getFileLocation());
		int rowNo = CommonElementsPage.getRowNo(data.getNodeID());
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		searchByOrderNumber(data.getOrderNo());
		btnPickOrder.click();
		confirmPickTicket(data.getQtyList(), data.getItemIdList());
		// CommonElementsPage.clickOnConfirmBtn();
		// Action.switchWindow("Confirm Pick Ticket");
		// CommonElementsPage.enterStagingLoc(data.getLocId());
		// CommonElementsPage.clickOnContinueBtn();
		// Common.closePrintPopup();
	}

	public void completePackOrder() throws Exception {
		data = SFSData.get(env.getFileLocation());
		int rowNo = CommonElementsPage.getRowNo(data.getNodeID());
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		searchByOrderNumber(data.getOrderNo());
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
}
