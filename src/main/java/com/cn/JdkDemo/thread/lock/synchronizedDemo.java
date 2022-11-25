package com.cn.JdkDemo.thread.lock;

/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.thread.lock
 * @Time: 2022-08-19 13:40
 * @Description: TODO
 **/
public class synchronizedDemo {

    public synchronized void funcA() {
        System.out.println("a lock ¡­¡­¡­¡­");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a exit ¡­¡­¡­¡­");
    }

    public synchronized void funcB() {
        System.out.println("b lock ¡­¡­¡­¡­");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b exit ¡­¡­¡­¡­");
    }


}

class test {
    public static void main(String[] args) {
        synchronizedDemo s = new synchronizedDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> s.funcA()).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> new synchronizedDemo().funcB()).start();
        }
    }
}
