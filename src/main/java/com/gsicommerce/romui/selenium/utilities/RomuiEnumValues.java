package com.gsicommerce.romui.selenium.utilities;

public enum RomuiEnumValues {
	PAYMENT_METHOD_CONFIG_UPDATE("Heads up! Payment Method Configuration is successfully updated"),
	PAYMENT_METHOD_CONFIG_ADD("Heads up! Payment Method Configuration is successfully created"),
	PAYMENT_METHOD_CONFIG_DELETE("Heads up! Payment Method Configuration is successfully deleted"),
	SERVICEFLOW_HEADER("Service Flows"), SERVICEFLOW_ADD_HEADER("Create Service Flow"),
	SERVICEFLOW_EDIT_HEADER("Edit Service Flow Criteria"), SERVICEFLOW_VIEW_HEADER("Service Flow"),
	SERVICEFLOW_CONFIGURE_HEADER("Configure Service Flow Processes"),
	SERVICEFLOW_SAVE("Heads up! Your service workflow has been saved!"),
	SERVICEFLOW_EDIT("Heads up! Your service workflow has been updated!"),
	SERVICEFLOW_PROCESS_HEADER("Service Flow Processes"),
	SERVICE_GROUP_CONFIG("Heads up! Service Group Configurations Updated Successfully"),
	SFS_PICKORDER_SUCCESS_MSG("Heads up! Order successfully updated!"),
	SFS_PACKORDER_SUCCESS_MSG("Heads up! The order has been successfully packed."),
	ITEM_ADD("Heads up! Item successfully created"), ITEM_EDIT("Heads up! Item successfully updated"),
	INVENTORY_ADD("Heads up! Inventory has been added for item"),
	INVENTORY_ADJUST("Heads up! Inventory has been adjusted for item"),
	INVENTORY_MOVE("Heads up! Inventory has been moved for item"),
	FORM_ERROR("Oh snap! Please check your form for validation errors"),
	SHIPPINGREGIONGRPFORM_ERROR("Oh snap! Regions can't be empty"),
	SHIPPINGREGIONGRP_SAVED("Heads up! Region Group saved successfully"),
	SHIPPINGREGIONGRP_DELETE("Heads up! The Shipping Region Group Was Successfully Deleted!"),
	SHIPPINGREGIONFORM_ERROR("Oh snap! Please check your form for validation errors"),
	SHIPPINGREGION_SAVED("Heads up! Region Saved Successfully"),
	SHIPPINGREGION_DELETE("Heads up! The Shipping Region Was Successfully Deleted!"),
	PIPELINE_SAVE("Heads up! Your pipeline has been saved!"), PIPELINE_DELETE("Heads up! Pipeline has been deleted."),
	PIPELINE_EDIT("Heads up! Your pipeline has been updated!"),
	PIPELINE_FORMVALIDATION(
			"Please confirm the pipeline criteria form data you entered or remove it entirely before submitting."),
	SHIPPING_LABEL_CONFIG_ADD("Heads up! Shipping Label Configuration created successfully."),
	SHIPPNG_LABEL_CONFIG_EDIT("Heads up! Shipping Label Configuration updated successfully."),
	ORDER_NOTFOUND("Heads up! No Results Found"),
	SELLERCONFIG_EDIT("Heads up! Seller Updated Successfully"),
	ATPRULES_ADD("Heads up! ATP Rule created successfully!"),
	ATPRULES_DELETE("Heads up! ATP Rule deleted."),
	ATPRULES_EDIT("Heads up! ATP Rule updated successfully!"),
	SAFETYSTOCK_NOTFOUND("Heads up! No Safety Stock Found"),
	SAFETYSTOCK_ADD("Heads up! Safety Stock was successfully created"),
	SAFETYSTOCK_EDIT("Heads up! Safety Stock was successfully updated"),
	SAFETYSTOCK_DELETE("Heads up! The Safety Stock Was Successfully Deleted!"),
	SAFETYSTOCK_EXIST("Oh snap! Safety Stock already exists"),
	SERVICEFLOW_CRITERIA_VALIDATION(""),
	SERVICEFLOW_VALIDATION(""),
	USER_NOTFOUND(""),
	USER_FOUND(""),
	ROLE_VALIDATION(""),
	USER_VALIDATION(""),
	NODECALENDARS_ADD("Heads up! Calendar Successfully Saved!"),
	NODECALENDARS_DELETE("Heads up! The Calendar was successfully deleted!");

	private String updateMsg;

	RomuiEnumValues(String updateMsg) {
		this.updateMsg = updateMsg;
	}

	public String getMessage() {
		return updateMsg;
	}
}
