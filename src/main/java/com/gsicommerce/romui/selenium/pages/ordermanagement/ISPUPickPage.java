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
import com.gsicommerce.romui.selenium.testdata.ISPUData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;

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

//	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Complete Pickup')]")
//	@CacheLookup
//	private List<WebElement> itemRows;

	public void searchByOrderNumber(String orderNumber) throws Exception {
		Action.enter(txtOrderNo, orderNumber);
		CommonElementsPage.clickOnSearchBtn();
	}

	public void pickOrder() throws Exception {
		data = ISPUData.get(env.getFileLocation());
		int rowNo = CommonElementsPage.getRowNo(data.getNodeID());
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		searchByOrderNumber(data.getOrderNo());
		btnPickOrder.click();
		Action.selectByVisibleText(drpdwnPick, data.getQtyList().get(0));
		CommonElementsPage.clickOnConfirmBtn();
		Action.switchWindow("Confirm Pick Ticket");
		CommonElementsPage.enterStagingLoc(data.getLocId());
		CommonElementsPage.clickOnContinueBtn();
		Common.closePrintPopup();
	}

	public void customerPickup() throws Exception {
		data = ISPUData.get(env.getFileLocation());
		int rowNo = CommonElementsPage.getRowNo(data.getNodeID());
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		searchByOrderNumber(data.getOrderNo());
		btnCompletePickup.click();
		completeOrderPickup(data.getQtyList(), data.getItemIdList());
		Common.closePrintPopup();
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
}
