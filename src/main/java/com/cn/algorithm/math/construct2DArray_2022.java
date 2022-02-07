package com.cn.algorithm.math;

import com.cn.algorithm.util.printUtils;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-01-01 22:32
 * @Description: TODO
 * @Project_name: java-learn
 */
public class construct2DArray_2022 {

    /**
     * 给你一个下标从 0开始的一维整数数组original和两个整数m和n。你需要使用original中所有元素创建一个m行n列的二维数组。
     *
     * original中下标从 0到 n - 1（都 包含 ）的元素构成二维数组的第一行，下标从 n到 2 * n - 1（都包含）的元素构成二维数组的第二行，依此类推。
     *
     * 请你根据上述过程返回一个m x n的二维数组。如果无法构成这样的二维数组，请你返回一个空的二维数组。
     */
    public static void main(String[] args) {
        int[] test = new int[]{1,3,4,5};
        int m = 2;
        int n = 2;
        printUtils.printArray(construct2DArray(test,m,n));

    }

    /**
     * 题目很简单，简单循环一边就过了。但其中的思想是我一直欠缺的，我感觉自己一直缺乏对“算法”这个抽象概念的理解，刷了很多道算法题了
     * 感觉还是不能够清晰的说出来。想一想前面我写的shell编程，输入一堆参数然后输出一堆参数，算法就是中间的处理过程，我突然有些明白了
     * 这其实是一种抽象与具体的结合。有时候在编程的时候会想破头想不出来，有可能就是对于太具体的某个用例推整个结果集，但并不完全适用
     * 我需要找到一种针对所有情况都使用的处理过程，并且这个过程有更好的时间复杂度和健壮性
     * @param original
     * @param m
     * @param n
     * @return
     */
    public static int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length){
            return new int[0][0];
        }
        int[][] arr = new int[m][n];
        int index = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = original[index++];
            }
        }
        return arr;
    }
}
