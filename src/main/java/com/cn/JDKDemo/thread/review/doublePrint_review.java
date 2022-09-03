package com.cn.JDKDemo.thread.review;

/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.thread.review
 * @Time: 2022-07-19 14:27
 * @Description: TODO
 **/
public class doublePrint_review {

    Object lock = new Object();

    int mark = 0;

    int index = 1;

    Character c = 'a';

    public static void main(String[] args) {
        doublePrint_review d = new doublePrint_review();
        new Thread( () -> {
            d.printNum();
        }).start();
        new Thread( () -> {
            d.printAlpha();
        }).start();
    }

    public void printNum(){
        while (index < 20){
            synchronized (lock){
                if(mark % 2 != 0){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mark++;
                System.out.print(index++ + " ");
                lock.notifyAll();
            }
        }
    }

    public void printAlpha(){
        while (index < 20){
            synchronized (lock){
                if(mark % 2 == 0){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mark--;
                System.out.print(c++ + " ");
                lock.notifyAll();
            }
        }
    }
}
