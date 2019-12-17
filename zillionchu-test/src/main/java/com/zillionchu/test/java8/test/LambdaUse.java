package com.zillionchu.test.java8.test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/4/12 10:22
 * @Description:
 */
public class LambdaUse {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("r", 100), new Apple("a", 150));

        System.out.println(filter(apples, apple -> apple.getColor().equals("a")));
        System.out.println(Bifilter(apples, (apple, s) -> apple.getColor().equals("r") && s > 99));


        System.out.println("out --:"+testFuntion(new Apple("b", 100),apple -> {
          return  "11111"+apple.toString();
        }));
    }

    private static List<Apple> filter(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> resutl = new ArrayList<>();
        for (Apple a : apples
        ) {
//            if (predicate.test(a)) {
//                resutl.add(a);
//            }
        }

        return resutl;
    }

    private static List<Apple> Bifilter(List<Apple> apples, BiPredicate<Apple, Long> predicate) {
        List<Apple> resutl = new ArrayList<>();
        for (Apple a : apples
        ) {
            if (predicate.test(a, a.getWeight())) {
                resutl.add(a);
            }
        }

        return resutl;
    }


    private static String testFuntion(Apple apple, Function<Apple, String> function) {

        return function.apply(apple);
    }


}
