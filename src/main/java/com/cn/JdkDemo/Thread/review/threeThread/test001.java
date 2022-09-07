package com.cn.JdkDemo.Thread.review.threeThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-04-02 11:20
 * @Description: �����߳���Ʊ ���߳̾�������
 * @Project_name: java-learn
 */
public class test001 {
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    private int index = 0;

    public static void main(String[] args) {
        test001 t = new test001();
        new Thread( () -> t.sale_a("a",0)).start();
        new Thread( () -> t.sale_b("b",1)).start();
        new Thread( () -> t.sale_c("c",2)).start();
    }

    public void sale(String s, Condition cur, Condition next,int target){
        while (index <= 98){
            //����ҪС��98������ᳬ��100.��Ϊ�����ж����ڲ��������100�Ļ�
            //��100ʱ��������������ֻ�Ǳ�������lock�⣬���ǽ�����whileѭ��
            //���Ծͻ����ִ�е���102�������
            lock.lock();
                if(index % 3 != target){
                    try {
                        cur.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("��Ʊվ " + s + " ���ڳ��۵� " + index + " ��Ʊ");
                index++;
                next.signalAll();
                lock.unlock();
        }
    }

    public void sale_a(String s,int target){
        sale(s,c1,c2,target);
    }

    public void sale_b(String s,int target){
        sale(s,c2,c3,target);
    }

    public void sale_c(String s,int target){
        sale(s,c3,c1,target);
    }
}
