package com.cn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类名:MapSum
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-15 11:10
 **/
class MapSum {
    class TrieNode {
        int val = 0;
        TrieNode[] next = new TrieNode[26];
    }

    TrieNode root;
    Map<String, Integer> map;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
            node.val += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return 0;
            }
            node = node.next[c - 'a'];
        }
        return node.val;
    }

    public static void main(String[] args) {

        Stream.of(1,2,6,8,4,5,6).map(i -> i % 2).collect(Collectors.toList()).forEach(System.out::print);
        System.out.println();
        Arrays.asList('s','t','c','e','h','y','m').stream().filter(i -> i - 'e' >= 0)
                .collect(Collectors.toList()).forEach(System.out::print);
        System.out.println();
        Map<Integer, Integer> collect = Stream.of(1, 2, 6, 8, 4, 5, 6).
                collect(Collectors.toMap(i -> i + 2, i -> i));
        Iterator<Map.Entry<Integer, Integer>> iterator1 = collect.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry<Integer, Integer> next = iterator1.next();
            System.out.println(next.getKey() + next.getValue());
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
