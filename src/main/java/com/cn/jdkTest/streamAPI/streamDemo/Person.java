package com.cn.jdkTest.streamAPI.streamDemo;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time:2021-08-02 10:47
 * @Description: stream�� ��ʾpojo
 * @Project_name:NettyDemo
 */
public class Person {

	private String name;  // ����
	private int salary; // н��
	private int age; // ����
	private String sex; //�Ա�
	private String area;  // ����

	// ���췽��
	public Person(String name, int salary, int age,String sex,String area) {
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.sex = sex;
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", salary=" + salary +
				", age=" + age +
				", sex='" + sex + '\'' +
				", area='" + area + '\'' +
				'}';
	}
}