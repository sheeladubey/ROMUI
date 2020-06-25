package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CatalogInventorySearchData {

	@JsonProperty("clientItemID")
	String clientItemID;

	@JsonProperty("productID")
	String productID;

	@JsonProperty("itemDescrp")
	String itemDescrp;

	@JsonProperty("itemIdList")
	List<String> itemIdList;

	@JsonProperty("qty")
	String qty;

	@JsonProperty("taxCode")
	String taxCode;

	@JsonProperty("itemType")
	String itemType;

	@JsonProperty("status")
	String status;

	@JsonProperty("productTitle")
	String productTitle;

	@JsonProperty("currency")
	String currency;

	@JsonProperty("unitCost")
	String unitCost;

	@JsonProperty("countryOfOrigin")
	String countryOfOrigin;

	@JsonProperty("brandName")
	String brandName;

	@JsonProperty("brandLocale")
	String brandLocale;

	@JsonProperty("brandDescp")
	String brandDescp;

	@JsonProperty("upcType")
	String upcType;

	@JsonProperty("colorCode")
	String colorCode;

	@JsonProperty("colorLocale")
	String colorLocale;

	@JsonProperty("colorDescrp")
	String colorDescrp;

	@JsonProperty("upc")
	String upc;

	@JsonProperty("sizeCode")
	String sizeCode;

	@JsonProperty("sizeLocale")
	String sizeLocale;

	@JsonProperty("sizeDescrp")
	String sizeDescrp;

	@JsonProperty("styleID")
	String styleID;

	@JsonProperty("styleDescrp")
	String styleDescrp;

	@JsonProperty("dsSupplierName")
	String dsSupplierName;

	@JsonProperty("dsSupplierNo")
	String dsSupplierNo;

	@JsonProperty("dsSupplierPartNo")
	String dsSupplierPartNo;

	@JsonProperty("sourcingOverride")
	String sourcingOverride;

	@JsonProperty("sourcingPreference")
	String sourcingPreference;

	@JsonProperty("sourcingClassfication1")
	String sourcingClassfication1;

	@JsonProperty("sourcingClassfication2")
	String sourcingClassfication2;

	@JsonProperty("sourcingClassfication3")
	String sourcingClassfication3;

	@JsonProperty("hazardousMaterlCode")
	String hazardousMaterlCode;

	@JsonProperty("weightUnitOfMeasure")
	String weightUnitOfMeasure;

	@JsonProperty("itemWeight")
	String itemWeight;

	@JsonProperty("dimensionUnitOfMeasure")
	String dimensionUnitOfMeasure;

	@JsonProperty("itemPackWidth")
	String itemPackWidth;

	@JsonProperty("itemPackLength")
	String itemPackLength;

	@JsonProperty("itemPackHeight")
	String itemPackHeight;

	@JsonProperty("itemPackType")
	String itemPackType;

	@JsonProperty("dimensionalWeightUOM")
	String dimensionalWeightUOM;

	@JsonProperty("dimensionalWeight")
	String dimensionalWeight;

	@JsonProperty("freightClass")
	String freightClass;

	@JsonProperty("shipAlone")
	String shipAlone;

	@JsonProperty("shippingSurchargeOverride")
	String shippingSurchargeOverride;

	@JsonProperty("shippingChargeOverride")
	String shippingChargeOverride;

	@JsonProperty("minShipmtProcessingDays")
	String minShipmtProcessingDays;

	@JsonProperty("maxShipmtProcessingDays")
	String maxShipmtProcessingDays;

	@JsonProperty("minOrderableQty")
	String minOrderableQty;

	@JsonProperty("maxOrderableQty")
	String maxOrderableQty;

	@JsonProperty("imgType")
	String imgType;

	@JsonProperty("imgView")
	String imgView;

	@JsonProperty("imgHeight")
	String imgHeight;

	@JsonProperty("imgWidth")
	String imgWidth;

	@JsonProperty("imgURL")
	String imgURL;

	@JsonProperty("attribName")
	String attribName;

	@JsonProperty("attribVal")
	String attribVal;

	@JsonProperty("nodeID")
	String nodeID;

	@JsonProperty("supplyType")
	String supplyType;

	@JsonProperty("quantity")
	String quantity;

	@JsonProperty("reason")
	String reason;

	@JsonProperty("adjustmentType")
	String adjustmentType;

	@JsonProperty("adjustmentQty")
	String adjustmentQty;

	@JsonProperty("nodeType")
	String nodeType;

	@JsonProperty("itemID")
	String itemID;

	public String getStyleID() {
		return styleID;
	}

	public String getStyleDescrp() {
		return styleDescrp;
	}

	public String getDsSupplierName() {
		return dsSupplierName;
	}

	public String getDsSupplierNo() {
		return dsSupplierNo;
	}

	public String getDsSupplierPartNo() {
		return dsSupplierPartNo;
	}

	public String getSourcingOverride() {
		return sourcingOverride;
	}

	public String getSourcingPreference() {
		return sourcingPreference;
	}

	public String getSourcingClassfication1() {
		return sourcingClassfication1;
	}

	public String getSourcingClassfication2() {
		return sourcingClassfication2;
	}

	public String getSourcingClassfication3() {
		return sourcingClassfication3;
	}

	public String getHazardousMaterlCode() {
		return hazardousMaterlCode;
	}

	public String getWeightUnitOfMeasure() {
		return weightUnitOfMeasure;
	}

	public String getItemWeight() {
		return itemWeight;
	}

	public String getDimensionUnitOfMeasure() {
		return dimensionUnitOfMeasure;
	}

	public String getItemPackWidth() {
		return itemPackWidth;
	}

	public String getItemPackLength() {
		return itemPackLength;
	}

	public String getItemPackHeight() {
		return itemPackHeight;
	}

	public String getItemPackType() {
		return itemPackType;
	}

	public String getDimensionalWeightUOM() {
		return dimensionalWeightUOM;
	}

	public String getDimensionalWeight() {
		return dimensionalWeight;
	}

	public String getFreightClass() {
		return freightClass;
	}

	public String getShipAlone() {
		return shipAlone;
	}

	public String getShippingSurchargeOverride() {
		return shippingSurchargeOverride;
	}

	public String getShippingChargeOverride() {
		return shippingChargeOverride;
	}

	public String getMinShipmtProcessingDays() {
		return minShipmtProcessingDays;
	}

	public String getMaxShipmtProcessingDays() {
		return maxShipmtProcessingDays;
	}

	public String getMinOrderableQty() {
		return minOrderableQty;
	}

	public String getMaxOrderableQty() {
		return maxOrderableQty;
	}

	public String getImgType() {
		return imgType;
	}

	public String getImgView() {
		return imgView;
	}

	public String getImgHeight() {
		return imgHeight;
	}

	public String getImgWidth() {
		return imgWidth;
	}

	public String getImgURL() {
		return imgURL;
	}

	public String getAttribName() {
		return attribName;
	}

	public String getAttribVal() {
		return attribVal;
	}

	public String getSizeCode() {
		return sizeCode;
	}

	public String getSizeLocale() {
		return sizeLocale;
	}

	public String getSizeDescrp() {
		return sizeDescrp;
	}

	public String getColorCode() {
		return colorCode;
	}

	public String getColorLocale() {
		return colorLocale;
	}

	public String getColorDescrp() {
		return colorDescrp;
	}

	public String getUpcType() {
		return upcType;
	}

	public String getUpc() {
		return upc;
	}

	public String getBrandName() {
		return brandName;
	}

	public String getBrandLocale() {
		return brandLocale;
	}

	public String getBrandDescp() {
		return brandDescp;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public String getUnitCost() {
		return unitCost;
	}

	public String getCurrency() {
		return currency;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public String getStatus() {
		return status;
	}

	public String getItemType() {
		return itemType;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public String getClientItemID() {
		return clientItemID;
	}

	public String getProductID() {
		return productID;
	}

	public String getItemDescrp() {
		return itemDescrp;
	}

	public String getQty() {
		return qty;
	}

	public List<String> getItemIdList() {
		return itemIdList;
	}

	public String getNodeID() {
		return nodeID;
	}

	public String getSupplyType() {
		return supplyType;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getReason() {
		return reason;
	}

	public String getAdjustmentType() {
		return adjustmentType;
	}

	public String getAdjustmentQty() {
		return adjustmentQty;
	}

	public String getNodeType() {
		return nodeType;
	}

	public String getItemID() {
		return itemID;
	}

	public static CatalogInventorySearchData get(String filename)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), CatalogInventorySearchData.class);
	}

}
