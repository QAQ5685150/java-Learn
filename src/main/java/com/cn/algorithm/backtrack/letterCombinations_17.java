package com.cn.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.backtrack
 * @Time: 2022-07-12 9:22
 **/
public class letterCombinations_17 {

    public static void main(String[] args) {
        for (String letterCombination : letterCombinations("23")) {
            System.out.println(letterCombination + " ");
        }

//        throw concurrentModifyException from @checkForComodification()
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        for (Integer integer : list) {
//            list.add(1 + integer);
//        }

        backTracking(tel,"23",0);
        for (String re : res) {
            System.out.println(re + " ");
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
}
