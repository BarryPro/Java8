package org.demo.java8.programming;

import java.util.Arrays;
import java.util.Comparator;

public class ReturnDemo {
	
	public static  void demo() {
		String[] strings = {"a", "bb", "ccc", "ddd"};
		
		Arrays.sort(strings, comparator1());
		
	}
	
	/**
	 * 返回按照字符长度比较的 函数表达式实例
	 * @return
	 */
	public static Comparator<String>  comparator1() {
		return (String x, String y) -> Integer.compare(x.length(), y.length());
	}
	
	/**
	 *  返回 忽略大小写的  函数表达式实例
	 * @return
	 */
	public static Comparator<String>  comparator2() {
		return (String x, String y) -> x.compareToIgnoreCase(y);
	}

}
