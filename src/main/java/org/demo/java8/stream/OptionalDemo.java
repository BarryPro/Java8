package org.demo.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Optional<T> 对象或者是对一个T类型对象的封装，或者表示不是任何对象
 * 
 * 
 * @author zhangsf
 *
 */
public class OptionalDemo {
	static List<String> results = new ArrayList<>();
	
	public static void  demo1() {
		List<String> wordList = Arrays.asList(new String[]{"a", "b", "c"});
		Optional<String> largest = wordList.stream().max(String::compareToIgnoreCase);
		// 判断值 是否存在
		if (largest.isPresent()) {
			System.out.println("largest:"+largest.get());
		}
		
		
		largest.ifPresent(v -> results.add(v));
		
		largest.ifPresent(results::add);
	}
	
	
	/**
	 * 创建一个Optional 对象
	 * @param x
	 * @return
	 */
	public static Optional<Double>  inverse (Double x) {
		return x==0?Optional.empty():Optional.of(1/x);
	}
	
	/**
	 * 计算平方根
	 * @param x
	 * @return
	 */
	public static Optional<Double>  squareRoot (Double x) {
		return x<0?Optional.empty():Optional.of(Math.sqrt(x));
	}
	
	
	public static void  demo3 () {
		
		// 相当于调用  inverse(x).squareRoot(y);
		inverse(5d).flatMap(OptionalDemo::squareRoot);
	}
	
	
}
