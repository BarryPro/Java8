package org.demo.java7.trywith;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.Scanner;

public class TryWithResourcesDemo {
	
	
	public void demo1() throws IOException {
		try(Scanner in = new Scanner(Paths.get("D:\\temp\\demo.txt"))) {
			while(in.hasNext()) {
				System.out.println(in.next().toLowerCase());
			}
		}
	}
	
	/**
	 * 自动关闭 in与 out
	 * @throws IOException
	 */
	public void demo2() throws IOException {
		try(Scanner in = new Scanner(Paths.get("D:\\temp\\demo.txt"));
				PrintWriter out = new PrintWriter("D:\\temp\\demo1.txt")) {
			while(in.hasNext()) {
				out.println(in.next().toLowerCase());
			}
		}
	}
	
	
	/**
	 * catch 多个异常
	 * @throws IOException
	 */
	public void demo3() throws IOException {
		try {
			Class.forName(TryWithResourcesDemo.class.getName()).getMethod("demo1").invoke(null, new Object[]{});
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用相关父类
	 * @throws IOException
	 */
	public void demo4() throws IOException {
		try {
			Class.forName(TryWithResourcesDemo.class.getName()).getMethod("demo1").invoke(null, new Object[]{});
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}

}
