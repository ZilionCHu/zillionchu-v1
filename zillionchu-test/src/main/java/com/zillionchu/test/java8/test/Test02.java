package com.zillionchu.test.java8.test;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019-07-03 16:39
 * @Description:
 */
public class Test02 {

    public static void main(String[] args) {


        // System.out.println(0%2);

        //List<String> strings = Arrays.asList("0", "1", "0", "1", "1", "0", "1");
        List<String> strings = Lists.newArrayList("0", "1", "0", "1", "0", "1", "1");


        String v;
        for (int i = 0; i < strings.size(); i++) {
            v = strings.get(i);
            if (i != strings.size() - 1) {
                if (v.equals(strings.get(i + 1))) {
                    strings.remove(i + 1);
                }
            }
        }
        System.out.println(strings.toString());
    }

//        ArrayList<String> strings = Lists.newArrayList("tom", "jackjack", "kingg");
//        int call = call(strings, s -> s.length() > 5);
//        long count = strings.stream().filter(s -> s.length() >= 3).count();
//          long count = strings.stream().map()
//        System.out.println("count===================" + count);
//        System.out.println("call===================" + call);
//    }
//
//    public static int call(List<String> list, Predicate<String> predicate) {
//        int i = 0;
//        for (String s : list) {
//            if (predicate.test(s)) {
//                i++;
//            }
//
//        }
//        return i;
//    }
}

