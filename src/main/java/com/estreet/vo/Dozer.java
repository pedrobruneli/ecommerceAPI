package com.estreet.vo;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class Dozer {
	
	public static Mapper mapper() {
		return DozerBeanMapperBuilder.buildDefault();
	}
	
	public static <O, D> List<D> convertList(List<O> before, Class<D> classe) {
		List<D> nova = new ArrayList<D>();
		for(Object o : before) {
			nova.add(mapper().map(o, classe));	
		}
		return nova;
	}

}
