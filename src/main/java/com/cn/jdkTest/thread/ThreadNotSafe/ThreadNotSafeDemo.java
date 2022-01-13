package com.cn.jdkTest.thread.ThreadNotSafe;

/**
 * 类名:ThreadNotSafe
 * 描述:多线程安全问题之卖票问题
 * 姓名:南风
 * 日期:2021-10-21 14:34
 **/

public class ThreadNotSafeDemo implements Runnable {

    private static volatile Integer ans = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        getNext();
    }

    /**
     * 功能描述:多线程下不安全
     * @return void
     **/
    public void getNext() {
        //保持程序一直运行，也可以在开线程的地方for循环或者while 但是一定要有循环，不然程序只执行一次
        //       while (ans > 0){
        //同步代码块，加锁
        synchronized (obj) {
            //双重检查的应用，如果这里不判断，会出现票数为负的情况
            //因为synchronized虽然锁住了线程，进入到锁的线程等待后如果没有第二重检查，就会让第一重检查的判断失效
            if (ans > 0) {
                try {
                    //尝试等待，让每个线程都有机会抢票
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " ==>" + ans--);
            }
        }
    }
    //   }

    public static void main(String[] args) {
        ThreadNotSafeDemo threadNotSafeDemo = new ThreadNotSafeDemo();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> threadNotSafeDemo.run(), "thread-1").start();
            new Thread(() -> threadNotSafeDemo.run(), "thread-2").start();
            new Thread(() -> threadNotSafeDemo.run(), "thread-3").start();
        }

    }
}

