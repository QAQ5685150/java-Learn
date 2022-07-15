package com.cn.algorithm.array;

import java.util.Arrays;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.array
 * @Time: 2022-07-14 15:54
 * @Description: TODO
 **/
public class leastInterval_621 {

    public static int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A'] += 1;
        }
        Arrays.sort(count);
        int maxCount = 1;
        for (int i = 24; i >= 0; i--) {
            if(count[i] == count[25]){
                maxCount++;
            }else {
                break;
            }
        }
        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 1 + maxCount);
    }
}
