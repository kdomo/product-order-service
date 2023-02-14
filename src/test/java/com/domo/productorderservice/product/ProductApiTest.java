package com.domo.productorderservice.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.domo.productorderservice.ApiTest;

public class ProductApiTest extends ApiTest {
	@Autowired
	private ProductService productService;

	@Test
	@DisplayName("상품 등록")
	void 상품_등록() {
		final var request = ProductSteps.상품등록요청_생성();
		final var response = ProductSteps.상품등록요청(request);

		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}
}
