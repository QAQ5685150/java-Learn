package com.cn.algorithm.dataStructure.tree;

/**
 * 类名:TrieTree
 * 描述:前缀树
 * 姓名:南风
 * 日期:2021-10-20 16:53
 **/
public class TrieTree {

    private boolean isEnd;
    private TrieTree[] node;

    public TrieTree(){
        this.node = new TrieTree[26];
        isEnd = false;
    }

    public void add(String word){
        TrieTree node = this;
        int length = word.length();
        char[] chars = word.toCharArray();
        for (int i = 0; i < length; i++) {
            int tmp = chars[i] - 'a';
            if(node.node[tmp] == null){
                node.node[tmp] = new TrieTree();
            }
            node = node.node[tmp];
        }
        node.isEnd = true;
    }

    public boolean isExist(String word){
        return search(word);
    }

    public boolean search(String word){
        TrieTree node = this;
        char[] chars = word.toCharArray();
        int length = chars.length;
        int index = 0;
        while (index != length && node != null){
            int tmp = chars[index++] - 'a';
            if(node.node[tmp] == null){
                break;
            }
            node = node.node[tmp];
        }
        return index == length;
    }

    //test
    public static void main(String[] args) {
        TrieTree tree = new TrieTree();
        tree.add("knowledge");
        System.out.println(tree.search("know"));
        System.out.println(tree.isExist("kno"));
        System.out.println(tree.isExist("now"));
        System.out.println(tree.isExist("knowledgedss"));
    }
}


