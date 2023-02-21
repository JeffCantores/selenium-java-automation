package com.sampleframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(name = "username") WebElement uname;
	@FindBy(name = "password") WebElement pass;
	@FindBy(xpath = "//input[@value='Login']") WebElement loginBtn;
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	public void loginToCRM(String username, String password) {
		uname.sendKeys(username);
		pass.sendKeys(password);
		loginBtn.click();
	}

}
