package com.cn.Algorithm.algoritmBook.luogu;

import java.util.Scanner;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-04-06 14:17
 * @Description: TODO
 * @Project_name: java-learn
 */
public class test01 {
    public static void main(String[] args) {
        test02();
    }

    /**
     * 	P1085 [NOIP2004 普及组] 不高兴的津津
     */
    public static void test01(){
        Scanner sc = new Scanner(System.in);
        int[][] week = new int[7][2];
        for (int i = 0; i < 7; i++) {
            String[] s = sc.nextLine().split(" ");
            week[i][0] = Integer.valueOf(s[0]);
            week[i][1] = Integer.valueOf(s[1]);
        }
        int max = 0;
        int ans = 0;
        for (int i = 0; i < week.length; i++) {
            int cur = week[i][0] + week[i][1];
            if(cur > max){
                max = cur;
                ans = i;
            }
        }
        System.out.println(ans);
    }

    /**
     * P1909 [NOIP2016 普及组] 买铅笔
     */
    public static void test02(){
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int[][] price = new int[3][2];
        for (int i = 0; i < 3; i++) {
            price[i][0] = sc.nextInt();
            price[i][1] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (int[] ints : price) {
            int number = ints[0];
            int value = ints[1];
            int sum = (total % number) == 0 ? (total / number) * value : (total / number + 1) * value;
            min = Math.min(sum,min);
        }
        System.out.println(min);
    }

}
