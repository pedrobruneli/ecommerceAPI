package com.estreet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estreet.dto.BrandDTO;
import com.estreet.models.Brand;
import com.estreet.services.impl.BrandServiceIMPL;

@RestController
@RequestMapping(path = "/brand")
public class BrandController {
	
	@Autowired
	private BrandServiceIMPL service;
	
	@GetMapping
	public List<Brand> getAll() {
		return service.getAll();
	}
	
	@GetMapping(path = "/{id}")
	public Brand get(@PathVariable Long id) {
		return service.get(id);
	}
	
	@PostMapping
	public Brand create(@RequestBody @Valid BrandDTO dto) {
		return service.create(dto);
	}
	
	@PutMapping(path = "/{id}")
	public Brand update(@PathVariable Long id, @RequestBody BrandDTO dto) {
		return service.update(id, dto);
	}

}
