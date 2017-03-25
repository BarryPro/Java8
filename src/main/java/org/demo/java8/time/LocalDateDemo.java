package org.demo.java8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 新的API 中，有2种时间，本地日期/时间  与  带时区的时间
 * 
 * 可以使用  plus 添加  天/周/月/年
 * 可以使用 minus 减去  天/周/月/年
 * 
 * 
 * Period : 两个本地时间之间的时段 ， 表示一段逝去的年/月/日
 * 
 * @author zhangsf
 *
 */
public class LocalDateDemo {
	
	/**
	 * LocalDate 是一个带有年份，月份，当月天数的日期
	 */
	public static void demo() {
		//今天的日期
		LocalDate today = LocalDate.now();
		
		//生日
		LocalDate birthday1 = LocalDate.of(1985, 1, 17);
		
		// Period 时段，表示一段逝去的年，月，日
		//获取下一年的生日日期
		LocalDate birthday2= birthday1.plus(Period.ofYears(1));
		
		// 返回2个日期之间的天数
		birthday2.until(birthday1, ChronoUnit.DAYS);
		
		// 一年中的 第 255 天
		LocalDate programmersDay = LocalDate.of(2016, 1, 1).plusDays(255);
		
		
		// 返回星期几
		LocalDate.of(1900, 1, 1).getDayOfWeek().getValue();
		
		// 周六后的三天 是 周二
		DayOfWeek.SATURDAY.plus(3);
	}

}
