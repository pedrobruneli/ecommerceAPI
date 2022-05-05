package com.estreet.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estreet.dto.BrandDTO;
import com.estreet.models.Brand;
import com.estreet.models.Product;
import com.estreet.repositories.BrandRepository;
import com.estreet.services.BrandService;
import com.estreet.vo.BrandVO;
import com.estreet.vo.Dozer;

@Service
public class BrandServiceIMPL implements BrandService{
	
	@Autowired
	private BrandRepository brandREP;

	@Override
	public BrandVO create(BrandDTO dto) {
		Brand brand = new Brand();
		brand.setName(dto.getName());
		brand.setProducts(new ArrayList<Product>());
		brandREP.save(brand);
		return Dozer.parseObject(brand, BrandVO.class);
	}

	@Override
	public BrandVO get(Long id) {
		return Dozer.parseObject(brandREP.findById(id).get(), BrandVO.class);
	}

	@Override
	public BrandVO update(Long id, BrandDTO dto) {
		Optional<Brand> optBrand = brandREP.findById(id);
		if(optBrand.isPresent()) {
			Brand brand = optBrand.get();
			brand.setName(dto.getName() != null ? dto.getName() : brand.getName());
			brandREP.save(brand);
			return Dozer.parseObject(brand, BrandVO.class);
		}
		return null;
	}

	@Override
	public List<BrandVO> getAll() {
		return Dozer.convertList(brandREP.findAll(), BrandVO.class);
	}

	@Override
	public BrandVO delete(Long id) {
		Optional<Brand> optBrand = brandREP.findById(id);
		if(optBrand.isPresent()) {
			Brand brand = optBrand.get();
			brandREP.delete(brand);
			return Dozer.parseObject(brand, BrandVO.class);
		}
		return null;
	}

}
