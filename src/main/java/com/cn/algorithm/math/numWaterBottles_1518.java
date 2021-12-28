package com.cn.algorithm.math;

/**
 * 类名: numWaterBottles_1518
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2021-12-17 11:46
 **/
public class numWaterBottles_1518 {

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9,3));

    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles > 0){
            int left = numBottles % numExchange;
            int cur = ((numBottles - left) / numExchange);
            ans += cur;
            numBottles = (left + cur) >= numExchange ? (left + cur) : 0;
        }
        return ans;
    }
}
