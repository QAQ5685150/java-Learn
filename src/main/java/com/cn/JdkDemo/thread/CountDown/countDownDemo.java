package com.cn.JdkDemo.thread.CountDown;

import com.cn.JdkDemo.thread.Utils.MyRejectHandler;
import com.cn.JdkDemo.thread.Utils.MyThreadFactory;

import java.util.Collections;
import java.util.concurrent.*;

/**
 * 类名:countDownDemo
 * 描述:模拟 CountDownLatch 并发
 * 姓名:南风
 * 日期:2021-10-27 13:54
 **/
public class countDownDemo {

    public static void main(String[] args) {
        MyThreadFactory factory1 = new MyThreadFactory("MyFactory1");
        //MyThreadFactory factory2 = new MyThreadFactory("MyFactory2");
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Collections.addAll(queue, "task1", "task2", "task3", "task4", "task5");//模拟生产数据
        CountDownLatch countDownLatch = new CountDownLatch(queue.size());
        ExecutorService executorService1 = new ThreadPoolExecutor(
                5,9,60L, TimeUnit.SECONDS,new SynchronousQueue<>()
                        ,factory1,new MyRejectHandler());

        for (int i = 0; i < queue.size(); i++) {
            executorService1.execute(new task(queue,countDownLatch));
        }

        try {
            System.out.println("waiting……");
            countDownLatch.await();
            System.out.println("mission complete!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService1.shutdown();
    }
}

class task implements Runnable{

    private LinkedBlockingQueue<String> blockingQueue;

    private CountDownLatch countDownLatch;

    public task(LinkedBlockingQueue<String> blockingQueue, CountDownLatch countDownLatch) {
        this.blockingQueue = blockingQueue;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            String take = blockingQueue.take();
            System.out.println(Thread.currentThread().getName() + " process " + take + " ok!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}
