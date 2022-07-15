package com.cn.algorithm.search.bfs;

import java.util.*;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-04-06 9:25
 * @Description: TODO
 * @Project_name: java-learn
 */
public class findMinHeightTrees_310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        /*���ֻ��һ���ڵ㣬��ô��������С�߶���*/
        if (n == 1) {
            res.add(0);
            return res;
        }
        /*���������ڵ�ĳ��ȱ�*/
        int[] degree = new int[n];
        /*����ͼ��ϵ����ÿ���ڵ��list�д洢�����ڵ�*/
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;/*����++*/
            map.get(edge[0]).add(edge[1]);/*������ڽڵ�*/
            map.get(edge[1]).add(edge[0]);
        }
        /*��������*/
        Queue<Integer> queue = new LinkedList<>();
        /*�����г���Ϊ1�Ľڵ㣬Ҳ����Ҷ�ӽڵ����*/
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }
        /*ѭ��������Ȼ�Ǿ���Ĳ����ж�*/
        while (!queue.isEmpty()) {
            res = new ArrayList<>();/*����ط�ע�⣬����ÿ��ѭ����Ҫnewһ���µĽ�����ϣ�
            ������󱣴�ľ������յ���С�߶�����*/
            int size = queue.size();/*����ÿһ��Ľڵ������*/
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);/*�ѵ�ǰ�ڵ������������Ҫ�����ʣ�Ϊʲô��ǰֻ��Ҷ�ӽڵ�ΪʲôҪ����������?
                ��Ϊ����ÿ��ѭ�������½�һ��list��������󱣴�ľ������һ��״̬�µ�Ҷ�ӽڵ㣬
                ��Ҳ�Ǻܶ����������˵�ļ���Ҷ�ӽڵ�Ĳ��֣����������һ��ͼ��ÿ������꣬
                ����Ѹò㣨Ҳ����Ҷ�ӽڵ�㣩��һ��Ӷ������Ƴ�����
                �����൱�ڰ�ԭ����ͼ������һȦҶ�ӽڵ㣬�γ�һ����С���µ�ͼ��*/
                List<Integer> neighbors = map.get(cur);
                /*������Ǿ����bfs�ˣ��ѵ�ǰ�ڵ�����ڽӵ㶼�ó�����
                 * �����ǵĳ��ȶ���1����Ϊ��ǰ�ڵ��Ѿ��������ˣ����ԣ�
                 * �������ڽڵ��Ǿ��п��ܱ��Ҷ�ӽڵ�*/
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        /*�����Ҷ�ӽڵ����Ǿ����*/
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;/*�������һ�α����list*/
    }

}
