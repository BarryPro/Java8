package org.demo.java8.nashorn;

import java.util.Arrays;
import java.util.List;

/**
 * Created by belong on 2017/4/5.
 */
public class Java8Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 1, 2);
        list.forEach(el -> System.out.println(el));
        list.forEach(System.out::print);
    }
}
