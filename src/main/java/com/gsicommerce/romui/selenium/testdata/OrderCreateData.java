package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsicommerce.romui.selenium.utilities.Common;

public class OrderCreateData {
	@JsonProperty("WebOrderId")
	String WebOrderId;

	@JsonProperty("ItemId")
	String ItemId;
	
	@JsonProperty("SourceId")
	String SourceId;
	
	@JsonProperty("Quantity")
	String Quantity;

	public String setWebOrderId(String webOrderId) {
		return WebOrderId = webOrderId + Common.generateRandomID("AUTO");
	}

	public String getWebOrderId() {
		return WebOrderId;
	}

	public String setItemId(String itemid) {
		return ItemId;
	}

	public String getItemId() {
		return ItemId;
	}
	
	public String setSourceId(String sourceId) {
		return SourceId;
	}

	public String getSourceId() {
		return SourceId;
	}

	public String setQuantity(String quantity) {
		return Quantity;
	}

	public String getQuantity() {
		return Quantity;
	}
	public static OrderCreateData get(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), OrderCreateData.class);
	}

}
