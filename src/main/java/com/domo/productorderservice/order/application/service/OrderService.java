package com.domo.productorderservice.order.application.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domo.productorderservice.order.application.port.OrderPort;
import com.domo.productorderservice.order.domain.Order;
import com.domo.productorderservice.product.domain.Product;

@RestController
@RequestMapping("/orders")
public class OrderService {
	private final OrderPort orderPort;

	public OrderService(OrderPort orderPort) {
		this.orderPort = orderPort;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Void> createOrder(@RequestBody CreateOrderRequest request) {
		final Product product = orderPort.getProductById(request.getProductId());
		final Order order = new Order(product, request.getQuantity());
		orderPort.save(order);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
