package com.cn.DesignModel.bridge;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-21 10:32
 * @Description: 设计模式之 桥接模式 顶级抽象借口
 * @Project_name: java-learn
 */
public abstract class Pay {

    private IpayModel ipayModel;

    public Pay(IpayModel ipayModel) {
        this.ipayModel = ipayModel;
    }

    public void pay(){
        ipayModel.pay();
    }
}
