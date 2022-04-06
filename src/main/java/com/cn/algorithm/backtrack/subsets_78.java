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
//        Scanner sc = new Scanner(System.in);
//        int length = sc.nextInt();
//        int i  = 0;
//        int[] test = new int[length];
//        while (i < length){
//            test[i] = sc.nextInt();
//            i++;
//        }
        int[] test = new int[]{1,2,3};
        for (List<Integer> subset : review(test)) {
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

    public static List<List<Integer>> review(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        _process(list,nums,list1,0);
        return list;
    }

    private static void  _process(List<List<Integer>> list, int[] nums, List<Integer> arr,int startIndex) {
//        if(arr.size() == nums.length){
            list.add(new ArrayList<>(arr));
//            return;
//        }

        for (int i = startIndex; i < nums.length; i++) {
            arr.add(nums[i]);
            _process(list,nums,arr,i + 1);//往下一层的递归参数为i + 1 防止出现重复
            arr.remove(arr.size() - 1);
        }

    }


}