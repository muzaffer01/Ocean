package com.selenium.testcases;

import org.testng.annotations.Test;

import com.selenium.busniessflow.BusinessFlow;


public class SecondTest extends BusinessFlow{
	
	String Sheetname="TestData1";
	
	@Test(groups = {"sanity"})
	public void formSubmitionErrorVerificatio() throws Exception {	
	inValidFormSubmit();
		}

	
}



