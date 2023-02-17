package com.domo.productorderservice.payment;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.domo.productorderservice.ApiTest;
import com.domo.productorderservice.order.OrderSteps;
import com.domo.productorderservice.product.ProductSteps;

public class PaymentApiTest extends ApiTest {
	@Test
	@DisplayName("상품 주문")
	void 상품_주문() {
		ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
		OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성());

		var response = PayMentSteps.주문결제요청(PayMentSteps.주문결제요청_생성());

		assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
	}
}
