package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@ApiOperation(value = "Return product for given ID", response = Product.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = Product.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	@GetMapping(value = "/showProduct")
	public ResponseEntity<Product> showProduct(@RequestParam String id) 
	{
		Product product = productService.showProduct(id);
		ResponseEntity<Product> response = new ResponseEntity<>(product, HttpStatus.OK);
		return response;
	}
	
	@ApiOperation(value = "Returns all Products", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = List.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	@GetMapping(value = "/showAllProducts")
	public List<Product> showAllProducts() 
	{
		return productService.showAllProducts();
	}
}
