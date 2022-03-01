package com.cn.jdkTest.thread.review;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-03-01 16:37
 * @Description: ����Ĭ���̳߳� demo
 * @Project_name: java-learn
 */
public class test05 {

    public static void main(String[] args) {
        ExecutorService cached = Executors.newCachedThreadPool();
        cached.execute(
            () -> {
            // ... do something inside runnable task

        });
        cached.shutdown();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(12);
        fixedThreadPool.submit(
                () ->{

                }
        );
        fixedThreadPool.shutdown();

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
        scheduledThreadPool.submit(
                () -> {

                }
        );
        scheduledThreadPool.shutdown();

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.submit(
                () -> {

                }
        );
        singleThreadExecutor.shutdown();
    }
}
