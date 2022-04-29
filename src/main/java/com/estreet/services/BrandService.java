package com.estreet.services;

import java.util.List;

import com.estreet.dto.BrandDTO;
import com.estreet.models.Brand;


public interface BrandService {
	
	Brand create(BrandDTO dto);
	
	Brand get(Long id);
	
	Brand update(Long id, BrandDTO dto);
	
	List<Brand> getAll();
	
	Brand delete(Long id);

}
