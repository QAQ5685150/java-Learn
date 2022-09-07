package com.cn.HttpClient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 类名:HttpUrlConnectionDemo01
 * 描述:通过JDK网络类Java.net.HttpURLConnection  调用第三方网络接口demo
 * 姓名:南风
 * 日期:2021-10-29 11:08
 **/
public class HttpUrlConnectionDemo01  {

    private static String GET = "GET";
    private static String POST = "POST";

    public static void doGetOrPost(String method,String pathUrl, String data) throws IOException {
        OutputStreamWriter out = null;
        BufferedReader br = null;
        String result = "";
        try {
            URL url = new URL(pathUrl);
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //请求方式
            String setMethod = method.equals("POST") ? "POST" : "GET";
            conn.setRequestMethod(setMethod);

            //通用请求设置
            conn.setRequestProperty("accept","/");
            conn.setRequestProperty("connection","Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.81 Safari/537.36");
            conn.setRequestProperty("Content-Type","application/json;charset=utf-8");

            //DoOutput设置是否向httpUrlConnection输出，DoInput设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            conn.setDoOutput(true);
            conn.setDoInput(true);

            /**
             * 下面的三句代码，就是调用第三方http接口
             */
            //获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            //发送请求参数即数据
            out.write(data);
            //flush输出流的缓冲
            out.flush();

            InputStream inputStream = conn.getInputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));
            String str = "";
            while ((str = br.readLine()) != null){
                result += str;
            }
            System.out.println(result);
            inputStream.close();
            conn.disconnect();


        }catch (Exception exception){
            System.out.println(exception);
        }finally {
            if(out != null){
                out.close();
            }
            if(br != null){
                br.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        doGetOrPost(GET,
                "http://wthrcdn.etouch.cn/WeatherApi?citykey=101100301",
                "");
    }
}
