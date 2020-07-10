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
	static Environment env;
	Action action;

	public CommonElementsPage(WebDriver driver, Environment env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		action = new Action(driver, env);
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save')]")
	public static WebElement btnSave;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Add')]")
	private static WebElement btnAdd;

	@FindBy(how = How.CSS, using = "[type='submit']")
	public static WebElement btnSearch;

	@FindBy(how = How.CSS, using = "[data-tooltip='Show Advanced Search']")
	@CacheLookup
	private static WebElement btnAdvanceSearch;

	@FindBy(how = How.CSS, using = "#limit")
	@CacheLookup
	private static WebElement drpdwnPagLimit;

	@FindBy(how = How.CSS, using = "span.ss-icon.ss-navigateright.ss-black-tie-bold")
	private static WebElement lkNextPage;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Confirm')]")
	private static WebElement btnConfirm;

	@FindBy(how = How.CSS, using = "#store_fulfillment_pick_ticket_hold_location")
	@CacheLookup
	private static WebElement txtStagingLoc;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue')]")
	@CacheLookup
	private static WebElement btnContinue;

	@FindBy(how = How.CSS, using = ".reflow-table")
	private static WebElement nodeWebTable;

	@FindBy(how = How.CSS, using = ".alert-info")
	@CacheLookup
	public WebElement txtEditSuccessMsg;

	@FindBy(how = How.CSS, using = "[data-tooltip='Search'] span.ss-search.ss-icon")
	private static WebElement iconSearch;

	@FindBy(how = How.CSS, using = "[role='alert']")
	public static WebElement txtAlertErrorMsg;

	@FindBy(how = How.XPATH, using = ".//option")
	public static List<WebElement> selectDropDownOption;

	@FindBy(how = How.CSS, using = "[name='pick_selected'] span")
	public static WebElement btnPickSelected;

	@FindBy(how = How.CSS, using = "[data-bulk-decline=''] span")
	public static WebElement btnBulkDecline;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Get My Tickets')]")
	private static WebElement btnGetMyTickets;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Cancel')]")
	private static WebElement btnCancel;

	public static Webtable nodeWebTable() {
		Webtable wt = new Webtable(driver, (WebElement) nodeWebTable);
		return wt;
	}

	public static void clickOnSaveBtn() {
		Action.waitForElementToBeClickable(driver, btnSave, 30);
		// btnSave.click();
		Action.clickUsingJavaScipt(btnSave);
	}

	public static void clickOnAddBtn() {
		Action.waitForElementToBeClickable(driver, btnAdd, 30);
		// btnAdd.click();
		Action.clickUsingJavaScipt(btnAdd);
	}

	public static void clickOnSearchBtn() {
		// btnSearch.click();
		Action.clickUsingJavaScipt(btnSearch);
	}

	public static void clickOnAdvncSearchBtn() {
		btnAdvanceSearch.click();
	}

	public static void clickOnConfirmBtn() {
		Action.waitForElementToBeClickable(driver, btnConfirm, 10);
		btnConfirm.click();
	}

	public static void clickOnContinueBtn() {
		btnContinue.click();
	}

	public static void selectLimitPerPage() {
		try {
			if (drpdwnPagLimit.isDisplayed()) {
				Select se = new Select(drpdwnPagLimit);
				List<WebElement> listOfOptions = se.getOptions();
				int count = listOfOptions.size();
				Action.selectByIndex(drpdwnPagLimit, count - 1);
			}
		} catch (Exception ex) {
			Reporter.log("There is no page limit option displayed");
		}
	}

	public static void clickNextPage() {
		if (lkNextPage.isEnabled()) {
			lkNextPage.click();
		}
	}

	public static int getRowNo(String nodeID, int col) throws Exception {
		selectLimitPerPage();
		Thread.sleep(3000);
		Reporter.log("page limit drop down value is selected");
		int rowNo = 0;
		rowNo = nodeWebTable().getTableRowNumForCellText(nodeID, col);
		while (rowNo <= 0) {
			CommonElementsPage.clickNextPage();
			Common.waitForElement(driver, nodeWebTable, 10);
			rowNo = nodeWebTable().getTableRowNumForCellText(nodeID, col);
		}
		return rowNo;
	}

	public static void clickActionsIcon(int row, int col, int child) throws Exception {
		Reporter.log("Action icon is clicked on");
		if (row == 0) {
			nodeWebTable().clickSpanIconForSingleRow(col, child);
		} else {
			nodeWebTable().clickIcon(row, col, child);
		}
	}

	public static void enterStagingLoc(String loc) throws Exception {
		Action.enter(txtStagingLoc, loc);
	}

	public static void clickOnSearchIcon() {
		Action.waitForElementToBeClickable(driver, iconSearch, 30);
		if ("firefox,ie".contains(env.getBrowserType())) {
			Action.clickUsingJavaScipt(iconSearch);
		} else {
			/* iconSearch.click(); */
			Action.clickUsingJavaScipt(iconSearch);
		}
	}

	public static String getRowCellTextVal(int row, int col) throws Exception {
		Reporter.log("Getting the column value of the first row");
		return nodeWebTable().getTableCellText(row, col);
	}

	public static void clickSingleRowActionsIcon(int col, int child) throws Exception {
		Reporter.log("Action icon is clicked on");
		nodeWebTable().clickSpanIconForSingleRow(col, child);
	}

	public static int getTotalRows() throws Exception {
		Reporter.log("Get Total No of Rows in the webtable");
		return nodeWebTable().GetNumOfRows();
	}

	public static void clickSelectLink(int row, int col, int divchild, int buttonchild) throws Exception {
		Reporter.log("Action icon is clicked on");
		nodeWebTable().clickButton(row, col, divchild, buttonchild);
	}

	public static void clickActionsSpanIcon(int row, int col, int index) throws Exception {
		Reporter.log("Action icon is clicked on");
		nodeWebTable().clickSpanElement(row, col, index);
	}

	public static void clickDivSpanLink(int row, int col, int divchild, int child, int spanchild) throws Exception {
		Reporter.log("View Order icon is clicked on");
		nodeWebTable().clickDivLinkSpanElement(row, col, divchild, child, spanchild);

	}

	public static void clickSelectBtnSpanLink(int row, int col, int spanChild) throws Exception {
		Reporter.log("Action icon for span element is clicked on");
		nodeWebTable().clickButtonSpanElement(row, col, spanChild);
	}

	// Select values from dropdown
	public static void selectDropDwnValues(WebElement el, String selectOption) {
		// el.click();
		Action.clickUsingJavaScipt(el);
		for (int i = 0; i < selectDropDownOption.size(); i++) {
			// System.out.println(selectDropDownOption.get(i).getText());
			if (selectDropDownOption.get(i).getText().equals(selectOption)) {
				Action.selectByIndex(el, i);

				break;
			}
		}

	}

	public static String getSingleRowCellTextVal(int col) throws Exception {
		Reporter.log("Getting the column value of the row");
		return nodeWebTable().getTableCellText(col);
	}

	public static void clickActionsIconWithoutSpan(int row, int col, int child) throws Exception {
		Reporter.log("Action icon is clicked on");
		if (row == 0) {
			nodeWebTable().clickSingleRowActionIconWithChild(col, child);
		} else {
			nodeWebTable().clickIcon(row, col, child);
		}
	}

	public static void clickOnGetMyTicketsBtn() {
		// btnGetMyTickets.click();
		Action.clickUsingJavaScipt(btnGetMyTickets);
	}

	public static void clickOnCancelBtn() {
		btnCancel.click();
	}

	public static void clickDivChildSpanLink(int row, int col, int divchild, int child, int spanchild)
			throws Exception {
		Reporter.log("View Order icon is clicked on");
		nodeWebTable().clickDivChildLinkSpanElement(row, col, divchild, child, spanchild);
	}

}
