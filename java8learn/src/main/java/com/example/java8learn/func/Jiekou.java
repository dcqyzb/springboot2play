package com.example.java8learn.func;

/**
 * @author DC
 * @description
 * @date 2020/1/13
 */
@FunctionalInterface
public interface Jiekou {
    /**
     * 接口只有一个抽象方法（函数式接口）
     */
    void show(int a);

    /**
     * 接口默认函数，非抽象方法
     *
     * @param b
     */
    default void show1(String b) {
        System.out.println(b);
    }
}
