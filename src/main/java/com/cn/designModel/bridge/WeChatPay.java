package com.cn.designModel.bridge;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-03-21 10:36
 * @Description: TODO
 * @Project_name: java-learn
 */
public class WeChatPay extends Pay{

    public WeChatPay(IpayModel ipayModel) {
        super(ipayModel);
    }

    public void pay_way(){
        System.out.println("ʹ��΢��֧����");
        pay();
    }
}
