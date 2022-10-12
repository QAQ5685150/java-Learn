package com.cn.DesignModel.viewer.viewerReview;

/**
 * @Author: Linxx
 * @Package: com.cn.DesignModel.viewer.viewerReview
 * @Time: 2022-09-27 9:45
 * @Description: TODO
 **/
public class EventServer {

    private static EventManager eventManager;

    public static void main(String[] args) {
        eventManager = new EventManager();
        for (types value : types.values()) {
            eventManager.register(value);
        }

        eventManager.subscribe(types.LISTENER1,new listener1());
        eventManager.subscribe(types.LISTENER1,new listener11());
        eventManager.subscribe(types.LISTENER2,new listener2());

        eventManager.notifyListener(types.LISTENER1);
        eventManager.notifyListener(types.LISTENER2);
    }
}
