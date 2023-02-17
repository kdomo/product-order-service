package com.domo.productorderservice.payment.application.port;

import com.domo.productorderservice.order.domain.Order;
import com.domo.productorderservice.payment.domain.Payment;

public interface PaymentPort {
	Order getOrder(Long orderId);

	void save(Payment payment);

	void pay(int price, String cardNumber);
}
