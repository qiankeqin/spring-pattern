package com.dayu.pattern.proxy;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-06-27 09:08
 */
public class MMtest {
    public static void main(String[] args) {
//        Son son = (Son) new MM().getInstance(new Son("zhejiang"));
        Person person = (Person) new MM().getInstance(new Son());
        person.find();

    }
}