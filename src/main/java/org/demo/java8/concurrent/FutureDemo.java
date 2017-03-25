package org.demo.java8.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

	static ExecutorService es = Executors.newCachedThreadPool();

	public static void demo1() throws InterruptedException, ExecutionException {

		Future<Long> f = es.submit(() -> Thread.currentThread().getId());
		f.get();
	}

	/**
	 * java 8 提供 CompletableFuture 对象
	 * 
	 * <p>
	 * 所有以 Async 结尾的方法都有两种形式，
	 * <p>
	 * 一种会在普通的 ForkJoinPool 中运行所提供的操作
	 * <p>
	 * 另一种需要提供一个 java.util.concurrent.Executor 作为参数，并在该指定的executor对象中执行操作
	 *
	 */
	public static void demo2() {
		// 创建 CompletableFuture 对象
		CompletableFuture<String> threadid1 = CompletableFuture
				.supplyAsync(() -> String.valueOf(Thread.currentThread().getId()));

		CompletableFuture<String> threadid2 = CompletableFuture
				.supplyAsync(() -> String.valueOf(Thread.currentThread().getId())).thenApply(x -> "Thread id :" + x);

		CompletableFuture<Void> threadid3 = CompletableFuture
				.supplyAsync(() -> String.valueOf(Thread.currentThread().getId())).thenApply(x -> "Thread id :" + x)
				.thenAccept(System.out::println);
	}
	
	/**
	 * 编写异步操作
	 */
	public static void demo3() {

		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "test");
		/**
		 * 向 cf 对象添加 action
		 */
		//1 参数 | 描述
		// T->U | 为结果提供一个函数
		// cf.thenApply(fn);

		//2 参数 					  | 描述
		// T->ComletableFuture<U> | 对结果调用一个函数，并执行返回的Future对象
		//cf.thenCompose(fn);
		
		//3      参数 					  | 描述
		// (T, Throwable)->U          | 处理结果或者错误
		//cf.handle(fn)
		
		//4      参数 				 | 描述
		//    T -> void          | 与thenApply 类似， 但是结果为 void
		//cf.thenAccept(action);
		
		
		//5      参数 				 		| 描述
		//    (T, Throwable)->void      | 与handle类似，但是结果为 void
		//cf.whenComplete(action)
		
		
		//6      参数 			| 描述
		//    Runnable      | 执行返回void的Runnable对象
		//cf.thenRun(action)

	}
	
	
	public static void demo4() {
		CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "test1");
		CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> "test2");
		
		/**
		 * 这3个方法会并行运行一个  CompletableFuture<T> 与 CompletableFuture<U> 操作，并将结果组合在一起
		 */
		//1                           参数 				                | 描述
		//   CompletableFuture<U>, (T,U)->V    	| 执行两个对象，并将结果按照指定函数组合起来
		//cf1.thenCombine(cf2, fn);
		
		
		//2.与thenCombine类似，但是结果为 void
		//cf1.thenAcceptBoth(cf2, action)
		
		
		//3.在两个对象完成后，执行Runnable对象
		//cf1.runAfterBoth(cf2, action);
		
		/**
		 * 这3个方法会并行运行两个 CompletableFuture 操作，只要其中任何一个结束，就会返回该结果并忽略其他结果
		 */
		//1. 当其中一个对象的结果可用时，将结果传递给指定函数
		//cf1.applyToEither(cf2, fn)
		
		//2. 与 applyToEither 类似，但结果为 void
		//cf1.acceptEither(cf2, action)
		
		//3. 在其中一个对象结束后执行 Runnable 对象
		//cf1.runAfterEither(cf2, action)
		
		/**
		 * 接收一组可结束的的 Future 对象，并返回 CompletableFuture<Void> 结果，当这些Future对象全部结束，或者他们中的任意一个结束时，该结果都会结束。
		 */
		//CompletableFuture.allOf(cfs)
		//CompletableFuture.anyOf(cfs)
	}

}
