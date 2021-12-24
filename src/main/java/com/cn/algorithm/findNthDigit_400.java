package com.cn.algorithm;

/**
 * 类名:findNthDigit_400
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-30 10:17
 **/
public class findNthDigit_400 {

    public static void main(String[] args) {
        System.out.println(findNthDigit(15400));
    }

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
