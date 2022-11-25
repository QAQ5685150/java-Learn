package com.cn.JdkDemo.blockQueue.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.blockQueue.delay
 * @Time: 2022-11-25 11:24
 * @Description: TODO
 **/
public class order implements Delayed {

    /**
     * ÑÓ³ÙÊ±¼ä
     */
    private long time;
    String name;
    public order(String name, long time, TimeUnit unit) {
        this.name = name;
        this.time = System.currentTimeMillis() + (time > 0 ? unit.toMillis(time) : 0);
    }
    @Override
    public long getDelay(TimeUnit unit) {
        return time - System.currentTimeMillis();
    }
    @Override
    public int compareTo(Delayed o) {
        order order = (order) o;
        long diff = this.time - order.time;
        if (diff <= 0) {
            return -1;
        } else {
            return 1;
        }
    }

}
