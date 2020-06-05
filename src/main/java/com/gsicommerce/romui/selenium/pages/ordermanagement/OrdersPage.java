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
	private static String searchOrderByOption;
	private static int rowNoWebOrder;
	private static int rowNoOrderStatus;
	private static int rowNo4;
	private static int rowNoFulfillmentOrder;
	private static String emailID;
	private static String fulfillmentOrderNum;
	private static String customerName;

	public OrdersPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);
	}

	@FindBy(how = How.CSS, using = ".radial-filter-menu-toggle-btn")
	private WebElement btnSearchIcon;

	@FindBy(how = How.CSS, using = "#order_search_form_search_type")
	private WebElement drpdwnOrderSearchBy;

	@FindBy(how = How.CSS, using = "#order_search_form_display_id")
	private WebElement txtOrderNumber;

	@FindBy(how = How.CSS, using = "#order_search_form_fulfillment_order_id")
	@CacheLookup
	private WebElement txtFulfillmentOrderNumber;

	@FindBy(how = How.CSS, using = "[data-filter-submit-button='']")
	private WebElement btnSearchOrder;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Search')]")
	private List<WebElement> btnSearchOrderUAT;

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

	@FindBy(how = How.CSS, using = ".col-sm-3.order-mobile-spacing")
	private List<WebElement> lblCustomerName;

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

	// to Verify search order
	public void searchOrderBy(int searchindex) throws JsonParseException, JsonMappingException, IOException, Exception {
		ordersdata = OrdersData.get(env.getFileLocation());
		searchOrderByOption = ordersdata.getSearchOrderBy().get(searchindex);
		webOrderNumber = ordersdata.getOrderID();
		btnSearchIcon.click();
		if (searchOrderByOption.equals("Order Number")) {
			// select search order type
			Action.selectByVisibleText(drpdwnOrderSearchBy, searchOrderByOption);
			// Enter Web Order number
			Action.waitForElementToBeClickable(driver, txtOrderNumber, 10);
			Action.enter(txtOrderNumber, webOrderNumber);
			// click search btn
			btnSearchOrder.click();
			rowNoWebOrder = CommonElementsPage.getRowNum(webOrderNumber);
			System.out.println("Selected Order number is:" + Webtable.getTableCellText(rowNoWebOrder, 1));
			Assert.assertEquals(Webtable.getTableCellText(rowNoWebOrder, 1), webOrderNumber,
					RomuiEnumValues.ORDER_NOTFOUND.getMessage());
		}
		if (searchOrderByOption.equals("Fulfillment Order Number")) {
			fulfillmentOrderNum = ordersdata.getFulFillmentOrderID();
			// select search order type
			Action.selectByVisibleText(drpdwnOrderSearchBy, searchOrderByOption);
			// enter Fulfillment Orderid
			Action.waitForElementToBeClickable(driver, txtFulfillmentOrderNumber, 10);
			Action.enter(txtFulfillmentOrderNumber, fulfillmentOrderNum);
			// click search btn
			btnSearchOrder.click();
			System.out.println("Selected row for fulfillment order search - " + CommonElementsPage.getRowNum(webOrderNumber));
			rowNo4 = CommonElementsPage.getRowNum(webOrderNumber);
			System.out.println("Selected Row Text for fulfillment order search is:" + Webtable.getTableCellText(rowNo4, 1));
			Assert.assertEquals(Webtable.getTableCellText(rowNo4, 1), webOrderNumber,
					RomuiEnumValues.ORDER_NOTFOUND.getMessage());

		}
		if (searchOrderByOption.equals("Customer Name")) {
			String custFirstName = ordersdata.getCustomer_FirstName();
			String custLastName = ordersdata.getCustomer_LastName();
			customerName = custFirstName + " " + custLastName;
			// select search order type
			Action.selectByVisibleText(drpdwnOrderSearchBy, searchOrderByOption);
			// enter Customer Name
			Action.waitForElementToBeClickable(driver, txtCustomerFirstName, 10);
			Action.enter(txtCustomerFirstName, custFirstName);
			Action.enter(txtCustomerLastName, custLastName);
			// click search btn
			btnSearchOrder.click();
			rowNoWebOrder = CommonElementsPage.getRowNum(webOrderNumber);
			System.out.println("Selected row for customer name search is- " + CommonElementsPage.getRowNum(webOrderNumber));
			System.out.println("Selected Row Text for customer name search is:" + Webtable.getTableCellText(rowNoWebOrder, 2));
			Assert.assertEquals(Webtable.getTableCellText(rowNoWebOrder, 2), customerName,
					RomuiEnumValues.ORDER_NOTFOUND.getMessage());
		}
		if (searchOrderByOption.equals("Email")) {
			emailID = ordersdata.getEmailID();
			// select search order type
			Action.selectByVisibleText(drpdwnOrderSearchBy, searchOrderByOption);
			// enter Email
			Action.waitForElementToBeClickable(driver, txtorderSearchEmail, 10);
			Action.enter(txtorderSearchEmail, emailID);
			// click search button
			btnSearchOrder.click();
			System.out.println("Selected row for email id search is- " + CommonElementsPage.getRowNum(webOrderNumber));
			rowNoWebOrder = CommonElementsPage.getRowNum(webOrderNumber);
			System.out.println("Selected Row Text for email id search is:" + Webtable.getTableCellText(rowNoWebOrder, 3));
			Assert.assertEquals(Webtable.getTableCellText(rowNoWebOrder, 3),emailID,
					RomuiEnumValues.ORDER_NOTFOUND.getMessage());

		}
		if (searchOrderByOption.equals("Order Status")) {
			String webOrderNumber1 = ordersdata.getOrderStatusID();
			String OrderStatusFrom = ordersdata.getOrderStatusFrom();
			String OrderStatusTo = ordersdata.getOrderStatusTo();
			// select search order type
			Action.selectByVisibleText(drpdwnOrderSearchBy, searchOrderByOption);
			Action.selectByVisibleText(drpdwnOrderStatusFrom, OrderStatusFrom);
			Action.selectByVisibleText(drpdwnOrderStatusTo, OrderStatusTo);
			// click search btn
			btnSearchOrder.click();
			System.out.println("Selected row for order status search is- " + CommonElementsPage.getRowNum(webOrderNumber1));
			rowNoOrderStatus = CommonElementsPage.getRowNum(webOrderNumber1);
			System.out.println("Selected Row Text for order status search is:" + Webtable.getTableCellText(rowNoOrderStatus,5));
			System.out.println("Order selected:" + Webtable.getRowText(rowNoOrderStatus));
			Assert.assertEquals(Webtable.getTableCellText(rowNoOrderStatus, 5), "",
					RomuiEnumValues.ORDER_NOTFOUND.getMessage());
		}

	}

	public void clickEditSearch() throws JsonParseException, JsonMappingException, IOException, Exception {

		searchOrderBy(0);
		Action.waitForElementToBeClickable(driver, btnSearchIcon, 10);
		btnSearchIcon.click();
		searchOrderBy(3);
	}

	public void orderSearchFormValidation()
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		btnSearchIcon.click();
		Action.waitForElementToBeClickable(driver, btnSearchOrder, 10);
		btnSearchOrder.click();
		Assert.assertEquals(CommonElementsPage.formErrorValidation(), RomuiEnumValues.USER_VALIDATION.getMessage(),
				"Order Search form Error Validation message has not been found");
	}

	public void viewOrders(int index) throws JsonParseException, JsonMappingException, IOException, Exception {
		ordersdata = OrdersData.get(env.getFileLocation());
		String viewOrderBy = ordersdata.getSearchOrderBy().get(index);

		if (viewOrderBy.equals("Order Number")) {
			searchOrderBy(0);
			// Click View Order icon
			CommonElementsPage.clickViewOrderIcon(rowNoWebOrder, 6, 1, 1, 1);
			System.out.println("Order numbere is:" + headerViewOrderNum.getText());
			Assert.assertEquals(headerViewOrderNum.getText(), webOrderNumber,"View Order screen has not been validated");
			Action.waitForElementToBeClickable(driver, btnExitOrder, 10);
			btnExitOrder.click();
		}
		if (viewOrderBy.equals("Fulfillment Order Number")) {
			Action.waitForElementToBeVisible(driver, btnSearchIcon, 20);
			Action.waitForElementToBeClickable(driver, btnSearchIcon, 20);
			Action.clickElementJavaScipt(btnSearchIcon);
			searchOrderBy(1);
			// Click View Order icon
			CommonElementsPage.clickViewOrderIcon(rowNo4, 6, 1, 1, 1);
			Action.waitForElementToBeClickable(driver, drpdwntoggleReturn, 10);
			drpdwntoggleReturn.click();
			Action.waitForElementToBeClickable(driver, lkFulfillmentOrders, 10);
			lkFulfillmentOrders.click();
			rowNoFulfillmentOrder = CommonElementsPage.getRowNumFulfillmentOrders(fulfillmentOrderNum);
			System.out.println("Fulfillment order number is " + Webtable.getTableCellText(rowNoFulfillmentOrder, 1));
			Assert.assertEquals(Webtable.getTableCellText(rowNoFulfillmentOrder, 1), fulfillmentOrderNum,
					RomuiEnumValues.ORDER_NOTFOUND.getMessage());
			Action.clickElementJavaScipt(lkbackToOrders);
			Action.waitForElementToBeClickable(driver, btnExitOrder, 10);
			btnExitOrder.click();
		}
		if (viewOrderBy.equals("Customer Name")) {
			Action.clickElementJavaScipt(btnSearchIcon);
			searchOrderBy(2);
			// Click View Order icon
			// CommonElementsPage.clickViewOrderIcon(rowNo1, 6, 0, 1, 1);
			CommonElementsPage.clickViewOrderIcon(rowNoWebOrder, 6, 0, 1, 1);
			Assert.assertEquals(lblCustomerName.get(1).getText().substring(5, 18), customerName,
					"Order Search By Customer Name has not been verified");
			Action.waitForElementToBeClickable(driver, btnExitOrder, 10);
			btnExitOrder.click();
		}
		if (viewOrderBy.equals("Email")) {
			Action.waitForElementToBeClickable(driver, btnSearchIcon, 10);
			btnSearchIcon.click();
			searchOrderBy(3);
			CommonElementsPage.clickViewOrderIcon(rowNoWebOrder, 6, 0, 1, 1);
			Assert.assertEquals(lblCustomerName.get(1).getText().substring(24,53).trim(),emailID,
					"Order Search By Email ID has not been verified");
			Action.waitForElementToBeClickable(driver, btnExitOrder, 10);
			btnExitOrder.click();

		}
		if (viewOrderBy.equals("Order Status")) {
			btnSearchIcon.click();
			searchOrderBy(4);
			// Click View Order icon
			CommonElementsPage.clickViewOrderIcon(rowNoOrderStatus, 6, 1, 1, 1);
		}
	}

	public void addZeroCostOrder() throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		// click add ZCO button
			Action.clickElementJavaScipt(btnZCOrder);
		//btnZCOrder.click();
		CommonElementsPage.switchWindow("Order Lookup - Radial Order Management");
		// select all fields and continue
		selectSourceAndContinue(0);
		editBillingAddress();

	}

	public void selectSourceAndContinue(int sourceindex) throws JsonParseException, JsonMappingException, IOException {
		ordersdata = OrdersData.get(env.getFileLocation());
		// select source, currency & locale and click continue button
		// selectSource(source);
		//CommonElementsPage.selectDropDwnValues(drpdwnSource, ordersdata.getSource().get(sourceindex));
		drpdwnSource.click();
		Action.selectByVisibleText(drpdwnSource, ordersdata.getSource().get(sourceindex));
		// selectCurrency(currency);
		//CommonElementsPage.selectDropDwnValues(drpdwnCurrency, ordersdata.getCurrency());
		drpdwnCurrency.click();
		Action.selectByVisibleText(drpdwnCurrency, ordersdata.getCurrency());
		// selectLocale(locale);
		//CommonElementsPage.selectDropDwnValues(drpdwnLocale, ordersdata.getLocale());
		drpdwnLocale.click();
		Action.selectByVisibleText(drpdwnLocale, ordersdata.getLocale());
		btnAddOrderContinue.click();
	}

	public void editBillingAddress() throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		ordersdata = OrdersData.get(env.getFileLocation());
		// select edit billing address
		Action.waitForElementToBeClickable(driver, drpdwnEditBillingAddress, 20);
		Action.clickElementJavaScipt(drpdwnEditBillingAddress);
		//drpdwnEditBillingAddress.click();
		Action.waitForElementToBeClickable(driver, lkEditBillingAddress, 10);
		
		Action.scrollingToElementofAPage(lkEditBillingAddress);
		Action.clickElementJavaScipt(lkEditBillingAddress);
		//lkEditBillingAddress.click();
		// enter all fields data
		// selectBillToCountry(country);
	//	CommonElementsPage.selectDropDwnValues(drpdwnBillToCountry, ordersdata.getBillToCountry());
		Action.waitForElementToBeClickable(driver, drpdwnBillToCountry, 20);
		Action.selectByVisibleText(drpdwnBillToCountry, ordersdata.getBillToCountry());
		Action.enter(txtbxBillToTitle, ordersdata.getBillToTitle());
		Action.enter(txtbxBillToFirstName, ordersdata.getBillToFirstName());
		Action.enter(txtbxBillToMiddleName, ordersdata.getBillToMiddleName());
		Action.enter(txtbxBillToLastName, ordersdata.getBillToLastName());
		Action.enter(txtbxBillToaddressLine1, ordersdata.getBillToAddressLine1());
		Action.enter(txtbxBillToaddressLine2, ordersdata.getBillToAddressLine2());
		Action.enter(txtbxBillToaddressLine3, ordersdata.getBillToAddressLine3());
		Action.enter(txtbxBillToaddressLine4, ordersdata.getBillToAddressLine4());
		Action.enter(txtbxBillToCity, ordersdata.getBillToCity());
		// selectBillToState(ordersdata.getBillToState());
		CommonElementsPage.selectDropDwnValues(drpdwnBillToCountry, ordersdata.getBillToState());
		// Action.selectByVisibleText(drpdwnBillToState, ordersdata.getBillToState());
		Action.enter(txtbxBillToPostalCode, ordersdata.getBillToPostalCode());
		Action.enter(txtbxBillToEmail, ordersdata.getBillToEmail());
		Action.enter(txtbxBillToPhone, ordersdata.getBillToPhone());
		btnBillToSaveChanges.click();
	}

}
