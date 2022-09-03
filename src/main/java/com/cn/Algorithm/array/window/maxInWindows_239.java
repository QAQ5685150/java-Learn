package com.cn.Algorithm.array.window;

import java.util.*;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-04-01 11:56
 * @Description: TODO
 * @Project_name: java-learn
 */
public class maxInWindows_239 {

    public static void main(String[] args) {
        int[] test= new int[]{2,3,4,2,6,2,5,1};
        for (Integer maxInWindow : maxInWindows(test, 3)) {
            System.out.print(maxInWindow + " ");
        }
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(size == 0 || size>num.length || num.length == 0){
            return list;
        }

        LinkedList<Integer> qmax = new LinkedList<Integer>();
        //int w = 0;
        for(int i=0;i<num.length;i++){
            while(!qmax.isEmpty() && num[qmax.peekLast()]<=num[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() == i - size){// �ж϶��е�ͷ�����±��Ƿ����
                qmax.pollFirst();
            }
            if(i>=size-1){//�ж��Ƿ��γ��˴���
                list.add(num[qmax.peekFirst()]);
            }
        }
        return list;
    }


    public static ArrayList<Integer> maxInWindows_review(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();

        LinkedList<Integer> qmax = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
            //��qmax˫�˶��У���˫�˶���Ϊ�˷���ʵ�ִ��ڵĽ���������ά����һ������
            //�������£�forѭ��nums[i] ��ǰ���ʹ��������һ�����Ƚϣ����û���µ����󣬾��Ƴ��������һ����
            //ֱ������Ϊ�գ�Ȼ�������һ������
            //��������Ϊ�������ֵʼ���ڴ��ڵĵ�һ��λ�ã�����ֱ��ȡfirst�Ϳ����õ����ֵ���±�
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            //ά�����ڵ������������Ƴ� ��i - size���ǵ�ǰ��������˿����õ�����С���Ǹ�����������±���ȣ��͸��´���
            if(qmax.peekFirst() == i - size){
                qmax.pollFirst();
            }
            if(i >= size - 1){//ÿһ���ƶ����ڣ����´��ڵ����ֵ������ĸ�����ÿ�ƶ�һ�ξ͸���һ�δ��ڵ����ֵ
                //��������ֻҪ���ڴ���size���͸��µ��������ֵ������
                list.add(num[qmax.peekFirst()]);
            }
        }
        return list;
    }
}
