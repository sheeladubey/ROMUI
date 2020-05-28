package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServiceGroupConfigsData {

	@JsonProperty("headerLogoURL")
	String headerLogoURL;

	@JsonProperty("menuLogoURL")
	String menuLogoURL;

	@JsonProperty("cancelCode")
	String cancelCode;

	@JsonProperty("cancelReason")
	String cancelReason;

	@JsonProperty("publishInvoiceValue")
	String publishInvoiceValue;

	@JsonProperty("publishInvoiceDescrp")
	String publishInvoiceDescrp;

	@JsonProperty("returnReasonCode")
	String returnReasonCode;

	@JsonProperty("returnReason")
	String returnReason;

	@JsonProperty("ftcEntryType")
	String ftcEntryType;

	@JsonProperty("ftcShipToCounty")
	String ftcShipToCounty;

	@JsonProperty("ftcFlow")
	String ftcFlow;

	@JsonProperty("ftcTypeOfOrder")
	String ftcTypeOfOrder;

	@JsonProperty("ftcNoOfHrs")
	String ftcNoOfHrs;

	@JsonProperty("returnWindowDays")
	String returnWindowDays;

	@JsonProperty("returnLocOverride")
	String returnLocOverride;

	@JsonProperty("returnEligibleRank")
	String returnEligibleRank;

	@JsonProperty("returnEligibleRankDesc")
	String returnEligibleRankDesc;

	@JsonProperty("returnRefundChargeRule")
	String returnRefundChargeRule;

	@JsonProperty("returnRefundReasonCode")
	String returnRefundReasonCode;

	@JsonProperty("returnRefundReason")
	String returnRefundReason;

	@JsonProperty("returnRefundProductCondCode")
	String returnRefundProductCondCode;

	@JsonProperty("returnRefundProductCondReason")
	String returnRefundProductCondReason;

	@JsonProperty("iShipSolVer")
	String iShipSolVer;

	@JsonProperty("adminAddrTaxCalc")
	String adminAddrTaxCalc;

	@JsonProperty("taxStrategyVal")
	String taxStrategyVal;

	@JsonProperty("taxEntryType")
	String taxEntryType;

	@JsonProperty("backOrderedRetryMin")
	String backOrderedRetryMin;

	@JsonProperty("pinLength")
	String pinLength;

	@JsonProperty("ssgISPUStPickProcessApprng")
	String ssgISPUStPickProcessApprng;

	@JsonProperty("ssgISPUStPickProcessExpired")
	String ssgISPUStPickProcessExpired;

	@JsonProperty("ssgISPUCompletePickingApprng")
	String ssgISPUCompletePickingApprng;

	@JsonProperty("ssgISPUCompletePickingExpired")
	String ssgISPUCompletePickingExpired;

	@JsonProperty("ssgISPUCustPickupApprng")
	String ssgISPUCustPickupApprng;

	@JsonProperty("ssgISPUCustPickupExpired")
	String ssgISPUCustPickupExpired;

	@JsonProperty("ssgSFSStPickProcessApprng")
	String ssgSFSStPickProcessApprng;

	@JsonProperty("ssgSFSStPickProcessExpired")
	String ssgSFSStPickProcessExpired;

	@JsonProperty("ssgSFSCompletePickingApprng")
	String ssgSFSCompletePickingApprng;

	@JsonProperty("ssgSFSCompletePickingExpired")
	String ssgSFSCompletePickingExpired;

	@JsonProperty("ssgSFSCompletePackingApprng")
	String ssgSFSCompletePackingApprng;

	@JsonProperty("ssgSFSCompletePackingExpired")
	String ssgSFSCompletePackingExpired;

	@JsonProperty("ssgSTSStPickProcessApprng")
	String ssgSTSStPickProcessApprng;

	@JsonProperty("ssgSTSStPickProcessExpired")
	String ssgSTSStPickProcessExpired;

	@JsonProperty("ssgSFSPickExpiredCanclSLA")
	String ssgSFSPickExpiredCanclSLA;

	@JsonProperty("ssgSTSCompletePickingApprng")
	String ssgSTSCompletePickingApprng;

	@JsonProperty("ssgSTSCompletePickingExpired")
	String ssgSTSCompletePickingExpired;

	@JsonProperty("ssgSTSCompletePackingApprng")
	String ssgSTSCompletePackingApprng;

	@JsonProperty("ssgSTSCompletePackingExpired")
	String ssgSTSCompletePackingExpired;

	@JsonProperty("ssgSTSCustPickupApprng")
	String ssgSTSCustPickupApprng;

	@JsonProperty("ssgSTSCustPickupExpired")
	String ssgSTSCustPickupExpired;

	@JsonProperty("ssgSTSPickExpiredCanclSLA")
	String ssgSTSPickExpiredCanclSLA;

	@JsonProperty("ssgAssctStPickProcessApprng")
	String ssgAssctStPickProcessApprng;

	@JsonProperty("ssgAssctStPickProcessExpired")
	String ssgAssctStPickProcessExpired;

	@JsonProperty("ssgAssctCompletePickingApprng")
	String ssgAssctCompletePickingApprng;

	@JsonProperty("ssgAssctCompletePickingExpired")
	String ssgAssctCompletePickingExpired;

	@JsonProperty("ssgAssctCmpltPackingApprng")
	String ssgAssctCmpltPackingApprng;

	@JsonProperty("ssgAssctCmpltPackingExpired")
	String ssgAssctCmpltPackingExpired;

	@JsonProperty("ssgAssctCustDelvryApprng")
	String ssgAssctCustDelvryApprng;

	@JsonProperty("ssgAssctCustDelvryExpired")
	String ssgAssctCustDelvryExpired;

	@JsonProperty("ssgPickDeclineReasonCode")
	String ssgPickDeclineReasonCode;

	@JsonProperty("ssgPickDeclineReason")
	String ssgPickDeclineReason;

	@JsonProperty("ssgCustPickupDeclineReasonCode")
	String ssgCustPickupDeclineReasonCode;

	@JsonProperty("ssgCustPickupDeclineReason")
	String ssgCustPickupDeclineReason;

	@JsonProperty("ssgPackDeclineReasonCode")
	String ssgPackDeclineReasonCode;

	@JsonProperty("ssgPackDeclineReason")
	String ssgPackDeclineReason;

	@JsonProperty("ssgCheckInDeclineReasonCode")
	String ssgCheckInDeclineReasonCode;

	@JsonProperty("ssgCheckInDeclineReason")
	String ssgCheckInDeclineReason;

	@JsonProperty("marketPlaceOrderEntryType")
	String marketPlaceOrderEntryType;

	@JsonProperty("pickupExpiredCnclMin")
	String pickupExpiredCnclMin;

	@JsonProperty("packageID")
	String packageID;

	@JsonProperty("packageWeight")
	String packageWeight;

	@JsonProperty("packageWeightUnits")
	String packageWeightUnits;

	@JsonProperty("packngMaterialWeight")
	String packngMaterialWeight;

	@JsonProperty("packngMaterialWeightUnits")
	String packngMaterialWeightUnits;

	@JsonProperty("packageHeight")
	String packageHeight;

	@JsonProperty("packageHeightUnits")
	String packageHeightUnits;

	@JsonProperty("packagewidth")
	String packagewidth;

	@JsonProperty("packagewidthUnits")
	String packagewidthUnits;

	@JsonProperty("packageLength")
	String packageLength;

	@JsonProperty("packageLengthUnits")
	String packageLengthUnits;

	public String getHeaderLogoURL() {
		return headerLogoURL;
	}

	public String getCancelCode() {
		return cancelCode;
	}

	public String getFtcTypeOfOrder() {
		return ftcTypeOfOrder;
	}

	public String getFtcNoOfHrs() {
		return ftcNoOfHrs;
	}

	public String getReturnWindowDays() {
		return returnWindowDays;
	}

	public String getReturnLocOverride() {
		return returnLocOverride;
	}

	public String getReturnEligibleRank() {
		return returnEligibleRank;
	}

	public String getReturnRefundChargeRule() {
		return returnRefundChargeRule;
	}

	public String getiShipSolVer() {
		return iShipSolVer;
	}

	public String getAdminAddrTaxCalc() {
		return adminAddrTaxCalc;
	}

	public String getTaxStrategyVal() {
		return taxStrategyVal;
	}

	public String getTaxEntryType() {
		return taxEntryType;
	}

	public String getBackOrderedRetryMin() {
		return backOrderedRetryMin;
	}

	public String getSsgISPUStPickProcessApprng() {
		return ssgISPUStPickProcessApprng;
	}

	public String getSsgISPUStPickProcessExpired() {
		return ssgISPUStPickProcessExpired;
	}

	public String getSsgISPUCompletePickingApprng() {
		return ssgISPUCompletePickingApprng;
	}

	public String getSsgISPUCompletePickingExpired() {
		return ssgISPUCompletePickingExpired;
	}

	public String getSsgISPUCustPickupApprng() {
		return ssgISPUCustPickupApprng;
	}

	public String getSsgISPUCustPickupExpired() {
		return ssgISPUCustPickupExpired;
	}

	public String getSsgSFSStPickProcessApprng() {
		return ssgSFSStPickProcessApprng;
	}

	public String getSsgSFSStPickProcessExpired() {
		return ssgSFSStPickProcessExpired;
	}

	public String getSsgSFSCompletePickingApprng() {
		return ssgSFSCompletePickingApprng;
	}

	public String getSsgSFSCompletePickingExpired() {
		return ssgSFSCompletePickingExpired;
	}

	public String getSsgSFSCompletePackingApprng() {
		return ssgSFSCompletePackingApprng;
	}

	public String getSsgSFSCompletePackingExpired() {
		return ssgSFSCompletePackingExpired;
	}

	public String getSsgSFSPickExpiredCanclSLA() {
		return ssgSFSPickExpiredCanclSLA;
	}

	public String getSsgSTSStPickProcessApprng() {
		return ssgSTSStPickProcessApprng;
	}

	public String getSsgSTSStPickProcessExpired() {
		return ssgSTSStPickProcessExpired;
	}

	public String getSsgSTSCompletePickingApprng() {
		return ssgSTSCompletePickingApprng;
	}

	public String getSsgSTSCompletePickingExpired() {
		return ssgSTSCompletePickingExpired;
	}

	public String getSsgSTSCompletePackingApprng() {
		return ssgSTSCompletePackingApprng;
	}

	public String getSsgSTSCompletePackingExpired() {
		return ssgSTSCompletePackingExpired;
	}

	public String getSsgSTSCustPickupApprng() {
		return ssgSTSCustPickupApprng;
	}

	public String getSsgSTSCustPickupExpired() {
		return ssgSTSCustPickupExpired;
	}

	public String getSsgSTSPickExpiredCanclSLA() {
		return ssgSTSPickExpiredCanclSLA;
	}

	public String getSsgAssctStPickProcessApprng() {
		return ssgAssctStPickProcessApprng;
	}

	public String getSsgAssctStPickProcessExpired() {
		return ssgAssctStPickProcessExpired;
	}

	public String getSsgAssctCompletePickingApprng() {
		return ssgAssctCompletePickingApprng;
	}

	public String getSsgAssctCompletePickingExpired() {
		return ssgAssctCompletePickingExpired;
	}

	public String getSsgAssctCmpltPackingApprng() {
		return ssgAssctCmpltPackingApprng;
	}

	public String getSsgAssctCmpltPackingExpired() {
		return ssgAssctCmpltPackingExpired;
	}

	public String getSsgAssctCustDelvryApprng() {
		return ssgAssctCustDelvryApprng;
	}

	public String getSsgAssctCustDelvryExpired() {
		return ssgAssctCustDelvryExpired;
	}

	public String getSsgPickDeclineReasonCode() {
		return ssgPickDeclineReasonCode;
	}

	public String getSsgPickDeclineReason() {
		return ssgPickDeclineReason;
	}

	public String getSsgCustPickupDeclineReasonCode() {
		return ssgCustPickupDeclineReasonCode;
	}

	public String getSsgCustPickupDeclineReason() {
		return ssgCustPickupDeclineReason;
	}

	public String getSsgPackDeclineReasonCode() {
		return ssgPackDeclineReasonCode;
	}

	public String getSsgPackDeclineReason() {
		return ssgPackDeclineReason;
	}

	public String getSsgCheckInDeclineReasonCode() {
		return ssgCheckInDeclineReasonCode;
	}

	public String getSsgCheckInDeclineReason() {
		return ssgCheckInDeclineReason;
	}

	public String getMarketPlaceOrderEntryType() {
		return marketPlaceOrderEntryType;
	}

	public String getPickupExpiredCnclMin() {
		return pickupExpiredCnclMin;
	}

	public String getPackageID() {
		return packageID;
	}

	public String getPackageWeight() {
		return packageWeight;
	}

	public String getPackageWeightUnits() {
		return packageWeightUnits;
	}

	public String getPackngMaterialWeight() {
		return packngMaterialWeight;
	}

	public String getPackngMaterialWeightUnits() {
		return packngMaterialWeightUnits;
	}

	public String getPackageHeight() {
		return packageHeight;
	}

	public String getPackageHeightUnits() {
		return packageHeightUnits;
	}

	public String getPackagewidth() {
		return packagewidth;
	}

	public String getPackagewidthUnits() {
		return packagewidthUnits;
	}

	public String getPackageLength() {
		return packageLength;
	}

	public String getPackageLengthUnits() {
		return packageLengthUnits;
	}

	public String getMenuLogoURL() {
		return menuLogoURL;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public String getPublishInvoiceValue() {
		return publishInvoiceValue;
	}

	public String getPublishInvoiceDescrp() {
		return publishInvoiceDescrp;
	}

	public String getReturnReasonCode() {
		return returnReasonCode;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public String getFtcEntryType() {
		return ftcEntryType;
	}

	public String getFtcShipToCounty() {
		return ftcShipToCounty;
	}

	public String getFtcFlow() {
		return ftcFlow;
	}

	public String getReturnRefundReasonCode() {
		return returnRefundReasonCode;
	}

	public String getReturnRefundReason() {
		return returnRefundReason;
	}

	public String getReturnRefundProductCondCode() {
		return returnRefundProductCondCode;
	}

	public String getReturnRefundProductCondReason() {
		return returnRefundProductCondReason;
	}

	public String getReturnEligibleRankDesc() {
		return returnEligibleRankDesc;
	}

	public String getPinLength() {
		return pinLength;
	}

	public static ServiceGroupConfigsData get(String filename)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(filename), ServiceGroupConfigsData.class);
	}

}
