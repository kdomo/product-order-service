package com.domo.productorderservice.payment;

import org.springframework.stereotype.Component;

@Component
public class ConsolePaymentGateway implements PaymentGateway {
	@Override
	public void excute(int totalPrice, String cardNumber) {
		System.out.println("결제 금액: " + totalPrice);
		System.out.println("카드 번호: " + cardNumber);
		System.out.println("결제 완료");
	}
}
