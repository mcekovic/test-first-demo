package org.strangeforest.bc.bettypes;

import java.util.*;
import java.util.stream.*;

import org.strangeforest.bc.*;

public class Accumulator implements BetType {

	@Override public <T> Stream<List<T>> combinations(List<T> items) {
		return Stream.of(items);
	}
}
