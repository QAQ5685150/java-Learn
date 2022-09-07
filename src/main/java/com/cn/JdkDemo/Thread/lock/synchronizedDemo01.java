package com.cn.JdkDemo.Thread.lock;

import java.util.concurrent.*;

/**
 * 类名:synchronizedDemo01
 * 描述:生产者消费者Demo
 * 姓名:南风
 * 日期:2021-10-19 10:17
 **/
public class synchronizedDemo01 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();
        Producer01 producer = new Producer01(queue);
        Consumer01 consumer = new Consumer01(queue);
        //Future<?> submit = executorService.submit(producer);
//        try {
//            Object o = submit.get();
//            System.out.println(o);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        //producer.run();

        //executorService.execute(producer);
        //executorService1.execute(consumer);

        for(int i = 0;i < 2;i++){//模拟两个线程生产
            new Thread( ()-> producer.run()).start();
        }

        for(int i = 0;i < 3;i++){
            new Thread( ()-> consumer.run()).start();
        }

    }
}
