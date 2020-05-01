package com.gsicommerce.romui.selenium.pages.common;

import org.openqa.selenium.WebDriver;
import com.gsicommerce.romui.selenium.pages.HomePage;
import com.gsicommerce.romui.selenium.pages.LoginPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.CommonElementsPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.OrderManagementMenusPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.PaymentMethodConfigPage;
import com.gsicommerce.romui.selenium.testdata.Environment;

public class ROMUIPageFactory extends PageFactory{

	private final LoginPage loginPage;
	private final HomePage homePage;
	private final OrderManagementMenusPage ordMgmPage;
	private final PaymentMethodConfigPage paymtMethdConfigPage;
	private final CommonElementsPage commonElePage;
	public ROMUIPageFactory(WebDriver driver, Environment env) {
		super(driver, env);
		loginPage = new LoginPage(driver, env);
		homePage = new HomePage(driver, env);
		ordMgmPage = new OrderManagementMenusPage(driver,env);
		paymtMethdConfigPage = new PaymentMethodConfigPage(driver, env);
		commonElePage = new CommonElementsPage(driver, env);
	}
	public LoginPage loginPage() {
		return loginPage;
	}
	public HomePage homePage() {
		return homePage;
	}
	public OrderManagementMenusPage orderMgmPage() {
		return ordMgmPage;
	}
	public PaymentMethodConfigPage paymtMethdConfigPage() {
		return paymtMethdConfigPage;
	}
	public CommonElementsPage commonElePage() {
		return commonElePage;
	}
}
