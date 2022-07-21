package com.cn.algorithm.backtrack;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.backtrack
 * @Time: 2022-07-12 9:22
 **/
public class letterCombinations_17 {

    public static void main(String[] args) {
        for (String letterCombination : letterCombinations("232")) {
            System.out.print(letterCombination + " ");
        }
        System.out.println();
        for (String letterCombination : review("232")) {
            System.out.print(letterCombination + " ");
        }

//        throw concurrentModifyException from @checkForComodification()
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        for (Integer integer : list) {
//            list.add(1 + integer);
//        }
        System.out.println();

        Backtracking_review1("232",0);
        for (String re : result) {
            System.out.print(re + " ");
        }
    }

    static String[] tel = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            res = process(res,tel,digits.charAt(i) - '0');
        }
        return res;
    }

    /**
     * 方法一：递归，函数的输出作为下一次循环的输入，递归处理
     * @param list
     * @param tel
     * @param index
     * @return
     */
    public static List<String> process(List<String> list, String[] tel, int index){
        String s = tel[index];
        List<String> res = new ArrayList<>();
        for (int i = 0; i < tel[index].length(); i++) {
            if(list.size() == 0){
                res.add(s.substring(i,i+1));
            }else {
                for (String s1 : list) {
                    res.add(s1 + s.substring(i,i+1));
                }
            }
        }
        return res;
    }

    static List<String> res = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    /**
     * 回溯的方法，通过“添加-撤销”的方法完成树形结构扫描全域
     * @param ss
     * @param digits
     * @param index
     */
    public static void backTracking(String[] ss, String digits, int index){
        if(digits.length() == index){
            res.add(sb.toString());
            return;
        }

        String s1 = ss[digits.charAt(index) - '0'];
        for (int i = 0; i < s1.length(); i++) {
            sb.append(s1.charAt(i));
            backTracking(ss,digits,index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static String[] telephone = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static List<String> review(String digits){
        int len = digits.length();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            res = dfs_review(res,Integer.valueOf(digits.charAt(i) - '0'));
        }
        return res;
    }

    private static List<String> dfs_review(List<String> list, int index) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < telephone[index].length(); i++) {
            if(list.isEmpty()){
                res.add(telephone[index].substring(i,i+1));
            }else {
                for (String re : list) {
                    res.add(re + telephone[index].substring(i,i+1));
                }
            }
        }
        return res;
    }


    static List<String> result = new ArrayList<>();

    static StringBuilder stringBuilder = new StringBuilder();

    public static void Backtracking_review(String[] ss, String digits,int index){
        if (index == digits.length()){
            result.add(stringBuilder.toString());
            return;
        }
        String s = ss[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            Backtracking_review(ss,digits,index + 1);
            stringBuilder.deleteCharAt(index);
        }
    }

    public static void Backtracking_review1(String digits,int index){
        if (index == digits.length()){
            result.add(stringBuilder.toString());
            return;
        }
        String s = telephone[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            Backtracking_review1(digits,index + 1);
            stringBuilder.deleteCharAt(index);
        }
    }
}
