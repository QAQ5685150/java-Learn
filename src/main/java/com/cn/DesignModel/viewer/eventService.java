package com.cn.DesignModel.viewer;

/**
 * @class: eventService
 * @description: TODO
 * @author: 南风
 * @date: 2021-12-08 10:56
 **/
public class eventService {

    private EventManager eventManager;

    /**
    *功能描述:注册所有枚举类型到监听器中
    *@return
    **/
    public eventService(){
        eventManager = new EventManager(EventManager.type.MQ,EventManager.type.info);
        eventManager.subscribe(String.valueOf(EventManager.type.MQ),new MQEventListener());
        eventManager.subscribe(String.valueOf(EventManager.type.info),new infoEventListener());
    }

    public void doNotify(){
        eventManager.notifyAllRegister();
    }

    public void doNotify(Enum<EventManager.type> typeEnum){
        eventManager.notify(typeEnum);
    }

    public static void main(String[] args) {
        eventService es = new eventService();
        es.doNotify();
        System.out.println("===========");
        es.doNotify(EventManager.type.MQ);
    }
}
