package com.domo.productorderservice.product.application.port;

import com.domo.productorderservice.product.domain.Product;

public interface ProductPort {
	void save(Product product);

	Product getProduct(Long productId);
}
