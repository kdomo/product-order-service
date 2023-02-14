package com.domo.productorderservice.product;

import java.util.HashMap;
import java.util.Map;

import com.domo.productorderservice.product.Product;

public class ProductRepository {
	private Long sequence = 0L;
	private Map<Long, Product> persistence = new HashMap<>();

	public void save(final Product product) {
		product.assginId(++sequence);
		persistence.put(product.getId(), product);
	}
}
