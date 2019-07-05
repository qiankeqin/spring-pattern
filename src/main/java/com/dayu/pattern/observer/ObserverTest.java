package com.dayu.pattern.observer;

import com.dayu.pattern.observer.subject.Event;
import com.dayu.pattern.observer.subject.Observer;
import com.dayu.pattern.observer.subject.Subject;
import com.dayu.pattern.observer.subject.SubjectEventType;

import java.lang.reflect.Method;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-05 09:18
 */
public class ObserverTest {
    public static void main(String[] args) {
        try{
            //观察者
            Observer observer = new Observer();

            //注册事件
            Subject subject = new Subject();
            Method advice = Observer.class.getMethod("advice", new Class<?>[]{Event.class});
            subject.addListner(SubjectEventType.ON_ADD,observer,advice);
            subject.addListner(SubjectEventType.ON_REMOVE,observer,advice);
            subject.addListner(SubjectEventType.ON_S,observer,advice);
            subject.addListner(SubjectEventType.ON_UPDATE,observer,advice);

            subject.add();
            subject.remove();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}