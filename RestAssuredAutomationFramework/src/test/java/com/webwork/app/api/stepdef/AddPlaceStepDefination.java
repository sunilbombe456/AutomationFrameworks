package com.webwork.app.api.stepdef;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import com.webwork.app.testdata.APIResources;
import com.webwork.app.testdata.TestDataBuild;
import com.webwork.app.testdata.Utils;
import com.webwork.automation.pojo.AddPlace;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

@SuppressWarnings("deprecation")
public class AddPlaceStepDefination extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	TestDataBuild testData = new TestDataBuild();
	Response response;
	static String placeId;

	@Given("^Add Place Payload$")
	public void add_Place_Payload() throws Throwable {
		res = given().spec(requestSpecification()).body(testData.getPlacePayload());
	}

	@Given("^Add Place Payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void add_Place_Payload_with(String name, String language, String address) throws Throwable {

		AddPlace p = testData.getPlacePayload();
		p.setName(name);
		p.setLanguage(language);
		p.setAddress(address);

		res = given().spec(requestSpecification()).body(p);
	}

	@When("^users calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
	public void users_calls_with_htttp_request(String apiPath, String httpMethod) throws Throwable {
		APIResources resourceAPI = APIResources.valueOf(apiPath);
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if (httpMethod.equalsIgnoreCase("post")) {
			response = res.when().log().all().post(resourceAPI.getResource()).then().spec(resspec).log().all().extract()
					.response();
			System.err.println("POST METHOD CALLED");
		} else if (httpMethod.equalsIgnoreCase("delete")) {
			response = res.when().log().all().delete(resourceAPI.getResource()).then().spec(resspec).log().all()
					.extract().response();
		}else if (httpMethod.equalsIgnoreCase("get")) {
			response = res.when().log().all().get(resourceAPI.getResource()).then().spec(resspec).log().all()
					.extract().response();
		}
	}


	@Then("^the API call got success with status code (\\d+)$")
	public void the_API_call_got_success_with_status_code(int statusCode) throws Throwable {
		assertEquals(response.getStatusCode(), statusCode);
	}

	@Then("^status in response body is OK$")
	public void status_in_response_body_is_OK() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}
	
	@Then("^verify place_id  created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
	public void verify_place_id_created_maps_to_using(String expectedName, String apiPath) throws Throwable {
		 placeId = getJsonPath(response,"place_id");
		 res = given().spec(requestSpecification()).queryParam("place_id", placeId);
		 users_calls_with_htttp_request( apiPath, "GET");
		 String actualName = getJsonPath(response,"name");
		 assertEquals(actualName, expectedName.trim());
	}

	@Then("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void in_response_body_is(String key, String expectedValue) throws Throwable {
		assertEquals(getJsonPath(response,key), expectedValue);
	}

	@Given("^DeletePlace Payload$")
	public void deleteplace_Payload() throws Throwable {
		res = given().spec(requestSpecification()).body(testData.deletePlacePayload(placeId));
	}

}
