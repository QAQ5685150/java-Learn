package com.cn.Algorithm.string.kuohao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.string.kuohao
 * @Time: 2022-09-13 10:02
 * @Description: leetcode22.À¨ºÅÉú³É
 **/
public class generateParenthesis_22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        sc.next();
        String s = sc.nextLine();
        System.out.println(i + " " + s);
    }

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        process(new StringBuilder(), n, 0, 0);
        return res;
    }

    public void process(StringBuilder sb, int n, int left, int right){
        if(left + right == 2 * n){
            res.add(sb.toString());
            return;
        }
        if(left < n){
            sb.append("(");
            process(sb,n,left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(right < left){
            sb.append(")");
            process(sb,n,left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
