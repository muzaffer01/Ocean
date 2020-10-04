package com.selenium.busniessflow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.muzzafar.readers.ExcelReader;
import com.selenium.core.TestBase;
import com.selenium.muzzar.util.Utils;
import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;

public class BusinessFlow extends TestBase {
	
String Sheetname="TestData1";

public void inValidFormSubmit() throws Exception {
	
	logger = extent.createTest("Invlaid Form Submission Verification");
	
	System.out.println("Invlaid Form Submission Verification");
	logger.log(Status.INFO, "page loaded");		
	ExcelReader excelobj= new ExcelReader();
	String name=excelobj.readexcel(3,1, Sheetname);
	driver.findElement(By.xpath("//input[@id='txtName']")).sendKeys(name);
	driver.findElement(By.xpath("//input[@id='txtAddress']")).sendKeys("this is test2");	
	driver.findElement(By.xpath("//input[@id=\'txtZipcode\']")).sendKeys("this is test3");
	WebElement country = driver.findElement(By.xpath("//select[@id='selCountry']"));
	Select Mycountry= new Select(country);
	Mycountry.selectByVisibleText("AA");
	driver.findElement(By.xpath("//input[@value='m']")).click();
	driver.findElement(By.xpath("//input[@value='r']")).click();
	driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("123456");
	driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc@xyz.com");
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("abcdef");
	driver.findElement(By.xpath("//input[@id='txtPWVerified']")).sendKeys("abcdef");
	driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
	String ele= driver.findElement(By.xpath("//td[@id='elmZipcodeError']")).getText();
	System.out.println(ele);
	String ExpectedString = "Please enter a 5-digit zip code!";
	if (ele.equalsIgnoreCase(ExpectedString)) {
		Utils u = new Utils();
		logger.log(Status.INFO,"SnapShot"+logger.addScreenCaptureFromPath(u.takeSnapShot(driver)));
	}		
	Assert.assertEquals(ele, ExpectedString);
	Thread.sleep(3000);
}

	public void validFormSubmit() throws Exception {
		logger = extent.createTest("Form Submission Verification");
		logger.log(Status.INFO, "page loaded");		
		ExcelReader excelobj= new ExcelReader();
		String name=excelobj.readexcel(3,1, Sheetname);
		/*
		 * driver.findElement(By.xpath("//input[@id='txtName']")).sendKeys(name);
		 * driver.findElement(By.xpath("//input[@id='txtAddress']")).sendKeys("this is test2");
		 * driver.findElement(By.xpath("//input[@id=\'txtZipcode\']")).sendKeys("58752")
		 * ;
		 */
		LoginPage lp= new LoginPage(driver);
		lp.sendName(name);
		lp.sendAddress("this is Done");
		lp.sendzipcode("23565");
		
		WebElement country = driver.findElement(By.xpath("//select[@id='selCountry']"));
		Select Mycountry= new Select(country);
		Mycountry.selectByVisibleText("AA");
		driver.findElement(By.xpath("//input[@value='m']")).click();
		driver.findElement(By.xpath("//input[@value='r']")).click();
		
		//PageFactory Concept
		HomePage hp = new HomePage(driver);
		hp.send_phone_number("2222333333");
		hp.send_email("abcd@abcd.com");
		
// 		Home Page can be written with Page Factory concept
//		It allows to findelments once and use to pass values in numerous places.
//		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("123456");
//		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc@xyz.com");
		
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("abcdef");
		driver.findElement(By.xpath("//input[@id='txtPWVerified']")).sendKeys("abcdef");
		driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
		Thread.sleep(3000);
		Utils u = new Utils();
		/*
		 * try { u.takeSnapShot(driver); } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */
		logger.log(Status.INFO,"SnapShot"+logger.addScreenCaptureFromPath(u.takeSnapShot(driver)));
		logger.log(Status.PASS, "Message Found");
		
		
	}
	
	
}
