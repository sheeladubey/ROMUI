package com.gsicommerce.romui.selenium.testdata;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsicommerce.romui.selenium.utilities.Common;

public class NodeCalendarsData {
	
	@JsonProperty("Calendar ID")
	String CalendarID;
	
	@JsonProperty("Calendar Description")
	String CalendarDescription;
	
	@JsonProperty("Max Items")
	String MaxItems;
	
	@JsonProperty("ExceptionDate")
	Integer ExceptionDate;
	
	public String getCalendarID() {
		return CalendarID + Common.generateRandomID("AUTO");
	}
	
	public String getCalendarDescription() {
		return CalendarDescription + Common.generateRandomID("AUTO");
	}
	
	public String getMaxItems() {
		return MaxItems;
	}
	
	public Integer getExceptionDate()
	{
		return ExceptionDate;
	}

	public static NodeCalendarsData get(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper.readValue(new File(filename), NodeCalendarsData.class);
	}
}
