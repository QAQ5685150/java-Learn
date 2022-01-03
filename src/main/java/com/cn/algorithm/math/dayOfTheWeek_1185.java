package com.cn.algorithm.math;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-01-03 22:24
 * @Description: TODO
 * @Project_name: java-learn
 */
public class dayOfTheWeek_1185 {

    /**
     * ����һ�����ڣ��������һ���㷨���ж����Ƕ�Ӧһ���е���һ�졣
     * ����Ϊ����������day��month ��year���ֱ��ʾ�ա��¡��ꡣ
     * �����صĽ���������⼸��ֵ�е�һ��
     * {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}��
     * ����������һ������ 1971 �� 2100 ��֮�����Ч���ڡ�
     */
    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31,8,2019));
    }

    /**
     * ģ����㣬1971 1.1�����ģ������ϴ�������������ʵ����֮�����������������Ҫ������㣩
     * ���+3����Ϊ��ʼ���������ģ����������죩�� %7 �͵õ����ˡ�
     * @param day
     * @param month
     * @param year
     * @return
     */
    public static String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        /* �������֮ǰ����ݵ��������� */
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        /* ��������У������·�֮ǰ���·ݵ��������� */
        for (int i = 0; i < month - 1; ++i) {
            days += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        /* �����·��е��������� */
        days += day;
        return week[(days + 3) % 7];
    }
}
