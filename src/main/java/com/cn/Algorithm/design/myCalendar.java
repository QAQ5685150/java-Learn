package com.cn.Algorithm.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.design
 * @Time: 2022-07-05 16:04
 **/
public class myCalendar{


    static class MyCalendar_729 {
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

    static class MyCalendarTwo_731 {

        List<int[]> order1;
        List<int[]> order2;

        public MyCalendarTwo_731() {
            order1 = new ArrayList<>();
            order2 = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] ints : order2) {
                int l = ints[0];
                int r = ints[1];
                if(r > start && l < end){
                    return false;
                }
            }

            for (int[] ints : order1) {
                int l = ints[0];
                int r = ints[1];
                if(r > start && l < end){
                    order2.add(new int[]{Math.max(l, start), Math.min(r, end)});
                }
            }
            order1.add(new int[]{start,end});
            return true;
        }

    public static void main(String[] args) {
            MyCalendarTwo_731 m = new MyCalendarTwo_731();
            System.out.println(m.book(10, 20));
            System.out.println(m.book(50, 60));
            System.out.println(m.book(10, 40));
            System.out.println(m.book(5, 15));
            System.out.println(m.book(5, 10));
            System.out.println(m.book(25, 55));
        }
    }
}
