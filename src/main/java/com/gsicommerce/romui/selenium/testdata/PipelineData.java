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

public class PipelineData {

	@JsonProperty("pipelineName")
	String pipelineName;

	@JsonProperty("pipelineCriteriaType")
	List<String> pipelineCriteriaType;
	
	@JsonProperty("pipelineCriteriaGroup")
	List<String> pipelineCriteriaGroup;
	
	@JsonProperty("pipelineOperator")
	List<String> pipelineOperator;
	
	@JsonProperty("pipelineValueOrderType")
	List<String> pipelineValueOrderType;
	
	@JsonProperty("pipelineValueTenderType")
	List<String> pipelineValueTenderType;
	
	@JsonProperty("pipelineValueFulfillmentMethod")
	List<String> pipelineValueFulfillmentMethod;
	
	
	public String getPipelineName() {
		String pipelinename = pipelineName + Common.generateRandomID("Auto");
		return pipelinename;
	}

	public List<String> getPipelineCriteriaType() {
		return pipelineCriteriaType;
	}
	
	public List<String> getPipelineCriteriaGroup() {
		return pipelineCriteriaGroup;
	}
	
	public List<String> getpipelineOperator() {
		return pipelineOperator;
	}
	
	public List<String> getpipelineValueOrderType() {
		return pipelineValueOrderType;
	}
		
	public List<String> getpipelineValueTenderType() {
		return pipelineValueTenderType;
	}
	
	public List<String> getpipelineValueFulfillmentMethod() {
		return pipelineValueFulfillmentMethod;
	}
	
	public static PipelineData get(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		 mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), PipelineData.class);
	}

}
