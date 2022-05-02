package com.estreet.services;

import java.util.List;

import com.estreet.dto.ProductDTO;
import com.estreet.vo.ProductVO;

public interface ProductsService {
	
	ProductVO create(ProductDTO dto);
	
	ProductVO get(Long id);
	
	ProductVO update(Long id, ProductDTO dto);
	
	List<ProductVO> getAll();
	
	ProductVO delete(Long id);
}
