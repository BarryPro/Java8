package org.demo.java8.time;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * Instant  时间的瞬时点
 * 
 * Duration  计算2个瞬时点之间的时间距离，  表示两个瞬时点之间的时间量
 * 
 * 
 * @author zhangsf
 *
 */
public class InstantDemo {
	
	public static void demo() throws InterruptedException {
		Instant start = Instant.now();
		
		TimeUnit.SECONDS.sleep(5);
		
		Instant end = Instant.now();
		
		Duration timeElapsed = Duration.between(start, end);
		long millis = timeElapsed.toMillis();
	}

}
