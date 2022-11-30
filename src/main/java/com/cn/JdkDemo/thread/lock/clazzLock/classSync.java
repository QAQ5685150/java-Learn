package com.cn.JdkDemo.thread.lock.clazzLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.thread.lock.clazzLock
 * @Time: 2022-11-30 11:06
 * @Description: TODO
 **/
public class classSync {

    //不加锁的volatile变量出现线程安全问题
    //pool-1-thread-13 ??????????: 99210
    public static volatile Integer global = 1;

    public static void main(String[] args) throws InterruptedException {
        //类锁2种方式:
        synchronized (classSync.class){

        }

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 100000; i++) {
            classSync c1 = new classSync();
            Thread t1 = new Thread(() -> {
                try {
                    c1.classLock();
                    //c1.methodLock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            executorService.submit(t1);
        }
        executorService.shutdown();
    }

    /**
     * 不加synchronized 出现线程同步问题
     * pool-1-thread-1 ??????????: 100000
     * @throws InterruptedException
     */
    public synchronized static void classLock() throws InterruptedException {
        int i = 0;
        //System.out.println(Thread.currentThread().getName() + " 操作局部变量: " + i++);
        System.out.println(Thread.currentThread().getName() + " 操作全局变量: " + global++);
    }

    /**
     * 对象锁 加在非static方法上 不同对象调用不会阻塞
     * pool-1-thread-3 ??????????: 99881
     */
    public synchronized void methodLock(){
        int i = 0;
        //System.out.println(Thread.currentThread().getName() + " 操作局部变量: " + i++);
        System.out.println(Thread.currentThread().getName() + " 操作全局变量: " + global++);
    }
}
