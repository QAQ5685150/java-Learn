package com.cn.algorithm.array;

import com.cn.algorithm.util.inputUtils;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-02-06 23:11
 * @Description: TODO
 * @Project_name: java-learn
 */
public class IPO_502 {

    /**
     * ���� n ����Ŀ������ÿ����Ŀ i ��������һ�������� profits[i] ������������Ŀ��Ҫ����С�ʱ� capital[i] ��
     *
     * ���������ʱ�Ϊ w ���������һ����Ŀʱ���㽫��ô����������󽫱���ӵ�������ʱ��С�
     *
     * �ܶ���֮���Ӹ�����Ŀ��ѡ�� ��� k ����ͬ��Ŀ���б��� ��������ʱ� ����������տɻ�õ�����ʱ���
     */
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr,(a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y - x);
        int index = 0;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            while (index < len && arr[index][0] <= w){
                pq.add(arr[index][1]);
                index++;
            }
            if(!pq.isEmpty()){
                w += pq.poll();
            }else {
                break;
            }
        }
        return w;
    }

    public static void main(String[] args) {
        int k = inputUtils.getInt();
        int w = inputUtils.getInt();
        int[] profits = inputUtils.getArr();
        int[] capital = inputUtils.getArr();
        int maximizedCapital = findMaximizedCapital(k, w, profits, capital);
        System.out.println(maximizedCapital);
    }

}
