package com.cn.JDKDemo.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.AQS
 * @Time: 2022-08-22 11:11
 * @Description: TODO
 **/
public class testLock {

    private static int mark = 0;
    static MyLock lock = new MyLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();

    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition condition11 = reentrantLock.newCondition();
    static Condition condition22 = reentrantLock.newCondition();
    /**
     * AQS提供了Condition组件完成多线程之间通讯，
     * condition类似于object类里的等待、唤醒方法
     * condition.await() = object.wait()
     * condition.sign() = object.notify()
     * condition.signAll() = object.notifyAll()
     * condition可以支持多个等待队列 object只支持一个
     * 使用wait()方法或者await()后，线程从running状态转入ready就绪态，加入等待队列等待唤醒
     * @param args
     */
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            while (mark < 10){
                reentrantLock.lock();
                if(mark % 2 == 0){
                    try {
                        condition11.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mark++;
                System.out.println(Thread.currentThread().getName() + " lock share file a" + mark);
                condition22.signalAll();
                reentrantLock.unlock();
            }

        },"linxx - 1");

        Thread b = new Thread(() -> {
            while (mark < 10){
                reentrantLock.lock();
                if(mark % 2 != 0){
                    try {
                        condition22.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mark++;
                System.out.println(Thread.currentThread().getName() + " lock share file b" + mark);
                condition11.signalAll();
                reentrantLock.unlock();
            }
        },"linxx - 2");
        a.start();
        b.start();
    }
}
