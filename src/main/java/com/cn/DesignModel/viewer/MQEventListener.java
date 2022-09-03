package com.cn.DesignModel.viewer;

/**
 * @class: MQEventListener
 * @description: TODO
 * @author: 南风
 * @date: 2021-12-08 10:39
 **/
public class MQEventListener implements EventListener{

    @Override
    public void doEvent() {
        System.out.println("MQEventListener send message");

    }
}
