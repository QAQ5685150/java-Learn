package com.cn.Algorithm.algoritmBook.august;

import java.util.Stack;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.algoritmBook
 * @Time: 2022-08-16 10:05
 * @Description: [0,1,0,2,1,0,1,3,2,1,2,1]
 **/
public class day08_16 {
    public static void main(String[] args) {
        int[] test = new int[]{4,2,0,3,2,5};
        System.out.println(trap_42(test));
    }

    public static int trap_42(int[] arr){
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                Integer last = stack.pop();
                if (stack.isEmpty()) break;
                Integer peek = stack.peek();
                int width = i - peek - 1;
                int high = Math.min(arr[peek],arr[i]) - arr[last];
                res += width * high;
            }
            stack.push(i);
        }
        return res;
    }


}
