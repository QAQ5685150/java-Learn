package com.cn.JdkDemo.Thread.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 类名:ThreadPoolUtils
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-10-26 9:31
 **/
public class ThreadPoolUtils {

    public static Executor getThreadPool(){
        return new ThreadPoolExecutor(4,9,60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
    }
}
