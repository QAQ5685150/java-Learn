package com.cn.Algorithm.string;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-01-09 21:30
 * @Description: TODO
 * @Project_name: java-learn
 */
public class slowestKey_1629 {

    public static void main(String[] args) {
        int[] test = new int[]{19,22,28,29,66,81,93,97};
        String t = "fnfaaxha";
        System.out.println(slowestKey(test,t));
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] chars = keysPressed.toCharArray();
        int[] arr = new int[27];
        int[] tmp = new int[releaseTimes.length];
        int ans = 0;
        int max = 0;
        for (int i = releaseTimes.length - 1; i > 0; i--) {
            tmp[i] = releaseTimes[i] - releaseTimes[i - 1];
        }
        tmp[0] = releaseTimes[0];
        for (int i = 0; i < tmp.length; i++) {
            arr[chars[i] - 'a'] = Math.max(tmp[i],arr[chars[i] - 'a']);
        }

        for (int i = arr.length - 1; i >= 0 ; i--) {
            if(arr[i] > max){
                max = arr[i];
                ans = i;
            }
        }
        char c = (char) (ans + 'a');
        return c;
    }
}
