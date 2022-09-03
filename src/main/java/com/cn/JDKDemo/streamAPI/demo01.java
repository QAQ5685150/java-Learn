package com.cn.JDKDemo.streamAPI;

import com.cn.Pojo.person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类名:demo01
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-13 9:33
 **/
public class demo01 {

    public static void main(String[] args) {
        //generateDemo();
        //demo01(); stream.filter（）过滤传入函数式接口返回true的值
//        refMapdemo();//map 归纳
//        System.out.println(" ");
//
//        List<String> strings = new ArrayList<>();
//        Collections.addAll(strings,"asd","qwe","zxc","wer","sdf","xcv");
//        printCollection(getStreamByList(strings).collect(Collectors.toList()));
//        System.out.println(" ");
//
//        printCollection(getStreamByStaticRandom().collect(Collectors.toList()));
//        testMap();

        //给函数式接口赋函数？可以传入别的函数执行对应返回值的函数，因为是个接口，类似于让对应函数直接实现传入的函数
        //Action action = System.out :: println;
        //action.execute("Hello World!");

        testInterface(System.out::print, 1,4,5,7,2,4,8);
    }


    private static void testInterface(Action action,Integer ... i) {
        List<Integer> collect = Arrays.stream(i).collect(Collectors.toList());
        action.execute(collect);
    }

    /**
    *功能描述:stream.map() 对Collection里每个元素进行操作
    *@returnvoid
    **/
    private static void testMap() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,3,5,2,6,7);
        List<Integer> collect = list.stream().filter(i -> i > 2).map(i -> i * i).collect(Collectors.toList());
        printCollection(collect);
    }

    /**
    *功能描述:打印一个Collection
    *@paramt
    *@return void
    **/
    private static void printCollection(Collection t){
        t.forEach(i -> System.out.print(i + " "));
    }

    /**
    *功能描述:根据指定函数获取流中得每个元素的数据并重新组合成一个新的元素(stream.collect()传入toList函数)。
    *@returnvoid
    **/
    private static void refMapdemo() {
        List<person> plist = new ArrayList<>();
        plist.add(new person(1,"小明",15));
        plist.add(new person(2,"小红",18));
        plist.add(new person(3,"小王",20));
        List<String> map = plist.stream().map(person::getName).collect(Collectors.toList());
        printCollection(map);
        List<person> filter = plist.stream().filter(person -> person.getAge() <= 18).collect(Collectors.toList());
        printCollection(filter);
    }

    private static void generateDemo() {
        Stream<Integer> limit = Stream.generate(() -> 1).limit(10);
        limit.forEach(i -> System.out.print(i + " "));
    }

    private static void demo01(){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 15; i++){
            list.add(i);
        }
        list.stream().filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + " "));
    }

    /**
    *功能描述:传入List  返回一个流
    *@returnjava.util.stream.Stream<T>
    **/
    private static <T> Stream<T> getStreamByList(List<T> list){
        return list.stream();
    }

    /**
    *功能描述:用Arrays获取一个流
    *@returnjava.util.stream.Stream<T>
    **/
    private static <T> Stream<T> getStreamByArrays(T[] integers){
        return Arrays.stream(integers);
    }

    /**
    *功能描述:随机获取一个流
    *@returnjava.util.stream.Stream<java.lang.Double>
    **/
    private static Stream<Double> getStreamByStaticRandom(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Stream<Integer> limit = Stream.iterate(0, x -> x + 1).limit(10);

        Stream<Double> random = Stream.generate(Math::random).limit(10);
        return random;
    }
}

@FunctionalInterface
interface Action<T>{
    public void execute(T t);
}
