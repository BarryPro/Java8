package org.demo.java7.other;

public class NumberParseDemo {
	
	public static void demo() {
		double x = Double.parseDouble("+1.0");
		// 在jdk7 以前， +1 不是一个有效的整数
		int n = Integer.parseInt("+1.0");
	}

}
