package com.cn.Algorithm.string;

import com.cn.Algorithm.util.printUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.string
 * @Time: 2022-09-27 11:27
 * @Description: TODO
 **/
public class partition_131 {

    public static void main(String[] args) {
        List<List<String>> aab = partition_back("aabb");
        printUtils.printArray(aab);

    }

    public static List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        String[] split = s.split("");
        List<String> splits = new ArrayList<>();
        for (String s1 : split) {
            splits.add(s1);
        }
        res.add(splits);
        for (int i = 0; i < len; i++) {
            String first = s.substring(0, i);
            String last = s.substring(i, len);
            ArrayList<String> cur = new ArrayList<>();
            if (checkString(first) && checkString(last)) {
                cur.add(first);
                cur.add(last);
                res.add(cur);
            }
        }
        return res;
    }

    public static boolean checkString(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    static List<List<String>> list = new ArrayList<>();

    public static List<List<String>> partition_back(String s) {
        process(s.toCharArray(), new ArrayList<String>(), 0);
        return list;
    }

    public static void process(char[] c, ArrayList<String> path, int n) {
        if (n == c.length) {
            //����ֱ�����path�������Ϊ��
            //��Ϊlist.add(path)��һ�����õ�ַ���ݹ�Ҫ��path�������ݹ鵽���pathΪ�գ��ʹ�ӡΪ��
            //ʹ����һ�����ϱ���path��ĩβλ�õ�ֵ�����ǿ��Ե�
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = n; i < c.length; i++) {
            if (check(c, n, i)) {
                path.add(new String(c, n, i - n + 1));
                //�������µݹ��i��ʼ ����Ŀ���Կ���ÿ�δӵ�ǰλ�����µݹ�
                //һ������n��һ������i i��nλ�ÿ�ʼ�����Ǵӵ�ǰѭ��iλ�����µݹ��
                process(c, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public static boolean check(char[] s, int i, int j) {
        while (i < j) {
            if (s[i++] != s[j--]) {
                return false;
            }
        }
        return true;
    }

    class Solution {

        //����һ��ȫ�ֱ���ans
        List<List<String>> ans = new ArrayList<>();

        //������
        public List<List<String>> partition(String s) {
            backtrack(s.toCharArray(), 0, new ArrayList());
            return ans;
        }

        //���ݷ���
        void backtrack(char[] s, int startIndex, List<String> path) {
            //��startIndexԽ��ʱ����
            if (startIndex == s.length) {
                //����ǰpath��ӵ�ans�У�ע�⣺��Ҫ����һ��ArrayList
                ans.add(new ArrayList(path));
                return;
            }
            //��startIndex��ʼö��
            for (int i = startIndex; i < s.length; i++) {
                if (check(s, startIndex, i)) {
                    //��startIndex��i����ǻ��Ĵ����򽫴˴�����path�������µݹ�
                    path.add(new String(s, startIndex, i - startIndex + 1));
                    backtrack(s, i + 1, path);
                    //�ݹ���Ϻ󣬼ǵý��˴���path��ɾ�������ǻ����㷨�Ĺؼ�����
                    path.remove(path.size() - 1);
                }
            }
        }

        //�����������жϴ�start��end�Ƿ����
        boolean check(char[] s, int start, int end) {
            while (start <= end) {
                if (s[start++] != s[end--]) {
                    return false;
                }
            }
            return true;
        }
    }
}
