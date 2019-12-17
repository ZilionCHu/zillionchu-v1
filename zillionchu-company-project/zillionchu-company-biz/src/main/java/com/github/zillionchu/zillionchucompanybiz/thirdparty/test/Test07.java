package com.github.zillionchu.zillionchucompanybiz.thirdparty.test;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类名称 Test07
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/10 17:30
 * @版本 1.00
 */
public class Test07 {
    public static void main(String[] args) {
        List<Map<String, Object>> carsInfo = new ArrayList();
        HashMap<String, Object> hashMap = Maps.newHashMap();
        hashMap.put("Tom", "111");
        hashMap.put("Tom111", "111");
        hashMap.put("Tom222", "111");



        carsInfo.add(hashMap);

        System.out.println(carsInfo);


//        carsInfo.stream().flatMap(map -> {
//            return map.forEach((s, o) -> {
//
//            });
//        });




        List<Map<String, Object>> carsInfoNew = new ArrayList();
        for (Map<String, Object> map : carsInfo) {
            HashMap<String, Object> var2 = Maps.newHashMap();
            map.forEach((s, o) -> {
                var2.put(s.toUpperCase(), o);
            });
            carsInfoNew.add(var2);
        }

        System.out.println(carsInfoNew);


    }
}
