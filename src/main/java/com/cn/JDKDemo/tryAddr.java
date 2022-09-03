package com.cn.JDKDemo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 类名:tryAddr
 * 描述:尝试搜索ip第四位 0~255 可以访问ip的8011端口的地址
 * 姓名:南风
 * 日期:2021-11-04 13:48
 **/
public class tryAddr {

    public static void main(String[] args) throws Exception {
        String ip = "http://172.168.30.1:";
        String line = "";
        InputStream content = null;
        try {
                try {
                    URL url = new URL(ip);
                    content = (InputStream) url.getContent();
                }catch (Exception e){
                   content = processIP(content,getNextIp(1),1);
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content));
                while ((line = bufferedReader.readLine()) != null) {
                    line += bufferedReader.readLine();
                    System.out.println(ip);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(line);
    }

    public static InputStream processIP(InputStream content, String ip, int i) throws Exception {
        if(i >= 253){
            return null;
        }
        try {
            URL url = new URL(ip);
            System.out.println("trying search ip：" + ip);
            content = (InputStream) url.getContent();
        }catch (Exception e){
            System.out.println("this ipAddr don't have result");
            return processIP(content,getNextIp(i),++i);
        }
        return null;
    }


    public static String getNextPort(String ip,Integer port){
        String newIp = "";
        port++;
        newIp = ip + port + "/";
        return newIp;
    }

    public static String getNextIp(Integer dType){
        String newIp = "";
        dType++;
        newIp = "http://172.168.30." + dType + ":8011/";
        return newIp;
    }
}
