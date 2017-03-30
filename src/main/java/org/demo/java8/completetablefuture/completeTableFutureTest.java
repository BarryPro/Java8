package org.demo.java8.completetablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * Created by belong on 2017/3/30.
 */
public class completeTableFutureTest {
    CompletableFuture<String> completableFuture;
    public static void main(String[] args) {
        Supplier<String> supplier = ()->"belong";
        System.out.println(supplier.get());
        System.out.println("belong.belong@outlook.com");
        System.out.println("1278423697@qq.com");
        System.out.println("baby");
        System.out.println("ji");
        List<String> list = Arrays.asList("belong");
        list.forEach(System.out::println);
    }
}
