package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Action;

public class OrderManagementMenusPage {
	WebDriver driver;
	Environment env;
	Action action;
	public OrderManagementMenusPage(WebDriver driver, Environment env) {
		// TODO Auto-generated constructor stub	
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);		
	}
	@FindBy(how=How.CSS, using ="[data-tooltip='Main Menu']")
	@CacheLookup
	WebElement btnMainMenu;
	
	@FindBy(how = How.XPATH, using = "//i/parent::a[contains(text(),'Catalog & Inventory')]")
	@CacheLookup
	WebElement lkCatalogInventory;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Orders')]")
	@CacheLookup
	WebElement lkOrders;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Pipelines')]")
	@CacheLookup
	WebElement lkPipeline;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Service Flows')]")
	@CacheLookup
	WebElement lkServiceFlows;
	
	@FindBy(how = How.XPATH, using = "//i/parent::a[contains(text(),'Fulfillment')]")
	@CacheLookup
	WebElement lkFulfillment;
	
	@FindBy(how = How.XPATH, using = "//i/parent::a[contains(text(),'Reporting Dashboard')]")
	@CacheLookup
	WebElement lkReportingDashboard;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Omni Administration')]")
	@CacheLookup
	WebElement lkOmniAdministration;
	
	@FindBy(how = How.XPATH, using = "//i/parent::a[contains(text(),'Help Documentation')]")
	@CacheLookup
	WebElement lkHelpDocumentation;
	
	@FindBy(how = How.XPATH, using = "//i/parent::a[contains(text(),'Release Notes')]")
	@CacheLookup
	WebElement lkReleaseNotes;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Item Search')]")
	@CacheLookup
	WebElement lkItemSearch;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Inventory Search')]")
	@CacheLookup
	WebElement lkInvSearch;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Inventory Audits')]")
	@CacheLookup
	WebElement lkInvAudits;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Availability Search')]")
	@CacheLookup
	WebElement lkAvlSearch;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Store Fulfillment')]")
	@CacheLookup
	WebElement lkStoreFulfillment;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Omnichannel Fulfillment Dashboard')]")
	@CacheLookup
	WebElement lkOmniFulfilDashboard;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Store Fulfillment Dashboard')]")
	@CacheLookup
	WebElement lkStoreFulfilDashboard;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'User Management')]")
	@CacheLookup
	WebElement lkUserMgmt;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Users')]")
	@CacheLookup
	WebElement lkUsers;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Roles')]")
	@CacheLookup
	WebElement lkRoles;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Inventory Availability')]")
	@CacheLookup
	WebElement lkInvAvailability;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'ATP Rules')]")
	@CacheLookup
	WebElement lkATPRules;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Safety Stock Configuration')]")
	@CacheLookup
	WebElement lkSafetyStckConfig;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Order Line Sourcing Rules')]")
	@CacheLookup
	WebElement lkOrderLnSourngRules;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Core Rules')]")
	@CacheLookup
	WebElement lkCoreRules;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Seller Rules')]")
	@CacheLookup
	WebElement lkSellerRules;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Region Configuration')]")
	@CacheLookup
	WebElement lkRegionConfig;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Shipping Region Groups')]")
	@CacheLookup
	WebElement lkShipngRegionGrps;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Shipping Regions')]")
	@CacheLookup
	WebElement lkShipngRegions;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Seller Configurations')]")
	@CacheLookup
	WebElement lkSellerConfig;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Payment Method Configurations')]")
	@CacheLookup
	WebElement lkPaymtMethdConfig;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Seller')]")
	@CacheLookup
	WebElement lkSeller;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Service Group Configs')]")
	@CacheLookup
	WebElement lkServiceGrpConfig;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Ship Method Optimizations')]")
	@CacheLookup
	WebElement lkShipMthdOptimztions;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Shipping Label Configurations')]")
	@CacheLookup
	WebElement lkShipngLabelConfig;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Inventory Organization')]")
	@CacheLookup
	WebElement lkInvOrgzation;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Fulfillment Node')]")
	@CacheLookup
	WebElement lkFulfillmntNode;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Fulfillment Node Group')]")
	@CacheLookup
	WebElement lkFulfillmntNodeGrp;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Node Calendars')]")
	@CacheLookup
	WebElement lkNodeCaldrs;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Fulfillment Node Item')]")
	@CacheLookup
	WebElement lkFulfillmntNodeItem;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Print Documents')]")
	@CacheLookup
	WebElement lkPrintDocs;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Configure Order Queues')]")
	@CacheLookup
	WebElement lkConfigOrderQueues;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Manage Store Messages')]")
	@CacheLookup
	WebElement lkMngStoreMsgs;
	
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Reason Codes')]")
	@CacheLookup
	WebElement lkReasonCodes;
	
	@FindBy(how=How.CLASS_NAME,using="radial-app-header__user")
	@CacheLookup
	WebElement btnStore;
	
	@FindBy(how=How.ID,using="client_store_search")
	@CacheLookup
	WebElement txtStoreSearch;
	
	@FindBy(how=How.CLASS_NAME,using="btn-default btn-search")
	//@FindBy(how=How.CLASS_NAME,using="context-tree-action")
	//span[contains(text(),'Filter')]
	@CacheLookup
	WebElement btnStoreSearchClick;
	
	//@FindBy(how=How.XPATH,using="//button[@type='submit']")
	@FindBy(how=How.CLASS_NAME,using=".context-tree-action")
	@CacheLookup
	List<WebElement> lkStoreList;
	
	
	public void clickOnItemSearch() {
		btnMainMenu.click();
		lkCatalogInventory.click();
		lkItemSearch.click();
	}
	
	public void clickOnInventorySearch() {
		btnMainMenu.click();
		lkCatalogInventory.click();
		lkInvSearch.click();
	}
	public void clickOnInventoryAudits() {
		btnMainMenu.click();
		lkCatalogInventory.click();
		lkInvAudits.click();
	}
	public void clickOnAvailabilitySearch() {
		btnMainMenu.click();
		lkCatalogInventory.click();
		lkAvlSearch.click();
	}
	public void clickOnOrders() {
		btnMainMenu.click();
		Action.waitForElementToBeClickable(driver, lkOrders, 10);
		lkOrders.click();
	}
	
	
	public void clickOnStoreFulfillment() {
		btnMainMenu.click();
		lkFulfillment.click();
		lkStoreFulfillment.click();
	}
	
	public void clickOnOmniChnlFulfmtDashboard() {
		btnMainMenu.click();
		lkReportingDashboard.click();
		lkOmniFulfilDashboard.click();
	}
	
	public void clickOnStoreFulfmtDashboard() {
		btnMainMenu.click();
		lkReportingDashboard.click();
		lkStoreFulfilDashboard.click();
	}
	
	public void clickOnUsers() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkUserMgmt.click();
		lkUsers.click();
	}
	
	public void clickOnRoles() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkUserMgmt.click();
		lkRoles.click();
	}
	
	public void clickOnATPRules() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkInvAvailability.click();
		lkATPRules.click();		
	}
	
	public void clickOnSafetyStockConfig() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkInvAvailability.click();
		lkSafetyStckConfig.click();		
	}
	
	public void clickOnCoreRules() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkOrderLnSourngRules.click();
		lkCoreRules.click();		
	}
	
	public void clickOnSellerRules() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkOrderLnSourngRules.click();
		lkSellerRules.click();		
	}
	
	public void clickOnShippingRegionGrps() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkRegionConfig.click();
		lkShipngRegionGrps.click();		
	}
	
	public void clickOnShippingRegions() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkRegionConfig.click();
		lkShipngRegions.click();		
	}
	
	public void clickOnPaymtMethdConfig() {
		btnMainMenu.click();
		Action.waitForElementToBeClickable(driver, lkOmniAdministration, 10);
		lkOmniAdministration.click();
		Action.waitForElementToBeClickable(driver, lkSellerConfig, 10);
		lkSellerConfig.click();
		Action.waitForElementToBeClickable(driver, lkPaymtMethdConfig, 10);
		lkPaymtMethdConfig.click();		
	}
	
	public void clickOnSeller() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkSellerConfig.click();
		lkSeller.click();		
	}
	
	public void clickOnServiceGrpConfig() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkSellerConfig.click();
		lkServiceGrpConfig.click();		
	}
	
	public void clickOnShipMethdOptimztions() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkSellerConfig.click();
		lkShipMthdOptimztions.click();		
	}
	
	public void clickOnShippingLabelConfig() {
		btnMainMenu.click();
		Action.waitForElementToBeClickable(driver, lkOmniAdministration, 10);
		lkOmniAdministration.click();
		Action.waitForElementToBeClickable(driver, lkSellerConfig,10);
		lkSellerConfig.click();
		Action.waitForElementToBeClickable(driver, lkShipngLabelConfig,10);
		lkShipngLabelConfig.click();		
	}
	
	public void clickOnInvOrganization() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkInvOrgzation.click();
	}

	public void clickOnFulfillmentNode() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkFulfillmntNode.click();
	}
	
	public void clickOnFulfillmentNodeGrp() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkFulfillmntNodeGrp.click();
	}
	
	public void clickOnNodeCalendars() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkNodeCaldrs.click();
	}
	
	public void clickOnFulfillmentNodeItem() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkFulfillmntNodeItem.click();
	}
	public void clickOnPrintDocuments() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkPrintDocs.click();
	}
	
	public void clickOnConfigOrderQueues() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkConfigOrderQueues.click();
	}
	
	public void clickOnManageStoreMsgs() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkMngStoreMsgs.click();
	}
	
	public void clickOnReasonCodes() {
		btnMainMenu.click();
		lkOmniAdministration.click();
		lkReasonCodes.click();
	}
	
	public void clickOnHelpDocumentation() {
		btnMainMenu.click();
		lkHelpDocumentation.click();
	}
	
	public void clickOnReleaseNotes() {
		btnMainMenu.click();
		lkReleaseNotes.click();
	}

	public void clickOnPipeline() {
		btnMainMenu.click();
	//selectStore("1008011");
	// btnStoreSearchClick.click();
		Action.waitForElementToBeClickable(driver, lkPipeline, 10);
		lkPipeline.click();
		
	}

	public void clickOnServiceFlows() {
		btnMainMenu.click();
		Action.waitForElementToBeClickable(driver, lkServiceFlows, 10);
		lkServiceFlows.click();
		
	}
	

	//** sheela-Select Store from store list
	public void selectStore(String storeId)
	{
		btnStore.click();
		Action.enter(txtStoreSearch,storeId.substring(0,storeId.length()));
		
		for (int i = 0; i <lkStoreList.size();i++)
		{
			WebElement storeList=lkStoreList.get(i);
			System.out.println("StoreList is:"+storeList);
		{
			if(storeList.getText().equalsIgnoreCase(storeId))
	
				try {
                    Thread.sleep(2000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			
			System.out.println("Store List are" +storeList);
			
			storeList.click();
            break;
	}
	}
	}
	
}
