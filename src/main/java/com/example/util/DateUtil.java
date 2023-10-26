package com.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateUtil {

	public static Date getDateIndianFormat (String date_string ) {
		Date date=null;
		try {
		 
			//Instantiating the SimpleDateFormat class
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
			//Parsing the given String to Date object


			date = formatter.parse(date_string);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return date;
	}
}
