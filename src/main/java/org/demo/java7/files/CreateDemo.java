package org.demo.java7.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateDemo {
	
	/**
	 * 创建文件夹
	 * 
	 * @throws IOException 
	 */
	public static void create() throws IOException {
		Path p = Paths.get("d:", "temp", "path-demo3");
		
		// 路径中出了最后一部分以外的其他目录，必须都已经存在
		Files.createDirectory(p);
		
		//同时创建中间目录
		Files.createDirectories(p);
	}

}
