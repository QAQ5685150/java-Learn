package com.cn.jdkTest.thread.review;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-03 16:25
 * @Description: lock + condition 实现三个线程循环打印
 * @Project_name: java-learn
 */
public class conditionDemo {

    private int times;
    private int index = 0;

    public conditionDemo(int times) {
        this.times = times;
    }

    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    private void print(Integer target, String s, Lock lock, Condition cur, Condition next){
        for (int i = 0; i < times; i++) {
            lock.lock();
            try {
                if(index % 3 != target){
                    cur.await();
                }
                index++;
                System.out.println(s + "  ----  " + index);
                next.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public void printA(Integer target, String s){
        print(target,s,lock,c1,c2);
    }

    public void printB(Integer target, String s){
        print(target,s,lock,c2,c3);
    }
    public void printC(Integer target, String s){
        print(target,s,lock,c3,c1);
    }

    public static void main(String[] args) {
        conditionDemo c = new conditionDemo(100);
        new Thread(() -> c.printA(0,"A")).start();
        new Thread(() -> c.printB(1,"B")).start();
        new Thread(() -> c.printC(2,"C")).start();
    }

}
