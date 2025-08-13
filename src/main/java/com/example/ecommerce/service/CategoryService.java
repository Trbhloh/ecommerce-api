package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// Create
	public Category createcategory(Category category) {
		return categoryRepository.save(category);
	}
	// Read
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	// Read by Id
	public Category getCategoryById(Long id) {
		// findByid return optional <Category>
		// safe way to indicate that the return data type can either be Category or null
		// If it is null throw an error message.
		return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
	}
	
	// Update
	public Category updateCategory(Long id, Category updatedcategory) {
		Category existing = getCategoryById(id);
		existing.setName(updatedcategory.getName());
		return categoryRepository.save(existing);
	}
	
	
		// Delete
	public void deleteCatgory(Long id) {
		if(!categoryRepository.existsById(id)) {
				throw new RuntimeException("Product not found");
		}
		categoryRepository.deleteById(id);
	}

}
