package com.selenium.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.muzzafar.readers.ExcelReader;
import com.selenium.core.TestBase;
import com.selenium.muzzar.util.Utils;

public class FirstTest extends TestBase {
	String Sheetname="TestData1";

	@Test(groups = {"sanity"})
	public void formSubmitionVerification() throws Exception {
		logger = extent.createTest("Form Submission Verification");
		logger.log(Status.INFO, "page loaded");		
		ExcelReader excelobj= new ExcelReader();
		String name=excelobj.readexcel(3,1, Sheetname);
		driver.findElement(By.xpath("//input[@id='txtName']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='txtAddress']")).sendKeys("this is test2");	
		driver.findElement(By.xpath("//input[@id=\'txtZipcode\']")).sendKeys("58752");
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
		Thread.sleep(3000);
		Utils u= new Utils();
		logger.log(Status.INFO,"SnapShot"+logger.addScreenCaptureFromPath(u.takeSnapShot(driver)));
		logger.log(Status.PASS, "Message Found");
	}


}
	















