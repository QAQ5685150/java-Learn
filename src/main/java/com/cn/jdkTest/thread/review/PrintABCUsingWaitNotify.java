package com.cn.jdkTest.thread.review;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-03 17:00
 * @Description: synchronized wait\notify实现
 * @Project_name: java-learn
 */
public class PrintABCUsingWaitNotify {
    private int times;// 打印的次数
    private int state = 0;// 打印的状态
    private Object objectA = new Object();
    private Object objectB = new Object();
    private Object objectC = new Object();

    public PrintABCUsingWaitNotify(int times) {
        super();
        this.times = times;
    }

    public void printA(){
        print("A", 0, objectA, objectB);
    }

    public void printB(){
        print("B", 1, objectB, objectC);
    }

    public void printC(){
        print("C", 2, objectC, objectA);
    }

    public void print(String name, int targetState, Object curr, Object next){
        for (int i = 0; i < times;) {
            synchronized (curr) {
                while(state % 3 != targetState){
                    try {
                        curr.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i++;
                state++;
                System.out.print(name);
                //解锁前同步下一把锁，再通知解锁，否则会出现IllegalMonitorStateException
                synchronized (next) {
                    next.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintABCUsingWaitNotify p = new PrintABCUsingWaitNotify(100);
        new Thread(new Runnable() {
            @Override
            public void run() {
                p.printA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                p.printB();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                p.printC();
            }
        }).start();
    }
}
