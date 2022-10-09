package com.cn.Algorithm.string.kuohao;
import java.util.Stack;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.string.kuohao
 * @Time: 2022-10-09 13:38
 * @Description: TODO
 **/
public class scoreOfParentheses_856 {

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses_1("(((()))())"));
    }

    /**
     * ���η�
     * @param s
     * @return
     */
    public static int scoreOfParentheses_1(String s) {
        if(s.length() == 2){
            return 1;
        }
        int len = s.length();
        int n = 0;
        int deep = 0;
        for (int i = 0; i < len; i++) {
            deep += s.charAt(i) == '(' ? 1 : -1;
            if(deep == 0){
                n = i + 1;
                break;
            }
        }
        if(len == n){ //deep == 0 ���ҵ���ƽ�����������������ƽ�⣬����� (1,len-1)
            return 2 * scoreOfParentheses_1(s.substring(1,len - 1));
        }else { //���м���ǰ�ҵ���ƽ�⣬�ҵ��ֽ�����µݹ����
            return scoreOfParentheses_1(s.substring(0,n)) + scoreOfParentheses_1(s.substring(n));
        }
    }

// ((())())
// s:1 2 3 3 2 4
// i:      1 2 1
    public static int scoreOfParentheses_2(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        Stack<Integer> integers = new Stack<>();
        integers.push(0);
        for (int i = 0; i < len; i++) {
            char cur = chars[i];
            if(cur == '('){
                integers.push(0);
            }else {//A + (B * 2)��Ƕ��������� (��0ռλ�ں����pop()��Ϊ+�����
                Integer tmp = integers.pop();
                Integer top = integers.pop() + Math.max(2 * tmp, 1);
                integers.push(top);
            }
        }
        return integers.peek();
    }

    /**
     * ������ ��ȼ�����
     * @param s
     * @return
     */
    public static int scoreOfParentheses_3(String s) {
        int res = 0;
        int deep = 0;
        for (int i = 0; i <s.length(); i++) {
             deep += (s.charAt(i) == '(' ? 1 : -1);
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '('){
                res += (1 << deep);
            }
        }
        return res;
    }
}
