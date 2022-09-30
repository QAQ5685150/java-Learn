package com.cn.Algorithm.algoritmBook.virtualMatch;

import com.cn.Algorithm.dataStructure.LinkedList.ListNode;
import com.cn.Algorithm.util.printUtils;

import java.util.*;
import java.util.logging.Filter;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.algoritmBook.virtualMatch
 * @Time: 2022-09-30 14:43
 * @Description: TODO
 **/
public class reContruct {

    public static void main(String[] args) {
        int[] test1 = new int[]{2,7,8,10};
        int[] test2 = new int[]{4,9};
        printUtils.printArray(explorationSupply(test1, test2));

        int[] t1 = new int[]{6,5,2,1,0};
        int[][] t2 = new int[][]{{0,1,2},{2,3,3}};
        System.out.println(storedEnergy(6, t1, t2));

        VendingMachine sys = new VendingMachine();
        sys.addItem(0,1,"Apple",4,3); // 时刻 0 ，添加 1 个 Apple，价格为 4，保质期为 3。
        sys.addItem(1,3,"Apple",4,2); // 时刻 1 ，添加 3 个 Apple，价格为 4，保质期为 2。
        System.out.println(sys.sell(2, "Mary", "Apple", 2));
        sys.addItem(2,1,"Banana",2,5); // 时刻 2 ，添加 1 个 Banana，价格为 2，保质期为 5。
        System.out.println(sys.sell(4, "Jim", "Banana", 2));
        System.out.println(sys.sell(4, "Mary", "Banana", 1));
        System.out.println(sys.sell(4, "Mary", "Apple", 1));
        sys.addItem(6,200,"Apple",2,5); // 时刻 6 ，添加 200 个 Apple，价格为 2，保质期为 5。
        System.out.println(sys.sell(6, "Jim", "Apple", 100));
        System.out.println(sys.sell(7, "Mary", "Apple", 100));

    }

    public ListNode reContruct(ListNode head) {
        ListNode node = new ListNode();
        ListNode dummy = node;
        while (head != null){
            if(head.val % 2 != 0){
                node.next = new ListNode(head.val);
                node = node.next;
            }
            head = head.next;
        }
        return dummy.next;
    }


    public static int[] explorationSupply(int[] station, int[] pos) {
        int[] res = new int[pos.length];

        for (int i = 0; i < pos.length; i++) {
            int cur = Integer.MAX_VALUE;
            for (int j = 0; j < station.length; j++) {
                if(Math.abs(station[j] - pos[i]) < cur){
                    cur = Math.abs(station[j] - pos[i]);
                    res[i] = j;
                }
            }
        }
        return res;
    }

    public static int storedEnergy(int storeLimit, int[] power, int[][] supply) {
        int res = 0;
        int index = 0;
        int[] cur = supply[index];
            for (int i = 0; i < power.length; i++) {
            if(index + 1 < supply.length){
                if(i == supply[index + 1][0]){
                    index++;
                    cur = supply[index];
                }
            }

            int min = cur[1];
            int max = cur[2];
            if(power[i] < min) res = res - (min - power[i]) >= 0 ? res - (min - power[i]) : 0;
            if(power[i] > max) res = res + (power[i] - max) >= storeLimit ? storeLimit : res + (power[i] - max);
        }
        return res;
    }
}

class VendingMachine {

    HashMap<String, PriorityQueue<item>> item;

    HashMap<String,Float> custom;


    public VendingMachine() {
        item = new HashMap<>();
        custom = new HashMap<>();
    }

    public void addItem(int time, int number, String item, int price, int duration) {
        if(null != this.item.get(item)){
            PriorityQueue<item> items = this.item.get(item);
            items.add(new item(time,number,price,duration,duration + time));
            this.item.put(item,items);
        }else {
            PriorityQueue<item> items = new PriorityQueue<>( (a,b) -> {
                if(a.getPrice() != b.getPrice()){
                    return a.getPrice() - b.getPrice();
                }else {
                    return a.getLast() - b.getLast();
                }
            });
            items.add(new item(time,number,price,duration,duration + time));
            this.item.put(item,items);
        }

    }

    public long sell(int time, String customer, String item, int number) {
        if (this.custom.get(customer) == null) {
            this.custom.put(customer,new Float(1));
        }
        if(null == this.item.get(item)){
            return -1;
        }
        Float zhekou = this.custom.get(customer);
        PriorityQueue<item> curItems = this.item.get(item);
        long v = 0L;
        Iterator<item> iterator = curItems.iterator();//同一商品不同批次的题目没搞明白，过了30%
        while (iterator.hasNext()) {
            item curItem = iterator.next();
            v += (long) Math.ceil(curItem.getPrice() * number * zhekou);
            curItem.setNumber(curItem.getNumber() - number);
            curItems.offer(curItem);
        }
        this.custom.put(customer,new Float(this.custom.get(customer) - 0.01));
        this.item.put(item,curItems);
        return v == 0L ? -1 : v;
    }
}

class item{
    int time;
    int number;
    int price;
    int duration;
    int last;

    public item(int time, int number, int price, int duration, int last) {
        this.time = time;
        this.number = number;
        this.price = price;
        this.duration = duration;
        this.last = last;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTime() {
        return time;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public int getLast() {
        return last;
    }
}
