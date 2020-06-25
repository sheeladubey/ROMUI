package com.gsicommerce.romui.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;

public class LoginPage {

	WebDriver driver;
	Environment env;

	public LoginPage(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "#login_form_user_id")
	@CacheLookup
	WebElement txtUserSSOName;

	@FindBy(how = How.CSS, using = "#login_form_username")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(how = How.CSS, using = "#login_form_password")
	@CacheLookup
	WebElement txtPasswd;

	@FindBy(how = How.CSS, using = "[name='button']")
	@CacheLookup
	WebElement btnSSOSingIn;

	@FindBy(how = How.CSS, using = "[type='submit']")
	@CacheLookup
	WebElement btnSingIn;

	@FindBy(how = How.CSS, using = ".radial-app-header__user-name")
	private static WebElement btnStore;

	@FindBy(how = How.CSS, using = "#client_store_search")
	private static WebElement txtbxStoreSearch;

	@FindBy(how = How.CSS, using = "span.input-group-btn .btn-default")
	private static WebElement btnStoreSearch;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	// @FindBy(how = How.CSS, using = "button.context-tree-action[type='submit']")
	// @FindBy(how = How.CSS, using = ".context-tree-action")
	private static List<WebElement> lststorelist;

	@FindBy(how = How.CSS, using = "a.radial-app-user-menu__item[href='/en/session/destroy']")
	private static List<WebElement> btnsignout;

	public void login(String username, String passwd) {
		Common.waitForElement(driver, txtUserName, 2);
		txtUserName.sendKeys(username);
		txtPasswd.sendKeys(passwd);
		// btnSingIn.click();
		Action.clickUsingJavaScipt(btnSingIn);
		//selectStore(env.getSellerId(), env.getStoreId());
	}

	public void selectStore(String sellerid, String storeId) {
		try {
			// btnStore.click();
			Action.clickUsingJavaScipt(btnStore);
			Action.waitForElementToBeClickable(driver, txtbxStoreSearch, 30);
			Action.enter(txtbxStoreSearch, storeId);
			List<WebElement> storeList = driver.findElements(By.xpath("//button[contains(text(),'" + storeId + "')]"));
			int size = lststorelist.size();
			for (int i = 0; i < size; i++) {

				if (lststorelist.get(i).getText().contains(sellerid)) {
					//storeList.get(i - 1).click();
					Action.clickUsingJavaScipt(storeList.get(i - 1));
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickSignout() {
		Action.clickUsingJavaScipt(btnStore);
		// btnStore.click();
		btnsignout.get(1).click();

	}

}
