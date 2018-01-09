package com.valuelabs.timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TodayTime {

	public static void main(String[] args) {
		DateFormat date=new SimpleDateFormat("yyyy/MM/dd");
		Date dt=new Date(System.currentTimeMillis()+24*60*60*1000);
		System.out.println(date.format(dt));
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date1 = new Date();
		System.out.println(dateFormat.format(date1)); 
	}

}
