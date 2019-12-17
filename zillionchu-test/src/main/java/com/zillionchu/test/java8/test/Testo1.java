package com.zillionchu.test.java8.test;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019-06-14 16:17
 * @Description:
 */
public class Testo1 {

    private static int confBeatTime = 30;

    public static void main(String[] args) {
        long sleepSecond = confBeatTime - (System.currentTimeMillis() / 1000) % confBeatTime;
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() / 1000);
        System.out.println((System.currentTimeMillis() / 1000) % confBeatTime);
        System.out.println(sleepSecond);

    }
}
