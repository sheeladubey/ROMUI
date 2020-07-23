package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.NodeCalendarsData;
import com.gsicommerce.romui.selenium.utilities.Action;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.RomuiEnumValues;

public class NodeCalendarsPage {

	WebDriver driver;
	Environment env;
	private NodeCalendarsData nodeCalendarsData;
	private static int rowCalID;
	private static String calID;
	private static String calDescrip;

	public NodeCalendarsPage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_id")
	private WebElement txtboxCalID;

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_description")
	private WebElement txtboxCalDescrip;

	@FindBy(how = How.CSS, using = "#default_day-toggle .switch-shim")
	private WebElement toggleDefaultDay;

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_default_day_attributes_cut_off_time")
	private WebElement calCutoffTimeDefaultDay;

	@FindBy(how = How.CSS, using = ".shift-details-default_day [data-date-time-picker='time']")
	private List<WebElement> shifttime;

	@FindBy(how = How.CSS, using = ".default_day-shifts [type='text']")
	private List<WebElement> calShifttime;

	@FindBy(how = How.CSS, using = "[title='Increment Hour'][href='#'][data-action='incrementHours']")
	private WebElement incrementhours;

	@FindBy(how = How.CSS, using = ".calendar-toggle-week .ss-plus")
	private List<WebElement> plusIconDefaultDay;

	@FindBy(how = How.CSS, using = "#monday-toggle .switch-shim")
	private WebElement toggleMonday;

	@FindBy(how = How.CSS, using = "#tuesday-toggle")
	private WebElement toggleTuesday;

	@FindBy(how = How.CSS, using = "#wednesday-toggle")
	private WebElement toggleWednesday;

	@FindBy(how = How.CSS, using = "#thursday-toggle")
	private WebElement toggleThurday;

	@FindBy(how = How.CSS, using = "[name='store_fulfillment_calendar[friday_attributes][working_day]'][type='checkbox']")
	private WebElement toggleFriday;

	@FindBy(how = How.CSS, using = "a.add-exception")
	private WebElement btnAddException;

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_monday_attributes_cut_off_time")
	private WebElement calCutoffTimeMonday;

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_monday_attributes_shifts_attributes_0_start_time")
	private WebElement calStartTimeMonday;

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_monday_attributes_shifts_attributes_0_end_time")
	private WebElement calEndTimeMonday;

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_monday_attributes_shifts_attributes_0_max_items")
	private WebElement txtboxMaxitemsMonday;

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_friday_attributes_cut_off_time")
	private WebElement calCutoffTimeFriday;

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_friday_attributes_shifts_attributes_0_start_time")
	private WebElement calStartTimeFriday;

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_friday_attributes_shifts_attributes_0_end_time")
	private WebElement calEndTimeFriday;

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_friday_attributes_shifts_attributes_0_max_items")
	private WebElement txtboxMaxitemsFriday;

	@FindBy(how = How.CSS, using = ".calendar-working-day-toggle.col-sm-12")
	private WebElement toggleCalExpection;

	@FindBy(how = How.CSS, using = ".alert-info")
	public WebElement txtSuccessMsg;

	@FindBy(how = How.CSS, using = ".col-sm-9")
	private List<WebElement> viewNodeCalDetails;

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_exception_days_attributes_1_exception_date")
	private WebElement CalExceptionDatePicker;

	@FindBy(how = How.CSS, using = ".exception-shift-details-1 [placeholder='hh:mm a']")
	private List<WebElement> ExceptionShiftTime;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Confirm')]")
	private WebElement btnDeleteConfirm;
	
	@FindBy(how = How.XPATH, using = " //span[contains(text(),'Edit')]")
	private WebElement btnEditView;
	
	public void addNodeCalendars() throws Exception {
		nodeCalendarsData = NodeCalendarsData.get(env.getFileLocation());

		CommonElementsPage.clickOnAddBtn();
		calID = nodeCalendarsData.getCalendarID();
		/* Action.enter(txtboxCalID, CalID); */
		System.out.println("Node Calendar ID is::" + calID);
		Action.enter(txtboxCalID, calID);
		calDescrip = nodeCalendarsData.getCalendarDescription();
		System.out.println("Node Calendar Description is::" + calDescrip);
		Action.enter(txtboxCalDescrip, calDescrip);
		Action.scrollDown("300");
		Action.waitForElementToBeClickable(driver, toggleDefaultDay, 10);
		Action.clickUsingJavaScipt(toggleDefaultDay);
		calCutoffTimeDefaultDay.click();
		calShifttime.get(0).click();
		calShifttime.get(1).click();
		incrementhours.click();
		Action.enter(calShifttime.get(2), nodeCalendarsData.getMaxItems());
		Action.scrollDown("400");
		Action.waitForElementToBeClickable(driver, plusIconDefaultDay.get(0), 10);
		plusIconDefaultDay.get(0).click();
		Action.waitForElementToBeClickable(driver, toggleMonday, 10);
		toggleMonday.click();
		Action.waitForElementToBeClickable(driver, calCutoffTimeMonday, 10);
		calCutoffTimeMonday.click();
		Action.scrollDown("400");
		Action.waitForElementToBeClickable(driver, calStartTimeMonday, 10);
		calStartTimeMonday.click();
		Action.waitForElementToBeClickable(driver, calEndTimeMonday, 10);
		calEndTimeMonday.click();
		incrementhours.click();
		Action.enter(txtboxMaxitemsMonday, nodeCalendarsData.getMaxItems());
		Action.scrollDown("400");
		Action.waitForElementToBeClickable(driver, plusIconDefaultDay.get(3), 10);
		plusIconDefaultDay.get(3).click();
		Common.waitForPageLoaded(driver);
		Action.waitForElementToBeClickable(driver, toggleFriday, 20);
		// toggleFriday.click();
		Action.clickUsingJavaScipt(toggleFriday);
		Action.waitForElementToBeClickable(driver, calCutoffTimeFriday, 10);
		calCutoffTimeFriday.click();
		Action.scrollDown("400");
		Action.waitForElementToBeClickable(driver, calStartTimeFriday, 10);
		calStartTimeFriday.click();
		Action.waitForElementToBeClickable(driver, calEndTimeFriday, 10);
		calEndTimeFriday.click();
		incrementhours.click();
		Action.enter(txtboxMaxitemsFriday, nodeCalendarsData.getMaxItems());
		CommonElementsPage.clickOnSaveBtn();
		Assert.assertEquals(txtSuccessMsg.getText(), RomuiEnumValues.NODECALENDARS_ADD.getMessage(),
				"Node Calendars not added successfully");
		rowCalID = CommonElementsPage.getRowNo(calID, 1);
		System.out.println("Newly Added Calendar ID is::" + CommonElementsPage.getRowCellTextVal(rowCalID, 1));
		Reporter.log("Newly Added Calendar ID is::" + CommonElementsPage.getRowCellTextVal(rowCalID, 1));
		Assert.assertEquals(CommonElementsPage.getRowCellTextVal(rowCalID, 1), calID, "CALENDAR ID not added");

	}

