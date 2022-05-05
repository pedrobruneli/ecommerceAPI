package com.estreet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estreet.dto.BrandDTO;
import com.estreet.services.impl.BrandServiceIMPL;
import com.estreet.vo.BrandVO;

@CrossOrigin(origins = {"localhost:8080"})
@RestController
@RequestMapping(path = "/brand")
public class BrandController {
	
	@Autowired
	private BrandServiceIMPL service;
	
	@GetMapping
	public List<BrandVO> getAll() {
		return service.getAll();
	}
	
	@GetMapping(path = "/{id}")
	public BrandVO get(@PathVariable Long id) {
		return service.get(id);
	}
	
	@PostMapping
	public BrandVO create(@RequestBody @Valid BrandDTO dto) {
		return service.create(dto);
	}
	
	@PutMapping(path = "/{id}")
	public BrandVO update(@PathVariable Long id, @RequestBody BrandDTO dto) {
		return service.update(id, dto);
	}

}
