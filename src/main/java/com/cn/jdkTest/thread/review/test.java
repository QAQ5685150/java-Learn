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
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-02-27 15:44
 * @Description: �����������ߣ�juc test �����߳̽����ӡ
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
                        //����ж��������ˣ�˵���������ʱ��������ģ��ͻ��������߳�ִ��������߼����Լ�����ȴ�
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
                    //�ڶ���notify����ʱ������������ϣ���������һ�����ڵȴ�������Դindex���̣߳�
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


