package com.cn.algorithm.array;

import com.cn.algorithm.util.printUtils;
import com.cn.pojo.person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 类名: leastBricks_554
 * 描述: 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 * 姓名: @author南风
 * 日期: 2022-02-18 16:45
 **/
public class leastBricks_554 {

    /**
    *功能描述: map保存的<key,value> key是每一次当前位置有没有“空隙”存在，数组中位数上有，表示这里有个空隙，累计第一层该位置有，每一层空隙的位置互不影响都可以在map中get取出来
     * 处理完后就遍历map，把
    *@param args
    *@return void
    **/
    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        Collections.addAll(wall,Arrays.asList(1,2,2,1),Arrays.asList(3,1,2),
                Arrays.asList(1,3,2),Arrays.asList(2,4),Arrays.asList(3,1,2),Arrays.asList(1,3,1,1));
        System.out.println(leastBricks(wall));
        //System.out.println(leastBricks_list(wall));
//        stream_review(wall);
        leastBricks_list(wall);

    }

    public static int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (Integer integer : wall.get(i)) {
                sum += integer;
                map.put(sum,map.getOrDefault(sum,0) + 1);
            }
            map.remove(sum);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println(next.getKey() + " : " + next.getValue());
        }
        int ans = n;
        for (Integer integer : map.keySet()) {
            int cur = map.get(integer);
            ans = Math.min(ans,n - cur);
        }
        return ans;
    }

    public static int leastBricks_list(List<List<Integer>> wall){
        int total = wall.get(0).stream().mapToInt(x -> x).sum();
        int[] arr = new int[total + 1];
        for (List<Integer> list : wall) {
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
                arr[sum] += 1;
            }
        }
        printUtils.printArray(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < total - 1; i++) {
            ans = Math.min(ans, arr[i]);
        }
        return ans;
    }

    /**
     * stream流  map、mapToInt、filter、collect、flatMap操作 review
     * @param wall
     */
    public static void stream_review(List<List<Integer>> wall){
        System.out.println("map操作 对流中所有数据便利操作 传入泛型T返回泛型R 传入的表达式可以对中间所有数据便利操作");
        //求List<List<Integer>>集合中，每个集合的大小
        List<Integer> collect = wall.stream().map(x -> x.size()).collect(Collectors.toList());
        printUtils.printArray(collect);


        System.out.println("mapToInt 返回一个intStream 传入的lambda相当于便利集合操作  sum 对intStream操作，求和");
        //求integer集合中所有数的和
        int total = wall.get(0).stream().mapToInt(x -> x).sum();
        System.out.println(total);


        System.out.println("filter 传入一个boolean 过滤流中所有符合的数据:");
        //打印intStream中所有大于x > 0的数据 :: 表示调用方法
        IntStream intStream = wall.get(0).stream().mapToInt(x -> x).filter(x -> x > 0);
        intStream.map(x -> x).forEach(System.out::print);

        //flapMap
        String[] strs = { "aaa", "bbb", "ccc" };
        Arrays.stream(strs).map(str -> str.split("")).forEach(System.out::println);// Ljava.lang.String;@53d8d10a
        Arrays.stream(strs).map(str -> str.split("")).flatMap(Arrays::stream).forEach(System.out::print);// aaabbbccc
        System.out.println();
        Arrays.stream(strs).map(str -> str.split("")).flatMap(str -> Arrays.stream(str)).forEach(System.out::print);// aaabbbccc


        //groupingBy和partitioningBy 是Collectors内的方法
        //分区：将stream按条件分为两个Map，比如员工按薪资是否高于8000分为两部分。
        //分组：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组。
        List<person> people = new ArrayList<>();
        people.add(new person(1L,"王蕾蕾",18));
        people.add(new person(2L,"张三",25));
        people.add(new person(3L,"艾克",33));
        people.add(new person(4L,"孙正义",12));

        Map<Boolean, List<person>> collect1 = people.stream().collect(Collectors.groupingBy(x -> x.getAge() > 20));


    }
}
