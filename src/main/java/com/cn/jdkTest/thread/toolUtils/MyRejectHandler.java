package com.cn.jdkTest.thread.toolUtils;

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


///**
// * A handler for rejected tasks that discards the oldest unhandled
// * request and then retries {@code execute}, unless the executor
// * is shut down, in which case the task is discarded.
// */
//public static class DiscardOldestPolicy implements RejectedExecutionHandler {
//    /**
//     * Creates a {@code DiscardOldestPolicy} for the given executor.
//     */
//    public DiscardOldestPolicy() { }
//
//    /**
//     * Obtains and ignores the next task that the executor
//     * would otherwise execute, if one is immediately available,
//     * and then retries execution of task r, unless the executor
//     * is shut down, in which case task r is instead discarded.
//     *
//     * @param r the runnable task requested to be executed
//     * @param e the executor attempting to execute this task
//     */
//    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
//        if (!e.isShutdown()) {
//            e.getQueue().poll();
//            e.execute(r);
//        }
//    }
//}
