package com.cn.algorithm.window;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.window
 * @Time: 2022-07-18 16:13
 * @Description: TODO
 **/
class MovingAverage {

    int cur;

    int size;

    double window;

    Deque<Integer> deque = new ArrayDeque<Integer>();

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.cur = 0;
        window = 0;
    }

    public double next(int val) {
        window += val;
        cur++;
        deque.addLast(val);
        if(cur > size){
            window -= deque.pollFirst();
        }
        int tmp = cur >= size ? size : cur;
        return window / tmp;
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}