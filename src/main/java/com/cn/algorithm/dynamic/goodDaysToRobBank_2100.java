package com.cn.algorithm.dynamic;

import com.cn.algorithm.util.printUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-06 21:28
 * @Description: TODO
 * @Project_name: java-learn
 */
public class goodDaysToRobBank_2100 {

    public static void main(String[] args) {
        int[] security = new int[]{5,3,3,3,5,6,2};
        printUtils.printArray(goodDaysToRobBank(security,2));
    }

    /**
     * 标准答案：前缀和，分两次统计，一次统计每个数左边有多少小于当前数  一次统计右边有多少个数大于当前数
     * 最后一遍判断，如果当前数的左前数组和右前数组同时大于Time，说明当前数是符合的天数，加入结果数组
     * @param security
     * @param time
     * @return
     */
    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            if (security[n - i - 1] <= security[n - i]) {
                right[n - i - 1] = right[n - i] + 1;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                ans.add(i);
            }
        }
        return ans;
    }


    /**
     * 俺的思路，直接前缀和加模拟，符合判断要求就直接加入结果数组
     * @param security
     * @param time
     * @return
     */
    public static List<Integer> goodDaysToRobBank1(int[] security, int time) {
        List<Integer> ans = new ArrayList<>();
        int length = security.length;
        if(time == 0){
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                list.add(i);
            }
        }
        if(time >= length){
            return new ArrayList<>();
        }

        int[] arr = new int[length + 1];
        int tmp = 0;
        for (int i = 1; i < length + 1; i++) {
            tmp += security[i - 1];
            arr[i] = tmp;
        }

        for (int i = time; i < length - time; i++) {
            if(method(arr,i,time)){
                ans.add(i);
            }
        }

        return ans;
    }

    public static boolean method(int[] pre, int i, int time){
        int left = pre[i - time + 1] - pre[i - time];
        for (int j = i - time; j < time; j++) {
            int cur = pre[j + 1] - pre[j];
            if(left < cur){
                return false;
            }
        }
        int right = pre[i + time + 1] - pre[i + time];
        for (int j = i + time; j >i ; j--) {
            int cur = pre[j + 1] - pre[j];
            if(right < cur){
                return false;
            }
        }
        return true;
    }
}
