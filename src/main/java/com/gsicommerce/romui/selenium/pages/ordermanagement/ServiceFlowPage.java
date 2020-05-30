package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.ServiceFlowData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class ServiceFlowPage {

	WebDriver driver;
	Environment env;
	Action action;
	private ServiceFlowData data;

	public ServiceFlowPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);
	}

	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Service Flows')]")
	@CacheLookup
	private WebElement lkServiceflow;

	@FindBy(how = How.CSS, using = "#order_orchestration_service_workflow_search_form_type")
	@CacheLookup
	private WebElement drpdwnService;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Search')]")
	@CacheLookup
	private WebElement btnSearch;

	@FindBy(how = How.CSS, using = "[data-tooltip='View Service Flow']")
	@CacheLookup
	private WebElement iconView;

	@FindBy(how = How.CSS, using = "[data-tooltip='Copy Service Flow']")
	@CacheLookup
	private WebElement iconCopy;

	@FindBy(how = How.CSS, using = "[data-tooltip='Edit Service Flow Criteria']")
	@CacheLookup
	private WebElement iconEdit;

	@FindBy(how = How.CSS, using = "[data-tooltip='Edit Service Flow Processes']")
	@CacheLookup
	private WebElement iconEditProcess;

	@FindBy(how = How.CSS, using = "#order_orchestration_service_workflow_service_flow_name")
	@CacheLookup
	private WebElement txtBoxSvcFlwName;

	@FindBy(how = How.CSS, using = "#order_orchestration_service_workflow_service_name")
	@CacheLookup
	private WebElement drpdwnSvcName;

	@FindBy(how = How.CSS, using = "#condition_grouping_start")
	@CacheLookup
	private WebElement drpdwnSvcFlwCriteriaGroupStart;

	@FindBy(how = How.CSS, using = "#condition_grouping_end")
	@CacheLookup
	private WebElement drpdwnSvcFlwCriteriaGroupEnd;

	@FindBy(how = How.CSS, using = "#condition_type")
	@CacheLookup
	private WebElement drpdwnSvcFlwCriteriaType;

	@FindBy(how = How.CSS, using = "#condition_operator")
	@CacheLookup
	private WebElement drpdwnSvcFlwCriteriaOperator;

	@FindBy(how = How.CSS, using = "#condition_value")
	@CacheLookup
	private WebElement drpdwnSvcFlwCriteriaValue;

	/*--------------------------------------------------------------*/

	@FindBy(how = How.CSS, using = ".pipeline-criteria-form-container")
	@CacheLookup
	private WebElement serviceFlowCriteriaFormContainer;

	@FindBy(how = How.XPATH, using = "//div[@class='pipeline-criteria-form-container']//div//span[@class='ss-icon ss-trash']")
	@CacheLookup
	private WebElement btnSvcFlwCriteriaDelete;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'pipeline-criteria-form-container')]//div//span[contains(@class,'ss-icon ss-check')]")
	@CacheLookup
	private WebElement btnSvcFlwCriteriaConfirm;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add Condition')]")
	@CacheLookup
	private WebElement btnAddCondition;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Prepend Condition')]")
	@CacheLookup
	private WebElement btnPrependCondition;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save and Configure Processes')]")
	@CacheLookup
	private WebElement btnSaveConfigProcess;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save & Exit')]")
	@CacheLookup
	private WebElement btnSave;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Edit Service Flow Processes')]")
	@CacheLookup
	private WebElement btnEditProcess;

	@FindBy(how = How.CSS, using = ".alert-info")
	@CacheLookup
	public WebElement txtSuccessMsg;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Add')]")
	@CacheLookup
	private WebElement btnAddSvcFlw;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add Process')]")

	@CacheLookup
	private WebElement btnAddProcess;

	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Step 1')]")
	@CacheLookup
	private WebElement btnStep;

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'Remove Process')])[1]")
	@CacheLookup
	private WebElement btnRemoveProcess;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'View Service Flow Configuration')]")
	@CacheLookup
	private WebElement viewSvcFlwConfig;

	@FindBy(how = How.CSS, using = "h1>div")
	@CacheLookup
	public WebElement viewSvcFlwConfigHeader;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'header__primary-text header__primary-text--solo')]")
	@CacheLookup
	public WebElement viewSvcFlwProcessHeader;

	@FindBy(how = How.CSS, using = "[data-disable-with='Confirm']")
	@CacheLookup
	public WebElement btnConfirm;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue')]")
	@CacheLookup
	public WebElement btnContinue;

	@FindBy(how = How.XPATH, using = "(//label[contains(text(),'Value')]/following-sibling::input)[2]")
	@CacheLookup
	public WebElement txtboxValue;

	@FindBy(how = How.XPATH, using = "(//label[contains(text(),'Value')]/following-sibling::input)[4]")
	@CacheLookup
	public WebElement txtboxValue2;

	@FindBy(how = How.XPATH, using = "(//label[contains(text(),'Value')]/following-sibling::input)[5]")
	@CacheLookup
	public WebElement txtboxValue3;

	@FindBy(how = How.XPATH, using = "(//label[contains(text(),'Value')]/following-sibling::input)[10]")
	@CacheLookup
	public WebElement txtboxValue4;

	@FindBy(how = How.XPATH, using = "(//label[contains(text(),'Value')]/following-sibling::input)[12]")
	@CacheLookup
	public WebElement txtboxValue5;

	@FindBy(how = How.XPATH, using = "(//label[contains(text(),'Value')]/following-sibling::input)[14]")
	@CacheLookup
	public WebElement txtboxValue6;

	public void addSvcFlw() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = ServiceFlowData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddSvcFlw, 06);
		btnAddSvcFlw.click();
		Action.enter(txtBoxSvcFlwName, data.getSvcFlwName());
		Action.selectByValue(drpdwnSvcName, "Shipment");
		selectSvcFlwCriteriaByshippingType();
		btnSaveConfigProcess.click();

		// btnSave.click();
	}

	public void editSvcFlw() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = ServiceFlowData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddSvcFlw, 06);
		Action.selectByValue(drpdwnService, "Shipment");
		btnSearch.click();
		Action.scrollDown("200");
		iconEdit.click();
		txtBoxSvcFlwName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Action.enter(txtBoxSvcFlwName, data.getSvcFlwName());
		Action.selectByValue(drpdwnSvcName, "Shipment");
		btnPrependCondition.click();
		selectSvcFlwCriteriaByTenderType();
		Thread.sleep(10000);
		btnSave.click();

	}

	public void selectSvcFlwCriteriaByshippingType() {

		Action.selectByIndex(drpdwnSvcFlwCriteriaGroupStart, 1);
		Action.selectByIndex(drpdwnSvcFlwCriteriaType, 5);
		Action.selectByIndex(drpdwnSvcFlwCriteriaOperator, 1);
		Action.selectByIndex(drpdwnSvcFlwCriteriaValue, 2);
		Action.selectByIndex(drpdwnSvcFlwCriteriaGroupEnd, 2);
		btnSvcFlwCriteriaConfirm.click();
	}

	public void selectSvcFlwCriteriaByTenderType() {

		Action.selectByIndex(drpdwnSvcFlwCriteriaGroupStart, 1);
		Action.selectByIndex(drpdwnSvcFlwCriteriaType, 6);
		Action.selectByIndex(drpdwnSvcFlwCriteriaOperator, 2);
		Action.selectByIndex(drpdwnSvcFlwCriteriaValue, 5);
		Action.selectByIndex(drpdwnSvcFlwCriteriaGroupEnd, 5);
		btnSvcFlwCriteriaConfirm.click();
	}

	public void clickViewSvcFlw() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = ServiceFlowData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddSvcFlw, 06);
		Action.selectByValue(drpdwnService, "Shipment");
		btnSearch.click();
		iconView.click();
		System.out.println("Clicked View Service Flow button");
		Assert.assertEquals(viewSvcFlwConfigHeader.getText(), RomuiEnumValues.SERVICEFLOW_VIEW_HEADER.getMessage(),
				"USER does not navigated to View Service Flow screen");
		viewSvcFlwConfig.click();
		System.out.println("View Service Flow Process button is Clicked");
		String actualViewServiceFlowConfigHeader = viewSvcFlwProcessHeader.getText();
		Assert.assertEquals(actualViewServiceFlowConfigHeader, RomuiEnumValues.SERVICEFLOW_PROCESS_HEADER.getMessage(),
				"USER does not navigated to configure service flow screen");
		btnEditProcess.click();
		CommonElementsPage.clickOnCancelBtn();
		System.out.println("Clicked Cancel button");
	}

	public void copySvcFlw() throws JsonParseException, JsonMappingException, IOException {
		data = ServiceFlowData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddSvcFlw, 06);
		Action.selectByValue(drpdwnService, "Shipment");
		btnSearch.click();
		Action.scrollDown("200");
		Action.waitForElementToBeClickable(driver, iconCopy, 10);
		iconCopy.click();
		Action.enter(txtBoxSvcFlwName, data.getSvcFlwName());
		btnSave.click();

	}

	public void editSvcFlwprocess() throws JsonParseException, JsonMappingException, IOException {
		data = ServiceFlowData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddSvcFlw, 06);
		Action.selectByValue(drpdwnService, "Shipment");
		btnSearch.click();
		Action.waitForElementToBeClickable(driver, iconEditProcess, 10);
		iconEditProcess.click();

	}

	public void addSvcFlwProcess() throws InterruptedException {

		btnAddProcess.click();
		for (int i = 0; i <= 5; i++) {
			List<WebElement> drpdwnProcessName = driver.findElements(By.cssSelector("#process_name"));
			drpdwnProcessName.get(i).click();
			Action.selectByIndex(drpdwnProcessName.get(i), i);
			Action.scrollDown("500");
			if (i < 5) {
				btnAddProcess.click();
			}
			Action.scrollDown("500");

		}
		for (int j = 0; j <= 14; j++) {
			List<WebElement> txtboxValue = driver.findElements(By.cssSelector("[name='attribute_value']"));
			Action.enter(txtboxValue.get(j), data.getSvcFlwkeyValue());
			Thread.sleep(10000);
		}
		Thread.sleep(10000);
		btnSave.click();

	}

	public void editSvcFlwProcess() {

		// Action.selectByValue(drpdwnProcessName1, "1");
		txtboxValue.clear();
		Action.enter(txtboxValue, data.getHfrSvcFlwValue());
		Action.scrollDown("500");
		// Action.selectByValue(drpdwnProcessName3, "3");
		txtboxValue.clear();
		Action.enter(txtboxValue3, data.getShipmentSvcFlwValue());
		btnSave.click();
	}

}