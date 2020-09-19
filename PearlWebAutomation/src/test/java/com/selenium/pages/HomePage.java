package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage (WebDriver localdriver) {
		driver = localdriver;
		PageFactory.initElements(localdriver, HomePage.class);
	}
	
	@FindBy(xpath = "//input[@id='txtPhone']" ) WebElement phone_number_we;
	@FindBy(xpath = "//input[@id='txtEmail']") WebElement email_we;
	
	public void send_phone_number (String phone_number_var) {
		phone_number_we.sendKeys(phone_number_var);
	}
	
	public void send_email (String email_var) {
		email_we.sendKeys(email_var);
	}
		
	
	
	
	
	
	

}
