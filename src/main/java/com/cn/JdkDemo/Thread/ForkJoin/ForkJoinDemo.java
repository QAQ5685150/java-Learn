package com.cn.JdkDemo.Thread.ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.Thread.ForkJoin
 * @Time: 2022-09-13 15:31
 * @Description: ForkJoin Çø¼äÀÛ¼ÓDemo
 **/
public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long l = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        JoinTask joinTask = new JoinTask(1, 1000000, 1000000/4);
        ForkJoinTask<Long> submit = forkJoinPool.submit(joinTask);
        System.out.println(submit.get());
        long integer = joinTask.get();
        System.out.println(integer);
        System.out.println(joinTask.getRes());
        System.out.println("process times : " + (System.currentTimeMillis() - l));

    }

}

class JoinTask extends RecursiveTask<Long> {

    private int start;

    private int end;

    private int times;

    private long res;

    public JoinTask(int start, int end, int times) {
        this.end = end;
        this.start = start;
        this.times = times;
    }

    public long getRes() {
        return res;
    }

    @Override
    protected Long compute() {
        System.out.println(Thread.currentThread().getName() + "is processing range [" + start + "," + end + "]");
        if (end - start <= times) {
            for (int i = start; i <= end; i++) {
                res += i;
            }
        } else {
            int middle = start + ((end - start) >> 1);
            JoinTask left = new JoinTask(start,middle,times);
            JoinTask right = new JoinTask(middle + 1,end,times);
            left.fork();
            right.fork();
            res = left.join() + right.join();
        }
        return res;
    }
}
