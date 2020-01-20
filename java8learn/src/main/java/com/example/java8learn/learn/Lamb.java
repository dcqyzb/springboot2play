package com.example.java8learn.learn;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author DC
 * @description
 * @date 2020/1/13
 */
public class Lamb {

    public void predicateTest(Integer i) {
        //参数为T -> Boolean，用于判断
        Predicate<Integer> func = x -> x > 1;
        System.out.println("是否大于1? " + func.test(i));
    }

    public void consumerAccept(Integer i) {
        //参数 T ->{} ，用于处理某事物
        Consumer<Integer> func = System.out::println;
        func.accept(i);
    }

    public static void functionApply(Integer a, Integer b) {
        //参数 T -> R， 用于对数据进行处理变换，返回R类型
        Function<Point, Double> func = p -> p.distance(0, 0);
        System.out.println("点[3,4]距离原点的距离是?" + func.apply(new Point(a, b)));
    }

    public static void supplier(Integer a, Integer b) {
        //参数 ( ) -> T，生成对象
        Supplier<Point> func = () -> new Point(a, b);
        Point point = func.get();
        System.out.println(point.toString());
    }

    public static void unaryOperator(Integer i) {
        //参数 T -> T，对T进行处理，并且返回同类型
        UnaryOperator<Integer> addSelf = x -> x + 1;
        System.out.println(i + "+1=" + addSelf.apply(i));
    }

    public static void binaryOperator(Integer a, Integer b) {
        //参数(T, T) -> T ，变换返回同类型T
        BinaryOperator<Integer> max = (x, y) -> x > y ? x : y;
        System.out.println("比较" + a + "和" + b + ",大的是：" + max.apply(a, b));
    }

    private static void girl(Consumer<String> one, Consumer<String> two, String[] arr) {
        for (String s : arr) {
            one.andThen(two).accept(s);
        }
    }



    public static void main(String[] args) {

        Map<Character, List<String>> collect = Stream.of("Alex", "Dob", "David", "Amy")
                .collect(Collectors.groupingBy(v -> v.charAt(0)));
        System.out.println(collect);
    }
}
