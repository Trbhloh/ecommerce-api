package com.example.ecommerce.module;

import java.util.Set;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Tag;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

// @Entity, the Java class/Bean that will be mapped to the database using ORM.
// ORM - object (class, property, method) relational (table, query, column) mapping
// Entity - relational mapping
// - class name (table name), id (primary & column), property (column)
@Entity
public class Product {
	
	// @Id, Primary key for the entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement and unique
	private Long id;
	private String name;
	private String description;
	private Double price;
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category category;
	
	
	@JsonBackReference
	
	// Define Many to many relationship
	// There will be an additional table created, which is calling product_tag
	// Inside product_tag, there will to coulmn - product_id, tag_id ==> pivot table
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="product_tag", joinColumns=@JoinColumn(name="product_id"), inverseJoinColumns=@JoinColumn(name="tag_id"))
	private Set<Tag> tags;
	
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	// Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
