package org.strangeforest.bc;

import java.math.*;
import java.util.*;

final class BetUnit {

	private final List<BetLeg> legs;

	BetUnit(List<BetLeg> legs) {
		this.legs = legs;
	}

	public BigDecimal cumulativePrice() {
		return legs.stream()
			.map(BetLeg::price)
			.reduce(BigDecimal.ONE, BigDecimal::multiply);
	}
}
