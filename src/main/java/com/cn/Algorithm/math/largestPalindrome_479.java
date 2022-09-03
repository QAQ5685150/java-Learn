package com.cn.Algorithm.math;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-04-16 10:26
 * @Description: TODO
 * @Project_name: java-learn
 */
public class largestPalindrome_479 {

    public static void main(String[] args) {
        System.out.println(largestPalindrome(2));
    }

    public static int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int upper = (int) Math.pow(10, n) - 1;
        int ans = 0;
        for (int left = upper; ans == 0; --left) { // 枚举回文数的左半部分
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                p = p * 10 + x % 10; // 翻转左半部分到其自身末尾，构造回文数 p
            }
            for (long x = upper; x * x >= p; --x) {
                if (p % x == 0) { // x 是 p 的因子
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }
}
