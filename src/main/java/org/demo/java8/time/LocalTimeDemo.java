package org.demo.java8.time;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * LocalTime 表示一天中的某个时间 例如 15:30:00 
 * 
 * 
 * @author zhangsf
 *
 */
public class LocalTimeDemo {
	
	public static void demo() {
		
		//当前时间
		LocalTime rightNow = LocalTime.now();
		// 指定时间
		LocalTime bedtime = LocalTime.of(22, 30);
		
		// 休息8个小时的起床时间
		LocalTime wakeup = bedtime.plusHours(8);
		
	}
	
	/**
	 * LocalDateTime 表示一个日期和时间
	 */
	public static void demo1() {
		LocalDateTime now = LocalDateTime.now();
	}

}
