package com.cn.JdkDemo.Thread.review.doublePrint;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-02-27 16:17
 * @Description: 多线程交替打印 test02
 * @Project_name: java-learn
 */
public class test01 {

     public static Object lock = new Object();

     static int i = 0;

    public static synchronized void number(){
        while (true){
            synchronized (lock){
                while (i != 0) {
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                i++;
                System.out.println(Thread.currentThread().getName());
                lock.notifyAll();

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
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                i--;
                System.out.println(Thread.currentThread().getName());
                lock.notifyAll();

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
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(
                () -> {
                    int j = 0;
                    while (true){
                        synchronized (lock){
                            while (i != 0) {
                                //lock.notifyAll();
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                            i++;
                            System.out.println(Thread.currentThread().getName() + " " + j++);
                            lock.notifyAll();

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        );
        executorService.submit(
                () -> {
                    char c = 'a';
                    while (true){
                        synchronized (lock){
                            while (i == 0) {
                                //lock.notifyAll();
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                            i--;
                            System.out.println(Thread.currentThread().getName() + " " + c++);
                            lock.notifyAll();

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        );
//        new Thread(()->{t.number();},"b").start();
//        new Thread(()->{t.number2();},"a").start();


    }
}
