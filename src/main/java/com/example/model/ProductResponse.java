package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class ProductResponse {

	String status;
	String message = "";
	List<Product> products = new ArrayList<Product>();
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
