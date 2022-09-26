package com.cn.DesignModel.viewerReview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.DesignModel.viewerReview
 * @Time: 2022-09-26 16:49
 * @Description: TODO
 **/
public class EventManager {

    enum types{
        LISTENER1,
        LISTENER2
    }

    public static HashMap<String, List<EventListener>> listenerHashMap = new HashMap<>();

    public void register(Enum<types> ... type){
        for (Enum<types> typesEnum : type) {
            listenerHashMap.put(typesEnum.toString(),new ArrayList<>());
        }
    }

    public boolean subscribe(Enum<types> type, EventListener eventListener){
        return listenerHashMap.get(type.toString()).add(eventListener);
    }

    public void note(){
        listenerHashMap.forEach( (k,v) -> {

        });
    }

}
