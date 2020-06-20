package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsicommerce.romui.selenium.utilities.Common;

public class SellerConfigurationsData {

	@JsonProperty("SellerID")
	String SellerID;
	
	@JsonProperty("InventoryOrganizationID")
	String InventoryOrganizationID;

	@JsonProperty("SellerName")
	String SellerName;

	@JsonProperty("MaxDuration")
	String MaxDuration;

	@JsonProperty("OSDescriptionsCreated")
	String OSDescriptionsCreated;

	@JsonProperty("OSDescriptionsPre-SellLineCreated")
	String OSDescriptionsPreSellLineCreated;

	@JsonProperty("OSDescriptionsDummyReturn")
	String OSDescriptionsDummyReturn;

	@JsonProperty("InventoryAdjReasonsCode")
	String InventoryAdjReasonsCode;

	@JsonProperty("SellerRegionLookupStrategy")
	String SellerRegionLookupStrategy;

	public String getSellerID() {
		return SellerID;
	}
	
	public String getInventoryOrganizationID() {
		return InventoryOrganizationID;
	}

	public String getSellerName() {
		return SellerName;
	}

	public String getMaxDuration() {
		return MaxDuration;
	}

	public String getOSCreated() {
		return OSDescriptionsCreated;
	}

	public String getOSSellLine() {
		return OSDescriptionsPreSellLineCreated;
	}

	public String getOSDummyReturn() {
		return OSDescriptionsDummyReturn + Common.generateRandomID("Auto");
	}

	public String getInventoryAdjReasonsCode() {
		return InventoryAdjReasonsCode + Common.generateRandomID("Auto");
	}

	public String getSellerRegionLookupStrategy() {
		return SellerRegionLookupStrategy;
	}

	public static SellerConfigurationsData get(String filename)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), SellerConfigurationsData.class);
	}

}
