package org.demo.java7.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 没有直接删除或者复制非空目录的方法， 要实现这些操作，需要使用 FileVisitor 接口
 * 
 * 
 * @author zhangsf
 *
 */
public class CopeMoveDemo {
	
	/**
	 * 复制文件
	 * @throws IOException 
	 */
	public static void copyDemo() throws IOException {
		Path p1 = Paths.get("d:", "temp", "path-demo1", "demo.txt");
		Path p2 = Paths.get("d:", "temp", "path-demo2");
		
		// 如果目标文件或目录已经存在，copy 或者move 会失败
		Files.copy(p1, p2);
		//覆盖一个已经存在的目标文件， 使用 REPLACE_EXISTING
		Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
		
	}
	
	public static void moveDemo() throws IOException {
		Path p1 = Paths.get("d:", "temp", "path-demo1", "demo.txt");
		Path p2 = Paths.get("d:", "temp", "path-demo2");
		
		Files.move(p1, p2);
		
		//原子方式执行移动操作  ATOMIC_MOVE
		Files.move(p1, p2, StandardCopyOption.ATOMIC_MOVE);
	}
	
	public static void delDemo() throws IOException {
		Path p2 = Paths.get("d:", "temp", "path-demo2", "demo.txt");
		// 文件不存在则抛出异常
		Files.delete(p2);
		
		boolean deleted = Files.deleteIfExists(p2);
	}

}
