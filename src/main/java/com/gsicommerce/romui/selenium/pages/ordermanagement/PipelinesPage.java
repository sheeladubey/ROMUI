package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;
import java.util.Calendar;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.PipelineData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;
import com.gsicommerce.romui.selenium.utilities.SelectDate;

public class PipelinesPage {

	WebDriver driver;
	Environment env;
	Action action;
	SelectDate selectdate;
	private PipelineData data;
	Calendar futureStartDate = null;
	Calendar dateCurrent = null;
	Calendar endDateCal = null;

	public PipelinesPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);
	}

	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Pipelines')]")
	@CacheLookup
	private WebElement lkPipeline;

	@FindBy(how = How.CSS, using = "[data-tooltip='View Pipeline']")
	@CacheLookup
	private WebElement btnView;

	@FindBy(how = How.CSS, using = "[data-tooltip='Edit Pipeline']")
	@CacheLookup
	private WebElement btnEdit;

	@FindBy(how = How.CSS, using = "[data-tooltip='Edit Pipeline Configuration']")
	@CacheLookup
	private WebElement btnEditConfig;

	@FindBy(how = How.CSS, using = "[data-tooltip='Delete Pipeline']")
	@CacheLookup
	private WebElement btnDeletePipeline;

	@FindBy(how = How.CSS, using = "[data-tooltip='Copy Pipeline']")
	@CacheLookup
	private WebElement btnCopyPipeline;

	@FindBy(how = How.XPATH, using = "//input[@id='order_orchestration_pipeline_name']")
	@CacheLookup
	private WebElement txtBoxPipelineName;

	@FindBy(how = How.CSS, using = "#order_orchestration_pipeline_start_date")
	@CacheLookup
	private WebElement txtStartDate;

	@FindBy(how = How.CSS, using = "#order_orchestration_pipeline_end_date")
	@CacheLookup
	private WebElement txtEndDate;

	@FindBy(how = How.CSS, using = "#order_orchestration_pipeline_status")
	@CacheLookup
	private WebElement drpdwnPipelineStatus;

	@FindBy(how = How.CSS, using = "#condition_grouping_start")
	@CacheLookup
	private WebElement drpdwnPipelineCriteriaGroupStart;

	@FindBy(how = How.CSS, using = "#condition_grouping_end")
	@CacheLookup
	private WebElement drpdwnPipelineCriteriaGroupEnd;

	@FindBy(how = How.CSS, using = "#condition_type")
	@CacheLookup
	private WebElement drpdwnPipelineCriteriaType;

	@FindBy(how = How.CSS, using = "#condition_operator")
	@CacheLookup
	private WebElement drpdwnPipelineCriteriaOperator;

	@FindBy(how = How.CSS, using = "#condition_value")
	@CacheLookup
	private WebElement drpdwnPipelineCriteriaValue;

	/*-----------------------------------------------------Create Event-----------------------*/
	@FindBy(how = How.CSS, using = "#SalesOrderCreate")
	@CacheLookup
	private WebElement dragSalesOrderCreate;

	@FindBy(how = How.CSS, using = ".dropzone.column-starting-point")
	@CacheLookup
	private WebElement dropSalesOrderCreate;

	@FindBy(how = How.CSS, using = "#graph-container")
	@CacheLookup
	public WebElement btnOrderCreate;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'sidebar-body-overlay sidebar-body-overlay--active')]")
	@CacheLookup
	private WebElement OrderCreateEvent;

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'exit-event-button')]")
	@CacheLookup
	private WebElement btnConnect;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Scheduling')]")
	@CacheLookup
	private WebElement btnScheduling;

	@FindBy(how = How.CSS, using = ".add-new")
	@CacheLookup
	private WebElement btnAddConnection;
	/*--------------------------------------------------------------*/

	// @FindBy(how = How.XPATH, using =
	// "//div[contains(@class,'pipeline-criteria-form-container')]")
	@FindBy(how = How.CSS, using = ".pipeline-criteria-form-container")
	@CacheLookup
	private WebElement pipelineCriteriaFormContainer;

	@FindBy(how = How.XPATH, using = "//div[@class='pipeline-criteria-form-container']//div//span[@class='ss-icon ss-trash']")
	@CacheLookup
	private WebElement btnPipelineCriteriaDelete;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'pipeline-criteria-form-container')]//div//span[contains(@class,'ss-icon ss-check')]")
	@CacheLookup
	private WebElement btnPipelineCriteriaConfirm;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add Condition')]")
	@CacheLookup
	private WebElement btnAddCondition;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Prepend Condition')]")
	@CacheLookup
	private WebElement btnPrependCondition;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save and Add Configuration')]")
	@CacheLookup
	private WebElement btnSaveAddConfig;

	@FindBy(how = How.CSS, using = ".alert-info")
	@CacheLookup
	public WebElement txtSuccessMsg;

	@FindBy(how = How.XPATH, using = "//a[contains(@class,'btn-default btn')]//span[contains(text(),'Add')]")
	@CacheLookup
	private WebElement btnAddPipeline;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'View Pipeline Configuration')]")
	@CacheLookup
	private WebElement lkviewPipelineConfig;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'header__primary-text header__primary-text--solo')]")
	@CacheLookup
	public WebElement txtScreenHeader;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'header__primary-text header__primary-text--solo')]")
	@CacheLookup
	public WebElement viewPipelineConfigHeader;

	@FindBy(how = How.XPATH, using = "//tr[1]//td[2]//span[1]")
	@CacheLookup
	private WebElement secondColumn;

	@FindBy(how = How.CSS, using = "[data-disable-with='Confirm']")
	@CacheLookup
	public WebElement btnConfirm;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue')]")
	@CacheLookup
	public WebElement btnContinue;

	public void addPipeline() throws JsonParseException, JsonMappingException, IOException {
		data = PipelineData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddPipeline, 03);
		btnAddPipeline.click();
		Action.enter(txtBoxPipelineName, data.getPipelineName());
		clickonStartDate();
		clickonEndDate();
		selectPipelineCriteriaByTenderType();
		btnSaveAddConfig.click();
		createEvents();

		// Action.waitForElementToBeClickable(driver, btnPipelineCriteriaDelete, 10);
		// btnPipelineCriteriaDelete.click();
		// System.out.println("pipeline criteria button has been deleted");
		// CommonElementsPage.clickOnSaveExitBtn();

	}

	public void createEvents() {
		Common.dragAndDrop(driver, dragSalesOrderCreate, dropSalesOrderCreate, 10);
		Common.waitForElementPresent(driver, btnOrderCreate, 10);
		// btnOrderCreate.click();

		Actions actions = new Actions(driver);
		actions.moveToElement(btnOrderCreate).perform();
		actions.click();
		// btnConnect.click();
		// btnScheduling.click();
		// btnAddConnection.click();
		CommonElementsPage.clickOnSaveBtn();

	}

	public void clickViewPipeline() {
		btnView.click();
		System.out.println("Clicked View Pipeline button");
		Assert.assertEquals(txtScreenHeader.getText(), RomuiEnumValues.PIPELINE_VIEW_HEADER.getMessage(),
				"USER does not navigated to View Pipeline screen");
		lkviewPipelineConfig.click();
		System.out.println("View Pipeline Configuration button Clicked");
		String actualViewPipelineConfigHeader = viewPipelineConfigHeader.getText();
		Assert.assertEquals(actualViewPipelineConfigHeader, RomuiEnumValues.PIPELINE_CONFIGURE_HEADER.getMessage(),
				"USER does not navigated to configure Pipeline screen");
		CommonElementsPage.clickOnCancelBtn();
		System.out.println("Clicked Cancel button");
	}
	// Sheela-This method will select StartDate on Create Pipeline screen

	public void clickonStartDate() {
		if (!txtStartDate.isSelected()) {
			txtStartDate.click();
			txtStartDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			txtStartDate.sendKeys(SelectDate.selectStartDate(futureStartDate));
		} else if (txtStartDate.toString().equals(SelectDate.selectCurrentDate(dateCurrent))) {
			txtStartDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			txtStartDate.sendKeys(SelectDate.selectStartDate(futureStartDate));
		}
		System.out.println("Start Date Entered");
	}

	// Sheela-This method will select EndDate on Create Pipeline screen

	public void clickonEndDate() {
		if (!txtEndDate.isSelected()) {
			txtEndDate.click();
			txtEndDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

			txtEndDate.sendKeys(SelectDate.selectEndDate(endDateCal));
		} else if (txtEndDate.toString().equals(SelectDate.selectCurrentDate(dateCurrent))) {
			txtEndDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			txtEndDate.sendKeys(SelectDate.selectEndDate(endDateCal));
		}
		System.out.println("End Date Entered");
	}

	public void EditPipeline() throws JsonParseException, JsonMappingException, IOException {
		data = PipelineData.get(env.getFileLocation());
		if (secondColumn.getText().equals("DRAFT")) {
			btnEdit.click();
			txtBoxPipelineName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Action.enter(txtBoxPipelineName, data.getPipelineName());
			Action.selectByIndex(drpdwnPipelineStatus, 2);
			clickonStartDate();
			clickonEndDate();
			pipelineCriteriaFormContainer.click();
			selectPipelineCriteriaByOrderType();
			CommonElementsPage.clickOnSaveExitBtn();
			Common.waitForElementPresent(driver, btnContinue, 05);
			btnContinue.click();
		} else

		if (secondColumn.getText().equals("ACTIVE")) {
			btnEdit.click();
			clickonStartDate();
			clickonEndDate();
			CommonElementsPage.clickOnSaveExitBtn();
		}

	}

	public void selectPipelineCriteriaByTenderType() {

		Action.selectByIndex(drpdwnPipelineCriteriaGroupStart, 1);
		Action.selectByIndex(drpdwnPipelineCriteriaType, 4);
		Action.selectByIndex(drpdwnPipelineCriteriaOperator, 1);
		Action.selectByIndex(drpdwnPipelineCriteriaValue, 6);
		Action.selectByIndex(drpdwnPipelineCriteriaGroupEnd, 2);
		btnPipelineCriteriaConfirm.click();
	}

	public void selectPipelineCriteriaByOrderType() {
		Action.selectByIndex(drpdwnPipelineCriteriaGroupStart, 1);
		Action.selectByIndex(drpdwnPipelineCriteriaType, 2);
		Action.selectByIndex(drpdwnPipelineCriteriaOperator, 1);
		Action.selectByIndex(drpdwnPipelineCriteriaValue, 0);
		Action.selectByIndex(drpdwnPipelineCriteriaGroupEnd, 2);
		btnPipelineCriteriaConfirm.click();

	}

	public void deletePipeline() 
	{
		btnDeletePipeline.click();
		System.out.println("Delete Pipeline Button Clicked");
		Action.waitForElementToBeClickable(driver, btnConfirm, 10);
		btnConfirm.click();
		System.out.println("Delete Pipeline Confirm button Clicked");
	
	}
	
	public void copyPipeline() throws JsonParseException, JsonMappingException, IOException 
	{
		data = PipelineData.get(env.getFileLocation());
		Action.scrollDown("200");
		Action.waitForElementToBeClickable(driver, btnCopyPipeline, 10);
		btnCopyPipeline.click();
		Action.enter(txtBoxPipelineName,data.getPipelineName());
		clickonStartDate();
		clickonEndDate();
		CommonElementsPage.clickOnSaveExitBtn();
		
	}
	
	public void editPipelienConfiguration()
	{
		if(secondColumn.getText().equals("DRAFT"))
		{
		//Action.scrollDown("200");
		//Action.waitForElementToBeClickable(driver, btnEditConfig, 10);
		btnEditConfig.click();
		Common.dragAndDrop(driver, dragSalesOrderCreate, dropSalesOrderCreate, 10);
		CommonElementsPage.clickOnSaveBtn();
		btnContinue.click();
	}else
		if(secondColumn.getText().equals("ACTIVE"))
		{
			btnEditConfig.click();
			CommonElementsPage.clickOnCancelBtn();
		}else
		{
		System.out.println("Edit pipeline cnfig didn't get complete");
		}

}
}
