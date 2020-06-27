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

public class InventoryAvailabilityData {
	@JsonProperty("ATP Rule Name")
	String ATP_Rule_Name;

	@JsonProperty("ATP Rule Description")
	String ATP_Rule_Description;

	@JsonProperty("Overdue Supply")
	String Overdue_Supply;

	@JsonProperty("Overdue Demand")
	String Overdue_Demand;

	@JsonProperty("Forward Days to Consider Supply")
	String Forward_Days;

	@JsonProperty("Backward Days to Consider Supply")
	String Backward_Days;

	@JsonProperty("Receipt Processing Time")
	String Receipt_Processing_Time;
	
	@JsonProperty("Advance Notification Time")
	String Advance_Notification;
	
	@JsonProperty("Choose a Type")
	List<String> Choose_a_Type;
	
	@JsonProperty("Item Id")
	String ItemId;
	
	@JsonProperty("Node Id")
	String NodeId;
	
	@JsonProperty("Fulfillment Type Id")
	List<String> Fulfillment_Type_Id;
	
	@JsonProperty("Supply Type Id")
	List<String> Supply_Type_Id;
	
	@JsonProperty("Node Type")
	List<String> Node_Type;
	
	@JsonProperty("Safety Stock Type")
	List<String> Safety_Stock_Type;
	
	@JsonProperty("Safety Stock Value")
	String Safety_Stock_Value;
	
	@JsonProperty("Item Attribute")
	List<String> Item_Attribute;
	
	@JsonProperty("Item Attribute Value")
	String Item_Attribute_Value;
	
	
	public String getATP_Rule_Name() {
		return ATP_Rule_Name + Common.generateRandomID("Automation");
	}
	public String getATP_Rule_Description() {
		return ATP_Rule_Description + Common.generateRandomID("Automation");
	}
	public String getOverdue_Supply() {
		return Overdue_Supply;
	}
	public String getOverdue_Demand() {
		return Overdue_Demand;
	}
	public String getForward_Days() {
		return Forward_Days;
	}
	public String getBackward_Days() {
		return Backward_Days;
	}
	public String getReceipt_Processing_Time() {
		return Receipt_Processing_Time;
	}
	public String getAdvance_Notification() {
		return Advance_Notification;
	}
	
	public List<String> getChoose_a_Type() {
		return Choose_a_Type;
	}
	
	public String getItemId() {
		return ItemId;
	}
	public String getNodeId() {
		return NodeId;
	}
	
	public List<String> getFulfillment_Type_Id() {
		return Fulfillment_Type_Id;
	}
	
	public List<String> getSupply_Type_Id() {
		return Supply_Type_Id;
	}
	
	public List<String> getNode_Type() {
		return Node_Type;
	}
	
	public List<String> getSafety_Stock_Type() {
		return Safety_Stock_Type;
	}
	
	public String getSafety_Stock_Value() {
		return Safety_Stock_Value;
	}
	
	public List<String> getItem_Attribute() {
		return Item_Attribute;
	}
	
	public String getItem_Attribute_Value() {
		return Item_Attribute_Value;
	}


	
	public static InventoryAvailabilityData get(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), InventoryAvailabilityData.class);
	}


}
