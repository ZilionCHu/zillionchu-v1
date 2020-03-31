package com.zillionchu.test.reflect;

/**
 * @Auther: ZiLlionChu
 * @Date: 2020/3/15 12:15
 * @Description:
 */
public class User {

    private final static String TGA = "java";

    public User(String age, String name) {
        this.age = age;
        this.name = name;
    }

    private User(String age) {
        this.age = age;
    }

    public User() {
    }

    public void test(String txt) {
        System.out.println("public" + txt);

    }

    private void test01(String txt) {
        System.out.println("private" + txt);

    }

    private String age;

    private String name;


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
