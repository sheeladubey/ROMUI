package com.gsicommerce.romui.selenium.pages.ordermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Action;

public class ItemSearchPage {
	
	WebDriver driver;
	Environment env;
	Action action;	
	public ItemSearchPage(WebDriver driver, Environment env) {
		// TODO Auto-generated constructor stub	
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);
		
	}
	
	@FindBy(how = How.CSS, using = "#items_item_search_form_query")
	@CacheLookup
	WebElement txtSearch;	
	
	@FindBy(how = How.CSS, using = "[type='submit']")
	@CacheLookup
	WebElement btnSearch;
		
	@FindBy(how = How.CSS, using = "[data-tooltip='Show Advanced Search']")
	@CacheLookup
	WebElement btnAdvanceSearch;
	
	@FindBy(how = How.CSS, using = "#items_item_search_form_client_item_id")
	@CacheLookup
	WebElement txtClientItemID;
	
	@FindBy(how = How.CSS, using = "#items_item_search_form_display_product_id")
	@CacheLookup
	WebElement txtDisProdID;
	
	@FindBy(how = How.CSS, using = "#items_item_search_form_status")
	@CacheLookup
	WebElement dropDownStatus;
	
	@FindBy(how = How.CSS, using = "#items_item_search_form_style_id")
	@CacheLookup
	WebElement txtStyleID;
	
	
	public void searchForItem(String searchterm) {
		txtSearch.clear();
		txtSearch.sendKeys(searchterm);
		btnSearch.click();
		
	}
	

}
