package com.selenium.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.muzzafar.readers.PropertyReader;
import com.muzzafar.util.Configuration;

public class TestBase {
	
	WebDriver driver;
	
	@BeforeMethod
	public void invokeBrowser() {
		PropertyReader mypropertyreader= new PropertyReader();
		String getenvivalue=mypropertyreader.getvaluefrompropertyreader("EXEENV");
		switch(getenvivalue) {
		case "UAT":
			System.setProperty("webdriver.chrome.driver", Configuration.PROJECT_PATH+"\\src\\test\\resources\\Binaries\\chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("This is UAT");
			String getuaturl=mypropertyreader.getvaluefrompropertyreader("UAT");
			driver.get(getuaturl);
			
			break;
			
		case "SIT":
			System.setProperty("webdriver.chrome.driver", Configuration.PROJECT_PATH+"\\src\\test\\resources\\Binaries\\chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println(driver);
			System.out.println("This is SIT");
			String getsiturl=mypropertyreader.getvaluefrompropertyreader("SIT");
			driver.get(getsiturl);
			break;
		}
	}	
	
	
	@AfterMethod
	public void browserClose() {
		driver.close();
		driver.quit();
	}

}
