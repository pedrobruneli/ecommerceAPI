package com.estreet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.estreet.dozer.Dozer;
import com.estreet.models.Brand;
import com.estreet.models.Product;
import com.estreet.vo.BrandVO;
import com.estreet.vo.ProductVO;
import com.github.dozermapper.core.Mapper;

@SpringBootTest
class ApplicationTests {

	private Mapper mapper = Dozer.mapper();
	
	@Test
	void dozerProductTest() {
		
		Brand brand = new Brand(1L, "Brand prod", List.of(new Product()));
		Product prod = new Product(2L, brand, "Product", "Prod Desc", 120.0, "Product Image");
		
		ProductVO vo = mapper.map(prod, ProductVO.class);
		assertEquals(vo.getBrand().getName(), "Brand prod");
		assertEquals(vo.getDescricao(), "Prod Desc");
		assertEquals(vo.getId(), 2L);
		assertEquals(vo.getImage(), "Product Image");
		assertEquals(vo.getName(), "Product");
		assertEquals(vo.getPrice(), 120.0);
	}
	
	@Test
	void dozerBrandTest() {
		Product prod = new Product();
		prod.setImage("Brand product image");
		Brand brand = new Brand(3L, "Brand name", List.of(prod));
		BrandVO vo = mapper.map(brand, BrandVO.class);
		
		assertEquals(vo.getId(), 3L);
		assertEquals(vo.getName(), "Brand name");
		assertEquals(vo.getProducts().get(0).getImage(), "Brand product image");
		
	}
	
	@Test
	void dozerLista() {
		List<Brand> brands = new ArrayList<Brand>();
		for(int i = 0; i < 10; i ++) {
			Product produto = new Product();
			produto.setName("Product " + i);
			Brand brand = new Brand(Integer.toUnsignedLong(i), "Brand " + i, List.of(produto));
			brands.add(brand);
		}
		List<BrandVO> brandsVO = Dozer.convertList(brands, BrandVO.class);
		assertEquals(brandsVO.get(0).getId(), 0L);
		assertEquals(brandsVO.get(0).getName(), "Brand 0");
		assertEquals(brandsVO.get(0).getProducts().get(0).getName(), "Product 0");
	}

}
