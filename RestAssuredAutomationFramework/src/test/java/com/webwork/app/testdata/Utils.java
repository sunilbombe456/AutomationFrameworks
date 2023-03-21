package com.webwork.app.testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws FileNotFoundException {
		if (req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

			RestAssured.baseURI = "https://rahulshettyacademy.com";
			req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
					.addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
		}
		return req;
	}
	
	public static String getGlobalValue(String key) throws IOException {
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\SUNIL\\Event-Management-Workspace\\RestAssuredAutomationFramework\\src\\test\\java\\com\\webwork\\app\\testdata\\global.properties");
		props.load(fis);
		return props.getProperty(key);
	}
	
	public String getJsonPath(Response response, String key) {
		String res = response.asString();
		JsonPath jsonPath = new JsonPath(res);
		return jsonPath.get(key).toString();
	}

}
