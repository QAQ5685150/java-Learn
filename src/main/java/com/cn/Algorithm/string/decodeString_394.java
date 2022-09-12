package com.cn.Algorithm.string;

import java.util.Stack;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.string
 * @Time: 2022-07-04 11:01
 **/
public class decodeString_394 {

    public static void main(String[] args) {
        String test1 = "3[a]2[bc]";
        String test2 = "3[a2[c]";
        System.out.println(decodeString_review(test1));
    }

    public static String decodeString(String s) {
        char[] chars = s.toCharArray();
        //字符串集合栈，保存多重[]上一重的值
        Stack<StringBuilder> ansSB = new Stack<>();
        //数字栈，保存’[‘前出现的数字 表示要解码多少次
        Stack<Integer> multi = new Stack<>();
        //结果字符串，会先从最内层开始算起一层一层往外扩，由栈先进后出的特性支撑
        StringBuilder sb = new StringBuilder();
        int mul = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(chars[i])){
                //有可能是多位倍数
                mul = mul * 10 + (chars[i] - '0');
            }else if(chars[i] == '['){
                //当有多层嵌套括号时，字符栈保存里层字符，再次遇到']'时会从里到外递归出多重括号的效果
                ansSB.push(sb);//从上往下会走这边，从下往上多次括号上一次的也会保存在栈里
                multi.push(mul);
                mul = 0;//遇到'['说明数字结束，清空
                sb = new StringBuilder();
            }else if(Character.isAlphabetic(chars[i])){
                sb.append(chars[i]);
            }else {
                StringBuilder ans = ansSB.pop();
                Integer pop = multi.pop();
                for (int j = 0; j < pop; j++) {
                    ans.append(sb);
                }
                sb = ans;//遇到']'后让里层等于ans括号内的倍数字符串，然后再遇到'['时字符栈就会保存到字符栈中，多重嵌套。
            }
        }
        return sb.toString();
    }


    public static String decodeString_review(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }else if(c == '['){
                numStack.push(num);
                num = 0;
                stringStack.push(sb);
                sb = new StringBuilder();
            }else if(Character.isAlphabetic(c)){
                sb.append(c);
            }else {
                StringBuilder tmpString = stringStack.pop();
                Integer tmpNum = numStack.pop();
                for (int i = 0; i < tmpNum; i++) {
                    tmpString.append(sb);
                }
                sb = tmpString;
            }
        }
        return sb.toString();
    }
}






