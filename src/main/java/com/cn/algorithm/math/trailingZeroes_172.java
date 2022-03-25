package com.cn.algorithm.math;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-25 10:21
 * @Description: TODO
 * @Project_name: java-learn
 */
public class trailingZeroes_172 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(15));
    }

    /**
     * 题解：
     *     首先题目的意思是末尾有几个0
     *     比如6! = 【1* 2* 3* 4* 5* 6】
     *     其中只有2*5末尾才有0，所以就可以抛去其他数据 专门看2 5 以及其倍数 毕竟 4 * 25末尾也是0
     *     比如10！ = 【2*4*5*6*8*10】
     *     其中 4能拆成2*2  10能拆成2*5
     *     所以10！ = 【2*（2*2）*5*（2*3）*（2*2*2）*（2*5）】
     *     一个2和一个5配对 就产生一个0 所以10！末尾2个0
     *
     *     转头一想 2肯定比5多 所以只数5的个数就行了
     *
     *     假若N=31 31里能凑10的5为[5, 2*5, 3*5, 4*5, 25, 6*5] 其中 25还能拆为 5**2
     *     所以 里面的5的个数为 int(31/(5**1)) +  int(31/(5**2))
     *     所以 只要先找个一个 5**x < n 的x的最大数 然后按上面循环加起来
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }


    // 傻瓜版  模拟运算统计尾数 int过20就超了 Long过不了100
    public static int trailingZeroes_test(int n) {
        Long ans = Long.valueOf(n);
        while(n > 1){
            ans *= (--n);
        }
        return getNum(ans);
    }

    public static int getNum(Long n){
        int ans = 0;
        while(n > 0){
            if(n % 10 == 0){
                ans++;
                n /= 10;
            }else{
                break;
            }
        }
        return ans;
    }
}
