package com.cn.Algorithm.string;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.string
 * @Time: 2022-08-01 11:27
 * @Description: TODO
 **/
public class compareVersion_165_BM22 {
    public static void main(String[] args) {
        System.out.println(compare("2.1", "1.1"));
        }

    public static int compare (String version1, String version2) {
        // write code here
        String[] c1 = version1.split("\\.");
        String[] c2 = version2.split("\\.");
        int len = Math.min(c1.length,c2.length);
        for(int i = 0; i < len; i++){
            int i1 = Integer.valueOf(c1[i]);
            int i2 = Integer.valueOf(c2[i]);
            if(i1 > i2){
                return 1;
            }else if(i1 < i2){
                return -1;
            }
        }
        if(c1.length > c2.length)    return 1;
        else if(c1.length < c2.length)    return -1;
        return 0;
    }

    /**
     * 上午写了一版，没找明白关键问题
     * 问题是比较两边的版本号，有一个问题是两个版本号不一样如何比较
     * 上午我写的是，找到两个版本里最短长度，都一样说明前面相同，然后比较长度，长的就返回
     * 但是忽略了一个问题， “2.1.0” 和 “2.1”这样就不对了
     * 于是换了一种思路，找最长的比较，如果枚举的i超过其中一个长度，就置为0去和第二个比较
     * @param version1
     * @param version2
     * @return
     */
    public static int compare2 (String version1, String version2) {
        // write code here
        String[] c1 = version1.split("\\.");
        String[] c2 = version2.split("\\.");
        int len = Math.max(c1.length,c2.length);
        for(int i = 0; i < len; i++){
            int i1 = i >= c1.length ? 0 : Integer.valueOf(c1[i]);
            int i2 = i >= c2.length ? 0 : Integer.valueOf(c2[i]);
            if(i1 > i2){
                return 1;
            }else if(i1 < i2){
                return -1;
            }
        }
        return 0;
    }
}
