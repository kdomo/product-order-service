package com.domo.productorderservice.payment.adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domo.productorderservice.payment.domain.Payment;

interface PaymentRepository extends JpaRepository<Payment, Long> {
}
