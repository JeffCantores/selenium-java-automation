package com.sampleframework.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sampleframework.pages.LoginPage;
import com.sampleframework.pages.BaseClass;

public class LoginTestCRM extends BaseClass{
	
	@Test
	public void testLogin() {
		
		logger = report.createTest("Login to CRM");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login Successful");
	}
}
