package org.demo.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LimitOrConcat {
	
	/**
	 * 产生100个随机数字
	 */
	public static void limit() {
		Stream<Double> randoms = Stream.generate(Math::random).limit(100);
	}
	
	/**
	 * 将两个流连接到一起
	 */
	public static void concat() {
		// 产生新流 [h,e,l,l,o,w,o,r,d]
		Stream<Character> combined = Stream.concat(characterStream("hello"), characterStream("word"));
	}
	
	
	public static Stream<Character> characterStream(String s) {
		List<Character> result = new ArrayList<>();
		for (char c : s.toCharArray()) {
			result.add(c);
		}
		return result.stream();
	}
	
	
	
}
