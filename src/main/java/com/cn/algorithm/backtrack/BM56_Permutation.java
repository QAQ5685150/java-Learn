package com.cn.algorithm.backtrack;

import java.util.*;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.backtrack
 * @Time: 2022-09-01 16:23
 * @Description: TODO
 **/
public class BM56_Permutation {

    //1:swap char to permutation the string
    HashSet<String> set = new HashSet<>();

    public ArrayList<String> Permutation1(String str) {
        // write code here
        process(str.toCharArray(), str.length(), 0);
        return new ArrayList<>(set);
    }

    public void process(char[] c, int len, int index) {
        if (len == index) {
            set.add(new String(c));
            return;
        }
        for (int i = index; i < len; i++) {
            swap(c, i, index);
            process(c, len, index + 1);
            swap(c, index, i);
        }
    }

    public void swap(char[] c, int i, int j) {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    //2:permutation the string with boolean[]
    public static void Permutation2(String s) {
        Set<String> res = new HashSet<>();
        backtrack(s.toCharArray(), "", new boolean[s.length()], res);
        Iterator<String> iterator = res.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.print(next + " ");
        }
    }

    private static void backtrack(char[] chars, String temp, boolean[] visited, Set<String> res) {
        //�߽������жϣ���ѡ����ַ����ȵ���ԭ�ַ������ȵ�ʱ��˵��ԭ�ַ������ַ����Ѿ�
        //ѡ����
        if (temp.length() == chars.length) {
            res.add(temp);
            return;
        }
        //ÿһ���ڵ����Ƕ�Ҫ��ͷ��ʼѡ
        for (int i = 0; i < chars.length; i++) {
            //�Ѿ�ѡ����ľͲ�����ѡ��
            if (visited[i])
                continue;
            //��ʾѡ��ǰ�ַ�
            visited[i] = true;
            //�ѵ�ǰ�ַ�ѡ��󣬵�������һ�����ѡ
            backtrack(chars, temp + chars[i], visited, res);
            //�ݹ������ߵ�ʱ��Ҫ����ѡ��
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutation2("acb");
    }
}
