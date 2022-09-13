package com.cn.JdkDemo.Thread.Utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类名:MyThreadFactory
 * 描述:自定义线程池工厂
 * 姓名:南风
 * 日期:2021-10-27 14:32
 **/
public class MyThreadFactory implements ThreadFactory {
    private final String userName;
    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    public MyThreadFactory(String userName) {
        //定义线程名称方便排查日志
        this.userName = "MyThreadFactory's " + userName + " Worker";
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = userName + atomicInteger.getAndIncrement();
        Thread thread = new Thread(null,r,name,0);
        // System.out.println(thread.getName());
        return thread;
    }
}
