package com.domo.productorderservice.payment.adapter;

import org.springframework.stereotype.Component;

import com.domo.productorderservice.order.adapter.OrderRepository;
import com.domo.productorderservice.order.domain.Order;
import com.domo.productorderservice.payment.application.port.PaymentPort;
import com.domo.productorderservice.payment.domain.Payment;

@Component
public class PaymentAdapter implements PaymentPort {
	private final PaymentGateway paymentGateway;
	private final PaymentRepository paymentRepository;
	private final OrderRepository orderRepository;

	public PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository,
			OrderRepository orderRepository) {
		this.paymentGateway = paymentGateway;
		this.paymentRepository = paymentRepository;
		this.orderRepository = orderRepository;
	}

	@Override
	public Order getOrder(Long orderId) {
		return orderRepository.findById(orderId)
				.orElseThrow(() -> new IllegalArgumentException("주문이 존재하지 않습니다."));
	}

	@Override
	public void save(Payment payment) {
		paymentRepository.save(payment);
	}

	@Override
	public void pay(int totalPrice, String cardNumber) {
		paymentGateway.excute(totalPrice, cardNumber);
	}
}
