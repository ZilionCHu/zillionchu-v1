package com.zillionchu.test.thread;

/**
 * @Auther: ZiLlionChu
 * @Date: 2020/1/9 12:55
 * @Description:
 */
public class Thread01 {

    private static final Object lock = new Object();


    public static void main(String[] args) {


        Thread the = new Thread("线程E") {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + i);
                        if (i == 5) {
                            lock.notify();
                        }
                    }
                }
            }
        };


        Thread thf = new Thread("线程F") {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "启动了");
                    }
                }
            }
        };
        thf.start();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        the.start();


    }

}
