package com.dayu.pattern.proxy.custom;

import com.dayu.pattern.proxy.Person;
import com.dayu.pattern.proxy.Son;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-06-28 13:23
 */
public class CustomTest {
    public static void main(String[] args) {
        Person person   = (Person)new CustomProxy().getInstance(new Son());
        person.find();

    }
}