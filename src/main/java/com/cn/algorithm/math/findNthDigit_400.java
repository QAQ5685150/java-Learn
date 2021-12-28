package com.cn.algorithm.math;

/**
 * 类名:findNthDigit_400
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-30 10:17
 **/
public class findNthDigit_400 {

    /**
    * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
    **/
    public static void main(String[] args) {
        System.out.println(findNthDigit(15400));
    }

    /**
    *直接根据规律计算。
     *
     * 已知 xx 位数共有 9 \times 10^{x - 1}9×10
     * x−1
     *   个，所有 xx 位数的位数之和是 x \times 9 \times 10^{x - 1}x×9×10
     * x−1
     *  。使用 dd 和 \textit{count}count 分别表示当前遍历到的位数和当前位数下的所有整数的位数之和，初始时 d = 1d=1，\textit{count} = 9count=9。每次将 nn 减去 d \times \textit{count}d×count，然后将 dd 加 11，将 \textit{count}count 乘以 1010，直到 n \le d \times \textit{count}n≤d×count，此时的 dd 是目标数字所在整数的位数，nn 是所有 dd 位数中从第一位到目标数字的位数。
     *
     * 为了方便计算目标数字，使用目标数字在所有 dd 位数中的下标进行计算，下标从 00 开始计数。令 \textit{index} = n - 1index=n−1，则 \textit{index}index 即为目标数字在所有 dd 位数中的下标，\textit{index}index 的最小可能取值是 00。
    **/
    public static int findNthDigit2(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

    /**
    *功能描述:TODO
    *@param n
    *@return int
    **/
    public static int findNthDigit(int n) {
        int dig = 1, count = 9;
        while (n > (long) dig * count) {
            n -= dig * count;
            dig++;
            count *= 10;
        }
        int start = ((int)Math.pow((double)10,(double) (dig - 1)));
        int offset = n / dig;
        int cur = start + offset;
        int num = n % (dig - 1);

        int tmp = cur;
        int len = 0;
        while(tmp > 0){
            tmp /= 10;
            len++;
        }

        int[] arr = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            arr[i] = cur % 10;
            cur /= 10;
        }
        return arr[num];
    }
}
