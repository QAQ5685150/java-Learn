package com.cn.JdkDemo.Thread.CountDown;

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
        Data mysqlData = new Data(4);
        Data redisData = new Data(5);
        Data mongoData = new Data(3);
        new Thread(() -> {
            res += mongoData.getTotal();
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            res += redisData.getTotal();
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            res += mysqlData.getTotal();
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();

        System.out.println(res);
    }


}

class Data{
    private int total;

    public Data(int total){
        this.total = total;
    }

    public int getTotal(){
        return total;
    }
}