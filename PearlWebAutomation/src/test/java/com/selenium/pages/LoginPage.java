package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//input[@id='txtName']")
	WebElement name;
	
	@FindBy(xpath = "//input[@id='txtAddress']")
	WebElement address;
	
	@FindBy(xpath = "//input[@id='txtZipcode']")
	WebElement zipcode;
	

	
	public void sendName(String Name) {
		name.sendKeys(Name);
	}
	
	public void sendAddress(String Address) {
		address.sendKeys(Address);
	}
	
	public void sendzipcode(String zipCode) {
		zipcode.sendKeys(zipCode);
	}
	
}
