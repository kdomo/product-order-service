package com.domo.productorderservice.payment;

interface PaymentGateway {
	void excute(int totalPrice, String cardNumber);
}
