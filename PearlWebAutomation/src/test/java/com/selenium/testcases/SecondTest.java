package com.selenium.testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.muzzafar.readers.ExcelReader;
import com.selenium.core.TestBase;
import com.selenium.muzzar.util.Utils;


public class SecondTest extends TestBase{
	
	String Sheetname="TestData1";
	
	@Test(groups = {"sanity","Smoke"})
	public void formSubmitionErrorVerificatio() throws Exception {
		
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
			try {
				u.takeSnapShot(driver);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}		
		Assert.assertEquals(ele, ExpectedString);
		Thread.sleep(3000);
	}

	
}



