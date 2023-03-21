package com.webwork.automation.simplePages;

public class ECommerceAPITest {

//	public static void main(String args[]) {
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
//		RequestSpecification addProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
//				.addHeader("authorization", response.getToken()).build();
//		
//		RequestSpecification reqAddProduct=given().log().all().spec(addProductBaseReq).param("productName", "Laptop")
//		.param("productAddedBy", response.getUserId())
//		.param("productCategory", "fashion")
//		.param("productSubCategory", "shirts")
//		.param("productPrice", "11500")
//		.param("productDescription", "Lenova")
//		.param("productFor", "men")
//		.multiPart("productImage", new File("C://Users//SUNIL//Laptop.jpg"));
//		
//		String addProductResponse = reqAddProduct.when().post("/api/ecom/product/add-product").
//		then().log().all().extract().response().asString();
//		
//		System.out.println(addProductResponse);
//		JsonPath js = new JsonPath(addProductResponse);
//		
//		System.out.println("Second Execution");
//		
//		// Create Order
//		
//		RequestSpecification addOrderBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
//				.addHeader("authorization", response.getToken()).setContentType(ContentType.JSON).build();
//		 
//		OrderDetails orderDetails = new OrderDetails("India",js.get("productId").toString());
//		List<OrderDetails> orderDetailList = new ArrayList<OrderDetails>();
//		orderDetailList.add(orderDetails);
//		Orders  order = new Orders(orderDetailList);
//		
//		RequestSpecification createOrderReq = given().log().all().spec(addOrderBaseReq).body(order);
//		
//		String responseAddOrder = createOrderReq.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
//		
//		System.out.println("Add Order Response==="+responseAddOrder);
//		
//		// Delete Product
//		
//		RequestSpecification deleteProdBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
//				.addHeader("authorization", response.getToken()).setContentType(ContentType.JSON).build();
//		
//		RequestSpecification deleteProdReq = given().log().all().spec(deleteProdBaseReq).pathParam("productId", js.get("productId").toString());
//		
//		String deleteResponse = deleteProdReq.when().delete("/api/ecom/product/delete-product/{productId}").then().log().all().extract()
//				.response().asString();
//		
//		JsonPath js1 = new JsonPath(deleteResponse);
//		
//		Assert.assertEquals("Product Deleted Successfully", js1.get("message").toString());
//		
//		System.out.println(deleteResponse);
//		 
//		
//	}
	
}
