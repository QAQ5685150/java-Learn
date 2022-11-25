package com.cn.JdkDemo.thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-09-20 21:02
 * @Description: TODO
 * @Project_name: java-learn
 */
public class test {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();

    static volatile int semaphore = 0;
    static volatile int resource = 9;

    static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) {
        int resource = 9;
        Object lock = new Object();
        task t1 = new task(3, resource, lock);
        task t2 = new task(2, resource, lock);
        new Thread(() -> t1.run()).start();
        new Thread(() -> t2.run()).start();
    }

    static class task {
        int need;
        volatile int resource;
        volatile Object obj;
        AtomicBoolean flag = new AtomicBoolean(true);

        public task(int need, int resource, Object obj) {
            this.need = need;
            this.resource = resource;
            this.obj = obj;
        }

        public synchronized void run() {
            while (flag.get()) {
                if (resource >= need) {
                    resource -= need;
                    System.out.println(Thread.currentThread().getName() + " get " + need + ", left" + resource);
                } else {
                    flag.set(false);
                }
            }
        }
    }

    public static void Main(String[] args) {
        new Thread(() -> {
            while (flag.get()) {
                lock.lock();
                if (semaphore % 2 == 0) {
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                semaphore++;
                if (resource >= 2) {
                    resource -= 2;
                    System.out.println(resource);
                }
                if (resource < 3) {
                    flag.set(false);
                }
                condition2.signal();
                lock.unlock();
            }

        }, "monkey1").start();
        new Thread(() -> {
            while (flag.get()) {
                lock.lock();
                if (semaphore % 2 != 0) {
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                semaphore++;
                if (resource >= 3) {
                    resource -= 3;
                    System.out.println(resource);
                }
                if (resource < 2) {
                    flag.set(false);
                }
                condition1.signal();
                lock.unlock();
            }
        }, "monkey2").start();
    }
}
