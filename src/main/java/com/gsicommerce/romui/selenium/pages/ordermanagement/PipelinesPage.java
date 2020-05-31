package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;
import java.util.Calendar;
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
import com.gsicommerce.romui.selenium.testdata.PipelineData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;
import com.gsicommerce.romui.selenium.utilities.Webtable;

public class PipelinesPage {

	WebDriver driver;
	Environment env;
	Action action;

	private PipelineData data;
	Calendar futureStartDate = null;
	Calendar dateCurrent = null;
	Calendar endDateCal = null;
	private static String addpipelineName;
	private static int rowNo;
	private static int rowNo1;
	private static String editPipelineName;

	public PipelinesPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);
	}

	@FindBy(how = How.CSS, using = "[data-tooltip='View Pipeline']")
	@CacheLookup
	private WebElement btnView;

	@FindBy(how = How.CSS, using = "[data-tooltip='Edit Pipeline']")
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

	@FindBy(how = How.CSS, using = "#order_orchestration_pipeline_name")
	private WebElement txtBoxPipelineName;

	@FindBy(how = How.CSS, using = "#order_orchestration_pipeline_start_date")
	private WebElement txtStartDate;

	@FindBy(how = How.CSS, using = "#order_orchestration_pipeline_end_date")
	private WebElement txtEndDate;

	@FindBy(how = How.CSS, using = "#order_orchestration_pipeline_status")
	private WebElement drpdwnPipelineStatus;

	@FindBy(how = How.CSS, using = "#condition_grouping_start")
	private WebElement drpdwnPipelineCriteriaGroupStart;

	@FindBy(how = How.CSS, using = "#condition_grouping_end")
	private WebElement drpdwnPipelineCriteriaGroupEnd;

	@FindBy(how = How.CSS, using = "#condition_type")
	private WebElement drpdwnPipelineCriteriaType;

	@FindBy(how = How.CSS, using = "#condition_operator")
	private WebElement drpdwnPipelineCriteriaOperator;

	@FindBy(how = How.CSS, using = "#condition_value")
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

	@FindBy(how = How.CSS, using = ".sidebar-container")
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

	@FindBy(how = How.CSS, using = ".pipeline-criteria-form-container")
	private WebElement pipelineCriteriaFormContainer;

	@FindBy(how = How.CSS, using = "[type='button'][data-pipeline-cancel-condition='']")
	private WebElement btnPipelineCriteriaDelete;

	@FindBy(how = How.CSS, using = "[data-pipeline-confirm-condition=''][type='button']")
	private WebElement btnPipelineCriteriaConfirm;

	@FindBy(how = How.CSS, using = "[data-add-new-condition=''][type='button']")
	private WebElement btnAddCondition;

	@FindBy(how = How.CSS, using = "[data-prepend-condition=''][type='button']")
	private WebElement btnPrependCondition;

	@FindBy(how = How.CSS, using = "[data-pipeline-submit-button='add'][type='submit']")
	private WebElement btnSaveAddConfig;

	@FindBy(how = How.CSS, using = "[data-pipeline-submit-button='skip'][type='submit']")
	private WebElement btnSaveExit;

	@FindBy(how = How.CSS, using = "[data-on-pipeline-form-submit=''][type='button']")
	private WebElement btnSave;

	@FindBy(how = How.CSS, using = ".alert-info")
	public WebElement txtSuccessMsg;

	@FindBy(how = How.CSS, using = "[href='/en/sellers/TMSEB2/order_orchestration/new']")
	private WebElement btnAddPipeline;

	@FindBy(how = How.CSS, using = ".radial-action-bar-secondary-btn")
	private WebElement lkviewPipelineConfig;

	@FindBy(how = How.CSS, using = "[style='word-break: break-all; max-width: 131px;']")
	@CacheLookup
	private WebElement secondColumn;

	@FindBy(how = How.CSS, using = "[data-disable-with='Confirm']")
	@CacheLookup
	private WebElement btnConfirm;

	@FindBy(how = How.CSS, using = "[data-confirm-pipeline-status-btn='']")
	private WebElement btnContinue;

	@FindBy(how = How.CSS, using = "[data-confirm-config-btn=''][type='button']")
	@CacheLookup
	private WebElement btnContinueConfig;

	@FindBy(how = How.CSS, using = "[data-dismiss='modal']")
	@CacheLookup
	private WebElement btnCancelPopWindow;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save and Edit Configuration')]")
	private WebElement btnSaveEditConfig;

	@FindBy(how = How.CSS, using = "[data-pipeline-submit-button='add']")
	private WebElement btnSaveViewConfig;

	@FindBy(how = How.CSS, using = ".condition-display-container-inner")
	private WebElement btnCreteriaCondition;

	@FindBy(how = How.CSS, using = ".radial-action-bar-secondary-btn")
	private WebElement btnCancel;

	public void addPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		data = PipelineData.get(env.getFileLocation());
		btnAddPipeline.click();
		addpipelineName = data.getPipelineName();
		System.out.println("ADDED PIPELINE NAME is:-" + addpipelineName);
		Action.enter(txtBoxPipelineName, addpipelineName);
		clickonStartDate();
		clickonEndDate();
		selectPipelineCriteriaByTenderType();
		btnPrependCondition.click();
		selectPipelineCriteriaByOrderType();
		btnSaveAddConfig.click();
		Common.dragAndDrop(driver, dragSalesOrderCreate, dropSalesOrderCreate, 10);
		btnSave.click();
		btnContinueConfig.click();
		System.out.println("Selected row- " + CommonElementsPage.getRowNum(addpipelineName));
		rowNo = CommonElementsPage.getRowNum(addpipelineName);
         System.out.println("Row Selected :" +rowNo);
		if (Webtable.getTableCellText(rowNo, 1).contains(addpipelineName)) {
			System.out.println("Pipeline added successfully");
		} else {
			System.out.println("Pipeline not added successfully");
		}
       System.out.println("row text:"+Webtable.getTableCellText(rowNo, 1));
		Assert.assertEquals(Webtable.getTableCellText(rowNo, 1), addpipelineName, "Pipeline has not been added");
	}

	public void clickViewPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		addPipeline();
		CommonElementsPage.clickActionsIcon(rowNo, 5, 1, 1);
		WebElement lblNameViewPipeline = driver
				.findElement(By.xpath("//div[contains(text(),'" + addpipelineName + "')]"));
		System.out.println("Name value is:" + lblNameViewPipeline.getText());
		if (lblNameViewPipeline.getText().contains(addpipelineName)) {
			System.out.println("view pipeline screen validated");
		} else {
			System.out.println("view pipeline screen not validated");
		}
		Assert.assertEquals(lblNameViewPipeline.getText(), addpipelineName, "View Pipeline screen has been validated");

		Action.waitForElementToBeClickable(driver, lkviewPipelineConfig, 10);
		Action.clickElementJavaScipt(lkviewPipelineConfig);

		WebElement lblNameConfigurePipeline = driver.findElement(
				By.xpath("//div[contains(text(),'Name')] | //div[contains(text(),'" + addpipelineName + "')]"));

		if (lblNameConfigurePipeline.getText().contains(addpipelineName)) {
			System.out.println("Configure pipeline screen validated");
		} else {
			System.out.println("Configure pipeline screen not validated");
		}

		Assert.assertEquals(lblNameConfigurePipeline.getText(), addpipelineName,
				"Configure Pipeline screen has been validated");
		Action.waitForElementToBeVisible(driver, btnCancel, 10);
		Action.waitForElementToBeClickable(driver, btnCancel, 15);
		btnCancel.click();

	}
	// Sheela-This method will select StartDate on Create Pipeline screen

	public void clickonStartDate() {
		if (!txtStartDate.isSelected()) {
			txtStartDate.click();
			txtStartDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			txtStartDate.sendKeys(Common.selectStartDate(futureStartDate));
		} else if (txtStartDate.toString().equals(Common.selectCurrentDate(dateCurrent))) {
			txtStartDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			txtStartDate.sendKeys(Common.selectStartDate(futureStartDate));
		}

	}

	// Sheela-This method will select EndDate on Create Pipeline screen

	public void clickonEndDate() {
		if (!txtEndDate.isSelected()) {
			txtEndDate.click();
			txtEndDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

			txtEndDate.sendKeys(Common.selectEndDate(endDateCal));
		} else if (txtEndDate.toString().equals(Common.selectCurrentDate(dateCurrent))) {
			txtEndDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			txtEndDate.sendKeys(Common.selectEndDate(endDateCal));
		}

	}

	public void editPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		addPipeline();
		CommonElementsPage.clickActionsIcon(rowNo, 5, 3, 1);
		// try {
		data = PipelineData.get(env.getFileLocation());
		// if(secondColumn.getText().equals("DRAFT")) {
		// Action.waitForElementToBeClickable(driver, btnEdit, 10);
		// btnEdit.click();
		editPipelineName = data.getPipelineName();
		System.out.println("EDIT PIPELINE NAME IS:" + editPipelineName);
		Action.waitForElementToBeClickable(driver, txtBoxPipelineName, 10);
		txtBoxPipelineName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		//Action.enter(txtBoxPipelineName, editPipelineName);
		txtBoxPipelineName.sendKeys(editPipelineName);
		Action.selectByIndex(drpdwnPipelineStatus, 2);
		clickonStartDate();
		clickonEndDate();
		//if (btnCreteriaCondition.isDisplayed()) {
			btnPrependCondition.click();
			selectPipelineCriteriaByPaymentMethod();
			btnSaveEditConfig.click();
			Common.waitForElementPresent(driver, btnContinue, 10);
			btnContinue.click();
			Assert.assertEquals(txtSuccessMsg.getText(),RomuiEnumValues.PIPELINE_EDIT.getMessage(), "Pipelne hasn't been updated");
			Action.waitForElementToBeClickable(driver, btnCancel, 10);
			Action.clickElementJavaScipt(btnCancel);
			
		//}
			System.out.println("Selected row- " + CommonElementsPage.getRowNum(editPipelineName));
			 rowNo1 = CommonElementsPage.getRowNum(editPipelineName);
		System.out.println("Edited pipeline:" +Webtable.getTableCellText(rowNo1, 1));
		Assert.assertEquals(Webtable.getTableCellText(rowNo1, 1), editPipelineName, "Pipeline has not been Edited");
		
	}
		
		public void editPipelineActive() throws JsonParseException, JsonMappingException, IOException, Exception
		{
			editPipeline();	
			CommonElementsPage.clickActionsIcon(rowNo1, 5, 3, 1);
			System.out.println(txtBoxPipelineName.getText());
			Action.selectByIndex(drpdwnPipelineStatus, 0);
			clickonStartDate();
			clickonEndDate();
			btnSaveViewConfig.click();
			Common.waitForElementPresent(driver, btnContinue, 05);
			btnContinue.click();
			Assert.assertEquals(txtSuccessMsg.getText(),RomuiEnumValues.PIPELINE_EDIT.getMessage(), "Pipelne hasn't been updated");
			btnCancel.click();
			System.out.println("Selected row is:" +Webtable.getTableCellText(rowNo1, 2));
			Assert.assertEquals(Webtable.getTableCellText(rowNo1, 2), "INACTIVE", "Pipeline has not been Edited");
		}
		/*
		 * } if (secondColumn.getText().equals("ACTIVE")) { btnEdit.click();
		 * clickonStartDate(); clickonEndDate(); btnSaveViewConfig.click();
		 * Common.waitForElementPresent(driver, btnContinue, 05); btnContinue.click(); }
		 * if (secondColumn.getText().equals("INACTIVE")) { btnEdit.click();
		 * Common.waitForElementPresent(driver, drpdwnPipelineStatus, 10);
		 * Action.selectByIndex(drpdwnPipelineStatus, 1); clickonStartDate();
		 * clickonEndDate(); btnSaveViewConfig.click();
		 * Common.waitForElementPresent(driver, btnContinue, 05); btnContinue.click(); }
		 * } catch (Exception e) {
		 * 
		 * // e.printStackTrace(); }
		 */
	

	
	public void selectPipelineCriteriaByTenderType() {

		Action.selectByIndex(drpdwnPipelineCriteriaGroupStart, 1);
		Action.selectByIndex(drpdwnPipelineCriteriaType, 6);
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

	public void selectPipelineCriteriaByPaymentMethod() {
		Action.selectByIndex(drpdwnPipelineCriteriaGroupStart, 1);
		Action.selectByIndex(drpdwnPipelineCriteriaType, 10);
		Action.selectByIndex(drpdwnPipelineCriteriaOperator, 1);
		Action.selectByIndex(drpdwnPipelineCriteriaValue, 1);
		Action.selectByIndex(drpdwnPipelineCriteriaGroupEnd, 2);
		btnPipelineCriteriaConfirm.click();

	}
	public void deletePipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		addPipeline();
		CommonElementsPage.clickDeleteIcon(rowNo, 5, 1);
		System.out.println("Delete Pipeline Button Clicked");
		Action.waitForElementToBeClickable(driver, btnConfirm, 10);
		btnConfirm.click();
		System.out.println("Delete Pipeline Confirm button Clicked");

	}

	public void copyPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		data = PipelineData.get(env.getFileLocation());
		Action.scrollDown("200");
		CommonElementsPage.clickActionsIcon(rowNo, 5, 2, 1);
		btnCopyPipeline.click();
		String copypipelineName = data.getPipelineName();
		System.out.println("COPY Pipeline name is:-" + copypipelineName);
		// Action.enter(txtBoxPipelineName, data.getPipelineName());
		Action.enter(txtBoxPipelineName, copypipelineName);
		clickonStartDate();
		clickonEndDate();
		btnSaveAddConfig.click();
		Action.waitForElementToBeClickable(driver, btnSave, 25);
		btnSave.click();
		Action.waitForElementToBeClickable(driver, btnContinueConfig, 10);
		btnContinueConfig.click();
	}

	public void editPipelienConfiguration() throws Exception {
		CommonElementsPage.clickActionsIcon(rowNo, 5, 4, 1);
		try {
			if (secondColumn.getText().equals("DRAFT")) {
				btnEditConfig.click();
				Common.dragAndDrop(driver, dragSalesOrderCreate, dropSalesOrderCreate, 10);
				btnSave.click();
				Action.waitForElementToBeClickable(driver, btnContinueConfig, 10);
				btnContinueConfig.click();
			}
			if (secondColumn.getText().equals("ACTIVE")) {
				btnEditConfig.click();
				btnCancel.click();
			}
			if (secondColumn.getText().equals("INACTIVE")) {
				btnEditConfig.click();
				btnCancel.click();
			}

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

}
