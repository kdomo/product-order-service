package com.domo.productorderservice.payment;

import org.springframework.http.MediaType;

import com.domo.productorderservice.payment.application.service.PaymentRequest;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class PayMentSteps {
	public static PaymentRequest 주문결제요청_생성() {
		final Long orderId = 1L;
		final String cardNumber = "1234-1234-1234-1234";
		return new PaymentRequest(orderId, cardNumber);
	}

	public static ExtractableResponse<Response> 주문결제요청(PaymentRequest request) {
		return RestAssured.given().log().all()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(request)
				.when()
				.post("/payments")
				.then().log().all()
				.extract();
	}
}
