package org.demo.java8.others;

import java.util.Base64;

public class Base64Demo {
	
	public static void demo() {
		Base64.Encoder encoder = Base64.getEncoder();
		String encoded = encoder.encodeToString("aaa".getBytes());
				
	}

}
