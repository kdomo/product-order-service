package com.domo.productorderservice.payment.application.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domo.productorderservice.order.domain.Order;
import com.domo.productorderservice.payment.application.port.PaymentPort;
import com.domo.productorderservice.payment.domain.Payment;

@RestController
@RequestMapping("/payments")
class PaymentService {

	private final PaymentPort paymentPort;

	public PaymentService(PaymentPort paymentPort) {
		this.paymentPort = paymentPort;
	}

	@PostMapping
	@Transactional
	public void payment(@RequestBody final PaymentRequest request) {
		Order order = paymentPort.getOrder(request.getOrderId());
		final Payment payment = new Payment(order, request.getCardNumber());
		paymentPort.pay(payment.getPrice(), payment.getCardNumber());
		paymentPort.save(payment);
	}
}
