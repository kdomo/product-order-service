package com.domo.productorderservice.product;

public class ProductService {
	private final ProductPort productPort;

	public ProductService(ProductPort productPort) {
		this.productPort = productPort;
	}

	public void addProduct(AddProductRequest request) {
		final Product product = new Product(request.getName(), request.getPrice(), request.getDiscountPolicy());
		productPort.save(product);
	}
}
