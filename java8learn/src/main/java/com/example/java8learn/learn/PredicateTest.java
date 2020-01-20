package com.example.java8learn.learn;

import java.util.function.Predicate;

/**
 * @author DC
 * @description
 * @date 2020/1/13
 */
public class PredicateTest {
    /**
     * 判断逻辑
     *
     * @param p
     */
    private static void pre(Predicate<String> p) {
        boolean b = p.test("Hello Java");
        System.out.println("字符串很长吗？ --- " + b);
    }

    /**
     * 与
     *
     * @param one
     * @param two
     */
    private static void preAnd(Predicate<String> one, Predicate<String> two) {
        boolean b = one.and(two).test("Hello Java");
        System.out.println("字符串是否包含“H”和“J”？ --- " + b);
    }

    /**
     * 或
     *
     * @param one
     * @param two
     */
    private static void preOr(Predicate<String> one, Predicate<String> two) {
        boolean b = one.or(two).test("Hello Java");
        System.out.println("字符串是否包含“H”或“W”？ --- " + b);
    }

    /**
     * 非
     *
     * @param p
     */
    private static void preNegate(Predicate<String> p) {
        boolean b = p.negate().test("Hello Java");
        System.out.println("字符串长吗？ --- " + b);
    }

    public static void main(String[] args) {
        //判断
        pre(s -> s.length() > 10);
        //and
        preAnd(s -> s.contains("H"), s -> s.contains("W"));
        //or
        preOr(s -> s.contains("H"), s -> s.contains("W"));
        //非
        preNegate(s -> s.length() < 5);
    }
}
