package com.dayu.pattern.observer.subject;

/**
 * @author qiankeqin
 * @Description: 观察者
 * @date 2019-07-05 13:08
 */
public class Observer {
    public void advice(Event event){
        System.out.println("===============触发事件，打印日志===============");

        System.out.println("收到消息："+event.getSource());
    }
}