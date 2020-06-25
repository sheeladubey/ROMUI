package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RegionConfigurationData {

	@JsonProperty("regionGrpDescrp")
	String regionGrpDescrp;

	@JsonProperty("regionName")
	String regionName;

	@JsonProperty("regionLevelName")
	String regionLevelName;

	@JsonProperty("country")
	String country;

	@JsonProperty("state")
	String state;

	@JsonProperty("postalCodeHigh")
	String postalCodeHigh;

	@JsonProperty("postalCodeLow")
	String postalCodeLow;

	public String getRegionLevelName() {
		return regionLevelName;
	}

	public String getCountry() {
		return country;
	}

	public String getState() {
		return state;
	}

	public String getPostalCodeHigh() {
		return postalCodeHigh;
	}

	public String getPostalCodeLow() {
		return postalCodeLow;
	}

	public String getRegionGrpDescrp() {
		return regionGrpDescrp;
	}

	public String getRegionName() {
		return regionName;
	}

	public static RegionConfigurationData get(String filename)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), RegionConfigurationData.class);
	}

}
