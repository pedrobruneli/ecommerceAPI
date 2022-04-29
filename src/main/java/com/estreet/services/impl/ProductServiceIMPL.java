package com.estreet.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estreet.dto.ProductDTO;
import com.estreet.models.BrandRepository;
import com.estreet.models.Product;
import com.estreet.models.ProductRepository;
import com.estreet.services.ProductsService;

@Service
public class ProductServiceIMPL implements ProductsService {

	@Autowired
	ProductRepository productREP;
	
	@Autowired
	BrandRepository brandREP;

	@Override
	public Product create(ProductDTO dto) {
		Product product = new Product();
		product.setBrand(brandREP.findById(dto.getBrandId()).get());
		product.setDescricao(dto.getDescricao());
		product.setImage(dto.getImage());
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		productREP.save(product);
		return product;
	}

	@Override
	public Product get(Long id) {
		return productREP.findById(id).get();
	}

	@Override
	public Product update(Long id, ProductDTO dto) {
		Optional<Product> optProduct = productREP.findById(id);
		if (optProduct.isPresent()) {
			Product product = optProduct.get();
			product.setName(dto.getName() != null ? dto.getName() : product.getName());
			product.setImage(dto.getImage() != null ? dto.getImage() : product.getImage());
			product.setDescricao(dto.getDescricao() != null ? dto.getDescricao() : product.getDescricao());
			product.setPrice(dto.getPrice() != null ? dto.getPrice() : product.getPrice());
			productREP.save(product);
			return product;
		}
		return null;
	}

	@Override
	public List<Product> getAll() {
		return productREP.findAll();
	}

	@Override
	public Product delete(Long id) {
		Optional<Product> product = productREP.findById(id);
		if (product.isPresent()) {
			productREP.delete(product.get());
			return product.get();
		}
		return null;
	}

}
