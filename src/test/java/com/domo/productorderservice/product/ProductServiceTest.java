package com.domo.productorderservice.product;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	private ProductService productService;
	private ProductPort productPort;

	@BeforeEach
	void setUp() {
		productPort = Mockito.mock(ProductPort.class);
		productService = new ProductService(productPort);
	}

	@Test
	@DisplayName("상품수정")
	void 상품수정() {
		final Long productId = 1L;
		final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);
		Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

		Mockito.when(productPort.getProduct(productId)).thenReturn(product);

		productService.updateProduct(productId, request);

		assertThat(product.getName()).isEqualTo("상품 수정");
		assertThat(product.getPrice()).isEqualTo(2000);
	}
}
