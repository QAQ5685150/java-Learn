package com.cn.Algorithm.array.sort.nlogn;

import com.cn.Algorithm.util.printUtils;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-02-07 11:34
 * @Description: 快排 利用递归选数到最终位置上，从上到下递归排序
 * @Project_name: java-learn
 */
public class quickSort {

    /**
     * 先找到一个基准，以基准中心交换左右两边的数，左边都比基准小，右边都比基准大，i和j相交就与基准互换位置，完成第一遍排序
     * 然后递归的分别对基准左侧和右侧继续进行快排，二分的思想
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }

    public static void main(String[] args) {
        int[] test = new int[]{9, 4, 6, 5, 1, 3, 2, 7, 6, 4};
        int[] test1 = new int[]{1, 3, 5, 5, 2};
//        quickSort_review(test,0,test.length - 1);
//        printUtils.printArray(test);
        System.out.println(findKth(test1, test.length - 1, 3));
        printUtils.printArray(test1);
    }

    public static int findKth(int[] a, int n, int K) {
        // write code here
        quickSort1(a, 0, a.length - 1);
        return a[K - 1];
    }

    public static void quickSort1(int[] arr, int i, int j) {
        if (i > j) return;
        int l = i;
        int r = j;
        int start = arr[i];
        while (l < r) {
            while (r > l && arr[r] >= start) r--;
            while (l < r && arr[l] <= start) l++;
            if (l < r) swap(arr, l, r);
        }
        arr[i] = arr[l];
        arr[l] = start;
        quickSort1(arr, i, r - 1);
        quickSort1(arr, r + 1, j);
    }

    /**
     * quicksort review
     * 每一步的交换策略忘记了
     * 首先找到基准，用一个参数接受，while循环，左边i指针往右找到比基准大的，停止
     * 右边j往左找到比基准下小的，停止
     * 交换i j位置，继续while直到i=j
     * 退出循环后，交换i位置和当前基准tmp
     * 交换完成后，进入下一次循环，对i = j的左边和右边分别递归该过程，直到完成排序
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort2(int[] arr, int low, int high) {
        int i, j, tmp, t;
        if (low > high) {
            return;
        }

        i = low;
        j = high;
        tmp = arr[low];

        while (i < j) {
            while (tmp <= arr[j] && i < j) {
                j--;
            }
            while (tmp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        arr[low] = arr[i];
        arr[i] = tmp;

        quickSort2(arr, low, j - 1);
        quickSort2(arr, j + 1, high);

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort_review(int[] arr, int low, int high) {
        if (low > high) return;
        int start = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            //右指针先动 左指针再动
            while (arr[j] >= start && i < j) {
                j--;
            }
            while (arr[i] <= start && i < j) {
                i++;
            }
            if (i < j) swap(arr, i, j);
        }
        arr[low] = arr[i];
        arr[i] = start;
        quickSort_review(arr, 0, j - 1);
        quickSort_review(arr, j + 1, high);
    }

    public static int leetcode_215(int[] arr, int k){
        return qSelect(arr,0,arr.length - 1, k);
    }

    public static int qSelect(int[] arr, int l, int r, int k){
        if(l == r) return arr[k];
        int p1 = l;
        int p2 = r;
        int cur = arr[p1];
        while (p1 < p2){
            while (arr[p2] > cur){
                p2--;
            }
            while (arr[p1] < cur){
                p1++;
            }
            if(p1 < p2) swap(arr,p1,p2);
        }
        if(k < p2) return qSelect(arr,l,p2,k);
        else return qSelect(arr,p2,r,k);
    }

}
