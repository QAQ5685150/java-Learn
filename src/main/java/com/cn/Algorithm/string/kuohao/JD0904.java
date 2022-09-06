package com.cn.Algorithm.string.kuohao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.string.kuohao
 * @Time: 2022-09-06 14:00
 * @Description: ���� 09-04 ����
 **/
public class JD0904 {

    public static void main(String[] args) {
        //demo03();
        //demo02();
        System.out.println(dp("())())"));
    }

    /**
     * ��Ŀ����
     * С���õ���һ�����飬��ÿ�ο��Խ������²���֮һ��
     * ѡ��һ��Ԫ��x���������Ϊ1��x-1��
     * ��ѡ��һ��Ԫ��x���������Ϊa��b����Ҫ��֤a*b=x
     * С��ϣ�������ٵĲ������������������������Ԫ��ȫ�����1�����ܰ������
     * ����������
     * ��һ������һ��������n����������ĳ��ȡ�
     * �ڶ�������n��������ai������С���õ������顣
     * 1 �� n, ai �� 1e5
     * ���������
     * һ��������������С�Ĳ���������
     *
     * input:
     * 2
     * 2 6
     *
     * output:
     * 5
     *
     *
     * ˼·�� �Զ����µĵݹ飬hashmap���仯�����Ż�һ�£�Ҳ����ֱ��DP
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
     * �Զ����µ�dfs�ݹ�
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
     * �Ե����ϵ�dp[]�����ʽ����
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
     * ��Ŀ����
     * ����һ�����Ŵ���ȨֵΪ��������Ϸ����������еĳ��ȡ�
     * ���磬"())())��Ȩֵ��4��������Ϸ�����������Ϊ"()()��
     * ������һ���������Ŵ��������Ӵ�Ȩֵ֮�͡�
     * ����������
     * һ��������'('��')'���ַ��������Ȳ�����2e5��
     * ���������
     * �����Ӵ���Ȩֵ�͡�
     *
     * input:
     * ())())
     *
     * output:
     * 26
     *
     * ���ͣ�
     * ȨֵΪ2���Ӵ���2��
     * ȨֵΪ4���Ӵ���2��
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
