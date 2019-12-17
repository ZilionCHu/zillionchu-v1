package com.github.zillionchu.zillionchucompanycore.thirdparty.util;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @类名称 AnnotationValidUtil
 * @类描述 参数验证
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/17 19:53
 * @版本 1.00
 */
public class AnnotationValidUtil {

    public static String volidateDto(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {

        });


        return null;
    }


}
