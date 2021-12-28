package com.cn.algorithm.string;

import com.cn.algorithm.dataStructure.tree.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类名: findAllConcatenatedWordsInADict_472
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2021-12-28 17:13
 **/
public class findAllConcatenatedWordsInADict_472 {

    private static Trie trieTree = new Trie();

    private static Trie1 trie = new Trie1();

    public static void main(String[] args) {
        String[] words = new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> result = findAllConcatenatedWordsInADict_1(words);
        for (String s : result) {
            System.out.print(s + " ");
        }

        System.out.println();

        List<String> result2 = findAllConcatenatedWordsInADict_2(words);
        for (String s : result2) {
            System.out.print(s + " ");
        }
    }


    public static List<String> findAllConcatenatedWordsInADict_1(String[] words) {

        List<String> list = new ArrayList<>();
        Arrays.sort(words, (a,b) -> a.length() - b.length());

        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            if("".equals(cur)) continue;
            if(dfs1(cur,0)){
                list.add(cur);
            }else {
                trieTree.insert(cur);
            }
        }

        return list;
    }

    public static boolean dfs1(String word,int start){
        for (int i = 1; i < word.length(); i++) {
            boolean exist = trieTree.search(word.substring(start, i));
            if(exist){
                return true;
            }
        }
        return false;
    }


    /**
    *功能描述:TODO
    *@param words
    *@return java.util.List<java.lang.String>
    **/
    public static List<String> findAllConcatenatedWordsInADict_2(String[] words) {
        List<String> ans = new ArrayList<String>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 0) {
                continue;
            }
            if (dfs2(word, 0)) {
                ans.add(word);
            } else {
                insert(word);
            }
        }
        return ans;
    }

    public static boolean dfs2(String word, int start) {
        if (word.length() == start) {
            return true;
        }
        Trie1 node = trie;
        for (int i = start; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            node = node.children[index];
            if (node == null) {
                return false;
            }
            if (node.isEnd) {
                if (dfs2(word, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void insert(String word) {
        Trie1 node = trie;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie1();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
}




class Trie1 {
    Trie1[] children;
    boolean isEnd;

    public Trie1() {
        children = new Trie1[26];
        isEnd = false;
    }
}
