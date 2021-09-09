package org.strangeforest.bc.bettypes;

import java.util.*;
import java.util.stream.*;

import org.paukov.combinatorics3.*;
import org.strangeforest.bc.*;

import static java.lang.String.*;

public class Perms implements BetType {

	private final int length;

	public Perms(int length) {
		if (length < 0)
			throw new IllegalArgumentException("Perms length cannot be negative");
		this.length = length;
	}

	@Override public <T> Stream<List<T>> combinations(List<T> items) {
		if (items.size() < length)
			throw new IllegalArgumentException(format("Perms item count %1$d must not be less then length %2$d", items.size(), length));
		return Generator.combination(items).simple(length).stream();
	}
}
