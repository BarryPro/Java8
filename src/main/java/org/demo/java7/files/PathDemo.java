package org.demo.java7.files;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path 用来取代 File类
 * 
 * 
 * @author zhangsf
 *
 */
public class PathDemo {
	
	public static void pathDemo() throws IOException {
		/*
		 *可以接收一个或多个字符串，然后将这些字符串用文件系统默认的路径分隔符(Unix系统为 / , windows系统为 \)连接起来 
		 */
		Path absolute = Paths.get("d:", "temp", "path-demo1", "demo.txt");
		System.out.println(absolute.toRealPath());
		
		Path absolute2 = Paths.get("D:\\temp\\path-demo1\\demo.txt");
	}
	
	/**
	 * 组合解析路径
	 * 
	 * @throws IOException
	 */
	public static void resolveDemo() throws IOException {
		
		/*
		 * p.resolve(q) 
		 * 1.如果q是一个绝对路径，那么返回结果就是q
		 * 2.否则，根据文件系统规则，结果就是p 然后 q
		 */
		Path homeDirectory = Paths.get("d:", "temp");
		Path configPath = homeDirectory.resolve("path-demo1/demo.txt");
		System.out.println(configPath.toRealPath());
		
		/*
		 * resolveSibling 针对某个路径的父目录进行解析，并产生一个兄弟路径
		 * 
		 */
		Path workPath = Paths.get("d:", "temp", "path-demo1");
		Path tempPath = workPath.resolveSibling("path-demo2");
		System.out.println(tempPath.toRealPath());
		
	}
	
	/**
	 * resolve 相反的方法
	 * 构建相对路径
	 * 
	 * @throws IOException
	 */
	public static void relativizeDemo() throws IOException {
		Path pathA = Paths.get("d:", "temp", "path-demo1");
		Path p = pathA.relativize(Paths.get("d:", "temp", "path-demo2"));
		System.out.println(p.toString());
	}
	
	/**
	 * 去掉路径种的冗余
	 * @throws IOException
	 */
	public static void normalizeDemo() throws IOException {
		Path pathA = Paths.get("d:\\temp\\path-demo1\\..\\path-demo2");
		System.out.println(pathA.normalize());
	}
	
	
	public static void toAbsolutePathDemo() throws IOException {
		Path pathA = Paths.get("src","main","java");
		System.out.println(pathA.toAbsolutePath());
	}
	
	
	public static void demo1() throws IOException {
		Path absolute = Paths.get("d:", "temp", "path-demo1", "demo.txt");
		
		Path parent = absolute.getParent();
		System.out.println(parent.toString());
		
		Path file = absolute.getFileName();
		System.out.println(file.toString());
		
		Path root = absolute.getRoot();
		System.out.println(root.toString());
	}
	
	
	
	public static void main(String[] args) throws Exception {
//		pathDemo();
//		resolveDemo();
//		relativizeDemo();
//		normalizeDemo();
//		toAbsolutePathDemo();
		demo1();
	}

}
