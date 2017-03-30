package org.demo.java8.reference;

/**
 * Created by belong on 2017/3/29.
 */

import java.util.List;
import java.util.ArrayList;

public class Java8Tester {
    public static void main(String args[]) {
        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        //方法引用
        names.forEach(System.out::println);
    }
}
