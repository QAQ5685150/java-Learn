package com.cn.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @class: scheduleCourse_630
 * @description: TODO
 * @author: 南风
 * @date: 2021-12-14 15:44
 **/
public class scheduleCourse_630 {

    //  [[5,11],[3,5],[10,20],[4,20],[10,16]]
    public static void main(String[] args) {
        int[][] test = new int[][]{{100, 200},{200, 1300},{1000, 1250},{2000, 3200}};
        int[][] test1 = new int[][]{{1, 2}};
        int[][] test2 = new int[][]{{3, 2},{4,3}};
        int[][] test3 = new int[][]{{5,11},{3,5},{10,20},{4,20},{10,16}};
        Arrays.sort(test, (a,b) -> a[0] - b[0]);
        for (int[] ints : test3) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println(scheduleCourse(test));
        System.out.println(scheduleCourse(test1));
        System.out.println(scheduleCourse(test2));
        System.out.println(scheduleCourse1(test3));
    }

    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[0] - b[1]);
        int curTime = 0;
        int ans = 0;
        for (int i = 0; i < courses.length; i++) {
            if(curTime + courses[i][0] < courses[i][1]){
                curTime += courses[i][0];
                ans++;
            }
            if(courses[i][0] > courses[i][1]) continue;
        }
        return ans;
    }

    public static int scheduleCourse1(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        // 优先队列中所有课程的总时间
        int total = 0;

        for (int[] course : courses) {
            int ti = course[0], di = course[1];
            if (total + ti <= di) {
                total += ti;
                q.offer(ti);
            } else if (!q.isEmpty() && q.peek() > ti) {
                total -= q.poll() - ti;
                q.offer(ti);
            }
        }

        return q.size();
    }

}


