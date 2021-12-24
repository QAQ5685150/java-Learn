package com.cn.algorithm;

import java.util.Arrays;

/**
 * 类名:bulbSwitch_319
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-16 9:54
 **/
public class bulbSwitch_319 {

    public static void main(String[] args) {
        System.out.println(bulbSwitch(10));
    }

    public static int bulbSwitch(int n) {
        int[] arr = new int[n + 1];
        int sum = 0;
        int index = 2;
        Arrays.fill(arr,1);
        for (int i = 1; i < n; i++) {
            int cur = 0;
            while (cur <= n){
                arr[cur] *= -1;
                cur += index;
            }
            index++;
        }
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != -1) sum += 1;
        }
        return sum;
    }

}
