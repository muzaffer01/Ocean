package com.selenium.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import readers.PropertyReader;


public class SecondTest {
	
	
	
	@Test
	public void myfirsttest() {
		PropertyReader a= new PropertyReader();
		String xyz=a.getvaluefrompropertyreader("SIT_UN");
		System.out.println(xyz);
		System.out.println("Run this test 5 times");
		}
	
	@Test
	public void sufwebinvoke() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\java eclipse\\MyProjects\\Ocean\\PearlWebAutomation\\src\\test\\resources\\Binaries\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver(); 
		
		PropertyReader a= new PropertyReader();
		String suf=a.getvaluefrompropertyreader("UAT");
		//driver.get("https://www3.ntu.edu.sg/home/ehchua/programming/webprogramming/jsdemo/JSFormValidation.html");
		driver.get(suf);
				
		driver.findElement(By.xpath("//input[@id='txtName']")).sendKeys("this is test");
		
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
		
		Assert.assertEquals(ele, ExpectedString);

		Thread.sleep(3000);
		driver.close();
		driver.quit();
		
		
		
		}
	
}



