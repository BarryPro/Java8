package org.demo.java8.time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeDemo {
	
	/**
	 * 获取所有的时区ID
	 */
	public static void demo() {
		ZoneId.getAvailableZoneIds().forEach(System.out::println);
	}
	
	/**
	 * 创建一个时区对象
	 */
	public static void dem1() {
		// 1969-07-16 T 09:32-04:00[America/New_York]
		ZonedDateTime apollolllaunch = ZonedDateTime.of(1969, 7, 16, 9, 32, 0, 0, ZoneId.of("America/New_York"));
	}

}
