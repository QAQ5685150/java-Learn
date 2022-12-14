package com.cn.Algorithm.array.sort.nlogn;

import com.cn.Algorithm.util.printUtils;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-02-07 11:34
 * @Description: 归并排序
 * @Project_name: java-learn
 */
public class mergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{9,4,6,5,1,3,2,7,6,4};
        //mergeSort_review(test,0, test.length - 1);

        merge_re(test,0,test.length - 1);
        printUtils.printArray(test);
    }

    public static void mergeSort_review(int[] arr,int l,int r){
        if(l == r ){
            return;
        }
        // >> 操作符 二进制整体右移一位，例如11 二进制 1011 整体右移一位就是 0101 高位补0 结果是5 相当于 除2操作
        int mid = l + ((r - l) >> 1);
        mergeSort_review(arr,l,mid);
        mergeSort_review(arr,mid + 1,r);
        merge_review(arr,l,mid,r);
    }

    public static void merge_review(int[] arr,int l,int m,int r){
       int[] help = new int[r - l + 1];
       int p1 = l;
       int p2 = m + 1;
       int index = 0;
       while (p1 <= m && p2 <= r){
           help[index++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
       }
       while (p1 <= m){
           help[index++] = arr[p1++];
       }
       while (p2 <= r){
           help[index++] = arr[p2++];
       }
//       int j = 0;
//       for (int i = l; i < help.length; i++) {
//           arr[i] = help[j++];  这样写第二段是不会被补上的，l在右半段是肯定大于help数组的长度
//       }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
    static int num = 0;
    public static int reversePairs(int[] nums) {
        merge(nums,0,nums.length - 1);
        return num;
    }

    public static void merge(int[] nums, int l, int r){
        if(l == r){
            return ;
        }
        int mid = (l + (r - l) >> 1);
        merge(nums,l,mid);
        merge(nums,mid + 1,r);
        mergeSort1(nums,l,mid,r);
    }

    public static void mergeSort1(int[] nums, int l,int mid, int r){
        int[] help = new int[r - l + 1];
        int index = 0;
        int p1 = l;
        int p2 = mid;
        while (p1 <= mid && p2 <= r){
            if(nums[p1] > nums[p2]) num++;
            help[index++] = nums[p1] > nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 != mid){
            help[index++] = nums[p1++];
        }
        while (p2 != r){
            help[index++] = nums[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            help[i + l] = help[i];
        }
    }


    public static void merge_re(int[] arr, int l, int r){
        if(l == r){
            return;
        }
        int mid = (l + ((r - l) >> 1));
        merge_re(arr,l,mid);
        merge_re(arr,mid + 1, l);
        mergerSort_re(arr,l,mid,r);
    }

    public static void mergerSort_re(int[] arr, int l,int mid, int r){
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid;
        int index = 0;
        while (p1 <= mid && p2 <= r){
            if(arr[p1] > arr[p2]) help[index++] = arr[p1++];
            else help[index++] = arr[p2++];
        }
        while (p1 <= mid){
            help[index++] = arr[p1++];
        }
        while (p2 <= r){
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
