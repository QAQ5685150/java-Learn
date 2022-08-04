package com.cn.algorithm.LinkedList;

import java.util.HashMap;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm
 * @Time: 2022-07-22 15:10
 * @Description: TODO
 **/
public class LRU_Cache {

    HashMap<Integer, DoubleLinkedList> cache;
    DoubleLinkedList head = new DoubleLinkedList(-1,-1);
    DoubleLinkedList tail = new DoubleLinkedList(-1,-1);
    int capacity;
    int cur;

    public LRU_Cache(int capacity) {
        // write code here
        cache = new HashMap<>();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        cur = 0;
    }

    public int get(int key) {
        // write code here
        DoubleLinkedList node = cache.get(key);
        if(node == null){
            return -1;
        }
        move2head(node);
        return node.val;
    }

    public void set(int key, int value) {
        // write code here
        DoubleLinkedList node = cache.get(key);
        if(node == null){
            DoubleLinkedList tmp = new DoubleLinkedList(key, value);
            cache.put(key,tmp);
            add2head(tmp);
            cur++;
            if(cur > capacity){
                DoubleLinkedList tail = removeTail();
                cache.remove(tail.key);
                cur--;
            }
        }else {
            move2head(node);
        }
    }

    private void add2head(DoubleLinkedList node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void deleteNode(DoubleLinkedList node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void move2head(DoubleLinkedList node){
        deleteNode(node);
        add2head(node);
    }

    private DoubleLinkedList removeTail(){
        DoubleLinkedList pre = this.tail.pre;
        deleteNode(pre);
        return pre;
    }

    public static void main(String[] args) {
        LRU_Cache s = new LRU_Cache(3);
        s.set(1,1);
        s.set(2,2);
        s.set(3,3);
        s.set(4,4);
        System.out.println(s.get(5));
        System.out.println(s.get(1));
        System.out.println(s.get(4));
    }
}

class DoubleLinkedList {
    int key;
    int val;
    DoubleLinkedList pre;
    DoubleLinkedList next;

    public DoubleLinkedList(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRU_Cache object will be instantiated and called as such:
 * LRU_Cache solution = new LRU_Cache(capacity);
 * int output = solution.get(key);
 * solution.set(key,value);
 */