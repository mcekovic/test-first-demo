package org.strangeforest.bc.bettypes;

import java.util.*;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class AccumulatorTest {

	@Test
	void testAccumulator() {
		var accumulator = new Accumulator();

		var combinations = accumulator.combinations(List.of("A", "B", "C"));

		assertThat(combinations).containsExactly(List.of("A", "B", "C"));
	}
}
