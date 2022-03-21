package com.cn.designModel.bridge;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-21 10:33
 * @Description: TODO
 * @Project_name: java-learn
 */
public class FacePayMode implements IpayModel{
    @Override
    public void pay() {
        System.out.println("使用刷脸支付！");
    }
}
