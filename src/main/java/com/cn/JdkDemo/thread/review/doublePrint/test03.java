package com.cn.JdkDemo.thread.review.doublePrint;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-02-27 16:29
 * @Description: �߳̽����ӡ test03
 * @Project_name: java-learn
 */
public class test03 {

//    public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
//    static Lock redLock = lock.readLock();
//    static Lock writeLock = lock.writeLock();
    static int i = 1;

    static Lock lock = new ReentrantLock(true);


    public static void main(String[] args) {
            new Thread( () -> {
                while (true){
                    if(i == 1){
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                        i--;
                        lock.unlock();
                    }

                }
            },"a").start();

            new Thread( () -> {
                while (true){
                    if(i != 1){
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                        i++;
                        lock.unlock();
                    }
                }

            },"b").start();
    }
}