package com.cn.jdkTest.thread.lock;

import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;

/**
 * 类名:consumer
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-10-19 10:25
 **/
public class Consumer01 implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    public Consumer01(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @SneakyThrows
    @Override
    public void run() {
        //消费忘加循环了 整差了……
        while (true) {
            try {
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consuming…… now this queue have length " + blockingQueue.size());
            System.out.println("current Thread is " + Thread.currentThread().getName());
            System.out.println();
            try {
                Thread.sleep( 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
