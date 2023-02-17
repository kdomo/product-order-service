package com.domo.productorderservice.payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.domo.productorderservice.order.OrderService;
import com.domo.productorderservice.order.OrderSteps;
import com.domo.productorderservice.product.ProductService;
import com.domo.productorderservice.product.ProductSteps;

@SpringBootTest
public class PaymentServiceTest {
	@Autowired
	private PaymentService paymentService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Test
	@DisplayName("상품 주문")
	void 상품_주문() {
		productService.addProduct(ProductSteps.상품등록요청_생성());
		orderService.createOrder(OrderSteps.상품주문요청_생성());
		final PaymentRequest request = PayMentSteps.주문결제요청_생성();
		paymentService.payment(request);
	}
}
