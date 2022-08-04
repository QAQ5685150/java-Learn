package com.cn.algorithm.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名:checkValidString_678
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-13 17:48
 **/
public class checkValidString_678 {

    /**
     * 给定一个只包含三种字符的字符串：（，）和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
     *
     * 任何左括号 (必须有相应的右括号 )。
     * 任何右括号 )必须有相应的左括号 (。
     * 左括号 ( 必须在对应的右括号之前 )。
     * *可以被视为单个右括号 )，或单个左括号 (，或一个空字符串。
     * 一个空字符串也被视为有效字符串。
     **/
    public static void main(String[] args) {
//        String test = "(((*))))";
//        System.out.println(checkValidString(test));
//        System.out.println(checkValidString1(test));
        for (int i : twoSum(new int[]{3,2,4}, 6)) {
            System.out.print(i + " ");
        }
    }

    public static int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < numbers.length; i++){
            map.put(numbers[i], i + 1);
        }
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(target - numbers[i])){
                res[0] = i + 1;
                res[1] = map.get(target - numbers[i]);
                break;
            }
        }
        return res;
    }

    /**
    *功能描述:TODO
    *@params
    *@return boolean
    **/
    public static boolean checkValidString(String s) {
        int l = 0, r = 0, f = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            if (c == '(') {
                l++;
                continue;
            }
            if (c == ')') {
                r++;
                continue;
            } else {
                f++;
                continue;
            }
        }
        if (l == r) return true;

        return l + f == r || r + f == l ? true : false;
    }

    /**
     * 使用贪心的思想，可以将空间复杂度降到 O(1)。
     *
     * 从左到右遍历字符串，遍历过程中，未匹配的左括号数量可能会出现如下变化：
     *
     * 如果遇到左括号，则未匹配的左括号数量加 1；
     *
     * 如果遇到右括号，则需要有一个左括号和右括号匹配，因此未匹配的左括号数量减 1；
     *
     * 如果遇到星号，由于星号可以看成左括号、右括号或空字符串，因此未匹配的左括号数量可能加 1、减 1 或不变。
     *
     * 基于上述结论，可以在遍历过程中维护未匹配的左括号数量可能的最小值和最大值，根据遍历到的字符更新最小值和最大值：
     *
     * 如果遇到左括号，则将最小值和最大值分别加 1；
     *
     * 如果遇到右括号，则将最小值和最大值分别减 1；
     *
     * 如果遇到星号，则将最小值减 1，将最大值加 1。
     *
     * 任何情况下，未匹配的左括号数量必须非负，因此当最大值变成负数时，说明没有左括号可以和右括号匹配，返回 false。
    **/
    public static boolean checkValidString1(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++; r++;
            } else if (c == ')') {
                l--; r--;
            } else {
                l--; r++;
            }
            l = Math.max(l, 0);
            if (l > r) return false;
        }
        return l == 0;
    }
}
