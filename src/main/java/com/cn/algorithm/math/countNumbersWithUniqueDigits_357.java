package com.cn.algorithm.math;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-11 10:16
 * @Description: TODO
 * @Project_name: java-learn
 */
public class countNumbersWithUniqueDigits_357 {

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(3));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        int total = (int)Math.pow(10D,(double) n);
        int last = 0;
        for(int i = 0;i < n - 1; i++){
            last += (int)Math.pow((double) 10,i);
        }
        return total - 3 * 9 * last;
    }
}
