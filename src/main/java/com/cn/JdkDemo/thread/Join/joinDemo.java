package com.cn.JdkDemo.thread.Join;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.Thread.Join
 * @Time: 2022-09-28 15:42
 * @Description: TODO
 **/
public class joinDemo {

    static volatile Integer num = 10;

    public static void main(String[] args) throws InterruptedException {
        joinDemo jo = new joinDemo();
        Thread t1 = new Thread(jo.new tasks(2),"t1");
        Thread t2 = new Thread(jo.new tasks(3),"t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

     class tasks implements Runnable{

        int times;

        public tasks(int times) {
            this.times = times;
        }

        @Override
        public void run() {
            while (true){
                synchronized (num){
                    if(num - times < 0){
                        num.notify();
                        break;
                    }
                    num -= times;
                    System.out.println(Thread.currentThread().getName() + " -> " + times + " : " +num);
                }
            }
        }
    }
}


