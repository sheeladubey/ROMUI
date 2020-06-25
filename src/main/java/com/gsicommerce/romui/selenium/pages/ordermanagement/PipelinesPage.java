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
import org.testng.Reporter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.PipelineData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

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
		// btnAddPipeline.click();
		Action.clickUsingJavaScipt(btnAddPipeline);
		addpipelineName = pipelinedata.getPipelineName();
		System.out.println("ADDED PIPELINE NAME is:-" + addpipelineName);
		Action.enter(txtBoxPipelineName, addpipelineName);
		Common.clickonCalendarDate(txtStartDate, pipelinedata.getpipelineStartDate());
		Common.clickonCalendarDate(txtEndDate, pipelinedata.getpipelineEndDate());
		// Select by Tender Type
		Reporter.log("Selecting PIPELINE CRITERIA BY TENDER TYPE");
		selectPipelineCriteria(0, 5, 0, 3, 1);
		btnPrependCondition.click();
		// Select By Order Type
		Reporter.log("Selecting PIPELINE CRITERIA BY ORDER TYPE");
		selectPipelineCriteria(0, 1, 0, 0, 1);
		btnSaveAddConfig.click();
		Action.dragAndDrop(driver, dragSalesOrderCreate, dropSalesOrderCreate, 10);
		// btnSave.click();
		Action.clickUsingJavaScipt(btnSave);
		// btnContinueConfig.click();
		Action.waitForElementToBeClickable(driver, btnContinueConfig, 10);
		Action.clickUsingJavaScipt(btnContinueConfig);
		rowNoaddPipeline = CommonElementsPage.getRowNo(addpipelineName);
		System.out.println("Row Selected for recently added pipeline is :" + rowNoaddPipeline);
		System.out.println("Newly Added pipeline is::" + CommonElementsPage.getRowCellTextVal(rowNoaddPipeline, 1));
		Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowNoaddPipeline, 1), addpipelineName,
				"Pipeline has not been added");
		Assert.assertTrue(
				CommonElementsPage.getRowCellTextVal(rowNoaddPipeline, 2).equals("DRAFT")
						&& CommonElementsPage.getRowCellTextVal(rowNoaddPipeline, 5).contains("Delete Pipeline"),
				"Delete pipeline icon doesn't exist for Draft status record");
	}

	public void clickViewPipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		// addPipeline();
		System.out.println("Row Selected to view pipeline is :" + rowNoaddPipeline);
		System.out.println("Pipeline name to view is::" + CommonElementsPage.getRowCellTextVal(rowNoaddPipeline, 1));
		CommonElementsPage.clickDivSpanLink(rowNoaddPipeline, 5, 0, 1, 1);
		WebElement lblNameViewPipeline = driver
				.findElement(By.xpath("//div[contains(text(),'" + addpipelineName + "')]"));
		Assert.assertEquals(lblNameViewPipeline.getText().substring(5), addpipelineName,
				"View Pipeline screen has not been validated");
		Action.waitForElementToBeClickable(driver, lkviewPipelineConfig, 05);
		Action.clickUsingJavaScipt(lkviewPipelineConfig);
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
		Action.scrollToBottomofPage();
		Reporter.log("Click Edit Pipeline Icon for Draft status record");
		System.out.println("Selected row for edit draft status is::" + rowNoaddPipeline);
		System.out.println(
				"Draft status Pipeline name to edit is::" + CommonElementsPage.getRowCellTextVal(rowNoaddPipeline, 1));
		CommonElementsPage.clickDivSpanLink(rowNoaddPipeline, 5, 0, 3, 1);
		System.out.println("EDIT PIPELINE NAME for Active status IS:" + editPipelineName);
		Action.waitForElementToBeClickable(driver, txtBoxPipelineName, 10);
		txtBoxPipelineName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Action.enter(txtBoxPipelineName, editPipelineName);
		Action.selectByIndex(drpdwnPipelineStatus, 2);
		Common.clickonCalendarDate(txtStartDate, pipelinedata.getpipelineStartDate());
		Common.clickonCalendarDate(txtEndDate, pipelinedata.getpipelineEndDate());
		btnPrependCondition.click();
		// Select By Fulfillment Method
		Reporter.log("Selecting Fulfillment Method type");
		selectPipelineCriteria(0, 0, 0, 0, 1);
		btnSaveEditConfig.click();
		Common.waitForElementPresent(driver, btnContinue, 10);
		btnContinue.click();
		Assert.assertEquals(txtSuccessMsg.getText(), RomuiEnumValues.PIPELINE_EDIT.getMessage(),
				"Pipelne for Draft Status hasn't been updated");
		Action.waitForElementToBeClickable(driver, btnCancel, 10);
		Action.clickUsingJavaScipt(btnCancel);
		rowNoeditpipelineDraft = CommonElementsPage.getRowNo(editPipelineName);
		System.out
				.println("Edited pipeline name is:" + CommonElementsPage.getRowCellTextVal(rowNoeditpipelineDraft, 1));
		Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowNoeditpipelineDraft, 1), editPipelineName,
				"Draft status Pipeline record has not been Edited");
		Assert.assertTrue(
				CommonElementsPage.getRowCellTextVal(rowNoeditpipelineDraft, 2).equals("ACTIVE")
						&& !CommonElementsPage.getRowCellTextVal(rowNoeditpipelineDraft, 5).contains("Delete Pipeline"),
				"Delete pipeline icon exist for Active status record");

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
		System.out.println("selected pipeline name to change status is:"
				+ CommonElementsPage.getRowCellTextVal(rowNoeditpipelineDraft, 1));
		Action.scrollToBottomofPage();
		Reporter.log("Click Edit Pipeline Icon for Active status record");
		CommonElementsPage.clickDivSpanLink(rowNoeditpipelineDraft, 5, 0, 3, 1);
		Action.selectByIndex(drpdwnPipelineStatus, 0);
		Common.clickonCalendarDate(txtStartDate, pipelinedata.getpipelineStartDate());
		Common.clickonCalendarDate(txtEndDate, pipelinedata.getpipelineEndDate());
		btnSaveViewConfig.click();
		Common.waitForElementPresent(driver, btnContinue, 05);
		btnContinue.click();
		Assert.assertEquals(txtSuccessMsg.getText(), RomuiEnumValues.PIPELINE_EDIT.getMessage(),
				"Pipelne for Active Status hasn't been updated");
		Action.waitForElementToBeClickable(driver, btnCancel, 10);
		Action.clickUsingJavaScipt(btnCancel);
		rowNoeditpipelineActive = CommonElementsPage.getRowNo(editPipelineName);
		System.out.println("Selected row for active edit pipeline is "
				+ CommonElementsPage.getRowCellTextVal(rowNoeditpipelineActive, 1));
		Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowNoeditpipelineActive, 2), "INACTIVE",
				"Active status Pipeline record has not been Edited");
		Assert.assertTrue(CommonElementsPage.getRowCellTextVal(rowNoeditpipelineActive, 2).equals("INACTIVE")
				&& !CommonElementsPage.getRowCellTextVal(rowNoeditpipelineActive, 5).contains("Delete Pipeline"),
				"Delete pipeline icon exist for InActive status record");

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
		Action.scrollToBottomofPage();
		Reporter.log("Click Edit Pipeline Icon for Inactive status record");
		System.out.println("Selected Row for edit Pipeline which is in Active status::" + rowNoeditpipelineActive);
		CommonElementsPage.clickDivSpanLink(rowNoeditpipelineActive, 5, 0, 3, 1);
		Action.selectByIndex(drpdwnPipelineStatus, 1);
		Common.clickonCalendarDate(txtStartDate, pipelinedata.getpipelineStartDate());
		Common.clickonCalendarDate(txtEndDate, pipelinedata.getpipelineEndDate());
		btnSaveViewConfig.click();
		Common.waitForElementPresent(driver, btnContinue, 05);
		btnContinue.click();
		Assert.assertEquals(txtSuccessMsg.getText(), RomuiEnumValues.PIPELINE_EDIT.getMessage(),
				"Pipelne for Inactive status hasn't been updated");
		Action.waitForElementToBeClickable(driver, btnCancel, 10);
		Action.clickUsingJavaScipt(btnCancel);
		int rowNoeditpipelineInActive = CommonElementsPage.getRowNo(editPipelineName);
		System.out.println("selected row for edit inactive status pipeline is::"
				+ CommonElementsPage.getRowCellTextVal(rowNoeditpipelineInActive, 1));
		Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowNoeditpipelineInActive, 2), "ACTIVE",
				"Inactive status Pipeline record has not been Edited");
	}

	public void deletePipeline() throws JsonParseException, JsonMappingException, IOException, Exception {
		addPipeline();
		System.out
				.println("Selected row is for deletion::" + CommonElementsPage.getRowCellTextVal(rowNoaddPipeline, 1));
		if (CommonElementsPage.getRowCellTextVal(rowNoaddPipeline, 2).equals("DRAFT")
				&& btnDeletePipeline.isDisplayed()) {
			Action.scrollToBottomofPage();
			Reporter.log("Click delete icon for draft status record");
			CommonElementsPage.clickSelectBtnSpanLink(rowNoaddPipeline, 5, 1);
			Action.waitForElementToBeClickable(driver, btnConfirm, 10);
			btnConfirm.click();
		} else {
			System.out.println("delete Icon not found for Draft Status Record");
		}
	}

	public void copyPipelineDraftStatus() throws JsonParseException, JsonMappingException, IOException, Exception {
		// addPipeline();
		Action.scrollToBottomofPage();
		Reporter.log("Click Copy Pipeline Icon for Draft status record");
		CommonElementsPage.clickDivSpanLink(rowNoaddPipeline, 5, 0, 2, 1);
		pipelinedata = PipelineData.get(env.getFileLocation());
		String copypipelineName = pipelinedata.getPipelineName();
		Action.waitForElementToBeClickable(driver, txtBoxPipelineName, 10);
		txtBoxPipelineName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Action.enter(txtBoxPipelineName, copypipelineName);
		Common.clickonCalendarDate(txtStartDate, pipelinedata.getpipelineStartDate());
		Common.clickonCalendarDate(txtEndDate, pipelinedata.getpipelineEndDate());
		btnSaveAddConfig.click();
		Action.waitForElementToBeClickable(driver, btnSave, 10);
		Action.clickUsingJavaScipt(btnSave);
		Action.waitForElementToBeClickable(driver, btnContinueConfig, 10);
		btnContinueConfig.click();
		int copypipelineDraft = CommonElementsPage.getRowNo(copypipelineName);
		Assert.assertEquals(CommonElementsPage.getRowCellTextVal(copypipelineDraft, 1), copypipelineName,
				"Copy Pipeline for Draft status has not Saved Successfull");

	}

	public void copyPipelineActiveStatus() throws JsonParseException, JsonMappingException, IOException, Exception {
		// editPipeline();
		Action.scrollToBottomofPage();
		Reporter.log("Click Copy Pipeline Icon for Active status record");
		CommonElementsPage.clickDivSpanLink(rowNoeditpipelineDraft, 5, 0, 2, 1);
		pipelinedata = PipelineData.get(env.getFileLocation());
		String copypipelineName = pipelinedata.getPipelineName();
		Action.waitForElementToBeClickable(driver, txtBoxPipelineName, 10);
		txtBoxPipelineName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Action.enter(txtBoxPipelineName, copypipelineName);
		Common.clickonCalendarDate(txtStartDate, pipelinedata.getpipelineStartDate());
		Common.clickonCalendarDate(txtEndDate, pipelinedata.getpipelineEndDate());
		btnSaveAddConfig.click();
		Action.waitForElementToBeClickable(driver, btnSave, 10);
		Action.clickUsingJavaScipt(btnSave);
		Action.waitForElementToBeClickable(driver, btnContinueConfig, 10);
		btnContinueConfig.click();
		int copypipelineActive = CommonElementsPage.getRowNo(copypipelineName);
		Assert.assertEquals(CommonElementsPage.getRowCellTextVal(copypipelineActive, 1), copypipelineName,
				"Copy Pipeline for Active status has not Saved Successfull");

	}

	public void copyPipelineInActiveStatus() throws JsonParseException, JsonMappingException, IOException, Exception {
		// editPipelineActiveStatus();
		Action.scrollToBottomofPage();
		Reporter.log("Click Copy Pipeline Icon for Inactive status record");
		CommonElementsPage.clickDivSpanLink(rowNoeditpipelineActive, 5, 0, 2, 1);
		pipelinedata = PipelineData.get(env.getFileLocation());
		String copypipelineName = pipelinedata.getPipelineName();
		Action.waitForElementToBeClickable(driver, txtBoxPipelineName, 10);
		txtBoxPipelineName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Action.enter(txtBoxPipelineName, copypipelineName);
		Common.clickonCalendarDate(txtStartDate, pipelinedata.getpipelineStartDate());
		Common.clickonCalendarDate(txtEndDate, pipelinedata.getpipelineEndDate());
		btnSaveAddConfig.click();
		Action.waitForElementToBeClickable(driver, btnSave, 10);
		Action.clickUsingJavaScipt(btnSave);
		Action.waitForElementToBeClickable(driver, btnContinueConfig, 10);
		btnContinueConfig.click();
		int copypipelineInActive = CommonElementsPage.getRowNo(copypipelineName);
		Assert.assertEquals(CommonElementsPage.getRowCellTextVal(copypipelineInActive, 1), copypipelineName,
				"Copy Pipeline for Inactive status has not been Saved Successfully");

	}

	public void editPipelienConfigurationDraft() throws Exception {
		addPipeline();
		Action.scrollToBottomofPage();
		Reporter.log("Click Edit Pipeline Configuration Icon for Draft status record");
		CommonElementsPage.clickDivSpanLink(rowNoaddPipeline, 5, 0, 4, 1);
		Action.waitForElementToBeClickable(driver, btnSave, 10);
		Action.clickUsingJavaScipt(btnSave);
		Action.waitForElementToBeClickable(driver, btnContinueConfig, 10);
		btnContinueConfig.click();

	}

	public void editPipelienConfigurationActive() throws Exception {
		// addPipeline();
		Action.scrollToBottomofPage();
		Reporter.log("Click Edit Pipeline Configuration Icon for Active status record");
		CommonElementsPage.clickDivSpanLink(rowNoaddPipeline, 5, 0, 4, 1);
		Action.waitForElementToBeClickable(driver, btnCancel, 10);
		Action.clickUsingJavaScipt(btnCancel);
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
		Action.waitForElementToBeClickable(driver, btnPipelineCriteriaConfirm, 10);
		btnPipelineCriteriaConfirm.click();
	}

	// Below method is for form validation
	public void pipelineFormValidation()
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		btnAddPipeline.click();
		btnSaveExit.click();
		Assert.assertEquals(txtformvalidationError.getText(), RomuiEnumValues.PIPELINE_FORMVALIDATION.getMessage(),
				"Pipeline form Error Validation message has not been found");
		// Select By Fulfillment Method
		Reporter.log("Selecting Fulfillment Method type for Pipeline Criteria");
		selectPipelineCriteria(0, 0, 0, 0, 1);
		btnSaveExit.click();
		Assert.assertEquals(CommonElementsPage.txtAlertErrorMsg.getText(), RomuiEnumValues.FORM_ERROR.getMessage(),
				"Pipeline form Error Validation message has not been found");

	}

}