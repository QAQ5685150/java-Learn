package com.cn.Algorithm.array.partition;

import java.util.Arrays;

/**
 * 类名: numFriendRequests_825
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2021-12-27 17:13
 **/
public class numFriendRequests_825 {

    public static void main(String[] args) {
        int[] test = new int[]{12,13,14,15,16,17,18};
        //System.out.println(numFriendRequests(test));
        //System.out.println(numFriendRequests1(test));
        System.out.println(numFriendRequests2(test));
    }

    /**
    *功能描述: 排序 + 二分 TODO
    *@param ages
    *@return int
    **/
    public static int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int len = ages.length - 1;
        int ans = 0;

        for (int i = len; i > 0 ; i--) {
            int num = getNum(ages, i);
            ans += i - num;
        }
        return ans;
    }

    public static int getNum(int[] ages, int right){
        int l = 0;
        int r = right;
        while (l < r){
            int mid = l + (r - l) >> 1;
            if(ages[mid] <= (int) (ages[right] * 0.5 + 7)){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return r;
    }

    /**
    *功能描述:二分 + 排序 找左右边界再加到ans
     * 对双重循环第二个循环用二分的优化，在一个大范围上找左右边界用二分的思想降低时间复杂度
    *@param ages
    *@return int
    **/
    public int numFriendRequests5(int[] ages) {
        int ans=0;
        Arrays.sort(ages);
        for(int i=0;i<ages.length;i++){
            if(ages[i]<=14||ages[0]>ages[i]||2*ages[ages.length-1]<=ages[i]+14){continue;}
            //先找右边界
            int l1=0,r1=ages.length-1;
            while(l1<r1){
                int mid=(l1+r1)>>1;
                if(ages[mid]<=ages[i]){l1=mid;}
                else{r1=mid-1;}
                if(l1==r1-1){
                    if(ages[r1]<=ages[i]){l1=r1;}
                    break;
                }
            }
            //再找左边界
            int l2=0,r2=ages.length-1;
            while(l2<r2){
                int mid=(l2+r2)>>1;
                if(2*ages[mid]>ages[i]+14){r2=mid;}
                else{l2=mid+1;}
            }
            ans+=l1-r2;
        }
        return ans;
    }

    /** 20 30 100 110 120
    *功能描述: 排序 + 前缀和
    *@param ages
    *@return int
    **/
    public static int numFriendRequests1(int[] ages){
        Arrays.sort(ages);
        int[] arr = new int[121];
        for (int age : ages) {
            arr[age]++;
        }
        for (int i = 1; i < 120; i++) {
            arr[i] += arr[i - 1];
        }
        int ans = 0;
        for (int i = 15; i < 120; i++) {
            ans += arr[i] * (arr[(int) (i * 0.5) + 7] - 1);
        }
        return ans;
    }

    public static int numFriendRequests2(int[] ages) {
        int[] cnt = new int[121];
        for (int age : ages) {
            ++cnt[age];//计数数组
        }
        int[] pre = new int[121];
        for (int i = 1; i <= 120; ++i) {
            pre[i] = pre[i - 1] + cnt[i];
        }
        int ans = 0;
        for (int i = 15; i <= 120; ++i) {
            //存在的用户才会计数
            if (cnt[i] > 0) {
                //找到符合条件的范围(用数组下标表示年龄，在条件中表示符合ages[y] <= 0.5 * ages[x] + 7的用户)
                int bound = (int) (i * 0.5 + 8);
                //pre[i] - pre[bound - 1]用前缀和表示这一个范围内有多少用户
                ans += cnt[i] * (pre[i] - pre[bound - 1]);
            }
        }
        return ans;
    }
}
