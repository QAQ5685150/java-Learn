package com.cn.Algorithm.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 类名: MapSum_677
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2022-01-13 11:25
 **/
public class MapSum_677 {

    /**
     * 功能描述:实现一个 MapSum 类，支持两个方法，insert和sum：
     * <p>
     * MapSum() 初始化 MapSum 对象
     * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，
     * 整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
     * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
     *
     * 输入：
     * ["MapSum", "insert", "sum", "insert", "sum"]
     * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
     * 输出：
     * [null, null, 3, null, 5]
     **/
    public static void main(String[] args) {
//        MapSum ms = new MapSum();
//        ms.insert("apple",3);
//        System.out.println(ms.sum("ap"));
//        ms.insert("app",4);
//        System.out.println(ms.sum("ap"));
        MapSumTrie mst = new MapSumTrie();
        mst.insert("apple",3);
        System.out.println(mst.sum("ap"));
        mst.insert("app",4);
        System.out.println(mst.sum("ap"));
    }
}

/**
*功能描述:hash
*@return
**/
class MapSum {

    Map<String,Integer> map;

    public MapSum() {
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        char[] cur = key.toCharArray();
        this.map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        Set<Map.Entry<String, Integer>> entries = this.map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            if(isPrefix(prefix,next.getKey())){
                sum += next.getValue();
            }
        }
        return sum;
    }

    public boolean isPrefix(String prefix, String word){
        if(prefix.length() > word.length()){
            return false;
        }
        char[] chars = prefix.toCharArray();
        char[] chars1 = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != chars1[i]){
                return false;
            }
        }
        return true;
    }
}

/**
*功能描述:前缀树
*@return
**/
class MapSumTrie{

    class Trie{
        int val = 0;
        Trie[] node = new Trie[26];
    }

    Map<String,Integer> map;
    Trie trie;

    public MapSumTrie() {
        this.map = new HashMap<>();
        this.trie= new Trie();
    }

    public void insert(String key, int val) {
        Trie root = trie;
        char[] chars = key.toCharArray();
        int value = val - map.getOrDefault(key,0);
        map.put(key,val);
        for (char c : chars) {
            int cur = c - 'a';
            if(root.node[cur] == null){
                root.node[cur] = new Trie();
            }
            root = root.node[cur];
            root.val += value;
        }
    }

    public int sum(String prefix) {
        Trie node = trie;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            int cur = c - 'a';
            if(node.node == null){
                return 0;
            }
            node = node.node[cur];
        }
        return node.val;
    }
}


