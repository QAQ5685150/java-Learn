package com.cn.algorithm.dynamic;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-04-15 21:32
 * @Description: ��̬�滮 ��Ծ��Ϸϵ��
 * @Project_name: java-learn
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] test= new int[]{2,3,1,5,1,2,0,0,3,4};
        System.out.println(canJump1(test));

        int[] test2 = new int[]{2,3,0,1,4,3,3};
        System.out.println(canJump2(test2));
    }

    /**
     *��Ծ��Ϸ1
     * ����һ���Ǹ��������� nums �������λ������� ��һ���±� ��
     * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
     * �ж����Ƿ��ܹ��������һ���±ꡣ
     * @param nums
     * @return
     */
    public static boolean canJump1(int[] nums) {
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

    /**
     *��Ծ��Ϸ2
     * ����һ���Ǹ��������� nums �������λ������ĵ�һ��λ�á�
     * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
     * ���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�
     * ���������ǿ��Ե�����������һ��λ�á�
     * @param nums
     * @return
     */
    public static int canJump2(int[] nums) {
        int n = nums.length;
        int index = 0;
        int times = 0;
        for (int i = 0; i <= n - 1; i = index) {
            int max = 0;
            int rightmost = index + nums[i];
            while (i < n && i <= rightmost){
                i++;
                if(nums[i] >= max){
                    index = i;
                }
            }
            times++;
        }
        return times;
    }
    //�ٷ����
    public static int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int reach = 0;
        int nextreach = nums[0];
        int step = 0;
        for(int i = 0;i<nums.length;i++){
            nextreach = Math.max(i+nums[i],nextreach);
            if(nextreach >= nums.length-1) return (step+1);
            if(i == reach){
                step++;
                reach = nextreach;
            }
        }
        return step;
    }
}
