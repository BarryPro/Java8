package org.demo.java8.reference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by belong on 2017/3/29.
 */
public class Car {
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }


    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public void fun(){
        System.out.println("belong");
    }

    public static void main(String[] args) {
        //方法引用
        final Car car = Car.create( Car::new );
        collide(car);
        final List< Car > cars = Arrays.asList( car );
        cars.forEach( Car::collide );
        cars.forEach( Car::repair );
        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );
        Car car1 = Car.create(Car::new);
        car1.fun();
        cars.forEach(Car::fun);
    }
}
