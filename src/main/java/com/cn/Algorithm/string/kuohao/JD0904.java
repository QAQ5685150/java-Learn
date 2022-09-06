package com.cn.Algorithm.string.kuohao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.string.kuohao
 * @Time: 2022-09-06 14:00
 * @Description: 京东 09-04 笔试
 **/
public class JD0904 {

    public static void main(String[] args) {
        //demo03();
        //demo02();
        System.out.println(dp("())())"));
    }

    /**
     * 题目描述
     * 小红拿到了一个数组，她每次可以进行如下操作之一：
     * 选择一个元素x，将其分裂为1和x-1。
     * ·选择一个元素x，将其分裂为a和b，需要保证a*b=x
     * 小红希望用最少的操作次数，将所有数组的所有元素全部变成1。你能帮帮她吗？
     * 输入描述：
     * 第一行输入一个正整数n，代表数组的长度。
     * 第二行输入n个正整数ai，代表小红拿到的数组。
     * 1 ≤ n, ai ≤ 1e5
     * 输出描述：
     * 一个整数，代表最小的操作次数。
     *
     * input:
     * 2
     * 2 6
     *
     * output:
     * 5
     *
     *
     * 思路： 自顶向下的递归，hashmap记忆化搜索优化一下，也可以直接DP
     */
    public static void demo02(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        int[] dp = dp(5000);
        for (int i = 0; i < n; i++) {
            res += dp[sc.nextInt()];
        }
        System.out.println(res);
    }

    /**
     * 自顶向下的dfs递归
     * @param n
     * @return
     */
    public static int process(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        int res = Integer.MAX_VALUE;
        if(n % 2 == 0){
            res = process( 2) + process(n / 2) + 1;
        }
        int i = process(n - 1) + 1;
        return Math.min(res,i);
    }

    /**
     * 自底向上的dp[]数组格式递推
     * @param n
     * @return
     */
    public static int[] dp(int n){
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int tmp = Integer.MAX_VALUE;
            if(i % 2 == 0){
                tmp = dp[2] + dp[i / 2] + 1;
            }
            int val = dp[i - 1] + 1;
            dp[i] = Math.min(tmp, val);
        }
        return dp;
    }

    /**
     * 题目描述
     * 定义一个括号串的权值为，它的最长合法括号子序列的长度。
     * 例如，"())())的权值是4，它的最长合法括号子序列为"()()”
     * 现在求一个给定括号串的所有子串权值之和。
     * 输入描述：
     * 一个仅包含'('和')'的字符串，长度不超过2e5。
     * 输出描述：
     * 所有子串的权值和。
     *
     * input:
     * ())())
     *
     * output:
     * 26
     *
     * 解释：
     * 权值为2的子串有2个
     * 权值为4的子串有2个
     */
    public static void demo03(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        ArrayList<int[]> score = getScore(s);
        int weight = 0;
        for (int[] ints : score) {
            int left = ints[0];
            int right = ints[1];
            weight += (left + 1) * (len - right + 1) * 2;
        }
        System.out.println(weight);
    }

    public static ArrayList<int[]> getScore(String str){
        ArrayList<int[]> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '('){
                stack.push(i);
            }else {
                if(!stack.isEmpty() && str.charAt(stack.peek()) == '('){
                    res.add(new int[]{stack.pop(),i + 1});
                }
            }
        }
        return res;
    }

    public static int dp(String str){
        int length = str.length();
        int[] dp = new int[length + 1];
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= length; i++) {
            dp[i] = dp[i - 1];
            if(str.charAt(i - 1) == '('){
                stack.push(i);
            }else {
                if(!stack.isEmpty()){
                    Integer pop = stack.pop();
                    dp[i] = dp[i] + pop;
                }
            }
            ans = ans + dp[i];
        }
        return ans * 2;
    }
}
