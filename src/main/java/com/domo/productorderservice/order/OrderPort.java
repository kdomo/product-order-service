package com.domo.productorderservice.order;

import com.domo.productorderservice.product.Product;

interface OrderPort {
	Product getProductById(final Long productId);

	void save(final Order order);
}
