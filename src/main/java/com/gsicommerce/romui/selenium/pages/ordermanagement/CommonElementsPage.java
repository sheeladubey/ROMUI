package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.Webtable;

public class CommonElementsPage {

	static WebDriver driver;
	Environment env;
	Action action;

	public CommonElementsPage(WebDriver driver, Environment env) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);

	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save')]")
	@CacheLookup
	private static WebElement btnSave;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Add')]")
	@CacheLookup
	private static WebElement btnAdd;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save & Exit')]")
	@CacheLookup
	private static WebElement btnSaveExit;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Cancel')]")
	@CacheLookup
	private static WebElement btnCancel;

	@FindBy(how = How.CSS, using = "[type='submit']")
	@CacheLookup
	private static WebElement btnSearch;

	@FindBy(how = How.CSS, using = "[data-tooltip='Show Advanced Search']")
	@CacheLookup
	private static WebElement btnAdvanceSearch;

	@FindBy(how = How.CSS, using = "#limit")
	@CacheLookup
	private static WebElement drpdwnPagLimit;

	@FindBy(how = How.CSS, using = "span.ss-icon.ss-navigateright.ss-black-tie-bold")
	private static WebElement lkNextPage;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Confirm')]")
	@CacheLookup
	private static WebElement btnConfirm;

	@FindBy(how = How.CSS, using = "#store_fulfillment_pick_ticket_hold_location")
	@CacheLookup
	private static WebElement txtStagingLoc;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue')]")
	@CacheLookup
	private static WebElement btnContinue;

	@FindBy(how = How.CSS, using = ".reflow-table")
	private static WebElement nodeWebTable;
	

	@FindBy(how = How.CSS, using = ".table-responsive")
	private static WebElement nodeWebTableFulfillmentOrders;
	
	@FindBy(how = How.CSS, using = ".alert-danger")
	private static WebElement txtformvalidationError;
	
	@FindBy(how = How.XPATH, using = ".//option")
	private static List<WebElement> selectDropDownOption;
	
	
	public static Webtable nodeWebTable() {
		Webtable wt = new Webtable(driver, (WebElement) nodeWebTable);
		return wt;
	}

	public static void clickOnSaveBtn() {
	//	btnSave.click();
		Action.clickElementJavaScipt(btnSave);
	}

	public static void clickOnAddBtn() {
		Action.waitForElementToBeClickable(driver, btnAdd, 10);
		btnAdd.click();
	}

	public static void clickOnCancelBtn() {
		btnCancel.click();

	}

	public static void clickOnSearchBtn() {
		btnSearch.click();
	}

	public static void clickOnAdvncSearchBtn() {
		btnAdvanceSearch.click();
	}

	public static void clickOnConfirmBtn() {
		btnConfirm.click();
	}

	public static void clickOnContinueBtn() {
		btnContinue.click();
	}

	public static void selectLimitPerPage() {
		if (drpdwnPagLimit.isDisplayed()) {
			Select se = new Select(drpdwnPagLimit);
			List<WebElement> listOfOptions = se.getOptions();
			int count = listOfOptions.size();
			Action.selectByIndex(drpdwnPagLimit, count - 1);
		}
	}

	public static void clickNextPage() {
		if (lkNextPage.isEnabled()) {
			lkNextPage.click();
		}
	}

	public static int getRowNo(String nodeID) throws Exception {
		selectLimitPerPage();
		Reporter.log("page limit drop down value is selected");

		int rowNo = 0;
		rowNo = nodeWebTable().getTableRowNumForCellText(nodeID, 1);
		while (rowNo <= 0) {
			CommonElementsPage.clickNextPage();
			Common.waitForElement(driver, nodeWebTable, 10);
			rowNo = nodeWebTable().getTableRowNumForCellText(nodeID, 1);
		}
		return rowNo;

	}
