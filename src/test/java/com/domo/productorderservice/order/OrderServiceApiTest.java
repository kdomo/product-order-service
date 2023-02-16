package com.domo.productorderservice.order;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.springframework.http.MediaType.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.domo.productorderservice.ApiTest;
import com.domo.productorderservice.product.ProductSteps;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

class OrderServiceApiTest extends ApiTest {

	private static CreateOrderRequest 상품주문요청_생성() {
		final Long productId = 1L;
		final int quantity = 2;
		final CreateOrderRequest request = new CreateOrderRequest(productId, quantity);
		return request;
	}

	@Test
	@DisplayName("상품 주문")
	void 상품_주문() {
		ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
		final CreateOrderRequest request = 상품주문요청_생성();

		ExtractableResponse<Response> response = RestAssured.given().log().all()
				.contentType(APPLICATION_JSON_VALUE)
				.body(request)
				.post("/orders")
				.then()
				.log().all().extract();
		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}

}
