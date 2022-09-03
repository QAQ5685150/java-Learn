package com.cn.Algorithm.array;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-05 10:25
 * @Description: TODO
 * @Project_name: java-learn
 */
public class NumArray_307 {

    int[] num;
    int[] trees;

    public NumArray_307(int[] nums) {
        trees = new int[nums.length + 1];
        num = nums;
        for (int i = 0; i < nums.length; i++) {
            add(i + 1,nums[i]);
        }

    }

    public void update(int index, int val) {
        add(index + 1,val);
        num[index] = val;
    }

    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }

    public void add(int index, int val){
        while (index < trees.length){
            trees[index] += val;
            index += lowBit(index);
        }
    }

    public int lowBit(int x){
        return x & (-x);
    }

    public int prefixSum(int index){
        int ans = 0;
        while (index > 0){
            ans += trees[index];
            index -= lowBit(index);
        }
        return ans;
    }

}
