package com.cn.JdkDemo.Swing;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.Swing
 * @Time: 2022-08-26 9:58
 * @Description: TODO
 **/
public class swingDemo {

    public static void main(String[] args)
    {
        //java Swingѧϰ
        //���ɴ���
        JFrame windows1=new UserExportPanel("����");
        Container container1=windows1.getContentPane();//���������ڵ��������
        container1.setBackground(Color.white);//���ñ�����ɫ
        windows1.setBounds(60,100,500,300);//����λ�ô�С
        windows1.setVisible(true);//����������
        windows1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ð�x��Ĳ���.[���ֻ�ǹر��Ǹ�����]

    }

}
