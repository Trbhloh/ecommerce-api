package com.example.ecommerce.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.module.Product;

// My repository will get all the functions from JpaRepository
// The first argument inside <> will be your Entity name
// The second argument inside <> will be the ID data type
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// Declare in repository then in service can use this method to find by name.
	//List<Product> findbyName(String name);

}
