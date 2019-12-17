package com.zillionchu.test.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/4 20:11
 * @Description:
 */
public class Test01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        classPathXmlApplicationContext.getBean("");
    }
}
