package com.cn.JDKDemo.streamAPI.streamDemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: @小脑斧不可爱
 * @Time:2021-08-02 10:20
 * @Description: java8 Stream流demo
 * @Project_name:NettyDemo
 */
public class demo01 {


	public static void main(String[] args) {
		//getMax();
		//getMaxString();
		//filter();筛选 传入lambda表达式返回处理后的数据

		//getAvg();
		// 统计员工人数、平均工资、工资总额、最高工资。
		//对pojo对象list某一属性统计的技巧：先把pojo对象的属性转化用map（）转化成该属性list集合对象
		//再用统计list的stream求出该属性的统计信息

		map();//映射
		//partitioningBy();分组(partitioningBy/groupingBy)

		//joiningDemo();//拼接stream中的元素

		//sorted();

	}

	private static void sorted() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Sherry", 9000, 24, "female", "New York"));
		personList.add(new Person("Tom", 8900, 22, "male", "Washington"));
		personList.add(new Person("Jack", 9000, 25, "male", "Washington"));
		personList.add(new Person("Lily", 8800, 26, "male", "New York"));
		personList.add(new Person("Alisa", 9000, 26, "female", "New York"));

		//按工资salary升序排序（默认排序）
		List<Integer> collect = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getSalary).collect(Collectors.toList());
		//按工资salary倒叙排序   map里面你传进去哪个function(pojo对象的属性)显示的就是哪个属性
		List<Integer> collect1 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(Person::getSalary).collect(Collectors.toList());
		//先按工资再按年龄升序排序
		List<String> collect2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName).collect(Collectors.toList());
		//自定义排序 先按工资再按年龄，需要自己忘sorted函数里面穿lambda表达式
		List<String> collect3 = personList.stream().sorted((p1, p2) -> {
			if (p1.getSalary() == p2.getSalary()) {
				return p2.getAge() - p1.getAge();
			} else {
				return p2.getSalary() - p1.getSalary();
			}
		}).map(Person::getName).collect(Collectors.toList());

		System.out.println("按工资升序排序：" + collect);
		System.out.println("按工资降序排序：" + collect1);
		System.out.println("先按工资再按年龄升序排序：" + collect2);
		System.out.println("先按工资再按年龄自定义降序排序：" + collect3);

	}

	/**
	 * `joining`可以将stream中的元素用特定的连接符（没有的话，则直接连接）连接成一个字符串。
	 */
	private static void joiningDemo() {
		List<Person> personList = new ArrayList<>();
		Collections.addAll(personList,
				new Person("Tom", 8900, 23, "male", "New York"),
				new Person("Jack", 7000, 25, "male", "Washington"),
				new Person("Lily", 7800, 21, "female", "Washington"));
		String collect = personList.stream().map(Person::getArea).collect(Collectors.joining(" - "));
		System.out.println("员工地区：{ "+collect+" }");
		List<String> list = Arrays.asList("A", "B", "C");
		String s = list.stream().collect(Collectors.joining(","));
		System.out.println("拼接后的字符串："+s);


	}

	private static void partitioningBy() {
		List<Person> list = new ArrayList<>();
		Collections.addAll(list,
				new Person("Tom", 8900, 23, "male", "Washington"),
				new Person("Jack", 7000, 25, "male", "Washington"),
				new Person("Lily", 7800, 21, "female", "New York"),
				new Person("Anni", 8200, 24, "female", "New York"));

		//将员工Person中薪水是否大于7000分组
		Map<Boolean, List<Person>> collect = list.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 7000));
		//将员工按照性别分组
		Map<String, List<Person>> collect1 = list.stream().collect(Collectors.groupingBy(Person::getSex));
		//先按照性别分组，再按照地区分组
		Map<String, Map<String, List<Person>>> collect2 = list.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));

		System.out.println("员工按薪资是否大于7000分组情况：" + collect);
		System.out.println("员工按性别分组情况：" + collect1);
		System.out.println("员工按性别、地区：" + collect2);

	}

	/**
	 * stream map映射操作demo
	 */
	private static void map() {
		String[] userName = new String[]{"asd5685150","lxx1996915915","zxcvasdf"};
		Stream<String> stream = Arrays.asList(userName).stream().map(x -> x.toUpperCase());
		List<String> collect = stream.collect(Collectors.toList());
		System.out.println("用户名中的英文转换成大写字母 : "+collect);

		List<Integer> collect1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream().map(x -> x + 3).collect(Collectors.toList());
		System.out.println("每个元素值+3："+collect1);

		List<Person> list = new ArrayList<>();
		Collections.addAll(list,new Person("Tom", 8900, 23, "male", "New York")
				,new Person("Jack", 7000, 25, "male", "Washington"),
				new Person("Lily", 7800, 21, "female", "Washington"));
		Map<String, Integer> collect2 = list.stream().sorted((a, b) -> a.getAge() - b.getAge())
				.sorted((a, b) -> a.getSalary() - b.getSalary())
				.collect(Collectors.toMap(o -> o.getName(), o -> o.getAge()));
		Iterator<Map.Entry<String, Integer>> iterator = collect2.entrySet().iterator();
		while (iterator.hasNext()){
			Map.Entry<String, Integer> next = iterator.next();
			System.out.println( next.getKey() + " -> " + next.getValue());
		}


	}

	public static void getAvg(){
		List<Person> personList = new ArrayList<>();
		Collections.addAll(personList,new Person("Tom", 8900, 23, "male", "New York")
		,new Person("Jack", 7000, 25, "male", "Washington"),
				new Person("Lily", 7800, 21, "female", "Washington"));

		int count = personList.size();
		//求Person对象平均工资，
		Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
		//求最高工资  先用map映射把salary映射成一个integer的list，再用max传入integer的比较器找到最大数
		Optional<Integer> max = personList.stream().map(Person::getSalary).max(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		//求工资之和
		int sum = personList.stream().mapToInt(Person::getSalary).sum();
		//一次性统计所有信息
		DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));

		System.out.println("员工总数：" + count);
		System.out.println("员工平均工资：" + average);
		System.out.println("员工最高工资：" + max.get());
		System.out.println("员工工资总和：" + sum);
		System.out.println("员工工资所有统计：" + collect);

	}

	public static void filter(){
		List<Integer> list = Arrays.asList(1, 4, 3, 6, 8, 5, 9, 24, 16, 37, 45, 23, 14, 36, 12);
		Stream<Integer> is = list.stream().filter(y -> y > 6);
		long count = is.count();
		System.out.println("List总元素个数：" + list.size());
		System.out.println("List中大于6的元素个数：" + count);


	}

	/**
	 * 获取Integer集合中的最大值。
	 */
	public static void getMax(){
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list,4,2,3,5,67,1,2,3,9,23);
		Optional<Integer> max = list.stream().max(Integer::compareTo);
		Optional<Integer> max1 = list.stream().max(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		System.out.println(max.get());
		System.out.println(max1.get());
	}

	/**
	 * 获取StringList中最长的字符串
	 */
	public static void getMaxString(){
		List<String> list = Arrays.asList("asdf", "qwerq", "zczcxxx", "zxcasdqwe", "zcx");
		Optional<String> max = list.stream().max(Comparator.comparing(String::length));
		System.out.println("最长的字符串为："+ max.get());
	}
}
