package com.domo.productorderservice.order.application.service;

import org.springframework.util.Assert;

import lombok.Getter;

@Getter
public class CreateOrderRequest {
	private final Long productId;
	private final int quantity;

	public CreateOrderRequest() {
		this.productId = null;
		this.quantity = 0;
	}

	public CreateOrderRequest(Long productId, int quantity) {
		Assert.notNull(productId, "상품 ID는 필수입니다.");
		Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
		this.productId = productId;
		this.quantity = quantity;
	}
}

