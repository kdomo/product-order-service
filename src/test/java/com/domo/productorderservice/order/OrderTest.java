package com.domo.productorderservice.order;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import com.domo.productorderservice.order.domain.Order;
import com.domo.productorderservice.product.domain.DiscountPolicy;
import com.domo.productorderservice.product.domain.Product;

class OrderTest {

	@Test
	void getTotalPrice() {
		Order order = new Order(new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT), 2);

		final int totalPrice = order.getTotalPrice();

		assertThat(totalPrice).isEqualTo(2000);
	}

}