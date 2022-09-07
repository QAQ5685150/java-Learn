package com.cn.JdkDemo.date;

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
        calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置星期一为一周开始的第一天
        calendar.setMinimalDaysInFirstWeek(4);//可以不用设置
        calendar.setTimeInMillis(System.currentTimeMillis());//获得当前的时间戳
        int weekYear = calendar.get(Calendar.YEAR);//获得当前的年
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println(calendar.get(Calendar.DATE));
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);//获得当前日期属于今年的第几周

        System.out.println("第几周："+weekOfYear);
        System.out.println(weekYear);
        calendar.setWeekDate(weekYear, weekOfYear, 2);//获得指定年的第几周的开始日期

        long starttime = calendar.getTime().getTime();//创建日期的时间该周的第一天，
        calendar.setWeekDate(weekYear, weekOfYear, 1);//获得指定年的第几周的结束日期
        long endtime = calendar.getTime().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd");
        String dateStart = simpleDateFormat.format(starttime);//将时间戳格式化为指定格式
        String dateEnd = simpleDateFormat.format(endtime);
        System.out.println(dateStart);
        System.out.println(dateEnd);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setFirstDayOfWeek(Calendar.MONDAY);//设置星期一为一周开始的第一天
        calendar1.setMinimalDaysInFirstWeek(4);//可以不用设置
        calendar1.setTimeInMillis(System.currentTimeMillis());//获得当前的时间戳
        calendar1.setWeekDate(2022,34,7);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy年MM月dd");
        String format = simpleDateFormat1.format(calendar1.getTime());
        System.out.println(format);
    }
}
