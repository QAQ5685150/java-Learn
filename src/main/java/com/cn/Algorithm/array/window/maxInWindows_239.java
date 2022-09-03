package com.cn.Algorithm.array.window;

import java.util.*;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-04-01 11:56
 * @Description: TODO
 * @Project_name: java-learn
 */
public class maxInWindows_239 {

    public static void main(String[] args) {
        int[] test= new int[]{2,3,4,2,6,2,5,1};
        for (Integer maxInWindow : maxInWindows(test, 3)) {
            System.out.print(maxInWindow + " ");
        }
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(size == 0 || size>num.length || num.length == 0){
            return list;
        }

        LinkedList<Integer> qmax = new LinkedList<Integer>();
        //int w = 0;
        for(int i=0;i<num.length;i++){
            while(!qmax.isEmpty() && num[qmax.peekLast()]<=num[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() == i - size){// 判断队列的头部的下标是否过期
                qmax.pollFirst();
            }
            if(i>=size-1){//判断是否形成了窗口
                list.add(num[qmax.peekFirst()]);
            }
        }
        return list;
    }


    public static ArrayList<Integer> maxInWindows_review(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();

        LinkedList<Integer> qmax = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
            //用qmax双端队列（用双端队列为了方便实现窗口的进出条件）维护了一个窗口
            //规则如下：for循环nums[i] 当前数和窗口内最后一个数比较，如果没有新的数大，就移除窗口最后一个数
            //直到窗口为空，然后加入下一个数。
            //这样做是为了让最大值始终在窗口的第一个位置，这样直接取first就可以拿到最大值的下标
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            //维护窗口的条件，过期移除 （i - size）是当前窗口最左端可以拿到的最小的那个数，如果和下标相等，就更新窗口
            if(qmax.peekFirst() == i - size){
                qmax.pollFirst();
            }
            if(i >= size - 1){//每一次移动窗口，更新窗口的最大值，这里的更新是每移动一次就更新一次窗口的最大值
                //所以这里只要窗口大于size，就更新到窗口最大值集合里
                list.add(num[qmax.peekFirst()]);
            }
        }
        return list;
    }
}
