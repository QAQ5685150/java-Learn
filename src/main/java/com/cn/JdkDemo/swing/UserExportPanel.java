package com.cn.JdkDemo.swing;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.Swing
 * @Time: 2022-08-26 10:04
 * @Description: TODO
 **/
public class UserExportPanel extends JFrame {

    private Box exportInputBox;//用户输入部分的盒子，主要包含导入功能,垂直排列
    private Box exportBox;//用户名盒子，包含两个部分，一个label一个TextFiled,水平排列
    private Box buttonBox;//按钮盒子,水平排列
    private JLabel exportLabel;//
    private JTextField exportInput;//导入日期输入框
    private JButton exportBtn;//输入按钮

    public UserExportPanel(String tittle)
    {
        //实例化所有的对象
        setTitle(tittle);
        exportLabel =new JLabel("请输入导出日期");
        exportInput =new JTextField();
        exportBtn =new JButton("导出excel");

        exportInputBox =Box.createVerticalBox();//内部组件，垂直排列
        buttonBox=Box.createHorizontalBox();//内部组件，水平排列
        exportBox =Box.createHorizontalBox();//内部组件，水平排列

        //将导入日期相关内容加入用户名盒子
        exportBox.add(exportLabel);
        exportBox.add(Box.createHorizontalStrut(10));//输入框与label的横向间隔
        exportBox.add(exportInput);

        //导入日期输入框大小
        exportInputBox.add(Box.createHorizontalStrut(20));
        exportInputBox.add(Box.createVerticalStrut(30));

        //将导入日期加入用户输入userInputBox盒子
        exportInputBox.add(exportBox);
        exportInputBox.add(Box.createVerticalStrut(10));//两行之间的间距

        //将按钮加入到按钮盒子
        //绑定点击事件
        exportBtn.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = exportInput.getText();
                int statDay = 0;
                try {
                    statDay = Integer.parseInt(text);
                } catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                    new formatFail().setVisible(true);
                    return;
                }
                if (text.length() != 8){
                    new checkNumFail().setVisible(true);
                    return;
                }
                System.out.println(statDay);
                String filePath = getFilePath();
                if (filePath.equals("none")){
                    return;
                }

                exportExcel(statDay, filePath);

                new exportSuccess().setVisible(true);
            }

        });
        buttonBox.add(Box.createHorizontalStrut(50));
        buttonBox.add(exportBtn);

        //这个面板为空布局
        //设置这两个大盒子exportInputBox和buttonBox的位置
        setLayout(null);
        setBounds(50,50,200,100);

        add(exportInputBox);
        add(buttonBox);

        exportInputBox.setBounds(20,20,400,100);
        buttonBox.setBounds(20,160,280,100);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        validate();
    }


    private void exportExcel(int statDay, String filePath) throws FileNotFoundException {
        //绑定按钮事件方法
    }

    private static String getFilePath() {
        JFileChooser jf = new JFileChooser();
        jf.setVisible(true);
        jf.setDialogTitle("请选择导出路径");
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = jf.showOpenDialog(null);
        if (result == JFileChooser.CANCEL_OPTION) {
            return "none";
        } else {
            String path = jf.getSelectedFile().getAbsolutePath();
            return path;
        }
    }
}


class formatFail extends JFrame{
    private Box failBox;
    private JLabel failLabel;
    public formatFail(){
        failBox = Box.createVerticalBox();
        failLabel = new JLabel();
        failLabel.setText("日期输入格式为：yyyyMMdd");
        failLabel.setBounds(20,20,50,50);
        setName("提示");
        setBounds(50,50,260,180);
        failLabel.setBounds(50,50,30,30);

        failBox.add(failLabel);
        add(failBox);
        failBox.setBounds(50,50,80,10);
    }
}

class checkNumFail extends JFrame{
    private Box failBox;
    private JLabel failLabel;
    public checkNumFail(){
        failBox = Box.createVerticalBox();
        failLabel = new JLabel();
        failLabel.setText("请输入正确的日期格式");
        failLabel.setBounds(20,20,50,50);
        setName("提示");
        setBounds(50,50,260,180);
        failBox.add(failLabel);
        failLabel.setBounds(50,50,30,30);
        add(failBox);
        failBox.setBounds(50,50,80,10);
    }
}

class exportSuccess extends JFrame{
    private Box exportBox;
    private JLabel exportLabel;
    private JButton exportBtn;//?????
    public exportSuccess(){
        exportBox = Box.createVerticalBox();
        exportLabel = new JLabel();
        exportBtn = new JButton();
        exportLabel.setText("导出成功");
        exportBtn.setText("确定");
        setName("提示");
        setBounds(50,50,260,180);
        exportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        exportLabel.setBounds(20,20,50,50);
        exportBtn.setBounds(20,60,50,50);
        exportBox.add(exportLabel);
        exportBox.add(exportBtn);
        exportBox.setBounds(50,50,80,10);
        add(exportBox);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private void close(){dispose();}
}


