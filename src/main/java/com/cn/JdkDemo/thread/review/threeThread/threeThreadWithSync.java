package com.cn.JdkDemo.thread.review.threeThread;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-03-02 0:30
 * @Description: TODO
 * @Project_name: java-learn
 */
public class threeThreadWithSync extends Thread {
    private static Object LOCK = new Object();
    private static int flag = 1;
    public static void main(String[] args) throws InterruptedException {
        threeThreadWithSync A = new threeThreadWithSync() {
            public void run() {
                while (true) {
                    synchronized (LOCK) {
                        while (flag != 1) {
                            LOCK.notifyAll();
                            try {
                                LOCK.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("A");
                        flag = 2;
                        LOCK.notifyAll();
                    }
                }
            }
        };
        threeThreadWithSync B = new threeThreadWithSync() {
            public void run() {
                while (true) {
                    synchronized (LOCK) {
                        while (flag != 2) {
                            LOCK.notifyAll();
                            try {
                                LOCK.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("B");
                        flag = 3;
                        LOCK.notifyAll();
                    }
                }
            }
        };
        threeThreadWithSync C = new threeThreadWithSync() {
            public void run() {
                while (true) {
                    synchronized (LOCK) {
                        while (flag != 3) {
                            LOCK.notifyAll();
                            try {
                                LOCK.wait();

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("C");
                        flag = 1;
                        LOCK.notifyAll();
                    }
                }
            }
        };
        C.setName("C");
        B.setName("B");
        A.setName("A");
        C.start();
        B.start();
        A.start();
    }
}
