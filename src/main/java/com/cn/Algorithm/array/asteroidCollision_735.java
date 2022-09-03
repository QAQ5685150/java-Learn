package com.cn.Algorithm.array;

import com.cn.Algorithm.util.printUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.array
 * @Time: 2022-07-13 9:20
 * @Description: TODO
 **/
public class asteroidCollision_735 {

    public static void main(String[] args) {
        int[] test = new int[]{5,10,-5,20,31,-13,-41,50,35,23,-14,-24,-60,23,25,27,68};
        for (int i : asteroidCollision(test)) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] test1 = new int[]{5,10,-5,20,31,-13};
        int[] reverse = reverse(test1, 0, test1.length - 1);
        printUtils.printArray(reverse);
        //异或运算符交换两个数
//        int a = 40;
//        int b = 50;
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//        System.out.println(a + " : " + b);
    }

    /**
     * 执行用时：14 ms, 在所有 Java 提交中击败了12.38%的用户
     * @param asteroids
     * @return
     */
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int tmp = asteroids[i];
            if (!stack.isEmpty() && isDiff(stack.peek(),tmp)){
                while (!stack.isEmpty() && isDiff(stack.peek(),tmp) && Math.abs(stack.peek()) < Math.abs(tmp)){
                    stack.pop();
                }
                if (!stack.isEmpty() && isDiff(stack.peek(),tmp) && Math.abs(stack.peek()) > Math.abs(tmp)){
                    continue;
                }
                if(!stack.isEmpty() && isDiff(stack.peek(),tmp) && Math.abs(stack.peek()) == Math.abs(tmp)){
                    stack.pop();
                    continue;
                }

            }
            stack.push(tmp);
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static boolean isDiff(int a, int b){
        return (a > 0 && b < 0);
    }

    /**
     * 用boolean控制循环是否继续，好思路
     * @param ats
     * @return
     */
    public static int[] asteroidCollision2(int[] ats) {
        Deque<Integer> d = new ArrayDeque<>();
        for (int t : ats) {
            boolean ok = true;
            while (ok && !d.isEmpty() && d.peekLast() > 0 && t < 0) {
                int a = d.peekLast(), b = -t;
                if (a <= b) d.pollLast();
                if (a >= b) ok = false;
            }
            if (ok) d.addLast(t);
        }
        int sz = d.size();
        int[] ans = new int[sz];
        while (!d.isEmpty()) ans[--sz] = d.pollLast();
        return ans;
    }

    public static int[] reverse(int[] arr, int i, int j){
        while (i < j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
            i++;
            j--;
        }
        return arr;
    }
}
