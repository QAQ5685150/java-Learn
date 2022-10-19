package com.cn.Algorithm.array.partition;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.array.partition
 * @Time: 2022-10-19 14:18
 * @Description: TODO
 **/
public class recursion {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,4,5,6,7,8};
        System.out.println(search(0,test.length - 1,7,test));
        System.out.println(partition(test,0,test.length - 1,7));
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


    public static int search(int start,int end,int target,int a[]){
        if(start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (target > a[mid]) {
                //target >��=���жϹ���a[mid] ��ô�´ο�ʼ��λ��Ӧ��Խ��mid�ĺ�һ��λ��
                return search(mid + 1, end, target, a);
            } else if (target < a[mid]) {
                //target <��=���жϹ���a[mid] ��ô�´ν�����λ��Ӧ��Խ��end��mid��ǰһ��λ��
                return search(start, mid - 1, target, a);
            }
        }

        return -1;
    }
}
