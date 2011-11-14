package br.com.biopids.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static Date incrementMonth(Date date, Integer month){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH , month);
        return calendar.getTime();
	}
	
	public static Date incrementDays(Date date, Integer days){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

}
