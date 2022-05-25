package com.cn.algorithm.math;

/**
 * @Auther: @С�Ը����ɰ�
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
        for (int left = upper; ans == 0; --left) { // ö�ٻ���������벿��
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                p = p * 10 + x % 10; // ��ת��벿�ֵ�������ĩβ����������� p
            }
            for (long x = upper; x * x >= p; --x) {
                if (p % x == 0) { // x �� p ������
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }
}
