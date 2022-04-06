package com.cn.algorithm.array;

import java.util.Stack;

/**
 * 类名:trap_42
 * 描述:42. 接雨水
 * 姓名:南风
 * 日期:2021-08-23 13:28
 **/
public class trap_42 {

    public static void main(String[] args) {
        int[] test = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(test));
        //System.out.println(trap2(test));
    }

    /**
    *功能描述:单调栈
    *@param height
    *@return int
    **/
    public static int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < height.length;i++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()] ) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int leftIndex = stack.peek();
                int curWidth = i - leftIndex - 1;
                int curHeight = Math.min(height[leftIndex],height[i]) - height[top];
                ans += curHeight * curWidth;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
    *功能描述:双指针
    *@param height
    *@return int
    **/
    public static int trap2(int[] height) {
        int ans = 0;
        int left = 0,leftMax = 0;
        int right = height.length - 1,rightMax = 0;

        while(left < right){
            //产生差值的情况是有一边移动， 另一边用leftMax固定，
            leftMax = Math.max(leftMax,height[left]);//维护了一个最大值，用最大值减去当前位置的高度就是可以盛下的水量
            //可以分情况证明正确性：1、若前面的max比后面的max小，必然有leftMax ~ 下一个leftMax 的水量为 --> 当前的leftMax - height[left]
            //2、若前面的max比后面的max小，又有height[left] < height[right] 水量就是leftMax往右的所有能盛下的高度差
            rightMax = Math.max(rightMax,height[right]);
            //右边同理
            if(height[left] < height[right]){
                //height[left] < height[right]的正确性：这种情况右指针的“山峰”一定比左边高，左边能接的水量就是左边最大值 - 当前左边山峰高度
                ans += leftMax - height[left];
                //我刚开始以为会出现ans为负数的情况，在遍历到 height[left] = leftMax的位置，但是人家这时候正好相等啊= =
                left++;
            }else{//同理
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}