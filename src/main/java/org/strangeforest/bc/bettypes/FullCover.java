package org.strangeforest.bc.bettypes;

import java.util.*;
import java.util.stream.*;

import org.strangeforest.bc.*;

import static java.util.function.Function.*;
import static org.paukov.combinatorics3.Generator.*;

public class FullCover implements BetType {

	@Override public <T> Stream<List<T>> combinations(List<T> items) {
		return IntStream.rangeClosed(1, items.size())
			.mapToObj(length -> combination(items).simple(length).stream())
			.flatMap(identity());
	}
}
