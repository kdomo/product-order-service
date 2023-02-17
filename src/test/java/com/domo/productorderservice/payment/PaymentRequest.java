package com.domo.productorderservice.payment;

import org.springframework.util.Assert;

class PaymentRequest {
	private final Long orderId;
	private final String cardNumber;

	public PaymentRequest(Long orderId, String cardNumber) {
		Assert.notNull(orderId, "상품 ID는 필수입니다.");
		Assert.hasText(cardNumber, "카드 번호는 필수입니다.");
		this.orderId = orderId;
		this.cardNumber = cardNumber;
	}

	public Long getOrderId() {
		return orderId;
	}

	public String getCardNumber() {
		return cardNumber;
	}
}
