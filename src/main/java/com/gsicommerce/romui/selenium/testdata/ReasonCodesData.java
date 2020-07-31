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

public class ReasonCodesData {
	
	@JsonProperty("Name")
	String Name;
	
	@JsonProperty("Type")
	List<String> Type;
	
	@JsonProperty("Description")
	String Description;
	
	@JsonProperty("nodeID")
	String nodeID;
	
	@JsonProperty("storeIndex")
	int storeIndex;
	
	public String getName() {
		return Name + Common.generateRandomID("AU");
	}
	
	public List<String> getType() {
		return Type;
	}
	
	public String getDescription() {
		return Description + Common.generateRandomID("");
	}
	
	public int getStoreIndex() {
		
		return storeIndex;
	}

	public String getNodeID() {
	
		return nodeID;
	}
	
	
	
	public static ReasonCodesData get(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), ReasonCodesData.class);
	}
	

}
