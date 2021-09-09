package org.strangeforest.bc;

import java.math.*;
import java.util.*;

public class Bet {

	private final BetType betType;
	private final BigDecimal unitStake;
	private final List<BetLeg> legs;

	public Bet(BetType betType, BigDecimal unitStake, List<BetLeg> legs) {
		this.betType = betType;
		this.unitStake = checkUnitStake(unitStake);
		this.legs = legs;
	}

	public Bet(BetType betType, String unitStake, List<BetLeg> legs) {
		this(betType, new BigDecimal(unitStake), validateLegs(legs));
	}

	private static BigDecimal checkUnitStake(BigDecimal unitStake) {
		if (unitStake.signum() <= 0)
			throw new IllegalArgumentException("Bet must have positive stake");
		return unitStake;
	}

	private static List<BetLeg> validateLegs(List<BetLeg> legs) {
		if (legs.isEmpty())
			throw new IllegalArgumentException("Bet legs cannot be empty");
		return legs;
	}

	public BigDecimal calculate() {
		return betType.combinations(legs)
			.map(legs -> new BetUnit(unitStake, legs).cumulativeMaxReturn())
			.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
