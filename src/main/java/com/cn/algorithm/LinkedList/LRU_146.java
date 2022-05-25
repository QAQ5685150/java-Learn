package com.cn.algorithm.LinkedList;

import java.util.HashMap;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-04-16 11:40
 * @Description: TODO
 * @Project_name: java-learn
 */
public class LRU_146 {

    public static void main(String[] args) {

    }

    DLinkedList head;
    DLinkedList tail;
    HashMap<Integer, DLinkedList> cache;
    int size;
    int capacity;

    public LRU_146(int capacity) {
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        DLinkedList dLinkedList = cache.get(key);
        if(dLinkedList == null){
            return -1;
        }
        return dLinkedList.value;
    }

    public void put(int key, int value) {
        DLinkedList dLinkedList = cache.get(key);
        if(dLinkedList == null){
            DLinkedList node = new DLinkedList(key, value);
            cache.put(key,node);
            add2head(node);
            size++;
            if(size > capacity){
                DLinkedList dLinkedList1 = removeTail();
                cache.remove(dLinkedList1.key);
                size--;
            }
        }else {
            dLinkedList.value = value;
            moveToHead(dLinkedList);
        }
    }

    private void add2head(DLinkedList node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(DLinkedList node){
        removeNode(node);
        add2head(node);
    }

    private void removeNode(DLinkedList node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLinkedList removeTail(){
        DLinkedList tail = this.tail.prev;//删除tail的前驱节点，tail是空指针，用来存放末尾，不是数据节点
        removeNode(tail);
        return tail;
    }
}

class DLinkedList{
    int key;
    int value;
    DLinkedList prev;
    DLinkedList next;

    public DLinkedList() {
    }

    public DLinkedList(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
