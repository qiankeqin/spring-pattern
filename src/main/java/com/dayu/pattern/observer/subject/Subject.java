package com.dayu.pattern.observer.subject;

/**
 * @author qiankeqin
 * @Description: 目标
 * @date 2019-07-04 20:12
 */
public class Subject extends EventListner{

    //这里一般使用动态代理实现监控，避免代码潜入

    public void add(){
        System.out.println("add");
        //触发提醒
        trigger(SubjectEventType.ON_ADD);
    }

    public void remove(){
        System.out.println("remove");
        //触发提醒
        trigger(SubjectEventType.ON_REMOVE);

    }
}