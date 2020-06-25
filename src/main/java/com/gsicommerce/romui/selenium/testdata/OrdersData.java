package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsicommerce.romui.selenium.utilities.Common;

public class OrdersData {

	@JsonProperty("SearchOrderBy")
	List<String> SearchOrderBy;

	@JsonProperty("SearchCriteria_OrderNumber")
	String SearchCriteria_OrderNumber;

	@JsonProperty("SearchCriteria_Email")
	String SearchCriteria_Email;

	@JsonProperty("SearchCriteria_CustomerName")
	String SearchCriteria_CustomerName;

	@JsonProperty("SearchCriteria_FulfillmentOrderNumner")
	String SearchCriteria_FulfillmentOrderNumner;

	@JsonProperty("SearchCriteria_OrderStatus")
	String SearchCriteria_OrderStatus;

	@JsonProperty("OrderID")
	String OrderID;

	@JsonProperty("OrderID1")
	String OrderID1;

	@JsonProperty("OrderStatusID")
	String OrderStatusID;

	@JsonProperty("FulFillmentOrderID")
	String FulFillmentOrderID;

	@JsonProperty("EmailID")
	String EmailID;

	@JsonProperty("Customer_FirstName")
	String Customer_FirstName;

	@JsonProperty("Customer_LastName")
	String Customer_LastName;

	@JsonProperty("ZipCode")
	String ZipCode;

	@JsonProperty("Start_Date")
	String Start_Date;

	@JsonProperty("End_Date")
	String End_Date;

	@JsonProperty("OrderStatusFrom")
	String OrderStatusFrom;

	@JsonProperty("OrderStatusTo")
	String OrderStatusTo;

	@JsonProperty("BillToCountry")
	String BillToCountry;

	@JsonProperty("BillToTitle")
	String BillToTitle;

	@JsonProperty("BillToFirstName")
	String BillToFirstName;

	@JsonProperty("BillToMiddleName")
	String BillToMiddleName;

	@JsonProperty("BillToLastName")
	String BillToLastName;

	@JsonProperty("BillToAddressLine1")
	String BillToAddressLine1;

	@JsonProperty("BillToAddressLine2")
	String BillToAddressLine2;

	@JsonProperty("BillToAddressLine3")
	String BillToAddressLine3;

	@JsonProperty("BillToAddressLine4")
	String BillToAddressLine4;

	@JsonProperty("BillToCity")
	String BillToCity;

	@JsonProperty("BillToState")
	String BillToState;

	@JsonProperty("BillToPostalCode")
	String BillToPostalCode;

	@JsonProperty("BillToEmail")
	String BillToEmail;

	@JsonProperty("BillToPhone")
	String BillToPhone;

	@JsonProperty("Source")
	List<String> Source;

	@JsonProperty("Currency")
	String Currency;

	@JsonProperty("Locale")
	String Locale;

	@JsonProperty("ItemID")
	List<String> ItemID;

	@JsonProperty("QTY")
	List<String> QTY;

	@JsonProperty("ShippingMethod")
	List<String> ShippingMethod;

	@JsonProperty("ReturnOrderID")
	String ReturnOrderID;

	@JsonProperty("ReturnQty")
	String ReturnQty;

	@JsonProperty("ReturnReasonCode")
	List<String> ReturnReasonCode;

	@JsonProperty("ReturnComment")
	String ReturnComment;

	public List<String> getSearchOrderBy() {
		return SearchOrderBy;
	}

	public String getSearchCriteria_OrderNumber() {
		return SearchCriteria_OrderNumber;
	}

	public String getSearchCriteria_Email() {
		return SearchCriteria_Email;
	}

	public String getSearchCriteria_CustomerName() {
		return SearchCriteria_CustomerName;
	}

	public String getSearchCriteria_FulfillmentOrderNumner() {
		return SearchCriteria_FulfillmentOrderNumner;
	}

	public String getSearchCriteria_OrderStatus() {
		return SearchCriteria_OrderStatus;
	}

	public String getOrderID() {
		return OrderID;
	}

	public String getOrderID1() {
		return OrderID1;
	}

	public String getOrderStatusID() {
		return OrderStatusID;
	}

	public String getFulFillmentOrderID() {
		return FulFillmentOrderID;
	}

	public String getEmailID() {
		return EmailID;
	}

	public String getCustomer_FirstName() {
		return Customer_FirstName;
	}

	public String getCustomer_LastName() {
		return Customer_LastName;
	}

	public String getZipCode() {
		return ZipCode;
	}

	public String getStartDate() {

		return Start_Date;
	}

	public String getEndDate() {
		return End_Date;
	}

	public String getOrderStatusFrom() {
		return OrderStatusFrom;
	}

	public String getOrderStatusTo() {
		return OrderStatusTo;
	}

	public String getBillToCountry() {
		return BillToCountry;
	}

	public String getBillToState() {
		return BillToState;
	}

	public String getBillToTitle() {
		return BillToTitle;
	}

	public String getBillToFirstName() {
		return BillToFirstName;
	}

	public String getBillToMiddleName() {
		return BillToMiddleName;
	}

	public String getBillToLastName() {
		return BillToLastName;
	}

	public String getBillToAddressLine1() {
		return BillToAddressLine1;
	}

	public String getBillToAddressLine2() {
		return BillToAddressLine2;
	}

	public String getBillToAddressLine3() {
		return BillToAddressLine3;
	}

	public String getBillToAddressLine4() {
		return BillToAddressLine4;
	}

	public String getBillToCity() {
		return BillToCity;
	}

	public String getBillToPostalCode() {
		return BillToPostalCode;
	}

	public String getBillToEmail() {
		return BillToEmail;
	}

	public String getBillToPhone() {
		return BillToPhone;
	}

	public List<String> getSource() {
		return Source;
	}

	public String getCurrency() {
		return Currency;
	}

	public String getLocale() {
		return Locale;
	}

	public List<String> getItemID() {
		return ItemID;
	}

	public List<String> getQTY() {
		return QTY;
	}

	public List<String> getShippingMethod() {
		return ShippingMethod;
	}

	public String getReturnQty() {
		return ReturnQty;
	}

	public List<String> getReturnReasonCode() {
		return ReturnReasonCode;
	}

	public String getReturnComment() {
		String returnComment = ReturnComment + Common.generateRandomID("Auto");
		return returnComment;
	}

	public String getReturnOrderID() {
		return ReturnOrderID;
	}

	public static OrdersData get(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), OrdersData.class);
	}

}