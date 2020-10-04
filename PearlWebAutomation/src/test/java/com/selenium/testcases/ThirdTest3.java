package com.selenium.testcases;

import org.testng.annotations.Test;

import com.selenium.busniessflow.BusinessFlow;

public class ThirdTest3 extends BusinessFlow {

	@Test(groups = {"sanity"})
	public void formSubmitionVerification() throws Exception {	
		validFormSubmit();
		
	}

	@Test(groups = {"smoke"})
	public void formSubmitionVerification2() throws Exception {	
		inValidFormSubmit();
	}

}
	




