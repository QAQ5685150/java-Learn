package com.cn.Algorithm.array;

import java.util.PriorityQueue;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-12 19:40
 * @Description: TODO
 * @Project_name: java-learn
 */
public class test {

    public static void main(String[] args) {
        int[][] test = new int[][]{{6,8},{2,9},{4,7}};
        test1(test);
    }

    public static void test1(int[][] values){
        PriorityQueue<int[]> left = new PriorityQueue<>( (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> right = new PriorityQueue<>((a,b) -> b[0] - a[0]);
//        int l = 0;
//        int r = values.length - 1;
//        int total = 0;
//        int days = 0;

        for (int i = 0; i < values.length; i++) {
            if(values[i][0] > values[i][1]){
                right.add(values[i]);
            }else {
                left.add(values[i]);
            }
        }
        int total = 0;
        for (int i = 0; i < values.length; i++) {
            if(i % 2 == 0){
                int[] poll = right.poll();
                total += poll[0] + poll[1] * i;
            }else {
                int[] poll = left.poll();
                total += poll[0] + poll[1] * (values.length - i - 1);
                right.poll();
            }
        }
        System.out.println(total);
    }
}
