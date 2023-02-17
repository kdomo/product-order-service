package com.domo.productorderservice.payment;

import org.springframework.stereotype.Component;

import com.domo.productorderservice.order.Order;

@Component
class PaymentService {

	private final PaymentPort paymentPort;

	public PaymentService(PaymentPort paymentPort) {
		this.paymentPort = paymentPort;
	}

	public void payment(final PaymentRequest request) {
		Order order = paymentPort.getOrder(request.getOrderId());
		final Payment payment = new Payment(order, request.getCardNumber());
		paymentPort.pay(payment.getPrice(), payment.getCardNumber());
		paymentPort.save(payment);
	}
}
