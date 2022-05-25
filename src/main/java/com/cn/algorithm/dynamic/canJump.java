package com.cn.algorithm.dynamic;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-04-15 21:32
 * @Description: TODO
 * @Project_name: java-learn
 */
public class canJump {

    public static void main(String[] args) {
        int[] test= new int[]{2,3,1,5,1,2,0,0,3,4};
        canJump(test);
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;//ά��һ����Զ�������ľ��룬���������������鳤�ȣ�˵�������������û����������ΪҪ���õ����һ��λ�ã�
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
