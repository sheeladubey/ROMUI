package com.gsicommerce.romui.selenium.pages.common;

import org.openqa.selenium.WebDriver;
import com.gsicommerce.romui.selenium.pages.HomePage;
import com.gsicommerce.romui.selenium.pages.LoginPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.AvailabilitySearchPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.CommonElementsPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.ISPUPickPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.InventoryAuditsPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.InventoryOrganizationPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.ATPRulesPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.InventorySearchPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.ItemSearchPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.NodeCalendarsPage;
//import com.gsicommerce.romui.selenium.pages.ordermanagement.OrderCreatePage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.OrderManagementMenusPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.OrdersPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.PaymentMethodConfigPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.PipelinesPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.SFSPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.SafetyStockConfigsPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.SellerConfigurationsPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.ServiceGroupConfigsPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.ShippingLabelConfigPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.ShippingRegionGroupsPage;
import com.gsicommerce.romui.selenium.pages.ordermanagement.StoreFulfillmentDashboardPage;
import com.gsicommerce.romui.selenium.testdata.Environment;

public class ROMUIPageFactory extends PageFactory {

	private final LoginPage loginPage;
	private final HomePage homePage;
	private final OrderManagementMenusPage ordMgmPage;
	private final PaymentMethodConfigPage paymtMethdConfigPage;
	private final CommonElementsPage commonElePage;
	private final ServiceGroupConfigsPage serviceGrpConfigPage;
	private final StoreFulfillmentDashboardPage storeFulflmtDashbrdPage;
	private final ISPUPickPage ispuPickPage;
	private final SFSPage sfsPage;
	private final ItemSearchPage itemSearchPage;
	private final InventorySearchPage inventorySearchPage;
	private final InventoryAuditsPage inventoryAuditsPage;
	private final AvailabilitySearchPage availbltySearchPage;
	private final ShippingRegionGroupsPage shippngRegionGrpPage;
	private final PipelinesPage pipeLinesPage;
	private final OrdersPage ordersPage;
	private final ShippingLabelConfigPage shipLbleConfigPage;
	private final SellerConfigurationsPage sellerConfigurationsPage;
	private final ATPRulesPage atpRulesPage;
	private final SafetyStockConfigsPage safetyStockConfigsPage;
	private final InventoryOrganizationPage inventoryOrganizationPage;
	// private final OrderCreatePage orderCreatePage;
	private final NodeCalendarsPage nodeCalendarsPage;

	public ROMUIPageFactory(WebDriver driver, Environment env) {
		super(driver, env);
		loginPage = new LoginPage(driver, env);
		homePage = new HomePage(driver, env);
		ordMgmPage = new OrderManagementMenusPage(driver, env);
		paymtMethdConfigPage = new PaymentMethodConfigPage(driver, env);
		commonElePage = new CommonElementsPage(driver, env);
		serviceGrpConfigPage = new ServiceGroupConfigsPage(driver, env);
		storeFulflmtDashbrdPage = new StoreFulfillmentDashboardPage(driver, env);
		ispuPickPage = new ISPUPickPage(driver, env);
		sfsPage = new SFSPage(driver, env);
		itemSearchPage = new ItemSearchPage(driver, env);
		inventorySearchPage = new InventorySearchPage(driver, env);
		inventoryAuditsPage = new InventoryAuditsPage(driver, env);
		availbltySearchPage = new AvailabilitySearchPage(driver, env);
		shippngRegionGrpPage = new ShippingRegionGroupsPage(driver, env);
		pipeLinesPage = new PipelinesPage(driver, env);
		shipLbleConfigPage = new ShippingLabelConfigPage(driver, env);
		ordersPage = new OrdersPage(driver, env);
		sellerConfigurationsPage = new SellerConfigurationsPage(driver, env);
		atpRulesPage = new ATPRulesPage(driver, env);
		safetyStockConfigsPage = new SafetyStockConfigsPage(driver, env);
		inventoryOrganizationPage = new InventoryOrganizationPage(driver, env);
		// orderCreatePage = new OrderCreatePage(driver, env);
		nodeCalendarsPage = new NodeCalendarsPage(driver, env);
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

	public ServiceGroupConfigsPage serviceGrpConfigPage() {
		return serviceGrpConfigPage;
	}

	public StoreFulfillmentDashboardPage storeFulflmtDashbrdPage() {
		return storeFulflmtDashbrdPage;
	}

	public ISPUPickPage ispuPickPage() {
		return ispuPickPage;
	}

	public SFSPage sfsPage() {
		return sfsPage;
	}

	public ItemSearchPage itemSearchPage() {
		return itemSearchPage;
	}

	public InventorySearchPage inventorySearchPage() {
		return inventorySearchPage;
	}

	public InventoryAuditsPage inventoryAuditsPage() {
		return inventoryAuditsPage;
	}

	public AvailabilitySearchPage availbltySearchPage() {
		return availbltySearchPage;
	}

	public ShippingRegionGroupsPage shippngRegionGrpPage() {
		return shippngRegionGrpPage;
	}

	public PipelinesPage pipeLinesPage() {
		return pipeLinesPage;
	}

	public ShippingLabelConfigPage shipLbleConfigPage() {

		return shipLbleConfigPage;
	}

	public OrdersPage ordersPage() {
		return ordersPage;
	}

	public SellerConfigurationsPage sellerConfigurationsPage() {
		return sellerConfigurationsPage;
	}

	public ATPRulesPage atpRulesPage() {

		return atpRulesPage;
	}

	public SafetyStockConfigsPage safetyStockConfigsPage() {

		return safetyStockConfigsPage;
	}

	public InventoryOrganizationPage inventoryOrganizationPage() {

		return inventoryOrganizationPage;
	}

	/*
	 * public OrderCreatePage orderCreatePage() {
	 * 
	 * return orderCreatePage; }
	 */

	public NodeCalendarsPage nodeCalendarsPage() {

		return nodeCalendarsPage;
	}
}
