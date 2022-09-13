package com.cn.JdkDemo.Thread.CountDown;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.Thread.CountDown
 * @Time: 2022-09-13 10:07
 * @Description: TODO
 **/
public class addNumCountDown {

    static int n = 1000000;

    static int taskNum = 2;

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        CountDownLatch countDown = new CountDownLatch(taskNum);
        TaskCount task1 = new TaskCount(0, n / taskNum, countDown);
        TaskCount task2 = new TaskCount(n / taskNum + 1, n, countDown);
        Thread t1 = new Thread(() -> task1.process());
        t1.start();
        Thread t2 = new Thread(() -> task2.process());
        t2.start();
        try {
            countDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sum " + n + " = " + (task1.getRes() + task2.getRes()));
        System.out.println("run times : " + (System.currentTimeMillis() - l));
    }
}

class TaskCount {

    private int start;

    private int end;

    private long res;

    private CountDownLatch countDownLatch;

    public TaskCount(int start, int end, CountDownLatch countDownLatch) {
        this.start = start;
        this.end = end;
        this.countDownLatch = countDownLatch;
    }

    public long getRes() {
        return res;
    }

    public void process(){
        System.out.println(Thread.currentThread().getName());
        for (int i = start; i <= end; i++) {
            res += i;
        }
        countDownLatch.countDown();
    }
}
