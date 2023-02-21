package com.sampleframework.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberSampleSteps {
	
	@Given("^Open the Firefox and launch the application$")
	public void open_the_Firefox_and_launch_the_application() throws Throwable {
		System.out.println("The browser has opened and launched the application.");
	}

	@When("^Enter the Username and Password$")
	public void enter_the_Username_and_Password() throws Throwable {
		System.out.println("You have successfully entered the username and password.");
	}

	@Then("^Reset the credential$")
	public void reset_the_credential() throws Throwable {
		System.out.println("You have successfully click the reset button!");
	}
	
}
