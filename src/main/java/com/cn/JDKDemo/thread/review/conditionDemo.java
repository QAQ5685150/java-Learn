package com.cn.JDKDemo.thread.review;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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

    private void print(Integer target, String s, Lock lock, Condition cur, Condition next) {
        for (int i = 0; i < times; i++) {
            lock.lock();
            try {
                if (index % 3 != target) {
                    cur.await();
                }
                index++;
                System.out.println(s + "  ----  " + index);
                next.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printA(Integer target, String s) {
        print(target, s, lock, c1, c2);
    }

    public void printB(Integer target, String s) {
        print(target, s, lock, c2, c3);
    }

    public void printC(Integer target, String s) {
        print(target, s, lock, c3, c1);
    }

    public static void main(String[] args) {
        conditionDemo c = new conditionDemo(100);
        new Thread(() -> c.printA(0, "A")).start();
        new Thread(() -> c.printB(1, "B")).start();
        new Thread(() -> c.printC(2, "C")).start();
    }

}

class review{

    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private int times;
    private int index = 0;
    private int i = 0;

    public review(int times){
        this.times = times;
    }

    private void print(Lock lock,Condition cur, Condition next,Object[] objects,Integer target){
        while (index < times){
            lock.lock();
                try {
                    if(target != index % 2){
                        cur.await();
                    }
                    index++;
                    System.out.println(objects[i++]);
                    next.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
    }

    public void printNum(Character num){
        print(lock,c1,c2,new Object[]{1,2,3,4,5,6,7,8,9,10},0);
    }

    public void printAlpha(Character alpha){
        print(lock,c2,c1,new Object[]{'a','b','c','d','e','f','g','h','i','j'},1);
    }

    public static void main(String[] args) {
        review r = new review(20);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit( () -> {
            r.printNum('1');
        });
        executorService.submit( () -> {
            r.printAlpha('a');
        });
    }
}