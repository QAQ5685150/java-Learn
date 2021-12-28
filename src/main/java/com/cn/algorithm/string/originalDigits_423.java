package com.cn.algorithm.string;

import java.util.*;

/**
 * 类名:originalDigits_423
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-24 14:11
 **/
public class originalDigits_423 {

    private static String[] stringss = new String[]{"zero", "six", "eight", "two", "seven", "five", "four", "three", "one", "nine"};

    /**
     * 功能描述:我的第一想法，所有单词放到map里，对每个字符遍历map的每个单词计数，实际证明这样只能解顺序的
     * @param s
     * @return java.lang.String
     **/
    public static String originalDigits1(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String ss : stringss) {
            map.put(ss, ss.length());
        }
        HashMap<String, Integer> map1 = new HashMap<>(map);

        for (int i = 0; i < s.length(); i++) {
            Set<String> strings = map1.keySet();
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                if (next.contains(s.substring(i, i + 1))) {
                    map1.put(next, map1.get(next) - 1);
                    if (map1.get(next) == 0) {
                        for (int j = 0; j < stringss.length; j++) {
                            if (next.equals(stringss[j])) {
                                sb.append(String.valueOf(j));
                            }
                        }
                        map1.put(next, next.length());
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 功能描述:依次确定每一个数字的次数
     * @param s
     * @return java.lang.String
     **/
    public static String originalDigits(String s) {
        int[] arr = new int[27];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            arr[aChar - 'a']++;
        }

        List<Character> characters = Arrays.asList('z', 'w', 'u', 'x', 'g');
        int[] ans = new int[10];
        int index = 0;
        for (int i = 0; i < 9; i += 2) {
            ans[i] += arr[characters.get(index++) - 'a'];
        }

        ans[3] = arr['h' - 'a'] - ans[8];
        ans[5] = arr['f' - 'a'] - ans[4];
        ans[7] = arr['v' - 'a'] - ans[5];
        ans[9] = arr['i' - 'a'] - ans[5] - ans[6] - ans[8];
        ans[1] = arr['n' - 'a'] - ans[7] - ans[9] * 2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < ans[i]; j++) {
                sb.append(String.valueOf(i));
            }
        }
        return sb.toString();
    }


    /**
     * 功能描述:给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
     * 
     * 输入：s = "owoztneoer"
     * 输出："012"
     * 
     * 输入：s = "fviefuro"
     * 输出："45"
     **/
    public static void main(String[] args) {
        String s = "fveieifugtrho";
        System.out.println(originalDigits(s));

    }
}
