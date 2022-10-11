package com.cn.JdkDemo.Thread.ThreadPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

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
