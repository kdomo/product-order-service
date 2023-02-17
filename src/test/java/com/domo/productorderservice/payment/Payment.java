package com.domo.productorderservice.payment;

import org.springframework.util.Assert;

import com.domo.productorderservice.order.Order;

class Payment {
	private final Order order;
	private final String cardNumber;
	private Long id;

	public Payment(Order order, String cardNumber) {
		Assert.notNull(order, "주문 정보는 필수입니다.");
		Assert.hasText(cardNumber, "카드 번호는 필수입니다.");
		this.order = order;
		this.cardNumber = cardNumber;
	}

	public void assignId(final Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public int getPrice() {
		return order.getTotalPrice();
	}

	public Long getId() {
		return id;
	}
}
