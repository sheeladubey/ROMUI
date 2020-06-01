package com.gsicommerce.romui.selenium.utilities;

public enum RomuiEnumValues {
	PAYMENT_METHOD_CONFIG_UPDATE("Heads up! Payment Method Configuration is successfully updated"),
	PAYMENT_METHOD_CONFIG_ADD("Heads up! Payment Method Configuration is successfully created"),
	PAYMENT_METHOD_CONFIG_DELETE("Heads up! Payment Method Configuration is successfully deleted"),
	PIPELINE_SAVE("Heads up! Your pipeline has been saved!"),
	PIPELINE_DELETE("Heads up! Pipeline has been deleted."),
	PIPELINE_EDIT("Heads up! Your pipeline has been updated!"),
	PIPELINE_FORMVALIDATION("Please confirm the pipeline criteria form data you entered or remove it entirely before submitting."),
	SERVICEFLOW_HEADER("Service Flows"),
	SERVICEFLOW_ADD_HEADER("Create Service Flow"), SERVICEFLOW_EDIT_HEADER("Edit Service Flow Criteria"),
	SERVICEFLOW_VIEW_HEADER("Service Flow"), SERVICEFLOW_CONFIGURE_HEADER("Configure Service Flow Processes"),
	SERVICEFLOW_SAVE("Heads up! Your service workflow has been saved!"),
	SERVICEFLOW_EDIT("Heads up! Your service workflow has been updated!"),
	SERVICEFLOW_PROCESS_HEADER("Service Flow Processes"),
	SERVICE_GROUP_CONFIG("Heads up! Service Group Configurations Updated Successfully"),
	SHIPPING_LABEL_CONFIG_ADD("Heads up! Shipping Label Configuration created successfully."),
	SHIPPNG_LABEL_CONFIG_EDIT("Heads up! Shipping Label Configuration updated successfully."),
	ORDER_NOTFOUND("Heads up! No Results Found"),
	USER_SAVE("Heads up! User Details Successfully Saved"),
	ROLE_SAVE("Heads up! Role successfully created!"), 
	USER_FOUND("1 User Found"), 
	ROLE_ADD_HEADER("Add Role"),
	ROLE_SUMMARY_HEADER("Manage Roles"),
	USER_NOTFOUND("Heads up! No Users Found"),
	USER_EDIT("Heads up! User Details Successfully Saved"),
	USER_DELETE("Heads up! User Successfully Deleted"),
	USER_VALIDATION("Oh snap! Please check your form for validation errors"),
	ROLE_EDIT("Heads up! Role successfully updated!"),
	ROLE_VALIDATION("Heads up! Please ensure you have selected at least one permission."),
	ROLE_DELETE("Heads up! Role successfully deleted!");	

	private String updateMsg;

	RomuiEnumValues(String updateMsg) {
		this.updateMsg = updateMsg;
	}

	public String getMessage() {
		return updateMsg;
	}
}
