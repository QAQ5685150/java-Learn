package com.cn.JDKDemo.Swing;

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

    private Box exportInputBox;//�û����벿�ֵĺ��ӣ���Ҫ�������빦��,��ֱ����
    private Box exportBox;//�û������ӣ������������֣�һ��labelһ��TextFiled,ˮƽ����
    private Box buttonBox;//��ť����,ˮƽ����
    private JLabel exportLabel;//
    private JTextField exportInput;//�������������
    private JButton exportBtn;//���밴ť

    public UserExportPanel(String tittle)
    {
        //ʵ�������еĶ���
        setTitle(tittle);
        exportLabel =new JLabel("�����뵼������");
        exportInput =new JTextField();
        exportBtn =new JButton("����excel");

        exportInputBox =Box.createVerticalBox();//�ڲ��������ֱ����
        buttonBox=Box.createHorizontalBox();//�ڲ������ˮƽ����
        exportBox =Box.createHorizontalBox();//�ڲ������ˮƽ����

        //����������������ݼ����û�������
        exportBox.add(exportLabel);
        exportBox.add(Box.createHorizontalStrut(10));//�������label�ĺ�����
        exportBox.add(exportInput);

        //��������������С
        exportInputBox.add(Box.createHorizontalStrut(20));
        exportInputBox.add(Box.createVerticalStrut(30));

        //���������ڼ����û�����userInputBox����
        exportInputBox.add(exportBox);
        exportInputBox.add(Box.createVerticalStrut(10));//����֮��ļ��

        //����ť���뵽��ť����
        //�󶨵���¼�
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

        //������Ϊ�ղ���
        //���������������exportInputBox��buttonBox��λ��
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
        //�󶨰�ť�¼�����
    }

    private static String getFilePath() {
        JFileChooser jf = new JFileChooser();
        jf.setVisible(true);
        jf.setDialogTitle("��ѡ�񵼳�·��");
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
        failLabel.setText("���������ʽΪ��yyyyMMdd");
        failLabel.setBounds(20,20,50,50);
        setName("��ʾ");
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
        failLabel.setText("��������ȷ�����ڸ�ʽ");
        failLabel.setBounds(20,20,50,50);
        setName("��ʾ");
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
        exportLabel.setText("�����ɹ�");
        exportBtn.setText("ȷ��");
        setName("��ʾ");
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


