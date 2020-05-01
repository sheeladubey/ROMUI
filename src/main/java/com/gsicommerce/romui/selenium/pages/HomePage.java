package com.gsicommerce.romui.selenium.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;

public class HomePage{
	WebDriver driver;
	Environment env;
	Action action;	
	public HomePage(WebDriver driver, Environment env) {
		// TODO Auto-generated constructor stub	
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);
		
	}
	@FindBy(how=How.CSS, using ="p.landing-tile-text")
	@CacheLookup
	List<WebElement> btnLanding;
	
	public void clickOnLandingButton(String name) {
		Common.waitForListElementsPresent(driver, btnLanding, 5);
		Iterator<WebElement> iter = btnLanding.iterator();
		while(iter.hasNext()) {
			WebElement ele = iter.next();
			System.out.println("List of items:"+ele.getText());
			if(ele.getText().contains(name)) {
				ele.click();
				break;
			}
		}
		
	}
}
