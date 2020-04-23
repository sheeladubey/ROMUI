package com.gsicommerce.romui.selenium.ROMUI.Pages.Common;

import org.openqa.selenium.WebDriver;
import com.gsicommerce.romui.selenium.ROMUI.TestData.Environment;

public class PageFactory {

	private WebDriver driver;
	private Environment env;
	public PageFactory(WebDriver driver, Environment env) {
		driver = this.driver;
		env = this.env;
		
	}
	
	public static ROMUIPageFactory getROMUIPages(WebDriver driver,
			Environment env) {

		return new ROMUIPageFactory(driver, env);
	}
}
