package org.demo.java8.stream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class IteratorOrStream {
	
	/**
	 * Stream 是java8中处理集合的关键抽象概念
	 * 
	 * 使用 for 循环迭代所有元素， 无法并行计算
	 * 
	 * 使用Stream ：
	 * 1.创建一个Stream
	 * 2.在一个或者多个步骤中，指定将初始Stream转换为另一个Stream的中间操作
	 * 3.使用一个终止操作来产生一个结果。该操作会强制它之前的延迟操作立即执行。
	 * 
	 * @throws IOException
	 */
	public static void demo1() throws IOException {
		String filePath = IteratorOrStream.class.getResource("").getPath()+"demo1.txt";
		File file = new File(filePath);
		String contents = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())), StandardCharsets.UTF_8);
		System.out.println(contents);
		
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		// for 循环迭代器
		int count = 0;
		for (String w: words) {
			if (w.length() > 12) count++;
		}
		System.out.println(count);
		
		// stream
		long count1 = words.stream().filter(w->w.length()>12).count();
		System.out.println(count1);
		
		//1. stream 自己不会存储元素。元素可能被存储在底层集合中，或者根据需要产生出来
		//2. stream 操作不会改变源对象，相反，他们会返回一个持有结果的新stream
		//3. stream操作符可能是延迟执行的。
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		demo1();
	}

}
