package com.cn.algorithm.competition;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.competition
 * @Time: 2022-07-18 13:15
 * @Description: TODO
 **/
public class leetcode_302 {

    public static void main(String[] args) {
//        for (int i : numberOfPairs(new int[]{18,43,36,13,7})) {
//            System.out.print(i + " ");
//        }

//        System.out.println(maximumSum2(new int[]{18,43,36,13,7}));

//        String[] s = new String[]{"24","37","96","04"};
//        int[][] query = new int[][]{{2,1},{2,2}};
//        for (int i : smallestTrimmedNumbers(s, query)) {
//            System.out.print(i + " ");
//        }

        //String: a.compareTo(b)方法：a > b return 1 \ a < b return -1
        System.out.println("20".compareTo("10"));
    }

    public static int[] numberOfPairs(int[] nums) {
        int opt = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if(nums[i] == nums[j] && nums[i] != -1 && nums[j] != -1){
                    opt++;
                    nums[i] = nums[j] = -1;
                    break;
                }
            }
            if(nums[i] != -1) left++;
        }
        return new int[]{opt,left};
    }


    // 数组双指针，O（n^2） 71/82 超时
    public int maximumSum(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            sum[i] = process(nums[i]);
        }
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if(sum[i] == sum[j]){
                    int tmp = nums[i] + nums[j];
                    max = Math.max(max,tmp);
                }
            }
        }
        return max == 0 ? -1 : max;
    }

    //hashMap 优化 空间换时间 O（n）
    public static int maximumSum2(int[] nums) {
        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < len; i++) {
            int cur = process(nums[i]);
            if(map.get(cur) != null && nums[map.get(cur)] < nums[i]){
                map.put(cur,i);
            }
            if(map.get(cur) == null) map.put(cur,i);
        }
        for (int i = 0; i < len; i++) {
            int process = process(nums[i]);
            if(map.get(process) != null && map.get(process) != i){
                int tmp = nums[i] + nums[map.get(process)];
                max = Math.max(max, tmp);
            }
        }
        return max == 0 ? -1 : max;
    }

    public static int process(int n){
        int sum = 0;
        while (n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }


    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        HashMap<Integer,long[]> map = new HashMap<>();
        for (int[] query : queries) {
            if(map.get(query[1]) == null){
                cutNum(map,nums,query[1]);
            }
        }
        int[] arr = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            long[] cur = map.get(query[1]);
            arr[index++] = getIndex(cur,query[0] - 1);
        }
        return arr;
    }

    public static void cutNum(HashMap<Integer,long[]> map, String[] nums, int k){
        int len = nums.length;
        long[] cur = new long[len];
        for (int i = 0; i < nums.length; i++) {
            cur[i] = Long.valueOf(nums[i].substring(nums[i].length() - k,nums[i].length()));
        }
        map.put(k,cur);
    }

    public static int getIndex(long[] nums, int k){
        long[][] arr = new long[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int) (o1[0] - o2[0]);
            }
        });
        return (int)arr[k][1];
    }

    //别人的题解 排序
    public int[] smallestTrimmedNumbers2(String[] nums, int[][] queries) {
        int nn = nums.length;
        int m = nums[0].length();
        int qn = queries.length;

        Integer [] idxs = new Integer[nn];
        for (int i = 0; i < nn; i ++)
        {
            idxs[i] = i;
        }

        int [] res = new int[qn];

        String [] tmp = new String[nn];
        for (int qi = 0; qi < qn; qi ++)
        {
            int k = queries[qi][0],    rLen = queries[qi][1];
            for (int i = 0; i < nn; i ++)
            {
                String num = nums[i];
                String x = num.substring(m - rLen, m);
                tmp[i] = x;
            }
            Arrays.sort(idxs, new Comparator<Integer>(){
                @Override
                public int compare(Integer i, Integer j)
                {
                    if (tmp[i].equals(tmp[j]) == false)
                    {
                        return tmp[i].compareTo(tmp[j]);
                    }
                    else
                    {
                        return i - j;
                    }
                }
            } );
            res[qi] = idxs[k - 1];
        }
        return res;
    }
}
