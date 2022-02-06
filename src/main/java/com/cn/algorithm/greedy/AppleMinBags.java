package com.cn.algorithm.greedy;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-02-05 22:36
 * @Description: 业务题 + 贪心策略
 * 先傻代码写出来正确的，然后打表找规律，用最快的方法（结果表达式）跑代码速度最快，刷题技巧
 * @Project_name: java-learn
 */
public class AppleMinBags {

    public static int minBags(int apple) {
        if (apple < 0) {
            return -1;
        }
        int bag6 = -1;
        int bag8 = apple / 8;
        int rest = apple - 8 * bag8;
        while (bag8 >= 0 && rest < 24) {
            int restUse6 = minBagBase6(rest);
            if (restUse6 != -1) {
                bag6 = restUse6;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }

    public static int minBagBase6(int rest) {
        return rest % 6 == 0 ? (rest / 6) : -1;
    }

    /**
     * 打表法做题，根据正确的代码打表总结数学规律写出表达式
     * @param apple
     * @return
     */
    public static int minBagAwesome(int apple) {
        if ((apple & 1) != 0) {
            return -1;
        }
        if (apple < 18) {
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1
                    : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        }
        return (apple - 18) / 8 + 3;
    }

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int testTime = 100000000;
        for (int test = 0; test < testTime; test++) {
            int apple = (int) (Math.random() * max);
            if (minBags(apple) != minBagAwesome(apple)) {
                System.out.println("error");
            }
        }

    }
}
