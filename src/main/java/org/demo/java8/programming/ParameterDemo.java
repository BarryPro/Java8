package org.demo.java8.programming;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class ParameterDemo {
	
	public static void demo1() {
		String[] names = {"aaa", "bbb", "ccc"};
		
		Arrays.sort(names, (s,t) ->Integer.compare(s.length(), t.length()));
		
		//选择 lambda 表达式的入参函数
		repeat(10, i -> System.out.println("Countdown: "+(9-i)) );
	}
	
	public static void repeat(int n, IntConsumer action) {
		for (int i=0; i<n; i++) {
			action.accept(i);
		}
	}
	
	
}
