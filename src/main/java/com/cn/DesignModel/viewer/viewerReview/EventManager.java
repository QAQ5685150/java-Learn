package com.cn.DesignModel.viewer.viewerReview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.DesignModel.viewer.viewerReview
 * @Time: 2022-09-26 16:49
 * @Description: TODO
 **/

enum types{
    LISTENER1,
    LISTENER2
}

public class EventManager {

    public static HashMap<String, List<EventListener>> listenerHashMap = new HashMap<>();

    public void register(Enum<types> ... type){
        for (Enum<types> typesEnum : type) {
            listenerHashMap.put(typesEnum.toString(),new ArrayList<>());
        }
    }

    public boolean subscribe(Enum<types> type, EventListener eventListener){
        return listenerHashMap.get(type.toString()).add(eventListener);
    }

    public List<EventListener> describe(Enum<types> type){
        return listenerHashMap.remove(type.toString());
    }

    public void notifyListener(Enum<types> type){
        listenerHashMap.forEach( (k,v) -> {
            if(k.equals(type.toString())){
                for (EventListener eventListener : v) {
                    eventListener.doEvent();
                }
            }
        });
    }

    public void notifyAllListener(Enum<types> ... types){
        for (Enum<types> type : types) {
            listenerHashMap.forEach( (k,v) -> {
                if(k.equals(type.toString())){
                    for (EventListener eventListener : v) {
                        eventListener.doEvent();
                    }
                }
            });
        }
    }


}
