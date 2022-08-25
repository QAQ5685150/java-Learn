package com.cn.jdkTest.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.date
 * @Time: 2022-08-24 16:55
 * @Description: TODO
 **/
public class calanderDemo {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);//��������һΪһ�ܿ�ʼ�ĵ�һ��
        calendar.setMinimalDaysInFirstWeek(4);//���Բ�������
        calendar.setTimeInMillis(System.currentTimeMillis());//��õ�ǰ��ʱ���
        int weekYear = calendar.get(Calendar.YEAR);//��õ�ǰ����
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println(calendar.get(Calendar.DATE));
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);//��õ�ǰ�������ڽ���ĵڼ���

        System.out.println("�ڼ��ܣ�"+weekOfYear);
        System.out.println(weekYear);
        calendar.setWeekDate(weekYear, weekOfYear, 2);//���ָ����ĵڼ��ܵĿ�ʼ����

        long starttime = calendar.getTime().getTime();//�������ڵ�ʱ����ܵĵ�һ�죬
        calendar.setWeekDate(weekYear, weekOfYear, 1);//���ָ����ĵڼ��ܵĽ�������
        long endtime = calendar.getTime().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd");
        String dateStart = simpleDateFormat.format(starttime);//��ʱ�����ʽ��Ϊָ����ʽ
        String dateEnd = simpleDateFormat.format(endtime);
        System.out.println(dateStart);
        System.out.println(dateEnd);



        Calendar calendar1 = Calendar.getInstance();
        calendar1.setFirstDayOfWeek(Calendar.MONDAY);//��������һΪһ�ܿ�ʼ�ĵ�һ��
        calendar1.setMinimalDaysInFirstWeek(4);//���Բ�������
        calendar1.setTimeInMillis(System.currentTimeMillis());//��õ�ǰ��ʱ���
        calendar1.setWeekDate(2022,34,7);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy��MM��dd");
        String format = simpleDateFormat1.format(calendar1.getTime());
        System.out.println(format);
    }
}
