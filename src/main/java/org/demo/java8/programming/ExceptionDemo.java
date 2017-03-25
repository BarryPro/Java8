package org.demo.java8.programming;

import java.util.function.Consumer;

public class ExceptionDemo {

	/**
	 * 顺序执行
	 * 
	 * @param first
	 * @param second
	 */
	public static void doInOrder(Runnable first, Runnable second) {
		first.run();
		second.run();
	}

	/**
	 * 异步执行， doInOrderAsync会立即返回并进行另一个线程中的工作，因此无法让方法重新抛出异常。
	 * 
	 * @param first
	 * @param second
	 */
	public static void doInOrderAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
		Thread t = new Thread() {
			public void run() {
				try {
					first.run();
					second.run();
				} catch (Throwable t) {
					handler.accept(t);
				}
			}
		};
		t.start();
	}

}
