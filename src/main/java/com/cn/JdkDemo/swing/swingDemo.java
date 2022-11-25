package com.cn.JdkDemo.swing;

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
        //java Swing学习
        //生成窗口
        JFrame windows1=new UserExportPanel("导入");
        Container container1=windows1.getContentPane();//获得这个窗口的内容面板
        container1.setBackground(Color.white);//设置背景颜色
        windows1.setBounds(60,100,500,300);//设置位置大小
        windows1.setVisible(true);//可视性设置
        windows1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置按x后的操作.[这个只是关闭那个窗口]

    }

}
