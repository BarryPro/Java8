package org.demo.java8.reference;

import java.util.function.Supplier;

/**
 * Created by belong on 2017/3/29.
 */
public class SupplierTest {
    public static void main(String[] args) {
        //lambda表达式允许只允许一个借口只有一个方法这样才能够匿名重写
        Supplier<String> supplier = () -> {return "belong";};
        System.out.println(supplier.get());
        Supplier<Integer> supplier2 = () -> {
            return 20;
        };
        System.out.println(supplier2.get() instanceof Integer);
        Number number = new Integer(5);
        System.out.println(number);
    }
}
