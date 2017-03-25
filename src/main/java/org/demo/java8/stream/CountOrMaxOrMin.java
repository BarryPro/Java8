package org.demo.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CountOrMaxOrMin {
	
	/**
	 * 获取流中最大值
	 */
	public static void max() {
		List<String> wordList = Arrays.asList(new String[]{"a", "b", "c"});
		Optional<String> largest = wordList.stream().max(String::compareToIgnoreCase);
		if (largest.isPresent()) {
			System.out.println("largest:"+largest.get());
		}
	}
	
	public static void findFirst() {
		List<String> wordList = Arrays.asList(new String[]{"Q", "W", "E"});
		wordList.parallelStream().filter(s->s.startsWith("Q")).findFirst();
		
		wordList.stream().filter(s->s.startsWith("Q")).findAny();
		
	}
	
	

}
