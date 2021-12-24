package com.cn.ThinkingJava.enumDemo.enumByInterface;

/**
 * 类名:Food
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-07-30 15:24
 **/
public interface Food {
    enum chuan_cai implements Food{
        yu_xiang_rou_si,
        gong_bao_ji_ding,
        chong_qing_xiao_mian
    }

    enum xiang_cai implements Food{
        xiang_cai1,
        xiang_cai2

    }

    enum yue_cai implements Food{
        cao_cha,
        guang_xi_ren

    }
}

class TypeOfFood{
    public static void main(String[] args) {
        Food.chuan_cai food = Food.chuan_cai.yu_xiang_rou_si;
    }
}
