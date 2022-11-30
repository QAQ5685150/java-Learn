package com.cn.JdkDemo.thread.lock.clazzLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.thread.lock.clazzLock
 * @Time: 2022-11-30 11:06
 * @Description: TODO
 **/
public class classSync {

    //��������volatile���������̰߳�ȫ����
    //pool-1-thread-13 ??????????: 99210
    public static volatile Integer global = 1;

    public static void main(String[] args) throws InterruptedException {
        //����2�ַ�ʽ:
        synchronized (classSync.class){

        }

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 100000; i++) {
            classSync c1 = new classSync();
            Thread t1 = new Thread(() -> {
                try {
                    c1.classLock();
                    //c1.methodLock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            executorService.submit(t1);
        }
        executorService.shutdown();
    }

    /**
     * ����synchronized �����߳�ͬ������
     * pool-1-thread-1 ??????????: 100000
     * @throws InterruptedException
     */
    public synchronized static void classLock() throws InterruptedException {
        int i = 0;
        //System.out.println(Thread.currentThread().getName() + " �����ֲ�����: " + i++);
        System.out.println(Thread.currentThread().getName() + " ����ȫ�ֱ���: " + global++);
    }

    /**
     * ������ ���ڷ�static������ ��ͬ������ò�������
     * pool-1-thread-3 ??????????: 99881
     */
    public synchronized void methodLock(){
        int i = 0;
        //System.out.println(Thread.currentThread().getName() + " �����ֲ�����: " + i++);
        System.out.println(Thread.currentThread().getName() + " ����ȫ�ֱ���: " + global++);
    }
}
