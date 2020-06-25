package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PaymentMethodConfigData {

	@JsonProperty("paymentMethodCode")
	List<String> paymentMethodCode;

	@JsonProperty("description")
	String description;

	@JsonProperty("minWaitTime")
	String minWaitTime;

	@JsonProperty("autoExpiry")
	String autoExpiry;

	@JsonProperty("authReversal")
	String authReversal;

	@JsonProperty("cashbackLimit")
	String cashbackLimit;

	@JsonProperty("chargeSequence")
	String chargeSequence;

	@JsonProperty("refundConstraintValue")
	String refundConstraintValue;

	@JsonProperty("refundSequence")
	String refundSequence;

	@JsonProperty("refundItemID")
	String refundItemID;

	@JsonProperty("refundItemUOM")
	String refundItemUOM;

	public List<String> getPaymentMethodCode() {
		return paymentMethodCode;
	}

	public String getDescription() {
		return description;
	}

	public String getMinWaitTime() {
		return minWaitTime;
	}

	public String getAutoExpiry() {
		return autoExpiry;
	}

	public String getAuthReversal() {
		return authReversal;
	}

	public String getCashbackLimit() {
		return cashbackLimit;
	}

	public String getChargeSequence() {
		return chargeSequence;
	}

	public String getrefundConstraintValue() {
		return refundConstraintValue;
	}

	public String getRefundSequence() {
		return refundSequence;
	}

	public String getRefundItemID() {
		return refundItemID;
	}

	public String getRefundItemUOM() {
		return refundItemUOM;
	}

	public static PaymentMethodConfigData get(String filename)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), PaymentMethodConfigData.class);
	}

}
