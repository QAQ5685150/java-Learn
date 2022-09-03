package com.cn.Algorithm.array;

/**
 * 类名: countQuadruplets_1995
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2021-12-29 18:00
 **/
public class countQuadruplets_1995 {

    /**
    *功能描述:给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
     *
     * nums[a] + nums[b] + nums[c] == nums[d] ，且
     * a < b < c < d
     *
     * 输入：nums = [1,2,3,6]
     * 输出：1
     * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
    **/
    public static void main(String[] args) {
        int[] test = new int[]{2,4,5,7,12,15,26};
        System.out.println(countQuadruplets(test));
        System.out.println(countQuadruplets1(test));
    }

    /**
    *功能描述:1995. 统计特殊四元组  数据量很小，直接遍历找所有。
     * 刚开始我用的set保存所有结果到里面找，想空间换时间减到0(N^3)，但这样不符合题目 a<b<c<d，set保存的是全局的答案，有可能造成找到的数是在前面
     * 也就是d < a或 d < b 这种情况
    *@param nums
    *@return int
    **/
    public static int countQuadruplets(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    int index = k + 1;
                    while(index < nums.length){
                        if(tmp == nums[index]){
                            ans++;
                        }
                        index++;
                    }
                }
            }
        }
        return ans;
    }

    /**
    *功能描述:哈希表解法，逆序遍历，散列到int[]下标取值，通过cnt[nums[a] + nums[b] + nums[c]]找是否有值存在
    *@param nums
    *@return int
    **/
    public static int countQuadruplets1(int[] nums) {
        int n = nums.length, ans = 0;
        int[] cnt = new int[10010];
        for (int c = n - 2; c >= 2; c--) {
            cnt[nums[c + 1]]++;
            for (int a = 0; a < n; a++) {
                for (int b = a + 1; b < c; b++) {
                    ans += cnt[nums[a] + nums[b] + nums[c]];
                }
            }
        }
        return ans;
    }





}
