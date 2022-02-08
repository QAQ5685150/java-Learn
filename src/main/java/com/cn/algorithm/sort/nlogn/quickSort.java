package com.cn.algorithm.sort.nlogn;

import com.cn.algorithm.util.printUtils;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-02-07 11:34
 * @Description: 快排
 * @Project_name: java-learn
 */
public class quickSort {

    /**
     * 先找到一个基准，以基准中心交换左右两边的数，左边都比基准小，右边都比基准大，i和j相交就与基准互换位置，完成第一遍排序
     * 然后递归的分别对基准左侧和右侧继续进行快排，二分的思想
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }

    public static void main(String[] args) {
        int[] test = new int[]{9,4,6,5,1,3,2,7,6,4};
        quickSort(test,0,test.length - 1);
        printUtils.printArray(test);
    }
}
