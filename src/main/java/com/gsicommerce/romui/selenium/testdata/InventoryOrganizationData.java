package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsicommerce.romui.selenium.utilities.Common;

public class InventoryOrganizationData {

	@JsonProperty("Inventory Organization ID")
	String InventoryOrgID;

	@JsonProperty("Inventory Organization Name")
	String InventoryOrgName;

	@JsonProperty("Inventory Organization Defaults")
	String InventoryOrgDefaults;

	@JsonProperty("Default Shipping Calendar ID")
	String InventoryOrgShippingCalendarID;

	@JsonProperty("Default ATP Rule")
	String DefaultATP;

	@JsonProperty("Node Rejected Supply Action")
	String NodeRejected;

	@JsonProperty("Group ID")
	String groupID;

	@JsonProperty("Calendar ID")
	String CalendarID;

	@JsonProperty("AttributeName")
	String AttributeName;

	@JsonProperty("Priority")
	String Priority;

	public String getInventoryOrgID() {
		return InventoryOrgID;
	}

	public String getInventoryOrgName() {
		return InventoryOrgName;
	}

	public String getInventoryOrgDefaults() {
		return InventoryOrgDefaults;
	}

	public String getInventoryOrgShippingCalendarID() {
		return InventoryOrgShippingCalendarID;
	}

	public String getDefaultATP() {
		return DefaultATP;
	}

	public String getNodeRejected() {
		return NodeRejected;
	}

	public String getGroupID() {
		return groupID;
	}

	public String getCalendarID() {
		return CalendarID;
	}

	public String getAttributeName() {
		return AttributeName + Common.generateRandomID("AUTO");
	}

	public String getPriority() {
		return Priority;
	}

	public static InventoryOrganizationData get(String filename)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), InventoryOrganizationData.class);
	}

}
