package com.domo.productorderservice.payment;

import com.domo.productorderservice.order.Order;

interface PaymentPort {
	Order getOrder(Long orderId);

	void save(Payment payment);

	void pay(int price, String cardNumber);
}
