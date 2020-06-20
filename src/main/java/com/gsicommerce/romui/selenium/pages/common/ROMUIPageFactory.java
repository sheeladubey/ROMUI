package com.gsicommerce.romui.selenium.pages.common;

import org.openqa.selenium.WebDriver;
import com.gsicommerce.romui.selenium.pages.HomePage;
import com.gsicommerce.romui.selenium.pages.LoginPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.CommonElementsPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.ISPUPickPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.OrderManagementMenusPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.OrdersPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.PaymentMethodConfigPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.PipelinesPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.SellerConfigurationsPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.ServiceFlowPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.ShippingLabelConfigPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.StoreFulfillmentDashboardPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.UserManagementPage;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.pages.ordermanagement.ServiceGroupConfigsPage;

public class ROMUIPageFactory extends PageFactory {

	private final LoginPage loginPage;
	private final HomePage homePage;
	private final OrderManagementMenusPage ordMgmPage;
	private final PaymentMethodConfigPage paymtMethdConfigPage;
	private final CommonElementsPage commonElePage;
	private final PipelinesPage pipeLinesPage;
	private final ShippingLabelConfigPage shipLbleConfigPage;
	private final ServiceFlowPage serviceFlowPage;
	private final OrdersPage ordersPage;
	private final ServiceGroupConfigsPage serviceGrpConfigPage;
	private final StoreFulfillmentDashboardPage storeFulflmtDashbrdPage;
	private final ISPUPickPage ispuPickPage;
	private final UserManagementPage userManagementPage;
	private final SellerConfigurationsPage sellerConfigurationsPage;

	public ROMUIPageFactory(WebDriver driver, Environment env) {
		super(driver, env);
		loginPage = new LoginPage(driver, env);
		homePage = new HomePage(driver, env);
		ordMgmPage = new OrderManagementMenusPage(driver, env);
		paymtMethdConfigPage = new PaymentMethodConfigPage(driver, env);
		commonElePage = new CommonElementsPage(driver, env);
		pipeLinesPage = new PipelinesPage(driver, env);
		shipLbleConfigPage = new ShippingLabelConfigPage(driver, env);
		serviceFlowPage = new ServiceFlowPage(driver, env);
		ordersPage = new OrdersPage(driver, env);
		serviceGrpConfigPage = new ServiceGroupConfigsPage(driver, env);
		storeFulflmtDashbrdPage = new StoreFulfillmentDashboardPage(driver, env);
		ispuPickPage = new ISPUPickPage(driver, env);
		userManagementPage=new UserManagementPage(driver,env);
		sellerConfigurationsPage=new SellerConfigurationsPage(driver,env);

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

	public PipelinesPage pipeLinesPage() {
		return pipeLinesPage;
	}

	public ShippingLabelConfigPage shipLbleConfigPage() {

		return shipLbleConfigPage;
	}

	public ServiceFlowPage serviceFlowPage() {

		return serviceFlowPage;
	}

	public OrdersPage ordersPage() {
		return ordersPage;
	}

	public ServiceGroupConfigsPage serviceGrpConfigPage() {
		return serviceGrpConfigPage;

	}

	public StoreFulfillmentDashboardPage storeFulflmtDashbrdPage() {
		return storeFulflmtDashbrdPage;
	}

	public ISPUPickPage ispuPickPage() {
		return ispuPickPage;
	}

	public UserManagementPage userManagementPage() {
		return userManagementPage;
	}

	public SellerConfigurationsPage sellerConfigurationsPage() {
		return sellerConfigurationsPage;
	}
}