//get row number for pipeline screen
	public static int getRowNum(String pipelineName) throws Exception {
		int rowNo = 0;
		rowNo = nodeWebTable().getTableRowNumForCellText(pipelineName, 1);
		while (rowNo <= 0) {
			// CommonElementsPage.clickNextPage();
			Common.waitForElement(driver, nodeWebTable, 10);
			rowNo = nodeWebTable().getTableRowNumForCellText(pipelineName, 1);
		}
		return rowNo;

	}
	public static int getTotalRows() throws Exception {
		Reporter.log("Get Total No of Rows in the webtable");
		return nodeWebTable().GetNumOfRows();
	}

	
	public static void clickActionsIcon(int row, int col, int child) throws Exception {
		Reporter.log("Action icon is clicked on");
		nodeWebTable().clickIcon(row, col, child);
	}

	// method to click action icons for pipeline screen

	public static  void clickActionsIcon(int row, int col, int child, int spanchild) throws Exception {
		Reporter.log("Action icon is clicked on");
		nodeWebTable().clickIconPipeline(row, col, child, spanchild);
	}

	// method to click delete action icons for pipeline screen
	public static void clickDeleteIcon(int row, int col, int spanchild) throws Exception {
		Reporter.log("Action icon is clicked on");
		nodeWebTable().clickDeleteIconPipeline(row, col, spanchild);
	}

	public static void enterStagingLoc(String loc) throws Exception {
		Action.enter(txtStagingLoc, loc);
		btnAdd.click();
	}

	public static void clickOnSaveExitBtn() {
		btnSaveExit.click();
	}
	
	public static int getRoleRowNum(String userId) throws Exception {
		selectLimitPerPage();
		Reporter.log("page limit drop down value is selected");
		int rowNo = 0;
		rowNo = nodeWebTable().getTableRowNumForCellText(userId, 1);
		while (rowNo <= 0) {
			CommonElementsPage.clickNextPage();
			Common.waitForElement(driver, nodeWebTable, 10);
			rowNo = nodeWebTable().getTableRowNumForCellText(userId, 1);
		}
		return rowNo;		

	}
	public static void clickActionsIconDelete(int row, int col, int child, int spanchild) throws Exception {
		Reporter.log("Delete icon is clicked on");
		nodeWebTable().clickIconDelete(row, col, child, spanchild);
	}

	public static void clickViewOrderIcon(int row, int col, int divchild, int child, int spanchild) throws Exception {
			Reporter.log("View Order icon is clicked on");
			nodeWebTable().clickIconViewOrder(row, col, divchild,child, spanchild);
		
	}
	
	public static Webtable nodeWebTableFulfillmentOrders() {
		Webtable wt = new Webtable(driver, (WebElement) nodeWebTableFulfillmentOrders);
		return wt;
	}
	
	//get row number for fulfillment orders screen
		public static int getRowNumFulfillmentOrders(String fulfillmentOrd) throws Exception {
			int rowNo = 0;
			rowNo = nodeWebTableFulfillmentOrders().getTableRowNumForCellText(fulfillmentOrd, 1);
			while (rowNo <= 0) {
				// CommonElementsPage.clickNextPage();
				Common.waitForElement(driver, nodeWebTable, 10);
				rowNo = nodeWebTableFulfillmentOrders().getTableRowNumForCellText(fulfillmentOrd, 1);
			}
			return rowNo;

		}
		
		public static String formErrorValidation() {
			return txtformvalidationError.getText();
		}

			//Select values from dropdown 
		public static void selectDropDwnValues(WebElement el,String selectOption) {
			//el.click();
			Action.clickElementJavaScipt(el);
			for (int i = 0; i < selectDropDownOption.size(); i++) {
				System.out.println(selectDropDownOption.get(i).getText());
				if (selectDropDownOption.get(i).getText().equals(selectOption)) {
					Action.selectByIndex(el, i);
					
					break;
				}
			}
			
		}
		
		public static void clickSingleRowActionsIcon(int col, int child) throws Exception {
			Reporter.log("Action icon is clicked on");
			nodeWebTable().clickSpanIconForSingleRow(col, child);
		}

		public static void clickSelectLink(int row, int col) throws Exception {
			Reporter.log("Action icon is clicked on");
			nodeWebTable().clickButton(row, col);
		}

		public static void clickActionsSpanIcon(int row, int col, int index) throws Exception {
			Reporter.log("Action icon is clicked on");
			nodeWebTable().clickSpanElement(row, col, index);
		}
		
	
	
}
