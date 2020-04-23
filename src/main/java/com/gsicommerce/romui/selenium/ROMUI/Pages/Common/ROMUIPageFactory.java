package com.gsicommerce.romui.selenium.ROMUI.Pages.Common;

import org.openqa.selenium.WebDriver;

import com.gsicommerce.romui.selenium.ROMUI.Pages.HomePage;
import com.gsicommerce.romui.selenium.ROMUI.Pages.LoginPage;
import com.gsicommerce.romui.selenium.ROMUI.Pages.ordermanagement.OrderManagementMenusPage;
import com.gsicommerce.romui.selenium.ROMUI.TestData.Environment;

public class ROMUIPageFactory extends PageFactory{

	private final LoginPage loginPage;
	private final HomePage homePage;
	private final OrderManagementMenusPage ordMgmPage;
	public ROMUIPageFactory(WebDriver driver, Environment env) {
		super(driver, env);
		loginPage = new LoginPage(driver, env);
		homePage = new HomePage(driver, env);
		ordMgmPage = new OrderManagementMenusPage(driver,env);
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

}
