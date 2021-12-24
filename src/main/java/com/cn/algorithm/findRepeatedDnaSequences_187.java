package com.cn.algorithm;

import java.util.*;

/**
 * 类名:findRepeatedDnaSequences_187
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-10-08 10:09
 **/
public class findRepeatedDnaSequences_187 {

    public static void main(String[] args) {
        String test = "AAAAAAAAAAA";
        findRepeatedDnaSequences(test).forEach(arr -> System.out.print(arr + " "));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
        List<String> ans = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length() - 9; i++){
            String substring = s.substring(i, i + 10);
            map.put(substring,map.getOrDefault(substring,0) + 1);
        }
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            if(next.getValue() >= 2){
                ans.add(next.getKey());
            }
        }
        return ans;
    }
}
