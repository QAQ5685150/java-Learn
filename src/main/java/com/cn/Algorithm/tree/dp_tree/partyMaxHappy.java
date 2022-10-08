package com.cn.Algorithm.tree.dp_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-10-02 11:32
 * @Description: TODO
 * @Project_name: java-learn
 */
public class partyMaxHappy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int v = Integer.parseInt(s[1]);
        HashMap<Integer, employee> map = new HashMap<>();

        String[] ss = sc.nextLine().split(" ");
        int[] happy = new int[n];
        for (int i = 0; i < n; i++) {
            happy[i] = Integer.valueOf(ss[i]);
        }
        employee boss = new employee(happy[0],new ArrayList<>());
        map.put(v,boss);
        for (int i = 0; i < n - 1; i++) {
            String[] s1 = sc.nextLine().split(" ");
            Integer i1 = Integer.valueOf(s1[0]);
            Integer i2 = Integer.valueOf(s1[1]);
            employee cur = map.get(i1);
            employee sub = new employee(happy[i2 - 1],new ArrayList<>());
            cur.sub.add(sub);
            map.put(i2,sub);
        }
        System.out.println(partyMaxHappy(boss));
    }

    public static int partyMaxHappy(employee e){
        info cur = process(e);
        return Math.max(cur.yes, cur.no);
    }

    public static info process(employee e){
        if(e.sub.isEmpty()){
            return new info(e.v,0);
        }
        int no = 0;
        int yes = e.v;
        for (employee employee : e.sub) {
            info sub = process(employee);
            yes += sub.no;
            no += Math.max(sub.no, sub.yes);
        }
        return new info(yes,no);
    }

    static class employee{
        int v;
        List<employee> sub;

        public employee(int v, List<employee> sub) {
            this.v = v;
            this.sub = sub;
        }
    }

    static class info{
        int yes;
        int no;

        public info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }
}
//        5
//    4       7
//2   2   2       23 34