package org.demo.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortOrDistinct {
	
	/**
	 * 字段长度排序
	 */
	public static void sort() {
		List<String> wordList = Arrays.asList(new String[]{"a", "aaa", "aa"});
		Stream<String> longestFirst = wordList.stream().sorted(Comparator.comparing(String::length).reversed());
	}
	
	
	public static void distinct() {
		Stream<String> uniqueWords = Stream.of("merrily","merrily","merrily","merrily","gently").distinct();
	}

}
