package com.domo.productorderservice.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {
	private PaymentService paymentService;
	private PaymentPort paymentPort;

	@BeforeEach
	void setUp() {
		PaymentGateway paymentGateway = new ConsolePaymentGateway();
		PaymentRepository paymentRepository = new PaymentRepository();

		paymentPort = new PaymentAdapter(paymentGateway, paymentRepository);
		paymentService = new PaymentService(paymentPort);
	}

	@Test
	@DisplayName("상품 주문")
	void 상품_주문() {
		final PaymentRequest request = PayMentSteps.주문결제요청_생성();
		paymentService.payment(request);

	}
}
