package com.cn.Algorithm.design;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.design
 * @Time: 2022-07-11 14:12
 **/
public class MagicDictionary_676 {
    static HashMap<String,Integer> map;

    public MagicDictionary_676() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            map.put(s,s.length());
        }
    }

    public boolean search(String searchWord) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            if(value == searchWord.length()){
                boolean replaceable = isReplaceable(key, searchWord);
                if (replaceable) return true;
            }
        }
        return false;
    }

    public boolean isReplaceable(String s1, String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars1.length; i++) {
            if(chars1[i] != chars2[i]){
                sum++;
            }
        }
        return sum == 1;
    }

    public static void main(String[] args) {
        MagicDictionary_676 m = new MagicDictionary_676();
        m.buildDict(new String[]{"hello","leet"});
        System.out.println(m.search("hallo"));
        System.out.println(m.search("hello"));
        System.out.println(m.search("hell"));
        System.out.println(m.search("leer"));
    }
}
