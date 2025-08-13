package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.module.Product;
import com.example.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	// localhost:8080/api/products?categoryId=1
	// Test flow
	// 1) create a product - post localhost:8080/api/product?categoryId=1&tagids=1,2
	// 2) Get all products or get product by id = localhost:8080/api/products
	// 3) Get all categories, or get category by id = localhost:8080/api/categories
	
	@PostMapping
	public Product addProduct(@RequestBody Product product, @RequestParam Long categoryId, @RequestParam List<Long> tagids) {
		// Now to create a new product i have to specify the category ID
		// Temporary use @RequestParam
		// Best paractice use proper DTO
		return productservice.createProduct(product, categoryId, tagids);
	}
	
	@GetMapping
	public List<Product> getAllProduct(){
		return productservice.getAllProducts();
	}

}
