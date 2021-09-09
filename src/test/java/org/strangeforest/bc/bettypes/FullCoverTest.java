package org.strangeforest.bc.bettypes;

import java.util.*;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class FullCoverTest {

	@Test
	void testPatent() {
		var fullCover = new FullCover();

		var combinations = fullCover.combinations(List.of("A", "B", "C"));

		assertThat(combinations).containsExactly(
			List.of("A"),
			List.of("B"),
			List.of("C"),
			List.of("A", "B"),
			List.of("A", "C"),
			List.of("B", "C"),
			List.of("A", "B", "C")
		);
	}
}
