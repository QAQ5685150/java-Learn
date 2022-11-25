package com.cn.JdkDemo.thread.Join;

import java.util.HashMap;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.Thread.Join
 * @Time: 2022-10-27 9:42
 * @Description: TODO
 **/
public class joinDemo2 {

    Integer total = 9;

    public static void main(String[] args) throws InterruptedException {
        joinDemo2 j = new joinDemo2();
        j.get();
        HashMap<Integer,Integer> map = new HashMap<>();
        System.out.println(null == map.get(1));
    }

    public void get() throws InterruptedException {
        takeApple t1 = new takeApple(new monkey(2));
        takeApple t2 = new takeApple(new monkey(3));
        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t2);

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();
    }

    class takeApple implements Runnable{
        monkey m;
        takeApple(monkey m){
            this.m = m;
        }

        @Override
        public void run() {
            while (true){
                synchronized (total){
                    if (total - m.count <= 0){
                        total.notify();
                        break;
                    }
                    total -= m.count;
                    System.out.println(Thread.currentThread().getName() + " take apple " + m.count + ", last " + total);
                }
            }
        }
    }

    class monkey{
        int count;
        monkey(int count){
            this.count = count;
        }
    }
}
