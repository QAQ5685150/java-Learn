package com.cn.algorithm.greedy;

import java.util.Arrays;

/**
 * 类名:numRescueBoats_881
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-26 14:05
 **/
public class numRescueBoats_881 {
    
    /**
     * 功能描述:第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
     *
     * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
     *
     * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
     *
     * 输入：people = [3,2,2,1], limit = 3
     * 输出：3
     * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
    **/
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
