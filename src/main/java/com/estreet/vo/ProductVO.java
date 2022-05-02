package com.estreet.vo;

import com.estreet.models.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
	
	private Long id;

	private Brand brand;

	private String name;
	
	private String descricao;
	
	private Double price;

	private String image;

}
