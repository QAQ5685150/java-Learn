package com.cn.JdkDemo.Thread.pcModel;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类名:producer
 * 描述:生产者模型
 * 姓名:南风
 * 日期:2021-08-16 15:25
 **/
public class producer implements Runnable {
    private volatile boolean isRunning = true;

    private BlockingQueue<pcData> blockingDeque;

    private static AtomicInteger count = new AtomicInteger();

    private static final int SLEEPTIME = 2000;

    public producer(BlockingQueue<pcData> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        pcData data = null;
        Random r = new Random();
        System.out.println("start producting id:" + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEPTIME));
                data = new pcData(count.incrementAndGet());
                System.out.println(data + " add to list");
                if (!blockingDeque.offer(data, 2, TimeUnit.SECONDS)) {
                    System.err.println(" failed to add list");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isRunning = false;
    }
}
