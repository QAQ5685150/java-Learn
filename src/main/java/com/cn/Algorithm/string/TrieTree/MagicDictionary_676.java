package com.cn.Algorithm.string.TrieTree;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.string.TrieTree
 * @Time: 2022-07-11 14:35
 **/
public class MagicDictionary_676 {

    /**
     *传统的TrieTree不适合这道题 需要修改。三叶姐用dfs和trie做的这道题，我很震惊原来还可以这样玩
     *review一下trieTree的insert和query，里面构建数据结构去节点然后迭代字符串数组，在循环中加入节点取节点
     * 的操作我好像有点理解了……上一次刷的时候还真的是不够理解trieTree
     * @param args
     */
    public static void main(String[] args) {

        MagicDictionary_676.buildDict(new String[]{"hello","leet"});
        System.out.println(query("hallo"));
        System.out.println(query("hello"));
        System.out.println(query("hell"));
        System.out.println(query("leer"));
    }

    static Trie trie = new Trie();

    public MagicDictionary_676() {
    }

    public static void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            add(s);
        }
    }

    public static boolean add(String s){
        char[] chars = s.toCharArray();
        Trie node = trie;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if(node.node[index] == null){
                node.node[index] = new Trie();
            }
            node = node.node[index];
        }
        node.isEnd = true;
        return true;
    }

    public static boolean query(String s){
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Trie pNode = trie;
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if(pNode.node[index] == null){
                return false;
            }
            pNode = pNode.node[index];
            sb.append(chars[i]);
        }
        if(pNode.isEnd == true){
            flag = isReplaceable(sb.toString(),s);
        }
        return flag;
    }

    public static boolean isReplaceable(String s1, String s2){
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

    static class Trie{
        Trie[] node;
        boolean isEnd;

        public Trie(){
            node = new Trie[26];
        }
    }
}
class MagicDictionary_dfs_trie {
    int N = 100 * 100, M = 26, idx = 0;
    int[][] tr = new int[N][M];
    boolean[] isEnd = new boolean[N * M];
    void add(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (tr[p][u] == 0) tr[p][u] = ++idx;
            p = tr[p][u];
        }
        isEnd[p] = true;
    }
    boolean query(String s, int idx, int p, int limit) {
        if (limit < 0) return false;
        if (idx == s.length()) return isEnd[p] && limit == 0;
        int u = s.charAt(idx) - 'a';
        for (int i = 0; i < 26; i++) {
            if (tr[p][i] == 0) continue;
            if (query(s, idx + 1, tr[p][i], i == u ? limit : limit - 1)) return true;
        }
        return false;
    }
    public void buildDict(String[] ss) {
        for (String s : ss) add(s);
    }
    public boolean search(String s) {
        return query(s, 0, 0, 1);
    }
}
