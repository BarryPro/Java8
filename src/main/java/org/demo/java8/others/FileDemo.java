package org.demo.java8.others;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class FileDemo {

	public static void demo1() throws IOException {
		try (Stream<String> lines = Files.lines(Paths.get("D:", "temp", "test.txt"))) {
			Optional<String> passwordEntry = lines.filter(s -> s.contains("password")).findFirst();
		}
	}

	public static void demo2() throws IOException {
		// 不会查询子目录
		try (Stream<Path> entries = Files.list(Paths.get("D:", "temp"))) {

		}
		
		// 查询所有子目录
		try (Stream<Path> entries = Files.walk(Paths.get("D:", "temp"))) {

		}
	}

}
