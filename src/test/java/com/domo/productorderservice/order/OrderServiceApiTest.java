package com.domo.productorderservice.order;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.domo.productorderservice.ApiTest;
import com.domo.productorderservice.product.ProductSteps;

class OrderServiceApiTest extends ApiTest {

	@Test
	@DisplayName("상품 주문")
	void 상품_주문() {
		ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
		final var request = OrderSteps.상품주문요청_생성();

		final var response = OrderSteps.상품주문요청(request);
		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}

}
