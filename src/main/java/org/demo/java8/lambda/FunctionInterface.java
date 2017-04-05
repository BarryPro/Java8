package org.demo.java8.lambda;

import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;

/**
 * 对于只包含一个抽象方法的接口，你可以通过lambda表达式来创建该接口的对象，这种接口被成为 函数式接口
 * 
 * @author zhangsf
 *
 */
public class FunctionInterface {
	
	/**
	 * 函数式接口1
	 */
	public static void demo1() {
		Runnable r = () -> {
			System.out.println("Runnable 是一个函数式接口");
		};
	}
	
	/**
	 * 函数式接口2
	 */
	public static void demo2() {
		BiFunction<String, String, Integer> comp = (first, second) -> Integer.compare(first.length(), second.length());
	}
	
	public static void main(String[] args) {
		
		Runnable runnable = ()->{System.out.println("belong");};
		Thread thread = new Thread(runnable);
		thread.start();
		Thread thread2 = new Thread(()->{
			new Random().ints().limit(10).forEach(System.out::println); 
		});
		thread2.start();
	}
}
