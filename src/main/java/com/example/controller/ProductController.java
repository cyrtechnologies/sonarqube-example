package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.model.ProductResponse;
import com.example.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@ApiOperation(value = "Add Product", response = ProductResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ProductResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	@PostMapping(value = "/addProduct")
	public ProductResponse addProduct(@RequestBody Product product) 
	{
		return productService.addProduct(product);
	}
	
	@ApiOperation(value = "Return product for given ID", response = ProductResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ProductResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	@GetMapping(value = "/showProduct")
	public ProductResponse showProduct(@RequestParam String id) 
	{
		return productService.showProduct(id);
	}
	
	@ApiOperation(value = "Returns all Products", response = ProductResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ProductResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	@GetMapping(value = "/showAllProducts")
	public ProductResponse showAllProducts() 
	{
		return productService.showAllProducts();
	}
}
