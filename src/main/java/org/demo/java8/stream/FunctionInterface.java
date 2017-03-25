package org.demo.java8.stream;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class FunctionInterface {
	
	
	public static void demo() {
		
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
		 * <p>参数类型    |  返回类型    |  描述
		 * <p>  T,U  |   void  |  处理T类型和U类型得值
		 */
		BiConsumer<String, String> biConsumer =  (String x, String y) -> x.concat(y) ;
		
		/**
		 * <p>参数类型    |  返回类型             |  描述
		 * <p>  T    |   boolean  |  一个计算Boolean值得函数
		 */
		Predicate<Integer> predicate = (Integer x) -> x>0 ;
		
		/**
		 * <p>参数类型    |  返回类型             |  描述
		 * <p>  T    |   int      |  计算 int 值得函数
		 */
		ToIntFunction<String> toIntFunction = (String x) -> {return Integer.parseInt(x);};
		
		/**
		 * <p>参数类型    |  返回类型             |  描述
		 * <p>  int  |   T        |  参数为 int 得函数
		 */
		IntFunction<String> intFunction = (int x) -> {return String.valueOf(x);};
		
		/**
		 * <p>参数类型    |  返回类型             |  描述
		 * <p>  T    |   R        |  参数类型为T得函数
		 */
		Function<String, Integer> function = (String x) -> x.length();
		
		
		/**
		 * <p>参数类型    |  返回类型             |  描述
		 * <p>  T,U  |   R        |  参数类型为 T 和U 得函数
		 */
		BiFunction<String, String, Integer> biFunction = (x, y) -> (x.concat(y)).length() ;
		
		/**
		 * <p>参数类型    |  返回类型             |  描述
		 * <p>  T  	 |   T        |  对类型T进行得一元操作
		 */
		UnaryOperator<Integer> unaryOperator = (Integer x) -> x/2;
		
		/**
		 * <p>参数类型    |  返回类型             |  描述
		 * <p>  T,T  |   T        |  对类型T进行得二元操作
		 */
		BinaryOperator<Integer> binaryOperator = (Integer x, Integer y) -> (x+y)/2;
		
	}
	
}
