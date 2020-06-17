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
import com.gsicommerce.romui.selenium.testdata.PipelineData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;
import com.gsicommerce.romui.selenium.utilities.Webtable;
import org.apache.log4j.Logger;

public class PipelinesPage {

	WebDriver driver;
	Environment env;
	Action action;

	private PipelineData pipelinedata;

	private static String addpipelineName;
	private static int rowNoaddPipeline;
	private static int rowNoeditpipelineDraft;
	private static String editPipelineName;
	private static int rowNoeditpipelineActive;
	public static Logger logger;

	public PipelinesPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);

	}

	@FindBy(how = How.CSS, using = "[data-tooltip='Delete Pipeline']")
	private WebElement btnDeletePipeline;

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

	@FindBy(how = How.CSS, using = "#SalesOrderCreate")
	@CacheLookup
	private WebElement dragSalesOrderCreate;

	@FindBy(how = How.CSS, using = ".dropzone.column-starting-point")
	@CacheLookup
	private WebElement dropSalesOrderCreate;

	@FindBy(how = How.CSS, using = "#graph-container")
	@CacheLookup
	public WebElement btnOrderCreate;

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

	@FindBy(how = How.CSS, using = "[data-disable-with='Confirm']")
	private WebElement btnConfirm;

	@FindBy(how = How.CSS, using = "[data-confirm-pipeline-status-btn='']")
	private WebElement btnContinue;

	@FindBy(how = How.CSS, using = "[data-confirm-config-btn=''][type='button']")
	private WebElement btnContinueConfig;

	@FindBy(how = How.CSS, using = "[data-dismiss='modal']")
	private WebElement btnCancelPopWindow;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Edit Pipeline')]]")
	private WebElement btnEditPipeline;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save and Edit Configuration')]")
	private WebElement btnSaveEditConfig;

	@FindBy(how = How.CSS, using = "[data-pipeline-submit-button='add']")
	private WebElement btnSaveViewConfig;

	@FindBy(how = How.CSS, using = ".condition-display-container-inner")
	private WebElement btnCreteriaCondition;

	@FindBy(how = How.CSS, using = ".radial-action-bar-secondary-btn")
	private WebElement btnCancel;

	@FindBy(how = How.CSS, using = ".alert-danger")
	private WebElement txtformvalidationError;

	@FindBy(how = How.CSS, using = ".reflow-table-row")
	@CacheLookup
	public List<WebElement> tableRows;

	public void addPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		pipelinedata = PipelineData.get(env.getFileLocation());
		btnAddPipeline.click();
		addpipelineName = pipelinedata.getPipelineName();
		System.out.println("ADDED PIPELINE NAME is:-" + addpipelineName);
		Action.enter(txtBoxPipelineName, addpipelineName);
		Common.clickonCalendarDate(txtStartDate, pipelinedata.getpipelineStartDate());
		Common.clickonCalendarDate(txtEndDate, pipelinedata.getpipelineEndDate());
		// Select by Tender Type
		// logger.info("Selecting PIPELINE CRITERIA BY TENDER TYPE");
		selectPipelineCriteria(0, 5, 0, 3, 1);
		btnPrependCondition.click();
		// Select By Order Type
		logger.info("Selecting PIPELINE CRITERIA BY ORDER TYPE");
		selectPipelineCriteria(0, 1, 0, 0, 1);
		btnSaveAddConfig.click();
		Common.dragAndDrop(driver, dragSalesOrderCreate, dropSalesOrderCreate, 10);
		btnSave.click();
		btnContinueConfig.click();
		rowNoaddPipeline = CommonElementsPage.getRowNum(addpipelineName);
		System.out.println("Row Selected :" + rowNoaddPipeline);
		Assert.assertEquals(Webtable.getTableCellText(rowNoaddPipeline, 1), addpipelineName,
				"Pipeline has not been added");
		Assert.assertTrue(
				Webtable.getTableCellText(rowNoaddPipeline, 2).equals("DRAFT") && Webtable.getTableCellText(rowNoaddPipeline, 5).contains("Delete Pipeline"),
				"Delete pipeline icon doesn't exist for Draft status record");
	}

	public void clickViewPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		// addPipeline();
		CommonElementsPage.clickActionsIcon(rowNoaddPipeline, 5, 1, 1);
		WebElement lblNameViewPipeline = driver
				.findElement(By.xpath("//div[contains(text(),'" + addpipelineName + "')]"));
		Assert.assertEquals(lblNameViewPipeline.getText().substring(5), addpipelineName,
				"View Pipeline screen has not been validated");
		Action.waitForElementToBeClickable(driver, lkviewPipelineConfig, 10);
		Action.clickElementJavaScipt(lkviewPipelineConfig);
		WebElement lblNameConfigurePipeline = driver.findElement(By.cssSelector(".col-sm-3.order-mobile-spacing"));
		Assert.assertEquals(lblNameConfigurePipeline.getText().substring(5), addpipelineName,
				"Configure Pipeline screen has not been validated");
		Action.waitForElementToBeClickable(driver, btnCancel, 15);
		btnCancel.click();
	}

	/*
	 * Verify Edit Pipeline feature . 1. First Added new Pipeline which is in DRAFT
	 * status 2.Then Edit pipeline name,status ,start and end date of recently added
	 * pipeline. 3.New pipeline is in ACTIVE status now.
	 * 
	 */
	public void editPipelineDraftStatus() throws JsonParseException, JsonMappingException, IOException, Exception {
		// addPipeline();
		pipelinedata = PipelineData.get(env.getFileLocation());
		editPipelineName = pipelinedata.getPipelineName();
		CommonElementsPage.clickActionsIcon(rowNoaddPipeline, 5, 3, 1);
		System.out.println("EDIT PIPELINE NAME for Active status IS:" + editPipelineName);
		Action.waitForElementToBeClickable(driver, txtBoxPipelineName, 10);
		txtBoxPipelineName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Action.enter(txtBoxPipelineName, editPipelineName);
		Action.selectByIndex(drpdwnPipelineStatus, 2);
		Common.clickonCalendarDate(txtStartDate, pipelinedata.getpipelineStartDate());
		Common.clickonCalendarDate(txtEndDate, pipelinedata.getpipelineEndDate());
		btnPrependCondition.click();
		// Select By Fulfillment Method
		System.out.println("Selecting Fulfillment Method type" );
		selectPipelineCriteria(0, 0, 0, 0, 1);
		btnSaveEditConfig.click();
		Common.waitForElementPresent(driver, btnContinue, 10);
		btnContinue.click();
		Assert.assertEquals(txtSuccessMsg.getText(), RomuiEnumValues.PIPELINE_EDIT.getMessage(),
				"Pipelne for Draft Status hasn't been updated");
		Action.waitForElementToBeClickable(driver, btnCancel, 10);
		Action.clickElementJavaScipt(btnCancel);
		rowNoeditpipelineDraft = CommonElementsPage.getRowNum(editPipelineName);
		System.out.println("Edited pipeline name is:" + Webtable.getTableCellText(rowNoeditpipelineDraft, 1));
		Assert.assertEquals(Webtable.getTableCellText(rowNoeditpipelineDraft, 1), editPipelineName,
				"Draft status Pipeline record has not been Edited");
		Assert.assertTrue(Webtable.getTableCellText(rowNoeditpipelineDraft, 2).equals("ACTIVE")
				&& !Webtable.getTableCellText(rowNoeditpipelineDraft, 5).contains("Delete Pipeline"), "Delete pipeline icon exist for Active status record");
  
	}

	/*
	 * Verify Edit Pipeline feature of ACTIVE status . 1. First Added new Pipeline.
	 * which is in DRAFT status 2.Then Edit pipeline name,status ,start and end date
	 * of recently added pipeline. 3.New pipeline is in ACTIVE status now.
	 * 4.Selected the new recently added Active status pipeline and change the
	 * status to INACTIVE and also change start and end date. 5.Now Pipeline is in
	 * INACTIVE status.
	 */
	public void editPipelineActiveStatus() throws JsonParseException, JsonMappingException, IOException, Exception {
		// editPipeline();
		pipelinedata = PipelineData.get(env.getFileLocation());
		CommonElementsPage.clickActionsIcon(rowNoeditpipelineDraft, 5, 3, 1);
		Action.selectByIndex(drpdwnPipelineStatus, 0);
		Common.clickonCalendarDate(txtStartDate, pipelinedata.getpipelineStartDate());
		Common.clickonCalendarDate(txtEndDate, pipelinedata.getpipelineEndDate());
		btnSaveViewConfig.click();
		Common.waitForElementPresent(driver, btnContinue, 05);
		btnContinue.click();
		Assert.assertEquals(txtSuccessMsg.getText(), RomuiEnumValues.PIPELINE_EDIT.getMessage(),
				"Pipelne for Active Status hasn't been updated");
		Action.waitForElementToBeClickable(driver, btnCancel, 10);
		Action.clickElementJavaScipt(btnCancel);
		rowNoeditpipelineActive = CommonElementsPage.getRowNum(editPipelineName);
		System.out.println("Edited pipeline active 5th column is:" +	Webtable.getTableCellText(rowNoeditpipelineActive, 5));
		if (Webtable.getTableCellText(rowNoeditpipelineActive, 2).equals("INACTIVE")
				&& !btnDeletePipeline.isDisplayed())
			System.out.println("Delete pipeline icon doesn't exist for InActive status record");
		else {
			System.out.println("Delete pipeline icon exist for InActive status record");
		}
		Assert.assertEquals(Webtable.getTableCellText(rowNoeditpipelineActive, 2), "INACTIVE",
				"Active status Pipeline record has not been Edited");
		Assert.assertTrue(Webtable.getTableCellText(rowNoeditpipelineActive, 2).equals("INACTIVE") && !Webtable.getTableCellText(rowNoeditpipelineActive, 5).contains("Delete Pipeline"), "Delete pipeline icon exist for InActive status record");
				
	}

	/*
	 * Verify Edit Pipeline feature of ACTIVE status . 1. First Added new Pipeline
	 * which is in DRAFT status 2.Then Edit pipeline name,status ,start and end date
	 * of recently added pipeline. 3.New pipeline is in ACTIVE status now.
	 * 4.Selected the new recently added ACtive status pipeline and change the
	 * status to INACTIVE and also change start and end date. 5.Now Pipeline is in
	 * INACTIVE status. 6.Select recently edited INACTIVE status pipelien,change
	 * status to ACTIVE,select start and end date .Click save&View config button and
	 * validate success message.
	 */
	public void editPipelineInActiveStatus() throws JsonParseException, JsonMappingException, IOException, Exception {
		// editPipelineActiveStatus();
		pipelinedata = PipelineData.get(env.getFileLocation());
		CommonElementsPage.clickActionsIcon(rowNoeditpipelineActive, 5, 3, 1);
		Action.selectByIndex(drpdwnPipelineStatus, 1);
		Common.clickonCalendarDate(txtStartDate, pipelinedata.getpipelineStartDate());
		Common.clickonCalendarDate(txtEndDate, pipelinedata.getpipelineEndDate());
		btnSaveViewConfig.click();
		Common.waitForElementPresent(driver, btnContinue, 05);
		btnContinue.click();
		Assert.assertEquals(txtSuccessMsg.getText(), RomuiEnumValues.PIPELINE_EDIT.getMessage(),
				"Pipelne for Inactive status hasn't been updated");
		Action.waitForElementToBeClickable(driver, btnCancel, 10);
		Action.clickElementJavaScipt(btnCancel);
		int rowNoeditpipelineInActive = CommonElementsPage.getRowNum(editPipelineName);
		System.out.println("Edited pipeline inactive 5th column is:" +	Webtable.getTableCellText(rowNoeditpipelineInActive, 5));
		Assert.assertEquals(Webtable.getTableCellText(rowNoeditpipelineInActive, 2), "ACTIVE",
				"Inactive status Pipeline record has not been Edited");
	}

	public void deletePipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		// addPipeline();
		if(Webtable.getTableCellText(rowNoaddPipeline, 2).equals("DRAFT") && btnDeletePipeline.isDisplayed()){
		CommonElementsPage.clickDeleteIcon(rowNoaddPipeline, 5, 1);
		Action.waitForElementToBeClickable(driver, btnConfirm, 10);
		btnConfirm.click();
		}else
		{
			System.out.println("delete Icon not found");
		}
	}

	public void copyPipelineDraftStatus() throws JsonParseException, JsonMappingException, IOException, Exception {
		// addPipeline();
		CommonElementsPage.clickActionsIcon(rowNoaddPipeline, 5, 2, 1);
		pipelinedata = PipelineData.get(env.getFileLocation());
		String copypipelineName = pipelinedata.getPipelineName();
		Action.waitForElementToBeClickable(driver, txtBoxPipelineName, 10);
		txtBoxPipelineName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Action.enter(txtBoxPipelineName, copypipelineName);
		Common.clickonCalendarDate(txtStartDate, pipelinedata.getpipelineStartDate());
		Common.clickonCalendarDate(txtEndDate, pipelinedata.getpipelineEndDate());
		btnSaveAddConfig.click();
		Action.waitForElementToBeClickable(driver, btnSave, 10);
		Action.clickElementJavaScipt(btnSave);
		Action.waitForElementToBeClickable(driver, btnContinueConfig, 10);
		btnContinueConfig.click();
		int copypipelineDraft = CommonElementsPage.getRowNum(copypipelineName);
		Assert.assertEquals(Webtable.getTableCellText(copypipelineDraft, 1), copypipelineName,
				"Copy Pipeline for Draft status has not Saved Successfull");

	}

	public void copyPipelineActiveStatus() throws JsonParseException, JsonMappingException, IOException, Exception {
		// editPipeline();
		CommonElementsPage.clickActionsIcon(rowNoeditpipelineDraft, 5, 2, 1);
		pipelinedata = PipelineData.get(env.getFileLocation());
		String copypipelineName = pipelinedata.getPipelineName();
		Action.waitForElementToBeClickable(driver, txtBoxPipelineName, 10);
		txtBoxPipelineName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Action.enter(txtBoxPipelineName, copypipelineName);
		Common.clickonCalendarDate(txtStartDate, pipelinedata.getpipelineStartDate());
		Common.clickonCalendarDate(txtEndDate, pipelinedata.getpipelineEndDate());
		btnSaveAddConfig.click();
		Action.waitForElementToBeClickable(driver, btnSave, 10);
		Action.clickElementJavaScipt(btnSave);
		Action.waitForElementToBeClickable(driver, btnContinueConfig, 10);
		btnContinueConfig.click();
		int copypipelineActive = CommonElementsPage.getRowNum(copypipelineName);
		Assert.assertEquals(Webtable.getTableCellText(copypipelineActive, 1), copypipelineName,
				"Copy Pipeline for Active status has not Saved Successfull");

	}

	public void copyPipelineInActiveStatus() throws JsonParseException, JsonMappingException, IOException, Exception {
		// editPipelineActiveStatus();
		CommonElementsPage.clickActionsIcon(rowNoeditpipelineActive, 5, 2, 1);
		pipelinedata = PipelineData.get(env.getFileLocation());
		String copypipelineName = pipelinedata.getPipelineName();
		Action.waitForElementToBeClickable(driver, txtBoxPipelineName, 10);
		txtBoxPipelineName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Action.enter(txtBoxPipelineName, copypipelineName);
		Common.clickonCalendarDate(txtStartDate, pipelinedata.getpipelineStartDate());
		Common.clickonCalendarDate(txtEndDate, pipelinedata.getpipelineEndDate());
		btnSaveAddConfig.click();
		Action.waitForElementToBeClickable(driver, btnSave, 10);
		Action.clickElementJavaScipt(btnSave);
		Action.waitForElementToBeClickable(driver, btnContinueConfig, 10);
		btnContinueConfig.click();
		int copypipelineInActive = CommonElementsPage.getRowNum(copypipelineName);
		Assert.assertEquals(Webtable.getTableCellText(copypipelineInActive, 1), copypipelineName,
				"Copy Pipeline for Inactive status has not been Saved Successfully");

	}

	public void editPipelienConfigurationDraft() throws Exception {
		addPipeline();
		CommonElementsPage.clickActionsIcon(rowNoaddPipeline, 5, 4, 1);
		Action.waitForElementToBeClickable(driver, btnSave, 10);
		Action.clickElementJavaScipt(btnSave);
		Action.waitForElementToBeClickable(driver, btnContinueConfig, 10);
		btnContinueConfig.click();

	}

	public void editPipelienConfigurationActive() throws Exception {
		// addPipeline();
		CommonElementsPage.clickActionsIcon(rowNoaddPipeline, 5, 4, 1);
		Action.waitForElementToBeClickable(driver, btnCancel, 10);
		Action.clickElementJavaScipt(btnCancel);
	}
