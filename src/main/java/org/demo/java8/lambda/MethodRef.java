package org.demo.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;

import javafx.scene.control.Button;

/**
 * <code>对象::实例方法</code>
 * <code>类::静态方法</code>
 * <p>方法引用等同于提供方法参数的 lambda表达式
 * 例如： 
 * System.out::println  等同于  x -> System.out.println(x)
 * Math::pow   等同于  (x,y) -> Math.pow(x, y)
 * 
 * ===================================================================
 * 
 * <code>类::实例方法</code>
 * 第一个参数会成为执行方法的对象
 * 例如 String::compareToIgnoreCase  等同于  (x,y) -> x.compareToIgnoreCase(y)
 * 
 * @author zhangsf
 *
 */
public class MethodRef {
	
	public static void demo() {
		Button button = new Button();
		button.setOnAction(event-> System.out.println(event));
		// 方法引用
		button.setOnAction(System.out::println);
	}
	
	public static void demo1() {
		String[] strings = {"aaa", "aa", "aaaa", "a"};
//		Comparator<String> comp = (x, y)-> x.compareToIgnoreCase(y);
		Arrays.sort(strings, (x, y)-> x.compareToIgnoreCase(y));
		
		Arrays.sort(strings, String::compareToIgnoreCase);
	}
	
	
	public static void demo2() {
		class Greeter {
			public void greet() {
				System.out.println("Hello ,world!");
			}
		}
		
		class ConcurrentGreeter extends Greeter {
			public void greet() {
				Thread t = new Thread(super::greet);
				t.start();
				
				Thread t1 = new Thread(()-> super.greet() );
				t1.start();
			}
		}
		
	}

}
