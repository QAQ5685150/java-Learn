package com.cn.Algorithm.array.priorityQueue;

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
//        int k = inputUtils.getInt();
//        int w = inputUtils.getInt();
//        int[] profits = inputUtils.getArr();
//        int[] capital = inputUtils.getArr();
        int maximizedCapital = findMaximizedCapital_review(2, 0, new int[]{1,2,3},new int[]{0,1,1});
        System.out.println(maximizedCapital);
    }


    public static int findMaximizedCapital_review(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>( (a,b) -> {
            return b[0] - a[0];
        });

        int[][] collection = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            collection[i][0] = profits[i];
            collection[i][1] = capital[i];
        }
        //Ҫ���ʱ��������� ��С����
        Arrays.sort(collection,(a,b) -> a[1] - b[1]);
        //��index��ʾ�����±���������k��ʾÿһ��ѭ���Ĵ�����k����������ͬʱ�����������Ŀ��
        //iѭ�����ٴξ��ǲ����˶��ٸ���Ŀ����Ϊÿ��ѭ�������while������з��ϵ���Ŀ����pq,���öѵ�����ȡ��ÿһ����������
        //ȡ����i�Σ������Ƕ�i<kѭ��
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (index < profits.length && collection[index][1] <= w){
                pq.add(collection[index++]);
            }
            if(!pq.isEmpty()){
                w += pq.poll()[0];
            }else {
                break;
            }
        }
        return w;
    }

}
