package com.selenium.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
	public  String Name;	
	
	
	public void chromeInvoke() {
		mypropertyreader =new PropertyReader();
		String Os=mypropertyreader.getvaluefrompropertyreader("OS");
		if (Os.equalsIgnoreCase("IOS")) {
			driver=new ChromeDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", Configuration.PROJECT_PATH+"/src/test/resources/Binaries/chromedriver.exe");
			driver=new ChromeDriver();
		}		
	}
	
	public void ffInvoke() {
		mypropertyreader =new PropertyReader();
		String Os=mypropertyreader.getvaluefrompropertyreader("OS");
		if (Os.equalsIgnoreCase("IOS")) {
			DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		    capabilities.setCapability("marionette", true);
			driver=new FirefoxDriver(capabilities);
		}else {
			System.setProperty("webdriver.gecko.driver", Configuration.PROJECT_PATH+"/src/test/resources/Binaries/geckodriver.exe");
			DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		    capabilities.setCapability("marionette", true);
			driver=new FirefoxDriver(capabilities);
		}		
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
	public void invokeBrowserandEnv() throws MalformedURLException {
		mypropertyreader= new PropertyReader();
		String serverRun=mypropertyreader.getvaluefrompropertyreader("RunONServer");
		if (serverRun.equalsIgnoreCase("true")) {
			String getenvivalue=mypropertyreader.getvaluefrompropertyreader("EXEENV");
			switch(getenvivalue) {
			case "UAT":
				DesiredCapabilities cap= new DesiredCapabilities().chrome();
				cap.setPlatform(Platform.LINUX);
				cap.setBrowserName("chrome");
			
				//forward and backward slash used on different OS
				//  WINDOWS uses both Single forward /    or Double back \\
				//  MAC and LINUX uses Single forward /  ONLY
				
//				another way of writing below step
//				URL myurl = new URL("http://192.168.1.100:4444/wd/hub");
//				driver = new RemoteWebDriver(myurl, cap);
				
				driver=new RemoteWebDriver(new URL("http://192.168.1.100:4444/wd/hub"), cap);
				String getuaturl=mypropertyreader.getvaluefrompropertyreader("UAT");
				driver.get(getuaturl);
				break;
				
			case "SIT":
				
				String getsiturl=mypropertyreader.getvaluefrompropertyreader("SIT");
				driver.get(getsiturl);
				break;
			}
		}else {
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
		
	}	
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDownBrowser() {
		//driver.close();
		driver.quit();
		extent.flush();
		
	}
	
	@BeforeTest(alwaysRun = true)
	public void ReportSetup() {
		mypropertyreader= new PropertyReader();
		//Sufiyan to update
		htmlReporter = new ExtentHtmlReporter("C:\\Users\\Ma Ateeq\\git\\Ocean\\PearlWebAutomation\\temp.html");
		 extent = new ExtentReports ();
		 extent.attachReporter(htmlReporter);//this is linking the content with the file..
		 extent.setSystemInfo("Environment",mypropertyreader.getvaluefrompropertyreader("EXEENV"));
		 extent.setSystemInfo("UserName", "Muzzafer");
		 htmlReporter.config().setReportName("Functional Automated Reports..");
	}
	
	@AfterTest(alwaysRun = true)
	public void ReportSetupExit() {
		 extent.flush();
	}

}
