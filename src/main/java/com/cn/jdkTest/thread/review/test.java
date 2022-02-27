package com.cn.jdkTest.thread.review;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-02-27 15:44
 * @Description: 生产者消费者，juc test 两个线程交替打印
 * @Project_name: java-learn
 */
public class test {

    public static int index = 0;

    public static Object obj = new Object();


    public static void main(String[] args) {
        new Thread(new alpha(index,obj), "b").start();

        new Thread(new number(index,obj), "a").start();

    }

}

class number implements Runnable{

    private int index;

    private Object obj;

    public number(int index,Object obj) {
        this.index = index;
        this.obj = obj;
    }

    @SneakyThrows
    @Override
    public void run() {
        int i = 1;
        while (i < 10){
            synchronized (obj){
                if(index != 0){
                    obj.wait();
                }
                index--;
                System.out.print(i++);
                //System.out.print(Thread.currentThread().getName());
                obj.notify();
            }

        }
    }
}

class alpha implements Runnable{

    private static List<String> string = new ArrayList<>();

    private int index;

    private Object obj;

    static {
        Collections.addAll(string,"A","B","C","D","E","F","G","H","I","J");
    }

    public alpha(int index,Object obj) {
        this.index = index;
        this.obj = obj;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (obj){
            int i = 0;
            while (i < 10){
                if(index == 0){
                    obj.wait();
                }
                index++;
                if(i < string.size()){
                    System.out.print(string.get(i++));
                }
                //System.out.print(Thread.currentThread().getName());
                obj.notify();
            }
        }
    }
}
