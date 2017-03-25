package org.demo.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.scene.control.Button;

public class ConstructorRef {
	
	/**
	 * 通过 strings 来构建 一组 Button List
	 */
	public static void demo() {
		List<String> labels = new ArrayList<>();
		
		Stream<Button> stream = labels.stream().map(Button::new);
		List<Button> buttons = stream.collect(Collectors.toList());
	}
	
	
}
