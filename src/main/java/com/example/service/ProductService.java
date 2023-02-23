package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.model.ProductResponse;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	ProductResponse productResponse = null;
	
	public ProductResponse addProduct(Product product) {
		productResponse = new ProductResponse();
		int count = 0;
		try {
			count = productRepository.addProduct(product);
		} catch (Exception ex) {
			count = 0;
			System.out.println("Error connecting to DB");
		}
		System.out.println(count + " row(s) updated.");
		if (count > 0) {
			productResponse.setStatus("Success");
			productResponse.setMessage("Product added successfully");
		} else {
			productResponse.setStatus("Failure");
			productResponse.setMessage("Product is not added successfully");
		}
		
		return productResponse;
	}

	public ProductResponse showProduct(String id) {
		productResponse = new ProductResponse();
		List<Product> products = null;
		if ("0".equalsIgnoreCase(id) || "".equalsIgnoreCase(id)) {
			productResponse.setStatus("Success");
			productResponse.setMessage("Product id cannot be 0 or empty");
			return productResponse;
		}
		try {
			products = productRepository.showProduct(id);
			productResponse.setStatus("Success");
			if (products.size() == 0) {
				productResponse.setMessage("Product is not found");
			}
			productResponse.setProducts(products);
		} catch (Exception ex) {
			products = null;
			productResponse.setStatus("Failure");
			productResponse.setMessage(ex.getMessage());
		}
		return productResponse;
	}
	
	public ProductResponse showAllProducts() {
		productResponse = new ProductResponse();
		List<Product> products = null;
		try {
			products = productRepository.showAllProducts();
			productResponse.setStatus("Success");
			productResponse.setProducts(products);
		} catch (Exception ex) {
			productResponse.setStatus("Failure");
			productResponse.setMessage(ex.getMessage());
		}
		return productResponse;
	}
}
