package com.cn.Algorithm.math;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-01-03 22:24
 * @Description: TODO
 * @Project_name: java-learn
 */
public class dayOfTheWeek_1185 {

    /**
     * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
     * 输入为三个整数：day、month 和year，分别表示日、月、年。
     * 您返回的结果必须是这几个值中的一个
     * {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
     * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
     */
    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31,8,2019));
    }

    /**
     * 模拟计算，1971 1.1是周四，在算上从输入天数到其实天数之间的所有天数（闰年要特殊计算）
     * 结果+3（因为起始那天是周四，往后推三天）再 %7 就得到答案了。
     * @param day
     * @param month
     * @param year
     * @return
     */
    public static String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        /* 输入年份之前的年份的天数贡献 */
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        /* 输入年份中，输入月份之前的月份的天数贡献 */
        for (int i = 0; i < month - 1; ++i) {
            days += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        /* 输入月份中的天数贡献 */
        days += day;
        return week[(days + 3) % 7];
    }
}
