package com.zillionchu.test.java8.test;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019-07-03 16:39
 * @Description:
 */
public class Test03 {

    private static final String dataRegexStrWOrk = "\\d{4}\\年\\d{1,2}\\月";

    public static void main(String[] args) {

        System.out.println(dataRegexStrWOrk.matches("xxxx年xx月"));

    }
}

