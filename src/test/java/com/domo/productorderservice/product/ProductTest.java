package com.domo.productorderservice.product;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void update() {
		Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
		product.update("상품 수정", 2000, DiscountPolicy.NONE);

		assertThat(product.getName()).isEqualTo("상품 수정");
		assertThat(product.getPrice()).isEqualTo(2000);
		assertThat(product.getDiscountPolicy()).isEqualTo(DiscountPolicy.NONE);
	}
}