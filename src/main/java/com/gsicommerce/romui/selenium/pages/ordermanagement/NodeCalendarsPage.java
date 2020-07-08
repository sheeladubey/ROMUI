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
import com.gsicommerce.romui.selenium.utilities.Common;



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
	
	@FindBy(how = How.CSS, using = "#default_day-toggle")
	private WebElement toggleDefaultDay;
	
	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_default_day_attributes_cut_off_time")
	private WebElement calCutoffTimeDefaultDay;
	
	@FindBy(how = How.CSS, using = ".shift-details-default_day [data-date-time-picker='time']")
	private List<WebElement> shifttime;
	
	@FindBy(how = How.CSS, using = ".default_day-shifts [type='text']")
	private List<WebElement> calShifttime;
	
	@FindBy(how = How.CSS, using = ".calendar-toggle-week .ss-plus")
	private List<WebElement> plusIconDefaultDay;
	
	@FindBy(how = How.CSS, using = "#monday-toggle")
	private WebElement toggleMonday;
	
	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_monday_attributes_cut_off_time")
	private WebElement calCutoffTimeMonday;
	
	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_monday_attributes_shifts_attributes_0_start_time")
	private WebElement calStartTimeMonday;
	
	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_monday_attributes_shifts_attributes_0_end_time")
	private WebElement calEndTimeMonday;
	
	@FindBy(how = How.CSS, using = "#store_fulfillment_calendar_monday_attributes_shifts_attributes_0_max_items")
	private WebElement txtboxMaxitemsMonday;
	
	public void addNodeCalendars() throws JsonParseException, JsonMappingException, IOException
	{
		nodeCalendarsData=NodeCalendarsData.get(env.getFileLocation());
				
		CommonElementsPage.clickOnAddBtn();
		Action.enter(txtboxCalID,nodeCalendarsData.getCalendarID());
		Action.enter(txtboxCalDescrip, nodeCalendarsData.getCalendarDescription());
		Action.scrollDown("300");
		
		toggleDefaultDay.click();
		Action.enter(calCutoffTimeDefaultDay, Common.selectTime(0));
		Action.enter(calShifttime.get(0),Common.selectTime(0));
		Action.enter(calShifttime.get(1), Common.selectTime(1));
		Action.enter(calShifttime.get(2), nodeCalendarsData.getMaxItems());
		
	}

}
