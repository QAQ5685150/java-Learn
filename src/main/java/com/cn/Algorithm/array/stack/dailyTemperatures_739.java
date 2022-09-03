package com.cn.Algorithm.array.stack;

import java.util.Stack;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.array.stack
 * @Time: 2022-07-14 10:36
 * @Description: TODO
 **/
public class dailyTemperatures_739 {

    public static void main(String[] args) {
        int[] test = new int[]{73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures2(test);
        for (int anInt : ints) {
            System.out.println(anInt + " ");
        }
    }


    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
//            while (!stack.isEmpty() && temperatures[stack.peek()] > temperatures[i]){
//                stack.push(i);
//            }
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }

    public static int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        res[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < T.length; j += res[j]) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }
}
