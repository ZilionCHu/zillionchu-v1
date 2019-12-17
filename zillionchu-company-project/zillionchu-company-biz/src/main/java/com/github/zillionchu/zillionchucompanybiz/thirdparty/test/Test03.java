package com.github.zillionchu.zillionchucompanybiz.thirdparty.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类名称 Test03
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/29 20:57
 * @版本 1.00
 */
public class Test03 {
    public static void main(String[] args) {
        // System.out.println("nameAge".toUpperCase());
        HashMap<String, Object> a = Maps.newHashMap();
        a.put("Tom", "1");
        a.put("Tom1", "11");
        HashMap<String, Object> b = Maps.newHashMap();
        b.put("jack", "2");
        HashMap<String, Object> c = Maps.newHashMap();
        c.put("kang", "3");
//        List<Map<String, Object>> list = Lists.newArrayList();
//        list.add(a);
        List<HashMap<String, Object>> hashMaps = Arrays.asList(a, b, c);
        //hashMaps.stream().flatMap(stringObjectHashMap -> ).forEach();
       /* List<Map<String, Object>> newList = Lists.newArrayList();

        hashMaps.forEach(stringObjectHashMap -> stringObjectHashMap.forEach((s, o) -> {
            HashMap<String, Object> map = Maps.newHashMap();
            map.put(s.toUpperCase(), o);
            //System.out.println(s);
            newList.add(map);

        }));*/

        List<Map<String, Object>> newList = Lists.newArrayList();
        hashMaps.forEach(s -> {
            s.forEach((k, v) -> {
                HashMap<String, Object> map = Maps.newHashMap();
                map.put(k.toUpperCase(), v);
                newList.add(map);
            });
        });

        System.out.println(newList);

        //System.out.println();

    }
}
