package com.webwork.app.test.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		plugin="json:target/jsonReports/cucumber-report.json",
		glue={"com.webwork.app.api.stepdef"}
//		tags= {"@AddPlace"}
		)
public class TestRunner {

}