	public void viewNodeCalendars() throws Exception {
		nodeCalendarsData = NodeCalendarsData.get(env.getFileLocation());
		System.out.println("Selected row for CAL ID is::" + rowCalID);
		System.out.println("Selected Calendar ID is:" + CommonElementsPage.getRowCellTextVal(rowCalID, 1));
		System.out.println("Click on View Calendar icon");
		Reporter.log("Click on View Calendar icon");
		CommonElementsPage.clickDivSpanLink(rowCalID, 3, 1, 1, 1);
		Reporter.log("Validate Calendars ID is" + calID);
		Assert.assertTrue(verifyViewNodeCalendars(0, calID), "No Data found for Node Calendar ID");
		Reporter.log("Validate Calendars Description is" + calDescrip);
		Assert.assertTrue(verifyViewNodeCalendars(0, calDescrip), "No Data found for Node Calendar Description");
	}

	public boolean verifyViewNodeCalendars(int index, String expected) throws Exception {
		boolean found = false;
		String actual = viewNodeCalDetails.get(index).getText();
		if (actual.contains(expected)) {
			found = true;
		} else {
			found = false;
		}
		return found;
	}
	
	public void clickEditNodeCalendar() throws Exception
	{
		nodeCalendarsData = NodeCalendarsData.get(env.getFileLocation());
		System.out.println("Selected row for CAL ID is::" + rowCalID);
		System.out.println("Selected Calendar ID is:" + CommonElementsPage.getRowCellTextVal(rowCalID, 1));
		System.out.println("Click on Edit Calendar icon");
		Reporter.log("Click on Edit Calendar icon");
		CommonElementsPage.clickDivSpanLink(rowCalID, 3, 1, 2, 1);
	}

	public void editNodeCalendars() throws Exception {
		nodeCalendarsData = NodeCalendarsData.get(env.getFileLocation());
		Common.waitForPageLoaded(driver);
		Action.enter(txtboxCalDescrip, nodeCalendarsData.getCalendarDescription());
		Action.scrollToBottomofPage();
		btnAddException.click();
		// Action.scrollDown("800");
		Common.waitForPageLoaded(driver);
		Action.scrollToBottomofPage();
		Action.scrollDown("500");
		Action.waitForElementToBeClickable(driver, CalExceptionDatePicker, 20);
		Common.clickonCalendarDate(CalExceptionDatePicker, nodeCalendarsData.getExceptionDate());
		ExceptionShiftTime.get(1).click();
		Action.waitForElementToBeClickable(driver, ExceptionShiftTime.get(0), 10);
		ExceptionShiftTime.get(0).click();
		Action.waitForElementToBeClickable(driver, ExceptionShiftTime.get(1), 10);
		ExceptionShiftTime.get(1).click();
		incrementhours.click();
		CommonElementsPage.clickOnSaveBtn();

	}

	public void deleteNodeCalendars() throws Exception {
		nodeCalendarsData = NodeCalendarsData.get(env.getFileLocation());
		System.out.println("Selected row for CAL ID is::" + rowCalID);
		System.out.println("Selected Calendar ID is:" + CommonElementsPage.getRowCellTextVal(rowCalID, 1));
		System.out.println("Click on Edit Calendar icon");
		Reporter.log("Click on Edit Calendar icon");
		CommonElementsPage.clickSelectLink(rowCalID, 3, 1, 1);
		Common.waitForPageLoaded(driver);
		Action.waitForElementToBeClickable(driver, btnDeleteConfirm, 10);
		btnDeleteConfirm.click();
	}
	
	public void formValidationNodeCalendar()
	{
		CommonElementsPage.clickOnAddBtn();
		CommonElementsPage.clickOnSaveBtn();
		CommonElementsPage.clickOnContinueBtn();
		
	}
	
	public void editNodeCalendarsFromView() throws Exception
	{
		viewNodeCalendars();
		Action.waitForElementToBeClickable(driver, btnEditView, 20);
		btnEditView.click();
		editNodeCalendars();
	}
}
