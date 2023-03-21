package com.webwork.automation.pojo;

public class OrderDetails {

	private String country;
	
	private String productOrderedId;

	public OrderDetails() {
	}

	public OrderDetails(String country, String productOrderedId) {
		this.country = country;
		this.productOrderedId = productOrderedId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProductOrderedId() {
		return productOrderedId;
	}

	public void setProductOrderedId(String productOrderedId) {
		this.productOrderedId = productOrderedId;
	}

	@Override
	public String toString() {
		return "OrderDetails [country=" + country + ", productOrderedId=" + productOrderedId + "]";
	}
	
	
}
