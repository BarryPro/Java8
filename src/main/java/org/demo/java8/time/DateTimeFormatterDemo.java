package org.demo.java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * 三种格式化方式
 * 
 * 预定义的标准格式 语言环境的相关格式 自定义的格式
 * 
 * 
 * @author zhangsf
 *
 */
public class DateTimeFormatterDemo {

	public static void demo() {
		LocalDateTime now = LocalDateTime.now();

		// 标准格式化
		String formatted = DateTimeFormatter.ISO_DATE_TIME.format(now);

	}

	public static void demo2() {
		
		LocalDateTime now = LocalDateTime.now();
		
		// 语言环境相关的格式化
		// 风格 SHORT， MEDIUM， LONG， FULL
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		String formatted2 = formatter.format(now);
		
		//使用指定的语言环境
		String formatted3 = formatter.withLocale(Locale.FRENCH).format(now);
	}
	
	
	
	public static void demo3() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm");
	}
	
	public static void demo4() {
		LocalDate ldate = LocalDate.parse("2016-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

}
