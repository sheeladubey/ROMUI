package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.OrdersData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;
import com.gsicommerce.romui.selenium.utilities.Webtable;

public class OrdersPage {

	WebDriver driver;
	Environment env;
	Action action;
	private OrdersData ordersdata;
	private static String webOrderNumber;
	private static int rowNo;
	private static String emailID;
	private static String fulfillmentOrderNum;
	private static String customerName;

	public OrdersPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);
	}

	@FindBy(how = How.CSS, using = "#order_search_form_search_type")
	private WebElement drpdwnOrderSearchBy;

	@FindBy(how = How.CSS, using = "#order_search_form_display_id")
	private WebElement txtOrderNumber;

	@FindBy(how = How.CSS, using = "#order_search_form_fulfillment_order_id")
	@CacheLookup
	private WebElement txtFulfillmentOrderNumber;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-default'][contains(text(),'Search')]")
	private WebElement btnSearchOrder;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-default btn-block'][contains(text(),'Edit Search')]")
	private WebElement btnEditSearchOrder;

	@FindBy(how = How.XPATH, using = ".//option")
	@CacheLookup
	private List<WebElement> OrderSearchSelectDropDownOption;

	@FindBy(how = How.CSS, using = "#order_search_form_first_name")
	private WebElement txtCustomerFirstName;

	@FindBy(how = How.CSS, using = "#order_search_form_last_name")
	private WebElement txtCustomerLastName;

	@FindBy(how = How.CSS, using = "#order_search_form_start_date")
	private WebElement txtorderSearchStartDate;

	@FindBy(how = How.CSS, using = "#order_search_form_end_date")
	private WebElement txtorderSearchEndDate;

	@FindBy(how = How.CSS, using = "#order_search_form_email")
	private WebElement txtorderSearchEmail;

	@FindBy(how = How.CSS, using = "#order_search_form_status_from")
	private WebElement drpdwnOrderStatusFrom;

	@FindBy(how = How.CSS, using = "#order_search_form_status_to")
	private WebElement drpdwnOrderStatusTo;

	@FindBy(how = How.CSS, using = "[data-tooltip='View Order']")
	@CacheLookup
	private By btnViewOrder;

	// Search Order By WebOrderNumber
	public void searchOrderByOrderNum(String OrderID)
			throws JsonParseException, JsonMappingException, IOException, Exception {
		ordersdata = OrdersData.get(env.getFileLocation());
		// select search order type
		Action.selectByVisibleText(drpdwnOrderSearchBy, ordersdata.getSearchCriteria_OrderNumber());
		// Enter Web Order number
		Action.waitForElementToBeClickable(driver, txtOrderNumber, 10);
		webOrderNumber = ordersdata.getOrderID();
		Action.enter(txtOrderNumber, webOrderNumber);
		// click search btn
		btnSearchOrder.click();
		System.out.println("Selected row- " + CommonElementsPage.getRowNum(webOrderNumber));
		rowNo = CommonElementsPage.getRowNum(webOrderNumber);
		System.out.println("Selected Row Text is:" + Webtable.getTableCellText(rowNo, 1));

		if (Webtable.getTableCellText(rowNo, 1).contains(webOrderNumber)) {
			System.out.println("Order Search by Web order number successfull");
		} else {
			System.out.println("Order Search by Web order number doesn't show any order");
		}

		Assert.assertEquals(Webtable.getTableCellText(rowNo, 1), webOrderNumber,
				RomuiEnumValues.ORDER_NOTFOUND.getMessage());

	}

	/*
	 * Search order by Fulfillment Order ID
	 * 
	 * 
	 */
	public void searchOrderByFulfillOrderNum(String FulfilmentOrderID)
			throws JsonParseException, JsonMappingException, IOException, Exception {
		ordersdata = OrdersData.get(env.getFileLocation());
		// select search order type
		Action.selectByVisibleText(drpdwnOrderSearchBy, ordersdata.getSearchCriteria_FulfillmentOrderNumner());
		// enter Fulfillment Orderid
		Action.waitForElementToBeClickable(driver, txtFulfillmentOrderNumber, 10);
		fulfillmentOrderNum = ordersdata.getFulFillmentOrderID();
		Action.enter(txtFulfillmentOrderNumber, fulfillmentOrderNum);
		webOrderNumber = ordersdata.getOrderID();
		// click search btn
		btnSearchOrder.click();
		System.out.println("Selected row- " + CommonElementsPage.getRowNum(webOrderNumber));
		rowNo = CommonElementsPage.getRowNum(webOrderNumber);
		System.out.println("Selected Row Text is:" + Webtable.getTableCellText(rowNo, 1));

		if (Webtable.getTableCellText(rowNo, 1).contains(webOrderNumber)) {

			System.out.println("Order Search by Fulfillment order number successfull");
		} else {
			System.out.println("Order Search by Fulfillment order number doesn't show any order");
		}

		Assert.assertEquals(Webtable.getTableCellText(rowNo, 1), webOrderNumber,
				RomuiEnumValues.ORDER_NOTFOUND.getMessage());

	}

	/*
	 * Search order by Customer Name
	 * 
	 */
	public void searchOrderByCustomerName(String Firstname, String Lastname)
			throws JsonParseException, JsonMappingException, IOException, Exception {
		ordersdata = OrdersData.get(env.getFileLocation());
		// select search order type
		Action.selectByVisibleText(drpdwnOrderSearchBy, ordersdata.getSearchCriteria_CustomerName());
		// enter Customer Name
		Action.waitForElementToBeClickable(driver, txtCustomerFirstName, 10);
		String custFirstName = ordersdata.getCustomer_FirstName();
		String custLastName = ordersdata.getCustomer_LastName();
		Action.enter(txtCustomerFirstName, custFirstName);
		Action.enter(txtCustomerLastName, custLastName);
		customerName = custFirstName + " " + custLastName;
		webOrderNumber = ordersdata.getOrderID();
		// click search btn
		btnSearchOrder.click();
		System.out.println("Selected row- " + CommonElementsPage.getRowNum(webOrderNumber));
		rowNo = CommonElementsPage.getRowNum(webOrderNumber);
		System.out.println("Selected Row Text is:" + Webtable.getTableCellText(rowNo, 2));

		if (Webtable.getRowText(rowNo).contains(webOrderNumber)
				&& Webtable.getTableCellText(rowNo, 2).contains(customerName)) {
			System.out.println("Order Search by Customer name successfull");
		} else {
			System.out.println("Order Search by Customer name doesn't show any order");
		}
		Assert.assertEquals(Webtable.getTableCellText(rowNo, 2), customerName,
				RomuiEnumValues.ORDER_NOTFOUND.getMessage());

	}

	public void searchOrderByEmail(String Email)
			throws JsonParseException, JsonMappingException, IOException, Exception {
		ordersdata = OrdersData.get(env.getFileLocation());
		// select search order type
		Action.selectByVisibleText(drpdwnOrderSearchBy, ordersdata.getSearchCriteria_Email());
		// enter Email
		Action.waitForElementToBeClickable(driver, txtorderSearchEmail, 10);
		emailID = ordersdata.getEmailID();
		Action.enter(txtorderSearchEmail, emailID);
		webOrderNumber = ordersdata.getOrderID();
		// click search button
		btnSearchOrder.click();
		System.out.println("Selected row- " + CommonElementsPage.getRowNum(webOrderNumber));
		rowNo = CommonElementsPage.getRowNum(webOrderNumber);
		System.out.println("Selected Row Text is:" + Webtable.getTableCellText(rowNo, 3));
		if (Webtable.getRowText(rowNo).contains(webOrderNumber)
				&& Webtable.getTableCellText(rowNo, 3).contains(emailID)) {
			System.out.println("Order Search by Email id  successfull");
		} else {
			System.out.println("Order Search by Email id doesn't show any order");
		}
		Assert.assertEquals(Webtable.getTableCellText(rowNo, 3), emailID, RomuiEnumValues.ORDER_NOTFOUND.getMessage());

	}

	// Search Order By Order Status
	public void searchOrderByOrderStatus(String StatusFrom, String StatusTo)
			throws JsonParseException, JsonMappingException, IOException,Exception {
		ordersdata = OrdersData.get(env.getFileLocation());
		// select search order type
		Action.selectByVisibleText(drpdwnOrderSearchBy, ordersdata.getSearchCriteria_OrderStatus());
		Action.selectByVisibleText(drpdwnOrderStatusFrom, ordersdata.getOrderStatusFrom());
		Action.selectByVisibleText(drpdwnOrderStatusTo, ordersdata.getOrderStatusTo());
		// click search btn
		btnSearchOrder.click();
		System.out.println("Selected row- " + CommonElementsPage.getRowNum(ordersdata.getSearchCriteria_OrderStatus()));
		rowNo=CommonElementsPage.getRowNum(ordersdata.getSearchCriteria_OrderStatus());
		Assert.assertEquals(Webtable.getTableCellText(rowNo, 5), "Created", RomuiEnumValues.ORDER_NOTFOUND.getMessage());

	}

	public void clickEditSearch() throws JsonParseException, JsonMappingException, IOException, Exception {

		searchOrderByOrderNum(webOrderNumber);
		Action.waitForElementToBeClickable(driver, btnEditSearchOrder, 10);
		btnEditSearchOrder.click();
		searchOrderByEmail(emailID);
	}

	// Select SearchOrderBY options
	public void selectOrderSearchDropdown(String orderSearchOption) {

		drpdwnOrderSearchBy.click();
		for (int i = 0; i < OrderSearchSelectDropDownOption.size(); i++) {
			System.out.println(OrderSearchSelectDropDownOption.get(i).getText());
			if (OrderSearchSelectDropDownOption.get(i).getText().equals(orderSearchOption)) {
				Action.selectByIndex(drpdwnOrderSearchBy, i);
				break;
			}
		}
	}

	// Select OrderStatusFrom
	public void selectOrderStatusFrom(String orderStatusFrom) {

		drpdwnOrderStatusFrom.click();
		for (int i = 0; i < OrderSearchSelectDropDownOption.size(); i++) {
			System.out.println(OrderSearchSelectDropDownOption.get(i).getText());
			if (OrderSearchSelectDropDownOption.get(i).getText().equals(orderStatusFrom)) {
				Action.selectByIndex(drpdwnOrderStatusFrom, i);
				break;
			}
		}
	}

	// Select OrderStatusTo
	public void selectOrderStatusTo(String orderStatusTo) {

		drpdwnOrderStatusTo.click();
		for (int i = 0; i < OrderSearchSelectDropDownOption.size(); i++) {
			System.out.println(OrderSearchSelectDropDownOption.get(i).getText());
			if (OrderSearchSelectDropDownOption.get(i).getText().equals(orderStatusTo)) {
				Action.selectByIndex(drpdwnOrderStatusTo, i);
				break;
			}
		}
	}
}
