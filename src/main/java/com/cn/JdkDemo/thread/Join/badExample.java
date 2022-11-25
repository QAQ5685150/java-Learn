package com.cn.JdkDemo.thread.Join;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.Thread.Join
 * @Time: 2022-10-27 9:43
 * @Description: TODO
 **/
public class badExample {
    Integer total = 9;

    public static void main(String[] args) throws InterruptedException {
        badExample badExample = new badExample();
        badExample.take();
    }

    public void take() throws InterruptedException {
        takeApple takeApple = new takeApple(new monkey(3));
        takeApple takeApple1 = new takeApple(new monkey(2));
        Thread t1 = new Thread(takeApple);
        Thread t2 = new Thread(takeApple1);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
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
                    if(total - m.count <= 0){
                        total.notify();
                        break;
                    }
                    total -= m.count;
                }
                System.out.println(Thread.currentThread().getName() + " get apple ,left " + total);
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
