package com.gsicommerce.romui.selenium.pages.ordermanagement;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.NodeCalendarsData;
import com.gsicommerce.romui.selenium.utilities.Action;

public class NodeCalendarsPage {

	WebDriver driver;
	Environment env;
	private NodeCalendarsData nodeCalendarsData;

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

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_monday_attributes_cut_off_time")
	private WebElement calCutoffTimeMonday;

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_monday_attributes_shifts_attributes_0_start_time")
	private WebElement calStartTimeMonday;

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_monday_attributes_shifts_attributes_0_end_time")
	private WebElement calEndTimeMonday;

	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_monday_attributes_shifts_attributes_0_max_items")
	private WebElement txtboxMaxitemsMonday;

	@FindBy(how = How.CSS, using = ".alert-info")
	public WebElement txtSuccessMsg;

	public void addNodeCalendars() throws JsonParseException, JsonMappingException, IOException {
		nodeCalendarsData = NodeCalendarsData.get(env.getFileLocation());

		CommonElementsPage.clickOnAddBtn();
		System.out.println("Node Calendar ID is::" + nodeCalendarsData.getCalendarID());
		Action.enter(txtboxCalID, nodeCalendarsData.getCalendarID());
		System.out.println("Node Calendar Description is::" + nodeCalendarsData.getCalendarDescription());
		Action.enter(txtboxCalDescrip, nodeCalendarsData.getCalendarDescription());
		Action.scrollDown("300");
		Action.waitForElementToBeClickable(driver, toggleDefaultDay, 10);
		// toggleDefaultDay.click();
		Action.clickUsingJavaScipt(toggleDefaultDay);
		calCutoffTimeDefaultDay.click();
		calShifttime.get(0).click();
		calShifttime.get(1).click();
		incrementhours.click();
		Action.enter(calShifttime.get(2), nodeCalendarsData.getMaxItems());
		Action.scrollDown("400");
		Action.waitForElementToBeClickable(driver, plusIconDefaultDay.get(0), 10);
		plusIconDefaultDay.get(0).click();
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
		CommonElementsPage.clickOnSaveBtn();

	}

}
