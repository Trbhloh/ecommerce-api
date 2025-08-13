package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Tag;
import com.example.ecommerce.repository.TagRepository;

@Service
public class TagService {
	
	@Autowired
	private TagRepository tagRepository;
	
	// Create
	public Tag createTag(Tag tag) {
		return tagRepository.save(tag);
	}
	
	// Read
	public List<Tag> getAllTags(){
		return tagRepository.findAll();
	}
	
	// Read by ID
	public List<Tag> getTagByIds(List<Long> ids) {
		return tagRepository.findAllById(ids);
	}
	
	// Update

	
	// Delete
	public void deletetag(Long id) {
		if(!tagRepository.existsById(id)) {
			throw new RuntimeException("tag not found");
		}
		tagRepository.deleteById(id);
	}


}
