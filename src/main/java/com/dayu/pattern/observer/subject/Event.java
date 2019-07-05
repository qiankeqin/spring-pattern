package com.dayu.pattern.observer.subject;

import java.lang.reflect.Method;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-05 13:09
 */
public class Event {
    private Object source;//事件源

    private Object target;//通知目标

    private Method callback;//回调

    private Long time;

    //触发
    private String trigger;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callback=" + callback +
                ", trigger='" + trigger + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}