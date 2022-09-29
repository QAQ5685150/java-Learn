package com.cn.Algorithm.array.partition;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.array.partition
 * @Time: 2022-09-29 15:38
 * @Description: TODO
 **/
public class minEatingSpeed_875 {

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MAX_VALUE;

        while(l < r){
            int mid = l + ((r - l ) >> 1);
            if(check(piles,h,mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] arr, int h, int k){
        int times = 0;
        for(int i : arr){
            times += (i - 1) / k + 1;
        }
        return times <= h;
    }
}
