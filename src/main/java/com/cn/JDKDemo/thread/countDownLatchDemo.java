package com.cn.JDKDemo.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.thread
 * @Time: 2022-07-28 13:13
 * @Description: ε��������˺���룺�����߳������ݣ������������õ�ͳ�����Ժ�������ִ��
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