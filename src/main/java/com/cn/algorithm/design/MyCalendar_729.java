package com.cn.algorithm.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.design
 * @Time: 2022-07-05 16:04
 **/
public class MyCalendar_729 {
    List<int[]> list;

    public MyCalendar_729() {
        list  = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        end--;
        for(int[] arr : list){
            int l = arr[0];
            int r = arr[1];
            if(start < r || end > l){
                return false;
            }
        }
        list.add(new int[]{start,end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendar_729 cal = new MyCalendar_729();
        System.out.println(cal.book(10, 20));
        System.out.println(cal.book(15, 30));
        System.out.println(cal.book(20, 30));
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */