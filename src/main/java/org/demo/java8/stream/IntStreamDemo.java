package org.demo.java8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamDemo {
	
	/**
	 * 
	 * Stream<Integer>  整数包装为对象是低效得
	 * 
	 * short,char,byte,boolean -> IntStream
	 * long -> LongStream
	 * float -> DoubleStream
	 * 
	 */
	public static void demo1() {
		//short
		//char
		//byte
		//boolean
		//int
		IntStream stream = IntStream.of(1, 1, 2, 3, 5);
		
		//不包扩上限 
		IntStream zeroToNinetyNine = IntStream.range(0, 100);
		// 包扩上限
		IntStream zeroToHundred = IntStream.rangeClosed(0, 100);
		
		Stream<Integer> integers = IntStream.range(0, 100).boxed();
		
		// maptoInt 转为原始类型流
		String[] strings = {"a", "aa", "aaa", "aaaa"};
		IntStream lengths = Arrays.stream(strings).mapToInt(String::length);
		
	}

}
