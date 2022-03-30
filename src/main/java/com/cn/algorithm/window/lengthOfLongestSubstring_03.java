package com.cn.algorithm.window;

import java.util.HashSet;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-30 10:28
 * @Description: TODO
 * @Project_name: java-learn
 */
public class lengthOfLongestSubstring_03 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcddabcdef"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int index = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            //刚开始我用的是set里是否存在判断左边的窗口是否要移动，题解是只要i！=0 循环一遍就左移
            //也好理解，里面的while只要退出，就说明set维护的窗口有重复数据，需要移动了，不需要判断是否在里面再移动左窗口
            if(i != 0){
                set.remove(s.charAt(i - 1));
            }
            while (index < s.length() && !set.contains(s.charAt(index))){
                set.add(s.charAt(index));
                index++;
                max = Math.max(max,index - i);
            }

        }
        return max;
    }
}
