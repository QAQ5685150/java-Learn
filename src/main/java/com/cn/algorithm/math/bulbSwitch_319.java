package com.cn.algorithm.math;

import java.util.Arrays;

/**
 * 类名:bulbSwitch_319
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-16 9:54
 **/
public class bulbSwitch_319 {

    /**
     * 初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭第二个。
     *
     * 第三轮，你每三个灯泡就切换第三个灯泡的开关（即，打开变关闭，关闭变打开）。
     *
     * 第 i 轮，你每 i 个灯泡就切换第 i 个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
     *
     * 找出并返回 n轮后有多少个亮着的灯泡。
    **/
    public static void main(String[] args) {
        System.out.println(bulbSwitch(10));
        System.out.println(bulbSwitch1(10));
    }

    /**
    *功能描述:我的版本 想用模拟统计最终结果
    *@return int
    **/
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

    /**
     * 第i个灯泡的反转次数等于它所有因子（包括1和i）的个数，一开始的状态的灭的，
     * 只有反转奇数次才会变成亮的，所以只有因子个数为奇数的灯泡序号才会亮，
     * 只有平方数的因子数为奇数（比如6=1*6,2*3，它们的因子总是成对出现的，而4=1*4,2*2，
     * 只有平方数的平方根因子会只出现1次），所以最终答案等于n以内（包括n和1）的平方数数量，
     * 只要计算sqrt(n)即可
    **/
    public static int bulbSwitch1(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }

}
