package com.domo.productorderservice.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
	private Long sequence = 0L;
	private Map<Long, Product> persistence = new HashMap<>();

	public void save(final Product product) {
		product.assginId(++sequence);
		persistence.put(product.getId(), product);
	}
}