//Below method is to select Pipeline criteria 
	public void selectPipelineCriteria(int grpindexstart, int typeindex, int operatorindex, int valueindex,
			int grpindexend) throws JsonParseException, JsonMappingException, IOException {
		pipelinedata = PipelineData.get(env.getFileLocation());
		String criteriaType = pipelinedata.getPipelineCriteriaType().get(typeindex);
		// Action.clickElementJavaScipt(btnAddPipeline);
		Action.selectByVisibleText(drpdwnPipelineCriteriaGroupStart,
				pipelinedata.getPipelineCriteriaGroup().get(grpindexstart));
		Action.selectByVisibleText(drpdwnPipelineCriteriaType, pipelinedata.getPipelineCriteriaType().get(typeindex));
		Action.selectByVisibleText(drpdwnPipelineCriteriaOperator,
				pipelinedata.getpipelineOperator().get(operatorindex));
		if (criteriaType.equals("Order Type")) {
			Action.selectByVisibleText(drpdwnPipelineCriteriaValue,
					pipelinedata.getpipelineValueOrderType().get(valueindex));
		}
		if (criteriaType.equals("Tender Type")) {
			Action.selectByVisibleText(drpdwnPipelineCriteriaValue,
					pipelinedata.getpipelineValueTenderType().get(valueindex));
		}
		if (criteriaType.equals("Fulfillment Method")) {
			Action.selectByVisibleText(drpdwnPipelineCriteriaValue,
					pipelinedata.getpipelineValueFulfillmentMethod().get(valueindex));
		}
		Action.selectByVisibleText(drpdwnPipelineCriteriaGroupEnd,
				pipelinedata.getPipelineCriteriaGroup().get(grpindexend));
		btnPipelineCriteriaConfirm.click();
	}

	//Below method is for form validation
	public void pipelineFormValidation()
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		btnAddPipeline.click();
		btnSaveExit.click();
		Assert.assertEquals(CommonElementsPage.formErrorValidation(),
				RomuiEnumValues.PIPELINE_FORMVALIDATION.getMessage(),
				"Pipeline form Error Validation message has not been found");
		// Select By Fulfillment Method
		selectPipelineCriteria(0, 0, 0, 0, 1);
		btnSaveExit.click();
		Assert.assertEquals(CommonElementsPage.formErrorValidation(), RomuiEnumValues.USER_VALIDATION.getMessage(),
				"Pipeline form Error Validation message has not been found");

	}

}
