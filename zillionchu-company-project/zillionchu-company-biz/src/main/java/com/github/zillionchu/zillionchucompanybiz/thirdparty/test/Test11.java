package com.github.zillionchu.zillionchucompanybiz.thirdparty.test;

import com.google.common.escape.Escaper;
import com.google.common.net.UrlEscapers;

/**
 * @类名称 Test11
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/28 15:35
 * @版本 1.00
 */
public class Test11 {

    private static final Escaper pathEscaper = UrlEscapers.urlPathSegmentEscaper();

    public static void main(String[] args) {
       // System.out.println(String.format("%s/%s", "aa", "bb"));

        System.out.println(pathEscaper.escape("http://20.200.34.92:8761/"));
    }
}
