package com.cn.DesignModel.bridge;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-03-21 10:37
 * @Description: TODO
 * @Project_name: java-learn
 */
public class ZhiFuBaoPay extends Pay{


    public ZhiFuBaoPay(IpayModel ipayModel) {
        super(ipayModel);
    }

    public void pay_way(){
        System.out.println("ʹ��֧����֧����");
        pay();
    }
}