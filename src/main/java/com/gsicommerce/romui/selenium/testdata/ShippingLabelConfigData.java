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

public class ShippingLabelConfigData {

	@JsonProperty("serviceProviderName")
	List<String> serviceProviderName;

	@JsonProperty("sellerDescription")
	String sellerDescription;

	@JsonProperty("addressLine1")
	String addressLine1;

	@JsonProperty("addressLine2")
	String addressLine2;

	@JsonProperty("addressLine3")
	String addressLine3;

	@JsonProperty("city")
	String city;

	@JsonProperty("state")
	String state;

	@JsonProperty("zipcode")
	String zipcode;

	@JsonProperty("parentAccountNumber")
	String parentAccountNumber;

	@JsonProperty("parentKey")
	String parentKey;

	@JsonProperty("parentPassword")
	String parentPassword;

	@JsonProperty("signatureOption")
	String signatureOption;

	@JsonProperty("labelStockType")
	String labelStockType;

	@JsonProperty("parentMeterNumber")
	String parentMeterNumber;

	public List<String> getserviceProviderName() {
		return serviceProviderName;
	}

	public String getsellerDescription() {
		System.out.println("Seller Description name is:" + sellerDescription + Common.generateRandomID("Auto"));
		return sellerDescription + Common.generateRandomID("Auto");
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getAddressLine3() {

		return addressLine3;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getparentAccountNumber() {
		return parentAccountNumber + Common.generateRandomID("000");
	}

	public String getparentKey() {
		return parentKey + Common.generateRandomID("000");
	}

	public String getparentPassword() {
		return parentPassword + Common.generateRandomID("@");
	}

	public String getsignatureOption() {
		return signatureOption;
	}

	public String getlabelStockType() {
		return labelStockType + Common.generateRandomID("Type");
	}

	public String getparentMeterNumber() {
		return parentMeterNumber + Common.generateRandomID("000");
	}

	public static ShippingLabelConfigData get(String filename)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), ShippingLabelConfigData.class);
	}

}
