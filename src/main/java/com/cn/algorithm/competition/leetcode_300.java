package com.cn.algorithm.competition;

import com.cn.algorithm.dataStructure.LinkedList.ListNode;

import java.util.*;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.competition
 * @Time: 2022-07-06 13:20
 **/
public class leetcode_300 {
    public static void main(String[] args) {
//        Character c = 'a';
//        c++;
//        System.out.println(c);
//        decodeMessage("the quick brown fox jumps over the lazy dog","vkbs bs t suepuv");

//        List<Integer> list = new ArrayList<>();
//        Collections.addAll(list,3,0,2,6,8,1,7,9,4,2,5,5,0);
//        spiralMatrix(3,5,ListNode.getNode(list));

        System.out.println(peopleAwareOfSecret(7, 1, 3));

    }

    public static String decodeMessage(String key, String message){
        char[] chars = new char[26];
        int index = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < key.length(); i++) {
            if(index < 26 && key.charAt(i) != ' ' && !set.contains(key.charAt(i))){
                chars[index++] = key.charAt(i);
                set.add(key.charAt(i));
            }
        }
        HashMap<Character,Character> map = new HashMap<>();
        Character c = 'a';
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],c++);
        }
        StringBuilder sb = new StringBuilder();
        for (char c1 : message.toCharArray()) {
            if(c1 != ' '){
                sb.append(map.get(c1));
            }else {
                sb.append(' ');
            }

        }
        return sb.toString();
    }


    /**
     * 矩阵位置关系题没练过 不太会……
     * @param m
     * @param n
     * @param head
     * @return
     */
    public static int[][] spiralMatrix(int m, int n, ListNode head){
        int i = 0;
        int j = 0;
        int[][] ans = new int[m][n];
        while (m != 0 && n != 0){
            while (j < n){
                ans[i][j] = head == null ? -1 : head.val;
                head = head.next;
                j++;
            }
            i++;
            j--;
            while (i < m){
                ans[i][j] = head == null ? -1 : head.val;
                head = head.next;
                i++;
            }
            i--;
            j--;
            n--;
            m--;
            while (j >= 0){
                ans[i][j] = head == null ? -1 : head.val;
                head = head.next;
                j--;
            }
            m--;
            while (i >= 0){
                ans[i][j] = head == null ? -1 : head.val;
                head = head.next;
                i--;
            }
            n--;
        }
        return null;
    }

    public int[][] spiralMatrix2(int m, int n, ListNode head) {
        /*
        一个模拟的万能转向trick(参考灵神)
         */
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);//全部赋值-1 链表断链就可以作为退出条件 后面不用再转向
        }
        ListNode cur = head;
        // 上右下左四个进给方向
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // idx为进给方向,x与y是遍历指针
        int idx = 0, x = 0, y = -1; // 为了进给第一步向右走了之后才赋值,初始化(x,y)=(0.-1)
        // 链表还没走完就继续循环
        while (cur != null) {
            int newX = x + dirs[idx][0], newY = y + dirs[idx][1];
            // 越界或者碰到已经覆盖过的->转向
            if (newX < 0 || newX >= m || newY < 0 || newY >= n || res[newX][newY] != -1) idx = (idx + 1) % 4;
            x += dirs[idx][0];
            y += dirs[idx][1];
            res[x][y] = cur.val;
            cur = cur.next;
        }
        return res;
    }

    static int MOD = (int)1e9 + 7;
    /**
     *
     * @param n
     * @param delay
     * @param forget
     * @return
     */
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
//        int sum = 1;
//        int people = 1;
//
//        for (int i = 1; i <= n; i++) {
//            if(i != 1 && (i + delay) % delay == 1){
//                sum += people;
//                people++;
//            }
//            if(i != 1 && (i + forget) % forget == 1){
//                sum--;
//                people--;
//            }
//        }
//        return sum % 1000000007;
        int[] f = new int[n];
        f[0] = 1;
        int cntB = 0;
        for (int i = 0; i < n; ++i) {
            if (i + delay >= n) cntB = (cntB + f[i]) % MOD;
            for (int j = i + delay; j < Math.min(i + forget, n); ++j)
                f[j] = (f[j] + f[i]) % MOD;
        }
        return (f[n - 1] + cntB) % MOD;
    }
}
