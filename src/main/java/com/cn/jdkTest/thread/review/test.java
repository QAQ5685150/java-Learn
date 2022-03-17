package com.cn.jdkTest.thread.review;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-02-27 15:44
 * @Description: 生产者消费者，juc test 两个线程交替打印
 * @Project_name: java-learn
 */
public class test {

    public static int index = 0;

    public static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        new Thread( () -> {
            int i = 0;
            while (i < 10){
                synchronized (obj){
                    while (index != 0){
                        //obj.notifyAll();
                        //这个判断条件过了，说明这块是暂时不想进来的，就唤醒其他线程执行另外的逻辑，自己进入等待
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    index--;
                    i++;
                    System.out.print(i + " ");
                    obj.notifyAll();
                    //第二个notify，这时候代码快运行完毕，唤醒另外一个还在等待共享资源index的线程，
                }
            }
        } ).start();

        new Thread( () -> {
            int i = 0;
            char c = 'a';
            while (i < 10){
                synchronized (obj){
                    while (index == 0){
                        //obj.notifyAll();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        obj.notify();
                    }
                    i++;
                    index++;
                    System.out.print(c++ + " ");
                    obj.notifyAll();
                }

            }
        } ).start();

        //process();
    }

    static ReentrantLock lock = new ReentrantLock();
    static Condition c1 = lock.newCondition();
    static Condition c2 = lock.newCondition();
    static Condition c3 = lock.newCondition();
    static int in = 0;

    public static void process(){
        new Thread( () -> {
                printA();
        }).start();
        new Thread( () -> {
                printB();
        }).start();
        new Thread( () -> {
                printC();
        }).start();
    }


    public static void print(Lock lock, Condition cur, Condition next,int index,String s){
        while (in < 30){
            lock.lock();
            try {
                if(in % 3 != index){
                    cur.await();
                }
                in++;
                System.out.println(s);
                next.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    public static void printA(){
        print(lock,c1,c2,0,"A");
    }

    public static void printB(){
        print(lock,c2,c3,1,"B");
    }

    public static void printC(){
        print(lock,c3,c1,2,"C");
    }

}


