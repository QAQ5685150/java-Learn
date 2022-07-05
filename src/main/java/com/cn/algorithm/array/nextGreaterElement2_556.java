package com.cn.algorithm.array;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.array
 * @Time: 2022-07-04 15:54
 **/
public class nextGreaterElement2_556 {

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(21));
    }

    //1 2 4 7 5 3 2 4
    public static int nextGreaterElement(int n) {
        String string = getString(n);
        char[] chars = string.toCharArray();
        int i = 0;
        int j = chars.length;
        while (i < chars.length - 1){
            if((chars[i] - '0') > (chars[i + 1] - '0')){
                break;
            }
            i++;
        }
        while (j > i){
            if((chars[j - 1]) > (chars[j])){
                break;
            }
            j--;
        }
        if(i == chars.length) {
            return -1;
        }
        swap(chars,i++,j);


        StringBuilder s = new StringBuilder(new String(chars));
        s.reverse();
        Integer res = Integer.valueOf(s.toString());
        return  res > n ? res : 0;
    }

    public static void swap(char[] chars,int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
    public static String getString(int n){
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            int i = n % 10;
            n /= 10;
            sb.append(i);
        }
        return sb.reverse().toString();
    }

    /**
     * 官方题解  来自重排字符串的31. 下一个排列
     * @param n
     * @return
     */
        public static int nextGreaterElement2(int n) {
            char[] nums = Integer.toString(n).toCharArray();
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i < 0) {
                return -1;
            }

            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap2(nums, i, j);
            reverse2(nums, i + 1);
            long ans = Long.parseLong(new String(nums));
            return ans > Integer.MAX_VALUE ? -1 : (int) ans;
        }

        public static void reverse2(char[] nums, int begin) {
            int i = begin, j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        public static void swap2(char[] nums, int i, int j) {
            char temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


}





