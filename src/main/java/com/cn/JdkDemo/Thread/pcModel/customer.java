package com.cn.JdkDemo.Thread.pcModel;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 类名:customer
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-16 15:25
 **/
public class customer implements Runnable{

    private BlockingQueue<pcData> queue;

    private static final int SLEEPTIME = 2000;
    public customer(BlockingQueue<pcData> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id :"+Thread.currentThread().getId());
        Random r = new Random();
        try{
            while(true){
                pcData data = queue.take();
                if(data != null)
                {
                    int re = data.getData() * data.getData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(),data.getData(),re));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }
}
