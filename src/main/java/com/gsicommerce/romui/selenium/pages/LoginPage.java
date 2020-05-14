package com.gsicommerce.romui.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Common;

public class LoginPage {

	WebDriver driver;
	Environment env;
	
	public LoginPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using ="#login_form_user_id")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(how=How.CSS, using="#login_form_password")
	@CacheLookup
	WebElement txtPasswd;
	
	@FindBy(how=How.CSS, using="[name='button']")
	@CacheLookup
	WebElement btnSingIn;
	
	public void login(String username, String passwd) {		
		Common.waitForElement(driver, txtUserName, 2);		
		txtUserName.sendKeys(username);
		txtPasswd.sendKeys(passwd);
		btnSingIn.click();		
	}

}
