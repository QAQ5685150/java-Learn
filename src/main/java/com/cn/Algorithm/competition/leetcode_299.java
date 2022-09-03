package com.cn.Algorithm.competition;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.competition
 * @Time: 2022-07-07 15:02
 **/
public class leetcode_299 {

    public static void main(String[] args) {
        //int[][] test = new int[][]{{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};
        //System.out.println(checkXMatrix(test));

        System.out.println(countHousePlacements(3));

//        int[] i1 = new int[]{20,40,20,70,30};
//        int[] i2 = new int[]{50,20,50,40,20};
//        System.out.println(maximumsSplicedArray(i1, i2));
    }

    public static boolean checkXMatrix(int[][] grid) {
        int col = grid.length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col; j++) {
                //找到位置依赖关系，变量会跟随循环变更
                if(i == j ||col - i == j + 1){
                    if(grid[i][j] == 0){
                        return false;
                    }
                }else {
                    if(grid[i][j] != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static int MOD = (int)1e9 + 7;

    public static int countHousePlacements(int n) {
        if(n == 1) return 4;
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 2;
        for(int i = 2;i <= n;i++){
            f[i] = ((f[i - 1]) + (f[i - 2])) % MOD;
        }
        return (f[n] * f[n]) % MOD;
    }

    static int max = 0;
    static int tmp = 0;
    static int index = 0;
    public static int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n1 = 0;
        int n2 = 0;
        process(nums1,nums2);
        for (int i = 0; i < nums1.length; i++) {
            if (i >= index - max && i <= index){
                n1 += nums2[i];
                n2 += nums1[i];
            }
            n1 += nums1[i];
            n2 += nums2[i];
        }
        return Math.max(n1,n2);
    }

    public static int process(int[] nums1, int[] nums2){
        for (int i = 0; i < nums1.length; i++) {
            tmp = nums1[i] > nums2[i] ? tmp++ : 0;
            if(tmp > max){
                max = Math.max(max,tmp);
                index = i;
            }
        }
        return index - max;
    }

}
