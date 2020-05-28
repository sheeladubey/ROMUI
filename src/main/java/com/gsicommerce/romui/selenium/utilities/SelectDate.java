package com.gsicommerce.romui.selenium.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SelectDate {

    static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");

	public static String selectCurrentDate(Calendar dateCurrent) {
		Date currentDate = new Date();
		Calendar currentDateInstance1 = Calendar.getInstance();
		currentDateInstance1.setTime(currentDate);
		currentDateInstance1.add(Calendar.DATE, 0);
		currentDate = currentDateInstance1.getTime();
		String currentDate1 = sdf.format(currentDate);
		return currentDate1;
	}

	public static String selectStartDate(Calendar startDateCal) {

		Date startDate = new Date();
		Calendar currentDateInstance = Calendar.getInstance();
		currentDateInstance.setTime(startDate);
		currentDateInstance.add(Calendar.DATE, 1);
		startDate = currentDateInstance.getTime();
		 String futureStartDate = sdf.format(startDate);
		return futureStartDate;		

	}

	public static String selectEndDate(Calendar endDateCal) {
		Date endDate = new Date();
		Calendar endDateCal1 = Calendar.getInstance();
		endDateCal1.setTime(endDate);
		endDateCal1.add(Calendar.DATE, 7);
		endDate = endDateCal1.getTime();	
		String futureEndDate = sdf.format(endDate);
		return futureEndDate;
	

	}
}
