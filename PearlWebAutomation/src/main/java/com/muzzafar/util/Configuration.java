package com.muzzafar.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Configuration {
	public static String PROJECT_PATH = System.getProperty("user.dir");
	
	
	public String getdateformat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-MM-SS");
		String date = sdf.format(new Date());
		return date;
		
	}
}
