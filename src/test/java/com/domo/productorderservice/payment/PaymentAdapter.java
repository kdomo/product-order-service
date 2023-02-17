package com.domo.productorderservice.payment;

import org.springframework.stereotype.Component;

import com.domo.productorderservice.order.Order;
import com.domo.productorderservice.product.DiscountPolicy;
import com.domo.productorderservice.product.Product;

@Component
class PaymentAdapter implements PaymentPort {
	private final PaymentGateway paymentGateway;
	private final PaymentRepository paymentRepository;

	public PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository) {
		this.paymentGateway = paymentGateway;
		this.paymentRepository = paymentRepository;
	}

	@Override
	public Order getOrder(Long orderId) {
		return new Order(new Product("상품1", 1000, DiscountPolicy.NONE), 1);
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
