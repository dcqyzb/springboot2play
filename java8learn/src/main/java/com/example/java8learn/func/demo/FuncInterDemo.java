package com.example.java8learn.func.demo;

import com.example.java8learn.func.Jiekou;

/**
 * @author DC
 * @description
 * @date 2020/1/13
 */
public class FuncInterDemo {
    public static void method(int a, Jiekou jk) {
        jk.show(a);
        jk.show1("sss");
    }

    public static void main(String[] args) {
        method(100, System.out::println);
    }
}
