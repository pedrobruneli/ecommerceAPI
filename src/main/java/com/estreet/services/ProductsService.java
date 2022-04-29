package com.estreet.services;

import java.util.List;

import com.estreet.dto.ProductDTO;
import com.estreet.models.Product;

public interface ProductsService {
	
	Product create(ProductDTO dto);
	
	Product get(Long id);
	
	Product update(Long id, ProductDTO dto);
	
	List<Product> getAll();
	
	Product delete(Long id);
}
