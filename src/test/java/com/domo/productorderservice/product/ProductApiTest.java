package com.domo.productorderservice.product;

import static com.domo.productorderservice.product.ProductSteps.*;
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

	@Test
	@DisplayName("상품 조회")
	void 상품조회() {
		productService.addProduct(ProductSteps.상품등록요청_생성());
		Long productId = 1L;

		final var response = 상품조회요청(productId);

		assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
		assertThat(response.jsonPath().getInt("price")).isEqualTo(1000);
		assertThat(response.jsonPath().getString("discountPolicy")).isEqualTo("NONE");
	}
}
