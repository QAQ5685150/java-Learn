package com.cn.Algorithm.algoritmBook.niuke;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.algoritmBook.niuke
 * @Time: 2022-09-01 17:13
 * @Description: TODO
 **/
public class huazi_moni {

    public static void  main(String[] args) throws IOException {
        //test01();
        //test02();
        test04();
    }

    private static void test04(){
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> map = new HashMap<>();

        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] split = s.split("\\\\");
            String key = split[split.length - 1];
            if(key.length() >= 16){
                key = key.substring(key.length() - 16);
            }
            map.put(key,map.getOrDefault(key,0) + 1);
        }
        map.entrySet().stream().sorted((k,v) -> v.getValue() - k.getValue());
        map.forEach((k,v) -> System.out.println(k + " " + v));
    }

    private static void test03() {
        Scanner sc = new Scanner(System.in);
        HashMap<Character,Integer> map = new HashMap<>();
        map.put(null,3);
        char c = 'A';int val = 10;
        for (int i = 0; i < 6; i++) {
            map.put(c++,val++);
        }
        String s = sc.nextLine().substring(2);
        int res = 0;
        int index = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c1 = s.charAt(i);
            int cur;
            if(Character.isDigit(c1)){
                cur = c1 - '0';
            }else {
                cur = map.get(c1);
            }
            res += cur * ((int) Math.pow(16,index++));
        }
        System.out.println(res);
        System.out.println(Integer.parseInt(s, 16));
    }

    private static void test02() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[500];
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            arr[val] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) System.out.println(i);
        }
    }

    /**
     * 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
     * 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
     */
    private static void test01() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            if(n == 0) break;
            int res = n % 3 == 0 ? 0 : 1;
            while(n > 2){
                int cur = n / 3;
                n %= 3;
                res += cur;
                n += cur;
            }
            System.out.println(res);
        }

    }
}
// 20 - 6 -> 8 - 3 -> 3 - 1