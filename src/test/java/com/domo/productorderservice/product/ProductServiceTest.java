package com.domo.productorderservice.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {
	@Autowired
	private ProductService productService;

	@Test
	@DisplayName("상품 조회")
	void 상품_조회() {
		productService.addProduct(ProductSteps.상품등록요청_생성());
		final Long productId = 1L;

		final GetProductResponse response = productService.getProduct(productId);

		assertThat(response).isNotNull();
		assertThat(response.getId()).isEqualTo(productId);
	}

}
