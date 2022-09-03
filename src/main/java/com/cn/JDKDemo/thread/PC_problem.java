package com.cn.JDKDemo.thread;

public class PC_problem {

    private static int number = 0;

    public static void main(String[] args) throws Exception {


        PC_problem pc = new PC_problem();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    pc.producer();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    pc.customer();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        },"B").start();
    }

    public synchronized void customer() throws Exception {
        synchronized (this){
            System.out.println("synchronized");
        }
        if(number == 0){
            this.wait();
        }
        number--;

        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + "==>" + number);
    }

    public synchronized void producer() throws Exception {
        if(number == 1){
            this.wait();
        }
        number++;
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + "==>" + number);
    }
}
