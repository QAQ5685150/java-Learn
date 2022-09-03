package com.cn.JDKDemo.streamAPI.streamDemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time:2021-08-02 10:20
 * @Description: java8 Stream��demo
 * @Project_name:NettyDemo
 */
public class demo01 {


	public static void main(String[] args) {
		//getMax();
		//getMaxString();
		//filter();ɸѡ ����lambda���ʽ���ش���������

		//getAvg();
		// ͳ��Ա��������ƽ�����ʡ������ܶ��߹��ʡ�
		//��pojo����listĳһ����ͳ�Ƶļ��ɣ��Ȱ�pojo���������ת����map����ת���ɸ�����list���϶���
		//����ͳ��list��stream��������Ե�ͳ����Ϣ

		map();//ӳ��
		//partitioningBy();����(partitioningBy/groupingBy)

		//joiningDemo();//ƴ��stream�е�Ԫ��

		//sorted();

	}

	private static void sorted() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Sherry", 9000, 24, "female", "New York"));
		personList.add(new Person("Tom", 8900, 22, "male", "Washington"));
		personList.add(new Person("Jack", 9000, 25, "male", "Washington"));
		personList.add(new Person("Lily", 8800, 26, "male", "New York"));
		personList.add(new Person("Alisa", 9000, 26, "female", "New York"));

		//������salary��������Ĭ������
		List<Integer> collect = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getSalary).collect(Collectors.toList());
		//������salary��������   map�����㴫��ȥ�ĸ�function(pojo���������)��ʾ�ľ����ĸ�����
		List<Integer> collect1 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(Person::getSalary).collect(Collectors.toList());
		//�Ȱ������ٰ�������������
		List<String> collect2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName).collect(Collectors.toList());
		//�Զ������� �Ȱ������ٰ����䣬��Ҫ�Լ���sorted�������洩lambda���ʽ
		List<String> collect3 = personList.stream().sorted((p1, p2) -> {
			if (p1.getSalary() == p2.getSalary()) {
				return p2.getAge() - p1.getAge();
			} else {
				return p2.getSalary() - p1.getSalary();
			}
		}).map(Person::getName).collect(Collectors.toList());

		System.out.println("��������������" + collect);
		System.out.println("�����ʽ�������" + collect1);
		System.out.println("�Ȱ������ٰ�������������" + collect2);
		System.out.println("�Ȱ������ٰ������Զ��彵������" + collect3);

	}

	/**
	 * `joining`���Խ�stream�е�Ԫ�����ض������ӷ���û�еĻ�����ֱ�����ӣ����ӳ�һ���ַ�����
	 */
	private static void joiningDemo() {
		List<Person> personList = new ArrayList<>();
		Collections.addAll(personList,
				new Person("Tom", 8900, 23, "male", "New York"),
				new Person("Jack", 7000, 25, "male", "Washington"),
				new Person("Lily", 7800, 21, "female", "Washington"));
		String collect = personList.stream().map(Person::getArea).collect(Collectors.joining(" - "));
		System.out.println("Ա��������{ "+collect+" }");
		List<String> list = Arrays.asList("A", "B", "C");
		String s = list.stream().collect(Collectors.joining(","));
		System.out.println("ƴ�Ӻ���ַ�����"+s);


	}

	private static void partitioningBy() {
		List<Person> list = new ArrayList<>();
		Collections.addAll(list,
				new Person("Tom", 8900, 23, "male", "Washington"),
				new Person("Jack", 7000, 25, "male", "Washington"),
				new Person("Lily", 7800, 21, "female", "New York"),
				new Person("Anni", 8200, 24, "female", "New York"));

		//��Ա��Person��нˮ�Ƿ����7000����
		Map<Boolean, List<Person>> collect = list.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 7000));
		//��Ա�������Ա����
		Map<String, List<Person>> collect1 = list.stream().collect(Collectors.groupingBy(Person::getSex));
		//�Ȱ����Ա���飬�ٰ��յ�������
		Map<String, Map<String, List<Person>>> collect2 = list.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));

		System.out.println("Ա����н���Ƿ����7000���������" + collect);
		System.out.println("Ա�����Ա���������" + collect1);
		System.out.println("Ա�����Ա𡢵�����" + collect2);

	}

	/**
	 * stream mapӳ�����demo
	 */
	private static void map() {
		String[] userName = new String[]{"asd5685150","lxx1996915915","zxcvasdf"};
		Stream<String> stream = Arrays.asList(userName).stream().map(x -> x.toUpperCase());
		List<String> collect = stream.collect(Collectors.toList());
		System.out.println("�û����е�Ӣ��ת���ɴ�д��ĸ : "+collect);

		List<Integer> collect1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream().map(x -> x + 3).collect(Collectors.toList());
		System.out.println("ÿ��Ԫ��ֵ+3��"+collect1);

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
		//��Person����ƽ�����ʣ�
		Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
		//����߹���  ����mapӳ���salaryӳ���һ��integer��list������max����integer�ıȽ����ҵ������
		Optional<Integer> max = personList.stream().map(Person::getSalary).max(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		//����֮��
		int sum = personList.stream().mapToInt(Person::getSalary).sum();
		//һ����ͳ��������Ϣ
		DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));

		System.out.println("Ա��������" + count);
		System.out.println("Ա��ƽ�����ʣ�" + average);
		System.out.println("Ա����߹��ʣ�" + max.get());
		System.out.println("Ա�������ܺͣ�" + sum);
		System.out.println("Ա����������ͳ�ƣ�" + collect);

	}

	public static void filter(){
		List<Integer> list = Arrays.asList(1, 4, 3, 6, 8, 5, 9, 24, 16, 37, 45, 23, 14, 36, 12);
		Stream<Integer> is = list.stream().filter(y -> y > 6);
		long count = is.count();
		System.out.println("List��Ԫ�ظ�����" + list.size());
		System.out.println("List�д���6��Ԫ�ظ�����" + count);


	}

	/**
	 * ��ȡInteger�����е����ֵ��
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
	 * ��ȡStringList������ַ���
	 */
	public static void getMaxString(){
		List<String> list = Arrays.asList("asdf", "qwerq", "zczcxxx", "zxcasdqwe", "zcx");
		Optional<String> max = list.stream().max(Comparator.comparing(String::length));
		System.out.println("����ַ���Ϊ��"+ max.get());
	}
}
