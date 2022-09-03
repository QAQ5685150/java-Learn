package com.cn.JDKDemo.thread.ThreadPool;

import java.util.concurrent.Executor;

/**
 * 类名:ThreadPoolDemo01
 * 描述:线程池使用方式
 * 姓名:南风
 * 日期:2021-10-26 9:35
 **/
public class ThreadPoolDemo01 {

    public static void main(String[] args) {
        Executor threadPool = ThreadPoolUtils.getThreadPool();
        for (int i = 0; i < 100; i++) {
            threadPool.execute(new Task());
        }
    }
}

class Task implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
