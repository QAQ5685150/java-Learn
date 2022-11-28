package com.cn.JdkDemo.thread.CountDown;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.thread
 * @Time: 2022-07-28 13:13
 * @Description: 蔚来面试手撕代码：三个线程拿数据，等所有数据拿到统计完以后再往下执行
 **/
public class countDownLatchDemo {

    public static volatile int res = 0;

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Data mysqlData = new Data(4,countDownLatch);
        Data redisData = new Data(5,countDownLatch);
        Data mongoData = new Data(3,countDownLatch);
        new Thread(() -> {
            res += mongoData.getTotal();
        }).start();

        new Thread(() -> {
            res += redisData.getTotal();
        }).start();

        new Thread(() -> {
            res += mysqlData.getTotal();
        }).start();
        countDownLatch.await();
        System.out.println(res);
    }
}

class Data{
    private int total;

    private CountDownLatch countDownLatch;

    public Data(int total,CountDownLatch countDownLatch){
        this.total = total;
        this.countDownLatch = countDownLatch;
    }

    public int getTotal(){
        this.countDownLatch.countDown();
        return total;
    }
}