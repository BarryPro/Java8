package org.demo.java8.concurrent;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

	/**
	 * 更新值
	 */
	public static void demo() {
		// 原子操作
		map.replace("name", "haha1", "haha2");

		// 原子更新， 通过一个键和一个函数计算出一个新的值
		map.compute("name", (k, v) -> v == null ? "" : v + "~");

		// 如果 name 不存在初始化为 aaa， 存在则调用函数
		map.merge("name", "aaa", (existingValue, newValue) -> existingValue + "-" + newValue);
	}

	/**
	 * 批量操作
	 * 
	 * <p>
	 * search 对每一个键和值应用一个函数，直到该函数返回一个非null的结果，然后search 会终止并返回该函数的结果
	 * <p>
	 * reduce 会通过提供的累积函数，将所有的键或者值组合起来
	 * <p>
	 * forEach 会对所有键和值应用一个函数
	 * 
	 * <p>
	 * 使用这几个函数需要指定一个并行阈值，如果映射包含的元素数量超过了这个阈值，批量操作就以并行方式执行，如果你希望批量数据操作在一个线程中运行，需要使用Long.MAX_VALUES作于阈值
	 * <p>
	 * 如果希望批量操作尽可能使用更多的线程，则应该使用1作为 阈值
	 */
	public static void demo1() {
		// 查找姓名为 aaa 的 key
		map.search(1, (k, v) -> v.equals("aaa") ? k : null);
		
		//形式1 ，直接调用消费函数
		map.forEach(1, (k, v) -> {
			System.out.println(k + "->" + v);
		});
		// 额外接收一个转换器
		map.forEach(1, (k, v) -> k + "->" + v, System.out::println);
		
		
		String allNames = map.reduceValues(1, (x, y) -> x.concat(",").concat(y));
	}
	
	/**
	 * Set 视图
	 * 
	 * 
	 */
	public static void demo2() {
		Set<String> names = map.newKeySet();
		
	}

}
