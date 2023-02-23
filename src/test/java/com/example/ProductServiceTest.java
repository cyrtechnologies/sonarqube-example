package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.model.Product;
import com.example.model.ProductResponse;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	
	@InjectMocks
	ProductService productService;
	
	@Mock
	ProductRepository productRepository;
	
	@Test
	public void showProductNameTest() {
		List<Product> products = new ArrayList<Product>();
		Product product = new Product();
		product.setId("PR1");
		product.setName("DESKTOP PRINTER");
		product.setCompany("HP");
		products.add(product);
		
		when(productRepository.showProduct("PR1")).thenReturn(products);
		ProductResponse prodRsp = productService.showProduct("PR1");
		assertEquals("DESKTOP PRINTER", prodRsp.getProducts().get(0).getName());
	}

	@Test
	public void showAllProductsTest() {
		List<Product> products = new ArrayList<Product>();
		Product product1 = new Product();
		product1.setId("PR1");
		product1.setName("DESKTOP PRINTER");
		product1.setCompany("HP");
		
		Product product2 = new Product();
		product2.setId("LP1");
		product2.setName("LAPTOP - ELITE BOOK");
		product2.setCompany("HP");
		
		products.add(product1); products.add(product2);
		
		when(productRepository.showAllProducts()).thenReturn(products);
		ProductResponse prodRsp = productService.showAllProducts();
		assertNotNull(prodRsp.getProducts());
	}
	
	@Test
	public void showProductWithEmptyTest() {
		ProductResponse prodRsp = productService.showProduct("");
		assertNotNull(prodRsp);
	}
	
	@Test
	public void showProductWithZeroTest() {
		ProductResponse prodRsp = productService.showProduct("0");
		assertNotNull(prodRsp);
	}
}
