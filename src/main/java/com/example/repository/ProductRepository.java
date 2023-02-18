package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Product;
import com.example.model.ProductRowMapper;

@Repository
public class ProductRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Product showProduct(String id) {
		List<Product> products = new ArrayList<Product>();
		Product product = null;
		String sql = "SELECT id, name, company FROM product WHERE id = '"+id+"'";
		products = jdbcTemplate.query(sql, new ProductRowMapper());
		if (products.size() > 0) {
			product = products.get(0);
		}
		return product;
	}
	
	public List<Product> showAllProducts() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT id, name, company FROM product";
		products = jdbcTemplate.query(sql, new ProductRowMapper());		
		return products;
	}
}
