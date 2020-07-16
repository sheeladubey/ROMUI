package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AssociateDeliveryData {

	@JsonProperty("orderNoList")
	List<String> orderNoList;

	@JsonProperty("nodeID")
	String nodeID;

	@JsonProperty("qtyList")
	List<String> qtyList;

	@JsonProperty("itemIdList")
	List<String> itemIdList;

	@JsonProperty("LocId")
	String LocId;
	
	@JsonProperty("shipMethod")
	String shipMethod;
	
	@JsonProperty("declineQty")
	String declineQty;
	
	@JsonProperty("storeIndex")
	int storeIndex;

	public int getStoreIndex() {
		return storeIndex;
	}

	public String getDeclineQty() {
		return declineQty;
	}

	public String getShipMethod() {
		return shipMethod;
	}

	public List<String> getOrderNoList() {
		return orderNoList;
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
	
	

	public static AssociateDeliveryData get(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), AssociateDeliveryData.class);
	}

}