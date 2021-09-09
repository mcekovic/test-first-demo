package org.strangeforest.bc;

import java.math.*;
import java.util.*;

final class BetUnit {

	private final BigDecimal stake;
	private final List<BetLeg> legs;

	BetUnit(BigDecimal stake, List<BetLeg> legs) {
		this.stake = stake;
		this.legs = legs;
	}

	public BigDecimal calculateCumulativePrice() {
		return legs.stream()
			.map(BetLeg::price)
			.reduce(BigDecimal.ONE, BigDecimal::multiply);
	}

	public BigDecimal cumulativeMaxReturn() {
		return stake.multiply(calculateCumulativePrice());
	}
}
