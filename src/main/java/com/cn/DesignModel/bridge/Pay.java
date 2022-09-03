package com.cn.DesignModel.bridge;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-03-21 10:32
 * @Description: ���ģʽ֮ �Ž�ģʽ ����������
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
