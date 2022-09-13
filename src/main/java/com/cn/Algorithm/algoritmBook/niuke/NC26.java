package com.cn.Algorithm.algoritmBook.niuke;

import java.util.ArrayList;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.algoritmBook.niuke
 * @Time: 2022-09-13 14:51
 * @Description: NC26 À¨ºÅÉú³É
 **/
public class NC26 {
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> generateParenthesis (int n) {
        // write code here
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
