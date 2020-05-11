package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.gsicommerce.romui.selenium.testdata.ServiceFlowData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;
import com.gsicommerce.romui.selenium.utilities.SelectDate;

public class ServiceFlowPage {
	
	WebDriver driver;
	Environment env;
	Action action;
	SelectDate selectdate;
	private ServiceFlowData data;
	Calendar futureStartDate = null;
	Calendar dateCurrent = null;
	Calendar endDateCal = null;
	

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
	
	
	
	
	@FindBy(how = How.CSS, using = ".alert-info")
	@CacheLookup
	public WebElement txtSuccessMsg;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Add')]")
	@CacheLookup
	private WebElement btnAddSvcFlw;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add Process')]")
	@CacheLookup
	private WebElement btnAddProcess;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'View Service Flow Configuration')]")
	@CacheLookup
	private WebElement viewSvcFlwConfig;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'header__primary-text header__primary-text--solo')]")
	@CacheLookup
	public WebElement txtSvcFlwScreenHeader;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'header__primary-text header__primary-text--solo')]")
	@CacheLookup
	public WebElement viewSvcFlwConfigHeader;

	@FindBy(how = How.XPATH, using = "//tr[1]//td[2]//span[1]")
	@CacheLookup
	private WebElement secondColumn;

	@FindBy(how = How.CSS, using = "[data-disable-with='Confirm']")
	@CacheLookup
	public WebElement btnConfirm;
	
	@FindBy(how = How.CSS, using = "#process_name")
	@CacheLookup
	public WebElement drpdwnProcessName;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue')]")
	@CacheLookup
	public WebElement btnContinue;
	
	@FindBy(how = How.XPATH, using = "(//label[contains(text(),'Value')]/following-sibling::input)[2]")
	@CacheLookup
	public WebElement txtboxValue;
	
	@FindBy(how = How.XPATH, using = "(//label[contains(text(),'Value')]/following-sibling::input)[4]")
	@CacheLookup
	public WebElement txtboxValue2;

	public void addSvcFlw() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = ServiceFlowData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddSvcFlw, 06);
		btnAddSvcFlw.click();
		Action.enter(txtBoxSvcFlwName, data.getSvcFlwName());
		Action.selectByValue(drpdwnSvcName, "Shipment");
		selectSvcFlwCriteriaByTenderType();
		btnSaveConfigProcess.click();
		
		//btnSave.click();
	}
	public void editSvcFlw() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		data = ServiceFlowData.get(env.getFileLocation());
		Common.waitForElementPresent(driver, btnAddSvcFlw, 06);
		btnAddSvcFlw.click();
		Action.enter(txtBoxSvcFlwName, data.getSvcFlwName());
		Action.selectByValue(drpdwnSvcName, "Shipment");
		selectSvcFlwCriteriaByTenderType();
		btnSaveConfigProcess.click();
		//addSvcFlwProcess();
		//btnSave.click();

	}
	public void selectSvcFlwCriteriaByTenderType() {

		Action.selectByIndex(drpdwnSvcFlwCriteriaGroupStart, 1);
		Action.selectByIndex(drpdwnSvcFlwCriteriaType, 5);
		Action.selectByIndex(drpdwnSvcFlwCriteriaOperator, 1);
		Action.selectByIndex(drpdwnSvcFlwCriteriaValue, 2);
		Action.selectByIndex(drpdwnSvcFlwCriteriaGroupEnd, 2);
		btnSvcFlwCriteriaConfirm.click();
	}
	
	public void addSvcFlwProcess1() {
		
		Action.waitForElementToBeClickable(driver, btnAddProcess, 10);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnAddProcess); 
		System.out.println("Add process btn clicked");
		Common.waitForElement(driver, drpdwnProcessName, 10);	
		drpdwnProcessName.submit();
		Action.selectByIndex(drpdwnProcessName, 0);
		selectValueFromDropDown(drpdwnProcessName,"OTF-Generation");
		txtboxValue.clear();
		//txtboxValue.sendKeys("Test");	
		Action.enter(txtboxValue, "Test");
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500)");
		Action.waitForElementToBeClickable(driver, btnAddProcess, 10);
		btnAddProcess.click();
		if(!drpdwnProcessName.isSelected());
		{
		Common.waitForElement(driver, drpdwnProcessName, 10);	
		drpdwnProcessName.submit();
		Action.selectByIndex(drpdwnProcessName, 1);
		selectValueFromDropDown(drpdwnProcessName,"HRF");
		txtboxValue2.clear();
		txtboxValue2.sendKeys("TestHRF");
		}
	//	}
		
		
	//	btnSave.click();
		}
	
	
	public void selectValueFromDropDown(WebElement drpdwnProcessName, String value)  //You can change "By Selector" to "WebElement element"
	{
		
	    List<WebElement> DropDownlist = driver.findElements(By.cssSelector("#process_name"));
	    System.out.println(DropDownlist.size());
	    Assert.assertEquals(DropDownlist.size(),2, "Provinces List does not match: ");
	    for (int i = 0; i < DropDownlist.size(); i++) {         
	        String strText = DropDownlist.get(i).getText();
	        System.out.println("strtext value" + strText);
	        if(strText.contentEquals(value)) {
	            DropDownlist.get(i).click();
	            break; //Comment this statement to print all values from DropDown on list 
	        }
	        System.out.println("Province " + i + "==========> " + strText);
	    }   
	}
	
	
	/*public void addSvcFlwProcess() throws InterruptedException {
		Action.waitForElementToBeClickable(driver, btnAddProcess, 10);
		btnAddProcess.click();
		Thread.sleep(10000);
		for(int i=1;i<=6;i++)
		{
		Action.selectByIndex(drpdwnProcessName, i);
		 txtboxValue.clear();
			txtboxValue.sendKeys("Test");	
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
		btnAddProcess.click();
		Thread.sleep(10000);
		Action.selectByIndex(drpdwnProcessName, i+1);
		Thread.sleep(10000);
		txtboxValue2.clear();
		txtboxValue2.sendKeys("Test");
		}
		
		
		btnSave.click();
		}
			*/
			
	

}
