package com.cn.Algorithm.array.stack;

import com.cn.Algorithm.util.printUtils;

import java.util.Stack;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.array
 * @Time: 2022-09-01 14:06
 * @Description: 1475. 商品折扣后的最终价格
 **/
public class finalPrices_1475 {

    public static void main(String[] args) {
        int[] test = new int[]{8,4,6,2,3};
        printUtils.printArray(finalPrices_stack(test));
    }

    //暴力解法
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] res = new int[len];
        for(int i = 0; i < len; i++){
            int cur = prices[i];
            for(int j = i + 1; j < len; j++){
                if(prices[i] >= prices[j]){
                    cur = prices[i] - prices[j];
                    break;
                }
            }
            res[i] = cur;
        }
        return res;
    }

    //单调栈
    public static int[] finalPrices_stack(int[] prices) {
        int len = prices.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]){
               res[stack.peek()] = prices[stack.pop()] - prices[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int index = stack.pop();
            res[index] = prices[index];
        }
        return res;
    }
}
