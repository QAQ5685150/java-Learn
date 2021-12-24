package com.cn.algorithm;

/**
 * 类名:sortColors_75
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-05 10:59
 **/
public class sortColors_75 {

    public static int[] sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p1 = 0;
        for(int i = 0;i < n;++i){
            if(nums[i] == 1){
                swap(nums,i,p1);
                ++p1;
            }else if(nums[i] == 0){
                swap(nums,i,p0);
                if(p0 < p1){//p0<p1 说明p0的位置上有一个1，这个时候换0就会把1换到后面去，所以换完p0后要再换一次p1
                    swap(nums,i,p1);
                }
                ++p0;
                ++p1;
            }

        }
        return nums;
    }

    public int[] mysortColors(int[] nums) {
        int n = nums.length;
        int i0 = 0;
        int i2 = n-1;
        for(int i1 = 1;i1 < i2;i1++){
            if(nums[i1] == 0){
                swap(nums,i0,i1);
                i0++;
            }
            if(nums[i1] == 2){
                swap(nums,i1,i2);
                i2--;
            }
        }
        return nums;
    }

    public static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,1,0,0,0,2,1,0,0,2,1,0,0,1};
        print(sortColors(test));
    }

}
