package org.demo.java8.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 收集结果 处理完流以后，只查看流的结果，而不是将他们聚合为一个值
 * 
 * @author zhangsf
 *
 */
public class CollectDemo {
	
	/**
	 * 聚合函数
	 */
	public static void demo1() {
		String[] strings = { "z", "x", "c", "v" };

		Stream<String> stream = Arrays.stream(strings);
		// 获取迭代器
		stream.iterator();

		String[] result = stream.toArray(String[]::new);
	}

	/**
	 * 并行收集不能使用聚合函数, 需要使用 collect
	 * 
	 * <p>1.一个能创建目标类型实例的方法，例如 hash set 的构造函数
	 * <p>2.一个将元素添加到目标中的方法，例如一个 add方法
	 * <p>3.一个将两个对象整合到一起的方法，例如 addAll方法
	 */
	public static void collect() {
		String[] strings = { "z", "x", "c", "v" };

		Stream<String> stream = Arrays.stream(strings);
		HashSet<String> result = stream.collect(HashSet::new, HashSet::add, HashSet::addAll);
	}
	
	/**
	 * 使用收集器
	 */
	public static void collect2() {
		String[] strings = { "z", "x", "c", "v" };
		Stream<String> stream = Arrays.stream(strings);
		
		// 收集结果到 List
		List<String> result = stream.collect(Collectors.toList());
		
		// 收集结果到 Set
		Set<String> result2 = stream.collect(Collectors.toSet());
		
		//控制Set类型
		TreeSet<String> result3 = stream.collect(Collectors.toCollection(TreeSet::new));
	}
	
	
	public static void collect3() {
		String[] strings = { "z", "x", "c", "v" };
		Stream<String> stream = Arrays.stream(strings);
		// 将流中所有的字符串连接起来
		String result = stream.collect(Collectors.joining());
		
		// 将流中所有的字符串连接起来 , 使用 , 分隔符
		String result2 = stream.collect(Collectors.joining(","));
		
		//流中包含字符串以外的对象，先将他们转换为字符串
		String result3 = stream.map(Object::toString).collect(Collectors.joining(","));
		
		// 将流结果聚合为一个 总和，平均值，最大值，或者最小值
		IntSummaryStatistics summary = stream.collect(Collectors.summarizingInt(String::length));
		double average = summary.getAverage();
		double max = summary.getMax();
		
	}
	
	/**
	 * 打印所有元素
	 */
	public static void collect4() {
		String[] strings = { "z", "x", "c", "v" };
		Stream<String> stream = Arrays.stream(strings);
		stream.forEach(System.out::println);
	}
	

}
