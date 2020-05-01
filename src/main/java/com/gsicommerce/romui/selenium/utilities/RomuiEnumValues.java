package com.gsicommerce.romui.selenium.utilities;

public enum RomuiEnumValues {
	PAYMENT_METHOD_CONFIG_UPDATE("Heads up! Payment Method Configuration is successfully updated"),
	PAYMENT_METHOD_CONFIG_ADD("Heads up! Payment Method Configuration is successfully created"),
	PAYMENT_METHOD_CONFIG_DELETE("Heads up! Payment Method Configuration is successfully deleted");
	private String updateMsg;
	RomuiEnumValues(String updateMsg){
		this.updateMsg = updateMsg;
	}
	public String getMessage() {
		return updateMsg;
	}
}
