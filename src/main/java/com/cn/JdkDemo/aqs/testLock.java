package com.cn.JdkDemo.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.AQS
 * @Time: 2022-08-22 11:11
 * @Description: TODO
 **/
public class testLock {

    private static int mark = 0;


    static MyLock lock = new MyLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();

    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition condition11 = reentrantLock.newCondition();
    static Condition condition22 = reentrantLock.newCondition();

    /**
     * AQS�ṩ��Condition�����ɶ��߳�֮��ͨѶ��
     * condition������object����ĵȴ������ѷ���
     * condition.await() = object.wait()
     * condition.sign() = object.notify()
     * condition.signAll() = object.notifyAll()
     * condition����֧�ֶ���ȴ����� objectֻ֧��һ��
     * ʹ��wait()��������await()���̴߳�running״̬ת��ready����̬������ȴ����еȴ�����
     * @param args
     */
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            while (mark < 10){
                reentrantLock.lock();
                if(mark % 2 == 0){
                    try {
                        condition11.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mark++;
                System.out.println(Thread.currentThread().getName() + " lock share file a" + mark);
                condition22.signalAll();
                reentrantLock.unlock();
            }

        },"linxx - 1");

        Thread b = new Thread(() -> {
            while (mark < 10){
                reentrantLock.lock();
                if(mark % 2 != 0){
                    try {
                        condition22.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mark++;
                System.out.println(Thread.currentThread().getName() + " lock share file b" + mark);
                condition11.signalAll();
                reentrantLock.unlock();
            }
        },"linxx - 2");
        a.start();
        b.start();
        //���ϴ���δ����װ��д�����⣬û�г���˼ά

        //���߼������һ������
        testLock test = new testLock();
        Thread thread1 = new Thread(() -> test.t1());
        Thread thread = new Thread(() -> test.t2());
        thread1.start();
        thread.start();
    }

    public void t1(){
        reconstruct(condition11,condition22,0);
    }

    public void t2(){
        reconstruct(condition22,condition11,1);
    }

    public void reconstruct(Condition cur,Condition next,int target){
        while (mark <= 100){
            reentrantLock.lock();
            try {
            if (mark % 2 == target ? true : false){
                cur.await();
            }
            mark++;
            System.out.println(Thread.currentThread().getName() + " get lock " + mark);
            next.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }
    }


}
