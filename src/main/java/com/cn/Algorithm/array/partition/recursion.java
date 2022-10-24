package com.cn.Algorithm.array.partition;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.array.partition
 * @Time: 2022-10-19 14:18
 * @Description: TODO
 **/
public class recursion {

    static int target = 4;

    public static void main(String[] args) {
        int[] test = new int[]{1,2,4,5,6,7,8};
        System.out.println(search(0,test.length - 1,target,test));
        System.out.println(partition(test,0,test.length - 1,target));
        System.out.println(unRecursion(test,target));
    }

    private static int partition(int[] arr,int l, int r,int target){
        if(l <= r){
            int mid = (( r + l) >> 1);
            if(target == arr[mid]){
                return arr[mid];
            }else if(target > arr[mid]){
                return partition(arr,mid + 1, r, target);
            }else if(target < arr[mid]){
                return partition(arr,l,mid - 1,target);
            }
        }
        return -1;
    }

    private static int unRecursion(int[] arr, int target){
        int l = 0;
        int r = arr.length - 1;
        while (l < r){
            int mid = l + ((r - l) >> 1);
            if(arr[mid] >= target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return arr[l];
    }


    public static int search(int start,int end,int target,int a[]){
        if(start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == target) {
                return a[mid];
            } else if (target > a[mid]) {
                //target >和=都判断过了a[mid] 那么下次开始的位置应该越过mid的后一个位置
                return search(mid + 1, end, target, a);
            } else if (target < a[mid]) {
                //target <和=都判断过了a[mid] 那么下次结束的位置应该越过end到mid的前一个位置
                return search(start, mid - 1, target, a);
            }
        }

        return -1;
    }
}
