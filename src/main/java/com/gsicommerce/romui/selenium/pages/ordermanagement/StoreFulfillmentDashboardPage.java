package com.gsicommerce.romui.selenium.pages.ordermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Action;

public class StoreFulfillmentDashboardPage {

	WebDriver driver;
	Environment env;
	Action action;

	public StoreFulfillmentDashboardPage(WebDriver driver, Environment env) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);

	}

	@FindBy(how = How.CSS, using = "[href*='STORE_PICK_UP&type=WAITING_FOR_PICK']")
	@CacheLookup
	private WebElement lkISPUWaitingForPick;

	@FindBy(how = How.CSS, using = "[href*='WAITING_FOR_CUSTOMER_PICK']")
	@CacheLookup
	private WebElement lkISPUCustomerPickup;

	@FindBy(how = How.CSS, using = "[href*='SHIP_TO_HOME&type=WAITING_FOR_PICK']")
	@CacheLookup
	private WebElement lkSFSWaitingForPick;

	@FindBy(how = How.CSS, using = "[href*='SHIP_TO_HOME&type=WAITING_FOR_PACK']")
	@CacheLookup
	private WebElement lkSFSWaitingForPack;

	@FindBy(how = How.CSS, using = "[href*='WAITING_FOR_CHECKIN']")
	@CacheLookup
	private WebElement lkSTSCheckIn;

	@FindBy(how = How.CSS, using = "[href*='WAITING_FOR_INSTORE_CHECKIN']")
	@CacheLookup
	private WebElement lkSTSInStoreCheckIn;

	@FindBy(how = How.CSS, using = "[href*='ASSOCIATE_DELIVERY&type=WAITING_FOR_PICK']")
	@CacheLookup
	private WebElement lkADWaitingForPick;

	@FindBy(how = How.CSS, using = "[href*='ASSOCIATE_DELIVERY&type=WAITING_FOR_PACK']")
	@CacheLookup
	private WebElement lkADWaitingForPack;

	@FindBy(how = How.CSS, using = "[href*='ASSOCIATE_DELIVERY&type=WAITING_FOR_DELIVERY']")
	@CacheLookup
	private WebElement lkADWaitingForDelivery;

	@FindBy(how = How.CSS, using = "[href*='putaways']")
	@CacheLookup
	private WebElement lkOPPutaway;

	@FindBy(how = How.CSS, using = "[href*='pick_tickets']")
	@CacheLookup
	private WebElement lkOPPickTicketSummry;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Order Search')]")
	@CacheLookup
	private WebElement lkOPOrderSearch;

	@FindBy(how = How.CSS, using = "[href*='reprint_documents']")
	@CacheLookup
	private WebElement lkOPReprintDoc;

	@FindBy(how = How.CSS, using = "[href*='order_exceptions']")
	@CacheLookup
	private WebElement lkOPOrderExceptn;

	@FindBy(how = How.CSS, using = "[href*='return_orders']")
	@CacheLookup
	private WebElement lkOPReturnItems;

	public void navigateToISPUPick() throws Exception {
		Reporter.log("Click on ISPU Pick Icon");
		lkISPUWaitingForPick.click();
	}

	public void navigateToOrderSearch() throws Exception {
		Reporter.log("Click on Order Search");
		lkOPOrderSearch.click();
	}

	public void navigateToISPUCustPickup() throws Exception {
		Reporter.log("Click on ISPU Customer Pickup Icon");
		lkISPUCustomerPickup.click();
	}

	public void navigateToSFSPick() throws Exception {
		Reporter.log("Click on SFS Pick Icon");
		lkSFSWaitingForPick.click();
	}

	public void navigateToSFSPack() throws Exception {
		Reporter.log("Click on SFS Pack Icon");
		lkSFSWaitingForPack.click();
	}
	
	public void navigateToReturnItems() throws Exception {
		Reporter.log("Click on Return items Icon");
		lkOPReturnItems.click();
	}


}
