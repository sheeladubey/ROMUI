package com.gsicommerce.romui.selenium.pages.ordermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Action;

public class CommonElementsPage {
	
	WebDriver driver;
	Environment env;
	Action action;	
	public CommonElementsPage(WebDriver driver, Environment env) {
		// TODO Auto-generated constructor stub	
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);
		
	}
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save')]")
	@CacheLookup
	private static WebElement btnSave;	
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Add')]")
	@CacheLookup
	private static WebElement btnAdd;	
		
		
	public static void clickOnSaveBtn() {
		btnSave.click();		
	}
	
	public static void clickOnAddBtn() {
		btnAdd.click();		
	}
	

}
