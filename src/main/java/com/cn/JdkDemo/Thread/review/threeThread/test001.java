package com.cn.JdkDemo.Thread.review.threeThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-04-02 11:20
 * @Description: 三个线程买票 多线程经典问题
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
            //这里要小于98，否则会超出100.因为锁的判定在内部，如果是100的话
            //到100时，还有两个程序只是被卡在了lock外，还是进入了while循环
            //所以就会出现执行到了102条的情况
            lock.lock();
                if(index % 3 != target){
                    try {
                        cur.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("售票站 " + s + " 正在出售第 " + index + " 张票");
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
