package com.cn.algorithm.math;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: @Ğ¡ÄÔ¸«²»¿É°®
 * @Time: 2022-03-27 10:15
 * @Description: TODO
 * @Project_name: java-learn
 */
public class missingRolls_2028 {

    public static void main(String[] args) {
        int[] test = new int[]{1,5,6};
        for (int i : missingRolls(test, 3, 4)) {
            System.out.print(i + " ");
        }
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int len = rolls.length;
        int total = len + n;
        int left = 0;
        for (int roll : rolls) {
            left += roll;
        }
        int target = total * mean;

        int[] ans = new int[n];
        int i = (target - left) % n;
        if (((target - left) / n) > 6 || ((target - left) / n) < 0) {
            return new int[]{};
        }else {
            Arrays.fill(ans,(target - left) / n);
            for (int j = 0; j < i; j++) {
                ans[j] += 1;
            }
        }
        for (int an : ans) {
            if(an > 6 || an == 0){
                return new int[]{};
            }
        }
        return ans;
    }
}
