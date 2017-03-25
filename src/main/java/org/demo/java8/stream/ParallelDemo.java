package org.demo.java8.stream;

import java.util.stream.Stream;

/**
 * 并行流
 * 
 * 默认情况下，流操作会创建一个串行流，方法 Collection.parallelStream() 除外 。
 * parallel 方法可以将任意串行流转为一个并行流
 * 
 * @author zhangsf
 *
 */
public class ParallelDemo {
	
	/**
	 * 串行流 变 并行流
	 */
	public static void parallel() {
		String[] strings = {"a", "b", "c", "d"};
		Stream<String> parallelWords = Stream.of(strings).parallel();
	}
	
	
}
