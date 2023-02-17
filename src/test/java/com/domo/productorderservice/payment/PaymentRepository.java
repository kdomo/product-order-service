package com.domo.productorderservice.payment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
class PaymentRepository {
	private final Map<Long, Payment> persistence = new HashMap<>();
	private Long sequence = 0L;

	public void save(Payment payment) {
		payment.assignId(++sequence);
		persistence.put(payment.getId(), payment);
	}
}
