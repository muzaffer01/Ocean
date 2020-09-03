package com.selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.muzzafar.readers.PropertyReader;
import com.muzzafar.util.Configuration;

public class TestBase {
	
	public WebDriver driver;
	PropertyReader mypropertyreader;
	
	public  ExtentHtmlReporter htmlReporter;
	public  ExtentReports extent;
	public  ExtentTest logger;
	public String Name;
	
	
	public void chromeInvoke() {
		System.setProperty("webdriver.chrome.driver", Configuration.PROJECT_PATH+"\\src\\test\\resources\\Binaries\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	public void ffInvoke() {
		System.setProperty("webdriver.gecko.driver", Configuration.PROJECT_PATH+"\\src\\test\\resources\\Binaries\\geckodriver.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
	    capabilities.setCapability("marionette", true);
		driver=new FirefoxDriver(capabilities);
		
	}
	
	
	public void browserSelection() {
		String browservalue=mypropertyreader.getvaluefrompropertyreader("Browser");
		switch (browservalue) {
		case "FF":
			ffInvoke();
			break;
		case "Chrome":
			chromeInvoke();
			break;

		default:
			System.out.println("Out of Scope! or check browser value!");
			try{
	            throw new NullPointerException("Browser value Missmatch");
	       } catch (IndexOutOfBoundsException e) {
	            e.printStackTrace();
	       }
		}
	}
	
	@BeforeMethod(alwaysRun = true)
	public void invokeBrowserandEnv() {
		mypropertyreader= new PropertyReader();
		String getenvivalue=mypropertyreader.getvaluefrompropertyreader("EXEENV");
		switch(getenvivalue) {
		case "UAT":
			browserSelection();
			String getuaturl=mypropertyreader.getvaluefrompropertyreader("UAT");
			driver.get(getuaturl);
			break;
			
		case "SIT":
			browserSelection();
			String getsiturl=mypropertyreader.getvaluefrompropertyreader("SIT");
			driver.get(getsiturl);
			break;
		}
	}	
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDownBrowser() {
		//driver.close();
		driver.quit();
		
	}
	
	@BeforeTest(alwaysRun = true)
	public void ReportSetup() {
		mypropertyreader= new PropertyReader();
		htmlReporter = new ExtentHtmlReporter("C:\\Users\\Ma Ateeq\\git\\Ocean\\PearlWebAutomation\\temp.html");
		 extent = new ExtentReports ();
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("Environment", "UAT");
		 extent.setSystemInfo("UserName", "Muzzafer");
		 htmlReporter.config().setReportName("Functional Automated Reports..");
	}
	
	@AfterTest(alwaysRun = true)
	public void ReportSetupExt() {
		 extent.flush();
	}

}
