package org.demo.java7.files;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ReadWriteDemo {
	
	/**
	 * 读取文件的全部内容
	 */
	public static void readDemo() throws IOException {
		byte[] bytes = Files.readAllBytes(Paths.get("d:", "temp", "path-demo1", "demo.txt"));
		String content = new String(bytes, StandardCharsets.UTF_8);
		System.out.println(content);
	}
	
	/**
	 * 按行读取
	 * @throws IOException
	 */
	public static void readLineDemo() throws IOException{
		List<String> lines = Files.readAllLines(Paths.get("d:", "temp", "path-demo1", "demo.txt"));
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	public static void writeDemo() throws IOException{
		String s = "aaa,bbb";
		Path p = Paths.get("d:", "temp", "path-demo1", "demo.txt");
		Files.write(p, s.getBytes(StandardCharsets.UTF_8));
		Files.write(p, s.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
	}
	
	/**
	 * 如果文件很大
	 * @throws IOException
	 */
	public static void readStreamDemo() throws IOException{
		Path p = Paths.get("d:", "temp", "path-demo1", "demo.txt");
		
		InputStream in = Files.newInputStream(p);
		OutputStream out = Files.newOutputStream(p);
		Reader reader = Files.newBufferedReader(p, StandardCharsets.UTF_8);
		Writer writer = Files.newBufferedWriter(p, StandardCharsets.UTF_8);
	}
	
	
	public static void filesCopyDemo() throws IOException {
		Path p1 = Paths.get("d:", "temp", "path-demo1", "demo.txt");
		Path p2 = Paths.get("d:", "temp", "path-demo2", "demo.txt");
		
		try(InputStream in = Files.newInputStream(p1)) {
			Files.copy(in, p2);
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		readDemo();
	}

}
