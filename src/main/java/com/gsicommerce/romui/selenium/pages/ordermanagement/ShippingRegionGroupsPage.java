package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.RegionConfigurationData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class ShippingRegionGroupsPage {

	WebDriver driver;
	Environment env;
	Action action;

	public ShippingRegionGroupsPage(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);

	}

	@FindBy(how = How.CSS, using = "[href*='new']")
	private WebElement btnAddNew;

	@FindBy(how = How.CSS, using = "[type='submit'] span")
	private List<WebElement> btnSave;

	@FindBy(how = How.CSS, using = "#region_group_name")
	private WebElement txtRegionGrpName;

	@FindBy(how = How.CSS, using = "#region_group_description")
	private WebElement txtRegionGrpDescrp;

	@FindBy(how = How.CSS, using = "#region_name")
	private WebElement txtRegionName;

	@FindBy(how = How.CSS, using = "[type='checkbox'][name='region[shipping_method_optimization_eligible]']")
	private WebElement chkboxShipMethdOptimztionsEligible;

	@FindBy(how = How.CSS, using = "#region_region_composite_attributes_region_level_name")
	private WebElement drpdwnRegionalLevelName;

	@FindBy(how = How.CSS, using = "#region_region_composite_attributes_country_code")
	private WebElement drpdwnCountry;

	@FindBy(how = How.CSS, using = "#region_region_composite_attributes_main_div_code")
	private WebElement txtState;

	@FindBy(how = How.CSS, using = "#region_region_composite_attributes_postal_code_low")
	private WebElement txtPostalCodeLow;

	@FindBy(how = How.CSS, using = "#region_region_composite_attributes_postal_code_high")
	private WebElement txtPostalCodeHigh;

	@FindBy(how = How.CSS, using = "[data-region-index='1'][type='button']")
	private WebElement btnRegionsAvailableAdd;

	@FindBy(how = How.CSS, using = ".radial-app-header__user-name")
	private static WebElement btnStore;

	public void addShippingRegionGroups(RegionConfigurationData data, String regionGrpName)
			throws InterruptedException {
		Action.waitForElementToBeClickable(driver, btnAddNew, 30);
		btnAddNew.click();
		CommonElementsPage.clickOnSaveBtn();
		Assert.assertEquals(CommonElementsPage.txtAlertErrorMsg.getText(),
				RomuiEnumValues.SHIPPINGREGIONGRPFORM_ERROR.getMessage(),
				"No error message displayed for blank region mandatory fields");
		Action.enter(txtRegionGrpName, regionGrpName);
		Action.enter(txtRegionGrpDescrp, data.getRegionGrpDescrp());
		Action.scrollToBottomofPage();
		btnAddNew.click();
		Action.enter(txtRegionName, data.getRegionName());
		chkboxShipMethdOptimztionsEligible.click();
		Action.selectByVisibleText(drpdwnRegionalLevelName, data.getRegionLevelName());
		Action.selectByVisibleText(drpdwnCountry, data.getCountry());
		if (data.getRegionLevelName().equals("Main Div Code")) {
			Action.enter(txtState, data.getState());
		} else if (data.getRegionLevelName().equals("Postal Code")) {
			Action.enter(txtPostalCodeLow, data.getPostalCodeLow());
			Action.enter(txtPostalCodeHigh, data.getPostalCodeHigh());
		}
		btnSave.get(1).click();
		WebElement addRegionAvail = driver
				.findElement(By.cssSelector(".region-item-btn[data-region-name='" + data.getRegionName() + "']"));
		Action.scrollToElementofPage(addRegionAvail);
		Action.scrollDown("-100");
		Thread.sleep(6000);
		try {
			addRegionAvail.click();
		} catch (Exception e) {
			addRegionAvail = driver
					.findElement(By.cssSelector(".region-item-btn[data-region-name='" + data.getRegionName() + "']"));
			Action.scrollToElementofPage(addRegionAvail);
			Action.scrollDown("-100");
			addRegionAvail.click();
		}
		CommonElementsPage.clickOnSaveBtn();
	}

	public void editShippingRegionGroups(RegionConfigurationData data, String regionGrpName) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(regionGrpName,1);
		Action.scrollToBottomofPage();
		CommonElementsPage.clickActionsSpanIcon(rowNo, 5, 0);
		driver.findElements(
				By.cssSelector("[data-region-remove-btn=''][data-region-name='" + data.getRegionName() + "']")).get(1)
				.click();
		btnRegionsAvailableAdd.click();
		CommonElementsPage.clickOnSaveBtn();
	}

	public void deleteShippingRegionGroups(RegionConfigurationData data, String regionGrpName) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(regionGrpName,1);
		Action.scrollToBottomofPage();
		CommonElementsPage.clickActionsSpanIcon(rowNo, 5, 1);
		CommonElementsPage.clickOnSearchBtn();
	}

	public void addShippingRegion(RegionConfigurationData data, String regionName) throws InterruptedException {
		Action.waitForElementToBeClickable(driver, btnAddNew, 30);
		btnAddNew.click();
		CommonElementsPage.clickOnSaveBtn();
		Assert.assertEquals(CommonElementsPage.txtAlertErrorMsg.getText(),
				RomuiEnumValues.SHIPPINGREGIONFORM_ERROR.getMessage(),
				"No error message displayed for blank region mandatory fields");
		Action.enter(txtRegionName, regionName);
		chkboxShipMethdOptimztionsEligible.click();
		Action.selectByVisibleText(drpdwnRegionalLevelName, data.getRegionLevelName());
		Action.selectByVisibleText(drpdwnCountry, data.getCountry());
		if (data.getRegionLevelName().equals("Main Div Code")) {
			Action.enter(txtState, data.getState());
		} else if (data.getRegionLevelName().equals("Postal Code")) {
			Action.enter(txtPostalCodeLow, data.getPostalCodeLow());
			Action.enter(txtPostalCodeHigh, data.getPostalCodeHigh());
		}
		CommonElementsPage.clickOnSaveBtn();
	}

	public void editShippingRegion(RegionConfigurationData data, String regionName) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(regionName,1);
		WebElement element = driver.findElement(By.cssSelector("[data-lookup-id='" + regionName + "']"));
		Action.scrollToElementofPage(element);
		Action.scrollDown("-150");
		CommonElementsPage.clickActionsSpanIcon(rowNo, 3, 0);
		Action.selectByVisibleText(drpdwnRegionalLevelName, "Country Code");
		CommonElementsPage.clickOnSaveBtn();
	}

	public void deleteShippingRegion(RegionConfigurationData data, String regionName) throws Exception {
		int rowNo = CommonElementsPage.getRowNo(regionName,1);
		WebElement element = driver.findElement(By.cssSelector("[data-lookup-id='" + regionName + "']"));
		Action.scrollToElementofPage(element);
		Action.scrollDown("-150");
		CommonElementsPage.clickActionsSpanIcon(rowNo, 3, 1);
		CommonElementsPage.clickOnSearchBtn();
	}
}
