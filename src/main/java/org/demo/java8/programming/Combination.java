package org.demo.java8.programming;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class Combination {
	
	
	public static void demo() {
		int[] integers = {1,2,3,4,5};
		// 组合函数
		Arrays.setAll(integers, composeInt(x->x+1, y->y+1));
		
		//非组合函数需要2步，可能会产生中间变量
		Arrays.setAll(integers, x->x+1);
		Arrays.setAll(integers, y->y+1);
	}
	
	
	public static <T> UnaryOperator<T> compose(UnaryOperator<T> op1, UnaryOperator<T> op2) {
		return t -> op2.apply(op1.apply(t));
	}
	
	
	public static IntUnaryOperator composeInt(IntUnaryOperator op1, IntUnaryOperator op2) {
		return t -> op2.applyAsInt(op1.applyAsInt(t));
	}
}
