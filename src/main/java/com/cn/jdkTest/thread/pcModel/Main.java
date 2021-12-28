package com.cn.jdkTest.thread.pcModel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 类名:Main
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-16 15:26
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<pcData> queue = new LinkedBlockingDeque<>(10);
        producer p1 = new producer(queue);
        producer p2 = new producer(queue);
        producer p3 = new producer(queue);
        customer c1 = new customer(queue);
        customer c2 = new customer(queue);
        customer c3 = new customer(queue);
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(p1);
        service.execute(p2);
        service.execute(p3);
        service.execute(c1);
        service.execute(c2);
        service.execute(c3);
        Thread.sleep(10*1000);
        p1.stop();
        System.out.println("p1 stop");
        p2.stop();
        System.out.println("p2 stop");
        p3.stop();
        System.out.println("p3 stop");
        Thread.sleep(3000);
        service.shutdown();
    }
}
