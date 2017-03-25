package org.demo.java8.lambda;

public class VariableScope {
	
	/**
	 * 自由变量： 不是参数并且没有在代码中定义的变量
	 * @param text  自由变量
	 * @param count 自由变量
	 */
	public static void demo(String text, int count) {
		Runnable r = () -> { // 含有自由变量的代码块被成为 闭包 （closure）
			for (int i=0; i< count; i++) {
				System.out.println(text);
			}
		};
		
		new Thread(r).start();
	}
	
	
	public static void demo1(String text, int count) {
		Runnable r = () -> { // 含有自由变量的代码块被成为 闭包 （closure）
			for (int i=0; i< count; i++) {
				//count--;  //错误， 不能更改已经捕获变量的值
				System.out.println(text);
			}
		};
		
		new Thread(r).start();
	}
	
	
}
