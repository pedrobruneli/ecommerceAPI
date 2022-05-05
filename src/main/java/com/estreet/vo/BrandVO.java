package com.estreet.vo;

import java.util.List;

import com.estreet.models.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandVO {

	private Long id;
	
	private String name;
	
	@JsonIgnore
	private List<Product> products;

}
