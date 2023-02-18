package com.example;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import com.example.model.Product;
import com.example.model.ProductRowMapper;
import com.example.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductRepositoryTest {
	
	@InjectMocks
	ProductRepository productRepository;
	
	@Mock
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void showProductTest() {
		List<Product> products = new ArrayList<Product>();
		Product product = new Product();
		product.setId("PR1");
		products.add(product);
		
		when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(ProductRowMapper.class))).thenReturn(products);
		Product prod = productRepository.showProduct("PR1");
		assertNotNull(prod);
	}

}
