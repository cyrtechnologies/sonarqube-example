package com.example;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

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
	public void showProductTest() {
		Product product = new Product();
		when(productRepository.showProduct(Mockito.anyString())).thenReturn(product);
		Product prod = productRepository.showProduct("PR1");
		assertNotNull(prod);
	}
	
	/*@Test
	public void showProductNameTest() {
		Product product = new Product();
		product.setId("PR1");
		product.setName("DESKTOP PRINTER");
		product.setCompany("HP");
		
		when(productRepository.showProduct(Mockito.anyString())).thenReturn(product);
		Product prod = productRepository.showProduct("PR1");
		assertEquals("DESKTOP PRINTER", prod.getName());
	}
	
	@Test
	public void showProductIdNull() {
		when(productRepository.showProduct("0")).thenReturn(null);
		Product prod = productRepository.showProduct("0");
		assertNull(prod);
	}*/
}
