package com.cn.Algorithm.array.partition;

/**
 * 类名:chalkReplacer_1894
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-10 17:58
 **/
public class chalkReplacer_1894 {

    /**
     * 一个班级里有n个学生，编号为 0到 n - 1。每个学生会依次回答问题，编号为 0的学生先回答，然后是编号为 1的学生，
     * 以此类推，直到编号为 n - 1的学生，然后老师会重复这个过程，重新从编号为 0的学生开始回答问题。
     * 给你一个长度为 n且下标从 0开始的整数数组chalk和一个整数k。一开始粉笔盒里总共有k支粉笔。
     * 当编号为i的学生回答问题时，他会消耗 chalk[i]支粉笔。如果剩余粉笔数量 严格小于chalk[i]，那么学生 i需要 补充粉笔。
     *
     * 请你返回需要 补充粉笔的学生 编号。
    **/
    public static void main(String[] args) {
        int[] test = new int[]{3,4,1,2};
        int k = 1;
        System.out.println(chalkReplacer_review(test, k));
    }

    /**
    *功能描述: my ans
    *@returnint
    **/
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

    /**
    *功能描述:前缀 + 二分
    *@paramc halk
    *@param k
    *@return int
     * 根据题意，每个学生消耗的粉笔为定值，所有粉笔最终会像老师的教导一样孜孜不倦地循环投入在所有的学生身上。
     *
     * 因此我们可以预处理出前缀和数组 sum，将 k 对所有学生一次循环所消耗总粉笔数（sum[n]）进行取模，
     * 得到最后一轮开始前的粉笔数量。
     *
     * 然后对前缀和数组进行二分，找到最后一位满足粉笔要求的学生，其往后一位的同学编号即是答案。
    **/
    public static int chalkReplacer1(int[] chalk, int k) {
        int n = chalk.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + chalk[i - 1];
        k = (int)(k % sum[n]);
        int l = 1, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (sum[mid] <= k) l = mid;
            else r = mid - 1;
        }

        return sum[r] <= k ? r : r - 1;
    }


    public static int chalkReplacer_review(int[] chalk, int k) {
        int len = chalk.length;
        int[] sum = new int[len];
        for (int i = 0; i < len; i++) {
            sum[i] = i == 0 ? chalk[0] : sum[i - 1] + chalk[i];
            if(sum[i] > k) return i;
        }
        int cur = k % sum[sum.length - 1];
        return binarySearch(sum,cur);
    }

    public static int binarySearch(int[] arr, int k){
        int l = 0;
        int r = arr.length - 1;
        while (l < r){
            int mid = l + ((r - l) >> 1);
            if(arr[mid] > k){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }


}
