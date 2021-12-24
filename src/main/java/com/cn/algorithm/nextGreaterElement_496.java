package com.cn.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * 类名:nextGreaterElement_496
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-10-26 10:01
 **/
public class nextGreaterElement_496 {

    public static void main(String[] args) {
        int[] test1 = new int[]{4,1,2};
        int[] test2 = new int[]{1,3,2,5};
//        int[] ints = nextGreaterElement(test1, test2);
//        System.out.print("[");
//        for (int i = 0; i < ints.length - 1; i++) {
//            System.out.print(ints[i] + ",");
//        }
//        System.out.print(ints[ints.length - 1]);
//        System.out.print("]");

        System.out.println(nextGreaterElement1(test1, test2));
    }

    /**
    *功能描述:找到 496.下一个最大的元素，时间复杂度O（nums1.length + nums2.length）的方法
    *@param nums1
    *@param nums2
    *@return int[]
    **/
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
         HashMap<Integer,Integer> map = new HashMap<>();
         Stack<Integer> stack = new Stack<>();
         int[] ans = new int[nums1.length];
         for(int i = 0;i < nums2.length;i++){
             while(!stack.isEmpty() && nums2[i] > stack.peek()){
                 map.put(stack.pop(),nums2[i]);
             }
             stack.push(nums2[i]);
         }
         while(!stack.isEmpty()){
             map.put(stack.pop(),-1);
         }
         for(int i = 0;i < nums1.length;i++){
             ans[i] = map.get(nums1[i]);
         }
         return ans;
     }

     public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
         HashMap<Integer,Integer> map = new HashMap<>();
         Stack<Integer> stack = new Stack<>();
         int[] ans = new int[nums1.length];
         for(int i = 0;i < nums2.length;i++){
             while(!stack.isEmpty() && nums2[i] > stack.peek()){
                 map.put(stack.pop(),nums2[i]);   //若下一个数比当前大，就加入map作为键值对，否则放入stack
             }
             stack.push(nums2[i]);
         }
         while(!stack.isEmpty()){
             map.put(stack.pop(),-1);
         }
         for(int i = 0;i < nums1.length;i++){
             ans[i] = map.get(nums1[i]);
         }
         return ans;
     }

}
