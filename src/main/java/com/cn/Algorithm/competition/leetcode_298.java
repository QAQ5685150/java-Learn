package com.cn.Algorithm.competition;

/**
 * @Auther: @С�Ը����ɰ�
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
        ֱ�ӿ��ܵĴ�n
        1.��k��β���������Ա�ʾΪb=a*10+k(a>=0)
        2.��n��k�ĺ�Ϊ:��b=��ai*10+n*k=num --> ��ai*10 = num - n*k >= 0 && (num - n*k) % 10 == 0
        ��С����ö�ٿ��ܵ�n�Ĵ�,������һ�����ʵķ��ؼ���,��ΧΪ[1,num] ��û�з��������ķ���-1
         */
        if (num == 0) return 0; // numΪ0�������������
        // num >= k�����:������Ҫһ��
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
                if(s.length()-i > 32) break;  // �жϳ���int����
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
        ����DP->ľ������֮����һ������������ľ��:
        1.״̬����:f[i][j]��ʾ�и�� i �� j ľ�������������Ǯ?
        2.״̬ת��:Ҫ��f[i][j]��Ҫ�������ļ��ַָ��?
            2.1 ֱ�Ӳ��������� pr[i][j]
            2.2 ������ f[i][j]=max(f[k][j]+f[i-k][j]) k��[1,i-1]
            2.3 ������ f[i][j]=max(f[i][k]+f[i][j-k]) k��[1,j-1]
            ��������һ����ʵ�ܺö�:����һ��� i �� j ��ľͷ
            ��ô�ɸ�С��ľͷ���?ֻ�����ַ�ʽ:����ƴ�Ӻ�����ƴ��
            ��Ϊʲô��ͬʱ����ƴ��������ƴ��?��Ϊû��Ҫ!��Ϊi��j�ı�����Ϊ����
            ��i��jС�ĵ�ľͷ����������Ǯ��ʵ�Ѿ�����
            ����Ҫ�ָ��4��,������ָ��4��ͷָ��2������������ʵ��һ����
            ��˹������ת��;����3��:��������,��������,����ֱ����!
        3.��ʼ��:���Խ�����f[i][j]��ʼ��Ϊֱ�����ļ�Ǯ
        4.����˳��:i��[1,m];j��[1,n];k��[1,i-1]�Լ�[1,j-1]
        5.������ʽ:����f[m][n]�ʹ����m �� n��ľͷ�����и���������Ǯ
         */
        // ����Ǯװ�����
        int[][] pr = new int[m + 1][n + 1];
        for (int[] p : prices) pr[p[0]][p[1]] = p[2];
        long[][] f = new long[m + 1][n + 1];
        // ö��ÿ���߿��ľͷ
        for (int i = 1; i <= m; i++) {  // i��[1,m]
            for (int j = 1; j <= n; j++) {  // j��[1,n]
                f[i][j] = pr[i][j]; // ����ֱ������������Ǯ(������Ǯ��Ϊ0)
                for (int k = 1; k <= i - 1; k++) {  // ������
                    f[i][j] = Math.max(f[i][j], f[k][j] + f[i - k][j]);
                }
                for (int k = 1; k <= j - 1; k++) {  // ������
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[i][j - k]);
                }
            }
        }
        return f[m][n];
    }
}
