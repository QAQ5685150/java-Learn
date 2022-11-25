package com.cn.JdkDemo.thread.review.doublePrint;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-02-27 16:50
 * @Description: TODO
 * @Project_name: java-learn
 */
public class readwriteLockDemo {

    static volatile char print = 'a';
    static ReentrantReadWriteLock readWriteLock =new ReentrantReadWriteLock();
    static Lock redLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(() -> {
            while (print <= 'z') {
                if((print - 'a') % 2 == 0 ) {
                    redLock.lock();
                    System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                    redLock.unlock();
                }
            }
        });
        service.submit(() -> {
            while (print <= 'z') {
                if((print - 'a') % 2 == 1 ) {
                    writeLock.lock();
                    System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                    writeLock.unlock();
                }
            }
        });
        service.shutdown();
    }

}
