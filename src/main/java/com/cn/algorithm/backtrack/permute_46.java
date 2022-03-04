package com.cn.algorithm.backtrack;

import com.cn.algorithm.util.printUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 类名:permute_46
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-16 17:18
 **/
public class permute_46 {

    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        process1(list,0);
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
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            nums[index++] = sc.nextInt();
        }


        System.out.println(permute(nums));
    }

    private static void process1(List<Integer> arr,int i){
        if(arr.size() == i){
            res.add(new ArrayList<>(arr));
        }

        for (int j = i; j < arr.size(); j++) {
            Collections.swap(arr,i,j);
            process1(arr,i + 1);
            Collections.swap(arr,j,i);
        }


    }
}
