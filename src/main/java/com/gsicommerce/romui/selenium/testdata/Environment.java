package com.gsicommerce.romui.selenium.testdata;

import org.testng.ITestContext;

import com.gsicommerce.romui.selenium.utilities.Common;

public class Environment {
	private final ITestContext context;

	protected Environment(final ITestContext context) {
		this.context = context;
	}

	public static Environment getInstance(final ITestContext context) {
		return new Environment(context);
	}
	public String getBrowserType() {
		return getParam("browserType");
	}
	public String getStoreEnvironment() {
		return getParam("storeEnvironment");
	}
	public String getUserName() {
		return getParam("adminUserName");
	}
	public String getPassword() {
		return getParam("adminPasswd");
	}
	public String getFileLocation() {
		return getParam("dataFile");
	}
	public Integer getWaitPeriod() {
		try {
			return Common.convertStringToInt(getParam("waitPeriod"));
		} catch (final Exception e) {
			return 20;
		}
	}
	public String getRemoteUrl() {
		return getParam("remoteUrl");
	}
	protected String getParam(final String key) {
		String valueCandidate = System.getProperty(key);
		if (valueCandidate != null) {
			return valueCandidate;
		} else if ((valueCandidate = System.getenv(key)) != null) {
			return valueCandidate;
		} else if ((valueCandidate = System.getenv("TESTNG_" + key)) != null) {
			return valueCandidate;
		} else if ((valueCandidate = context.getCurrentXmlTest().getParameter(
				key)) != null) {
			return valueCandidate;
		} else {
			return context.getSuite().getParameter(key);
		}
	}

	public String getStoreId() {
		return getParam("storeID");
	}
	
	public String getSellerId() {
		return getParam("sellerID");
	}
}
