package com.zillionchu.test.reflect;

import java.lang.reflect.Constructor;

/**
 * @Auther: ZiLlionChu
 * @Date: 2020/3/15 12:15
 * @Description:
 */
public class ReflectDemo {

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.zillionchu.test.reflect.User");
            get(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void get(Class clazz) throws Exception{

        Object newInstance = clazz.newInstance();
        User user = (User) newInstance;
        user.setAge("18");
        System.out.println(user.getAge());

        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Object newInstance1 = declaredConstructor.newInstance("19");
        User user01= (User)newInstance1;
        System.out.println(user01.getAge());


    }

}
