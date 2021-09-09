package org.strangeforest.bc;

import java.util.*;
import java.util.stream.*;

public interface BetType {

	<T> Stream<List<T>> combinations(List<T> items);
}
