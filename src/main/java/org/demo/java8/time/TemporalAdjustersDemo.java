package org.demo.java8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * 日期校正器
 * 
 * 可以用来计算   “每个月的第一个周二”  这样的日期
 * 
 * 
 * @author zhangsf
 *
 */
public class TemporalAdjustersDemo {
	
	/**
	 * 计算某个月的第一个周二
	 */
	public static void demo1() {
		LocalDate firstTuesday = LocalDate.of(2016, 12, 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
	}
	
}
