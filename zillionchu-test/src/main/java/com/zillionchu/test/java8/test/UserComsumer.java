package com.zillionchu.test.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/4/12 11:21
 * @Description:
 */
public class UserComsumer {


    public static void main(String[] args) {
        userCom(o -> System.out.println(o),"Hello");



        List<Apple> apples = Arrays.asList(new Apple("r", 100), new Apple("a", 150));

       // apples.sort();
    }

    public static <T>  void userCom(Consumer<T> consumer,T t){
        consumer.accept(t);

    }
}
