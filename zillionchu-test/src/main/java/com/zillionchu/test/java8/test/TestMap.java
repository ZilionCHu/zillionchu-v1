package com.zillionchu.test.java8.test;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/10/6 10:39
 * @Description:
 */
public class TestMap {

    public static void main(String[] args) {
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("tom","1");
        map.put("java","2");
        map.put("jack","3");
        map.put("kangkang","4");
        map.forEach((s, o) -> {
          s.toUpperCase();
        });

        //Stream.of(map).map(stringObjectHashMap -> ).collect(Collectors.toCollection());
    }
}
