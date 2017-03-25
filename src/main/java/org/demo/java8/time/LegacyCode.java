package org.demo.java8.time;

import java.text.Format;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 与遗留代码互操作
 * 
 * 
 * 
 * @author zhangsf
 *
 */
public class LegacyCode {
	
	public static void demo() {
		//Instant 类似 java.util.Date 
		Date date = new Date();
		//Date -> Instant
		Instant now = date.toInstant();
		// Instant -> Date
		date.from(now);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		Format format = formatter.toFormat();
	}

}
