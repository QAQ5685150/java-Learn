package com.cn.jdkTest.thread.review;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-02-27 16:17
 * @Description: 多线程交替打印 test02
 * @Project_name: java-learn
 */
public class test01 {

     static Object lock = new Object();

     static int i = 0;

    public static synchronized void number(){
        while (true){
            synchronized (lock){
                while (i != 0) {
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                i++;
                System.out.println(Thread.currentThread().getName());
                lock.notify();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static synchronized void number2(){
        while (true){
            synchronized (lock){
                while (i == 0) {
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                i--;
                System.out.println(Thread.currentThread().getName());
                lock.notify();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        test01 t = new test01();
        new Thread(()->{t.number();},"b").start();
        new Thread(()->{t.number2();},"a").start();


    }
}
