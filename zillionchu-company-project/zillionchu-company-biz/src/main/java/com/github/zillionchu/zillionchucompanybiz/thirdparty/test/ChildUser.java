package com.github.zillionchu.zillionchucompanybiz.thirdparty.test;

/**
 * @类名称 ChildUser
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/28 14:59
 * @版本 1.00
 */
public class ChildUser {

    private final String name;

    private final String age;

//    public ChildUser(ChildUserBuilder c) {
//        this.name = c.name;
//        this.age = c.age;
//    }


    public ChildUser(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ChildUser{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static ChildUserBuilder newBuilder() {
        return new ChildUserBuilder();
    }

    public static class ChildUserBuilder {
        private String name;
        private String age;


        public ChildUserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ChildUserBuilder age(String age) {
            this.age = age;
            return this;
        }


        public ChildUser build() {
            return new ChildUser(name, age);
        }
    }


    public static void main(String[] args) {

        // System.out.println(new ChildUserBuilder().age("10").name("Tom").build());


        System.out.println(ChildUser.newBuilder().name("10").age("Jack").build());


    }
}
