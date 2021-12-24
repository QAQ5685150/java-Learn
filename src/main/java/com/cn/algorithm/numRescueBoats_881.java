package com.cn.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类名:numRescueBoats_881
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-26 14:05
 **/
public class numRescueBoats_881 {
    public static void main(String[] args) {
        int[] test = new int[]{1,1,1};
        int limit = 3;
        System.out.println(numRescueBoats(test, limit));
        int i = 1;
        int a = i++;
        int b = ++i;
        System.out.println(a);
        System.out.println(b);
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int index = 0,right = people.length - 1;
        while (index <= right){
            if(people[index] + people[right] <= limit){
                index++;
            }
            --right;
            ++ans;
        }
        return ans;
    }
}
