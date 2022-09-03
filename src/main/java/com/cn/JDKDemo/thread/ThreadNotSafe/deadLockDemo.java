package com.cn.JDKDemo.thread.ThreadNotSafe;

/**
 * 类名: deadLockDemo
 * 描述: 死锁demo  两个线程都持有对方的锁，等待对方释放锁
 * 姓名: @author南风
 * 日期: 2022-01-13 17:38
 **/
public class deadLockDemo implements Runnable{

    private static Integer i = 0;
    private Object lockA = new Object();
    private Object lockB = new Object();
    
    @Override
    public void run(){
        while (true){
            if(i % 2 == 0){
                synchronized (lockA){
                    try {
                        lockA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockB){
                            try {
                                lockB.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("lock B ……" + Thread.currentThread().getName());
                            lockB.notify();
                        }
                        System.out.println("lock A ……" + Thread.currentThread().getName());

                    lockA.notify();
                }
            }else {
                synchronized (lockB){
                    System.out.println("lock B ……" + Thread.currentThread().getName());
                    synchronized (lockA){
                        try {
                            lockB.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("lock A ……" + Thread.currentThread().getName());
                        lockA.notify();
                    }
                    lockB.notify();
                }
            }
            i++;
            System.out.println(i);
        }
    }
}
class test{
    public static void main(String[] args) {
        deadLockDemo demo = new deadLockDemo();
        new Thread( () -> demo.run(),"demo1").start();
        new Thread( () -> demo.run(),"demo2").start();
    }
}