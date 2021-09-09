package org.strangeforest.bc.bettypes;

import java.util.*;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class PermsTest {

	@Test
	void testPerms2from3() {
		var perms2 = new Perms(2);

		var combinations = perms2.combinations(List.of("A", "B", "C"));

		assertThat(combinations).containsExactly(
			List.of("A", "B"),
			List.of("A", "C"),
			List.of("B", "C")
		);
	}

	@Test
	void perms3from2areInvalid() {
		var perms3 = new Perms(3);

		assertThatThrownBy(
			() -> perms3.combinations(List.of("A", "B"))
		).isExactlyInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void permsOfNegativeLengthAreInvalid() {
		assertThatThrownBy(
			() -> new Perms(-1)
		).isExactlyInstanceOf(IllegalArgumentException.class);
	}
}
