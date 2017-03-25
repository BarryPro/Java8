package org.demo.java8.stream;

import java.util.Optional;
import java.util.stream.Stream;

public class ReduceDemo {

	// (x op y) op z = x op (y op z)
	public static void demo1() {
		Integer[] ints = { 1, 2, 3, 4, 5 };

		Stream<Integer> intStream = Stream.of(ints);
		Optional<Integer> sum = intStream.reduce((x, y) -> x + y);
	}

	/**
	 * 当流为空时返回标识值
	 */
	public static void demo2() {
		Integer[] ints = { 1, 2, 3, 4, 5 };

		Stream<Integer> intStream = Stream.of(ints);
		Integer sum = intStream.reduce(0, (x, y) -> x + y);

	}

}
