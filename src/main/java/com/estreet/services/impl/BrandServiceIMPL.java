package com.estreet.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estreet.dto.BrandDTO;
import com.estreet.models.Brand;
import com.estreet.models.BrandRepository;
import com.estreet.models.Product;
import com.estreet.services.BrandService;

@Service
public class BrandServiceIMPL implements BrandService{
	
	@Autowired
	private BrandRepository brandREP;

	@Override
	public Brand create(BrandDTO dto) {
		Brand brand = new Brand();
		brand.setName(dto.getName());
		brand.setProducts(new ArrayList<Product>());
		brandREP.save(brand);
		return brand;
	}

	@Override
	public Brand get(Long id) {
		return brandREP.findById(id).get();
	}

	@Override
	public Brand update(Long id, BrandDTO dto) {
		Optional<Brand> optBrand = brandREP.findById(id);
		if(optBrand.isPresent()) {
			Brand brand = optBrand.get();
			brand.setName(dto.getName() != null ? dto.getName() : brand.getName());
			brandREP.save(brand);
			return brand;
		}
		return null;
	}

	@Override
	public List<Brand> getAll() {
		return brandREP.findAll();
	}

	@Override
	public Brand delete(Long id) {
		Optional<Brand> optBrand = brandREP.findById(id);
		if(optBrand.isPresent()) {
			Brand brand = optBrand.get();
			brandREP.delete(brand);
			return brand;
		}
		return null;
	}

}
