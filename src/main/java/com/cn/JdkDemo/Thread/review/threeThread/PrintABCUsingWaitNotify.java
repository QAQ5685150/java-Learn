package com.cn.JdkDemo.Thread.review.threeThread;

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

    public void printA() {
        print("A", 0, objectA, objectB);
    }

    public void printB() {
        print("B", 1, objectB, objectC);
    }

    public void printC() {
        print("C", 2, objectC, objectA);
    }

    public void print(String name, int targetState, Object curr, Object next) {
        for (int i = 0; i < times; i++) {
            synchronized (curr) {
                while (state % 3 != targetState) {
                    try {
                        //wait方法的语义有两个，一个是释放当前的对象锁、另一个是使得当前线程进入阻塞队列， 而这些操作都和监视器是相关的，
                        //所以wait必须要获得一个监视器锁。
                        curr.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                System.out.println(name);
                //解锁前同步下一把锁，再通知解锁，否则会出现IllegalMonitorStateException
                //notify方法必须出现在synchronized同步代码块里面，第一个代码块锁的是curr不是next
                //所以这边要解锁next 就要现有同步代码块再通知
                synchronized (next) {
                    next.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintABCUsingWaitNotify p = new PrintABCUsingWaitNotify(10);
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
