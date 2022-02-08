package com.cn.algorithm.sort.nlogn;

import com.cn.algorithm.util.printUtils;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-02-07 11:34
 * @Description: ����
 * @Project_name: java-learn
 */
public class quickSort {

    /**
     * ���ҵ�һ����׼���Ի�׼���Ľ����������ߵ�������߶��Ȼ�׼С���ұ߶��Ȼ�׼��i��j�ཻ�����׼����λ�ã���ɵ�һ������
     * Ȼ��ݹ�ķֱ�Ի�׼�����Ҳ�������п��ţ����ֵ�˼��
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
        //temp���ǻ�׼λ
        temp = arr[low];

        while (i<j) {
            //�ȿ��ұߣ���������ݼ�
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //�ٿ���ߣ��������ҵ���
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //������������򽻻�
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //��󽫻�׼Ϊ��i��j���λ�õ����ֽ���
        arr[low] = arr[i];
        arr[i] = temp;
        //�ݹ�����������
        quickSort(arr, low, j-1);
        //�ݹ�����Ұ�����
        quickSort(arr, j+1, high);
    }

    public static void main(String[] args) {
        int[] test = new int[]{9,4,6,5,1,3,2,7,6,4};
        quickSort(test,0,test.length - 1);
        printUtils.printArray(test);
    }
}
