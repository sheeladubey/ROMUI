package com.gsicommerce.romui.selenium.pages.ordermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;

public class ISPUPickPage {

	WebDriver driver;
	Environment env;
	Action action;

	public ISPUPickPage(WebDriver driver, Environment env) {
		// TODO Auto-generated constructor stub
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

	public void searchByOrderNumber(String orderNumber) throws Exception {
		Action.enter(txtOrderNo, orderNumber);
		CommonElementsPage.clickOnSearchBtn();
	}

	public void pickOrder(String nodeID, String orderNumber, String Qty, String loc) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(nodeID);
		CommonElementsPage.clickActionsIcon(rowNo, 4, 0);
		searchByOrderNumber(orderNumber);
		btnPickOrder.click();
		Action.selectByVisibleText(drpdwnPick, Qty);
		CommonElementsPage.clickOnConfirmBtn();
		Action.switchWindow("Confirm Pick Ticket");
		CommonElementsPage.enterStagingLoc(loc);
		CommonElementsPage.clickOnContinueBtn();
		Common.closePrintPopup();
	}

}
