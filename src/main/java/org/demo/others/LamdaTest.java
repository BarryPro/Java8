package org.demo.others;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class LamdaTest {
	@Test
	public void demo1(){
		String [] strings = {"aa","aaa","a","aaaa"};
		Comparator<String> comparable = (first,second)->Integer.compare(first.length(), second.length());
		Arrays.sort(strings, comparable);
		for(String s:strings){
			System.out.println(s);
		}
	}

}
