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
		if (id == "0" || id == "") {
			return null;
		}
		Product product = productRepository.showProduct(id);
		return product;
	}
	
	public List<Product> showAllProducts() {
		List<Product> products = productRepository.showAllProducts();
		return products;
	}
}
