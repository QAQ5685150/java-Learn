package com.cn.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-04 16:12
 * @Description: [78. 子集](https://leetcode-cn.com/problems/subsets/)
 * @Project_name: java-learn
 */
public class subsets_78 {

    private static List<List<Integer>> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int i  = 0;
        int[] test = new int[length];
        while (i < length){
            test[i] = sc.nextInt();
            i++;
        }
        for (List<Integer> subset : subsets(test)) {
            for (Integer integer : subset) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        process(list,new ArrayList<>(), nums, 0);
        return list;
    }

    public static void process(List<List<Integer>> rews, List<Integer> tmp,int[] nums, int i){
        rews.add(new ArrayList<>(tmp));

        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            process(rews,tmp,nums,j + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}