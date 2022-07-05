package com.cn.algorithm.string;

import java.util.Stack;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.string
 * @Time: 2022-07-04 11:01
 **/
public class decodeString_394 {

    public static void main(String[] args) {
        String test1 = "3[a]2[bc]";
        String test2 = "3[a2[c]]";
        System.out.println(decodeString(test2));
    }

    public static String decodeString(String s) {
        char[] chars = s.toCharArray();
        //�ַ�������ջ���������[]��һ�ص�ֵ
        Stack<StringBuilder> ansSB = new Stack<>();
        //����ջ�����桯[��ǰ���ֵ����� ��ʾҪ������ٴ�
        Stack<Integer> multi = new Stack<>();
        //����ַ��������ȴ����ڲ㿪ʼ����һ��һ������������ջ�Ƚ����������֧��
        StringBuilder sb = new StringBuilder();
        int mul = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(chars[i])){
                //�п����Ƕ�λ����
                mul = mul * 10 + (chars[i] - '0');
            }else if(chars[i] == '['){
                //���ж��Ƕ������ʱ���ַ�ջ��������ַ����ٴ�����']'ʱ����ﵽ��ݹ���������ŵ�Ч��
                ansSB.push(sb);
                multi.push(mul);
                mul = 0;//����'['˵�����ֽ��������
                sb = new StringBuilder();
            }else if(Character.isAlphabetic(chars[i])){
                sb.append(chars[i]);
            }else {
                StringBuilder ans = ansSB.pop();
                Integer pop = multi.pop();
                for (int j = 0; j < pop; j++) {
                    ans.append(sb);
                }
                sb = ans;//����']'����������ans�����ڵı����ַ�����Ȼ��������'['ʱ�ַ�ջ�ͻᱣ�浽�ַ�ջ�У�����Ƕ�ס�
            }
        }
        return sb.toString();
    }
}






