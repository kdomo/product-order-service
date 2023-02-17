package com.domo.productorderservice.product.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domo.productorderservice.product.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
