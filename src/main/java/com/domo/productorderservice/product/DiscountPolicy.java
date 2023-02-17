package com.domo.productorderservice.product;

public enum DiscountPolicy {
	NONE {
		@Override
		public int applyDiscount(final int price) {
			return price;
		}
	},
	FIX_1000_AMOUNT {
		@Override
		public int applyDiscount(final int price) {
			return Math.max(price - 1000, 0);
		}
	};

	abstract int applyDiscount(final int price);
}
