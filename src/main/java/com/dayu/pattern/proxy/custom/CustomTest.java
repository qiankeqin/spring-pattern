package com.dayu.pattern.proxy.custom;

import com.dayu.pattern.proxy.Person;
import com.dayu.pattern.proxy.Son;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-06-28 13:23
 */
public class CustomTest {
    public static void main(String[] args) {
        Person person   = null;
        try {
            person = (Person)new CustomProxy().getInstance(new Son());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        person.find();

    }
}