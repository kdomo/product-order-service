package com.domo.productorderservice.product.adapter;

import org.springframework.stereotype.Component;

import com.domo.productorderservice.product.application.port.ProductPort;
import com.domo.productorderservice.product.domain.Product;

@Component
public class ProductAdapter implements ProductPort {
	private final ProductRepository productRepository;

	public ProductAdapter(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public Product getProduct(Long productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
	}
}
