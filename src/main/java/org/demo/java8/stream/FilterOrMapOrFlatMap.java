package org.demo.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 转换流： 从一个流中读取数据，并将转换后的数据写入到另一个流中
 * @author zhangsf
 *
 */
public class FilterOrMapOrFlatMap {
	
	/**
	 * 过滤器
	 */
	public static void filter() {
		List<String> wordList = Arrays.asList(new String[]{"a", "b", "cc"});
		Stream<String> words = wordList.stream();
		Stream<String> longWords = words.filter(w->w.length()>1);
		
	}
	
	/**
	 * 元素转换
	 */
	public static void map() {
		List<String> wordList = Arrays.asList(new String[]{"a", "b", "cc"});
		Stream<String> words = wordList.stream();
		Stream <String> lowercaseWords = words.map(String::toLowerCase);
		Stream <String> lowercaseWords1 = words.map(s -> s.toLowerCase());
	}
	
	
	/**
	 * 展开 Stream 结果
	 */
	public static void flatMap() {
		
		List<String> wordList = Arrays.asList(new String[]{"aaa", "bbb", "ccc"});
		// 返回  [ [a,a,a],[b,b,b],[c,c,c]  ]
		Stream<Stream<Character>> result = wordList.stream().map(FilterOrMapOrFlatMap::characterStream);
		
		// 返回 [a,a,a,b,b,b,c,c,c]
		Stream<Character> letters = wordList.stream().flatMap(FilterOrMapOrFlatMap::characterStream);
	}
	
	public static Stream<Character> characterStream(String s) {
		List<Character> result = new ArrayList<>();
		for (char c : s.toCharArray()) {
			result.add(c);
		}
		return result.stream();
	}
	
}
