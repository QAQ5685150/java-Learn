package com.cn.JdkDemo.blockQueue.delay;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.blockQueue.delay
 * @Time: 2022-11-25 11:24
 * @Description: TODO
 **/
public class demo {

    public static void main(String[] args) throws InterruptedException {
        order order1 = new order("order1", 5, TimeUnit.SECONDS);
        order order2 = new order("order2", 10, TimeUnit.SECONDS);
        order order3 = new order("order3", 15, TimeUnit.SECONDS);
        DelayQueue<order> delayQueue = new DelayQueue<>();
        delayQueue.put(order1);
        delayQueue.put(order2);
        delayQueue.put(order3);
        System.out.println("订单延迟队列开始时间:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        while (delayQueue.size() != 0) {
            /**
             * 取队列头部元素是否过期
             */
            order task = delayQueue.poll();
            if (task != null) {
                System.out.format("订单:{%s}被取消, 取消时间:{%s}\n", task.name, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
            //Thread.sleep(1000);
        }

    }
}
