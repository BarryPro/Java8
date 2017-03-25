package org.demo.java7.other;

import java.util.Objects;

public class NullDemo {
	
	public static void nullDemo(String s) {
		// 检查参数是否为 Null
		Objects.requireNonNull(s);
	}

}
