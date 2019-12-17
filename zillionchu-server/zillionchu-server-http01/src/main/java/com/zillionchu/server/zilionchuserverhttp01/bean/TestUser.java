package com.zillionchu.server.zilionchuserverhttp01.bean;

import java.math.BigDecimal;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/11/6 14:03
 * @Description:
 */
public class TestUser {

    public static void main(String[] args) {
//        User.UserBuilder tom = User.builder().age("18").name("Tom");
//        System.out.println(tom);
//        System.out.println(tom.build().getAge());

        BigDecimal b= new BigDecimal(1);
        System.out.println(b.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        //System.out.println(bigDecimal.toString());

    }
}
