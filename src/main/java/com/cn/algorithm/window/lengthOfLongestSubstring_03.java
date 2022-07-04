package com.cn.algorithm.window;

import java.util.*;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-03-30 10:28
 * @Description: TODO
 * @Project_name: java-learn
 */
public class lengthOfLongestSubstring_03 {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcddabcdef"));

        //System.out.println(lengthOfLongestSubstring_review("bbbbbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
//        HashSet<Character> set = new HashSet<>();
//        int index = 0;
//        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            //�տ�ʼ���õ���set���Ƿ�����ж���ߵĴ����Ƿ�Ҫ�ƶ��������ֻҪi��=0 ѭ��һ�������
//            //Ҳ����⣬�����whileֻҪ�˳�����˵��setά���Ĵ������ظ����ݣ���Ҫ�ƶ��ˣ�����Ҫ�ж��Ƿ����������ƶ��󴰿�
//            if(i != 0){
//                set.remove(s.charAt(i - 1));
//            }
//            while (index < s.length() && !set.contains(s.charAt(index))){
//                set.add(s.charAt(index));
//                index++;
//                max = Math.max(max,index - i);
//            }
//
//        }
//        return max;
        HashSet<Character> set = new HashSet<>();
        char[] c = s.toCharArray();
        int max = 0;
        int index = 0;
        for(int i = 0;i < c.length; i++){
            if(i != 0){
                set.remove(c[i - 1]);
            }
            while(index < c.length && !set.contains(c[index])){
                set.add(c[index]);
                index++;
                max = Math.max(max,index - i);
            }
        }
        return max;
    }


    public static int lengthOfLongestSubstring_review(String s) {
        Deque<Character> que = new ArrayDeque<>();
        int max = 0;
        for (char c : s.toCharArray()) {
            while (que.contains(c)){
                que.pop();
            }
            que.offer(c);
            max = Math.max(que.size(),max);
        }
        return max;
    }
}
