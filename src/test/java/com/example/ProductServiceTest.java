package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.model.Product;
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
		Product product = new Product();
		product.setId("PR1");
		product.setName("DESKTOP PRINTER");
		product.setCompany("HP");
		
		when(productRepository.showProduct(Mockito.anyString())).thenReturn(product);
		Product prod = productService.showProduct("PR1");
		assertEquals("DESKTOP PRINTER", prod.getName());
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
		List<Product> prods = productService.showAllProducts();
		assertNotNull(prods);
	}
	
	@Test
	public void showProductWithEmptyTest() {
		Product prod = productService.showProduct("");
		assertEquals(null, prod);
	}
	
	@Test
	public void showProductWithZeroTest() {
		Product prod = productService.showProduct("0");
		assertEquals(null, prod);
	}
}
