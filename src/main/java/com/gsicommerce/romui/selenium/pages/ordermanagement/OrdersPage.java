package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	private static int rowNo1;
	private static int rowNo2;
	private static int rowNo3;
	private static int rowNo4;
	private static int rowNo5;
	private static int rowNo6;
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
	private List<WebElement> OrderSearchSelectDropDownOption;

	@FindBy(how = How.CSS, using = "#order_search_form_first_name")
	private WebElement txtCustomerFirstName;

	@FindBy(how = How.CSS, using = "#order_search_form_last_name")
	private WebElement txtCustomerLastName;

	@FindBy(how = How.CSS, using = "#order_search_form_postal_code")
	private WebElement txtZipCode;

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

	@FindBy(how = How.CSS, using = ".header__primary-text")
	private WebElement headerViewOrderNum;

	@FindBy(how = How.CSS, using = ".ss-navigateup")
	private WebElement drpdwntoggleReturn;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Fulfillment Orders')]")
	private WebElement lkFulfillmentOrders;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Returns')]")
	private WebElement lkReturns;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Events')]")
	private WebElement lkEvents;

	@FindBy(how = How.CSS, using = ".back-link")
	private WebElement lkbackToOrders;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Exit Order')]")
	private WebElement btnExitOrder;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'order-summary-heading')][contains(text(),'Name')]")
	private WebElement lblCustomerName;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'order-summary-heading')][contains(text(),'Email')]")
	private WebElement lblCustomerEmail;

	@FindBy(how = How.CSS, using = "[type='button'][data-create-zero-cost-order='true']")
	private WebElement btnZCOrder;

	@FindBy(how = How.CSS, using = "#orders_new_cart_form_source")
	private WebElement drpdwnSource;

	@FindBy(how = How.CSS, using = "#orders_new_cart_form_currency")
	private WebElement drpdwnCurrency;

	@FindBy(how = How.CSS, using = "#orders_new_cart_form_locale")
	private WebElement drpdwnLocale;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue')]")
	private WebElement btnAddOrderContinue;

	@FindBy(how = How.CSS, using = ".btn--charcoal-ghost")
	private WebElement drpdwnEditBillingAddress;

	@FindBy(how = How.CSS, using = ".dropdown-menu-right")
	private WebElement lkEditBillingAddress;
	
	@FindBy(how = How.CSS, using = "#address_country_code")
	private WebElement drpdwnBillToCountry;
	
	@FindBy(how = How.CSS, using = "#address_region")
	private WebElement drpdwnBillToState;
	
	@FindBy(how = How.CSS, using = "#address_title")
	private WebElement txtbxBillToTitle;
	
	@FindBy(how = How.CSS, using = "#address_first_name")
	private WebElement txtbxBillToFirstName;
	
	@FindBy(how = How.CSS, using = "#address_middle_name")
	private WebElement txtbxBillToMiddleName;
	
	@FindBy(how = How.CSS, using = "#address_last_name")
	private WebElement txtbxBillToLastName;
	
	@FindBy(how = How.CSS, using = "#address_line1")
	private WebElement txtbxBillToaddressLine1;
	@FindBy(how = How.CSS, using = "#address_line2")
	private WebElement txtbxBillToaddressLine2;
	@FindBy(how = How.CSS, using = "#address_line3")
	private WebElement txtbxBillToaddressLine3;
	@FindBy(how = How.CSS, using = "#address_line4")
	private WebElement txtbxBillToaddressLine4;
	@FindBy(how = How.CSS, using = "#address_city")
	private WebElement txtbxBillToCity;
	@FindBy(how = How.CSS, using = "#address_postal_code")
	private WebElement txtbxBillToPostalCode;
	@FindBy(how = How.CSS, using = "#address_email")
	private WebElement txtbxBillToEmail;
	@FindBy(how = How.CSS, using = "#address_phone")
	private WebElement txtbxBillToPhone;
	@FindBy(how = How.CSS, using = "[data-disable-with='Save Changes']")
	private WebElement btnBillToSaveChanges;
	// to Verify search order by Order number
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
		if (Webtable.GetNumOfRows() != 0) {
			System.out.println("Selected row- " + CommonElementsPage.getRowNum(webOrderNumber));
			rowNo = CommonElementsPage.getRowNum(webOrderNumber);
			System.out.println("Selected Row Text is:" + Webtable.getTableCellText(rowNo, 1));
			if (Webtable.getTableCellText(rowNo, 1).contains(webOrderNumber)) {
				System.out.println("Order Search by Web order number successfull");

			} else if (Webtable.GetNumOfRows() == 0) {
				System.out.println("Order Search by Web order number doesn't show any order");
				Assert.assertEquals(RomuiEnumValues.ORDER_NOTFOUND.getMessage(), webOrderNumber);
			}

			Assert.assertEquals(Webtable.getTableCellText(rowNo, 1), webOrderNumber,
					RomuiEnumValues.ORDER_NOTFOUND.getMessage());
		}
		// Click View Order icon
		CommonElementsPage.clickViewOrderIcon(rowNo, 6, 1, 1, 1);
		Action.waitForPageLoaded();
		System.out.println("Order numbere is:" + headerViewOrderNum.getAttribute("Order Number"));
		if (headerViewOrderNum.getText().contains(webOrderNumber)) {
			System.out.println("View Order screen validated");
		} else {
			System.out.println("View Order screen  has not been validated");
		}
		Assert.assertEquals(headerViewOrderNum.getText(), webOrderNumber, "View Order screen has not been validated");
		Action.waitForElementToBeClickable(driver, btnExitOrder, 10);
		btnExitOrder.click();

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
		rowNo4 = CommonElementsPage.getRowNum(webOrderNumber);
		System.out.println("Selected Row Text is:" + Webtable.getTableCellText(rowNo4, 1));

		if (Webtable.getTableCellText(rowNo4, 1).contains(webOrderNumber)) {

			System.out.println("Order Search by Fulfillment order number successfull");
		} else {
			System.out.println("Order Search by Fulfillment order number doesn't show any order");
		}

		Assert.assertEquals(Webtable.getTableCellText(rowNo4, 1), webOrderNumber,
				RomuiEnumValues.ORDER_NOTFOUND.getMessage());
		// Click View Order icon
		CommonElementsPage.clickViewOrderIcon(rowNo4, 6, 1, 1, 1);
		Action.waitForElementToBeClickable(driver, drpdwntoggleReturn, 10);
		drpdwntoggleReturn.click();
		Action.waitForElementToBeClickable(driver, lkFulfillmentOrders, 10);
		lkFulfillmentOrders.click();
		System.out.println("Selected row- " + CommonElementsPage.getRowNumFulfillmentOrders(fulfillmentOrderNum));
		rowNo5 = CommonElementsPage.getRowNumFulfillmentOrders(fulfillmentOrderNum);
		if (Webtable.getTableCellText(rowNo5, 1).contains(fulfillmentOrderNum)) {

			System.out.println("Order Search by Fulfillment order number successfull");
		} else {
			System.out.println("Order Search by Fulfillment order number doesn't show any order");
		}

		Assert.assertEquals(Webtable.getTableCellText(rowNo5, 1), fulfillmentOrderNum,
				RomuiEnumValues.ORDER_NOTFOUND.getMessage());

		lkbackToOrders.click();
		Action.waitForElementToBeClickable(driver, btnExitOrder, 10);
		btnExitOrder.click();

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
		rowNo1 = CommonElementsPage.getRowNum(webOrderNumber);
		System.out.println("Selected Row Text is:" + Webtable.getTableCellText(rowNo1, 2));

		if (Webtable.getRowText(rowNo1).contains(webOrderNumber)
				&& Webtable.getTableCellText(rowNo1, 2).contains(customerName)) {
			System.out.println("Order Search by Customer name successfull");
		} else {
			System.out.println("Order Search by Customer name doesn't show any order");
		}
		Assert.assertEquals(Webtable.getTableCellText(rowNo1, 2), customerName,
				RomuiEnumValues.ORDER_NOTFOUND.getMessage());

		// Click View Order icon
		CommonElementsPage.clickViewOrderIcon(rowNo1, 6, 0, 1, 1);
		if (lblCustomerName.getText().contains(customerName)) {
			System.out.println("Order Search By Customer Name has been verified");
		} else {
			System.out.println("Order Search By Customer Name has not been verified");
		}
		Assert.assertEquals(lblCustomerName.getText().contains(customerName), customerName,
				"Order Search By Customer Name has not been verified");
		Action.waitForElementToBeClickable(driver, btnExitOrder, 10);
		btnExitOrder.click();
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
		rowNo2 = CommonElementsPage.getRowNum(webOrderNumber);
		System.out.println("Selected Row Text is:" + Webtable.getTableCellText(rowNo2, 3));
		if (Webtable.getRowText(rowNo2).contains(webOrderNumber)
				&& Webtable.getTableCellText(rowNo2, 3).contains(emailID)) {
			System.out.println("Order Search by Email id  successfull");
		} else {
			System.out.println("Order Search by Email id doesn't show any order");
		}
		Assert.assertEquals(Webtable.getTableCellText(rowNo2, 3), emailID, RomuiEnumValues.ORDER_NOTFOUND.getMessage());

		// Click View Order icon
		CommonElementsPage.clickViewOrderIcon(rowNo2, 6, 0, 1, 1);
		WebElement lblCustomerEmail = driver.findElement(By.xpath("//span[contains(text(),'" + emailID + "')]"));
		if (lblCustomerEmail.getText().contains(emailID)) {
			System.out.println("Order Search By Email ID verified");
		} else {
			System.out.println("Order Search By Email ID has not been verified");
		}
		Assert.assertEquals(lblCustomerEmail.getText(), emailID, "Order Search By Email ID has not been verified");
		Action.waitForElementToBeClickable(driver, btnExitOrder, 10);
		btnExitOrder.click();
	}

	// Search Order By Order Status
	public void searchOrderByOrderStatus(String StatusFrom, String StatusTo)
			throws JsonParseException, JsonMappingException, IOException, Exception {
		ordersdata = OrdersData.get(env.getFileLocation());
		String webOrderNumber1 = ordersdata.getOrderStatusID();
		// select search order type
		Action.selectByVisibleText(drpdwnOrderSearchBy, ordersdata.getSearchCriteria_OrderStatus());
		String OrderStatusFrom = ordersdata.getOrderStatusFrom();
		String OrderStatusTo = ordersdata.getOrderStatusTo();
		Action.selectByVisibleText(drpdwnOrderStatusFrom, OrderStatusFrom);
		Action.selectByVisibleText(drpdwnOrderStatusTo, OrderStatusTo);
		// click search btn
		btnSearchOrder.click();
		System.out.println("Selected row- " + CommonElementsPage.getRowNum(webOrderNumber1));
		rowNo3 = CommonElementsPage.getRowNum(webOrderNumber1);
		System.out.println("Selected Row Text is:" + Webtable.getTableCellText(rowNo3, 5));
		System.out.println("Order selected:" + Webtable.getRowText(rowNo3));
		if (Webtable.getRowText(rowNo3).contains(webOrderNumber1)
				&& Webtable.getTableCellText(rowNo3, 5).contains(" ")) {
			System.out.println("Order Search by Order Status successfull");
		} else {
			System.out.println("Order Search by Status doesn't show any order");
		}
		Assert.assertEquals(Webtable.getTableCellText(rowNo3, 5), "", RomuiEnumValues.ORDER_NOTFOUND.getMessage());

		// Click View Order icon
		CommonElementsPage.clickViewOrderIcon(rowNo3, 6, 1, 1, 1);

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

	/*
	 * Search order by Customer Name
	 * 
	 */
	public void searchOrderByCustomerNameZipcode(String Firstname, String Lastname, String zipcode, String date)
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
		String zipCode = ordersdata.getZipCode();
		String startdate = ordersdata.getStartDate();
		String enddate = ordersdata.getEndDate();
		Action.enter(txtZipCode, zipCode);
		txtorderSearchStartDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		;
		Action.enter(txtorderSearchStartDate, startdate);
		txtorderSearchEndDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		;
		Action.enter(txtorderSearchEndDate, enddate);
		// click search btn
		btnSearchOrder.click();
		System.out.println("Selected row- " + CommonElementsPage.getRowNum(webOrderNumber));
		rowNo6 = CommonElementsPage.getRowNum(webOrderNumber);
		System.out.println("Selected Row Text is:" + Webtable.getTableCellText(rowNo6, 2));

		if (Webtable.getRowText(rowNo6).contains(webOrderNumber)
				&& Webtable.getTableCellText(rowNo6, 2).contains(customerName)) {
			System.out.println("Order Search by Customer name successfull");
		} else {
			System.out.println("Order Search by Customer name doesn't show any order");
		}
		Assert.assertEquals(Webtable.getTableCellText(rowNo6, 2), customerName,
				RomuiEnumValues.ORDER_NOTFOUND.getMessage());

		// Click View Order icon
		CommonElementsPage.clickViewOrderIcon(rowNo6, 6, 0, 1, 1);
		if (lblCustomerName.getText().contains(customerName)) {
			System.out.println("Order Search By Customer Name has been verified");
		} else {
			System.out.println("Order Search By Customer Name has not been verified");
		}
		Assert.assertEquals(lblCustomerName.getText().contains(customerName), customerName,
				"Order Search By Customer Name has not been verified");
		Action.waitForElementToBeClickable(driver, btnExitOrder, 10);
		btnExitOrder.click();
	}

	public void orderSearchFormValidation()
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		btnSearchOrder.click();
		Assert.assertEquals(CommonElementsPage.formErrorValidation(), RomuiEnumValues.USER_VALIDATION.getMessage(),
				"Order Search form Error Validation message has not been found");
		selectOrderSearchDropdown("Email");
		Assert.assertEquals(CommonElementsPage.formErrorValidation(), RomuiEnumValues.USER_VALIDATION.getMessage(),
				"Order Search form Error Validation message has not been found");
		selectOrderSearchDropdown("FulFillment Order");
		Assert.assertEquals(CommonElementsPage.formErrorValidation(), RomuiEnumValues.USER_VALIDATION.getMessage(),
				"Order Search form Error Validation message has not been found");
		selectOrderSearchDropdown("Customer Name");
		Assert.assertEquals(CommonElementsPage.formErrorValidation(), RomuiEnumValues.USER_VALIDATION.getMessage(),
				"Order Search form Error Validation message has not been found");
	}

	public void addZeroCostOrder() {
		// click add ZCO button
		btnZCOrder.click();
		CommonElementsPage.switchWindow("Order Lookup - Radial Order Management");
		// select all fields and continue
		selectSourceAndContinue("source", "currency", "locale");

	}

	// Select Source options
	public void selectSource(String source) {
		drpdwnSource.click();
		for (int i = 0; i < OrderSearchSelectDropDownOption.size(); i++) {
			System.out.println(OrderSearchSelectDropDownOption.get(i).getText());
			if (OrderSearchSelectDropDownOption.get(i).getText().equals(source)) {
				Action.selectByIndex(drpdwnSource, i);
				break;
			}
		}
	}

	// Select Currency options
	public void selectCurrency(String currency) {
		drpdwnCurrency.click();
		for (int i = 0; i < OrderSearchSelectDropDownOption.size(); i++) {
			System.out.println(OrderSearchSelectDropDownOption.get(i).getText());
			if (OrderSearchSelectDropDownOption.get(i).getText().equals(currency)) {
				Action.selectByIndex(drpdwnCurrency, i);
				break;
			}
		}
	}

	// Select Locale options
	public void selectLocale(String locale) {
		drpdwnLocale.click();
		for (int i = 0; i < OrderSearchSelectDropDownOption.size(); i++) {
			System.out.println(OrderSearchSelectDropDownOption.get(i).getText());
			if (OrderSearchSelectDropDownOption.get(i).getText().equals(locale)) {
				Action.selectByIndex(drpdwnLocale, i);
				break;
			}
		}
	}
	
	public void selectBillToCountry(String country) {
		drpdwnBillToCountry.click();
		for (int i = 0; i < OrderSearchSelectDropDownOption.size(); i++) {
			System.out.println(OrderSearchSelectDropDownOption.get(i).getText());
			if (OrderSearchSelectDropDownOption.get(i).getText().equals(country)) {
				Action.selectByIndex(drpdwnBillToCountry, i);
				break;
			}
		}
		
	}

	public void selectBillToState(String state) {
		drpdwnBillToState.click();
		for (int i = 0; i < OrderSearchSelectDropDownOption.size(); i++) {
			System.out.println(OrderSearchSelectDropDownOption.get(i).getText());
			if (OrderSearchSelectDropDownOption.get(i).getText().equals(state)) {
				Action.selectByIndex(drpdwnBillToState, i);
				break;
			}
		}
		
	}
	
	public void selectSourceAndContinue(String source, String currency, String locale) {
		// select source, currency & locale and click continue button
		selectSource(source);
		selectCurrency(currency);
		selectLocale(locale);
		btnAddOrderContinue.click();
	}

	public void editBillingAddress(String title, String firstName, String middleName, String lastName, String email,
			String addressLine1, String addressLine2, String addressLine3, String addressLine4, String city,
			String postalCode, String state, String country, String phone) throws InterruptedException {

		// select edit billing address
		drpdwnEditBillingAddress.click();
		lkEditBillingAddress.click();
		 //enter all fields data
		  selectBillToCountry(country);
		  Action.enter(txtbxBillToTitle, ordersdata.getBillToTitle());
		  Action.enter(txtbxBillToFirstName, ordersdata.getBillToFirstName());
		  Action.enter(txtbxBillToMiddleName, ordersdata.getBillToMiddleName());
		  Action.enter(txtbxBillToLastName, ordersdata.getBillToLastName());
		  Action.enter(txtbxBillToaddressLine1, ordersdata.getBillToAddressLine1());
		  Action.enter(txtbxBillToaddressLine2, ordersdata.getBillToAddressLine2());
		  Action.enter(txtbxBillToaddressLine3, ordersdata.getBillToAddressLine3());
		  Action.enter(txtbxBillToaddressLine4, ordersdata.getBillToAddressLine4());
		  Action.enter(txtbxBillToCity, ordersdata.getBillToCity());
		  selectBillToState(ordersdata.getBillToState());
		 // Action.selectByVisibleText(drpdwnBillToState, ordersdata.getBillToState());
		  Action.enter(txtbxBillToPostalCode, ordersdata.getBillToPostalCode());
		  Action.enter(txtbxBillToEmail, ordersdata.getBillToEmail());
		  Action.enter(txtbxBillToPhone, ordersdata.getBillToPhone());
		  btnBillToSaveChanges.click();
	}

}
