package com.cn.Algorithm.array.sort.nlogn;

import com.cn.Algorithm.util.printUtils;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-02-07 11:34
 * @Description: ���� ���õݹ�ѡ��������λ���ϣ����ϵ��µݹ�����
 * @Project_name: java-learn
 */
public class quickSort {

    /**
     * ���ҵ�һ����׼���Ի�׼���Ľ����������ߵ�������߶��Ȼ�׼С���ұ߶��Ȼ�׼��i��j�ཻ�����׼����λ�ã���ɵ�һ������
     * Ȼ��ݹ�ķֱ�Ի�׼�����Ҳ�������п��ţ����ֵ�˼��
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
        //temp���ǻ�׼λ
        temp = arr[low];

        while (i < j) {
            //�ȿ��ұߣ���������ݼ�
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //�ٿ���ߣ��������ҵ���
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //������������򽻻�
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //��󽫻�׼Ϊ��i��j���λ�õ����ֽ���
        arr[low] = arr[i];
        arr[i] = temp;
        //�ݹ�����������
        quickSort(arr, low, j - 1);
        //�ݹ�����Ұ�����
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
     * ÿһ���Ľ�������������
     * �����ҵ���׼����һ���������ܣ�whileѭ�������iָ�������ҵ��Ȼ�׼��ģ�ֹͣ
     * �ұ�j�����ҵ��Ȼ�׼��С�ģ�ֹͣ
     * ����i jλ�ã�����whileֱ��i=j
     * �˳�ѭ���󣬽���iλ�ú͵�ǰ��׼tmp
     * ������ɺ󣬽�����һ��ѭ������i = j����ߺ��ұ߷ֱ�ݹ�ù��̣�ֱ���������
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
            //��ָ���ȶ� ��ָ���ٶ�
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
