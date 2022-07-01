package com.cn.algorithm.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.dynamic
 * @Time: 2022-07-01 14:27
 **/
public class diffWaysToCompute_241 {

    public static void main(String[] args) {
        for (Integer integer : diffWaysToCompute3("2*3-4*5")) {
            System.out.print(integer + " ");
        }
    }

    /**
     * nice try……
     * 递归的思路，想到每次计算表达式的（i,i+3）位置再把这个个位置放回原来的字符串，调用递归函数处理
     * 循环的表达式没想好，怎么用递归分层级的思路没想出来……
     * @param expression
     * @return
     */
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < expression.length() - 3; i += 2) {
            StringBuilder sb = new StringBuilder();
            StringBuilder append = sb.append(expression.substring(0,i)).append(calculate(expression.substring(i, i + 3))).append(expression.substring(i + 3, expression.length()));
            process(append.toString(),res);
        }
        return res;
    }

    public static void process(String s, List<Integer> list){
        if(s.length() <= 3){
            list.add(calculate(s));
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder append = sb.append(calculate(s.substring(0, 3))).append(s.substring(3, s.length()));
        process(append.toString(),list);
    }

    public static int calculate(String s){
        String[] split = s.split("");
        Integer i1 = Integer.valueOf(split[0]);
        Integer i2 = Integer.valueOf(split[2]);
        int res = 0;
        if(split[1].equals("+")){
            res += (i1 + i2);
        }else if(split[1].equals("-")){
            res += (i1 - i2);
        }else if(split[1].equals("*")){
            res += (i1 * i2);
        }
        return res;
    }


    /**
     * 递归 和我差不多的思路
     * @param expression
     * @return
     */
    public static List<Integer> diffWaysToCompute3(String expression) {
        //表达式为空
        if (expression == null || expression.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = expression.toCharArray();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            //如果当前字符是操作符，也就是op，进行分割
            if (!Character.isDigit(aChar)) {
                //递归拿到左右两个表达式的结果集
                List<Integer> leftList = diffWaysToCompute3(expression.substring(0, i));
                List<Integer> rightList = diffWaysToCompute3(expression.substring(i + 1));
                //对两个结果集的所有结果进行op运算
                for (Integer left : leftList) {
                    for (Integer right : rightList) {
                        if (aChar == '+') {
                            ans.add(left + right);
                        } else if (aChar == '-') {
                            ans.add(left - right);
                        } else {
                            ans.add(left * right);
                        }
                    }
                }
            }
        }
        //结果集是空，证明该字符串是数字，将数字加入结果集
        if (ans.isEmpty()) {
            ans.add(Integer.valueOf(expression));
        }
        return ans;
    }

    /**
     * 回溯 不一样的思路
     * @param expression
     * @return
     */
    public static List<Integer> diffWaysToCompute2(String expression) {
        List<Character> symbols = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        int number = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (isSymbol(c)) {
                numbers.add(number);
                symbols.add(c);
                number = 0;
            } else {
                number = number * 10 + c - '0';
            }
        }
        numbers.add(number);
        List<Integer> ans = new ArrayList<>();
        recursive(symbols, numbers, ans, 0);
        return ans;
    }

    private static void recursive(List<Character> symbols, List<Integer> numbers, List<Integer> ans, int x) {
        if (symbols.size() == 0) {
            ans.add(numbers.get(0));
            return;
        }
        for (int i = 0; i < symbols.size(); i++) {
            if (i < x) {
                continue;
            }
            int a = numbers.get(i);
            int b = numbers.get(i + 1);
            char symbol = symbols.get(i);
            int compute = compute(a, b, symbol);
            // update
            numbers.remove(i + 1);
            numbers.set(i, compute);
            symbols.remove(i);
            recursive(symbols, numbers, ans, i - 1);
            // recover
            numbers.set(i, a);
            numbers.add(i + 1, b);
            symbols.add(i, symbol);
        }
    }

    private static int compute(int a, int b, char symbol) {
        switch (symbol) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static boolean isSymbol(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}
