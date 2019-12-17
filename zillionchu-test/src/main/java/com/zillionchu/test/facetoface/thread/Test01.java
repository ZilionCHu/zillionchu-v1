package com.zillionchu.test.facetoface.thread;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/11/29 16:07
 * @Description:
 */
public class Test01 extends Thread{
    @Override
    public void run() {
        System.out.println(String.format("id  -- %s",this.getId()));
        System.out.println(String.format("name  --  %s",this.getName()));

    }

    public static void main(String[] args) {

        System.out.println(String.format("seq  -- %s",String.format("%1$05d", 1)));

        Test01 test01=new Test01();
        test01.setName("Test01  thread ");
        test01.start();
    }
}
