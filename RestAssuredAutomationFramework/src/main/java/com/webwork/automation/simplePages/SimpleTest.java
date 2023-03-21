package com.webwork.automation.simplePages;

import static io.restassured.RestAssured.given;

import java.io.File;

import com.webwork.automation.pojo.LoginRequest;
import com.webwork.automation.pojo.LoginResponse;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class SimpleTest {
	
//	 public static void main(String[] args) {
//		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
//	
//		LoginRequest loginRequest = new LoginRequest("ganesh.jadhav@gmail.com","Ganesh@123");
//		
//		RequestSpecification reqLogin = given().log().all().spec(req).body(loginRequest);
//	
//		LoginResponse response = reqLogin.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponse.class);
//		
//		System.out.println(response);
//		
//		//New Request
//		
//		RequestSpecification addProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON)
//				.addHeader("authorization", response.getToken()).build();
//		
//		RequestSpecification reqAddProduct=given().log().all().spec(addProductBaseReq).param("productName", "Laptop")
//		.param("productAddedBy", response.getUserId())
//		.param("productCategory", "fashion")
//		.param("productSubCategory", "shirts")
//		.param("productPrice", "11500")
//		.param("productDescription", "Lenova")
//		.param("productFor", "men")
//		.multiPart("productImage", new File("C://Users//SUNIL//laptop1.png"));
//		
//		String addProductResponse = reqAddProduct.when().post("/api/ecom/product/add-product").
//		then().log().all().extract().response().asString();
//		
//		System.out.println(addProductResponse);
//		JsonPath js = new JsonPath(addProductResponse);
//		
//		System.out.println("Second Execution");
//		
//		
//	}
	
}

