package com.cn.Algorithm.array.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.array.greedy
 * @Time: 2022-09-13 14:03
 * @Description: TODO
 **/
public class maximumSwap_670 {

    public static void main(String[] args) {
        System.out.println(maximumSwap1(1993));
    }
//1 2 3 4
//4 3 0 1
//4 3 1 0
    public static int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int len = chars.length;
        int min = 10;
        int minIndex = 0;
        for (int i = 0; i < len; i++) {
            int cur = chars[i] - '0';
            if(cur < min){
                minIndex = i;
                min = cur;
            }
        }
        if(minIndex == len - 1){
            return num;
        }
        int maxIndex = minIndex;
        int max = min;
        for (int i = len - 1; i > minIndex; i--) {
            int cur = chars[i] - '0';
            if(cur > max){
                maxIndex = i;
                max = cur;
            }
        }
        for (int i = 0; i < len; i++) {
            int max_tmp = chars[maxIndex] - '0';
            int cur = chars[i] - '0';
            if(max_tmp > cur){
                minIndex = i;
                break;
            }
        }
        swap(chars,minIndex,maxIndex);
        return Integer.valueOf(new String(chars));
    }

    public static void swap(char[] c, int i, int j){
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    public static int maximumSwap1(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10); num /= 10;
        }
        int n = list.size(), ans = 0;
        int[] idx = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            if (list.get(i) > list.get(j)) j = i;
            idx[i] = j;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (list.get(idx[i]) != list.get(i)) {
                int c = list.get(idx[i]);
                list.set(idx[i], list.get(i));
                list.set(i, c);
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) ans = ans * 10 + list.get(i);
        return ans;
    }
}
