package com.webwork.automation.pojo;

import java.util.List;

public class Orders {
	
	private List<OrderDetails> orders;

	public Orders() {
		super();
	}

	public Orders(List<OrderDetails> orders) {
		super();
		this.orders = orders;
	}

	public List<OrderDetails> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetails> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Orders [orders=" + orders + "]";
	}

}
