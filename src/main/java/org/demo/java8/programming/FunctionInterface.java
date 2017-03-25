package org.demo.java8.programming;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionInterface {
	
	
	public static void demo() {
		
		/**
		 * <p>参数类型    |  返回类型    |  描述
		 * <p>  无          |   void  |  执行一个没有参数和返回值的操作
		 */
		Runnable runnable = ()-> System.out.println("run");
		
		
		/**
		 * <p>参数类型    |  返回类型    |  描述
		 * <p>  无          |   T     |  提供一个T类型得值
		 */
		Supplier<String> supplier = ()-> "aaa";
		
		/**
		 * <p>参数类型    |  返回类型    |  描述
		 * <p>  T    |   void  |  处理一个T类型得值
		 */
		Consumer<String> consumer = (String x) -> System.out.println(x);
		
		
		/**
		 * <p>参数类型    |  返回类型             |  描述
		 * <p>  T    |   R        |  参数类型为T得函数
		 */
		Function<String, Integer> function = (String x) -> x.length();
	}
	
}
