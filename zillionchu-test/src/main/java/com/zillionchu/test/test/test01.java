package com.zillionchu.test.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/11/16 15:26
 * @Description:
 */
public class test01 {

    public static void main(String[] args) {
//        Set<String> set1 = new HashSet<>();
//        Set<String> set2 = new HashSet<>();
//
//        set1.add("a");
//        set1.add("b");
//        set1.add("c");
//        set1.add("d");
//
//        set2.add("c");
//        set2.add("e");
//        set2.add("d");
//        set2.add("g");
//
//        set1.retainAll(set2);
//
//
//        System.out.println(set1);


        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list1.add("6");
        list1.add("7");
        list1.add("8");

        List<String> list2 = new ArrayList<String>();
        list2.add("2");
        list2.add("7");
        list2.add("10");

        //交集
        List<String> collect1 = list1.stream().filter(num -> list2.contains(num))
                .collect(Collectors.toList());
        System.out.println("交集");
        collect1.stream().forEach(System.out::println);

        //差集 list1-list2
        List<String> collect2 = list1.stream().filter(num -> !list2.contains(num))
                .collect(Collectors.toList());
        System.out.println("差集list1-list2");
        collect2.stream().forEach(System.out::println);

        //差集list2-list1
        List<String> collect3 = list2.stream().filter(num -> !list1.contains(num))
                .collect(Collectors.toList());
        System.out.println("差集list2-list1");
        collect3.stream().forEach(System.out::println);

        //并集  不去重
        list1.addAll(list2);
        System.out.println("并集  不去重");
        list1.stream().forEach(System.out::println);

        //并集  去重
        List<String> collect4 = list1.stream().distinct().collect(Collectors.toList());
        System.out.println("并集  去重");
        collect4.stream().forEach(System.out::println);


    }
}
