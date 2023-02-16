package com.domo.productorderservice.product;

import org.springframework.util.Assert;

import lombok.Getter;

@Getter
class UpdateProductRequest {
	private final String name;
	private final int price;
	private final DiscountPolicy discountPolicy;

	public UpdateProductRequest() {
		this.name = null;
		this.price = 0;
		this.discountPolicy = null;
	}

	public UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {
		Assert.hasText(name, "상품명은 필수입니다.");
		Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
		Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
		this.name = name;
		this.price = price;
		this.discountPolicy = discountPolicy;
	}
}
