package com.cn.jdkTest.thread.review;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-03-03 17:00
 * @Description: synchronized wait\notifyʵ��
 * @Project_name: java-learn
 */
public class PrintABCUsingWaitNotify {
    private int times;// ��ӡ�Ĵ���
    private int state = 0;// ��ӡ��״̬
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
                //����ǰͬ����һ��������֪ͨ��������������IllegalMonitorStateException
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
