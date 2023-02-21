package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public Product showProduct(String id) {
		if ("0".equalsIgnoreCase(id) || "".equalsIgnoreCase(id)) {
			return null;
		}
		return productRepository.showProduct(id);
	}
	
	public List<Product> showAllProducts() {
		return productRepository.showAllProducts();
	}
}
