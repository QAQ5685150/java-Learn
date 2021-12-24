package com.cn.algorithm;

/**
 * 类名:chalkReplacer_1894
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-10 17:58
 **/
public class chalkReplacer_1894 {

    public static void main(String[] args) {
        int[] test = new int[]{5,1,5};
        int k = 22;
        System.out.println(chalkReplacer(test, k));

    }

    public static int chalkReplacer(int[] chalk, int k) {
        int len = chalk.length;
        int[] prefix = new int[len];
        prefix[0] = chalk[0];
        for(int i = 1; i < len; i++){
            prefix[i] = prefix[i-1] + chalk[i];
        }
        int ans = 0;

        if(get(prefix,k)!=0){
            ans = get(prefix,k);
        }else {
            while (get(prefix,k) == 0 && k >= 0){
                k -= prefix[prefix.length - 1];
                ans = get(prefix, k);
            }
        }
        return ans;
    }

    public static int get(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if(num >= arr[i]){
                return i;
            }
        }
        return 0;
    }
}
