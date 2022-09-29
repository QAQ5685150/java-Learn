package com.cn.Algorithm.array.partition;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.array.partition
 * @Time: 2022-09-29 15:49
 * @Description: 笔试题 外卖送餐能力
 **/
public class sendFood {
    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(partition(test,3));
        for (int i = 1; i <= 10; i++) {
            System.out.println(partition_find(test,i));
        }

    }

    public static int partition(int[] arr, int h){
        int l = 0;
        int r = Integer.MAX_VALUE;
        while (l < r){
            int mid = l + ((r - l) >> 1);
            if(check(arr,h,mid)){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static boolean check(int[] arr, int h, int threshold){
        int times = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(sum + arr[i] > threshold){
                sum = 0;
                times++;
            }
            sum += arr[i];
        }
        if(sum != 0) times++;
        return times <= h;
    }

    /**
     * 基础二分 数组中查找数据
     * 要么我就三个条件判断  要么我两个条件 >= expect时r = mid <时 l = mid + 1 最后l就是答案
     * @param test
     * @return
     */
    public static int partition_find(int[] test, int expect){
        int l = 0;
        int r = test.length - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if(test[mid] > expect){
                r = mid - 1;
            }else if(test[mid] < expect){
                l = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
