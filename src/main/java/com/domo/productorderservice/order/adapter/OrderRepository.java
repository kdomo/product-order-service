package com.domo.productorderservice.order.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domo.productorderservice.order.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
