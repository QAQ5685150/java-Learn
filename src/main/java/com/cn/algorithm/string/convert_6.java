package com.cn.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-06-26 10:11
 * @Description: TODO
 * @Project_name: java-learn
 */
public class convert_6 {

    public static void main(String[] args) {
        String test = "PAYPALISHIRING";
        System.out.println(convert(test, 3));
    }


    public static String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int index = 0;
        int i = 0;
        int flag = 0;
        while (index < s.length()){
            i += flag;
            list.get(i).append(s.charAt(index));
            if(i == numRows - 1){
                flag = -1;
            }else if(i == 0){
                flag = 1;
            }
            index++;
        }
        String ans = "";
        for (StringBuilder stringBuilder : list) {
            ans += stringBuilder.toString();
        }
        return ans;
    }

    public static String covert2(String s, int numRows){
        if(numRows < 2){
            return s;
        }
        List<StringBuffer> res = new ArrayList<>();
        for(int i = 0;i < numRows ; i++){
            res.add(new StringBuffer());
        }
        int i = 0;
        int flag = -1;
        //控制位移这块 如何优化的思路要注意
        for(char c : s.toCharArray()){
            res.get(i).append(c);
            if(i == numRows - 1 || i == 0){
                flag = -flag;
            }
            i += flag;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (StringBuffer sb : res){
            stringBuffer.append(sb);
        }
        return stringBuffer.toString();
    }
}
