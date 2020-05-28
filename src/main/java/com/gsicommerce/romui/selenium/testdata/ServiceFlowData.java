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
	@JsonProperty("serviceflowKeyValue")
	String serviceflowKeyValue;
	@JsonProperty("OTFValue")
	String OTFValue;
	@JsonProperty("HFRValue")
	String HFRValue;
	@JsonProperty("PickValue")
	String PickValue;
	@JsonProperty("PackValue")
	String PackValue;
	@JsonProperty("ShipmentValue")
	String ShipmentValue;
	@JsonProperty("FlatrateValue")
	String FlatrateValue;

	
	
	public String getSvcFlwName() {
		System.out.println("Service Flow name is:" +serviceflowName+ Common.generateRandomID("Auto"));
		return serviceflowName+ Common.generateRandomID("Auto");
	}
	
	public String getSvcFlwkeyValue() {
		return serviceflowKeyValue+ Common.generateRandomID("Auto");
	}
	
	public String getOtfSvcFlwValue() {
		return OTFValue;
	}
	
	public String getHfrSvcFlwValue() {
		return HFRValue;
	}
	
	public String getPickSvcFlwValue() {
		return PickValue;
	}
	
	public String getPackSvcFlwValue() {
		return PackValue;
	}
	
	public String getShipmentSvcFlwValue() {
		return ShipmentValue;
	}
	
	public String getFlatrateSvcFlwValue() {
		return FlatrateValue;
	}
	
	
	public static ServiceFlowData get(String filename) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), ServiceFlowData.class);
    }

}
