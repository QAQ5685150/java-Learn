package com.cn.algorithm.math;

/**
 * 类名:computeArea_223
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-30 14:19
 **/
public class computeArea_223 {
    public static void main(String[] args) {
       // System.out.println(computeArea(-3,0,3,4,0,-1,9,2));//45
       // System.out.println(computeArea_x(-2, -2, 2, 2, -1, 4, 1, 6));//20
        System.out.println(computeArea_right(-2, -2, 2, 2, -1, 4, 1, 6));

    }


    public static int computeArea_x(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int x1 = ax1 >= bx1 ? ax1 : bx1;
        int x2 = ax2 <= bx2 ? ax2 : bx2;
        int y1 = ay1 >= by1 ? ay1 : by1;
        int y2 = ay2 <= by2 ? ay2 : by2;
        int cover = 0;

//        if(bx1 < ax2 || by1 < by2 || by2 > ay1 || bx2 > ax1) {
//            cover = Math.abs(y2 - y1) * Math.abs(x2 - x1);
//        }

        if((bx1 < ay1 && bx2 < ay2)|| (ay1 < by1 && ay2 < by2) || (bx1 < ax1 && by1 > ay1) || bx2 > ax1) {
            cover = Math.abs(y2 - y1) * Math.abs(x2 - x1);
        }
        int s1 = (ax2 - ax1) * (ay2 -ay1);
        int s2 = (bx2 - bx1) * (by2 - by1);

        return s1 + s2 - cover;
    }

    public static int computeArea_right(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int z1 = Math.min(ax2, bx2);
        int z2 = Math.max(ax1, bx1);
        int z3 = Math.min(ay2, by2);
        int z4 = Math.max(ay1, by1);

        int x = Math.max(0, z1 - z2);
        int y = Math.max(0, z3 - z4);
        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - (x * y);
    }
}
