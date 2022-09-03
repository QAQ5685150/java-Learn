package com.cn.Algorithm.competition;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-06-19 16:47
 * @Description: TODO
 * @Project_name: java-learn
 */
public class leetcode_298 {


    public static void main(String[] args) {
        //System.out.println(greatestLetter("lEeTcOdE"));
        System.out.println(longestSubsequence2("1001010",5));
        int[][] arr = new int[][]{{1,4,2},{2,2,7},{2,1,3}};
        System.out.println(sellingWood(3,5,arr));
    }

    /**
     *
     * @param s
     * @return
     */
    public static String greatestLetter(String s) {
        int[] upper = new int[26];
        int[] lower = new int[26];
        String res = "";
        for (char c : s.toCharArray()) {
            if(c - 'a' >= 0){
                lower[c - 'a']++;
            }else {
                upper[c - 'A']++;
            }
        }
        for (int j = upper.length - 1; j >= 0; j--) {
            if(upper[j] >= 1 && lower[j] >= 1){
                res = (char)('A'+j) + "";
                break;
            }
        }
        return res;
    }

    /**
     *
     * @param num
     * @param k
     * @return
     */
    public static int minimumNumbers(int num, int k) {
        /*
        直接可能的答案n
        1.以k结尾的正数可以表示为b=a*10+k(a>=0)
        2.则n个k的和为:∑b=∑ai*10+n*k=num --> ∑ai*10 = num - n*k >= 0 && (num - n*k) % 10 == 0
        从小到大枚举可能的n的答案,遇到第一个合适的返回即可,范围为[1,num] 若没有符合条件的返回-1
         */
        if (num == 0) return 0; // num为0的情况单独讨论
        // num >= k的情况:至少需要一个
        for (int i = 1; i <= num; i++) {
            int t = num - i * k;
            if (t >= 0 && t % 10 == 0) return i;
        }
        return -1;
    }

    /**
     *
     * @param s
     * @param k
     * @return
     */
    public static int longestSubsequence(String s, int k) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if(chars[i] - '0' == 1){
                sum += Math.pow(2,chars.length - 1 - i);
            }
        }
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] - '0' == 1 && sum > k){
                ans += 1;
                sum -= Math.pow(2,chars.length - 1 - i);
            }
        }
        return chars.length - ans;
    }

    public static int longestSubsequence2(String s, int k) {
        int zeros = 0;
        for(char c: s.toCharArray()){
            if(c=='0') zeros++;
        }
        int ones = 0;
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i)=='1'){
                if(s.length()-i > 32) break;  // 判断超出int上限
                if(Long.parseLong(s.substring(i),2) > k){
                    break;
                }
                ones++;
            }
        }
        return zeros + ones;
    }

    public static long sellingWood(int m, int n, int[][] prices) {
        /*
        线性DP->木块劈完之后还是一个方方正正的木块:
        1.状态定义:f[i][j]表示切割高 i 长 j 木块最多能卖多少钱?
        2.状态转移:要求f[i][j]就要看看有哪几种分割方法?
            2.1 直接不劈整块卖 pr[i][j]
            2.2 横着劈 f[i][j]=max(f[k][j]+f[i-k][j]) k∈[1,i-1]
            2.3 竖着劈 f[i][j]=max(f[i][k]+f[i][j-k]) k∈[1,j-1]
            反过来想一下其实很好懂:对于一块高 i 宽 j 的木头
            怎么由更小的木头组成?只有两种方式:横着拼接和竖着拼接
            那为什么不同时横着拼接与竖着拼接?因为没必要!因为i与j的遍历均为正序
            比i与j小的的木头能卖的最大价钱其实已经有了
            不需要分割成4块,就算你分割成4块和分割成2块计算出来的其实是一样的
            因此归根到底转移途径就3条:横着切卖,竖着切卖,不切直接卖!
        3.初始化:可以将所有f[i][j]初始化为直接卖的价钱
        4.遍历顺序:i∈[1,m];j∈[1,n];k∈[1,i-1]以及[1,j-1]
        5.返回形式:返回f[m][n]就代表高m 宽 n的木头经过切割能卖多少钱
         */
        // 将价钱装入矩阵
        int[][] pr = new int[m + 1][n + 1];
        for (int[] p : prices) pr[p[0]][p[1]] = p[2];
        long[][] f = new long[m + 1][n + 1];
        // 枚举每个高宽的木头
        for (int i = 1; i <= m; i++) {  // i∈[1,m]
            for (int j = 1; j <= n; j++) {  // j∈[1,n]
                f[i][j] = pr[i][j]; // 不切直接卖能卖多少钱(不能卖钱的为0)
                for (int k = 1; k <= i - 1; k++) {  // 横着切
                    f[i][j] = Math.max(f[i][j], f[k][j] + f[i - k][j]);
                }
                for (int k = 1; k <= j - 1; k++) {  // 竖着切
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[i][j - k]);
                }
            }
        }
        return f[m][n];
    }
}
