package com.cn.algorithm.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 类名:permute_46
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-16 17:18
 **/
public class permute_46 {

    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        process(nums,0);
        return res;
    }

    public static void process(int[] nums,int i){
        if(i == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            res.add(list);
        }
        for(int j = i;j < nums.length;j++){
            swap(nums,i,j);
            process(nums,i+1);
            swap(nums,j,i);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
