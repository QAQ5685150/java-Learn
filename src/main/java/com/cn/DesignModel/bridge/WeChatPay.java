package com.cn.DesignModel.bridge;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-21 10:36
 * @Description: TODO
 * @Project_name: java-learn
 */
public class WeChatPay extends Pay{

    public WeChatPay(IpayModel ipayModel) {
        super(ipayModel);
    }

    public void pay_way(){
        System.out.println("使用微信支付！");
        pay();
    }
}
