package org.demo.java8.lambda;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {
	/**
	 * java8 以前的写法 
	 */
	@Test
	public void demo11() {
		class Worker implements Runnable {
			@Override
			public void run() {
				for (int i=0; i<100; i++) {
					System.out.println(i);
				}
			}
		}
		Worker w = new Worker();
		new Thread(w).start();
	}

	/**
	 * lambda 表达式
	 */
	@Test
	public void demo1() {
		Thread t = new Thread(()->{
			for (int i=0; i<100; i++) {
				System.out.println(i);
			}
		});

		t.start();
	}

	/**
	 * java8 以前的写法
	 */
	@Test
	public void demo22() {
		String[] strings = {"aa", "aaaa", "a", "aaa"};

		class LengthComparator implements Comparator<String> {

			@Override
			public int compare(String first, String second) {
				return Integer.compare(first.length(), second.length());
			}
		}

		Arrays.sort(strings, new LengthComparator());
	}

	/**
	 * lambda 表达式
	 */
	@Test
	public void demo2() {
		String[] strings = {"aa", "aaaa", "a", "aaa"};
		Comparator<String> comp = (first, second)-> Integer.compare(first.length(), second.length());
		Arrays.sort(strings, comp);
	}


	/**
	 * java8 以前的写法
	 */
	public void demo33() {
		Button button = new Button();
		button.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("clicking");
			}
		});
	}

	/**
	 * lambda 表达式
	 */
	public void demo3() {
		Button button = new Button();
		button.setOnAction(event-> System.out.println("clicking"));
	}

	public static void main(String[] args) {
		new LambdaDemo().demo3();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		
	}


}
