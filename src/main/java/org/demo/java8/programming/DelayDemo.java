package org.demo.java8.programming;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 延迟执行
 * @author zhangsf
 *
 */
public class DelayDemo {
	
	static Logger logger = Logger.getLogger("DelayDemo");
	
	public static void logger(String x, String y) {
		
		// 字符串总是会被计算并传递给 info 方法， 然后再确定是否真的要执行
		logger.info("x: " + x + ", y: " + y);
		
		// 使用lambda 表达式延迟记录日志
		logger.info(()->"x: " + x + ", y: " + y);
	}
	
	
	
	public static void info (Logger logger, Supplier<String> message) {
		if (logger.isLoggable(Level.INFO)) {
			logger.info(message.get());
		}
	}
	
}
