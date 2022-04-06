package com.cn.algorithm.array;

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
                ++p0;//p0是还完以后最右边的边界，换完0后边界值要++
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

    /**
     * 功能描述:给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
     *
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
    **/
    public static void main(String[] args) {
        int[] test = new int[]{0,0,0,1,2,1};
        print(sortColors(test));
    }

}
