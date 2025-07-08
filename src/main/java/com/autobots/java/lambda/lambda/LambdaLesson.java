package com.autobots.java.lambda.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLesson {
    public static void main(String[] args) {

        MathOperations addition = (a, b) -> a + b;
        MathOperations multiple = (a,b) -> a * b;

        System.out.println("5 + 3 = " + addition.operation(5, 3));
        System.out.println("5 * 3 = " + multiple.operation(5, 3));

        Predicate<String> isNotEmpty = s -> !s.isEmpty(); // это вид функционального интерфейса
        // он принимает объект и возвращает тру или фолс
        System.out.println(isNotEmpty.test(""));
        System.out.println(isNotEmpty.test("java"));

        Function<Integer, String> toStringFun = i -> "число: " + i;
        //превращает один тип данных в другой
        System.out.println(toStringFun.apply(10));

        Consumer<String> print = s -> System.out.println("writting: " + s);
        print.accept("hello");
    }

}
