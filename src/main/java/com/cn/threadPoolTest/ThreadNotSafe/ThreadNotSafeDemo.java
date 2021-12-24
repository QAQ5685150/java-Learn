package com.cn.threadPoolTest.ThreadNotSafe;

/**
 * 类名:ThreadNotSafe
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-10-21 14:34
 **/

public class ThreadNotSafeDemo implements Runnable{

    private static Integer ans = 0;

    @Override
    public void run() {
        getNext();
    }

    /**
    *功能描述:多线程下不安全
    *@return void
    **/
    public void getNext(){
        for (int i = 0; i < 20000; i++) {
            synchronized (this){
                System.out.println(Thread.currentThread().getName());
                System.out.println(ans++);
            }
        }
    }

    public static void main(String[] args) {
        ThreadNotSafeDemo threadNotSafeDemo = new ThreadNotSafeDemo();

        new Thread(() -> threadNotSafeDemo.run(),"thread-1").start();

        new Thread(() -> threadNotSafeDemo.run(),"thread-2").start();

        new Thread(() -> threadNotSafeDemo.run(),"thread-3").start();

        new Thread(() -> threadNotSafeDemo.run(),"thread-4").start();

//        for (int i = 0; i < 50; i++) {
//            System.out.println(Thread.currentThread().getName());
//
//        }
//        for (int i = 0; i < 50; i++) {
//            System.out.println(Thread.currentThread().getName());
//
//        }

    }

}

