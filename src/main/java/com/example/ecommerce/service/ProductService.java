package com.example.ecommerce.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.module.Product;
import com.example.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TagService tagservice;
	
	// Create
	// Add a parameter categoryId so that i can retrieve the category
	// Add a parameter tags List<Tag> so that i can retrieve the tags
	public Product createProduct(Product product, Long categoryId, List<Long> tagIds) {
		
		// When i create a new product, i will get the category from categoryId
		// and set it to the product
		product.setCategory(categoryService.getCategoryById(categoryId));
		// When i create a new product, i will get the tags from tagids
		// and set it to the product
		product.setTags(Set.copyOf(tagservice.getTagByIds(tagIds)));
		return productRepository.save(product);
	}
	
	// Read
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	// Read by ID
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
	}
	
	// Update
	public Product updateProduct(Long id, Product updatedproduct) {
		Product existing = getProductById(id);
		existing.setName(updatedproduct.getName());
		existing.setPrice(updatedproduct.getPrice());
		existing.setQuantity(updatedproduct.getQuantity());
		return productRepository.save(existing);
	}
	
	// Delete
	public void deleteProduct(Long id) {
		if(!productRepository.existsById(id)) {
			throw new RuntimeException("Product not found");
		}
		productRepository.deleteById(id);
	}

}
