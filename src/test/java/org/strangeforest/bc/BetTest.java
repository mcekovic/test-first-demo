package org.strangeforest.bc;

import java.util.*;

import org.junit.jupiter.api.*;
import org.strangeforest.bc.bettypes.*;

import static org.assertj.core.api.Assertions.*;

class BetTest {

	@Test
	void singleBetIsCalculated() {
		var bet = new Bet(new Accumulator(), "10", List.of(new BetLeg("2")));

		var maxReturn = bet.calculate();

		assertThat(maxReturn).isEqualByComparingTo("20");
	}

	@Test
	void doubleBetIsCalculated() {
		var bet = new Bet(new Accumulator(), "10", List.of(
			new BetLeg("2"),
			new BetLeg("3")
		));

		var maxReturn = bet.calculate();

		assertThat(maxReturn).isEqualByComparingTo("60");
	}

	@Test
	void trebleBetIsCalculated() {
		var bet = new Bet(new Accumulator(), "2", List.of(
			new BetLeg("2"),
			new BetLeg("3"),
			new BetLeg("4")
		));

		var maxReturn = bet.calculate();

		assertThat(maxReturn).isEqualByComparingTo("48");
	}

	@Test
	void perms2from3betIsCalculated() {
		var bet = new Bet(new Perms(2), "1", List.of(
			new BetLeg("2"),
			new BetLeg("3"),
			new BetLeg("4")
		));

		var maxReturn = bet.calculate();

		assertThat(maxReturn).isEqualByComparingTo("26");
	}

	@Test
	void patentBetIsCalculated() {
		var bet = new Bet(new FullCover(), "1", List.of(
			new BetLeg("2"),
			new BetLeg("3"),
			new BetLeg("4")
		));

		var maxReturn = bet.calculate();

		assertThat(maxReturn).isEqualByComparingTo("59");
	}

	@Test
	void betWithZeroStakeIsInvalid() {
		assertThatThrownBy(
			() -> new Bet(new Accumulator(), "0", List.of(new BetLeg("2")))
		).isExactlyInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void betWithZeroLegsIsInvalid() {
		assertThatThrownBy(
			() -> new Bet(new Accumulator(), "10", List.of())
		).isExactlyInstanceOf(IllegalArgumentException.class);
	}
}
