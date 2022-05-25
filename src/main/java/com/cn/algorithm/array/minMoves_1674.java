package com.cn.algorithm.array;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-05-06 10:47
 * @Description: 1674. 使数组互补的最少操作次数
 * @Project_name: java-learn
 */
public class minMoves_1674 {

    public static void main(String[] args) {

    }

    public int minMoves(int[] nums, int limit) {
        int[] diff = new int[limit * 2 + 2];

        int len = nums.length;

        for (int i = 0; i < len / 2; i++) {
            int a = nums[i];
            int b = nums[len -i - 1];

            // [2, 2 * limit] 范围 + 2
            int l = 2, r = 2 * limit;
            diff[l] += 2;
            diff[r + 1] -= 2;

            // [1 + min(A, B), limit + max(A, B)] 范围 -1
            l = 1 + Math.min(a, b);
            r = limit + Math.max(a, b);
            diff[l] += -1;
            diff[r + 1] -= -1;

            // [A + B] 再 -1
            l = a + b;
            r = a + b;
            diff[l] += -1;
            diff[r + 1] -= -1;
        }

        int res = len;
        int sum = 0;
        for (int i = 2; i <= 2 + limit; i++) {
            sum += diff[i];
            res = Math.max(res,sum);
        }
        return res;
    }
}
