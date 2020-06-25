package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;

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
	
	public static InventoryAvailabilityData get(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), InventoryAvailabilityData.class);
	}


}
