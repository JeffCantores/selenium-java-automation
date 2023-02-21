package com.sampleframework.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
		glue = "com.sampleframework.stepdefinition"
)

public class Runner {
	
}
