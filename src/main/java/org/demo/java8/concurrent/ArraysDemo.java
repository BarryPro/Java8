package org.demo.java8.concurrent;

import java.util.Arrays;

public class ArraysDemo {
	
	public static void demo1() {
		String[] words = {"a", "bb", "ccc"};
		Arrays.parallelSort(words);
		
		//会将数组中的值按照一个函数的计算结果过滤出来
		int[] nums = {1001,1002,1003,1004};
		// nums 的值将被设置为  1，2，3，4
		Arrays.parallelSetAll(nums, i -> i%10);
		
		
		int[] nums2 = {1,2,3,4};
		//[1, 1*2, 1*2*3, 1*2*3*4]
		Arrays.parallelPrefix(nums2, (x,y)-> x*y);
	}

}
