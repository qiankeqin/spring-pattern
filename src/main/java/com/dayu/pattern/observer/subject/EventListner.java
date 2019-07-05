package com.dayu.pattern.observer.subject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-05 13:18
 */
public class EventListner {

    protected Map<Enum,Event> eventMap = new HashMap<>();

    public void addListner(Enum eventType, Object target, Method callback){
        //注册事件
        //用反射调用
        eventMap.put(eventType,new Event(target,callback));
    }

    private void trigger(Event e){
        e.setSource(this);
        e.setTime(System.currentTimeMillis());

        try {
            Object invoke = e.getCallback().invoke(e.getTarget(), e);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }

    }


    protected void trigger(Enum call){
        if(this.eventMap.containsKey(call)){
            this.trigger(this.eventMap.get(call).setTrigger(call.toString()));
        }
    }
}