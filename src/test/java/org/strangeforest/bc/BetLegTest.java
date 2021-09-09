package org.strangeforest.bc;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class BetLegTest {

	@Test
	void betLegWithPriceLessThanOneIsInvalid() {
		assertThatThrownBy(
			() -> new BetLeg("0.5")
		).isExactlyInstanceOf(IllegalArgumentException.class);
	}
}
