package com.cn.designModel.bridge;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-21 10:34
 * @Description: TODO
 * @Project_name: java-learn
 */
public class PhonePayModel implements IpayModel{
    @Override
    public void pay() {
        System.out.println("使用手机支付！");
    }
}
