package com.cn.JdkDemo.thread.ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.Thread.ForkJoin
 * @Time: 2022-09-29 13:40
 * @Description: ForkJoinPool ÈÎÎñ²ð·Ö
 **/
public class review {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> submit = forkJoinPool.submit(new recursive(1, 100, 25));
        System.out.println(submit.get());
    }
}

class recursive extends RecursiveTask<Long> {

    int start;
    int end;
    int times;
    long res;

    public recursive(Integer start, Integer end, Integer times) {
        this.start = start;
        this.end = end;
        this.times = times;
    }

    @Override
    protected Long compute() {
        if(end - start <= times){
            for (int i = start; i <= end; i++) {
                res += i;
            }
        }else {
            int mid = start + ((end - start) >> 1);
            recursive left = new recursive(start, mid, times);
            recursive right = new recursive(mid + 1, end, times);
            left.fork();
            right.fork();
            res = left.join() + right.join();
        }
        return res;
    }
}
