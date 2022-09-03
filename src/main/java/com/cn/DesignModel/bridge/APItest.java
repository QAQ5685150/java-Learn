package com.cn.DesignModel.bridge;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-03-21 10:38
 * @Description: TODO
 * @Project_name: java-learn
 */
public class APItest {


    public static void main(String[] args) {
        WeChatPay weChatPay =new WeChatPay(new FacePayMode());
        weChatPay.pay_way();
    }
}
