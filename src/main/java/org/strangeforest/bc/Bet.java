package org.strangeforest.bc;

import java.math.*;
import java.util.*;

public class Bet {

	private final BetType betType;
	private final BigDecimal unitStake;
	private final List<BetLeg> legs;

	public Bet(BetType betType, BigDecimal unitStake, List<BetLeg> legs) {
		this.betType = betType;
		this.unitStake = unitStake;
		this.legs = legs;
	}

	public Bet(BetType betType, String unitStake, List<BetLeg> legs) {
		this(betType, toUnitStake(unitStake), validateLegs(legs));
	}

	private static BigDecimal toUnitStake(String unitStake) {
		var decimalUnitStake = new BigDecimal(unitStake);
		if (decimalUnitStake.signum() <= 0)
			throw new IllegalArgumentException("Bet must have positive stake");
		return decimalUnitStake;
	}

	private static List<BetLeg> validateLegs(List<BetLeg> legs) {
		if (legs.isEmpty())
			throw new IllegalArgumentException("Bet legs cannot be empty");
		return legs;
	}

	public BigDecimal calculate() {
		var cumulativePrice = betType.combinations(legs)
			.map(legs -> new BetUnit(legs).cumulativePrice())
			.reduce(BigDecimal.ZERO, BigDecimal::add);
		return unitStake.multiply(cumulativePrice);
	}
}
