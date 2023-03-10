package com.domo.productorderservice.product.application.service;

import org.springframework.util.Assert;

import com.domo.productorderservice.product.domain.DiscountPolicy;

import lombok.Getter;

@Getter
public class GetProductResponse {
	Long id;
	String name;
	int price;
	DiscountPolicy discountPolicy;

	public GetProductResponse(Long id, String name, int price, DiscountPolicy discountPolicy) {
		Assert.notNull(id, "상품 ID는 필수입니다.");
		Assert.hasText(name, "상품명은 필수입니다.");
		Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
		this.id = id;
		this.name = name;
		this.price = price;
		this.discountPolicy = discountPolicy;
	}
}
