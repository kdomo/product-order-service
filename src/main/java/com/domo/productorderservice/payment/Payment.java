package com.domo.productorderservice.payment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.util.Assert;

import com.domo.productorderservice.order.Order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Payment {
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Order order;

	private String cardNumber;

	public Payment(Order order, String cardNumber) {
		Assert.notNull(order, "주문 정보는 필수입니다.");
		Assert.hasText(cardNumber, "카드 번호는 필수입니다.");
		this.order = order;
		this.cardNumber = cardNumber;
	}

	public int getPrice() {
		return order.getTotalPrice();
	}

}
