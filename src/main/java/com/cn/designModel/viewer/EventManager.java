package com.cn.designModel.viewer;

import java.util.*;

/**
 * @class: EventManager
 * @description: TODO
 * @author: 南风
 * @date: 2021-12-08 10:44
 **/
public class EventManager {

    enum type{
        MQ,
        info
    }

    private Map<String, List<EventListener>> listener = new HashMap<>();

    public EventManager (Enum<type>... type){
        for (Enum<EventManager.type> typeEnum : type) {
            listener.put(typeEnum.name(),new ArrayList<>());
        }
    }

    protected void subscribe(String name, EventListener eventListener){
        List<EventListener> eventListeners = listener.get(name);
        eventListeners.add(eventListener);
    }

    protected void unSubscribe(String name, EventListener eventListener){
        List<EventListener> eventListeners = listener.get(name);
        eventListeners.remove(eventListener);
    }

    /**
    *功能描述:通知所有注册的事件
    *@return void
    **/
    public void notifyAllRegister(){
        Set<Map.Entry<String, List<EventListener>>> entries = listener.entrySet();
        Iterator<Map.Entry<String, List<EventListener>>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, List<EventListener>> next = iterator.next();
            List<EventListener> value = next.getValue();
            value.forEach(a -> a.doEvent());
        }
    }

    /**
    *功能描述:通知单个事件下所有监听器
    *@paramevent Type
    *@return void
    **/
    public void notify(Enum<type> eventType) {
        List<EventListener> users = listener.get(String.valueOf(eventType));
        for (EventListener listener : users) {
            listener.doEvent();
        }
    }
}
