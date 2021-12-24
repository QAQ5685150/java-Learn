package com.cn.ThinkingJava.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * 类名:wordcount
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-10 17:07
 **/
public class wordcount {

    public static void main(String[] args) {
        fread("C:\\Users\\DELL\\Desktop\\word.txt");
    }
    // 读取文件：
    public static void fread(String fileurl) {
        File file = new File(fileurl);
        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader(new FileReader(file));
            String tem = null;
            String value = "";
            while ((tem = bfr.readLine()) != null) {
                value = value + tem;
            }
            String[] split = value.split(" ");
            TreeMap<String, Integer> tm1 = new TreeMap<String, Integer>(Collections.reverseOrder());// TreeMap可排序（传入一个反转比较器）


            for (String s : split) {
                if(tm1.containsKey(s)){
                    tm1.put(s,tm1.get(s) + 1);
                }else {
                    tm1.put(s,1);
                }
            }

            Iterator<Map.Entry<String, Integer>> iterator = tm1.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Integer> next = iterator.next();
                String key = next.getKey();
                Integer value1 = next.getValue();
                System.out.println(key + "---出现了： " + value1 + " 次");
            }


            System.out.println(value);
            // 将读取的字符串转换成字符数组：
//            char[] c = value.toCharArray();
//            // 定义一个map来存储结果：
//            // HashMap<Character,Integer> tm = new
//            // HashMap<Character,Integer>(Collections.reverseOrder());
//            TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>(Collections.reverseOrder());// TreeMap可排序（传入一个反转比较器）
//
//            for (int i = 0; i < c.length; i++) {
//                char charSrc = c[i];
//                if (tm.containsKey(charSrc)) { // 判断该键的值是否存在
//                    int count = tm.get(charSrc);
//                    tm.put(charSrc, count + 1);
//                } else {
//                    tm.put(charSrc, 1);
//                }
//            }
//
//            // 取出Map中的键和值
//            Iterator<Map.Entry<Character, Integer>> titer = tm.entrySet().iterator();
//            while (titer.hasNext()) {
//                Map.Entry<Character, Integer> map = titer.next();
//                char key = map.getKey();
//                int valu = map.getValue();
//                System.out.println(key + "出现过" + valu + "次!");
//            }

        } catch (Exception e) {
            System.err.println("文件读取错误");
        } finally {
            try {
                if (bfr != null) {
                    bfr.close();
                }
            } catch (Exception e2) {
                System.err.println("文件关闭错误");
            }
        }

    }
}
