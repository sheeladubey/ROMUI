package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@JsonProperty("FulFillmentOrderID")
	String FulFillmentOrderID;
	
	@JsonProperty("EmailID")
	String EmailID;
	
	@JsonProperty("Customer_FirstName")
	String Customer_FirstName;
	
	@JsonProperty("Customer_LastName")
	String Customer_LastName;
	
	@JsonProperty("Start_Date")
	String Start_Date;
	
	@JsonProperty("End_Date")
	String End_Date;
	
	@JsonProperty("OrderStatusFrom")
	String OrderStatusFrom;
	
	@JsonProperty("OrderStatusTo")
	String OrderStatusTo;
	
	
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
	
	public String getStartDate() {	
		
		return Start_Date ;
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
	
	public static OrdersData get(String filename) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return mapper.readValue(new File(filename), OrdersData.class);
    }

}
