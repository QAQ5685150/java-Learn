package com.cn.DesignModel.bridge;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-21 10:37
 * @Description: TODO
 * @Project_name: java-learn
 */
public class ZhiFuBaoPay extends Pay{


    public ZhiFuBaoPay(IpayModel ipayModel) {
        super(ipayModel);
    }

    public void pay_way(){
        System.out.println("使用支付宝支付！");
        pay();
    }
}
