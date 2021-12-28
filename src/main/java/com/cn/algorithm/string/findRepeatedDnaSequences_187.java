package com.cn.algorithm.string;

import java.util.*;

/**
 * 类名:findRepeatedDnaSequences_187
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-10-08 10:09
 **/
public class findRepeatedDnaSequences_187 {

    /**
     * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
     *
     * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
     *
     * （长为10的子串在原串中出现次数超过10）
    **/
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
