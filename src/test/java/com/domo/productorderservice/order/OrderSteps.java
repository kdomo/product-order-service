package com.domo.productorderservice.order;

import static org.springframework.http.MediaType.*;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class OrderSteps {
	public static CreateOrderRequest 상품주문요청_생성() {
		final Long productId = 1L;
		final int quantity = 2;
		final CreateOrderRequest request = new CreateOrderRequest(productId, quantity);
		return request;
	}

	public static ExtractableResponse<Response> 상품주문요청(CreateOrderRequest request) {
		return RestAssured.given().log().all()
				.contentType(APPLICATION_JSON_VALUE)
				.body(request)
				.post("/orders")
				.then()
				.log().all().extract();
	}
}
