package com.cn.jdkTest.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 类名:threadPoolDemo
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-07-22 18:03
 **/
public class threadPoolDemo {

    public static void main(String[] args) {

        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(new Runnable() {
            public void run() {

            }
        });
        es.shutdown();
    }
}
