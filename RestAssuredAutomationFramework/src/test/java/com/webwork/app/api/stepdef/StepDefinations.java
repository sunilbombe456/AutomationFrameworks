package com.webwork.app.api.stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinations {
	
	
	@Given("^Start Application for API test$")
	public void start_application_for_api_test() {
		System.out.println("Hello Word!");
	}
	
	@When("^Verify user is on login page$")
	public void verify_user_is_on_login_page() throws Throwable {
	   
	}

	@Then("^Login with valid credential$")
	public void login_with_valid_credential() throws Throwable {
	  
	}

}
