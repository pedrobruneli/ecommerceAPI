package com.estreet.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {
	
	@NotEmpty(message = "Preencha o campo name.")
	private String name;
	
	
	private String descricao;
	
	@NotNull(message = "Preencha o campo price.")
	private Double price;
	
	@NotEmpty(message = "Preencha o campo image")
	private String image;
	
	@NotNull
	private Long brandId;
	
}
