package com.cn.Algorithm.array;

import java.util.*;

/**
 * 类名:majorityElement_229
 * 描述:求众数2   hashmap & 摩尔投票法
 * 姓名:南风
 * 日期:2021-10-22 9:50
 **/
public class majorityElement_229 {

    /**
    *给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
    **/
    public static void main(String[] args) {
        int[] test = new int[]{1,1,1,3,3,3,2,2,2};
        List<Integer> list = majorityElement1(test);
        System.out.println(list);
    }

    /**
     * 摩尔投票法的基本思想很简单
     * 在每一轮投票过程中，从数组中找出一对不同的元素，将其从数组中删除。
     * 这样不断的删除直到无法再进行投票，如果数组为空，则没有任何元素出现的次数超过该数组长度的一半。
     * 如果只存在一种元素，那么这个元素则可能为目标元素。
    **/
    public static List<Integer> majorityElement1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int m1 = 0;
        int counter1 = 0;
        int m2 = 0;
        int counter2 = 0;
        for (int num : nums) {
            if((counter1 == 0 || m1 == num) && m2 != num){
                m1 = num;
                counter1++;
            }else if(counter2 == 0 || m2 == num){
                m2 = num;
                counter2++;
            }else{
                counter1--;
                counter2--;
            }
        }
        int count = 0;
        for (int num : nums) {
            if(m1 == num){
                count++;
            }
        }
        if(count > nums.length / 3) list.add(m1);

        count = 0;
        for (int num : nums) {
            if(m2 == num){
                count++;
            }
        }
        if(count > nums.length / 3 && m1 != m2) list.add(m2);

        return list;
    }


    public static List<Integer> majorityElement(int[] nums) {
        int major = nums.length / 3;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue() >= major){
                list.add(next.getKey());
            }
        }
        return list;
    }
}
