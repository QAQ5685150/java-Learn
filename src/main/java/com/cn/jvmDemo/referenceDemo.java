package com.cn.jvmDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-03-08 15:08
 * @Description: ֵ���������ô���demo
 * @Project_name: java-learn
 */
public class referenceDemo {


    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("a","1");
        List<HashMap> list = new ArrayList<>();
        list.add(map);
        map = null;//����ֵMap����list���ٰ�ԭmap��Ϊ�գ�list�ڵ�ֵ���䡣˵��list������������ֵ�ĸ���
        HashMap map1 = list.get(0);
        System.out.println(map1.get("a"));

        int a = 1;
        add(a);
        System.out.println("�ӿڵ������������ݵ�ֵΪ��" + a);//���÷��� �����β� �ٴ�ӡԭֵ��ֵ����û�з����仯

    }

    public static void add(int tmp){
        tmp++;
        System.out.println("���ýӿڸı䴫���ֵ�����ǣ�" + tmp);
    }


}
