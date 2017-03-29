package org.demo.java8.lambda;

/**
 * Created by belong on 2017/3/28.
 */
public class Java8Tester2 {
    final static String salutation = "Hello! ";

    public static void main(String args[]) {
        String name = "ycl";
        GreetingService greetService1 = message ->
                System.out.println(salutation + name + message);
        greetService1.sayMessage("belong");
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
