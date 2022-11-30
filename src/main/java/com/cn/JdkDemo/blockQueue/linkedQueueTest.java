package com.cn.JdkDemo.blockQueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.blockQueue
 * @Time: 2022-11-28 13:29
 * @Description: jdk1.8 linkedQueue bug recurrent,stream process linkedQueue will block current thread
 **/
public class linkedQueueTest {
    public static void main(String[] args) throws Exception {
        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(1000);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    queue.offer(new Object());
                    queue.remove();
                }
            }).start();
        }
        while (true) {
            System.out.println("begin scan, i still alive");
            queue.stream()
                    .filter(o -> o == null)
                    .findFirst()
                    .isPresent();
            Thread.sleep(100);
            System.out.println("finish scan, i still alive");
        }
    }
}
