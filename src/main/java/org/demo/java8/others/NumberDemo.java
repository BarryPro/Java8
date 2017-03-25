package org.demo.java8.others;

public class NumberDemo {
	
	public static void demo() {
		
		// 以byte为单位表示类型长度
		final int a = Integer.BYTES;
		
		// 提供 sum  max  min 给流操作使用
		Integer.sum(1, 2);
		
		// 有符号数 转为无符号数
		Integer.toUnsignedLong(1);
	}

}
