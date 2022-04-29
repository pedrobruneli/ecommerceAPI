package com.estreet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estreet.dto.ProductDTO;
import com.estreet.models.Product;
import com.estreet.services.impl.ProductServiceIMPL;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
	
	@Autowired
	private ProductServiceIMPL service;
	
	@GetMapping
	public List<Product> getAll() {
		return service.getAll();
	}
	
	@GetMapping(path = "/{id}")
	public Product get(@PathVariable Long id) {
		return service.get(id);
	}
	
	@PostMapping()
	public Product create(@Valid @RequestBody ProductDTO dto) {
		return service.create(dto);
	}
	
	@PutMapping(path = "/{id}")
	public Product update(@PathVariable Long id, @RequestBody ProductDTO dto) {
		return service.update(id, dto);
	}
	
	@DeleteMapping(path = "/{id}")
	public Product delete(@PathVariable Long id) {
		return service.delete(id);
	}
	

}