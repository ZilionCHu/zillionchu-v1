package com.zillionchu.test.java8.test;

import com.google.common.base.Function;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/4/11 14:53
 * @Description:
 */
public class Test01 {

    public static void main(String[] args) {
        //Predicate

        Function<String, Integer> ftFunction =(String s) -> s.length();

        System.out.println(ftFunction.apply("aaaa"));
    }
}
