package com.domo.productorderservice.order.application.port;

import com.domo.productorderservice.order.domain.Order;
import com.domo.productorderservice.product.domain.Product;

public interface OrderPort {
	Product getProductById(final Long productId);

	void save(final Order order);
}
