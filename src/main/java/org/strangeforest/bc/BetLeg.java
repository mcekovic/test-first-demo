package org.strangeforest.bc;

import java.math.*;

public class BetLeg {

	private final BigDecimal price;

	public BetLeg(BigDecimal price) {
		this.price = price;
	}

	public BetLeg(String price) {
		this(toLegPrice(price));
	}

	private static BigDecimal toLegPrice(String price) {
		var decimalPrice = new BigDecimal(price);
		if (decimalPrice.compareTo(BigDecimal.ONE) < 0)
			throw new IllegalArgumentException("BetLeg price must be at least 1");
		return decimalPrice;
	}

	public BigDecimal price() {
		return price;
	}
}
