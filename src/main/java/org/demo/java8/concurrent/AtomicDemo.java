package org.demo.java8.concurrent;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.StampedLock;

public class AtomicDemo {
	
	static AtomicLong nextNumber = new AtomicLong();
	
	/**
	 * java5 提供了很多原子操作，可以增加/减少值
	 */
	public static void demo() {
		//incrementAndGet 线程安全 +1
		long id = nextNumber.incrementAndGet();
		
	}
	
	/**
	 * java5 中 使用 compareAndSet 来保障线程安全的更新
	 */
	public static void demo1() {
		long oldvalue =0;
		long newvalue =0;
		do {
			oldvalue = nextNumber.get();
			newvalue = oldvalue + 1;
		} while (!nextNumber.compareAndSet(oldvalue, newvalue));
	}
	
	/**
	 * java8 的更新 不在需要循环，只需要提供lambda表达式
	 */
	public static void demo2() {
		nextNumber.updateAndGet(x -> x+1);
		
		// 或者
		nextNumber.accumulateAndGet(1, (x,y)-> x+y);
	}
	
	/**
	 * 当有大量线程访问同一个原子值时，由于乐观锁更新需要太多次重试，因此会导致性能严重下降，因此java提供了LongAdder与 LongAccumulator 来解决
	 * 
	 * @see LongAccumulator
	 */
	
	final static LongAdder adder = new LongAdder();
	public static void longAdderDemo() {
		
		for (int i=0; i<10; i++) {
			new Thread(()->{
				adder.increment();
			});
		}
		
		long total = adder.sum();
	}
	
	/**
	 * StampedLock 乐观读
	 * <p> 首先调用 tryOptimisticRead 方法， 会获得一个 “印戳”。 然后读取值并检查“印戳”是否仍然有效（例如，没有其他线程已经获取一个写锁）
	 * <p> 如果有效，就可以使用这个值，如果无效，会获得一个读锁（它将会阻塞所有的写锁）
	 * 
	 * @author zhangsf
	 *
	 */
	public static class Vector {
		private int size;
		private Object[] elements;
		private StampedLock lock = new StampedLock();
		
		public Object get(int n) {
			long stamp = lock.tryOptimisticRead();
			Object[] currentElements = elements;
			int currentSize = size;
			if (!lock.validate(stamp)) { // 某个线程持有一个写锁
				stamp = lock.readLock(); // 获得一个悲观锁
				currentElements = elements;
				currentSize = size;
				lock.unlockRead(stamp);
			}
			return n < currentSize ? currentElements[n] : null;
		}
	}
}
