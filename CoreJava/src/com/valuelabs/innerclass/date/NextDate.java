package com.valuelabs.innerclass.date;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class NextDate {
	public static void main(String ards[]){
		String nextDate = "";

		    /*try {
		        LocalDate date = LocalDate.now();
		        date = date.plusDays(2);
		        nextDate = date.toString();                            //java8
		        System.out.println(nextDate);
		    } finally {
		        
		    }*/
		
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		System.out.println(dt);
	}

}
