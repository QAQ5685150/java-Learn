package com.cn.algorithm;

import java.util.*;

/**
 * 类名:wordBreak_139
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-06 17:26
 **/
public class wordBreak_139 {

    static class Trie {
        //int[] tries = new int[26]; new ints[]是创建数组，数组每个位置保存一个int数字
        //new Trie[26] 是创建Trie结构数组，每个位置保存一个Trie对象，才是构建出一个树的结构出来
        private Trie[] node;
        private boolean isEnd;

        public Trie() {
            node = new Trie[26];
            isEnd = false;
        }

        public void insert(String s) {
            Trie node = this;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int index = c - 'a';
                if (node.node[index] == null) {
                    node.node[index] = new Trie();
                }
                node = node.node[index];
            }
            node.isEnd = true;
        }

        public boolean search(String s){
            Trie trie = find(s);
            return trie != null && trie.isEnd == true;
        }

        public Trie find(String prefix){
            Trie node = this;
            char[] chars = prefix.toCharArray();
            for (int i = 0; i < prefix.length(); i++) {
                int temp = chars[i] - 'a';
                if(node.node[temp] == null){
                    return null;
                }
                node = node.node[temp];
            }
            return node;
        }
    }

    public static boolean wordBreakByTrie(String s, List<String> wordDict){
        Trie trie = new Trie();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i < wordDict.size(); i++){
            trie.insert(wordDict.get(i));
        }
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && trie.search(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }




    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        Collections.addAll(wordDict,"a","b","bbb","bbbb");
        String test = "bb";
//        HashSet<String> set = new HashSet<>();
//        for(int i = 0;i < wordDict.size(); i++){
//            set.add(wordDict.get(i));
//        }
//        System.out.println(dfs(0,test.length(),set,test));
        //System.out.println(dp(test,wordDict));

        System.out.println(wordBreakByTrie(test, wordDict));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i < wordDict.size(); i++){
            set.add(wordDict.get(i));
        }
        int index = 0;
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        while (index < s.length()){
            sb.append(s.charAt(index));
            if(set.contains(String.valueOf(sb))){
                ans++;
                sb = new StringBuilder("");
            }
            index++;
        }
        return ans >= wordDict.size();
    }

    public static boolean dfs(int index, int len, HashSet<String> set, String s){
        if(index == len){
            return true;
        }

        for(int i = index + 1;i < len;i++){
            String substring = s.substring(0, index);
            if(set.contains(substring)){
                return true;
            }
        }
        return false;
    }

    public static boolean dp(String s, List<String> wordDict){
        HashSet<String> set = new HashSet<>();
        int maxlen = 0;
        for(int k = 0; k < wordDict.size(); k++){
            String temp = wordDict.get(k);
            set.add(temp);
            maxlen = Math.max(maxlen,temp.length());
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for(int i = 0; i <= len; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                }
                if(i - j > maxlen ){
                    continue;
                }
            }
        }
        return dp[len];
    }

}
