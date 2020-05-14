package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gsicommerce.romui.selenium.testdata.Environment;
//import com.gsicommerce.romui.selenium.testdata.ShippingLabelConfigData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;

public class OrdersPage {
	
	WebDriver driver;
	Environment env;
	Action action;
	//private OrdersData ordersdata;

	public OrdersPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);
	}
	
	@FindBy(how = How.CSS, using="#order_search_form_search_type")
	@CacheLookup
	private WebElement drpdwnOrderSearchBy;
	
	@FindBy(how = How.CSS, using="#order_search_form_display_id")
	@CacheLookup
	private WebElement txtOrderNumber;
	
	@FindBy(how = How.CSS, using="#order_search_form_fulfillment_order_id")
	@CacheLookup
	private WebElement txtFulfillmentOrderNumber;
	
	@FindBy(how= How.XPATH,using="//button[@class='btn btn-default'][contains(text(),'Search')]")
	@CacheLookup
	private WebElement btnSearchOrder;
	
	@FindBy(how= How.XPATH,using="//button[@class='btn btn-default btn-block'][contains(text(),'Edit Search')]")
	@CacheLookup
	private WebElement btnEditSearchOrder;
	
	@FindBy(how= How.XPATH,using=".//option")
	@CacheLookup
	private List<WebElement> OrderSearchSelectDropDownOption;
	
	@FindBy(how = How.CSS, using="#order_search_form_first_name")
	@CacheLookup
	private WebElement txtCustomerFirstName;
	
	@FindBy(how = How.CSS, using="#order_search_form_last_name")
	@CacheLookup
	private WebElement txtCustomerLastName;
	
	@FindBy(how = How.CSS, using="#order_search_form_start_date")
	@CacheLookup
	private WebElement txtorderSearchStartDate;
	
	@FindBy(how = How.CSS, using="#order_search_form_end_date")
	@CacheLookup
	private WebElement txtorderSearchEndDate;
	
	@FindBy(how = How.CSS, using="#order_search_form_email")
	@CacheLookup
	private WebElement txtorderSearchEmail;		
	
	@FindBy(how = How.XPATH, using="//table[@class='reflow-table']")
	@CacheLookup
	private List<WebElement> tblOrder;
	
			
	@FindBy(how = How.XPATH, using="//table[@class='reflow-table']/tbody/tr")
	@CacheLookup
	private List<WebElement> tblOrderRow;
	
	@FindBy(how = How.XPATH, using="//table[@class='reflow-table']/tbody/td")
	@CacheLookup
	private List<WebElement> tblOrderCol;
	
	
	@FindBy(how = How.CSS, using="[data-tooltip='View Order']")
	@CacheLookup
	private WebElement btnViewOrder;
	
	
	
	  public void selectOrderSearchDropdown(String orderSearchOption) {
		  
		  drpdwnOrderSearchBy.click();
		for(int i=0;i<OrderSearchSelectDropDownOption.size();i++) {
			//System.out.println(OrderSearchSelectDropDownOption.get(i).getText());
			 if (OrderSearchSelectDropDownOption.get(i).getText().equals(orderSearchOption)) {				
				 Action.selectByIndex(drpdwnOrderSearchBy,i);
	                break;
		}
	  }
	  }
	  
	  public void searchOrderByOrderNum()  {
	        //select search order type
	        selectOrderSearchDropdown("Order Number");
	        //enter Orderid
	        Action.waitForElementToBeClickable(driver, txtOrderNumber, 10);
	        Action.enter(txtOrderNumber, "0002559330896150");
	        //click search btn
	        btnSearchOrder.click();
	    }
	  
	  public void searchOrderByFulfillOrderNum()  {
		  Action.waitForElementToBeClickable(driver, btnEditSearchOrder, 10);
		  btnEditSearchOrder.click();
	        //select search order type
	        selectOrderSearchDropdown("Fulfillment Order Number");
	        //enter Fullfillment Orderid
	        Action.waitForElementToBeClickable(driver, txtFulfillmentOrderNumber, 10);
	        Action.enter(txtFulfillmentOrderNumber, "0002559330896150");
	        //click search btn
	        btnSearchOrder.click();
	    }
	  
	  public void searchOrderByCustomerName()  {
		 // Action.waitForElementToBeClickable(driver, btnEditSearchOrder, 10);
		 // btnEditSearchOrder.click();
	        //select search order type
	        selectOrderSearchDropdown("Customer Name");
	        //enter Customer Name
	        Action.waitForElementToBeClickable(driver, txtCustomerFirstName, 10);
	        Action.enter(txtCustomerFirstName, "Richard");
	        Action.enter(txtCustomerLastName, "Doyle");
	        //click search btn
	        btnSearchOrder.click();
	     //   getOrderRow("0002559330896150");
	      //  viewOrderDetails("0002559330896150");
	    }
	  
	  public void searchOrderByEmail()  {
		//  Action.waitForElementToBeClickable(driver, btnEditSearchOrder, 10);
		//  btnEditSearchOrder.click();
	        //select search order type
	        selectOrderSearchDropdown("Email");
	        //enter Email
	        Action.waitForElementToBeClickable(driver, txtorderSearchEmail, 10);
	        Action.enter(txtorderSearchEmail, "RadialNRFCustomer1@gmail.com");
	        //click search btn
	        btnSearchOrder.click();
	    }
	  
	  public void getOrderRow(String orderid)
	  {
		  
	  }
	 
	 }
