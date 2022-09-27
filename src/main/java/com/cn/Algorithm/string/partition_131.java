package com.cn.Algorithm.string;

import com.cn.Algorithm.util.printUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.string
 * @Time: 2022-09-27 11:27
 * @Description: TODO
 **/
public class partition_131 {

    public static void main(String[] args) {
        List<List<String>> aab = partition_back("aabb");
        printUtils.printArray(aab);

    }

    public static List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        String[] split = s.split("");
        List<String> splits = new ArrayList<>();
        for (String s1 : split) {
            splits.add(s1);
        }
        res.add(splits);
        for (int i = 0; i < len; i++) {
            String first = s.substring(0, i);
            String last = s.substring(i, len);
            ArrayList<String> cur = new ArrayList<>();
            if (checkString(first) && checkString(last)) {
                cur.add(first);
                cur.add(last);
                res.add(cur);
            }
        }
        return res;
    }

    public static boolean checkString(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    static List<List<String>> list = new ArrayList<>();

    public static List<List<String>> partition_back(String s) {
        process(s.toCharArray(), new ArrayList<String>(), 0);
        return list;
    }

    public static void process(char[] c, ArrayList<String> path, int n) {
        if (n == c.length) {
            //不能直接添加path，最后结果为空
            //因为list.add(path)是一个引用地址，递归要对path操作，递归到最后path为空，就打印为空
            //使用另一个集合保存path在末尾位置的值，就是可以的
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = n; i < c.length; i++) {
            if (check(c, n, i)) {
                path.add(new String(c, n, i - n + 1));
                //这里往下递归从i开始 从题目可以看出每次从当前位置向下递归
                //一个变量n，一个变量i i从n位置开始，就是从当前循环i位置往下递归的
                process(c, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public static boolean check(char[] s, int i, int j) {
        while (i < j) {
            if (s[i++] != s[j--]) {
                return false;
            }
        }
        return true;
    }

    class Solution {

        //声明一个全局变量ans
        List<List<String>> ans = new ArrayList<>();

        //主方法
        public List<List<String>> partition(String s) {
            backtrack(s.toCharArray(), 0, new ArrayList());
            return ans;
        }

        //回溯方法
        void backtrack(char[] s, int startIndex, List<String> path) {
            //当startIndex越界时返回
            if (startIndex == s.length) {
                //将当前path添加到ans中，注意：需要新造一个ArrayList
                ans.add(new ArrayList(path));
                return;
            }
            //从startIndex开始枚举
            for (int i = startIndex; i < s.length; i++) {
                if (check(s, startIndex, i)) {
                    //从startIndex到i如果是回文串，则将此串加入path，并向下递归
                    path.add(new String(s, startIndex, i - startIndex + 1));
                    backtrack(s, i + 1, path);
                    //递归完毕后，记得将此串从path中删除，这是回溯算法的关键步骤
                    path.remove(path.size() - 1);
                }
            }
        }

        //辅助方法，判断从start到end是否回文
        boolean check(char[] s, int start, int end) {
            while (start <= end) {
                if (s[start++] != s[end--]) {
                    return false;
                }
            }
            return true;
        }
    }
}
