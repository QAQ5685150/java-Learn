package com.cn.JdkDemo.Thread.ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.Thread.ForkJoin
 * @Time: 2022-10-18 16:39
 * @Description: TODO
 **/
public class forkJoin {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool fjp = new ForkJoinPool();
        ForkJoinTask<Long> submit = fjp.submit(new tasks(1,100,25));
        System.out.println(submit.get());
    }

}

class tasks extends RecursiveTask<Long>{

    private Integer start;

    private Integer end;

    private Integer recur;

    private Long res = 0L;

    public tasks(Integer start, Integer end, Integer recur) {
        this.start = start;
        this.end = end;
        this.recur = recur;
    }

    @Override
    protected Long compute() {
        if(end - start <= recur){
            for (int i = start; i <= end; i++) {
                res += i;
            }
        }else {
            int mid = (end + start) >> 1;
            tasks left = new tasks(start,mid,recur);
            tasks right = new tasks(mid + 1,end,recur);
            left.fork();
            right.fork();
            res = left.join() + right.join();
        }
        return res;
    }
}
