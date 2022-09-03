package com.cn.Algorithm.array.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 类名: eatenApples_1705
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2021-12-30 15:32
 **/
public class eatenApples_1705 {

    /**
     * 功能描述:有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
     *
     * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
     *
     * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
    **/
    public static void main(String[] args) {
        //多个一维数组集合表示一组二元数组
        int[] arr = new int[]{1,2};
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        int[] apples = new int[]{1,2,3,5,2,5,3,6,7,6};
        int[] days = new int[]{3,2,1,4,2,7,4,2,5,4};
        System.out.println(eatenApples(apples,days));
        System.out.println(apple(apples,days));

    }

    /**
     * 功能描述:贪心解法 建立一个小根堆，每次从堆拿出来的是“最接近过期时间的苹果”（二元组int[0]最小的那一组）
     * 当前日期用d表示，每次放入堆中的是最先生产出来苹果的过期时间（int[0] = d+days[d]）
     * 判断条件为，当苹果过期或没有苹果，移除堆顶的苹果，从“下一个苹果开始吃”
    *@param apples
    *@param days
    *@return int
    **/
    public static int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        Queue<int[]> queue = new PriorityQueue<>((x1, x2) -> x1[0] - x2[0]);
        int d = 0;
        while (d < apples.length || !queue.isEmpty()) {
            //d + days[d]是当前的日期 + 腐烂的日期，合起来是这一堆苹果到期的那一天
            // queue.peek()[0] <= d就是这对苹果到期的条件
            //apples[d]表示这对苹果还剩多少，queue.peek()[1] == 0是全部苹果吃完的条件
            if (d < apples.length && apples[d] > 0) queue.add(new int[]{d + days[d], apples[d]});       // 新结出的苹果入队
            while (!queue.isEmpty() && (queue.peek()[0] <= d || queue.peek()[1] == 0)) queue.poll();  // 到腐烂日期或者腐烂数量归零
            if (!queue.isEmpty()) {     //吃苹果
                ++ans;
                --queue.peek()[1];
            }
            ++d;
        }
        return ans;
    }

    /**
    *功能描述:分析的头头是道，自己开始写就有点晕了……还是没建立起把分析的条件转换场代码的桥梁呀
    *@param apple
    *@param days
    *@return int
    **/
    public static int apple(int[] apple, int[] days){
        Queue<int[]> pq = new PriorityQueue<>((x1, x2) -> x1[0] - x2[0]);
        int d = 0;
        int ans = 0;
        while (d < days.length || !pq.isEmpty()){
            if(d < apple.length && apple[d] > 0) pq.add(new int[]{d + days[d], apple[d]});
            while (!pq.isEmpty() && (pq.peek()[0] <= d || pq.peek()[1] == 0)){
                pq.poll();
            }
            if(!pq.isEmpty()){
                ++ans;
                --pq.peek()[1];
            }
            ++d;
        }
        return ans;
    }
}
