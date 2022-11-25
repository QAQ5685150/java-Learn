package com.cn.JdkDemo.thread.review.threeThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.thread.review
 * @Time: 2022-09-07 14:32
 * @Description: TODO
 **/
public class test0001 {

    static ReentrantLock lock = new ReentrantLock();
    static Condition c1 = lock.newCondition();
    static Condition c2 = lock.newCondition();
    static Condition c3 = lock.newCondition();
    static int num = 0;
    public static void print(Condition curr, Condition next, int target, String cur){
        while (num <= 100){
            lock.lock();
            if(num % 3 != target){
                try {
                    curr.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "----------" + cur);
            next.signalAll();
            lock.unlock();
        }
    }

    public static void printA(){
        print(c1,c2,0,"A");
    }

    public static void printB(){
        print(c2,c3,1,"B");
    }

    public static void printC(){
        print(c3,c1,2,"C");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(test0001::printA);
        executorService.submit(test0001::printB);
        executorService.submit(test0001::printC);
        executorService.shutdown();
    }
}
