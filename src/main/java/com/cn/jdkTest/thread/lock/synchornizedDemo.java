package com.cn.jdkTest.thread.lock;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类名:synchornizedDemo
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-07-23 15:17
 **/
@Deprecated
public class synchornizedDemo {

    private static volatile HashSet<Integer> set = new HashSet<Integer>();

    public static void main(String[] args) {
        set.add(1);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0;i < 5;i++){

            executorService.execute(()->{
                syn();
            });
        }
    }

    public synchronized static void syn(){
        if (set.contains(1)){
            synchronized (synchornizedDemo.class) {
                set.remove(set.size() - 1);
                set.add(2);
                for (Integer integer : set) {
                    System.out.println(integer);
                }
            }
        }
        if (set.contains(2)){
            synchronized (synchornizedDemo.class){
                set.remove(set.size()-1);
                set.add(1);
                for (Integer integer : set) {
                    System.out.println(integer);
                }
            }

        }



    }
}
