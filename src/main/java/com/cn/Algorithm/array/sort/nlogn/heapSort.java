package com.cn.Algorithm.array.sort.nlogn;

import com.cn.Algorithm.util.printUtils;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-02-07 11:35
 * @Description: ������
 * @Project_name: java-learn
 */
public class heapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) /2);
            index = (index - 1)/2 ;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{9,4,6,5,1,3,2,7,6,4};
        //heapSort(test);
        //printUtils.printArray(test);
        heapSort_review(test);
    }

    public static int[] heapSort_review(int[] arr){
        if(arr.length < 2 || arr == null){
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert_review(arr,i);
        }
        printUtils.printArray(arr);
        System.out.println();

        int size = arr.length;

        swap(arr,0,--size);
        while (size > 0){
            heapify_review(arr,0,size);
            swap(arr,0,--size);
        }
        printUtils.printArray(arr);
        return arr;
    }

    public static void heapInsert_review(int[] arr,int index){
        while (arr[(index - 1) / 2] < arr[index]){
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify_review(int[] arr,int index,int size){
        int left = index * 2 + 1;
        while (left < size){
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

}
