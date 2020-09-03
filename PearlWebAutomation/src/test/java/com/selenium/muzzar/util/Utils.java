package com.selenium.muzzar.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;
import com.muzzafar.util.Configuration;

public class Utils {

	   public String takeSnapShot(WebDriver Scdriver) {
		   double d= Math.random();
			String fileName=Double.toString(d);
			TakesScreenshot ts = (TakesScreenshot)Scdriver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = Configuration.PROJECT_PATH+"\\screenshots\\"+fileName+"_IMG.jpeg";
	        File destination = new File(dest);
	        try {
				Files.copy(source, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        return dest; 
    
	    }
	   
	   
	   
	
}
