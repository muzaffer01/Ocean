package com.selenium.muzzar.util;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.muzzafar.util.Configuration;

public class Utils {

	   public static void takeSnapShot(WebDriver Scdriver) throws Exception{
	        //Convert web driver object to TakeScreenshot
	        TakesScreenshot scrShot =((TakesScreenshot)Scdriver);
	        //Call getScreenshotAs method to create image file
	          File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	          //Move image file to new destination
	        Configuration con = new Configuration();
	        String fileName=con.getdateformat();
	           File DestFile=new File(Configuration.PROJECT_PATH+"\\screenshots\\"+fileName+"_IMG.jpeg");
	           //Copy file at destination
	           FileHandler.copy(SrcFile, DestFile);               
	    }
	   
	   
	   
	
}
