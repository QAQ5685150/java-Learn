package com.cn.Algorithm.array;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-03-31 10:17
 * @Description: TODO
 * @Project_name: java-learn
 */
public class removeElement_27 {

    public static void main(String[] args) {
        int[] test = new int[]{0,1,2,2,3,0,4,2};
        int i = removeElement_01(test, 2);
        for (int j = 0; j < i; j++) {
            System.out.print(test[j] + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int r = nums.length - 1;
        while(nums[r] == val){
            r--;
        }
        int index = 0;
        for(int i = 0;i < r; i++){
            if(nums[i] == val){
                swap(nums,i,r);
                r--;
                index++;
            }
        }
        return r + 1;
    }

    public static void swap(int[] nums,int l,int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static int removeElement_01(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
