package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsicommerce.romui.selenium.utilities.Common;

public class ServiceFlowData {
	@JsonProperty("serviceflowName")
	String serviceflowName;
	@JsonProperty("Value")
	String Value;
	@JsonProperty("Value2")
	String Value2;
	@JsonProperty("Value3")
	String Value3;
	@JsonProperty("Value4")
	String Value4;
	@JsonProperty("Value5")
	String Value5;
	@JsonProperty("Value6")
	String Value6;

	
	
	public String getSvcFlwName() {
		System.out.println("Service Flow name is:" +serviceflowName+ Common.generateRandomID("Auto"));
		return serviceflowName+ Common.generateRandomID("Auto");
	}
	
	public String getSvcFlwValue1() {
		return Value;
	}
	
	public String getSvcFlwValue2() {
		return Value2;
	}
	
	public String getSvcFlwValue3() {
		return Value3;
	}
	
	public String getSvcFlwValue4() {
		return Value4;
	}
	
	public String getSvcFlwValue5() {
		return Value5;
	}
	
	public String getSvcFlwValue6() {
		return Value6;
	}
	
	
	public static ServiceFlowData get(String filename) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), ServiceFlowData.class);
    }

}
