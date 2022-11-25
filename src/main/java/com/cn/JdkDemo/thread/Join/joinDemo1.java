package com.cn.JdkDemo.thread.Join;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.Thread.Join
 * @Time: 2022-09-28 15:53
 * @Description: join模拟两个线程抢占式卖票
 **/
public class joinDemo1 {

    volatile Integer total = 10;

    public static void main(String[] args) throws InterruptedException {
        joinDemo1 j = new joinDemo1();
        j.runTask();
    }
    public void runTask() throws InterruptedException {
        Thread t1 = new Thread(new trainStation(), "t1");
        Thread t2 = new Thread(new trainStation(), "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
    class trainStation implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (total){
                    if(total <= 0){
                        //通知另外一个线程 运行然后break，达到线程通信效果
                        //用wait notify
                        total.notify();
                        break;
                    }
                    total -= 1;
                    System.out.println(Thread.currentThread().getName() + " seal ont ticket, last " + (total));
                }
            }
        }
    }
}

