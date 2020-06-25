package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SFSData {

	@JsonProperty("orderNo")
	String orderNo;

	@JsonProperty("nodeID")
	String nodeID;

	@JsonProperty("qtyList")
	List<String> qtyList;

	@JsonProperty("itemIdList")
	List<String> itemIdList;

	@JsonProperty("LocId")
	String LocId;

	public String getOrderNo() {
		return orderNo;
	}

	public String getNodeID() {
		return nodeID;
	}

	public List<String> getQtyList() {
		return qtyList;
	}

	public List<String> getItemIdList() {
		return itemIdList;
	}

	public String getLocId() {
		return LocId;
	}

	public static SFSData get(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), SFSData.class);
	}

}
