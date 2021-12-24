package com.cn.threadPoolTest.lock;

import java.util.concurrent.BlockingQueue;

/**
 * 类名:Producer
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-10-19 10:25
 **/
public class Producer01 implements Runnable{

    private BlockingQueue<Integer> blockingQueue = null;

    public Producer01(BlockingQueue<Integer> queue) {
        this.blockingQueue = queue;
    }
    //private ThreadLocal<Deque<Integer>> ThreadLocal = new ThreadLocal<>();
    //ThreadLocal是在不同线程中的同步变量，每次get拿到一个副本，实现线程隔离，不一定会线程安全
    @Override
    public void run() {
        while (true){
            try {
                this.blockingQueue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Producing…… now this queue have length " + blockingQueue.size());
            System.out.println("current Thread is " + Thread.currentThread().getName());
            System.out.println();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
