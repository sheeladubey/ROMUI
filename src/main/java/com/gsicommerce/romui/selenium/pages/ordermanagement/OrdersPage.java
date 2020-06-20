package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.awt.AWTException;
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
import org.testng.Reporter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.OrdersData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;
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
	private static int rowNoReturnWebOrder;

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

	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Returns')]")
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

	@FindBy(how = How.CSS, using = ".btn--charcoal-ghost[type='button']")
	private WebElement drpdwnEdit;

	// @FindBy(how = How.CSS, using = ".dropdown-menu-right")
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Edit billing address')]")
	private WebElement lkEditBillingAddress;

	@FindBy(how = How.CSS, using = "#address_country_code")
	private WebElement drpdwnCountry;

	@FindBy(how = How.CSS, using = "#address_region")
	private WebElement drpdwnState;

	@FindBy(how = How.CSS, using = "#address_title")
	private WebElement txtbxTitle;

	@FindBy(how = How.CSS, using = "#address_first_name")
	private WebElement txtbxFirstName;

	@FindBy(how = How.CSS, using = "#address_middle_name")
	private WebElement txtbxMiddleName;

	@FindBy(how = How.CSS, using = "#address_last_name")
	private WebElement txtbxLastName;

	@FindBy(how = How.CSS, using = "#address_line1")
	private WebElement txtbxaddressLine1;

	@FindBy(how = How.CSS, using = "#address_line2")
	private WebElement txtbxaddressLine2;

	@FindBy(how = How.CSS, using = "#address_line3")
	private WebElement txtbxaddressLine3;

	@FindBy(how = How.CSS, using = "#address_line4")
	private WebElement txtbxaddressLine4;

	@FindBy(how = How.CSS, using = "#address_city")
	private WebElement txtbxCity;

	@FindBy(how = How.CSS, using = "#address_postal_code")
	private WebElement txtbxPostalCode;

	@FindBy(how = How.CSS, using = "#address_email")
	private WebElement txtbxEmail;

	@FindBy(how = How.CSS, using = "#address_phone")
	private WebElement txtbxPhone;

	@FindBy(how = How.CSS, using = "[data-disable-with='Save Changes']")
	private WebElement btnSaveChanges;

	@FindBy(how = How.XPATH, using = "//a[contains(@class,'btn btn-default')]")
	private WebElement btnAddItem;

	@FindBy(how = How.CSS, using = ".order-add-item-action--absolute")
	private WebElement btnAddSecondItem;

	@FindBy(how = How.CSS, using = "#simple_search_query")
	private WebElement txtbxsearchitem;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Search')]")
	private WebElement btnSearchitem;

	@FindBy(how = How.CSS, using = "#orders_line_item_quantity")
	private WebElement txtbxQty;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add')]")
	private WebElement btnAdd;

	@FindBy(how = How.CSS, using = "#selected_address_id_destination1")
	private WebElement radiobtnShippingAddress;

	@FindBy(how = How.CSS, using = ".btn-new-address")
	private WebElement btnAddNewAddressShipTo;

	@FindBy(how = How.XPATH, using = "//button[contains(@name,'button')]")
	private WebElement btnContinueShippingAddress;

	@FindBy(how = How.CSS, using = "[name='commit'][type='submit']")
	private WebElement btnContinueNewAddress;

	@FindBy(how = How.CSS, using = "#orders_shipping_method_form_shipping_method_groups_0_selected_shipping_method")
	private WebElement drpdwnShippingMethod;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Submit Order')]")
	private WebElement btnSubmitOrderZCOrder;

	@FindBy(how = How.CSS, using = "[data-disable-with='Submit Order']")
	private WebElement btnSubmitOrder;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Return Order')]")
	private WebElement btnReturnOrder;

	@FindBy(how = How.CSS, using = "[name='eligibility[]'][type='checkbox']")
	private WebElement chkboxReturnEligibleItems;

	@FindBy(how = How.CSS, using = "[type='submit'][name='next']")
	private WebElement btnNextEligibleItems;

	@FindBy(how = How.CSS, using = "#return_quantity")
	private WebElement txtboxReturnqty;

	@FindBy(how = How.CSS, using = " #return_reason")
	private WebElement drpdwnReturnReasonCode;

	@FindBy(how = How.CSS, using = "#return_rep_comment")
	private WebElement txtboxReturnComment;

	@FindBy(how = How.XPATH, using = "//button[@name='next']")
	private WebElement btnNextItemToReturnscreen;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Back')]")
	private WebElement btnBackItemToReturnscreen;

	@FindBy(how = How.XPATH, using = "//button[contains(@name,'done')]")
	private WebElement btnDoneItemToReturnscreen;

	@FindBy(how = How.CSS, using = ".alert-info")
	private WebElement txtsuccessMessage;

	// to Verify search order
	public void searchOrderBy(int searchindex) throws JsonParseException, JsonMappingException, IOException, Exception {
		ordersdata = OrdersData.get(env.getFileLocation());
		searchOrderByOption = ordersdata.getSearchOrderBy().get(searchindex);
		webOrderNumber = ordersdata.getOrderID();
		Action.waitForElementToBeClickable(driver, btnSearchIcon, 20);
		// btnSearchIcon.click();
		Action.clickElementJavaScipt(btnSearchIcon);
		// select search order type
		Action.waitForElementToBeClickable(driver, drpdwnOrderSearchBy, 20);
		Action.selectByVisibleText(drpdwnOrderSearchBy, searchOrderByOption);
		if (searchOrderByOption.equals("Order Number")) {
			// Enter Web Order number
			Action.waitForElementToBeClickable(driver, txtOrderNumber, 10);
			Action.enter(txtOrderNumber, webOrderNumber);
			// click search btn
			btnSearchOrder.click();
			// Get selected row
			rowNoWebOrder = CommonElementsPage.getRowNum(webOrderNumber);
			System.out.println("Selected Order number is:" + Webtable.getTableCellText(rowNoWebOrder, 1));
			Assert.assertEquals(Webtable.getTableCellText(rowNoWebOrder, 1), webOrderNumber,
					RomuiEnumValues.ORDER_NOTFOUND.getMessage());
		}
		if (searchOrderByOption.equals("Fulfillment Order Number")) {
			fulfillmentOrderNum = ordersdata.getFulFillmentOrderID();
			// enter Fulfillment Orderid
			Action.waitForElementToBeClickable(driver, txtFulfillmentOrderNumber, 10);
			Action.enter(txtFulfillmentOrderNumber, fulfillmentOrderNum);
			// click search btn
			btnSearchOrder.click();
			System.out.println(
					"Selected row for fulfillment order search - " + CommonElementsPage.getRowNum(webOrderNumber));
			rowNo4 = CommonElementsPage.getRowNum(webOrderNumber);
			System.out.println(
					"Selected Row Text for fulfillment order search is:" + Webtable.getTableCellText(rowNo4, 1));
			Assert.assertEquals(Webtable.getTableCellText(rowNo4, 1), webOrderNumber,
					RomuiEnumValues.ORDER_NOTFOUND.getMessage());

		}
		if (searchOrderByOption.equals("Customer Name")) {
			String custFirstName = ordersdata.getCustomer_FirstName();
			String custLastName = ordersdata.getCustomer_LastName();
			customerName = custFirstName + " " + custLastName;
			// enter Customer Name
			Action.waitForElementToBeClickable(driver, txtCustomerFirstName, 10);
			Action.enter(txtCustomerFirstName, custFirstName);
			Action.enter(txtCustomerLastName, custLastName);
			// click search btn
			btnSearchOrder.click();
			rowNoWebOrder = CommonElementsPage.getRowNum(webOrderNumber);
			System.out.println(
					"Selected row for customer name search is- " + CommonElementsPage.getRowNum(webOrderNumber));
			System.out.println(
					"Selected Row Text for customer name search is:" + Webtable.getTableCellText(rowNoWebOrder, 2));
			Assert.assertEquals(Webtable.getTableCellText(rowNoWebOrder, 2), customerName,
					RomuiEnumValues.ORDER_NOTFOUND.getMessage());
		}
		if (searchOrderByOption.equals("Email")) {
			emailID = ordersdata.getEmailID();
			// enter Email
			Action.waitForElementToBeClickable(driver, txtorderSearchEmail, 10);
			Action.enter(txtorderSearchEmail, emailID);
			// click search button
			btnSearchOrder.click();
			System.out.println("Selected row for email id search is- " + CommonElementsPage.getRowNum(webOrderNumber));
			rowNoWebOrder = CommonElementsPage.getRowNum(webOrderNumber);
			System.out
					.println("Selected Row Text for email id search is:" + Webtable.getTableCellText(rowNoWebOrder, 3));
			Assert.assertEquals(Webtable.getTableCellText(rowNoWebOrder, 3), emailID,
					RomuiEnumValues.ORDER_NOTFOUND.getMessage());

		}
		if (searchOrderByOption.equals("Order Status")) {
			String webOrderNumberOrderStatus = ordersdata.getOrderStatusID();
			String OrderStatusFrom = ordersdata.getOrderStatusFrom();
			String OrderStatusTo = ordersdata.getOrderStatusTo();
			// select search order type
			Action.selectByVisibleText(drpdwnOrderSearchBy, searchOrderByOption);
			Action.selectByVisibleText(drpdwnOrderStatusFrom, OrderStatusFrom);
			Action.selectByVisibleText(drpdwnOrderStatusTo, OrderStatusTo);
			// click search btn
			btnSearchOrder.click();
			System.out.println("Selected row for order status search is- "
					+ CommonElementsPage.getRowNum(webOrderNumberOrderStatus));
			rowNoOrderStatus = CommonElementsPage.getRowNum(webOrderNumberOrderStatus);
			System.out.println(
					"Selected Row Text for order status search is:" + Webtable.getTableCellText(rowNoOrderStatus, 5));
			System.out.println("Order selected:" + Webtable.getRowText(rowNoOrderStatus));
			Assert.assertEquals(Webtable.getTableCellText(rowNoOrderStatus, 5), OrderStatusFrom,
					RomuiEnumValues.ORDER_NOTFOUND.getMessage());
		}

	}

	public void clickEditSearch(int searchindex)
			throws JsonParseException, JsonMappingException, IOException, Exception {
		ordersdata = OrdersData.get(env.getFileLocation());
		searchOrderByOption = ordersdata.getSearchOrderBy().get(searchindex);
		if (searchOrderByOption.equals("Order Number")) {
			searchOrderBy(0);
		}
		if (searchOrderByOption.equals("Fulfillment Order Number")) {
			searchOrderBy(1);
		}
		if (searchOrderByOption.equals("Customer Name")) {
			searchOrderBy(2);
		}
		if (searchOrderByOption.equals("Email")) {
			searchOrderBy(3);
		}
		if (searchOrderByOption.equals("Order Status")) {
			searchOrderBy(4);
		}
		Action.waitForElementToBeClickable(driver, btnSearchIcon, 10);
		btnSearchIcon.click();
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
			Action.scrollingToBottomofAPage();
			Reporter.log("Click View Order icon");
			CommonElementsPage.clickViewOrderIcon(rowNoWebOrder, 6, 1, 1, 1);
			System.out.println("Order numbere is:" + headerViewOrderNum.getText());
			Assert.assertEquals(headerViewOrderNum.getText(), webOrderNumber,
					"View Order screen has not been validated");
			Action.waitForElementToBeClickable(driver, btnExitOrder, 10);
			btnExitOrder.click();
		}
		if (viewOrderBy.equals("Fulfillment Order Number")) {
			try {
				Action.waitForElementToBeVisible(driver, btnSearchIcon, 20);
				Action.waitForElementToBeClickable(driver, btnSearchIcon, 20);
				Action.clickElementJavaScipt(btnSearchIcon);
			} finally {
				Action.waitForElementToBeClickable(driver, btnSearchIcon, 20);
				Action.clickElementJavaScipt(btnSearchIcon);
			}
			searchOrderBy(1);
			// Click View Order icon
			Action.scrollingToBottomofAPage();
			Reporter.log("Click View Order icon");
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
			try {
				Action.waitForElementToBeClickable(driver, btnSearchIcon, 20);
				Action.clickElementJavaScipt(btnSearchIcon);
			} finally {
				Action.waitForElementToBeClickable(driver, btnSearchIcon, 20);
				Action.clickElementJavaScipt(btnSearchIcon);
			}
			searchOrderBy(2);
			// Click View Order icon
			Action.scrollingToBottomofAPage();
			Reporter.log("Click View Order icon");
			CommonElementsPage.clickViewOrderIcon(rowNoWebOrder, 6, 0, 1, 1);
			Assert.assertTrue(lblCustomerName.get(1).getText().contains(customerName),
					"Order Search By Customer Name has not been verified");
			Action.waitForElementToBeClickable(driver, btnExitOrder, 10);
			btnExitOrder.click();
		}
		if (viewOrderBy.equals("Email")) {
			try {
				Action.waitForElementToBeClickable(driver, btnSearchIcon, 10);
				// btnSearchIcon.click();
				Action.clickElementJavaScipt(btnSearchIcon);
			} finally {
				Action.waitForElementToBeClickable(driver, btnSearchIcon, 20);
				Action.clickElementJavaScipt(btnSearchIcon);
			}
			searchOrderBy(3);
			Action.scrollingToBottomofAPage();
			Reporter.log("Click View Order icon");
			CommonElementsPage.clickViewOrderIcon(rowNoWebOrder, 6, 0, 1, 1);
			Assert.assertTrue(lblCustomerName.get(1).getText().contains(emailID),
					"Order Search By Email ID has not been verified");
			Action.waitForElementToBeClickable(driver, btnExitOrder, 10);
			btnExitOrder.click();

		}
		if (viewOrderBy.equals("Order Status")) {
			try {
				Action.waitForElementToBeClickable(driver, btnSearchIcon, 15);
				Action.clickElementJavaScipt(btnSearchIcon);
			} finally {
				Action.waitForElementToBeClickable(driver, btnSearchIcon, 15);
				Action.clickElementJavaScipt(btnSearchIcon);
			}
			searchOrderBy(4);
			// Click View Order icon
			Action.scrollingToBottomofAPage();
			Reporter.log("Click View Order icon");
			CommonElementsPage.clickViewOrderIcon(rowNoOrderStatus, 6, 1, 1, 1);
		}
	}

	public void addZeroCostOrder()
			throws InterruptedException, JsonParseException, JsonMappingException, IOException, AWTException {
		// click add ZCO button
		Action.clickElementJavaScipt(btnZCOrder);
		// select all fields and continue
		Action.switchWindow("Order Lookup - Radial Order Management");
		selectSourceAndContinue(0);
		// select edit billing address
		Action.waitForElementToBeClickable(driver, drpdwnEdit, 20);
		Action.clickElementJavaScipt(drpdwnEdit);
		Action.waitForElementToBeClickable(driver, lkEditBillingAddress, 10);
		Action.clickElementJavaScipt(lkEditBillingAddress);
		editAddress();
		Action.waitForElementToBeVisible(driver, btnAddItem, 10);
		Action.clickElementJavaScipt(btnAddItem);
		addItem(0,0);
		Action.waitForElementToBeVisible(driver, btnAddNewAddressShipTo, 10);
		Action.clickElementJavaScipt(btnAddNewAddressShipTo);
		editAddress();
		btnContinueNewAddress.click();
		selectShippingMethod(0);
		/*
		 * //Add second item Action.waitForElementToBeClickable(driver,
		 * btnAddSecondItem, 10); Action.clickElementJavaScipt(btnAddSecondItem);
		 * //btnAddSecondItem.click(); addItem(1,0);
		 */
		Action.waitForElementToBeClickable(driver, btnSubmitOrderZCOrder, 10);
		Action.clickElementJavaScipt(btnSubmitOrderZCOrder);
		Action.clickElementJavaScipt(btnSubmitOrder);
		Common.closePrintPopup();
		System.out.println("ZCO created order is:" + txtsuccessMessage.getText());

	}

	public void selectSourceAndContinue(int sourceindex) throws JsonParseException, JsonMappingException, IOException {
		ordersdata = OrdersData.get(env.getFileLocation());
		// select source, currency & locale and click continue button
		Action.clickElementJavaScipt(drpdwnSource);
		// drpdwnSource.click();
		Action.selectByVisibleText(drpdwnSource, ordersdata.getSource().get(sourceindex));
		drpdwnCurrency.click();
		Action.selectByVisibleText(drpdwnCurrency, ordersdata.getCurrency());
		drpdwnLocale.click();
		Action.selectByVisibleText(drpdwnLocale, ordersdata.getLocale());
		btnAddOrderContinue.click();
	}

	public void editAddress() throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		ordersdata = OrdersData.get(env.getFileLocation());
		// enter all fields data
		drpdwnCountry.click();
		Action.waitForElementToBeClickable(driver, drpdwnCountry, 20);
		Action.selectByVisibleText(drpdwnCountry, ordersdata.getBillToCountry());
		Action.enter(txtbxTitle, ordersdata.getBillToTitle());
		Action.enter(txtbxFirstName, ordersdata.getBillToFirstName());
		Action.enter(txtbxMiddleName, ordersdata.getBillToMiddleName());
		Action.enter(txtbxLastName, ordersdata.getBillToLastName());
		Action.enter(txtbxaddressLine1, ordersdata.getBillToAddressLine1());
		Action.enter(txtbxaddressLine2, ordersdata.getBillToAddressLine2());
		Action.enter(txtbxaddressLine3, ordersdata.getBillToAddressLine3());
		Action.enter(txtbxaddressLine4, ordersdata.getBillToAddressLine4());
		Action.enter(txtbxCity, ordersdata.getBillToCity());
		// Action.clickElementJavaScipt(drpdwnState);
		CommonElementsPage.selectDropDwnValues(drpdwnState, ordersdata.getBillToState());
		Action.selectByVisibleText(drpdwnState, ordersdata.getBillToState());
		Action.enter(txtbxPostalCode, ordersdata.getBillToPostalCode());
		WebElement windowTitle = driver.findElement(By.xpath("//div[contains(@class,'modal-title')]"));
		System.out.println("Current window  title is:" + windowTitle.getText());
		if (windowTitle.getText().contains("Billing Address")) {
			Action.enter(txtbxEmail, ordersdata.getBillToEmail());
			Action.enter(txtbxPhone, ordersdata.getBillToPhone());
			btnSaveChanges.click();
		} else {
			Action.enter(txtbxPhone, ordersdata.getBillToPhone());
			btnContinueNewAddress.click();
		}

	}

	public void addItem(int itemindex, int qtyindex) throws JsonParseException, JsonMappingException, IOException {
		ordersdata = OrdersData.get(env.getFileLocation());
		System.out.println("item is:" + ordersdata.getItemID().get(itemindex));
		Action.waitForElementToBeVisible(driver, txtbxsearchitem, 10);
		Action.waitForElementToBeClickable(driver, txtbxsearchitem,10);
		Action.enter(txtbxsearchitem, ordersdata.getItemID().get(itemindex));
		Action.waitForElementToBeVisible(driver, btnSearchitem, 10);
		btnSearchitem.click();
		Action.enter(txtbxQty, ordersdata.getQTY().get(qtyindex));
		btnAdd.click();

	}

	public void selectShippingMethod(int shipindex) throws JsonParseException, JsonMappingException, IOException {
		ordersdata = OrdersData.get(env.getFileLocation());
		Action.waitForElementToBeClickable(driver, drpdwnShippingMethod, 10);
		drpdwnShippingMethod.click();
		Action.selectByVisibleText(drpdwnShippingMethod, ordersdata.getShippingMethod().get(shipindex));
		Action.waitForElementToBeVisible(driver, btnSaveChanges, 05);
		btnSaveChanges.click();
	}

	public void searchOrderforReturn() throws Exception {
		ordersdata = OrdersData.get(env.getFileLocation());
		Action.waitForElementToBeClickable(driver, btnSearchIcon, 20);
		// btnSearchIcon.click();
		Action.clickElementJavaScipt(btnSearchIcon);
		// select search order type
		Action.waitForElementToBeClickable(driver, drpdwnOrderSearchBy, 20);
		Action.selectByVisibleText(drpdwnOrderSearchBy, ordersdata.getSearchOrderBy().get(0));
		// Enter Web Order number
		Action.waitForElementToBeClickable(driver, txtOrderNumber, 10);
		Action.enter(txtOrderNumber, ordersdata.getReturnOrderID());
		// click search btn
		btnSearchOrder.click();
		rowNoReturnWebOrder = CommonElementsPage.getRowNum(ordersdata.getReturnOrderID());
		System.out.println("Selected Order number is:" + Webtable.getTableCellText(rowNoReturnWebOrder, 1));
	}

	public void createReturnOrder() throws JsonParseException, JsonMappingException, IOException, Exception {
		ordersdata = OrdersData.get(env.getFileLocation());
		// searchOrderBy(0);
		searchOrderforReturn();
		Action.scrollingToBottomofAPage();
		Reporter.log("Click View Order icon");
		CommonElementsPage.clickViewOrderIcon(rowNoReturnWebOrder, 6, 1, 1, 1);
		// viewOrders(0);
		Action.waitForElementToBeClickable(driver, drpdwntoggleReturn, 10);
		drpdwntoggleReturn.click();
		Action.waitForElementToBeClickable(driver, lkReturns, 10);
		// lkReturns.click();
		Action.clickElementJavaScipt(lkReturns);
		btnReturnOrder.click();
		chkboxReturnEligibleItems.click();
		btnNextEligibleItems.click();
		Action.enter(txtboxReturnqty, ordersdata.getReturnQty());
		drpdwnReturnReasonCode.click();
		Action.selectByVisibleText(drpdwnReturnReasonCode, ordersdata.getReturnReasonCode().get(0));
		Action.enter(txtboxReturnComment, ordersdata.getReturnComment());
		btnNextItemToReturnscreen.click();
		btnDoneItemToReturnscreen.click();
		Common.closePrintPopup();
		btnExitOrder.click();
		searchOrderforReturn();
		Assert.assertEquals(Webtable.getTableCellText(rowNoReturnWebOrder, 5), "Partially Return Received",
				"Return Order didn't created successfully");

	}
}
