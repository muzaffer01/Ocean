package com.selenium.muzzar.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

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
	   
	   
	   
	   
		/*
		 * public void DesiredCapDocker() {
		 * 
		 * DesiredCapabilities cap= new DesiredCapabilities().chrome();
		 * cap.setPlatform(Platform.LINUX); cap.setBrowserName("chrome");
		 * 
		 * 
		 * }
		 * 
		 * 
		 * public void DesiredCapBrowserStack() { DesiredCapabilities caps = new
		 * DesiredCapabilities(); caps.setCapability("os_version", "10");
		 * caps.setCapability("resolution", "1920x1080"); caps.setCapability("browser",
		 * "Chrome"); caps.setCapability("browser_version", "75.0");
		 * caps.setCapability("os", "Windows"); caps.setCapability("name",
		 * "BStack-[Java] Sample Test"); // test name caps.setCapability("build",
		 * "BStack Build Number 1"); // CI/CD job or build name
		 * 
		 * }
		 */
	
}
