package org.demo.java8.stream;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {
	
	public static void demo1() {
		
		//集合转为 Stream 
		List<String> l = new ArrayList<>();
		Stream<String> listStream = l.stream();
		
		// 数组转为 Stream
		String[] strings = {"a", "b", "c"};
		Stream<String> words = Stream.of(strings);
		
		// 多个参数转为 Stream
		Stream<String> song = Stream.of("a", "b", "c");
		
		//空的Stream
		Stream<String> silence = Stream.empty();
		
		
		//generate 静态方法
		Stream<String> echos = Stream.generate(()->"create stream");
		Stream<Double> randoms = Stream.generate(Math::random);
		
		
		//创建一个 0 1 2 3... 的无限序列
		Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
	}

}
