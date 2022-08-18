package com.cn.jdkTest.thread.pcModel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.thread.pcModel
 * @Time: 2022-06-29 9:23
 **/
public class blockQueueTest {

    public static void main(String[] args) {


        producer producer = new producer(deque);

        consumer consumer = new consumer(deque);

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread( () -> {
                int index = 0;
                while (index++ < 10){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    producer.product(finalI);
                }


            }).start();

            new Thread( () -> {
                int index = 0;
                while (index++ < 10) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    consumer.consumer();
                }
            }).start();
        }

    }

    /*
    blockingQueue经常配合atomic类原子操作使用
     */
    static BlockingQueue<Integer> deque = new LinkedBlockingDeque<>();


    static class producer{

        private BlockingQueue<Integer> queue;

        public producer() {
        }

        public producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        public void product(int i){
            queue.offer(i);
            System.out.println("-----生产者准备生产-----");
//                Thread.sleep(2000);
            System.out.println("producer make a product : " + i);
        }
    }

    static class consumer{

        private BlockingQueue<Integer> queue;

        public consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        public void consumer(){
            try {
                System.out.println("-----消费者准备消费-----");
//                Thread.sleep(2000);
                Integer take = queue.take();
                System.out.println("consumer get one product : " + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
