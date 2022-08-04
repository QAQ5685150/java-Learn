package com.cn.algorithm.string;

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
     * ����д��һ�棬û�����׹ؼ�����
     * �����ǱȽ����ߵİ汾�ţ���һ�������������汾�Ų�һ����αȽ�
     * ������д���ǣ��ҵ������汾����̳��ȣ���һ��˵��ǰ����ͬ��Ȼ��Ƚϳ��ȣ����ľͷ���
     * ���Ǻ�����һ�����⣬ ��2.1.0�� �� ��2.1�������Ͳ�����
     * ���ǻ���һ��˼·������ıȽϣ����ö�ٵ�i��������һ�����ȣ�����Ϊ0ȥ�͵ڶ����Ƚ�
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
