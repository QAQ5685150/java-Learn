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
        quickSort2(test,0,test.length - 1);
        printUtils.printArray(test);
    }

    /**
     * quicksort review
     * 每一步的交换策略忘记了
     * 首先找到基准，用一个参数接受，while循环，左边i指针往右找到比基准大的，停止
     * 右边j往左找到比基准下小的，停止
     * 交换i j位置，继续while直到i=j
     * 退出循环后，交换i位置和当前基准tmp
     * 交换完成后，进入下一次循环，对i = j的左边和右边分别递归该过程，直到完成排序
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort2(int[] arr, int low, int high){
        int i,j,tmp,t;
        if(low > high){
            return;
        }

        i = low;
        j = high;
        tmp = arr[low];

        while (i < j){
            while (tmp <= arr[j] && i < j){
                j--;
            }
            while (tmp >= arr[i] && i < j){
                i++;
            }
            if(i < j){
                swap(arr,i,j);
            }
        }
        arr[low] = arr[i];
        arr[i] = tmp;

        quickSort2(arr,low,j - 1);
        quickSort2(arr,j + 1,high);

    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
