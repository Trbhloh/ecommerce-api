package com.example.ecommerce.model;

import java.util.List;

import com.example.ecommerce.module.Product;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	// To define that this is One to Many relationship
	// the relation name is "category" - from child's perpective
	//@JsonManagedReference
	private List<Product> products; // List of childs
	
	public Category() {
		super();
	}
	public Category(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
