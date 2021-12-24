package com.cn.threadPoolTest.toolUtils;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 类名:MyRejectHandler
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-10-27 16:11
 **/
public class MyRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task reject " + executor.toString());
    }
}
