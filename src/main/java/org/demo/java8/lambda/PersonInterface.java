package org.demo.java8.lambda;

public interface PersonInterface {
	
	long getId();
	
	/**
	 * 默认方法 , 接口中包含带有具体实现的方法。 接口的实现类可以选择保留 getName 的实现， 或者重写它。
	 * @return
	 */
	default String getName() {
		return "my name";
	}
	
	/**
	 * 静态方法
	 * @param name
	 * @return
	 */
	public static int getAge(String name) {
		return 20;
	}
	
}
