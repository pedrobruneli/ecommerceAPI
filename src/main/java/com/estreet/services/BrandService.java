package com.estreet.services;

import java.util.List;

import com.estreet.dto.BrandDTO;
import com.estreet.vo.BrandVO;


public interface BrandService {
	
	BrandVO create(BrandDTO dto);
	
	BrandVO get(Long id);
	
	BrandVO update(Long id, BrandDTO dto);
	
	List<BrandVO> getAll();
	
	BrandVO delete(Long id);

}
